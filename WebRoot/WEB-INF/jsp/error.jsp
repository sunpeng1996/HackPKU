<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<title>错误页面</title>
    <link rel="stylesheet" type="text/css" href="css/error.css">

	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<section class="canvas-wrap">
        <div class="canvas-content">
            <div id="errorInfo">
                <div id="errorInfo-inner">
                    <p>
                        You are lucky to find this
                        <a href="index.jsp">ERROR</a>
                        page!&nbsp;&nbsp;Congratulation!<br/>
                        <font color="red">${errorMsg }</font>
                    </p> 
                </div>
            </div>
            <div id="errorInfo-bottom"></div>
        </div>
        <div id="canvas" class="gradient"></div>
        <div id="error-bottom">&copy;Powered By W_littlewhite</div>
    </section>
	<!-- Main library -->
    <script src="js/three.min.js"></script>
    <!-- Helpers -->
    <script src="js/projector.js"></script>
    <script src="js/canvas-renderer.js"></script>
    <!-- Visualitzation adjustments -->
    <script src="js/3d-lines-animation.js"></script>
</body>
</html>