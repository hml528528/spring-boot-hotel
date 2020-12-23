// components/album/album.js
Component({
  
  data: {
      //定义全局的图片的根路径
      basePath:"http://118.190.104.39:3000/",
      //定义分页需要的参数
      params:{
        //跳过几条数据
        skip:0,
        //一页请求几条数据
        limit:12
      },
       //定义图片的总记录数，默认为0
       total:0,
       albumData:[]
  },
  methods: {
      //获取远程热门模块数据
      getAlbumData(){
        wx.request({
          url: 'http://118.190.104.39:3000/album/',
          data:this.data.params,
          success:(res)=>{
            //获取远程专辑模块数据
           var data= res.data.data
           //更新数据到全局data中
           this.setData({
             //es6新特性，自动拼接获取的图片
              albumData:[...this.data.albumData,...data.list],
              //获取服务器图片的总记录数，并更新全局记录
              total:data.total
           })
          }
        })
      },
      //滚动触底事件，进行分页
      scrolltolower(){
        //判断跳过的记录数是否大于总记录数，如果大于，则终止程序
        //加载完成给相应的提示信息
           if(this.data.params.skip>=this.data.total){
             wx.showToast({
               title: '图片已经加载完成~~~',
               icon: 'none',
               duration: 2000
             })
             return
           }
          //获取分页的参数
          var params=this.data.params
          //获取分页要跳过的条数
          //每当触发触底事件，条数自动增加12
          params.skip+=12
          //更新数据到全局变量中
          this.setData({
           params:params
          })
          //当触发触底事件，再次请求hot服务器请求数据
          this.getAlbumData()
      },
      //点击事件，实现页面的跳转，并传递数据
      click(e){
        //获取当前点击事件的索引
        var index =e.currentTarget.dataset.index
        //获取当前点击索引的数据
        var data=this.data.albumData[index]
        //获取全局对象app
        var app=getApp()
        //把当前点击索引的数据存入全局对象中
        app.data=data
        //js实现页面的跳转
        wx.navigateTo({
          url: '/pages/albumDetail/albumDetail'
        })
    }
      },
      
  lifetimes: {
    // 在组件实例进入页面节点树时执行
  attached: function() {
     //调用getCategroyData()加载数据
     this.getAlbumData()
   
  }
}
})
