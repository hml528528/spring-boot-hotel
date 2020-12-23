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
<title>入住信息查询</title>

<!-- 引入bootstrap分页 -->
	
	<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>/static/js/bootstrap/bootstrap.css" />
	<script src="<%=basePath%>/static/js/bootstrap/jquery.min.js"></script>
	<script src="<%=basePath%>/static/js/bootstrap/bootstrap.min.js"></script>
	<script src="<%=basePath%>/static/js/bootstrap/bootstrap-paginator.js"></script>
	<script>
	$(function() {
		$('#pagination').bootstrapPaginator({
			bootstrapMajorVersion: 3,
			currentPage: ${requestScope.pageInfo.pageNum },
			totalPages: ${requestScope.pageInfo.pages },
			pageUrl: function(type, page, current) {
				return '/getSysUserInfo.do?pageNum=' + page;
			},
			itemTexts: function(type, page, current) {
				switch(type) {
					case "first":
						return "首页";
					case "prev":
						return "上一页";
					case "next":
						return "下一页";
					case "last":
						return "末页";
					case "page":
						return page;
				}
			}
		});
	});
	</script>
<%-- <script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script> --%>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="main.html">首页</a></li>
    <li><a href="#">入住管理</a></li>
    <li><a href="#">入住信息查询</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click">
      <a href="<%=basePath %>/checkInfoAdd.do"><img src="<%=basePath %>/static/images/t01.png" />添加</a></li>
      <li class="click">
      <a href="javascript:void(0)" id="click"><img src="<%=basePath %>/static/images/t02.png" /> 重置密码</a>
     </li>
      <li id="batchDel"><a><img src="<%=basePath %>/static/images/t03.png" />删除</a></li>
    </ul>
    
    <div class="toolbar1">
      <table>
        <form method="post" action="<%=basePath %>/getSysUserInfo.do">
          <tr>
            <td class="zi"><span>选择分类：</span></td>
            <td>
		            <select name="type">              
		                <option >用户名</option>
		              </select></td>
            <td class="zi"><span >关键字：</span></td>
            <td><input type="text" placeholder="与分类关联" name="username"/></td>
            <td><input type="submit" value="查询" class="button"/></td>
          </tr>
        </form>
      </table>
    </div>
    
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th><input name="" type="checkbox" value="" /></th>
        
        <th>编号</th>
        <th>用户名</th>
        <th>使用状态</th>
        <th>创建日期</th>
        <th>操作</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="map" varStatus="num">
      <tr>
        <td><input name="ck" type="checkbox" value="${map.id }" isAdmin="${map.is_admin }"/></td>
        <td>${ num.count}</td>
        <td>${map.username }</td>
        <td>${map.status=='1'?'启用':'禁用' }</td>
        <td>${map.create_date }</td>
        <td>
        <c:choose>
        <c:when test="${map.status=='1' && map.is_admin=='0'}">
         <a href="javascript:void(0)" class="tablelink" flag="click" id="${map.id }" status="0">禁用</a> 
        </c:when>
         <c:when test="${map.is_admin=='1'}">
         <a href="javascript:void(0)" class="tablelink">无权限</a> 
        </c:when>
        <c:otherwise>
          <a href="javascript:void(0)" class="tablelink" flag="click" id="${map.id }" status="1">启用</a> 
        </c:otherwise>
        </c:choose>
       
       </td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  <!--使用bootstrap分页插件  -->
  <!-- 把分页搞出来 -->
	<ul id="pagination"></ul>
  </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(function(){
		/* 重置密码 */
		$("#click").click(function(){
			var id=$("input[name=ck]:checked").val();
			var len=$("input[name=ck]:checked").size();
			var isAdmin=$("input[name=ck]:checked").attr("isAdmin");
			if(len==0){
				alert("请选择要重置密码的行")
			}else if(len>=2){
				alert("只能选择一行，请重新选择")
			}else{
				$.ajax({
					url:'<%=basePath %>/updatePassword.do',
					type:'post',
					dataType:'json',
					data:{
						id:id
						
					},
					success:function(result){
						if(result){//代表操作成功
							if(isAdmin=='1'){//是超级管理员
								alert("密码重置成功")
								window.open("<%=basePath %>pages/admin/login.jsp","_top");
							}else{
								alert("密码重置成功")
							}
						}else{
							alert("重置失败")
						}
					}
				})
			}
		});
		/* 启用与禁用 */
		$("a[flag=click]").click(function(){
			var id=$("a[flag=click]").attr("id");
			var status=$("a[flag=click]").attr("status");
			 $.ajax({
					url:'<%=basePath %>/updateSysUserStatus.do',
					type:'post',
					dataType:'json',
					data:{
						id:id,
						status:status
					},
					success:function(result){
						if(result){
							window.location.reload();
						}else{
							alert("修改失败")
						}
					} 
				}) 
		});
		$("#del").click(function(){
			   var flag= window.confirm("您确认删除本条记录吗?");
			   if(flag){//确定删除
				   $.ajax({
						url:'<%=basePath %>/deleteByid.do',
						type:'post',
						dataType:'json',
						data:{id:$(this).attr("room_id")},
						success:function(result){
							if(result){
								window.location.reload();
							}else{
								alert("删除失败")
							}
						} 
					}) 
			   }
			    
				
		});
	})
		
	</script>
</body>
</html>
