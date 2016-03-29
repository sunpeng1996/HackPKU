<%@ page language="java" import="java.util.*,com.common.*" pageEncoding="UTF-8"%>
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
				if($("#data_2").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房号不能为空\n';
				}
				if($("#data_6").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.使用者名称不能为空\n';
				}
				if($("#data_7").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.使用者证件类型不能为空\n';
				}
				if($("#data_9").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.使用类型不能为空\n';
				}
				if($("#data_11").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.使用者是否征收房产税不能为空\n';
				}
				if($("#data_12").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.征收品目不能为空\n';
				}
				if($("#data_13").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产原值不能为空\n';
				}
				if($("#data_14").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.免税原值不能为空\n';
				}
				if($("#data_15").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.应税原值不能为空\n';
				}
				if($("#data_16").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.有效期起不能为空\n';
				}
				if($("#data_17").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.有效期止不能为空\n';
				}
				if($("#data_19").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产税纳税人不能为空\n';
				}
				if($("#data_20").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产税纳税人证件类型不能为空\n';
				}
				if($("#data_21").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.房产税纳税人证件号码不能为空\n';
				}
				if($("#data_22").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.年应纳税额不能为空\n';
				}
				if($("#data_23").val().trim()==''){
					ei++;errorstr=errorstr+ei+'.纳税期限不能为空\n';
				}
				
				
				
				if(errorstr.length>0){
					alert(err_po+errorstr);
				}
				if(errorstr.length==0){
					$.ajax({type : "POST",  
				       url : "<%=path%>/rental/editRentalno",   
				       data:$('#form1').serialize(),
				       success : function (data){  
				           
				           	 window.location.href="<%=path%>/rental/rentalnoList";
				           
				       }  
					});
				}
			}
	
			$(function(){
				$("#data_2").val('${map.data_2}');
				$("#data_7").val('${map.data_7}');
				$("#data_9").val('${map.data_9}');
				$("#data_20").val('${map.data_20}');
				$("#data_12").val('${map.data_12}');
				$("#data_11").val('${map.data_11}');
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
							<h4 class="panel-title">房屋使用(非出租)信息管理</h4>
						</div>
                        <div class="panel-body" style="margin-right:30%">
                           
                                <div class="form-group" style="margin-left: 4px;">
                                 	<table class="table table-striped table-bordered table-hover table-condensed" style="width: 140%">
                                 		<tr>
                                 			<td><span style="color: red;">*</span>房号：</td>
                                 			<td>
                                 				<select id="data_2" name="data_2">
                                 					<%=Util.getOption("select id,data_5 from t_house order by id") %>
                                 				</select>
                                 			</td> 
                                 			<td></td>
                                 			<td></td>
                                 			<td></td>
                                 			<td></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>使用者名称：</td>
                                 			<td><input type="text" size="25" id="data_6" name="data_6" value="${map.data_6 }"/></td> 
                                 			<td><span style="color: red;">*</span>使用者证件类型：</td>
                                 			<td>
                                 				<select id="data_7" name="data_7">
                                 					<%=Util.getOption("select id,cardname from t_card order by id") %>
                                 				</select>
                                 			</td>
                                 			<td>使用者证件号码：</td>
                                 			<td><input type="text" size="25" id="data_8" name="data_8" value="${map.data_8 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>使用类型：</td>
                                 			<td>
                                 				<select id="data_9" name="data_9">
                                 					<option value="">请选择</option>
                                 					<%
                                 						Util u = new Util();
                                 						String[]  sylx = u.getProperties("sylx").split(",");
                                 						for(String a:sylx){
                                 							out.print("<option value='"+a+"'>"+a+"</option>");
                                 						}
                                 					%>
                                 					
                                 				</select>
                                 				
                                 			</td> 
                                 			<td>使用面积：</td>
                                 			<td><input type="text" size="25" id="data_10" name="data_10" value="${map.data_10 }"/></td>
                                 			<td><span style="color: red;">*</span>使用者是否征收房产税：</td>
                                 			<td>
                                 				<select id="data_11" name="data_11">
                                 					<option value="是">是</option>
                                 					<option value="否">否</option>
                                 				</select>
                                 			</td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>征收品目：</td>
                                 			<td>
                                 				<select id="data_12" name="data_12">
                                 					<option value="">请选择</option>
                                 					<option value="生产用房">生产用房</option>
                                 					<option value="营业用房">营业用房</option>
                                 					<option value="办公用房">办公用房</option>
                                 					<option value="职工用房">职工用房</option>
                                 				</select>
                                 			</td> 
                                 			<td></td>
                                 			<td></td>
                                 			<td></td>
                                 			<td></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>房产原值（元）：</td>
                                 			<td><input type="text" size="25" id="data_13" name="data_13" value="${map.data_13 }"/></td> 
                                 			<td><span style="color: red;">*</span>免税原值（元）：</td>
                                 			<td><input type="text" size="25" id="data_14" name="data_14" value="${map.data_14 }"/></td>
                                 			<td><span style="color: red;">*</span>应税原值（元）：</td>
                                 			<td><input type="text" size="25" id="data_15" name="data_15" value="${map.data_15 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>有效期起：</td>
                                 			<td><input type="text" size="25" id="data_16" name="data_16" value="${map.data_16 }" onClick="WdatePicker({readOnly:true})"/></td> 
                                 			<td><span style="color: red;">*</span>有效期止：</td>
                                 			<td><input type="text" size="25" id="data_17" name="data_17" value="${map.data_17 }" onClick="WdatePicker({readOnly:true})"/></td>
                                 			<td>备注：</td>
                                 			<td><input type="text" size="25" id="data_18" name="data_18" value="${map.data_18 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>房产税纳税人：</td>
                                 			<td><input type="text" size="25" id="data_19" name="data_19" value="${map.data_19 }"/></td> 
                                 			<td><span style="color: red;">*</span>房产税纳税人证件类型：</td>
                                 			<td>
                                 				<select id="data_20" name="data_20">
                                 					<%=Util.getOption("select id,cardname from t_card order by id") %>
                                 				</select>
                                 			</td>
                                 			<td><span style="color: red;">*</span>房产税纳税人证件号码：</td>
                                 			<td><input type="text" size="25" id="data_21" name="data_21" value="${map.data_21 }"/></td>                                			
                                 		</tr>
                                 		<tr>
                                 			<td><span style="color: red;">*</span>年应纳税额（元）：</td>
                                 			<td><input type="text" size="25" id="data_22" name="data_22" value="${map.data_22 }"/></td> 
                                 			<td><span style="color: red;">*</span>纳税期限：</td>
                                 			<td><input type="text" size="25" id="data_23" name="data_23" value="${map.data_23 }"/></td>
                                 			<td></td>
                                 			<td></td>                                			
                                 		</tr>
                                 	</table>
                                 </div>
                                
                                <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-9">
                                    	<a class="btn btn-sm btn-success" onclick="javascript:tj();"><i class="fa "></i>提交</a>
                                    	<a class="btn btn-sm btn-success" href="<%=path %>/rental/rentalnoList"><i class="fa "></i>返回</a>
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
