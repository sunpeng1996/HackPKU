(function (){
	$("#personInfo").bind("click",function() {
		$("#page-inner").load("personInfo.html #pageInfo");
		addActive('#personInfo');
	});
	$("#confirm").bind("click",function() {
		$("#page-inner").load("confirm.html");
		addActive('#confirm');
	});
	$("#myCommunity").bind("click",function() {
		$("#page-inner").load("myCommunity.html");
		addActive('#myCommunity');
	});
	$("#myTask").bind("click",function() {
		$("#page-inner").load("myTask.html");
		addActive('#myTask');
	});
	$("#messageManage").bind("click",function() {
		$("#page-inner").load("messageManage.html");
		addActive('#messageManage');
	});
	$("#edit-Info").bind("click",function() {
		$("#page-inner").load("addInfo.html");
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

//退出任务
function quitTask() {
	var task = document.getElementById("tasks");
	task.style.display = "none";
}

