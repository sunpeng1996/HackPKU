(function($) {
	$.zgx_dialog = function(options) {
		$.zgx_dialog.defaults = {
			width: 300,
			height: 200,
			url:'',
			title: '消息',
			scroll:true
		};
		var opts = $.extend(true, $.zgx_dialog.defaults, options);
		
		
		(function(opts) {
			dialog();
		})(opts);
		
		function dialog() {
			var html = "";
			html += '<div id="zgx_zhe"></div>';
			html += '<div id="zgx_tip">';
			html += '<div id="zgx_tiptop"><span id="zgx_tiptop_span">'+opts.title+'</span><a id="zgx_tiptop_a"></a>';
			html += '</div>';
			html += '<div id="zgx_tipinfo" style="height:'+(opts.height-40)+'px;">';
			if(opts.scroll){
				html += '<iframe style="border:none;" width="100%" height="100%" src="'+opts.url+'"></iframe>';
			} else {
				html += '<iframe scrolling="no" width="100%" height="100%" src="'+opts.url+'"></iframe>';
			}
			html += '</div>';
			html += '</div>';
			$("body").append(html);
			dialog_css();
		};
		
		function dialog_css() {
			$("#zgx_zhe").css({
				width: '100%',
				height: '100%',
				top:0,
				position:'absolute',
				background:'#fff',
				zIndex:'111110',
				opacity:0
			});
			$("#zgx_tip").css({
				width: opts.width + 'px',
				height: opts.height + 'px',
				position:'absolute',
				top:'10%',
				left: '50%',
				marginLeft:'-' + (opts.width/2) + 'px',
				background:'#fcfdfd',
				boxShadow:'1px 8px 10px 1px #9b9b9b',
				borderRadius:'1px',
				behavior:'url(js/pie.htc)',
				zIndex:'111111'
			});
			
			$("#zgx_tiptop").css({
				height:'40px',
				lineHeight:'40px',
				background:'#5B9AA9',
				cursor:'pointer'
			});
			
			$("#zgx_tiptop_span").css({
				fontSize:'14px',
				fontWeight:'bold',
				color:'#fff',
				float:'left',
				textIndent:'20px'
			});
			$("#zgx_tiptop_a").css({
				display:'block',
				background:'url(./assets/plugins/dialog/close.png) no-repeat',
				width:'22px',
				height:'22px',
				float:'right',
				marginRight:'7px',
				marginTop:'10px',
				cursor:'pointer'
			});
			$("#zgx_tipinfo").css({
				textAlign:'center',
				width:'100%',
				marginLeft:'0%',
				height:'93%'
			});
			
		}
		
		$("#zgx_tiptop_a").hover(function() {
			$(this).css({'background':'url(./assets/plugins/dialog/close1.png) no-repeat'});
		},function(){
			$(this).css({'background':'url(./assets/plugins/dialog/close.png) no-repeat'});
		});
		
		$("#zgx_tiptop_a").click(function() {
			$("#zgx_zhe").remove();
			$("#zgx_tip").remove();
		});
		
	}
})(jQuery);