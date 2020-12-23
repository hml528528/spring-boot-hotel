Page({
     /**
   * 页面的初始数据
   */
  data: {
    titles:[
      {
        id:1,
        text:"推荐"
      },
      {
        id:2,
        text:"分类"
      },
      {
        id:3,
        text: "最新"
      },
      {
        id:4,
        text:"专辑"
      }
    ],
    index:0
},
/**
 * 自定义父组件实践，用于接收子组件传来的参数
 */
getIndex(e){
    //获取子组件传递的参数
    var data=e.detail
    //更新索引
    this.setData({
     index:data
    })
}
})
