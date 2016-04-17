(function (){
	//异步加载页面
	//个人信息页面,有些bug
	$("#personInfo").bind("click",function() {
		$.ajax({
			url:basePath+ "/MyInfo.do",
			type:'GET',
			 success: function(data){ 
	            	$("#page-inner").html(data);
	            },
	            error: function(data){
	                alert("gg");
	            }
		});
		addActive('#personInfo');
	});
	//认证页面
	$("#confirm").bind("click",function() {
		$.ajax({
			url:basePath + "/confirm.do",
			type:'GET',
			contentType:'application/json;charset=utf-8',
			success:function(data){
				$("#page-inner").html(data);
			},
            error: function(data){
                alert("gg");
            }
		});
		addActive('#confirm');
	});
	// 我的社团页面
	$("#myCommunity").bind("click",function() {
		$.ajax({ 
            url:basePath + "/getUserClubs.do", 
            type:'GET', 
            contentType:'application/json;charset=utf-8',
            success: function(data){ 
            	$("#page-inner").html(data);
            },
            error: function(data){
                alert("gg");
            }
        }); 
		addActive('#myCommunity');
	});
	
	//加入社团界面,获取所有的社团
	$("#joinCommunity").bind("click",function() {
		$.ajax({ 
            url:basePath + "/getAllClubs.do", 
            type:'GET', 
            contentType:'application/json;charset=utf-8',
            success: function(data){ 
            	$("#page-inner").html(data);
            },
            error: function(data){
                alert("gg");
            }
        }); 
		addActive('#joinCommunity');
	});
	
	//加入社团界面,获取所有的社团
	$("#createCommunity").bind("click",function() {
		$.ajax({ 
            url:basePath + "/toCreateCommunity.do", 
            type:'POST', 
            contentType:'application/json;charset=utf-8',
            success: function(data){ 
            	$("#page-inner").html(data);
            },
            error: function(data){
                alert("gg了吧");
            }
        }); 
		addActive('#createCommunity');
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
		$("#page-inner").load("myEvents.html");
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


