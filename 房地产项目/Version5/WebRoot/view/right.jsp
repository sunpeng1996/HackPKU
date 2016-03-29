<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/common/common.jsp"%>

<!DOCTYPE HTML>
<html>
	<head>




		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


	</head>

	<body>
		
				<!-- begin breadcrumb -->
				<ol class="breadcrumb pull-right">
					<li>
						<a href="javascript:;">首页</a>
					</li>
					<li>
						<a href="javascript:;">实时监测与预警</a>
					</li>
					<li class="active">
						整体监测与预警
					</li>
				</ol>
				<!-- end breadcrumb -->
				<!-- begin page-header -->
				<h1 class="page-header">
					实时监测与预警
					<small>整体监测与预警</small>
				</h1>
				<!-- end page-header -->

				<!-- begin row -->
				<div class="row">
					<!-- begin col-8 -->
					<div class="col-md-8">
						<div class="panel panel-inverse" data-sortable-id="flot-chart-1">
							<div class="panel-body">
								<div class="height-700">
									<img src="assets/img/1.jpg" class="width-full height-full">
								</div>
							</div>
						</div>
					</div>
					<!-- end col-8 -->
					<!-- begin col-4 -->
					<div class="col-md-4">
						<div class="panel panel-inverse" data-sortable-id="flot-chart-6">

							<div class="panel-body">
								<div id="stacked-chart" class="height-300"></div>
							</div>
						</div>
						<div class="panel panel-inverse" data-sortable-id="flot-chart-3">

							<div class="panel-body">
								<div id="bar-chart" class="height-350"></div>
							</div>
						</div>
					</div>
					<!-- end col-4 -->
				</div>
				<!-- end row -->

			

	</body>
</html>
