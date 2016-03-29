function clickInfo(){
	$('#menu').show();
}


$(document).ready(function(){
	
    var tag = document.getElementById('cbdMap').getElementsByTagName('area');
	for(var i = 0; i<tag.length;i++) {
		(function(_i) {
			tag[_i].onmouseover = function() {
				 console.log(this.href);   //这一句是可修改的 
				 console.log(this.coords);
				 var pos = this.coords.split(',');
				 //var mouse = new MouseEvent();
				 //var x = mouse.x;
				 //var y = mouse.y;

				    $.ajax({
				    	url:"/tsur_shiro/gio/getChartData",
				    	success:function(data){
				    		alert(data);
				    	},
			    		dataType:text
				    });
				 $('#testDIV').show();
				 $('#testDIV').css("left",parseInt(pos[0]) + parseInt($('#cbdMap').offset().left));
				 $('#testDIV').css("top" , parseInt(pos[1]) + parseInt($('#cbdMap').offset().top));
			};
		})(i);
	}
    $('#test').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'aaa'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                     ['Firefox',   45.0],
                     ['IE',       26.8],
                     {
                         name: 'Chrome',
                         y: 12.8,
                         sliced: true,
                         selected: true
                     },
                     ['Safari',    8.5],
                     ['Opera',     6.2],
                     ['Others',   0.7]
                  ]
        }]
    });
});

function getOut(){
	$('#testDIV').hide();
}
function location(){
	$('#testDIV').hide();
}