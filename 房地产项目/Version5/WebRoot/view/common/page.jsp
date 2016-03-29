<%@ page language="java" import="java.util.*,com.common.PageBean" pageEncoding="utf-8"%>
<%@ include file="/view/common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

<%
PageBean pageBean=(PageBean)request.getAttribute("pageBean");
%>
function gotoPage(currentPage){
	var formId="<%=request.getParameter("formId")%>";
	if(currentPage=="select"){
		document.getElementById("currentPage").value=1;
	}else{
		document.getElementById("currentPage").value=currentPage;
	}
	document.getElementById(formId).submit();
}
</script>
  </head>
 
  <body>


<div class="dataTables_info" id="data-table_info" role="status" aria-live="polite">
每页 <select id="pageSize" name="pageSize" onchange="javascript:gotoPage('select')"  <%if(pageBean.getList().size()==0){ %>disabled<%} %>>
							<option <c:if test="${pageBean.pageSize == 20 }">selected</c:if>>20</option>
							<option <c:if test="${pageBean.pageSize == 50 }">selected</c:if>>50</option>
							<option <c:if test="${pageBean.pageSize == 100 }">selected</c:if>>100</option>
							<option <c:if test="${pageBean.pageSize == 200 }">selected</c:if>>200</option>
						</select> 条，共 ${pageBean.allRow } 条
</div>
                                
                                <div class="dataTables_paginate paging_simple_numbers">
                                
                                <c:if test="${pageBean.currentPage == 1}">    

   <a class="paginate_button previous disabled" aria-controls="data-table" data-dt-idx="" tabindex="0">首页</a>
								    <a class="paginate_button previous disabled" aria-controls="data-table" data-dt-idx="" tabindex="0">上一页</a>

 
 </c:if>
 
 
 <c:if test="${pageBean.currentPage != 1&&pageBean.allRow!=0}"> 

<a class="paginate_button previous " aria-controls="data-table" data-dt-idx="" tabindex="0" href="javascript:gotoPage(1);">首页</a>
   

<a class="paginate_button previous " aria-controls="data-table" data-dt-idx="" tabindex="0" href="javascript:gotoPage(${pageBean.currentPage-1});">上一页</a>

 </c:if>
 
 
                                
                                
                                
                                   
                                   <span>
                                   <%if(pageBean.getCurrentPage()-5>0){ %><a href="javascript:gotoPage('${pageBean.currentPage-5 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage-5 }</a><%} %>
                                   <%if(pageBean.getCurrentPage()-4>0){ %><a href="javascript:gotoPage('${pageBean.currentPage-4 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage-4 }</a><%} %>
                                   <%if(pageBean.getCurrentPage()-3>0){ %><a href="javascript:gotoPage('${pageBean.currentPage-3 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage-3 }</a><%} %>
                                   	<%if(pageBean.getCurrentPage()-2>0){ %><a href="javascript:gotoPage('${pageBean.currentPage-2 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage-2 }</a><%} %>
                                   		<%if(pageBean.getCurrentPage()-1>0){ %><a href="javascript:gotoPage('${pageBean.currentPage-1 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage-1 }</a><%} %>
                                   		
                                   		 <a class="paginate_button current" aria-controls="data-table" data-dt-idx="1" tabindex="0">${pageBean.currentPage }</a>
                                   		 
                                   		 <%if(pageBean.getCurrentPage()+1<=pageBean.getTotalPage()){ %><a href="javascript:gotoPage('${pageBean.currentPage+1 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage+1 }</a><%} %>
                                   		 <%if(pageBean.getCurrentPage()+2<=pageBean.getTotalPage()){ %><a href="javascript:gotoPage('${pageBean.currentPage+2 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage+2 }</a><%} %>
                                   		 <%if(pageBean.getCurrentPage()+3<=pageBean.getTotalPage()){ %><a href="javascript:gotoPage('${pageBean.currentPage+3 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage+3 }</a><%} %>
                                   		 <%if(pageBean.getCurrentPage()+4<=pageBean.getTotalPage()){ %><a href="javascript:gotoPage('${pageBean.currentPage+4 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage+4 }</a><%} %>
                                   		 <%if(pageBean.getCurrentPage()+5<=pageBean.getTotalPage()){ %><a href="javascript:gotoPage('${pageBean.currentPage+5 }');" class="paginate_button " aria-controls="data-table" data-dt-idx="" tabindex="0">${pageBean.currentPage+5 }</a><%} %>
                                   		 
                                         
                                    </span>
                                    
                                    
                                    
                                    
                                    <c:if test="${pageBean.currentPage != pageBean.totalPage&&pageBean.allRow!=0}">    

<a class="paginate_button next " aria-controls="data-table" data-dt-idx="" tabindex="0" id="data-table_next" href="javascript:gotoPage(${pageBean.currentPage+1});">下一页</a>


<a class="paginate_button next " aria-controls="data-table" data-dt-idx="" tabindex="0" id="data-table_next" href="javascript:gotoPage(${pageBean.totalPage });">尾页</a>

</c:if>  
                                    
									 
									 <c:if test="${pageBean.currentPage == pageBean.totalPage}">   
<a class="paginate_button next disabled" aria-controls="data-table" data-dt-idx="" tabindex="0" id="data-table_next">下一页</a>
									 <a class="paginate_button next disabled" aria-controls="data-table" data-dt-idx="" tabindex="0" id="data-table_next">尾页</a>
</c:if>
									 
                                 </div>

<%-- 

						共
						${pageBean.allRow }条记录，
						每页显示
						<select id="pageSize" name="pageSize" onchange="javascript:gotoPage('select')"  <%if(pageBean.getList().size()==0){ %>disabled<%} %>>
							<option <c:if test="${pageBean.pageSize == 10 }">selected</c:if>>10</option>
							<option <c:if test="${pageBean.pageSize == 20 }">selected</c:if>>20</option>
							<option <c:if test="${pageBean.pageSize == 50 }">selected</c:if>>50</option>
							<option <c:if test="${pageBean.pageSize == 100 }">selected</c:if>>100</option>
							<option <c:if test="${pageBean.pageSize == 200 }">selected</c:if>>200</option>
						</select>
						条，
						当前显示第
						<select id="goto" onchange="javascript:gotoPage('select')" <%if(pageBean.getList().size()==0){ %>disabled<%} %>>
							<%for(int i=1;i<=pageBean.getTotalPage();i++){ %>
							<option value="<%=i %>" <%if(pageBean.getCurrentPage()==i){ %> selected <%} %>><%=i %></option>
							<%} %>
						</select>
						页
					
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${pageBean.currentPage == 1}">    

    首页 上一页

 
 </c:if>
  
<c:if test="${pageBean.currentPage != 1&&pageBean.allRow!=0}">    
<a href="javascript:gotoPage(1);">
首页
</a>    
<a href="javascript:gotoPage(${pageBean.currentPage-1});">
上一页
</a>

</c:if>
<c:if test="${pageBean.currentPage != pageBean.totalPage&&pageBean.allRow!=0}">    
<a href="javascript:gotoPage(${pageBean.currentPage+1});" >
下一页
</a>
<a href="javascript:gotoPage(${pageBean.totalPage });">
 尾页
</a>
</c:if>   

<c:if test="${pageBean.currentPage == pageBean.totalPage}">   
    下一页 尾页
</c:if>

						
						
					









--%>













  </body>
</html>
