<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>

<!DOCTYPE html >
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/static/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	
	$("#name").focus(function(){
		$(this).css("background-color","#0FF")
		var text=$(this).val();
		if(text=="请填写姓名"){
			$(this).val("");
			}
		});
		
		$("#name").blur(function(){
		$(this).css("background-color","#FFF")
		var text=$(this).val();
		if(text==""){
			$(this).val("请填写姓名");
			}
		});

	
});

function checkidentity(){
	var id=$("#identity").val();
	var notice2=$("#notice2");
	var regid=/^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	if(regid.test(id)==false){
	   $(notice2).html("身份证输入不合法");	
	   return false;
	}else{
		$(notice2).html("");
		return true;
		}
}

function checkphone(){
	var id=$("#phone").val();
	var notice3=$("#notice3");
	var regid=/^[1-9]{8,11}$/;
	if(regid.test(id)==false){
	   $(notice3).html("电话号码输入不合法");	
	   return false;
	}else{
		$(notice3).html("");
		return true;
		}
}
</script>
<style type="text/css">
.sp{
color:red;
font-size:12px;
}
</style>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">客房管理</a></li>
    <li><a href="#">添加客房</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">添加客房</a></li> 
    
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>${username }</b>，请填写要添加的客房信息</div>
    <form action="<%=basePath %>/addHouse.do" method="post" id="fm">
    <ul class="forminfo">
    <li>
    <label>客房号<b>*</b></label>
    <input name="roomNum" type="text" class="dfinput" value="" id="name" />
    <span style="color:red;font-size:12px" id="sp"></span>
    </li>
    <li>
          <label>房间类型<b>*</b></label>
          <div class="vocation"> 
            <select class="select1" name="roomTypeId">
            
            </select>
          </div>
    </li>
    
       <li>
          <label>房间状态<b>*</b></label>
          <div class="vocation"> 
            <select class="select1" name="roomStatus">
              <option value="0">空闲</option>
                <option value="1">已入住</option>
                  <option value="2">待打扫</option>
            </select>
          </div>
    </li>  
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认"/></li>
    </ul>
    </form>
    </div> 
    <script type="text/javascript">
    $(function(){
    	$("input[type=text]").focus(function(){
    		$(".sp").html("");
    	})
    });
    
    </script>
   <script type="text/javascript">
   $("#fm").submit(function(){
		$("input[type=submit]").css({
			background:'#ccc'
		})
	});
   $(function(){
	   $("select[name=roomTypeId]").mouseover(function(){
		  $.ajax({
			  url:'<%=basePath %>/getHouseTypeInfo.do',
				type:'post',
				dataType:'json',
				success:function(result){
					var content="";
					for(var i in result){
						content+="<option value="+result[i].id+">"+result[i].room_type+"</option>";
					}	
					$("select[name=roomTypeId]>option").remove();	
					 $("select[name=roomTypeId]").append(content);
				}
		  });
		
		  }) ;
	   $("input[name=roomNum]").blur(function(){
			var rn=$("input[name=roomNum]").val();
		   $.ajax({
			  url:'<%=basePath %>/getRoomNums.do',
				type:'post',
				dataType:'json',
				data:{
					roomNum:rn
				},
				success:function(result){
					if(result){
						$("#sp").html("此房间号已存在，请重新输入");
						$("input[name=roomNum]").focus();
					}
					
				}
	  }) 
	  })
   });
	 
   
   
   </script>
</body>

</html>
