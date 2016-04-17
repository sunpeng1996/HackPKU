<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>社团日志</title>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团日志</span>
		</nav>
		<div id="taskCommon">
			<table>
				<tr>
						<td>
							<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal">提交form表单如何让页面在提交后不发生跳转-CSDN论坛-CSDN.NET-...</a>
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
					        <div class="modal-dialog">  
					        	<div class="modal-content">  
					                <div class="modal-header">  
					               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
					                	<h4 class="modal-title">日志详情</h4>  
					                </div>  
					                <div class="modal-body"> 
					                	<div>呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵我擦了我擦了我擦了我擦了我擦了我擦我查我草我擦我我</div>
					                </div> 
					                <div class="modal-footer">  
					                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">关闭</button>
					                </div>  
					            </div><!-- /.modal-content -->  
					        </div><!-- /.modal-dialog -->  
					    </div><!-- /.modal -->
						</td>
						<td>
							<span><i>2016-04-15</i></span>
						</td>
				</tr>
				<tr>
					<td>
						<a href="javascript:void(0);" data-toggle="modal" data-target="#myModal">
							为此，360网站卫士推出一项字体加速服务，站长只要修改一行代码，就可以免费使用到由360网站卫士CDN加速的字体服务。
						</a>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
					        <div class="modal-dialog">  
					        	<div class="modal-content">  
					                <div class="modal-header">  
					               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
					                	<h4 class="modal-title">日志详情</h4>  
					                </div>  
					                <div class="modal-body"> 
					                	<div>呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵我擦了我擦了我擦了我擦了我擦了我擦我查我草我擦我我</div>
					                </div> 
					                <div class="modal-footer">  
					                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">关闭</button>
					                </div>  
					            </div><!-- /.modal-content -->  
					        </div><!-- /.modal-dialog -->  
					    </div><!-- /.modal -->
					</td>
					<td>
						<span><i>2016-04-15</i></span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	  <!-- Bootstrap Js -->
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script> 
    <script type="text/javascript">
    	(function () {
			$("a[data-toggle='modal']").bind("click",function() {
				var trs = $("#pageInfo").find("#taskCommon").find("table").children();
				// var father = $(this).parent();
				// var target = father.find("#myModal");
				// target.attr("class","target-Modal");
				trs.each(function() {
					trs.find("#myModal").removeAttr("id","myModal");
				});
			});
		})();
    </script>
</body>
</html>