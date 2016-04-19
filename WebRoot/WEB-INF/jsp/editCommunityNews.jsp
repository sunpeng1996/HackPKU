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
	<title>社团日志</title>
</head>
<body>



    <div id="pageInfo">
		<nav>
			<span>社团新闻编辑</span>
		</nav>
			<div id="communityNews">
			<table >
				<tr>
					<td>标题</td>
					<td>时间</td>
					<td>发布者</td>
					<td>选项</td>
				</tr>
				  <c:forEach items="${requestScope.newsList }" var="nc" > 
				<tr>
						<td>
							<a href="javascript:void(0);" id="a_${nc.newId }" onclick="showNews(this);"><c:out value="${nc.title }"></c:out></a>
						</td>
						<td>
							<span class="time"><i><c:out value="${nc.newsTime }"></c:out></i></span>
						</td>
						<td>
							<span class="author"><c:out value="${nc.author}"></c:out></span>
						</td>
						<td>
							<a href="javascript:void(0);" id="c_${nc.newId }" onclick="editNews(this);">编辑</a>
						</td>
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
    		//æ¶é¤å¤ä¸ªæ¨¡ææ¡ä¹é´çç¹å»å²çª这他妈是啥
			$("a[data-toggle='modal']").click(function() {
				var trs = $("#pageInfo").find("#communityNews").find("table").children();
				var father = $(this).parent();
				var target = father.find(".modal");
				trs.each(function() {
					trs.find("#myModal").removeAttr("id","myModal");
				});
				target.attr("id","myModal");
			});
		})();
    	
    	function showNews(a){
    		//alert("看新闻");
    		var id = $(a).attr('id').replace('a_','');
    		$.ajax({ 
                url:basePath+"/toNewsPage.do", 
                type:'POST', 
                data:"news_id="+id,
                success: function(data){
        			$("#page-inner").html(data);
                },
                error: function(data){
                    alert("fail");
                }
            }); 
    	}
    	
    	function editNews(c){
    		//alert("即将编辑");
    		var id = $(c).attr('id').replace('c_','');
    		$.ajax({
    			url:basePath+"/editNews.do",
    			type:'POST',
    			data:'news_id='+id,
    			success:function(data){
    				//alert("编辑成功");
    				$("#page-inner").html(data);
    			},
    			error:function(data){
    				alert("gggg");
    			}
    		});
    	}
    
    </script> 
</body> 
</html>