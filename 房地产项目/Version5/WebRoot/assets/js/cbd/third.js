$(document).ready(function(){
    var tag = document.getElementById('pingmianMap').getElementsByTagName('area');
	for(var i = 0; i<tag.length;i++) {
		(function(_i) {
			tag[_i].onmouseover = function() {
				 var pos = this.coords.split(',');
				 //var mouse = new MouseEvent();
				 //var x = mouse.x;
				 //var y = mouse.y;
				 if (this.alt == "预警房屋"){
				 	$('#testDIV').show();
					$('#testDIV').css("left",parseInt(pos[0]) + parseInt($('#pingmianImg').offset().left));
					$('#testDIV').css("top" , parseInt(pos[1]) + parseInt($('#pingmianImg').offset().top));
				 }
			};
			tag[_i].onmouseout = function() {
				 if (this.alt == "预警房屋"){
				 	$('#testDIV').hide();
				 }
			};
		})(i);
	}
});

function getOut(){
	$('#testDIV').hide();
}

function cancelDisplay(){
	$('#testDIV').hide();
}

function goBack(){
	window.location.href = "";
}

function backToIndex(){
	window.location.href = "";
}