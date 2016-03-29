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
								分楼宇2015同比增长情况统计
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<c:forEach items="${bMes }" var="ent">
								<!-- #modal-dialog-del -->
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th width="100">
												楼宇(单位：万)
											</th>
											<th>
												年份
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
										<c:forEach items="${ent.value }" var="v">
											<tr>
												<td>
													${v.bname }
												</td>
												<td>
													${v.year }
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.jan < 0 ? -v.jan:v.jan) < 0.000001 or (v.jan + 100 < 0 ? -v.jan -100:v.jan +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.jan }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.jan < 0 }">
																		<font color="green">${v.jan }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.jan }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.feb < 0 ? -v.feb:v.feb) < 0.000001 or (v.feb + 100 < 0 ? -v.feb -100:v.feb +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.feb }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.feb < 0 }">
																		<font color="green">${v.feb }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.feb }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.mar < 0 ? -v.mar:v.mar) < 0.000001 or (v.mar + 100 < 0 ? -v.mar -100:v.mar +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.mar }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.mar < 0 }">
																		<font color="green">${v.mar }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.mar }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.apri < 0 ? -v.apri:v.apri) < 0.000001 or (v.apri + 100 < 0 ? -v.apri -100:v.apri +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.apri }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.apri < 0 }">
																		<font color="green">${v.apri }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.apri }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.may < 0 ? -v.may:v.may) < 0.000001 or (v.may + 100 < 0 ? -v.may -100:v.may +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.may }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.may < 0 }">
																		<font color="green">${v.may }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.may }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.june < 0 ? -v.june:v.june) < 0.000001 or (v.june + 100 < 0 ? -v.june -100:v.june +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.june }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.june < 0 }">
																		<font color="green">${v.june }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.june }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												
												<td>
													<c:choose>
														<c:when test="${(v.july < 0 ? -v.july:v.july) < 0.000001 or (v.july + 100 < 0 ? -v.july -100:v.july +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.july }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.july < 0 }">
																		<font color="green">${v.july }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.july }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.aug < 0 ? -v.aug:v.aug) < 0.000001 or (v.aug + 100 < 0 ? -v.aug -100:v.aug +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.aug }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.aug < 0 }">
																		<font color="green">${v.aug }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.aug }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.sept < 0 ? -v.sept:v.sept) < 0.000001 or (v.sept + 100 < 0 ? -v.sept -100:v.sept +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.sept }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.sept < 0 }">
																		<font color="green">${v.sept }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.sept }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.oct < 0 ? -v.oct:v.oct) < 0.000001 or (v.oct + 100 < 0 ? -v.oct -100:v.oct +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.oct }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.oct < 0 }">
																		<font color="green">${v.oct }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.oct }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.nov < 0 ? -v.nov:v.nov) < 0.000001 or (v.nov + 100 < 0 ? -v.nov -100:v.nov +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.nov }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.nov < 0 }">
																		<font color="green">${v.nov }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.nov }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
												<td>
													<c:choose>
														<c:when test="${(v.dec < 0 ? -v.dec:v.dec) < 0.000001 or (v.dec + 100 < 0 ? -v.dec -100:v.dec +100) < 0.000001}">
															<font color="blue">--------</font>
														</c:when>
														<c:otherwise>
														<c:choose>
															<c:when test="${v.year != null }">${v.dec }</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${v.dec < 0 }">
																		<font color="green">${v.dec }%</font>
																	</c:when>
																	<c:otherwise>
																		<font color="red">+${v.july }%</font>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
										</c:forEach>
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
