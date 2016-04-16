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
    <script type="text/javascript" src="<%=path %>/js/common.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.js"></script>>
</head>
<body>
    <div id="1">
        <nav>
            <span>创建社团</span>
        </nav>
      
        <form id="createClub" name="createClub"  method="post"  action="<%=path%>/club_create.do"  enctype="multipart/form-data" >
        	<div>
                <span>社团名称：</span>
                <input  type="text" name="clubname" value="${sessionScope.club.clubname }">
            </div>
            <div>
                <span>社团描述：</span>
                <input  type="text" name="description" value="${sessionScope.club.description }">
            </div>
            <div class="photo">
            	<span>上传社团图片 :</span>
            	<input type="file" name="clubImage" value="上传社团图片" >
            </div>
            <div>
                <span>创建时间：</span>
                <input  type="text" name="setuptime" placeholder="YYYY-MM-DD" value="${sessionScope.club.setuptime }">
            </div>
            <input id="createClubButton" class="button" type="submit" name="submit" value="确认信息"  >
		</form>
		
		 <!-- <script type="text/javascript"  这块是ajax提交表单，由于有文件，所以先注释掉>
		 $('#createClubButton').click(function(){
						alert("hello");
						alert($("form").serialize());
						$.ajax({ 
		                    url:basePath+"/club_create.do", 
		                    type:'POST', 
		                    data:$("form").serialize(),
		                    success: function(data){
		                    	alert('success');
		                    	if(data=='successCreate'){
		                    		alert("社团创建成功");
		                    	}
		            			$("#page-inner").html(data);
		                    },
		                    error: function(data){
		                        alert("fail");
		                    }
		                }); 
					})
				
	      </script> -->
		
      </div>
</body>
</html>
                