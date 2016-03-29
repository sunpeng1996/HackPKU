<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/common/common.jsp"%>





	
	<script type="text/javascript" src="<%=path %>/dwr/util.js"></script>    
	<script type="text/javascript" src="<%=path %>/dwr/engine.js"></script>
		
<script type="text/javascript">  
   
        dwr.engine.setActiveReverseAjax(true);  
        dwr.engine._errorHandler = function(message, ex) {dwr.engine._debug("Error: " + ex.name + ", " + ex.message, true);};
  
    function callBack(sensor_id,data,level){  
        $("#iframepage")[0].contentWindow.callBack(sensor_id,data,level);
    } 
    
    function dangqian(id)
	{
		for(i=1;i<150;i++)
		{
			if(i==id)
			{
				document.getElementById(""+i).className='cc';
			}
			else
			{
				document.getElementById(""+i).className='';
			}
			
		}
	}
    
</script>  



	<body>
		<!-- begin #page-container -->
		<div id="page-container" class="fade page-sidebar-minified page-sidebar-fixed page-header-fixed in">
			<!-- begin #header -->
			<div id="header" class="header navbar navbar-default navbar-fixed-top">
				<!-- begin container-fluid -->
				<div class="container-fluid">
					<!-- begin mobile sidebar expand / collapse button -->
					<div class="navbar-header">

					</div>
					<!-- end mobile sidebar expand / collapse button -->

					<!-- begin header navigation right -->
					<ul class="nav navbar-nav navbar-right">

						<li class="dropdown">
							<a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle f-s-14"> <i class="fa fa-bell-o"></i> <span class="label">5</span> </a>
							<ul class="dropdown-menu media-list pull-right animated fadeInDown">
								<li class="dropdown-header">
									通知 (3)
								</li>
								<li class="media">
									<a href="javascript:;">
										<div class="media-left">
											<i class="fa fa-bug media-object bg-red"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading">
												错误报告
											</h6>
											<div class="text-muted f-s-11">
												3分钟前
											</div>
										</div> </a>
								</li>

								<li class="media">
									<a href="javascript:;">
										<div class="media-left">
											<i class="fa fa-plus media-object bg-green"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading">
												1个新用户
											</h6>
											<div class="text-muted f-s-11">
												1小时前
											</div>
										</div> </a>
								</li>
								<li class="media">
									<a href="javascript:;">
										<div class="media-left">
											<i class="fa fa-envelope media-object bg-blue"></i>
										</div>
										<div class="media-body">
											<h6 class="media-heading">
												1个新邮件
											</h6>
											<div class="text-muted f-s-11">
												2小时前
											</div>
										</div> </a>
								</li>
								<li class="dropdown-footer text-center">
									<a href="javascript:;">查看更多</a>
								</li>
							</ul>
						</li>
						<li class="dropdown navbar-user">
							<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> <span class="hidden-xs">管理员</span> <b class="caret"></b> </a>
							<ul class="dropdown-menu animated fadeInLeft">
								<li class="arrow"></li>
								<li>
									<a href="javascript:;">个人资料</a>
								</li>
								<li>
									<a href="javascript:;"><span class="badge badge-danger pull-right">2</span>收件箱</a>
								</li>
								<li>
									<a href="javascript:;">个人设置</a>
								</li>
								<li>
									<a href="javascript:;">联系我们</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="javascript:;">安全退出</a>
								</li>
							</ul>
						</li>
						
						<li>
							<a href="javascript:history.go(-1)"> <i class="fa fa-sign-in"></i> 后退</a>
						</li>
						<li>
							<a href="<%=path %>/view/nav.jsp" target="iframepage"> <i class="fa fa-sign-out"></i> 首页 </a>
						</li>
						
						<li>
							<a href="<%=path %>/logout"> <i class="fa fa-sign-out"></i> 退出 </a>
						</li>
					</ul>
					<!-- end header navigation right -->
				</div>
				<!-- end container-fluid -->
			</div>
			<!-- end #header -->

			<!-- begin #sidebar -->
			<div id="sidebar" class="sidebar">
				<!-- begin sidebar scrollbar -->
				<div data-scrollbar="true" data-height="100%">
					<!-- begin sidebar top -->
					<ul class="nav">
						<li>
							<a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i> </a>
						</li>

					</ul>
					<!-- end sidebar top -->

					<!-- begin sidebar nav -->
					<ul class="nav">
						<c:forEach items="${menulist }" var="q">
							<c:if test="${q.isfather=='1' }">
								<li class="has-sub">
									<a href="javascript:;">
									    <b class="caret pull-right"></b>
									    <i class="fa fa-video-camera"></i>
									    <span>${q.menuname }</span>
								    </a>
			                         <ul class="sub-menu">
			                         	<c:forEach items="${menulist }" var="w">
			                         		<c:if test="${w.pid==q.id }">
			                         			
			                         			<c:forEach items="${mymenulist }" var="e">
			                         				<c:if test="${w.id==e.menu_id }">
			                         			<li><a href="<%=path %>/${w.menuurl }" target="iframepage">${w.menuname }</a></li>
			                         			</c:if>
			                         			</c:forEach>
			                         		</c:if>
			                         	</c:forEach>
			                         </ul>
								 </li>
							</c:if>
						</c:forEach>
					</ul>
					<!-- end sidebar nav -->
				</div>
				<!-- end sidebar scrollbar -->
			</div>

			<!-- end #sidebar -->

			<!-- begin #content -->			<div id="content" class="content">
				<iframe    id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="100%" onLoad="iFrameHeight()" src="<%=path %>/view/nav.jsp" ></iframe>
			</div>

			<script type="text/javascript" language="javascript"> 
			function iFrameHeight() { 
			var ifm= document.getElementById("iframepage"); 
			var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument; 
			if(ifm != null && subWeb != null) { 
			ifm.height = subWeb.body.scrollHeight; 
			} 
			} 
			</script>




			<!-- end #content -->


		</div>
		<!-- end page container -->


	</body>
</html>
