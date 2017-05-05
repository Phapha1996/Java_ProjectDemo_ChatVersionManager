<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>缺省错误页面</title>
	<meta http-equiv="content-type" content="text-html;charset='utf-8'">
	<script type="text/javascript">
	var sid;
	var s = 3;
	function showTime(){
		var div = document.getElementById("show");
		div.innerHTML=s;
		s--;
		sid = setTimeout('showTime()',1000);//每过1000毫秒调用一次当前函数
	}
	function pose(){
		var message = document.getElementById("message").innerHTML;
		if(message=="当前您还未上传任何版本"){
			showTime();
			document.getElementById("content").innerHTML = "即将自动跳转上传页面，如果没有跳转，请点击<a href='http://59.110.155.61:8080/ChatVersionManager/resource_addui'>发布新版本</a>";
			setTimeout("javascript:window.location.href='http://59.110.155.61:8080/ChatVersionManager/resource_addui'",3000);
		}
	}
	</script>
  </head>
  <body onload="pose()">
<h3 align="left"><font color="red"><div id="message"><s:property value="exception.message"/></div><div id="content"></div><div id="show" style="font-size: 40px;"></div></font></h3>
  </body>
</html>
