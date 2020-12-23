Page({
  data: {
     //定义跳转页面携带的数据
     data:[],
     //定义远程服务器的根路径
     basePath:"http://118.190.104.39:3000/",
     //定义请求的参数集合
      params:{
        skip:0,
        limit:12
      },
      //接收专辑详情图片列表数据
      list:[],
      //数据的总条数
      total:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
     //获取点击事件跳转带过来的数据
     //获取app对象
     var app=getApp()
     //获取数据
     var data=app.data
     //更新数据到全局data中
     this.setData({
       data:data
     })
     this.getList()
    },
     //定义获取专辑详情页数据的方法
  getList(){
    //显示加载中
     wx.showLoading({
       title: '小主请稍后'
     })
    wx.request({
      //1. 要拼接上个页面传递过来的album对象里的id属性；
      url: 'http://118.190.104.39:3000/album/'+this.data.data.id,
      //2. 拼接skip limit请求参数
      data: this.data.params,
      success:(res)=>{
        //console.log(res.data.data.list)
        this.setData({
          //使用es6展开运算符合并数据
          list:[...this.data.list,...res.data.data.list],
          total:res.data.data.total
        })
        //隐藏加载中
        wx.hideLoading()
      }
    })
 },
 //使用页面监听用户上拉触底事件，实现分页功能
 onReachBottom(){
   //先在事件体内打印一句话，测试事件是否可以正常运行；
   //console.log(1111)
   //判断是否还有更多数据
   if( this.data.params.skip >= this.data.total ){
     //提醒用户没有更多了
     wx.showToast({
       title: '我是有底线的',
       icon:'none'
     })
     //终止程序
      return
   }
   //开始实现我们的分页功能
   //1. 拿到全局的请求参数，并且修改skip参数；
   var params = this.data.params
   params.skip += 12
   //2. 把修改的参数更新到data里
   this.setData({
     params:params
   })
   //3. 回到数据请求方法里，对list数据进行合并
   //4. 重新发起数据请求
   this.getList()
 }
})