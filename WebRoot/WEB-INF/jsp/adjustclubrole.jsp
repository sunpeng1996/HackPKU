<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			<span>社团管理 >> 社团角色管理</span>
		</nav>
		<div id="communityPosManage">
			<div class="communityPosManageDiv">
				<form action="">
					<div class="input">
						<input type="text" name="rolename" value="" placeholder="请输入角色名称">
					</div>
					<div class="textarea">
						<textarea name="description" placeholder="请输入角色描述"></textarea>
					</div>
					<div class="button">
						<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal" name="menu_ids" onclick="getPrlg(this)">权限分配/确认</a>
						<input type="button" name="delete" value="删除">
					</div>
				</form>
			</div>
			
			<c:forEach items="${roles}" var="role">
				 <div class="communityPosManageDiv">
					<form action="updateRole.do" id="form_role_${role.roleId }" method="POST">		
						<input type="hidden" name="roleId" value="${role.roleId }" />
						<div class="input">
							<input type="text" name="rolename" value="${role.rolename }">
						</div>
						<div class="textarea">
							<textarea name="description">${role.description }</textarea>
						</div>
						<div class="button">
							<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal" name="menu_ids" onclick="getPrlg(this)">权限分配/确认</a>
							<input type="button" name="delete" value="删除">
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
		<script type="text/javascript">
		var cur_btn_form;
		function getPrlg(btn){
			var form = $(btn).parent('.button').parent().serialize();
			cur_btn_form = form;
			$.ajax({ 
		        url:basePath+"/getRoleMenu.do", 
		        type:'POST', 
		        data:form,
		        success: function(data){
		           $('#menu_ids_form').find("input").prop('checked',false);
		        	for(var i in data){
		        		$('#menu_ids_form').find("input[value='"+data[i]+"']").prop('checked',true);
		        	}
		        },
		        error: function(data){
		            alert("fail");
		        }
		    }); 
		}
			function update(){
				var menu_ids_form = $('#menu_ids_form').serialize();
				var cmplt_form = menu_ids_form + "&" + cur_btn_form;
				$.ajax({ 
		            url:basePath + "/updateRole.do", 
		            type:'POST', 
		            data:cmplt_form,
		            success: function(data){ 
		            	$('.modal-backdrop').remove();
		            	$("#page-inner").html(data);
		            },
		            error: function(data){
		                alert("gg");
		            }
		        }); 				
			}
		</script>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
	        <div class="modal-dialog">  
	        	<div class="modal-content">  
	                <div class="modal-header">  
	               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
	                	<h4 class="modal-title">权限分配</h4>   
	                </div>  
	                <div class="modal-body"> 
                		<form id="menu_ids_form" action="" method="post">
		                	<c:forEach items="${menus}" var="menu">
	                		
			                	<div class="communityPower">
									<input type="checkbox" name="menu_ids" value="${menu.menuId }"><span>&nbsp;${menu.menuname }</span>
								</div> 
		                	</c:forEach>					
						</form>
	                </div> 
	                <div class="modal-footer">  
	                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal" onclick="update()">确认</button>
	                </div>  
	            </div><!-- /.modal-content -->  
	        </div><!-- /.modal-dialog -->  
	    </div><!-- /.modal -->
		<div class="communityPosManageAdd">
			<i class="fa fa-plus"></i>
		</div>
	</div>
	  <!-- Bootstrap Js -->
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
    <script type="text/javascript">
    	(function () {
			$(".communityPosManageAdd").click(function() {
				$("#pageInfo").find("#communityPosManage").append($(".communityPosManageDiv:first-child").clone());
			});
		})();
    </script>
</body>
</html>