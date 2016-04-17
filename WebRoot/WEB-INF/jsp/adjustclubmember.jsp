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
			<span>社团管理 >> 社团成员调整</span>
			<a href="javascript:void(0);" id="edit-Info" data-toggle="modal" data-target="#myModal"><i class="fa fa-envelope">&nbsp;</i>申请&nbsp;<span id="requestNum">3</span>&nbsp;条</a>
		</nav>
		<div id="communityMemChange">
			<table border="1px">
				<tr>
					<th>姓名</th>
					<th>职位</th>
					<th>操作</th>
				</tr>
				
       	  		<c:forEach items="${clubMembership }" var="clubMember">
					<tr>
						<td>${clubMember.user.username }</td>
	       				<td>${clubMember.role.rolename }</td>
						<td><a id="a_${clubMember.user.userId }" name="a_${clubMember.role.roleId }" onclick="kick(this)" href="javascript:void(0);">踢</a></td> 
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
        <div class="modal-dialog">  
        	<div class="modal-content">  
                <div class="modal-header">  
               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
                	<h4 class="modal-title">申请审批</h4>  
                </div>  
                <div class="modal-body">  
       				<c:forEach items="${requests }" var="request" varStatus="vs">
       					<form action="" method="post"  onsubmit="return false;">
							<div class="requestMem" >
								<span>${request.user.username }</span>
								<span>	
									<select  name="roleId" >
								     	  <c:forEach items="${roles }"  var="role" >
								     		  <option value="${role.roleId }"  >${role.rolename }</option>
								     	   </c:forEach>
								    </select>
								    <input type="hidden" name="userId" value="${request.user.userId }"/>
								</span>
								<span>&nbsp;&nbsp;</span>
								<span><button id="btn_agree_${request.user.userId }" class="btn btn-primary btn-sm" onclick="agree(this)">同意</button></span>
								<span>&nbsp;&nbsp;</span>
								<span><button id="btn_reject_${request.user.userId }" class="btn btn-primary btn-sm" onclick="reject(this)">拒绝</button></span>
								<span>        分配职位:</span>
							</div>
						</form>
       				</c:forEach>
                </div> 
                <div class="modal-footer">  
                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">确认</button>
                </div>  
            </div><!-- /.modal-content -->  
        </div><!-- /.modal-dialog -->  
    </div><!-- /.modal --> 
    <!-- Bootstrap Js -->
    <script>
    	function agree(btn){
    		var data = $(btn).parent().parent().parent().serialize();
			$.ajax({ 
                   url:basePath+"/addClubMember.do", 
                   type:'POST', 
                   data:data,
                   success: function(data){
                   		alert(data);
                   		$(btn).parent().parent().parent().remove();
                   		calcTotalRequest();
                   },
                   error: function(data){
                       alert("fail");
                   }
            }); 
    	}
    	function reject(btn){
    		var data = $(btn).parent().parent().parent().serialize();
			$.ajax({ 
                   url:basePath+"/rejectRequest.do", 
                   type:'POST', 
                   data:data,
                   success: function(data){
                   		alert(data);
                   		$(btn).parent().parent().parent().remove();
                   		calcTotalRequest();
                   },
                   error: function(data){
                       alert("fail");
                   }
            }); 
    	}
    	function calcTotalRequest(){
    		$.ajax({ 
                   url:basePath+"/calcTotalRequest.do", 
                   type:'POST', 
                   success: function(data){
			    	   $('#requestNum').html(function(){return data;});
                   },
                   error: function(data){
                       alert("fail");
                   }
            }); 
    	}
    	calcTotalRequest();
    	function kick(a){
    		var userId = $(a).attr('id').replace('a_','');
    		var roleId = $(a).attr('name').replace('a_','');
    		$.ajax({ 
                   url:basePath+"/kickClubMember.do", 
                   type:'GET', 
                   data:{
                   	   userId:userId,
                   	   roleId:roleId
                   },
                   success: function(data){
                   		alert('success');
                   		$(a).parent().parent().remove();
                   },
                   error: function(data){
                       alert("fail");
                   }
            }); 
    		
    	}
    </script>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
</body>
</html>