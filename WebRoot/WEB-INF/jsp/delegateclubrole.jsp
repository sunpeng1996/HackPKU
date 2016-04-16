
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
	
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团管理 >> 社团角色分配</span>
		</nav>
		<div id="communityPosChange">
			<table>
				<tr>
					<th>姓名</th>
					<th>职位</th>
					<th>确认</th>
				</tr>
    			 <c:forEach items="${clubmembers }" var="clubmember">
					<tr>
						<td>${clubmember.user.username }</td>
						<td>
							<select   name="roleId" >
					     	   <c:forEach items="${roles }"  var="role" >
					     		  <option value="${role.roleId }"   <c:if test="${clubmember.role.roleId == role.roleId }">selected="selected"</c:if>>${role.rolename }</option>
					     	   </c:forEach>
					     	</select>
						</td>
						<td>
							<button id="btn_pchg_${clubmember.user.userId }" onclick="btn_pchg_click(this)">修改</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			 <script type="text/javascript">
			 	var btn_pchg_click = function(data){
			 		var userId = $(data).attr('id').replace('btn_pchg_','');
			 		var roleId = $(data).parent().parent().find("select[name='roleId']").val();
			 		$.ajax({ 
			            url:basePath + "/editUserRole.do", 
			            type:'GET', 
			            data:{
			            	roleId:roleId,
			            	userId:userId
			            },
			            success: function(data){ 
			            	alert('success');
			            	$("#page-inner").html(data);
			            },
			            error: function(data){
			                alert("gg");
			            }
			        }); 
			 	}
			 </script>
		</div>
	</div>
</body>
</html>