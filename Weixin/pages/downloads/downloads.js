// pages/downloads/downloads.js
Page({

  data: {
     url:""
  },
  onLoad: function (options) {
      //获取上个页面图片的路径
     var url=options.src
     //更新图片路径到全局变量url
     this.setData({
       url:url
     })
  },
  //点击按钮执行下载
   downloadPic(){
    wx.downloadFile({
      url:this.data.url , //仅为示例，并非真实的资源
      success(res){
         //获取临时下载图片路径
        var tempFile=res.tempFilePath
        wx.saveImageToPhotosAlbum({
          filePath:tempFile,
          success(res) { 
            console.log("下载成功")
          }
        })
      }
    })
   
   }
})