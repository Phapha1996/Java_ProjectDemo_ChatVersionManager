<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>畅聊版本管理系统</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
	<script type="text/javascript">
	function noMenuOne() 
	{ 
		alert('禁止右键菜单!'); 
		return false; 
	} 
	document.oncontextmenu = noMenuOne;
	/* function noMenuTwo() 
{ 
if(event.button == 2) 
{ 
alert('禁止右键菜单!'); 
return false; 
}  
} 
document.onmousedown = noMenuTwo; */
	</script>
  </head>
	<frameset rows="22%,*">
		<frame src="head.jsp" name="head">
		<frameset cols="14.4%,*">
			<frame src="left.jsp" name="left">
			<frame src="body.jsp" name="body">
		</frameset>
	
	</frameset>  
</html>
