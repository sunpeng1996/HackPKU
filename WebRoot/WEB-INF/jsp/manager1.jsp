<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath); 
%>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>个人中心</title>
    <!-- Bootstrap Styles-->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="css/my.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="css/custom-styles.css" rel="stylesheet" />
    
    <script src="js/common.js"></script>
    
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">LOGO</a>
            </div>

            <ul class="nav navbar-top-links navbar-left">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="index.jsp" aria-expanded="false">
                       <i class="fa fa-home fa-fw"></i>首页
                    </a>
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-list fa-fw"></i>活动
                    </a>
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bar-chart fa-fw"></i>排行榜
                    </a>
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-group fa-fw"></i>
                        加入我们
                    </a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<%=path%>/MyInfo.do" aria-expanded="false">
                       <i class="fa fa-user fa-fw"></i>	您好， <c:out value="${user.email }"/>
                    </a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<%=path%>/user_quit.do" aria-expanded="false">
                       <i class="fa fa-power-off fa-fw"></i>注销
                    </a>
                </li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a class="active-menu" href="javascript:void(0);" id="personInfo"><i class="fa fa-dashboard"></i>个人信息</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" id="confirm"><i class="fa fa-desktop"></i>认证</a>
                    </li>
					<li>
                        <a href="javascript:void(0);"  id="myCommunity"><i class="fa fa-bar-chart-o"></i>
                            我的社团</a>
                    </li>
                     <li>
                        <a href="javascript:void(0);"  id="createCommunity"><i class="fa fa-bar-chart-o"></i>
                            创建社团</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);"  id="joinCommunity"><i class="fa fa-bar-chart-o"></i>
                           加入社团</a>
                    </li>                    
                    <li>
                        <a href="javascript:void(0);" id="myTask"><i class="fa fa-qrcode"></i> 
                            我的任务</a>
                    </li>
                    
                    <li>
                        <a href="javascript:void(0);" id="messageManage"><i class="fa fa-table"></i>
                            消息管理</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div id="pageInfo">
                    <nav>
                        <span>个人信息</span>
                        <a href="<%=path%>/editInfo.do" id="edit-Info"><i class="fa fa-icon-edit fa-file">&nbsp;</i>编辑信息</a>
                    </nav>
                    <form id="Infomation" action="<%=path%>/user_update.do" method="post">
                        <div>
                            <span>姓名： </span>
                            <div class="inner-div" ><c:out value="${sessionScope.user.username }"></c:out></div>
                        </div>
                        <div>
                            <span>就读学校：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.schoolname }"></c:out></div>
                        </div>
                        <div>
                            <span>学院：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.institute }"></c:out></div>
                        </div>
                        <div>
                            <span>专业：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.major }"></c:out></div>
                        </div>
                        <div>
                            <span>学历：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.scholar }"></c:out></div>
                        </div>
                        <div>
                            <span>入学时间：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.time}"></c:out></div>
                        </div>
                        <div>
                            <span>性别：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.sex}"></c:out></div>
                        </div>
                        <div>
                            <span>所在地：</span>
                            <div class="inner-div"><c:out value="${sessionScope.user.province}"></c:out></div>
                        </div>  
                        <div class="photo">
                        	<img id="image" src="<%=basePath %>fileupload/${imagePath}"  width="200" height="200"   />
                        </div>
                    </form>
                </div>
                
            </div>
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- jQuery Js -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- JS Scripts-->
    <script src="js/manager.js"></script>
    <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="js/morris/raphael-2.1.0.min.js"></script>
    <script src="js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="js/custom-scripts.js"></script>

    <script type="text/javascript" src="js/upload.js"></script>
</body>

</html>