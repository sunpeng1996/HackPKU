<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="com.common.Util"/>
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
				if($("#lymc").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.楼宇名称不能为空\n';
				}
				if($("#lyzts").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.楼宇总套数不能为空\n';
				}
				if($("#lydz").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.楼宇坐落地址不能为空\n';
				}
				if($("#swjg_id").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.所属税务机关不能为空\n';
				}
				if($("#xzqh").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.行政区划不能为空\n';
				}
				if($("#fwscjx").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房屋所处街乡不能为空\n';
				}
				
				
				if(errorstr.length>0){
					alert(err_po+errorstr);
				}
				if(errorstr.length==0){
					$.ajax({type : "POST",  
				       url : "<%=path%>/role/editLy",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           if(data=="notOk"){
				        	   alert("系统错误，请联系管理员!");
				           }else{
				           	  window.location.href="<%=path%>/role/lyList";
				           }
				       }  
					});
				}
			}
			
			$(function(){
				$("#swjg_id").val('${map.swjg_id}');
				$("#xzqh").val('${map.xzqh}');
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
							<h4 class="panel-title">楼宇信息管理</h4>
						</div>
                        <div class="panel-body" style="margin-right:30%">
                           
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 楼宇名称：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="lymc" id="lymc" value="${map.lymc }"class="form-control"  style="width: 60%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 楼宇总套数：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="lyzts" id="lyzts" value="${map.lyzts }"class="form-control"  style="width: 60%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 楼宇坐落地址：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="lydz" id="lydz" value="${map.lydz }"class="form-control"  style="width: 60%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 所属税务机关：</label>
                                    <div class="col-md-9">
                                         <select class="form-control" style="width: 60%;" id="swjg_id" name="swjg_id">
                                         	<%=Util.getOption("select id,jgmc from t_swjg") %>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 行政区划：</label>
                                    <div class="col-md-9">
                                        <select class="form-control" style="width: 60%;" id="xzqh" name="xzqh">
                                         	<%=Util.getOption("select id,xzqhmc from t_xzqh") %>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"><span style="color: red">*</span> 房屋所处街乡：</label>
                                    <div class="col-md-9">
                                        <input type="text" name="fwscjx" id="fwscjx" value="${map.fwscjx }"class="form-control"  style="width: 60%;"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                    	<a class="btn btn-sm btn-success" onclick="javascript:tj();"><i class="fa "></i>提交</a>
                                    	<a class="btn btn-sm btn-success" href="<%=path %>/role/lyList"><i class="fa "></i>返回</a>
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
