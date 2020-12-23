// pages/categroyDetail/categroyDetail.js
Page({
  data: {
    titles:[
      {
        id:1,
        text:"最热",
        order:"hot"
      },
      {
        id:2,
        text:"最新",
        order:"new"
      }
    ],
      //获取点击页面传递的id
      id:"",
      //定义全局的图片的根路径
      basePath:"http://118.190.104.39:3000/",
      //定义分页需要的参数
      params:{
        //跳过几条数据
        skip:0,
        //一页请求几条数据
        limit:12,
        //关键字 “hot” 或者 “new”
        order:"hot"
      },
      //定义图片列表
        list:[],
      //图片的总记录数
        total:0
  },
  onLoad: function (options) {
     //获取点击页面传递的id
     var id=options.id
     //更新id到全局变量data中
     this.setData({
      id:id
     })
     //调用获取图片列表的详细信息的方法
     this.getDetail()
  },
  //获取图片列表的详细信息
  getDetail(){
      wx.request({
        url: 'http://118.190.104.39:3000/category/'+this.data.id,
        data:this.data.params,
        success:(res)=>{
          //获取图片列表
          var list=res.data.data.list
          //更新数据到data中
          this.setData({
             //es6新特性，自动拼接获取的图片
             list:[...this.data.list,...list],
             //获取服务器图片的总记录数，并更新全局记录
             total:res.data.data.total
          })
        }
      })
  },
  //触发触底事件，进行分页
   scrolltolower(){
     //判断跳过的记录数是否大于总记录数，如果大于，则终止程序
         //加载完成给相应的提示信息
         if(this.data.params.skip>=this.data.total){
          
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
       this.getDetail()
  },
  //获取子组件传递的index
  getIndex(e){
    //获取点击事件的索引
      var index=e.detail
      //获取页面切换的关键字
      var order=this.data.titles[index].order
      //替换全局变量的关键字参数值
      var params=this.data.params
      params.order=order
      //清空跳过的记录数
      params.skip=0
      //更新全局params
      this.setData({
        params:params,
        //清空全局list
        list:[]
      })
      //重新调用getDetail()加载数据
      this.getDetail()
  }

  
})