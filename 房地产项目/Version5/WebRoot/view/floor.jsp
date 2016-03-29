<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect(path+"/login.jsp");
}
List<Integer> hids = (List<Integer>)request.getAttribute("hids");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<link href='../assets/css/bootstrap.min.css' rel='stylesheet' type='text/css'>
	
	<script src="../assets/js/cbd/jquery-1.11.3.min.js"></script>
	<script src="../assets/js/cbd/bootstrap.min.js"></script>
	<script src="../assets/js/cbd/third.js"></script>
	
</head>
<body>
<script type="text/javascript">
			
	if(1 == ${errorflag}){
		alert("查无此房");
	}
</script>
	<div align="center" style="min-width:600px">
		<div class="row" >
			<button class="btn btn-primary" style="float:left;margin-left:40px;margin-top:30px" onclick="history.go(-1)">后退</button>
		</div>
		<h2>${floorNum }楼</h2>
		<div>
			<img src="../assets/img/pingmian.png" width="646px" height="642px" usemap="#pingmianMap" id="pingmianImg"/>
			<div id="testDIV" style="position:absolute;display:none;width:100px;height:20px;z-index:100;background:red" onmouseout="getOut()" onclick="cancelDisplay()">此房屋预警</div>
			<map name="pingmianMap" id="pingmianMap">
	     	  <area shape="poly" coords="19,119,191,97,194,186,32,187" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=7" target="iframepage" <%if(hids.contains(7)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="40,229,160,231,164,275,49,274" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=8" target="iframepage" <%if(hids.contains(8)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="53,289,164,290,160,323,66,324" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=9" target="iframepage" <%if(hids.contains(9)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="51,343,159,340,187,381,190,502,56,501" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=10" target="iframepage" <%if(hids.contains(10)){ out.print("alt=\"预警房屋\""); }%>>
			  
			  <area shape="poly" coords="204,376,248,370,253,496,214,495" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=11" target="iframepage" <%if(hids.contains(11)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="263,372,295,375,299,489,260,489" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=12" target="iframepage" <%if(hids.contains(12)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="309,379,343,374,345,513,308,531" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=13" target="iframepage" <%if(hids.contains(13)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="358,375,389,376,390,500,359,507" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=14" target="iframepage" <%if(hids.contains(14)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="407,376,435,374,440,491,407,491" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=15" target="iframepage" <%if(hids.contains(15)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="455,372,481,377,483,486,452,487" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=16" target="iframepage" <%if(hids.contains(16)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="496,376,600,369,620,459,506,494" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=17" target="iframepage" <%if(hids.contains(17)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="522,243,600,246,639,302,628,355,581,314,525,321" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=18" target="iframepage" <%if(hids.contains(18)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="528,187,572,192,588,222,527,224" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=19" target="iframepage" <%if(hids.contains(19)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="494,99,512,99,555,168,521,173,504,187,485,184" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=20" target="iframepage" <%if(hids.contains(20)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="445,94,471,90,474,172,474,189,445,194" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=1" target="iframepage" <%if(hids.contains(1)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="405,95,432,97,433,194,400,186" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=2" target="iframepage" <%if(hids.contains(2)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="352,92,378,94,382,190,354,198" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=3" target="iframepage" <%if(hids.contains(3)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="311,94,334,96,342,193,311,187" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=4"  target="iframepage" <%if(hids.contains(4)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="254,101,293,106,292,186,258,193" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=5" target="iframepage" <%if(hids.contains(5)){ out.print("alt=\"预警房屋\""); }%>>
			  <area shape="poly" coords="216,101,239,94,243,190,207,188" href="<%=path %>/gio/showHouseMsg?floor=${floor }&bid=${bid }&hid=6" target="iframepage" <%if(hids.contains(6)){ out.print("alt=\"预警房屋\""); }%>> 
			</map>
		</div>
	</div>
</body>