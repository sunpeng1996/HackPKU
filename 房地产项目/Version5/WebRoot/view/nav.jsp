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
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<link href='../assets/css/bootstrap.min.css' rel='stylesheet' type='text/css'>
	
	<script src="../assets/js/cbd/jquery-1.11.3.min.js"></script>
	<script src="../assets/js/cbd/bootstrap.min.js"></script>
	<script src="../assets/js/cbd/my2.js"></script>
	
	<script type="text/javascript" src="<%=path%>/assets/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/assets/js/themes/skies.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/exporting.js"></script>	
</head>
<body>
	<div align="center">
		<h2>首页导航</h2>
		<div>
			<img src="../assets/img/cbd.png" width="1176px" height="680px" usemap="#cbdMap" id="cbdImg"/>
		<%-- 
			<div id="testDIV" style="position:absolute;display:none;width:200px;height:200px;z-index:100;background:red" onmouseout="getOut()">
				<iframe src="<%=path%>/gio/showChart"></iframe>
			</div>
			<div id="test" style="width:200px;height:200px;" onmouseout="getOut()" onclick="location()">
				<iframe src="<%=path%>/gio/showChart"></iframe>
			</div> --%>
			<map name="cbdMap" id="cbdMap">
	     	  <area shape="rect" coords="395,50,425,81" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="413,85,439,119" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="700,55,719,98" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="679,97,703,135" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="746,63,767,104" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="730,107,747,139" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="795,76,821,122" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="759,115,788,151" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="835,86,865,137" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="795,127,821,158" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="874,102,903,159" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="824,140,854,178" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="863,158,888,193"href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="892,178,914,214" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="920,116,952,187" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="961,143,982,200" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="992,169,1025,209" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="916,197,941,232" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="1014,210,1044,248" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="1024,249,1057,277" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="1035,278,1072,331" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="929,234,947,254" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="948,250,965,276" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="947,282,977,316" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="1009,363,1046,432" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="895,380,924,348,953,360,930,396" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="960,427" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="954,426,996,459,941,510,904,469" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="856,392,897,409,868,443,830,421" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="813,429,839,448,803,472,778,450" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="882,471,922,508,871,552,826,509" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="363,417,414,471" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="301,461,356,534" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="rect" coords="319,389,362,442" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="227,449,247,430,271,452,262,483" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="263,380,290,352,315,382,295,405" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="184,412,221,388,239,419,221,439" href="<%=path %>/gio/showBuilding?bid=2" target="iframepage">
			  <area shape="poly" coords="229,344,253,328,278,350,255,373" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="136,362,170,349,196,389,163,412" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="168,270,214,313" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="79,274,141,337" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="167,244,204,268" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="80,234,123,266" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="176,214,203,240" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="98,204,125,215,138,248,113,232,87,225" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="111,180,144,186,157,222,136,228" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="184,199" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="183,197,212,204,223,229,201,211,185,210" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="133,158,156,165,170,193,158,206" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="rect" coords="202,179,229,200" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="162,132,188,148,204,177,174,184,157,150" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="191,114,216,128,225,156,202,164,184,132" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="231,99,251,98,269,136,241,140" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="229,159,247,167,258,188,238,197,223,171" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="252,146,265,151,272,172,256,178,245,157" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="268,84,288,79,304,115,278,122" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="305,74,328,62,343,99,317,112" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="363,58,388,54,390,82,372,90" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="279,124,301,131,310,159,283,157" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="311,121,331,112,348,140,322,151" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="345,108,361,99,372,127,350,136" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
			  <area shape="poly" coords="380,92,408,88,410,116,393,119" href="<%=path %>/gio/showBuilding?bid=1" target="iframepage">
	     	</map>
		</div>
		<div class="row" style="margin-top:30px">
			<button style="float:left;margin-left:100px"class="btn"><a href="<%=path%>/gio/gio_1">房产查询</a></button>
			<div class="btn-group dropup" style="float:right">
				<button style="float:right;margin-right:100px"class="btn btn-primary btn-squared dropdown-toggle" data-toggle="dropdown" onclick="clickInfo()">信息管理</button>
				<ul class="dropdown-menu">
					<li>
						<a href="<%=path %>/user/userList">
							用户信息管理
						</a>
					</li>
					<li>
						<a href="<%=path %>/menu/menuList">
							菜单信息管理
						</a>
					</li>
					<li>
						<a href="<%=path %>/role/fwList">
							房屋信息管理
						</a>
					</li>
					<li>
						<a href="<%=path %>/rental/rentalnoList">
							房屋使用(非出租)信息管理
						</a>
					</li>
					<li>
						<a href="<%=path %>/rental/rentalyesList">
							房屋使用(出租)信息管理
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	

</body>
</html>