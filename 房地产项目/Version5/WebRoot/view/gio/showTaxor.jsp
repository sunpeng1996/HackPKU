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
	
	
	function delByCheckBox(){
		$.ajax({type : "POST",  
		       url : "<%=path%>/user/delUser",   
		       data:$('#form1').serialize(),
		       success : function (data){  
		           if(data=="notOk"){
		        	   alert("系统错误，请联系管理员!");
		           }
		           location=location;
		       }  
		});
	}
	
	
	
	
	
	
	
	
	
	</script>

	</head>

	<body>
		<form action="<%=path%>/user/userList" method="post" id="form1" name="form1">
			<input type="hidden" id="currentPage" name="currentPage" value="1" />
			<!-- begin breadcrumb -->

			<!-- end breadcrumb -->
			<!-- begin page-header -->

			<!-- end page-header -->

			<!-- begin row -->
			<div class="row">
				<!-- begin col-12 -->
				<div class="col-md-12">
					<!-- begin panel -->
					<div class="panel panel-inverse">
						<div class="panel-heading">

							<h4 class="panel-title">
								纳税人信息显示
							</h4>
						</div>
						<div class="panel-body">
								<button class="btn btn-success btn-sm" onclick = "history.go(-1)">返回</button>
							<div class="table-responsive">
								<!-- #modal-dialog-del -->



								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th width="">
												纳税人识别号
											</th>
											<th width="">
												纳税人名称
											</th>
											<th width="">
												纳税人状态
											</th>
											<th width="">
												课征主体登记类型
											</th>
											<th width="">
												登记注册类型
											</th>
											<th width="">
												国地管户类型
											</th>
											<th width="">
												单位隶属关系
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.tax_id }
												</td>
												<td>
													${v.taxor_name }
												</td>
												<td>
													${v.taxor_state }
												</td>
												<td>
													${v.kzztdjlx }
												</td>
												<td>
													${v.djzclx }
												</td>
												<td>
													${v.gdghlx }
												</td>
												<td>
													${v.dwlsgx }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th>
												行业
											</th>
											<th>
												注册地址	
											</th>
											<th>
												注册地联系电话
											</th>	
											<th>
												生产经营地址
											</th>
											<th>
												生产经营地联系电话
											</th>
											<th>	
												法定代表人姓名
											</th>	
											<th>
												法定代表人身份证号码
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.hy}
												</td>
												<td>
													${v.zcdz }
												</td>
												<td>
													${v.zcdlxdh }
												</td>
												<td>
													${v.scjydz }
												</td>
												<td>
													${v.scjydlxdh }
												</td>
												<td>
													${v.fddbrxm }
												</td>
												<td>
													${v.fddbrsfzh }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
									
 								
 								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th>
												登记日期
											</th>
											<th>
												主管税务机关
											</th>
											<th>
												主管税务所（科、分局）
											</th>	
											<th>
												税收管理员
											</th>
											<th>
												街道乡镇
											</th>
											<th>	
												营改增纳税人类型
											</th>	
											<th>
												经营范围
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.djrq}
												</td>
												<td>
													${v.zgswjg }
												</td>
												<td>
													${v.zgswk }
												</td>
												<td>
													${v.ssgly }
												</td>
												<td>
													${v.jdxz }
												</td>
												<td>
													${v.ygzsrlx }
												</td>
												<td>
													${v.jyfw }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th>
												会计制度（准则）
											</th>
											<th>
												办证方式
											</th>
											<th>
												核算方式
											</th>	
											<th>
												国有控股类型
											</th>
											<th>
												国有投资比例
											</th>
											<th>	
												自然人投资比例
											</th>	
											<th>
												外资投资比例
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.kjzd}
												</td>
												<td>
													${v.bzfs }
												</td>
												<td>
													${v.hsfs }
												</td>
												<td>
													${v.gykglx }
												</td>
												<td>
													${v.gytzbl }
												</td>
												<td>
													${v.zrrtzbl }
												</td>
												<td>
													${v.wztzbl }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th>
												注册资本</th><th>	投资总额	</th><th>合伙人数</th><th>	总分机构类型	</th><th>跨区财产税主体登记标志	</th>
												<th>批准设立机关	</th><th>
														证照编号
											</th><th>开业设立日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.zczb}
												</td>
												<td>
													${v.tzze }
												</td>
												<td>
													${v.hhrs }
												</td>
												<td>
													${v.zfjglx }
												</td>
												<td>
													${v.kqccsztlx }
												</td>
												<td>
													${v.pzsljg }
												</td>
												<td>
													${v.zzbh }
												</td>
												<td>
													${v.kyslrq }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								
					
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th>
												生产经营期限起</th><th>	生产经营期限止</th><th>有效标志</th><th>登记序号</th><th>录入人</th><th>
													录入日期</th><th>修改人</th><th>修改日期</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.list }" var="v">
											<tr>
												<td>
													${v.date_begin}
												</td>
												<td>
													${v.date_end }
												</td>
												<td>
													${v.yxbz }
												</td>
												<td>
													${v.djxh }
												</td>
												<td>
													${v.lrr }
												</td>
												<td>
													${v.lrrq }
												</td>
												<td>
													${v.xgr }
												</td>
												<td>
													${v.xgrq }
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								


							</div>
						</div>
					</div>
					<!-- end panel -->
				</div>
				<!-- end col-12 -->
			</div>
			<!-- end row -->


		</form>
	</body>
</html>
