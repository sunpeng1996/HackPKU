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
								超期房屋预警
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">


								<!-- #modal-dialog-del -->



								<table class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<tr>
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
												权属有效期止
											</th>
										</tr>
									</thead>
									<tbody>



										<c:forEach items="${houseList }" var="h" varStatus="s">
											<tr>
												
												<td>
													${h.hid }
												</td>
												<td>
													${h.fybh }
												</td>
												<td>
													${h.usage }
												</td>
												<td>
													${h.floor }
												</td>
												<td>
													${h.fanghao }
												</td>
												<td>
													${h.owner_name }
												</td>
												<td>
													<font color = 'red'>${h.date_end }</font>
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
