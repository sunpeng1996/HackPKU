<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0, user-scalable=no" name="viewport" />
<title></title>
<link href="assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="assets/css/animate.min.css" rel="stylesheet" />
<link href="assets/css/style.min.css" rel="stylesheet" />
<link href="assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="assets/css/theme/default.css" rel="stylesheet" id="theme" />
<style>
.login-em{
	position:absolute;
	margin-top:12%;
	padding:5px;
	width:120px;
	height:20px;
	font-size:12px;
	line-height:10px;
	color:#FC8523; 
	background:#FFFCDF;
	-webkit-border-radius:3px;
	-moz-border-radius:3px;
	border-radius:3px;
	display:none;
}
</style>
</head>
<body>
	<div class="login-cover" >
		<div class="login-cover-image" >
			<img src="assets/img/login-bg/11bh.jpg" style="width: 100%"/>
		</div>
	</div>
	<div class="fade">
		<div class="login login-v2" data-pageload-addclass="animated flipInX">
			<div class="login-content">
					<div class="brand">
						<h2 class="text-center text-white" style="margin: 0 0 20px;">xxxx系统</h2>
					</div>
					<div class="form-group m-b-20">
						<input type="text" name="username" id="username" class="form-control input-lg" placeholder="用户名" />
					</div>
					<div class="form-group m-b-20">
						<input type="password" name="userpass" id="userpass" class="form-control input-lg" placeholder="密码" />
					</div>
					<div class="form-group m-b-20">
						<div id="errorMessage" class="login-em"></div>
					</div>
					<!-- <div class="checkbox m-b-20">
						<label> <input type="checkbox" id="remenberPass" /> 记住密码 </label>
					</div> -->
					<div class="login-buttons">
						<button type="button" id="loginButton" class="btn btn-success btn-block btn-lg">登陆</button>
					</div>
			</div>
		</div>
	</div>
	<script src="assets/plugins/jquery/jquery-1.9.1.min.js"></script>
	<script src="assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
	<script src="assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/jquery-cookie/jquery.cookie.js"></script>
	<script language="javascript">
		$(function() {
			$(window).keypress(function(event){
				switch(event.keyCode){
					case 13:$("#loginButton").click();
				}
			});
			
			$.extend({login:function(){
				var result = "";
				var username = $("#username").val();
				var userpass = $("#userpass").val();
				$.ajax({
					url:"<%=path%>/login",
					data:{username:username,userpass:userpass},
					dataType:"text",
					async: false,
					success:function(data){
						result =  data;
					}
				});
				return result;
			}});
			
			
			$("#loginButton").click(function(){
				var username = $("#username").val();
				var password = $("#userpass").val();
				var errorMessage = $("#errorMessage");
				if ($.trim(username) == "") {
					errorMessage.text("用户名不能为空 ");
					errorMessage.show();
					return false;
				} 
				else if ($.trim(password) == "") {
					errorMessage.text("密码不能为空 ");
					errorMessage.show();
					return false;
				} 
				else if ($.login() == "un") {
					errorMessage.text("用户名不存在 ");
					errorMessage.show();
					return false;
				}
				else if ($.login() == "pn") {
					errorMessage.text("密码错误 ");
					errorMessage.show();
					return false;
				} else{
					if($.login() == "y"){
						/*if($("#remenberPass").is(":checked")){
					 		$.cookie('swt_u_p', $("#username").val()+","+$("#userpass").val() , { path: '/', expires: 10 });
						} else{
							$.cookie('swt_u_p', null, { path: '/' });
						}*/
						window.location.href="<%=path%>/menu/mainMenu";
					}
				}
			});
		});
	</script>
</body>
</html>

