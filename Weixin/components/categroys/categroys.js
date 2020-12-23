Component({
  /**
   * 组件的初始数据
   */
  data: {
    //定义全局数据变量
    list:[],
    //定义全局图片的根路径
    basePath:"http://118.190.104.39:3000/"
  },

  /**
   * 组件的方法列表
   */
  methods: {
    //获取远程服务器的分类模块的数据
    getCategroyData(){
      wx.request({
        url:'http://118.190.104.39:3000/category',
        success:(res)=>{
          //获取数据
          var list=res.data.data
         //更新数据到全局data中
         this.setData({
           list:list
         })
        }
      })
    }

  },
  lifetimes: {
      // 在组件实例进入页面节点树时执行
    attached: function() {
       //调用getCategroyData()加载数据
       this.getCategroyData()
     
    }
  }
})
