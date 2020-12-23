// components/tabs/tabs.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
     tabs:{
       //父组件传递的数组参数类型
       type:Array,
       //不传值时默认为空数组
       value:[]
     }
  },

  /**
   * 组件的初始数据
   */
  data: {
     //定义当前对象的索引
     currentIndex:0
  },

  /**
   * 组件的方法列表
   */
  methods: {
    //定义一个点击事件，获取当前对象索引的值
      click(e){
          //获取当前点击对象的索引
          var index=e.currentTarget.dataset.index;
          //子组件向父组件传递参数
          //sendIndex:子组件自定义的事件名
          //index:传递参数
          this.triggerEvent("sendIndex",index)
          //更新当前对象的索引
          this.setData({
            currentIndex:index
          })

      }
  }
})
