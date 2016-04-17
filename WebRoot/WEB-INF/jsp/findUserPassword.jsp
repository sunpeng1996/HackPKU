<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>找回密码</title>
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
    
    <script type="text/javascript" src="<%=path %>/js/common.js"></script>
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
           
        </nav>
      
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div id="pageInfo">
        <nav>
            <span>骚年，密码咋忘了呢？填信息吧</span>
        </nav>
      
      	<form id="Infomation"  >
            <div>
            	<span>注册邮箱：</span>	
            	<input id="input_email" class="inner-div" type="text" name="email">
            </div>           
          
            <input class="button" type="submit" name="submit"  onclick="findMyPassword();" value="找回密码">
        </form>
        
        <script type="text/javascript">
        		function findMyPassword(){
        		//	var email = document.getElementById("email").value;
        		var email = $("#input_email").val();
        			alert("您的邮件已发送，请注意查收!(没收到，是你自己网络问题)");
        			/* alert("还我密码"); */
        			$.ajax({
        				 url:basePath+"/findPasswordByEmail.do", 
        				 type:'GET',
        				 data:{
        					 email:email
        				 }, 
        				 success: function(data){ 
			            	if(data=="success"){
			            		alert('您已经申请成功，请前往邮箱查看');
			            	}
			            	else{
			            		alert('您的邮箱不正确！');
			            	}
			            }
        			});
        		}
        </script>
      
 
      
    </div>
    <span>
    	<h4>我们会尽快给您的邮箱发送邮件，请您及时查收，谢谢，如有任何疑问，请与开发人员联系！</h4><br/>
    	<h4>如果您长时间未收到邮件，请确保您的邮箱填写正确，并重新申请。</h4>
    </span>
                
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
                
                