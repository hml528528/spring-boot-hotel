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
    <li><a href="#">订单信息管理</a></li>
    <li><a href="#">添加订单信息</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>订单信息</span></div>
  <div id="usual1" class="usual">
    <div id="tab1" class="tabson">
    <form action="<%=basePath %>/addorders.do" method="post">
      <ul class="forminfo">
        <li>
          <label>房间号<b>*</b></label>
          <div class="vocation"> 
            <!--   <input name="" type="text" class="dfinput" value="请填写单位名称"  style="width:518px;"/>-->
            <select class="select1" name="roomId">
            <c:forEach items="${numList }" var="RoomNumsList">
              <option value="${ RoomNumsList.id}" >${RoomNumsList.room_num }</option>
            </c:forEach>
            </select>
          </div> 
        </li>
        <br />
        <li  style="margin-top:20px;">
          <label for="name" >客人姓名<b>*</b></label>
          <div class="vocation">
            <input name="customerName" type="text" class="dfinput" readonly="readonly" placeholder="请填写客户姓名" pattern=".{2,20}" required="required" style="width:344px;" value="${errorMap.customerName==null?order.customerName:'' }"/>
            <span class="sp"></span>
          </div>
        </li>
        <br />
        <br />
        <br />
        <li>
          <label for="name" >身份证号码<b>*</b></label>
          <div class="vocation">
            <input name="idcard" type="text" class="dfinput" readonly="readonly" placeholder="请填写客户身份证号码" pattern="\d{17}[0-9X]" required="required" style="width:344px;" value="${errorMap.idcard==null?order.idcard:'' }"/>
             <span class="sp"></span>
          </div>
        </li>
        <br />
        <li>
          <label for="name" >手机号码<b>*</b></label>
          <div class="vocation">
            <input name="phoneNum" type="text" class="dfinput" readonly="readonly" placeholder="请填写客户手机号码" pattern="1[3578]\d{9}" required="required" style="width:344px;" value="${errorMap.phoneNum==null?order.phoneNum:'' }"/>
             <span class="sp"></span>
          </div>
        </li>
        <br />
        <li>
        <cite>
          <label for="name">账单状态<b>*</b></label>
          <input name="orderStatus" type="radio" value="1" checked="checked" />已结算
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input name="orderStatus" type="radio" value="0" />未结算
          <span class="sp" id="sp">${errorMap.orderStatus==null?'':errorMap.orderStatus }</span>
          </cite>
        </li>
        <br />
        <li>
          <label for="name" >订单总价<b>*</b></label>
          <div class="vocation">
            <input name="total" type="text" class="dfinput" placeholder="输入押金金额" required="required" pattern="[1-9]\d*.\d*|0.\d*[1-9]\d" style="width:344px;" value="${errorMap.total==null?order.total:'' }"/>
            <span class="sp" id="sp1">${errorMap.total==null?'':errorMap.total }</span>
          </div>
        </li>
        <br />
        <li>
          <label for="name" >创建订单时间<b>*</b></label>
          <div class="vocation">
            <input type="text" name="checkDate" class="laydate-icon span1-1" id="Calendar" style="width:324px; height:30px; line-height:28px; text-indent:10px; "/>
          </div>
        </li>
        <br />
        <li>
          <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="提交"/>
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
	<script type="text/javascript">
$(function(){
	//当点击订单总计获取焦点时隐藏错误信息
	$("input[name=total]").focus(function(){
		$("#sp").html("");
		$("#sp1").html("");
	});
	$("select[name=roomId]").change(function(){
		var value=$("select[name=roomId]>option:selected").attr("value");
		$.ajax({
			url:'<%=basePath %>/getdetailcheckInfo.do',
			type:'post',
			data:{roomId:value},
			dataType:"json",
			success:function(result){
				if(result){
					$("input[name=customerName]").attr("value",result.customer_name);
					$("input[name=idcard]").attr("value",result.idcard);
					$("input[name=phoneNum]").attr("value",result.phone_num);
					$("input[name=checkDate]").attr("value",result.check_date);
					$("input[name=checkDate]").attr("disabled","disabled");
					
				}
			}
		});
		
	})
})
</script>
</div>
</body>
</html>
