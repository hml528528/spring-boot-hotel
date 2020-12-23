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
				return '/getInfo.do?pageNum=' + page;
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
      <a href="<%=basePath %>/pages/admin/bill/checkin.jsp"><img src="<%=basePath %>/static/images/t02.png" /> 修改</a>
     </li>
      <li id="batchDel"><a><img src="<%=basePath %>/static/images/t03.png" />删除</a></li>
    </ul>
    
    <div class="toolbar1">
      <table>
        <form method="post" action="<%=basePath %>/getInfoBycondition.do">
          <tr>
            <td class="zi"><span>选择分类：</span></td>
            <td>
		            <select name="type">
		                <option value="room_num">房间号</option>
		                <option value="customer_name">客人姓名</option>
		                <option value="phone_num">手机号码</option>
		                <option value="idcard">身份证号码</option>
		              </select></td>
            <td class="zi"><span >关键字：</span></td>
            <td><input type="text" placeholder="与分类关联" name="keyword"/></td>
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
        <th>房间号</th><th>房间类型</th>
        <th>客人姓名</th>
        <th>性别</th>
        <th>身份证号码</th>
        <th>手机号码</th>
        <th>押金</th>
        <th>入住时间</th>
        <th>操作</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="CheckInfos" varStatus="num">
      <tr>
        <td><input name="ck" type="checkbox" value="${CheckInfos.id }" /></td>
        <td>${ CheckInfos.id}</td>
        <td>${CheckInfos.room_num }</td>
        <td>${CheckInfos.room_type }</td>
        <td>${ CheckInfos.customer_name}</td>
        <td>${CheckInfos.gender }</td>
        <td>${CheckInfos.idcard }</td>
        <td>${CheckInfos.phone_num }</td>
        <td>${CheckInfos.deposit }</td>
        <td>${CheckInfos.check_date }</td>
        <td>
        <c:choose>
        <c:when test="${CheckInfos.checkout_status=='1' }">
         <a href="out.html" class="tablelink">已退房</a> 
        </c:when>
        <c:otherwise>
          <a href="out.html" class="tablelink">退房</a> 
        </c:otherwise>
        </c:choose>
       
        <a href="javascript:void(0)" room_id="${CheckInfos.id }" class="tablelink"  id="del"> 删除</a>
       </td>
      </tr>
       </c:forEach>
    </tbody>
  </table>
  <!--使用bootstrap分页插件  -->
  <!-- 把分页搞出来 -->
	<ul id="pagination"></ul>
  
  
  <%-- <div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>
    <div class="tipinfo"> <span><img src="<%=basePath %>/static/images/ticon.png" /></span>
      <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite> </div>
    </div> --%>
    <!-- <div class="tipbtn">
      <input name="" type="button"  class="sure" value="确定" />
      &nbsp;
      <input name="" type="button"  class="cancel" value="取消" />
    </div> -->
  </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(function(){
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
	/* 全选按钮 */
		$("input[type=checkbox]:eq(0)").change(function(){
			var flag=$("input[type=checkbox]:eq(0)").prop("checked");
		      if(flag){//全选
		    	  $("input[name=ck]").prop("checked",true);
		      }else{//取消
		    	  $("input[name=ck]").prop("checked",false);
		      }
		})
		/* 批量删除 */
		$("#batchDel").click(function(){
		var $check=	$("input[name=ck]:checked");
		    if($check.size()>=1){//选中
		    	var idStrr="";
		    	$check.each(function(index,dom){
		    		var $dom=$(dom);
		    		var id=$dom.val();
		    		idStrr+=id+",";
		    	})
		    	
		    	$.ajax({
		    		url:'<%=basePath %>/batchDel.do',
		    		type:'post',
		    		data:{idStrr:idStrr},
		    		dataType:'json',
		    		success:function(result){
		    			if(result){
		    				window.location.reload();
		    			}else{
		    				alert("删除失败，请再次执行以上操作")
		    			}
		    		}
		    	})
		    }else{//没选中一个
		    	alert("请您选择要删除的行");
		    }
		})
		
	</script>
</body>
</html>
