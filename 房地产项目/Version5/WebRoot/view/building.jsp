<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect(path+"/login.jsp");
}
%>
<head>
	<meta charset="utf-8"/>
	<link href='../assets/css/bootstrap.min.css' rel='stylesheet' type='text/css'>
	<script src="../assets/js/cbd/jquery-1.11.3.min.js"></script>
	<script src="../assets/js/cbd/bootstrap.min.js"></script>
	<script src="../assets/js/cbd/second.js"></script>
	
	<script type="text/javascript" src="<%=path%>/assets/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/assets/js/themes/grid-light.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/exporting.js"></script>	
	<script>
		
$(function(){

    $('#piechart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: ''
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '税务',
            data: ${data}
        }]
    });
});
	</script>
</head>
<body>
	<div align="center" style="min-width:600px">
		<div class="row" >
			<button class="btn btn-primary" style="float:left;margin-left:40px;margin-top:30px" onclick="history.go(-1)">返回主页</button>
			<h2>       ${bname }</h2>
		</div>
		<div class="col-md-11" align="right">
			<button class="btn btn-lg" style="margin-top:40px"><a href="<%=path %>/gio/showHouseUsageState" target="iframepage">楼宇房产信息统计</a></button>
			<button class="btn btn-lg" style="margin-top:40px"><a href="<%=path %>/gio/showBuildingTaxCount?year=0" target="iframepage">楼宇税收情况统计</button>
			<button class="btn btn-lg" style="margin-top:40px"><a href="<%=path %>/gio/showBuildingTaxYOYBasis" target="iframepage">楼宇税收同比统计</button>
		
		</div>
		
		<div id="piechart" style="height:450px;width:450px;float:left;position;absolute;margin-left:50px" align="left" class="col-md-3">
		</div>
		<div style="height:700px;float:left" align="right" class="col-md-1">
			<%
				for(int i = 26;i > 0;i -= 2){
					List<Integer> wfs =  (List<Integer>)request.getAttribute("warnFloor");
					if(wfs.contains(i)){
			%>
						<div style="margin-top:20px">
							<a href="<%=path %>/gio/showHouse?floor=<%=i %>&bid=${bid}" style="background:red"><%=i %>层</a>
						</div>
			<%
				}else{
			 %>
			 			<div style="margin-top:20px">
							<a href="<%=path %>/gio/showHouse?floor=<%=i %>&bid=${bid}" style=""><%=i %>层</a>
						</div>
			 <%
			 	}}
			  %>
		</div>
		<div style="float:left" class="col-md-3">
			<img src="../assets/img/louyu.png" height="700px">
		</div>
		<div style="height:700px;" align="right" class="col-md-2">
			<%
				for(int i = 25;i > 0;i -= 2){
					List<Integer> wfs =  (List<Integer>)request.getAttribute("warnFloor");
					if(wfs.contains(i)){
			%>
						<div style="margin-top:20px">
							<a href="<%=path %>/gio/showHouse?floor=<%=i %>&bid=${bid}" style="background:red"><%=i %>层</a>
						</div>
			<%
				}else{
			 %>
			 			<div style="margin-top:20px">
							<a href="<%=path %>/gio/showHouse?floor=<%=i %>&bid=${bid}" style=""><%=i %>层</a>
						</div>
			 <%
			 	}}
			  %>
		</div>
	</div>
</body>