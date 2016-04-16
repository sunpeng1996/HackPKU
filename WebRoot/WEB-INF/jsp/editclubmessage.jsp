<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>社团信息变更</title>
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>
<body>
	<div id="pageInfo">
		<nav>
			社团管理 >> 社团信息变更
		</nav>
		
		<form action="updateClubMessage.do" method="post" id="communityInfoChange">
			<input type="hidden" name="clubId" value="${club.clubId }"/>
			<div id="communityInfoChange-left">
				<span>社团名称：</span>
				<input type="text" name="clubname" value="${club.clubname }"/>
			</div>
			<div id="communityInfoChange-logo">
				<span>社团图标：</span>
				<div id="communityLogo"></div>
				<a href="javascript:void(0);">
					点击上传<input type="file" name="submitLogo" accept="image/*" />
				</a>
			</div>
			<div id="communityInfoChange-right">
				<span>社团简介：</span>
				<textarea name="description">${club.description }</textarea>
			</div>
			<div id="communityInfoChange-bottom"><!-- 
				<input type="submit" value="确认修改" name="submit" > -->
				<input id="btn_submit" type="button" value="确认修改" />
			</div>
		</form>
		<script>		
			$('#btn_submit').click(function(){
				$.ajax({ 
                    url:basePath+"/jsp/updateClubMessage.do", 
                    type:'POST', 
                    data:$("form").serialize(),
                    success: function(data){
                    	alert('success');
            			$("#page-inner").html(data);
                    },
                    error: function(data){
                        alert("fail");
                    }
                }); 
			});
	
		</script>
	</div>
</body>
</html>