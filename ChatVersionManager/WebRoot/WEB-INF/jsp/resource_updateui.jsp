<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改页面</title>
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
    <script type="text/javascript">
    function noMenuOne() 
	{ 
		alert('fage源码保护，请勿右击!'); 
		return false; 
	} 
	document.oncontextmenu = noMenuOne;
    </script>
  </head>
 <%--  <body>
    上传页面，需要的信息：上传文件名，上传描述，上传
    <a href="${pageContext.request.contextPath }/resource_add">增加</a>
  </body> --%>
   <body style="text-align:center;overflow-x: hidden;">
   <h3 align="left"><font color="red">*&nbsp<s:property value="#request.resource.title" />修改</font></h3>
  	<form action="${pageContext.request.contextPath }/resource_update" method="post" enctype="multipart/form-data">
  	<table border="1"">
  		<tr>
  			<th>版本名称：</th>
  			<td><input type="text" name="resource.title" value="<s:property value="#request.resource.title" />"/></td>
  		</tr>
  		<tr>
  			<th>版本描述：</th>
  			<th><textarea rows="10" cols="50" name="resource.discription"><s:property value="#request.resource.discription" /></textarea></th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="修改"/>
  		<input type="reset" value="重置"/>
  	</div>
  	<input type="hidden" name="resource.id" value="<s:property value="#request.resource.id" />"/>
  	</form>
  </body>
</html>
