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
    <title>申请加入社团</title>
    <script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>

<body>
    <div id="pageInfo">
        <nav> 
            <span>加入社团 </span>
        </nav>
        <c:forEach items="${clubs}" var="club">
	        <div class="communitydiv community${club.clubId}">
	            <img src="<%=basePath%>fileupload/${club.image}">
	           <%--  <h2>${club.clubname }</h2>
	             <p>${club.description }</p> --%>
	            <div class="communitySum" >
	                <h2>${club.clubname }</h2>
	                <p>${club.description }</p>
	            </div>
	            <a id="button_${club.clubId }" onclick="joinClub(this)" >GO>></a>
	        </div>
        </c:forEach>
   
    </div>
    
    <script type="text/javascript">
    		function joinClub(data){
    			//alert("即将加入社团");
    			var clubId = $(data).attr('id').replace('button_','');
    			//alert(clubId);
    			$.ajax({
    				 url:basePath+"/joinClub.do", 
    				 type:'GET',
    				 data:{
			            	clubId:clubId
			            },
			            success: function(data){ 
			            	if(data=='success')
			            		alert('您已经申请成功，请耐心等待');
			            	else{
			            		alert('请勿重复申请');
			            	}
			            },
			            error: function(data){
			                alert("something wrong");
			            }
    			});
    		}
    </script>
    
</body>
</html>
                