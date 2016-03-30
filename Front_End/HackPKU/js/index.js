// 登陆注册窗口显示

(function(){
 	var lgLi=document.getElementById("lgmain").getElementsByTagName("li");
	var showlg_1=document.getElementById("showlg_1");
	var showlg_2=document.getElementById("showlg_2");
	for (var i = 0; i <lgLi.length ; i++) {
		if(i==0){
			lgLi[i].onclick = function(){
			showlg_1.style.display="block";
			showlg_2.style.display="none";
			}
		}else{
			lgLi[i].onclick = function(){
			showlg_2.style.display="block";
			showlg_1.style.display="none";
			}
		}	
	};

	var login_index=document.getElementById("login_index");
	var signup_index=document.getElementById("signup_index");
	var exit = document.getElementById("exit");
	login_index.onclick = function (){
		login(2);
	}
	signup_index.onclick = function (){
		login(1);
	}
	exit.onclick = function (){
		noshow();
	}
})();

//登陆与注册模块显示
function login (i) {
	var loginbg = document.getElementById('loginbg');
	var lgmain = document.getElementById('lgmain');
	var showlg_1 = document.getElementById('showlg_1');
	var showlg_2 = document.getElementById('showlg_2');
	var register_active = document.getElementById('register_active');
	var login_active = document.getElementById('login_active');
	loginbg.style.display = "block";
	lgmain.style.display = "block";
	if(i==1){
		showlg_1.style.display = "block";
		showlg_2.style.display = "none";
		register_active.className = "active";
		login_active.className = "";
	}else{
		showlg_1.style.display = "none";
		showlg_2.style.display = "block";
		register_active.className = "";
		login_active.className = "active";
	}
}
//登陆与注册模块隐藏
function noshow() {
	var loginbg = document.getElementById('loginbg');
	var lgmain = document.getElementById('lgmain');
	loginbg.style.display = "none";
	lgmain.style.display = "none";
}


