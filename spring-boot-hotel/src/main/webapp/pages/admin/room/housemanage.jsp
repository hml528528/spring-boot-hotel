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
<title>房间信息查询</title>

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
				return '/HouseManage.do?pageNum=' + page;
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
    <li><a href="#">房间管理</a></li>
    <li><a href="#">房间信息查询</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click">
      <a href="<%=basePath %>"><img src="<%=basePath %>/static/images/t01.png" />添加</a></li>
      <li class="click">
      <a href="<%=basePath %>"><img src="<%=basePath %>/static/images/t02.png" /> 修改</a>
     </li>
      <li id="batchDel"><a><img src="<%=basePath %>/static/images/t03.png" />删除</a></li>
    </ul>
    
  </div>
  <table class="tablelist">
  <form>
    <thead>
      <tr>
        <th><input name="" type="checkbox" value="" /></th>
        <th>编号</th>
        <th>房间类型</th>
        <th>房间价格</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="map">
      <tr id="tr">
        <td><input name="ck" type="checkbox"/></td>
        <td >${map.id}</td>
        <td >${map.room_type}</td>
        <td >${map.room_price}</td>
        <td>
         <a href="out.html" class="tablelink">修改</a> 
         <a href="javascript:void(0)"  class="tablelink"  id="del"> 删除</a>
       </td>
      </tr>
      </c:forEach>
      </form>
    </tbody>
  </table>
  <!--使用bootstrap分页插件  -->
	<ul id="pagination"></ul>
  </div>
</div>
<script type="text/javascript">
 $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
