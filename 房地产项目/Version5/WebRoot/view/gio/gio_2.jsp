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
		       url : "<%=path%>/rental/delRentalno",   
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
		<form action="<%=path%>/gio/queryHouseMesByNames" method="post" id="form1" name="form1">
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
								分楼宇房产信息统计
								</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								
								<!-- #modal-dialog-del -->


							<c:forEach items="${bsList }" var="v">
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr><!-- 
											<th>
												序号
											</th> -->
											<th width="">
												楼宇
											</th>
											<c:forEach items="${v.houseUsage }" var="ent">
												<th width="">
													${ent.key }											
												</th>
											</c:forEach>
										</tr>
									</thead>
									<tbody>

										<tr>
											<td>
												${v.building.bname }
											</td>
												<c:forEach items="${v.houseUsage }" var="entry" varStatus="s">
													<td>
														 ${entry.value }%
													</td>
												</c:forEach> 
											</tr>
									</tbody>
								</table>


							</c:forEach>


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
