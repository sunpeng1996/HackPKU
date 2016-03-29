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
		var ckbs = $("input[name=delCheckBox]:checked");
		if(ckbs.size()==0){
			alert("请至少选择一条信息");
		} else {
			$.ajax({
				type : "POST",  
			    url : "<%=path%>/menu/delMenu",
				data : $('#form1').serialize(),
				success : function(data) {
					if (data == "notOk") {
						alert("系统错误，请联系管理员!");
					}
					location = location;
				}
			});
		}
	}
</script>
</head>
<body>
	<form action="<%=path%>/menu/menuList" method="post" id="form1" name="form1">
		<input type="hidden" id="currentPage" name="currentPage" value="1" />
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-inverse">
					<div class="panel-heading">
						<h4 class="panel-title">菜单管理</h4>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<div class="dataTables_filter">
								<label> 菜单名称：<input name="s_menu_name" id="s_menu_name" value="${pageBean.paramMap.s_menu_name }" type="search" class="" placeholder="" aria-controls="data-table" /> 
								<a class="btn btn-success btn-sm" href="javascript:$('#form1').submit();"><i class="fa fa-search"></i> </a>
								</label>
							</div>
							<p>
								<a class="btn btn-sm btn-success" href="<%=path%>/menu/toAddMenu"><i class="fa fa-plus"></i> 添加</a> 
								<a data-toggle="modal" class="btn btn-sm btn-success" href="javascript:delByCheckBox();"><i class="fa fa-times"></i>删除</a>
							</p>
							<table class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<tr>
										<th width="3"><input name="" type="checkbox" value="" id="controlAll" onclick="javascript:selectAll();" /></th>
										<th width="60">序号</th>
										<th width="">菜单名称</th>
										<th width="">菜单路径</th>
										<th width="">菜单等级</th>
										<th width="">父级菜单</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageBean.list }" var="v" varStatus="s">
										<tr>
											<td><input name="delCheckBox" type="checkbox" value="${v.id }" /></td>
											<td>${(pageBean.currentPage-1)*pageBean.pageSize+s.index+1 }</td>
											<td>${v.menuname }</td>
											<td>${v.menuurl }</td>
											<td><c:if test="${v.isfather eq '1'}">根目录</c:if><c:if test="${v.isfather eq '2'}">子目录</c:if></td>
											<td>${v.pname }</td>
											<td>
												<a href="<%=path %>/menu/toUpdateMenu?sta=&id=${v.id }"><i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp; 
												<!-- <a href="<%=path %>/menu/toUpdateMenu?sta=view&MENU_ID=${v.MENU_ID }"><i class="fa fa-arrow-circle-o-right"></i></a> -->
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
			</div>
		</div>
	</form>
</body>
</html>
