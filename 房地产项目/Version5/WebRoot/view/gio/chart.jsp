<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.page import="com.common.Util"/>
<%@ include file="/view/common/common.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'chart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
	 /* 
	 $(function () { 
	 	var all_charts = $(".myChart");
	 	for (var i = 0; i < all_charts.length; ++i) {
	 			$(all_charts[i]).highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: 'Browser market shares at a specific website, 2014'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: ${result}
        }]
    });
    
    all_charts.css({
    	"position": "absolute",
    });
    
    	function DoLayout() {
    		var win_width = $(window).width();
    		
    		var chart_width = win_width / 2, chart_height = chart_width;
    		var cur_x = 0, cur_y = 0;
    		
    		for (var i = 0; i < all_charts.length; ++i) {
    			if (cur_x != 0 && cur_x + chart_width > win_width) {
    				cur_x = 0;
    				cur_y += chart_height;
    			}
    			$(all_charts[i]).css({
    				"left": cur_x,
    				"top": cur_y,
    				"width": chart_width,
    				"height": chart_height,
    			});
    			cur_x += chart_width;
    			if (cur_x > win_width) {
    				cur_x = 0;
    				cur_y += chart_height;
    			}
    		}
    	}
    	DoLayout();
    	$(window).resize(DoLayout);
	 	}
	 });
   */
   </script>
	</script>
	<script type="text/javascript">
		$(function () {
    $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '${bname}'
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
            data: ${data}
        }]
    });
});
	</script>
  </head>
  
  <body>
  	
		<form action="<%=path%>/gio/showChart" method="post" id="form1" name="form1">
			<input type="hidden" id="currentPage" name="currentPage" value="1" />
			<!-- begin breadcrumb -->

			<!-- end breadcrumb -->
			<!-- begin page-header -->

			<!-- end page-header -->

			<!-- begin row -->
			<div class="row">
				<!-- begin col-12 -->
				<div class="col-md-12">
					<!-- begin panel -->
					<div class="panel panel-inverse">
						<div class="panel-heading">

							<h4 class="panel-title">
								分楼宇税收情况统计（地税当年累计数）
							</h4>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
							
								<div class="dataTables_filter">
									<label>
										楼宇：
												<select id="lyid" name="lyid">
                                 					<%=Util.getOption("select id,lymc from t_lyjcxx order by id") %>
                                 				</select>
										<a class="btn btn-success btn-sm" href="javascript:$('#form1').submit();"><i class="fa fa-search"></i> </a>
									</label>
								</div>
							
								<!-- #modal-dialog-del -->
								<table
									class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										
									</thead>
									<tbody>
										<tr><td>
  	<div id="container" style="height: 400px"></div>
										</td></tr>
									</tbody>
								</table>
								</div></div></div>
								
		</form>
  </body>
</html>
