<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(request.getSession().getAttribute("user")==null){
	response.sendRedirect(path+"/login.jsp");
}
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0, user-scalable=no" name="viewport" />
    <title>xxx系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="<%=path%>/assets/css/fonts/linecons/css/linecons.css" rel="stylesheet">
	<link href="<%=path%>/assets/plugins/fonts/fontawesome/css/font-awesome.min.css" rel="stylesheet" >
    <link href="<%=path%>/assets/css/animate.min.css" rel="stylesheet" />
	<link href="<%=path%>/assets/css/style.min.css" rel="stylesheet" />
	<link href="<%=path%>/assets/css/style-responsive.min.css" rel="stylesheet" />
	<link href="<%=path%>/assets/css/new.css" rel="stylesheet" />
	
	
	 <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="<%=path%>/assets/js/excanvas.min.js"></script><![endif]-->
    <!--[if lt IE 9]>
      <script src="<%=path%>/assets/js/html5shiv.min.js"></script>
      <script src="<%=path%>/assets/js/respond.min.js"></script>
    <![endif]-->
	
	<!-- <script src="<%=path%>/assets/plugins/pace/pace.min.js"></script> -->
	
	<!-- ================== BEGIN BASE JS ================== -->
	<script src="<%=path%>/assets/plugins/jquery/jquery-1.9.1.min.js"></script>
	<script src="<%=path%>/assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
	<script src="<%=path%>/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
	<script src="<%=path%>/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path%>/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="<%=path%>/assets/plugins/jquery-cookie/jquery.cookie.js"></script>
	
	<script type="text/javascript" src="<%=path %>/assets/plugins/dialog/zgx_dialog.js"></script>
	<!-- ================== END BASE JS ================== -->
	
	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="<%=path%>/assets/js/apps.min.js"></script>
	<script src="<%=path%>/assets/js/common.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->
	<link href="<%=path%>/assets/plugins/DataTables/css/data-table.css" rel="stylesheet" />
	
    <script type="text/javascript" src="<%=path%>/assets/js/macarons.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/echarts-all.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/highcharts.js"></script>
	<script type="text/javascript" src="<%=path %>/assets/js/themes/skies.js"></script>
	<script type="text/javascript" src="<%=path%>/assets/js/exporting.js"></script>	
	<script type="text/javascript" src="<%=path%>/assets/js/My97DatePicker/WdatePicker.js"></script>
	
	
	<script>
		$(document).ready(function() {
			App.init();
			
		});
	</script>

  </head>
  
  
</html>
