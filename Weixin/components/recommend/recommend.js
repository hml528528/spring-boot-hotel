// components/recommend/recommend.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    //定义本地数据
      localData:[],
    //定义远程服务器的根路径
       basePath:"http://118.190.104.39:3000/",
    // 定义本地时间
        date:0,
        title:"",
     // 定义一个列表，用于封装远程的数据
         list:[],
      //本地热门数据
         hotData:[],
      //定义一个全局的分页参数
         params:{
            // skip 跳过几条数据
            skip:0,
            // limit 一页请求几条数据
            limit:12
         },
      //定义图片的总记录数，默认为0
         total:0

  },

  /**
   * 组件的方法列表
   */
  methods: {
       //定义一个获取远程数据的方法
       getData(){
        wx.request({
          //要请求数据的服务地址
          url: 'http://118.190.104.39:3000/home/cover', 
          //请求成功，则执行相应的方法
          //用箭头函数替代指针指向不明问题
          success:(res)=>{
            //获取服务器数据
            var remoteData=res.data.data
            //更新数据到全局data中
            this.setData({
                localData:remoteData
            })
          }
          // success (res) {
          //   //获取服务器数据
          //   remoteData=res.data.data
          //   //更新数据到全局data中
          //   //this指针指向当前对象（wx），更新全局数据失败
          //   this.setData({
          //       localData:remoteData
          //   })
          // }
        })
       },
       // 定义一个获取远程时间戳,标题，图片列表的方法
       getList(){
        wx.request({
          //要请求数据的服务地址
          url: 'http://118.190.104.39:3000/home/month', 
          //请求成功，则执行相应的方法
          //用箭头函数替代指针指向不明问题
          success:(res)=>{
            //获取服务器的数据
            var data=res.data.data
            //获取时间戳
            var date=data.date
            //格式化时间戳
            var formatDate=new Date(date)
            //获取日期对象的月份
            var month=formatDate.getMonth()+1
            //获取日期对象的的天
            var day=formatDate.getDate()
            //将格式化的时间进行拼接
            var Time=day +"/"+month+"月"
            //用对象点语法添加属性
            data.Time=Time
            //更新数据到全局data中
            this.setData({
               date:data.Time,
               title:data.title,
               list:data.list
            })
           
          }
        })
       },
       //获取远程热门模块数据
       getHotData(){
         wx.request({
           url: 'http://118.190.104.39:3000/home/hot/',
           data:this.data.params,
           success:(res)=>{
             //获取远程热门模块数据
            var data= res.data.data
            //更新数据到全局data中
            this.setData({
              //es6新特性，自动拼接获取的图片
               hotData:[...this.data.hotData,...data.list],
               //获取服务器图片的总记录数，并更新全局记录
               total:data.total
            })
           }
         })
       },
       //滚动触底事件，进行分页
       crolltolower(){
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
           this.getHotData()
       }
       },
  lifetimes: {
    attached: function() {
      // 在组件实例进入页面节点树时执行
      // 调用 获取远程数据的方法
      this.getData()
      // 调用 获取远程时间戳的方法
      this.getList()
      // 调用 获取远程热门模块的数据方法
      this.getHotData()
    }
  }
  })
