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
				if($("#rolename").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.角色名称不能为空\n';
				}
				
				if(errorstr.length>0){
					alert(err_po+errorstr);
				}
				if(errorstr.length==0){
					$.ajax({type : "POST",  
				       url : "<%=path%>/role/editRole",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           if(data=="notOk"){
				        	   alert("系统错误，请联系管理员!");
				           }else{
				           	  window.location.href="<%=path%>/role/roleList";
				           }
				           
				       }  
					});
				}
			}
		</script>
	</head>

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
							<h4 class="panel-title">角色管理</h4>
						</div>
                        <div class="panel-body" style="margin-right:30%">
                           
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 角色名称：</label>
                                    <div class="col-md-9">
                                        <input type="text"  name="rolename" id="rolename" value="${map.rolename }"class="form-control"  style="width: 40%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red"></span> 备注：</label>
                                    <div class="col-md-9">
                                         <textarea name="remark" id="remark" class="form-control" rows="5">${map.remark }</textarea>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                    	<a class="btn btn-sm btn-success" onclick="javascript:tj();"><i class="fa "></i>提交</a>
                                    	<a class="btn btn-sm btn-success" href="<%=path %>/role/roleList"><i class="fa "></i>返回</a>
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
