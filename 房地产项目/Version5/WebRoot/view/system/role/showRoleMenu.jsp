<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/assets/plugins/dialog/css.css" />
<style>
BODY {
	SCROLLBAR-FACE-COLOR: #e0f3fa; 
	FONT-SIZE: 12px; MARGIN: 0px; 
	SCROLLBAR-HIGHLIGHT-COLOR: #ffffff; 
	SCROLLBAR-SHADOW-COLOR: #84c2e3; 
	COLOR: #000000; 
	SCROLLBAR-3DLIGHT-COLOR: #84c2e3; 
	SCROLLBAR-ARROW-COLOR: #240024; 
	SCROLLBAR-TRACK-COLOR: #ffffff; 
	SCROLLBAR-DARKSHADOW-COLOR: #ffffff; 
	SCROLLBAR-BASE-COLOR: #ffffff
}
</style>
<script src="<%=path%>/assets/js/jquery.js"></script>
<script>
	$(function(){
		window.checkAllOrNot = function (obj) {
			var checked = obj.checked;
			var objs = document.getElementsByTagName("input");
			for (var i = 3; i < objs.length; i++) {
				if (checked) {
					if (objs[i].checked == false)
						objs[i].checked = true;
				} else {
					if (objs[i].checked == true)
						objs[i].checked = false;
				}
			}
		}
		
		window.checkAll = function (mainObj) {
			var name = mainObj.name;
			var names = document.getElementsByName(name);
			if (mainObj.checked == true) {
				for (var i = 0; i < names.length; i++) {
					addAllIdByMainObj(names[i], mainObj.checked);
				}
			} else {
				for (var i = 0; i < names.length; i++) {
					addAllIdByMainObj(names[i]);
				}
			}
		}
		
		window.addAllIdByMainObj = function (obj, flag) {
			var id = obj.id;
			if (!obj.checked) {
				if (flag) {
					obj.checked = true;
				}
			} else {
				if (!flag) {
					obj.checked = false;
				}
			}
		}
		
		window.commit = function () {
			
			$.ajax({
				url : '<%=path %>/role/editRoleMenu',
				data:$('#form1').serialize(),
				type : "post",
				dataType : "text",
				success : function(data) {
					 parent.location.reload();   
					
				}
			});
		}
		
		var n = 0;
		$(":checkbox:not(#checkAll)").each(function(){
			if(!$(this).is(":checked")){
				n++;
			}
		});
		if(n==0){
			$("#checkAll").attr("checked","checked");
		} else{
			$("#checkAll").removeAttr("checked");
		}
		
		$(".cc:checked").each(function(){
			$(this).parent().parent().prev().children().children(".pc").attr("checked","checked");
		});
		
		$(".cc").each(function(){
			$(this).click(function(){
				var ccc = $(this).parent().children(".cc:checked");
				if(ccc.size()==0){
					$(this).parent().parent().prev().children().children(".pc").removeAttr("checked");
				}else{
						$(this).parent().parent().prev().children().children(".pc").attr("checked","checked");
				}
			});
		});
	});
	
</script>
</head>
<body>
<form name="form1" id="form1" method="post">
	<input type="hidden" value="${roleId }" id="roleId" name="roleId"/>
	<table border="0" bgcolor="#f4f4f4" cellspacing="13" cellpadding="0" width="100%" height="100%">
		<tr>
			<td id="cc" width="96%">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#f4f4f4">
					<tr height="35" valign="center">
						<!-- <td><input type="checkbox" id="checkAll" onclick="checkAllOrNot(this);" />全选</td> -->
						<td align="right"><input type="image" src="<%=path%>/assets/plugins/dialog/commit.jpg" width="45" onclick="commit();" height="18" /></td>
					</tr>
					<tr>
						<td colspan="4"><hr class=dotline color=#000000 size=1></td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 
		<c:forEach var="menus" items="${list }">
			<tr>
				<td>
					<input class="pc" type="checkbox" id="${menus.MENU_ID}" name="${menus.MENU_ID}" <c:if test="${menus.ROLE_ID==roleId }">checked=true</c:if> onclick="checkAll(this);" />
					<b>${menus.MENU_NAME}</b>
				</td>
			</tr>
			<tr>
				<td>
					<c:forEach var="childMenus" items="${menus.CHILD_MENUS}" step="1">
	 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 					<input class="cc" type="checkbox" id="${childMenus.MENU_ID }" name="${childMenus.MENU_PARENT}" <c:if test="${childMenus.ROLE_ID==roleId }">checked=true</c:if> onclick="singleCheck(this);" />
						${childMenus.MENU_NAME }
	 					<br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><hr class=dotline color=#000000 size=1></td>
			</tr>
		</c:forEach>
		 -->
		 
		
		 
		<c:forEach var="q" items="${allmenu }">
			<c:if test="${q.isfather=='1'}">
			<tr>
				<td>
					<b>${q.menuname}</b>
				</td>
			</tr>
			
			<c:forEach var="w" items="${allmenu }">
				<c:if test="${q.id==w.pid}">
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="pc" type="checkbox" id="${q.id}" name="menu_id" value="${w.id }"
						 <c:forEach var="e" items="${list }">
						 
						 ${e.menu_id }
						 <c:if test="${e.menu_id==w.id }">
						 checked='true'
						 </c:if>
						 </c:forEach>
						/>
						<b>${w.menuname}</b>
					</td>
				</tr>
				</c:if>
			</c:forEach>
			<tr>
				<td><hr class=dotline color=#000000 size=1></td>
			</tr>
			</c:if>
		</c:forEach>
		
		
		
		
		
		
		
	</table>
	</form>
</body>
</html>

