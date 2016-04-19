<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>任务评分</title>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团活动 >> 任务评分</span>
		</nav>
		<div id="taskCommon">
			<table>
			<c:forEach items="${events}" var="event">
				<tr>
					<form  id="form_role_${event.task_id }">
					  
						<input type="hidden" name="task_id" value="${event.task_id }" />
						<td>
						<a href="javascript:void(0);" data-toggle="modal" data-target="#myModal">
							${event.taskname  }
						</a>
						<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
					        <div class="modal-dialog">  
					        	<div class="modal-content">  
					                <div class="modal-header">  
					               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
					                	<h4 class="modal-title">任务评分</h4>  
					                	<input type="text" name="totalscore" disabled="disabled" value="总分为:${event.totalscore  }">
					                </div>  
					                <div class="modal-body"> 
					                	<c:forEach items="${event.ptcs}" var="ptc">
					                	<div class="scores">
					                		<span>${ptc.username }</span>
					                		<input type="text" name="scores">
					                	</div>
					                	</c:forEach>
					                </div> 
					                <div class="modal-footer">  
					                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">确认</button>
					                </div>  
					            </div><!-- /.modal-content -->  
					        </div><!-- /.modal-dialog -->  
					    </div><!-- /.modal -->
					</td>
					<td>
						<input type="submit" name="submit" value="提交">
					</td>
					</form>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	  <!-- Bootstrap Js -->
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
    <script type="text/javascript">
    	(function () {
			$("a[data-toggle='modal']").click(function() {
				var trs = $("#pageInfo").find("#taskCommon").find("table").children();
				var father = $(this).parent();
				var target = father.find(".modal");
				trs.each(function() {
					trs.find("#myModal").removeAttr("id","myModal");
				});
				target.attr("id","myModal");
			});
		})();
    </script>
</body>
</html>
			