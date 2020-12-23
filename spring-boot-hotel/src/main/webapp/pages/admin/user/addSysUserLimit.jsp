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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    <li><a href="#">添加用户</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">添加用户</a></li> 
    
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <form action="javascript:void(0)" method="post" id="fm">
    <ul class="forminfo">
    <li>
    <label>用户名<b>*</b></label>
    <input name="username" type="text" class="dfinput" />
    </li>
    <li>
    <label>用户密码<b>*</b></label>
    <input name="password" type="text" class="dfinput" />
    </li>
   <li>
    <label>用户权限<b>*</b></label>
    <table>
    <c:forEach items="${menusList }" var="OneMenu">
    <tr>
    <input type="hidden" name="OneMenu" value="${OneMenu.id }">
    <td>${OneMenu.oneName }</td>
    <td>
    <c:forEach items="${OneMenu.towMenusList }" var="TowMenu">
    <input type="checkbox" oneMenuId="${OneMenu.id }"  name="TowMenu" value="${TowMenu.towMenuId }">${TowMenu.towName }
    </c:forEach>
    </td>
    </tr>
    </c:forEach>
    </table>
    </li>
    
    <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认"/></li>
    </ul>
    </form>
    </div> 
   <script type="text/javascript">
   $("#fm").submit(function(){
	   $("input[type=submit]").attr("disabled","disabled");
		$("input[type=submit]").css({
			background:'#ccc'
		});
        //传递数据
        var username=$("input[name=username]").val();
		var password=$("input[name=password]").val();
		//获取被勾选的二级权限ID
		var $tmChecked = $("input[name=TowMenu]:checked");
		var twoIdStr = "";
		//获取一级权限ID
		var oneIdStr = "";
		$tmChecked.each(function(index,dom){
			 twoIdStr+=$(dom).val()+",";
			 oneIdStr+=$(dom).attr("oneMenuId")+",";
		});
		alert(oneIdStr+"-----"+twoIdStr)
		//执行ajax操作，将数据保存到数据库中去
		$.ajax({
			url:"<%=basePath%>/addSysUserLimit.do",
			type:"post",
			dataType:"json",
			data:{
				username:username,
				password:password,
				oneIds:oneIdStr,
				twoIds:twoIdStr
			},
			success:function(result){
				alert()
			}
		})
		
	});
	 
   
   
   </script>
</body>

</html>
