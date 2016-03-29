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
	function submit(){
			$('#form1').submit();
	}
	</script>

	</head>

	<body>
		<form action="<%=path%>/gio/showBuildingTaxCount" method="post" id="form1" name="form1">
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
								分楼宇税收情况统计
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
							
								<div class="dataTables_filter">
									<label>
										年份：<input name="year" id="year" value="0"type="search" class="" placeholder="" aria-controls="data-table"/>
										<a class="btn btn-success btn-sm" href="javascript:submit();"><i class="fa fa-search"></i> </a>
									</label>
								</div>
							
								<!-- #modal-dialog-del -->
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th width="100">
												楼宇(单位：万)
											</th>
											<th width="">
												一月
											</th>
											<th width="">
												二月
											</th>
											<th width="">
												三月
											</th>
											<th width="">
												四月
											</th>
											<th width="">
												五月
											</th>
											<th width="">
												六月
											</th>
											<th width="">
												七月
											</th>
											<th width="">
												八月
											</th>
											<th width="">
												九月
											</th>
											<th width="">
												十月
											</th>
											<th width="">
												十一月
											</th>
											<th width="">
												十二月
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${buildingTaxCountList }" var="v">
											<tr>
												<td>
													${v.bname }
												</td>
												<td>
													${v.jan }
												</td>
												<td>
													${v.feb }
												</td>
												<td>
													${v.mar }
												</td>
												<td>
													${v.apri }
												</td>
												<td>
													${v.may }
												</td>
												<td>
													${v.june }
												</td>
												<td>
													${v.july }
												</td>
												<td>
													${v.aug }
												</td>
												<td>
													${v.sept }
												</td>
												<td>
													${v.oct }
												</td>
												<td>
													${v.nov }
												</td>
												<td>
													${v.dec }
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
