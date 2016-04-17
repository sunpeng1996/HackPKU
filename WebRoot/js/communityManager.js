
(function (){
	//异步加载页面
	//个人信息页面
	$("#personInfo").bind("click",function() {
		$("#page-inner").load("personInfo.html");
		addActive('#personInfo');
	});
	//社团信息
	$("#clubmessage").bind("click",function() {
		loadPage("/clubmessage.do");
	});
	//社团成员
	$("#clubmember").bind("click",function() {
		loadPage("/clubmember.do");
	});
	
	// 我的社团页面
	$("#myCommunity").bind("click",function() {
		$("#page-inner").load("myCommunity.html");
		addActive('#myCommunity');
	});
	// 我的任务页面
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
	// 查看日程页面
	$("#myEvents").bind("click",function() {
		loadPage("/scheduel.do");
	});
	// 社团日志
	$("#communityNews").bind("click",function() {
		loadPage("/clubnews.do");
	});
	// 社团信息变更页面
	$("#communityInfoChange").bind("click",function() {
		loadPage("/editclubmessage.do");
		
	});
	$("#distributeActivity").bind("click",function() {
		loadPage("/distributeactivity.do");
	});
	// 社团成员调整
	$("#communityMemChange").bind("click",function() {
		loadPage("/adjustclubmember.do");
	});
	// 社团角色分配
	$("#communityPosChange").bind("click",function(menu_id) {
		loadPage("/delegateclubrole.do");
	});
	
	// 编辑活动状态
	$("#evaluateActivity").bind("click",function() {
		loadPage("/evaluateactivity.do");
	});
	
	// 社团角色管理
	$("#communityPosManage").bind("click",function() {
		loadPage("/showRoles.do");
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


