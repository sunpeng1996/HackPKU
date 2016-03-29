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
	
	
	function delByCheckBox(){
		$.ajax({type : "POST",  
		       url : "<%=path%>/role/delFw",   
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
		<form action="<%=path%>/role/fwList" method="post" id="form1" name="form1">
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
								房屋基础信息管理
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">



								<div class="dataTables_filter">
									<label>
										房号：<input name="s_role_name" id="s_role_name" value="${pageBean.paramMap.s_role_name }"type="search" class="" placeholder="" aria-controls="data-table"/>
										<a class="btn btn-success btn-sm" href="javascript:$('#form1').submit();"><i class="fa fa-search"></i> </a>
									</label>
								</div>

								<p>
									<a class="btn btn-sm btn-success" href="<%=path%>/view/system/fw/edit.jsp"><i class="fa fa-plus"></i> 添加</a>
									
									<a data-toggle="modal" class="btn btn-sm btn-success" href="javascript:delByCheckBox();"><i class="fa fa-times"></i> 删除</a>
								</p>

								<!-- #modal-dialog-del -->



								<table class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
											<th width="3">
												<input name="" type="checkbox" value="" id="controlAll"
													onclick="javascript:selectAll();" />
											</th>
											<th width="60">
												序号
											</th>
											<th width="">
												房源编号
											</th>
											<th width="">
												房产使用类型
											</th>
											<th width="">
												楼层
											</th>
											<th width="">
												房号
											</th>
											<th width="">
												房产证书持有人名称
											</th>
											<th width="">
												权属有效期起
											</th>
											<th width="">
												权属有效期止
											</th>
											<th width="100">
												操作
											</th>
										</tr>
									</thead>
									<tbody>



										<c:forEach items="${pageBean.list }" var="v" varStatus="s">
											<tr>
												<td>
													<input name="delCheckBox" type="checkbox" value="${v.id }" />
												</td>
												<td>
													${(pageBean.currentPage-1)*pageBean.pageSize+s.index+1 }
												</td>
												<td>
													${v.data_6 }
												</td>
												<td>
													${v.usage }
												</td>
												<td>
													${v.data_4 }
												</td>
												<td>
													${v.data_5 }
												</td>
												<td>
													${v.data_13 }
												</td>
												<td>
													${v.data_11 }
												</td>
												<td>
													${v.data_17 }
												</td>
												<td>
												
													<a href="<%=path %>/role/toUpdateFw?id=${v.id }"><i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
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
