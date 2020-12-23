<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>结账退房</title>
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/static/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/editor/kindeditor.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/laydate/laydate.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/JsonHandler.js"></script>
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
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">入住信息管理</a></li>
    <li><a href="#">结账退房</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>消费信息</span></div>
<div id="usual1" class="usual">
  <div id="tab1" class="tabson">
  <form action="javascript:void(0)" id="form1">
    <ul class="forminfo">
      <li>
        <label>房间号<b>*</b></label>
        <div class="vocation"> 
          <!--   <input name="" type="text" class="dfinput" value="请填写单位名称"  style="width:518px;"/>-->
          <select class="select1" name="roomId">
          <c:forEach items="${RoomNumsList }" var="map">
            <option value="${map.id }" >${map.room_num }</option>
          </c:forEach>
          </select>
        </div>
      </li>
      <li  style="margin-top:20px;"> 
        <label for="name" >客人姓名<b>*</b></label>
        <div class="vocation">
          <input name="customerName" type="text" class="dfinput" value="客户姓名"  style="width:344px;"/>
        </div>
      </li>
      <br /> <br />
      <li>
        <label for="price" style="cursor:pointer" >单价<b>*</b></label>
        <div class="vocation">
          <input name="price" id="price" class="dfinput" value=""  style="width:344px;"/>
        </div>
      </li> <br />
      <li>
        <label for="deposit" style="cursor:pointer" >押金<b>*</b></label>
        <div class="vocation">
          <input name="deposit"  id="yajin" type="text" class="dfinput" value="押金"  style="width:344px;"/>
        </div>
      </li> <br />
       <li>
        <label for="other" style="cursor:pointer" >其他消费<b>*</b></label>
        <div class="vocation">
          <input name="otherConsume"   type="text" class="dfinput" value="" style="width:344px;"/>
        </div>
      </li> <br />
      <li>
        <label for="checkDate" style="cursor:pointer" >入住时间<b>*</b></label>
        <div class="vocation">
          <input name="checkDate"  id="date1" class="dfinput" value="2016-06-01"  style="width:344px;"/>
        </div>
      </li> <br />
      <li>
        <label for="Calendar" style="cursor:pointer" >退房时间<b>*</b></label>
        <div class="vocation">
          <input type="text" name="checkoutDate" class="laydate-icon span1-1" id="Calendar" style="width:324px; height:30px; line-height:28px; text-indent:10px; "/>
        </div> <br />
      </li>
      <li>
        <label>&nbsp;</label>
        <input name="" type="submit" class="btn" value="提交" />
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
	/* 结账退房 */
	$("input[type=submit]").click(function(){
		var data=$("#form1").serializeObject();
		alert(JSON.stringify(data));
		$.ajax({
			url:'<%=basePath %>/Checkout.do',
			type:'post',
			dataType:'json',
			data:data,
			success:function(result){
				if(result>=0){
					alert(result);
					window.location.href="<%=basePath %>/getInfo.do"
				}else{
					alert(result)
				}
				
			}
		})
	});
	$("select[name=roomId]").change(function(){
		var value=$("select[name=roomId]>option:selected").val();
		$.ajax({
			url:'<%=basePath %>/getdetailcheckInfo.do',
			type:'post',
			data:{roomId:value},
			dataType:"json",
			success:function(result){
				if(result){
					$("input[name=customerName]").attr("value",result.customer_name);
					$("input[name=customerName]").attr("readonly","readonly");
					$("input[name=price]").attr("value",result.room_price);
					$("input[name=price]").attr("readonly","readonly");
					$("input[name=deposit]").attr("value",result.deposit);
					$("input[name=deposit]").attr("readonly","readonly");
					var other=result.otherConsume;
					if(other==null){
						other=0;
					}
					$("input[name=otherConsume]").attr("value",other);
					$("input[name=otherConsume]").attr("readonly","readonly");
					$("input[name=checkDate]").attr("value",result.check_date);
					$("input[name=checkDate]").attr("readonly","readonly");
					
				}
			}
		});
		
	})
})
</script>
</div>
</body>
</html>
