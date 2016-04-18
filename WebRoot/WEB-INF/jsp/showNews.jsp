<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>社团日志发布</title>
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" href="css/index.css" type="text/css"> </link>
	<style>
	#editor {overflow:auto;; max-height:300px}
	</style>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团管理 >> 社团日志</span>
		</nav>
		<div id="publishNews">
			<div class="summary publish-Info">
				<span>标题:</span>
				<input id="title" type="text" name="summary"  value="${news.title }">
			</div>
			<div class="author publish-Info">
				<span>发布者:</span>
				<input id="publisher" type="text" name="author" value="${author }">
			</div> 
			<div class="publish-Info">
				<span>发布时间:</span>
				<input id="publish_time" type="text" name="time" value="${time }">
			</div> 
			<div class="details publish-Info">
				<span>新闻内容:</span>
				  <div class="hero-unit">

				    <div id="editor" >
				     ${summary }
				    </div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>