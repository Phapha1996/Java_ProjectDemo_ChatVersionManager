<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <meta http-equiv="content-type" content="text/html;charset='utf-8'">

	<style type="text/css">
		
		#table{
			margin:50px 0px 0px 20px;
			background:#fff;
		}
		
		#table li{
			margin:20px 0px 0px 0px;
			font-size:17px;
		}	
		#table a:link,a:visited{
		text-decoration:none;
		color:#004a87;
	}
	#table a:hover{
	color:#CCC;
	text-decoration:underline;
	color:red;
	width:150px;
	height:25px;
	}	
	</style>
  </head>
  
  <body style="overflow-x: hidden;">
	<ul id="table">
		<li><a href="${pageContext.request.contextPath }/resource_list" target="body">版本管理</a></li>
		<li><a href="##" target="body">功能待添加</a></li>
	</ul>
	
  </body>
</html>
