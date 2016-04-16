<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myEvents</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/myEvents.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jalendar_read.js"></script>
    <script type="text/javascript">
    $(function () {
        $('#myId3').jalendar();
    });
    </script>
</head>
<body>
    <div id="pageInfo">
        <div id="myId3" class="jalendar mid">
        </div>
    </div>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>

               
