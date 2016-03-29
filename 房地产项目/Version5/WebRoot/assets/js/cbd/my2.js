function clickInfo(){
	$('#menu').show();
}


$(document).ready(function(){
    var tag = document.getElementById('cbdMap').getElementsByTagName('area');
	for(var i = 0; i<tag.length;i++) {
		(function(_i) {
			tag[_i].onmouseover = function() {
				 console.log(this.href);   /*这一句是可修改的*/ 
				 console.log(this.coords);
				 var pos = this.coords.split(',');
				 //var mouse = new MouseEvent();
				 //var x = mouse.x;
				 //var y = mouse.y;
				 $('#testDIV').show();
				 $('#testDIV').css("left",parseInt(pos[0]) + parseInt($('#cbdMap').offset().left));
				 $('#testDIV').css("top" , parseInt(pos[1]) + parseInt($('#cbdMap').offset().top));
			};
		})(i);
	}
});

function getOut(){
	$('#testDIV').hide();
}