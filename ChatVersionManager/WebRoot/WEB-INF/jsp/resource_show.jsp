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
    <title>版本详情</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
  	<style type="text/css">
    	table{
			margin:10px 0px 0px 170px;
		}
		#caozuo{
			margin:10px 0px 0px 700px;
		}
		a:link,a:visited{
			text-decoration:none;
			color:#004a87;
		}
		a:hover{
			color:#CCC;
			text-decoration:underline;
			color:red;
		}
		#download{
			width:100%;
			margin:40px 0px 0px 10px;
			padding:0px;
		}
		td{
			font-weight: bold;
		}
		th{
			font-weight:lighter;
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
  
  <%-- <body>
   	 目前是查看当前版本的详情信息：版本号，版本名，版本创建时间，本机路径，下载路径，版本描述
    <a href="${pageContext.request.contextPath }/resource_list">返回</a>
  </body> --%>
  <body style="text-align:center;overflow-x: hidden;">
  	<h3 align="left"><font color="red">*&nbsp<s:property value="#request.resource.title"/></font></h3>
  	<div id="download"><a href="${pageContext.request.contextPath }/download?resource.id=<s:property value="#request.resource.id"/>&&resource.name=<s:property value="#request.resource.name"/>">下载到本机</a></div>
  	<table width="800px" border="1">
		<tr>
			<td>版本号：</td>.
			<th><s:property value="#request.resource.id"/></th>
		</tr>
		
		<tr>
			<td>版本名：</td>
			<th><s:property value="#request.resource.title"/></th>
		</tr>
		
		<tr>
			<td>版本上传文件名：</td>
			<th><s:property value="#request.resource.name"/></th>
		</tr>
		
		<tr>
			<td>版本创建时间：</td>
			<th><s:property value="#request.resource.releaseDate"/></th>
		</tr>
		
		<tr>
			<td>版本所处本机位置：</td>
			<th><s:property value="#request.resource.fileUrl"/></th>
		</tr>
		
		<tr>
			<td>Android下载提供地址：</td>
			<th><s:property value="#request.url" /></th>
		</tr>  	
		
		<tr>
			<td>版本描述：</td>
			<th><s:property value="#request.resource.discription"/></th>
		</tr>  	
  	</table>
  	<div id="caozuo">
		<a href="${pageContext.request.contextPath }/resource_list">返回</a>
  	</div>
  </body>
</html>
