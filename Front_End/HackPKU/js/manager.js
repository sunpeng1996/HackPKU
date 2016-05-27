(function (){
	//异步加载页面
	//个人信息页面
	$("#personInfo").bind("click",function() {
		$("#page-inner").load("personInfo.html");
		addActive('#personInfo');
	});
	//认证页面
	$("#confirm").bind("click",function() {
		$("#page-inner").load("confirm.html");
		addActive('#confirm');
	});
	// 我的社团页面
	$("#myCommunity").bind("click",function() {
		$("#page-inner").load("myCommunity.html");
		addActive('#myCommunity');
	});
	// 历史任务页面
	$("#myTask").bind("click",function() {
		$("#page-inner").load("myTask.html");
		addActive('#myTask');
	});
	// 消息管理页面
	$("#messageManage").bind("click",function() {
		$("#page-inner").load("messageManage.html");
		addActive('#messageManage');
	});
	// 编辑信息页面
	$("#edit-Info").bind("click",function() {
		$("#page-inner").load("addInfo.html");
	})
	// 创建社团页面
	$("#createCommunity").bind("click",function() {
		$("#page-inner").load("createCommunity.html");
	})
	// 加入社团页面
	$("#joinCommunity").bind("click",function() {
		$("#page-inner").load("joinCommunity.html");
	})
	// 推荐社团页面
	$("#goodCommunities").bind("click",function() {
		$("#page-inner").load("goodCommunities.html");
		addActive('#goodCommunities');
	});
	// 推荐社团查看活动页面
	$("#goodActivities").bind("click",function() {
		
		$("#page-inner").load("goodActivities.html");
	});

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


