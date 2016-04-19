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
    <script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.js"></script>
</head>
<body>
    <div id="pageInfo">
           <nav>
            我的社团 >> 创建社团
      	  </nav>
        <form id="communityInfoChange" name="createClub"  method="post"  action="<%=path%>/club_create.do"  enctype="multipart/form-data" >
        	<div id="communityInfoChange-left">
                <span>社团名称：</span>
                <input  type="text" name="clubname" value="${sessionScope.club.clubname }">
            </div>
            <div id="communityInfoChange-logo" >
            	<span>社团图片 :</span>
            	<div id="communityLogo"></div> 
            	<!--<input type="file" name="clubImage" value="上传社团图片" > -->
            	  <a href="javascript:void(0);">
                    点击上传<input id="click_upload" type="file" name="clubImage" accept="image/*" onclick="uploadImage()">
                </a>
            </div>
            <div id="communityInfoChange-right">
                <span>社团描述：</span>
                <textarea name="description">${sessionScope.club.description }</textarea>
            </div>
            <div id="communityInfoChange-bottom">
                <input type="submit" value="确认创建" name="submit">
            </div>
		</form>
		
		
		<!-- ajax用于图片上传的实时回显 -->
		<script type="text/javascript">
			function uploadImage(){
					
			
			}
		
		
		
		</script>
		
		
		
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
                