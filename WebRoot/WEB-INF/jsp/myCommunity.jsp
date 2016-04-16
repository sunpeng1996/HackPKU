<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myCommunity</title>
</head>
<body>
    <div id="pageInfo">
        <nav>
            <span>我的社团</span>
        </nav>
        <c:forEach items="${clubs }" var="club">
	        <div class="communitydiv community${club.clubId}">
	            <img src="images/hit_logo.png">
	            <div class="communitySum " >
	                <h2>${club.clubname }</h2>
	                <p>${club.description }</p>
	            </div>
	            <a href="<%=path %>/toClubPage.do?club_id=${club.clubId}">GO>></a>
	        </div>
        </c:forEach>
        <div class="communitydiv">
            <div>
               <a href="">创建社团</a> 
            </div>
            
            <div>
                <a href="">加入社团</a>
            </div>
        </div>
    </div>
    
</body>
</html>
                