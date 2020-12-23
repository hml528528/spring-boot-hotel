<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript" src="<%=basePath %>/static/js/laydate/laydate.js"></script>
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
	
	
	
});


</script>
<style type="text/css">
.sp{
color:red;
font-size: 12px;

}
</style>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">入住信息管理</a></li>
    <li><a href="#">添加入住信息</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>入住信息</span></div>
  <div id="usual1" class="usual">
    <div id="tab1" class="tabson">
    <form action="<%=basePath %>/addCheckInfos.do" method="post">
      <ul class="forminfo">
        <li>
          <label>房间号<b>*</b></label>
          <div class="vocation"> 
            <!--   <input name="" type="text" class="dfinput" value="请填写单位名称"  style="width:518px;"/>-->
            <select class="select1" name="roomNum">
            <c:forEach items="${RoomNumsList }" var="RoomNumsList">
              <option value="${RoomNumsList.room_num }">${RoomNumsList.room_num }</option>
            </c:forEach>
            </select>
          </div>
        </li>
        <br />
        <li  style="margin-top:20px;">
          <label for="name" >客人姓名<b>*</b></label>
          <div class="vocation">
            <input name="customerName" type="text" class="dfinput" placeholder="请填写客户姓名" pattern=".{2,20}" required="required" style="width:344px;" value="${errorMap.customerName==null?checkinfo.customerName:'' }"/>
            <span class="sp">${errorMap.customerName==null?'':errorMap.customerName }</span>
          </div>
        </li>
        <br />
        <li>
        <cite>
          <label for="name">性别<b>*</b></label>
          <input name="gender" type="radio" value="1" checked="checked" />男
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input name="gender" type="radio" value="0" />女
          </cite>
        </li>
        <br />
        <li><cite>
          <label for="name">会员<b>*</b></label>
          <input name="isMembership" type="radio" value="1" checked="checked" />是
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input name="membership" type="radio" value="0" />否
          </cite></li>
        <br />
        <li>
          <label for="name" >身份证号码<b>*</b></label>
          <div class="vocation">
            <input name="idcard" type="text" class="dfinput" placeholder="请填写客户身份证号码" pattern="\d{17}[0-9X]" required="required" style="width:344px;" value="${errorMap.idcard==null?checkinfo.idcard:'' }"/>
             <span class="sp">${errorMap.idcard==null?'':errorMap.idcard }</span>
          </div>
        </li>
        <br />
        <li>
          <label for="name" >手机号码<b>*</b></label>
          <div class="vocation">
            <input name="phoneNum" type="text" class="dfinput" placeholder="请填写客户手机号码" pattern="1[3578]\d{9}" required="required" style="width:344px;" value="${errorMap.phoneNum==null?checkinfo.phoneNum:'' }"/>
             <span class="sp">${errorMap.phoneNum==null?'': errorMap.phoneNum}</span>
          </div>
        </li>
        <br />
        <li>
          <label for="name" >押金<b>*</b></label>
          <div class="vocation">
            <input name="deposit" type="text" class="dfinput" placeholder="输入押金金额" required="required" style="width:344px;" value="${errorMap.deposit==null?checkinfo.deposit:'' }"/>
            <span class="sp">${errorMap.deposit==null?'': errorMap.deposit}</span>
          </div>
        </li>
        <br />
        <li>
          <label for="name" >入住时间<b>*</b></label>
          <div class="vocation">
            <input type="text" name="checkDate" class="laydate-icon span1-1" id="Calendar" style="width:324px; height:30px; line-height:28px; text-indent:10px; "/>
          </div>
        </li>
        <br />
        <li>
          <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="入住"/>
        </li>
      </ul>
      </form>
    </div>
  </div>
  <script type="text/javascript"> 
  
      $("#usual1 ul").idTabs(); 
    </script> 
  <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	!function(){
laydate.skin('qianhuang');
laydate({elem: '#Calendar'});
laydate.skin('qianhuang');
laydate({elem: '#Calendar2'});
}();
$(function dd(){
		var d=new Date(),str="";
		str+=(d.getFullYear()+"-");
		str+="0";
		str+=(d.getMonth()+1+"-");
		str+=d.getDate();
		$("#Calendar").attr("value",str);
		$("#Calendar2").attr("value",str);
	});

	</script> 
</div>
</body>
</html>
