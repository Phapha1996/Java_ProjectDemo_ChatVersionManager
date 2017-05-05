<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>增加页面</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
	<style type="text/css">
    	table{
			margin:70px 0px 0px 340px;
		}
		#caozuo{
			margin:10px 0px 0px 340px;
		}
		h3{
			margin:0px;
			padding:0px;
		}
    </style>
  </head>
  <script type="text/javascript">
 	 function noMenuOne() 
	{ 
		alert('fage源码保护，请勿右击!'); 
		return false; 
	} 
	document.oncontextmenu = noMenuOne;
  </script>
 <%--  <body>
    上传页面，需要的信息：上传文件名，上传描述，上传
    <a href="${pageContext.request.contextPath }/resource_add">增加</a>
  </body> --%>
   <body style="text-align:center;overflow-x: hidden;">
   <h3 align="left"><font color="red">*&nbsp版本添加(请上传合法apk文件，不要上传垃圾文件，否则服务器可能难以维护并有几率导致奔溃)</font></h3>
  	<form action="${pageContext.request.contextPath }/resource_add" method="post" enctype="multipart/form-data">
  	<table border="1"">
  		<tr>
  			<th>版本名称：</th>
  			<td><input type="text" name="resource.title"/></td>
  		</tr>
  		<tr>
  			<th>版本上传：</th>
  			<td><input type="file" name="version"/></td>
  		</tr>
  		<tr>
  			<th>版本描述：</th>
  			<th><textarea rows="10" cols="50" name="resource.discription"></textarea></th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="添加"/>
  		<input type="reset" value="重置"/>
  	</div>
  	</form>
  </body>
</html>
