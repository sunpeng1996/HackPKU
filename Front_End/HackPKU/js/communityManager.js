(function (){
	//异步加载页面
	//社团主页
	$("#communityMain").bind("click",function() {
		$("#page-inner").load("communityMain.html");
		addActive('#communityMain');
	});
	//社团信息
	$("#communityInfo").bind("click",function() {
		$("#page-inner").load("communityInfo.html");
		addActive('#communityInfo');
	});
	// 社团日志页面
	$("#communityNews").bind("click",function() {
		$("#page-inner").load("communityNews.html");
		addActive('#communityNews');
	});
	// 社团论坛页面
	$("#communityBBS").bind("click",function() {
		$("#page-inner").load("communityBBS.html");
		addActive('#communityBBS');
	});
	// 社团管理添加active类
	$("#communityManage").bind("click",function() {
		addActive('#communityManage');
	});
	// 社团活动添加active类
	$("#communityActivity").bind("click",function() {
		addActive('#communityActivity');
	});
	// 编辑信息页面
	$("#edit-Info").bind("click",function() {
		$("#page-inner").load("addInfo.html");
	})
	// 查看日程页面
	$("#myEvents").bind("click",function() {
		$("#page-inner").load("myEvents.html");
	})
	// 社团日志更新
	$("#publishNews").bind("click",function() {
		$("#page-inner").load("publishNews.html");
	})
	// 社团信息变更页面
	$("#communityInfoChange").bind("click",function() {
		$("#page-inner").load("communityInfoChange.html");
	})
	// 社团成员调整
	$("#communityMemChange").bind("click",function() {
		$("#page-inner").load("communityMemChange.html");
	})
	// 社团角色分配
	$("#communityPosChange").bind("click",function() {
		$("#page-inner").load("communityPosChange.html");
	})
	// 社团角色管理
	$("#communityPosManage").bind("click",function() {
		$("#page-inner").load("communityPosManage.html");
	})
	// 任务评分
	$("#taskCommon").bind("click",function() {
		$("#page-inner").load("taskCommon.html");
	})
})();

//活跃的菜单按钮添加样式
function addActive(index) {
	var menu_li = document.getElementById('main-menu').getElementsByTagName('li');
	for (var i = 0; i < menu_li.length; i++) {
		var menu_a = menu_li[i].getElementsByTagName('a')[0];
		menu_a.removeAttribute("class","active-menu");
	};
	$(index).addClass("active-menu");
}


