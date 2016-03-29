<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/common/common.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>




		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
			function tj(){
				var errorstr='';
				var err_po='提交失败，原因如下：\n\n';
				var ei=0;
				if($("#username").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.用户姓名不能为空\n';
				}
				if($("#loginname").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.登录名不能为空\n';
				}
				if($("#loginpass").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.密码不能为空\n';
				}
				if($("#LOGIN_PASS_1").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.确认密码不能为空\n';
				}
				if($("#loginpass").val()!=$("#LOGIN_PASS_1").val()){
					ei++;errorstr=errorstr+ei+'.两次密码不一致\n';
				}
				if($("#role_id").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.用户角色不能为空\n';
				}
				if($("#loginname").val().trim()!='' && $("#id").val().trim()==''){
					$.ajax({type : "POST",  
					   async: false,
				       url : "<%=path%>/user/searchYhm",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           if(data=="n"){
				        	  ei++;errorstr=errorstr+ei+'.登录名不能重复\n';
				           }
				       }  
					});
				}
				
				if(errorstr.length>0){
					alert(err_po+errorstr);
				}
				if(errorstr.length==0){
					$.ajax({type : "POST",  
				       url : "<%=path%>/user/editUser",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           if(data=="notOk"){
				        	   alert("系统错误，请联系管理员!");
				           }else{
				           	  window.location.href="<%=path%>/user/userList";
				           }
				       }  
					});
				}
			}
	
	
	$(function(){
					
					jQuery("#role_id").empty();
					$.ajax({type : "POST",  
				       url : "<%=path %>/user/getRoleForSelect",   
				       async: false,
				       dataType:'json',
				       data:$('#form1').serialize(),	   
				       success : function (data){  
				       		jQuery("<option value=''>请选择</option>").appendTo("#role_id");
				       		for(var i=0;i<data.length;i++){
				       			jQuery("<option value='"+data[i].id+"'>"+data[i].rolename+"</option>").appendTo("#role_id");
				       		}
				         	
				       }  
					});
					
					$("#role_id").val("${map.role_id}");
					$("#sex").val("${map.sex}");
			});
	
	</script>

	</head>
	<body>
		
		<form name="form1" id="form1" method="post" class="form-horizontal">
		<input type="hidden" id="id" name="id" <c:if test="${map==null }">value="0"</c:if>  <c:if test="${map!=null }">value="${map.id }"</c:if> />
			<!-- end breadcrumb -->
			<!-- begin page-header -->
			<h1 class="page-header">信息编辑</h1>
			<!-- end page-header -->
			
			<!-- begin row -->
			<div class="row">
              
			    <div class="col-md-7" style="width: 100%;">
			        <!-- begin panel -->
                    <div class="panel panel-inverse" data-sortable-id="form-stuff-1">
                        <div class="panel-heading">
							<h4 class="panel-title">用户管理</h4>
						</div>
                        <div class="panel-body" style="margin-right:30%">
                           
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 用户姓名：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="username" id="username" value="${map.username }"class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 登录名：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="loginname" id="loginname" value="${map.loginname }"  <c:if test="${map!=null }">readonly</c:if> class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 密码：</label>
                                    <div class="col-md-9">
                                        <input type="password" name="loginpass" id="loginpass" value="${map.loginpass }"class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 确认密码：</label>
                                    <div class="col-md-9">
                                        <input type="password" name="LOGIN_PASS_1" id="LOGIN_PASS_1" value="${map.loginpass }" class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 角色：</label>
                                    <div class="col-md-9">
                                        <select class="form-control" style="width: 40%;" id="role_id" name="role_id">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red"></span> 电话：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="phone" id="phone" value="${map.phone }" class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red"></span> 邮箱：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="email" id="email" value="${map.email }" class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red"></span> 性别：</label>
                                    <div class="col-md-9">
                                       <select class="form-control" style="width: 40%;" id="sex" name="sex">
                                       		<option value="男">男</option>
                                       		<option value="女">女</option>                                       		
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red"></span> 备注：</label>
                                    <div class="col-md-9">
                                         <textarea name="remark" id="remark" class="form-control"  rows="5">${map.remark }</textarea>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                    <c:if test="${sta!='view' }">
                                    	<a class="btn btn-sm btn-success" onclick="javascript:tj();"><i class="fa "></i>提交</a>
                                    </c:if>
                                    	<a class="btn btn-sm btn-success" href="<%=path %>/user/userList"><i class="fa "></i>返回</a>
                                    </div>
                                </div>
                           
                        </div>
                    </div>
                    <!-- end panel -->
                </div>
              
 
            </div>
            <!-- end row -->

</form>
		
	</body>
</html>
