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
<!-- 引入bootstrap分页 -->
	<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
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
				return '/getmembership.do?pageNum=' + page;
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
    <li><a href="#">会员管理</a></li>
    <li><a href="#">会员信息查询</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="<%=basePath %>/static/images/t01.png" /></span>添加</li>
      <li class="click" id="update"><span><img src="<%=basePath %>/static/images/t02.png" /></span>修改</li>
      <li><span><img src="<%=basePath %>/static/images/t03.png" /></span>删除</li>
    </ul>
    <div class="toolbar1">
      <table>
        <form method="get" name="serch">
          <tr>
            <td class="zi"><span>选择分类：</span></td>
            <td><select>
                <option>会员卡号</option>
                <option>会员姓名</option>
                <option>手机号码</option>
                <option>身份证号码</option>
              </select></td>
            <td class="zi"><span>关键字：</span></td>
            <td><input type="text" placeholder="与分类关联"/></td>
            <td><input type="submit" value="查询" class="button"/></td>
          </tr>
        </form>
      </table>
    </div>
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号</th>
        <th>会员卡号</th>
        <th>会员姓名</th>
        <th>性别</th>
        <th>身份证号码</th>
        <th>手机号码</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${pageInfo.list }" var="map" varStatus="num">
      <tr>
        <td><input name="ck" type="checkbox" value="${map.id }" /></td>
        <td>${num.count }</td>
        <td>${map.membership_num }</td>
        <td>${map.customer_name }</td>
        <td>${map.gender==1?'男':'女' }</td>
        <td>${map.idcard }</td>
        <td>${map.phone_num }</td>
       
        <td> <a href="#" class="tablelink"> 删除</a></td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
  <!--使用bootstrap分页插件  -->
	<ul id="pagination"></ul>
	
	<script type="text/javascript">
	$(function(){
	$("#update").click(function(){
	  var len=$("input[name=ck]:checked").size();
	  if(len<1){
		  alert("亲，请选择要更新的数据");
	  }else if(len>=2){
		  alert("亲，修改数据只能选择一条记录，请重新选择");
	  }else{//选中一条记录
		  var id=$("input[name=ck]:checked").val();
		 <%--  //触发ajax
		  $.ajax({
			  url:'<%=basePath %>/getMembershipByid.do',
			  type:'post',
			  dataType:'json',
			  data:{id:id}
			   }); --%>
			 
			  window.location.href="<%=basePath %>/getMembershipByid.do?id="+id;
	  }
	});
		
	});
	</script>
</body>
</html>
