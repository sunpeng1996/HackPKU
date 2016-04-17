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
			
			<c:forEach items="${events}" var="event">
				 <div class="communityPosManageDiv">
					<form action="submitEvaAct.do" id="form_role_${event.task_id }" method="POST">		
						<input type="hidden" name="task_id" value="${event.task_id }" />
						<div class="input">
							<input type="text" name="taskname" value="${event.taskname  }">
						</div>
						<div class="textarea">
							<textarea name="summary">${event.summary  }</textarea>
						</div>
						<div class="button">
							<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal" name="event_ids" onclick="getPtcpts(this)">权限分配/确认</a>
							<input type="text" name="totalscore" disabled="disabled" value="总分为:${event.totalscore  }">
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
		<script type="text/javascript">
		var cur_btn_form;
		function getPtcpts(btn){
			/* var form = $(btn).parent('.button').parent().serialize();
			cur_btn_form = form;
			$.ajax({ 
		        url:basePath+"/getRoleMenu.do", 
		        type:'POST', 
		        data:form,
		        success: function(data){
		           $('#event_ids_form').find("input").prop('checked',false);
		        	for(var i in data){
		        		$('#event_ids_form').find("input[value='"+data[i]+"']").prop('checked',true);
		        	}
		        },
		        error: function(data){
		            alert("fail");
		        }
		    });  */
		}
			function update(){
/* 				var event_ids_form = $('#event_ids_form').serialize();
				var cmplt_form = event_ids_form + "&" + cur_btn_form; */
				$.ajax({ 
		            url:basePath + "/submitEvaAct.do", 
		            type:'GET', 
		            data:"task_id=1&scores=2&scores=6",
		            success: function(data){ 
		            	alert(data);
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
                		<form id="event_ids_form" action="" method="post">
		                	<c:forEach items="${menus}" var="menu">
	                		
			                	<div class="communityPower">
									<input type="checkbox" name="event_ids" value="${menu.menuId }"><span>&nbsp;${menu.menuname }</span>
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
	</div>
	  <!-- Bootstrap Js -->
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
</body>
</html>