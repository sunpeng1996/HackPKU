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
    <title>我的社团</title>
    <!-- Bootstrap Styles-->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="css/custom-styles.css" rel="stylesheet" />
    <!-- myEvents CSS -->
    <link rel="stylesheet" href="css/myEvents.css" type="text/css" />
    <!-- myEvents CSS -->
    <link rel="stylesheet" href="css/my.css" type="text/css" />
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
                <a class="navbar-brand" href="index.html">LOGO</a>
            </div>

            <ul class="nav navbar-top-links navbar-left">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
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
                    <a class="dropdown-toggle" href="<%=path%>/MyInfo.do" aria-expanded="false"><!-- data-toggle="dropdown"  -->
                       <i class="fa fa-user fa-fw"></i>${user.email }
                    </a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<%=path%>/user_quit.do" aria-expanded="false">
                       <i class="fa fa-power-off fa-fw"></i>注销
                    </a>
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a class="active-menu" href="javascript:void(0);" id="personInfo"><i class="fa fa-dashboard"></i>社团主页</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" menu_id="12" class="menu" id="confirm"><i class="fa fa-desktop"></i>社团信息12</a>
                    </li>
					<li>
                        <a href="javascript:void(0);" menu_id="14" class="menu"  id="myCommunity"><i class="fa fa-bar-chart-o"></i>
                            社团日志14</a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" menu_id="15" class="menu" id="myTask"><i class="fa fa-qrcode"></i> 
                            社团论坛15</a>
                    </li>

                    <li>
                        <a href="javascript:void(0);" menu_id="1" class="menu" id="messageManage"><i class="fa fa-sitemap"></i>
                            社团管理1<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="javascript:void(0);" menu_id="3" class="menu" id="communityInfoChange" >社团信息变更3</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" menu_id="2" class="menu" id="communityMemChange">社团成员调整2</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" menu_id="4">社团职位调整4<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="javascript:void(0);" menu_id="5" class="menu" id="communityPosChange">社团角色分配5</a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" menu_id="6" class="menu" id="communityPosManage">社团角色管理6</a>
                                    </li>
                                </ul>

                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:void(0);" menu_id="7" class="menu" id="messageManage"><i class="fa fa-sitemap"></i>
                            社团活动7<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="javascript:void(0);" menu_id="8" class="menu" id="myEvents">查看日程8</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" menu_id="9" class="menu" id="distributeActivity">分配活动9</a>
                            </li>
                            <li>
                                <a href="javascript:void(0);" menu_id="10" class="menu">编辑活动状态10</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
			</div>

        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- jQuery Js -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- JS Scripts-->
    <script src="js/communityManager.js"></script> 
    <!-- Bootstrap Js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="js/morris/raphael-2.1.0.min.js"></script>
    <script src="js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="js/custom-scripts.js"></script>
	<script>
	
	    var menu_ids = ${menu_ids};
    	$(document).find('.menu').map(function(){
    		if(menu_ids.indexOf(parseInt($(this).attr('menu_id'))) == -1){
    			return this;
    		}
    	}).parent().remove();
	</script>
</body>

</html>