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
								房产查询
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">



								<div class="dataTables_filter">
									<label>
										房产所有人：<input name="owner_name" id="owner_name" value=""type="search" class="" placeholder="" aria-controls="data-table"/>
										<a class="btn btn-success btn-sm" href="javascript:$('#form1').submit();"><i class="fa fa-search"></i> </a>
									</label>
									<label>
										使用人：<input name="user_name" id="user_name" value=""type="search" class="" placeholder="" aria-controls="data-table"/>
									</label>
									<label>
										出租人：<input name="rental_name" id="rental_name" value=""type="search" class="" placeholder="" aria-controls="data-table"/>
									</label>
								</div>

								
								<!-- #modal-dialog-del -->



								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr><!-- 
											<th>
												序号
											</th> -->
											<th width="">
												楼宇号
											</th>
											<th width="">
												房屋序号
											</th>
											<th width="">
												使用人
											</th>
											<th width="">
												出租人
											</th>
											<th width="">
												所有人
											</th>
											<th width="">
												使用类型
											</th>
										</tr>
									</thead>
									<tbody>



										<c:forEach items="${pageBean.list }" var="v" varStatus="s">
											<tr><%--
												<td>
													 ${(pageBean.currentPage-1)*pageBean.pageSize+s.index+1 }
												</td> --%>
												<td>
													${v.th_lyid }
												</td>
												
												<td>
													<a href="<%=path %>/role/fwList?s_role_name=${v.th_id }">${v.th_id }</a>
												</td>
												<td>
													<c:choose>
														<c:when test="${v.user_idtype == 1 }">
															<a href="<%=path %>/gio/taxList?tax_id=${v.user_id }">${v.user_name }</a>
														</c:when>
														<c:otherwise>
															${v.user_name }
														</c:otherwise>
													</c:choose>
												</td>
												
												<td>
													<c:choose>
														<c:when test="${v.rental_idtype == 1 }">
															<a href="<%=path %>/gio/taxList?tax_id=${v.rental_id }">${v.rental_name }</a>
														</c:when>
														<c:otherwise>
															${v.rental_name }
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${v.owner_idtype == 1 }">
															<a href="<%=path %>/gio/taxList?tax_id=${v.owner_id }">${v.owner_name }</a>
														</c:when>
														<c:otherwise>
															${v.owner_name }
														</c:otherwise>
													</c:choose>
												</td>
												
												<td>
													${v.usage_type }
												</td>
											</tr>
										</c:forEach>







									</tbody>
								</table>



								<jsp:include page="/view/common/page.jsp">
									<jsp:param name="formId" value="form1" />
								</jsp:include>




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
