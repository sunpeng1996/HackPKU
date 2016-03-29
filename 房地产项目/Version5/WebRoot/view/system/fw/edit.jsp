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
				if($("#data_3").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产使用类型不能为空\n';
				}
				if($("#data_18").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房屋坐落地址不能为空\n';
				}
				if($("#data_2").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.所在楼宇不能为空\n';
				}
				if($("#data_4").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.楼层不能为空\n';
				}
				if($("#data_5").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房号不能为空\n';
				}
				if($("#data_19").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.所属税务机关不能为空\n';
				}
				
				if($("#data_9").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产总原值不能为空\n';
				}
				if($("#data_10").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房屋面积不能为空\n';
				}
				if($("#data_11").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.权属有效期起不能为空\n';
				}
				
				if($("#data_17").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.权属有效期止不能为空\n';
				}
				if($("#data_14").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产证书持有人证件类型不能为空\n';
				}
				if($("#data_15").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产证书持有人证件号码不能为空\n';
				}
				
				
				if(errorstr.length>0){
					alert(err_po+errorstr);
				}
				if(errorstr.length==0){
					$.ajax({type : "POST",  
				       url : "<%=path%>/role/editFw",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           if(data=="notOk"){
				        	   alert("系统错误，请联系管理员!");
				           }else{
				           	  window.location.href="<%=path%>/role/fwList";
				           }
				       }  
					});
				}
			}
			
			$(function(){
				$("#data_16").val('${map.data_16}');
				$("#data_2").val('${map.data_2}');
				$("#data_19").val('${map.data_19}');
				$("#data_20").val('${map.data_20}');
				$("#data_14").val('${map.data_14}');
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
							<h4 class="panel-title">房屋基础信息管理</h4>
						</div>
                        <div class="panel-body" style="margin-right:30%">
                           
                                 
                                 <div class="form-group" style="margin-left: 4px;">
                                 	<table class="table table-striped table-bordered table-hover table-condensed" style="width: 140%">
                                 		<tr>
                                 			<td>房源编号：</td>
                                 			<td><input type="text" size="25" id="data_6" name="data_6" value="${map.data_6 }"/></td> 
                                 			<td>产权证书号：</td>
                                 			<td><input type="text" size="25" id="data_7" name="data_7" value="${map.data_7 }"/></td>
                                 			<td>土地税源编号：</td>
                                 			<td><input type="text" size="25" id="data_8" name="data_8" value="${map.data_8 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			
                                 			<td><span style="color: red;">*</span>房产使用类型：</td>
                                 			<td><input type="text" size="25" id="data_3" name="data_3" value="${map.data_3 }"/></td>
                                 			<td>是否有效：</td>
                                 			<td>
                                 				<select id="data_16" name="data_16">
                                 					<option value="">请选择</option>
                                 					<option value="是">是</option>
                                 					<option value="否">否</option>
                                 				</select>
                                 			</td> 
                                 			<td><span style="color: red;">*</span>房屋坐落地址:</td>
                                 			<td ><input type="text" size="25" id="data_18" name="data_18" value="${map.data_18 }"/></td>                                 			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>所在楼宇：</td>
                                 			<td>
                                 				<select id="data_2" name="data_2">
                                 					<%=Util.getOption("select id,lymc from t_lyjcxx order by id") %>
                                 				</select>
                                 			</td>  
                                 			<td><span style="color: red;">*</span>楼层：</td>
                                 			<td><input type="text" size="25" id="data_4" name="data_4" value="${map.data_4 }"/></td>
                                 			<td><span style="color: red;">*</span>房号：</td>
                                 			<td><input type="text" size="25" id="data_5" name="data_5" value="${map.data_5 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>所属税务机关:</td>
                                 			<td >
                                 				<select id="data_19" name="data_19">
                                 					<%=Util.getOption("select id,jgmc from t_swjg order by id") %>
                                 				</select>
                                 			</td>
                                 			<td>行政区划:</td>
                                 			<td >
                                 				<select id="data_20" name="data_20">
                                 					<%=Util.getOption("select id,xzqhmc from t_xzqh order by id") %>
                                 				</select>
                                 			</td>
                                 			<td>房屋所处街乡:</td>
                                 			<td ><input type="text" size="25" id="data_21" name="data_21" value="${map.data_21 }"/></td>
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>房产总原值（元）：</td>
                                 			<td><input type="text" size="25"  id="data_9" name="data_9" value="${map.data_9 }"/></td> 
                                 			<td><span style="color: red;">*</span>房屋面积（平方米）：</td>
                                 			<td><input type="text" size="25"  id="data_10" name="data_10" value="${map.data_10 }"/></td>
                                 			<td ></td>
                                 			<td ></td>                             			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>权属有效期起：</td>
                                 			<td><input type="text" size="25" id="data_11" name="data_11" value="${map.data_11 }" onClick="WdatePicker({readOnly:true})"/></td>  
                                 			<td><span style="color: red;">*</span>权属有效期止：</td>
                                 			<td><input type="text" size="25" id="data_17" name="data_17" value="${map.data_17 }" onClick="WdatePicker({readOnly:true})"/></td>  
                                 			<td ></td>
                                 			<td ></td>
                                 		</tr>
                                 		<tr>
                                 			<td>房产证书持有人识别号:</td>
                                 			<td ><input type="text" size="25" id="data_12" name="data_12" value="${map.data_12 }"/></td>
                                 			<td>房产证书持有人名称:</td>
                                 			<td ><input type="text" size="25" id="data_13" name="data_13" value="${map.data_13 }"/></td>
                                 			<td ></td>
                                 			<td ></td>
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>房产证书持有人证件类型:</td>
                                 			<td >
                                 				<select id="data_14" name="data_14">
                                 					<%=Util.getOption("select id,cardname from t_card order by id") %>
                                 				</select>
                                 			</td>
                                 			<td><span style="color: red;">*</span>房产证书持有人证件号码:</td>
                                 			<td ><input type="text" size="25" id="data_15" name="data_15" value="${map.data_15 }"/></td>
                                 			<td ></td>
                                 			<td ></td>
                                 		</tr>
                                 	</table>
                                 </div>
                                 
                                 
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                    	<a class="btn btn-sm btn-success" onclick="javascript:tj();"><i class="fa "></i>提交</a>
                                    	<a class="btn btn-sm btn-success" href="<%=path %>/role/fwList"><i class="fa "></i>返回</a>
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
