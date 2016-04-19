var basePath = "http://localhost:8080/Quiclub";
//var basePath = "http://quiclub.mybluemix.net/";
function loadPage(action){
	$.ajax({ 
        url:basePath + action, 
        type:'GET', 
        contentType:'application/json;charset=utf-8',
        success: function(data){ 
        	$("#page-inner").html(data);
        },
        error: function(data){
            alert("gg");
        }
    }); 
}