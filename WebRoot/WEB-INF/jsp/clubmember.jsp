<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>社团成员调整</title>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团成员</span>
			</nav>
		<div id="communityMemChange">
			<table border="1px">
				<tr>
					<th>姓名</th>
					<th>职位</th>
				</tr>
				
       	  		<c:forEach items="${clubMembership }" var="clubMember">
					<tr>
						<td>${clubMember.user.username }</td>
	       				<td>${clubMember.role.rolename }</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
</body>
</html>