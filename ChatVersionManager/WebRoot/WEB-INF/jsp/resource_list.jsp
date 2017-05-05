<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>版本管理页面</title>
	<meta http-equiv="content-Type" content="test/html;charset='utf-8'">
	<style type="text/css" >
		#table{
			margin:10px 0px 0px 160px;
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
		#addlink{
			width:100%;
			margin:40px 0px 0px 0px;
			padding:0px 0px 0px 310px;
		}
		h3{
			margin:0px;
			padding:0px;
		}
	</style>
	<script type="text/javascript">
		function deleteMethod(id){
			if(window.confirm('确定要删除当前版本吗？这将会是不可逆转的，请及时做好备份工作！')){ 
				//alert("${pageContext.request.contextPath }/resource_delete?resource.id="+id);
				//alert(id);
				window.location.replace("${pageContext.request.contextPath }/resource_delete?resource.id="+id);
			}else{ 
				window.location.replace("${pageContext.request.contextPath}/resource_list");
			}
		}
		function noMenuOne() 
		{ 
			alert('fage源码保护，请勿右击!'); 
			return false; 
		} 
		document.oncontextmenu = noMenuOne;
	</script>
  </head>
  
  <%-- <body>
  	 当前是显示所有的版本页面（需要分页显示）,需要的信息：版本号，版本新功能描述，版本发布日期，本机路径，url网络路径
	<a href="${pageContext.request.contextPath}/resource_addui">添加版本</a>
	<a href="${pageContext.request.contextPath}/resource_delete">删除</a>
	<a href="${pageContext.request.contextPath}/resource_updateui">修改</a>
	<a href="${pageContext.request.contextPath}/resource_show">查看详情</a>
  </body> --%>
  
  <body style="text-align:center;overflow-x: hidden;">
	<h3 align="left"><font color="red">*&nbsp版本管理</font></h3>
	<div id="addlink"><a href="${pageContext.request.contextPath }/resource_addui">*&nbsp版本上线</a></div>
	<table id="table" align="center" border="1" width="800px">
		<tr>
			<th>版本号</th>
			<th>版本名</th>
			<th>发布日期</th>
			<th>版本功能描述</th>
			<th>功能操作</th>
		</tr>
		 <s:iterator value="#request.allResource" var="resource">
		<tr>
				<th><s:property value="#resource.id"/></th>
				<th><s:property value="#resource.title"/></th>
				<th><s:property value="#resource.releaseDate"/></th>
				<th><s:property value="#resource.discription"/></th>
				<th>
					<a href="${pageContext.request.contextPath }/resource_show?resource.id=<s:property value="#resource.id"/>">查看详情</a>
					<a href="${pageContext.request.contextPath }/resource_updateui?resource.id=<s:property value="#resource.id"/>">信息修改</a>
					<a href="javascript:deleteMethod('<s:property value="#resource.id"/>')">版本下线</a>
				</th>
		</tr>
		</s:iterator> 
	</table> 		
 	 	
  </body>
</html>
