<%@page import="hit.po.News"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath); 
%>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>社团信息</title>
</head>
<body>
	<div id="pageInfo">
		<nav>
			<span>社团新闻</span>
		</nav>
		<div id="communityNews">
			<table >
				<tr>
					<td>标题</td>
					<td>时间</td>
					<td>发布者</td>
				</tr>
		    <c:forEach items="${newsList }" var="news" > 
		    <%
		    	
		    	Date date = request.getAttribute("");
		    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    	String timeFormat = format.format(date)
		    %>
				<tr>
						<td>
							<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal"><c:out value="${news.title }"></c:out></a>
							<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
					        <div class="modal-dialog">  
					        	<div class="modal-content">  
					                <div class="modal-header">  
					               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>  
					                	<h4 class="modal-title">日志详情</h4>  
					                </div>  
					                <div class="modal-body"> 
					                	<div class="news-title">
					                		<h2><c:out value="${news.title }"></c:out></h2>
					                	</div>
					                	<div class="news-info">
					                		<span><i><c:out value="${news.publisherId }"></c:out></i></span>
					                		<span><i><c:out  value="${timeFormat }"></c:out></i></span>
					                	</div>
					                	<div class="news-body" >
					                		<c:out value="${news.summary}"></c:out>
					                	</div>
					                </div> 
					                <div class="modal-footer">  
					                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">关闭</button>
					                </div>  
					            </div><!-- /.modal-content -->  
					        </div><!-- /.modal-dialog -->  
					    </div><!-- /.modal -->
						</td>
						<td>
							<span class="time"><i><c:out value="${news.time }"></c:out></i></span>
						</td>
						<td>
							<span class="author"><c:out value="${news.publisherId}"></c:out></span>
						</td>
				</tr>
	</c:forEach>	
			<tr>
						<td>
							<a href="javascript:void(0);"  data-toggle="modal" data-target="#myModal">我是写死的，测试用的</a>
							<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
					        <div class="modal-dialog">  
					        	<div class="modal-content">  
					                <div class="modal-header">  
					               		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">Ã</button>  
					                	<h4 class="modal-title">日志详情</h4>  
					                </div>  
					                <div class="modal-body"> 
					                	<div class="news-title">
					                		<h2>我是这条新闻的标题</h2>
					                	</div>
					                	<div class="news-info">
					                		<span><i>黄运智</i></span>
					                		<span><i>2015/4/16 18:10</i></span>
					                	</div>
					                	<div class="news-body" >
					                		重磅来袭，虽然我也不知到是很么鬼。但是为了填满这个框框我必须啊要写一些东西来，重点是呢我觉得吧，写满挺不容易的。时间的话在新活动中心的222房间，时间是18:30到21:30分。
					                	</div>
					                </div> 
					                <div class="modal-footer">  
					                    <button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">关闭</button>
					                </div>  
					            </div><!-- /.modal-content -->  
					        </div><!-- /.modal-dialog -->  
					    </div><!-- /.modal -->
						</td>
						<td>
							<span class="time"><i>2016-04-15</i></span>
						</td>
						<td>
							<span class="author">é»è¿æº</span>
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
    		//æ¶é¤å¤ä¸ªæ¨¡ææ¡ä¹é´çç¹å»å²çª
			$("a[data-toggle='modal']").click(function() {
				var trs = $("#pageInfo").find("#communityNews").find("table").children();
				var father = $(this).parent();
				var target = father.find(".modal");
				trs.each(function() {
					trs.find("#myModal").removeAttr("id","myModal");
				});
				target.attr("id","myModal");
			});
			//å¤çæ¯æ¬¡ç¹å»è¿å¥é¡µé¢æ¨¡ææ¡èæ¯å±æ°å¢å¤çBUG
		})();
    </script>
</body>
</html>