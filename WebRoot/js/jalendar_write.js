
var memberIds = new Array();
var members = new Array();
$(function () {    
    (function ($) {
        $.fn.jalendar = function (options) {
            
            var settings = $.extend({
                customDay: new Date(),
                color: '#65c2c0',
                lang: 'EN'
            }, options);
            // Languages            
            var dayNames = {};
            var monthNames = {};
            var lAddEvent = {};
            var lAddEventBody = {};
            var lAllDay = {};
            var lTotalEvents = {};
            var lEvent = {};
            dayNames['EN'] = new Array('Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun');
            dayNames['TR'] = new Array('Pzt', 'Sal', 'Çar', 'Per', 'Cum', 'Cmt', 'Pzr');
            dayNames['ES'] = new Array('Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Såb', 'Dom');
            monthNames['EN'] = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'); 
            monthNames['TR'] = new Array('Ocak', 'Şubat', 'Mart', 'Nisan', 'Mayıs', 'Haziran', 'Temmuz', 'Ağustos', 'Eylül', 'Ekim', 'Kasım', 'Aralık'); 
            monthNames['ES'] = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'); 
            lAddEvent['EN'] = 'Add Event Title';
            lAddEventBody['EN'] = 'Add Event Summary';
            lAddEvent['TR'] = 'Yeni Etkinlik Ekle';
            lAddEvent['ES'] = 'Agregar Un Nuevo Evento';
            lAllDay['EN'] = 'All Day';
            lAllDay['TR'] = 'Tüm Gün';
            lAllDay['ES'] = 'Todo El Día';
            lTotalEvents['EN'] = 'Total Events in This Month: ';
            lTotalEvents['TR'] = 'Bu Ayki Etkinlik Sayısı: ';
            lTotalEvents['ES'] = 'Total De Eventos En Este Mes: ';
            lEvent['EN'] = 'Event(s)';
            lEvent['TR'] = 'Etkinlik';
            lEvent['ES'] = 'Evento(s)';
            
            
            var $this = $(this);
            var div = function (e, classN) {
                return $(document.createElement(e)).addClass(classN);
            };
            
            var clockHour = [];
            var clockMin = [];
            for (var i=0;i<24;i++ ){
                clockHour.push(div('div', 'option').text(i))
            }
            for (var i=0;i<59;i+=5 ){
                clockMin.push(div('div', 'option').text(i))
            }
            var clockHour_1 = [];
            var clockMin_1 = [];
            for (var i=0;i<24;i++ ){
                clockHour_1.push(div('div', 'option').text(i))
            }
            for (var i=0;i<59;i+=5 ){
                clockMin_1.push(div('div', 'option').text(i))
            }
            // HTML Tree
            $this.append(
//                div('div', 'fixed-event'),
                div('div', 'jalendar-wood').append(
                    div('div', 'jalendar-pages').append(
                        div('div', 'pages-bottom'),
                        div('div', 'header').css('background-color', settings.color).append(
                                div('a', 'prv-m'),
                                div('h1'),
                                div('a', 'nxt-m'),
                                div('div', 'day-names')
                            ),
                        div('div', 'total-bar').html( lTotalEvents[settings.lang] + '<b style="color: '+settings.color+'"></b>'),
                        div('div', 'days clearfix')
                    ),

                    div('div', 'add-event').append(
                        div('div', 'close-button'),
                        div('div', 'add-new').append(
                            '<input type="text" class="eventTitle" placeholder="' + lAddEvent[settings.lang] + '" value="' + lAddEvent[settings.lang] + '" />',
                            '<input type="text" class="eventScore" placeholder="Score" />',
                            '<input type="text" class="eventSummary" placeholder="' + lAddEventBody[settings.lang] + '" value="' + lAddEventBody[settings.lang] + '" />',
                            div('div', 'submit'),
                            div('div', 'clear'),
                            div('div', 'add-time').append(
                                div('div', 'disabled'),
                                div('div', 'select').addClass('hour').css('background-color', settings.color).append(
                                    div('span').text('00'),
                                    div('div', 'dropdown').append(clockHour)
                                ),
                                div('div', 'left').append(':'),
                                div('div', 'select').addClass('min').css('background-color', settings.color).append(
                                    div('span').text('00'),
                                    div('div', 'dropdown').append(clockMin)
                                )
                            ),
                            div('span','time-between').text('To'),
                            div('div', 'add-time').append(
                                div('div', 'disabled'),
                                div('div', 'select').addClass('hour').css('background-color', settings.color).append(
                                    div('span').text('00'),
                                    div('div', 'dropdown').append(clockHour_1)
                                ),
                                div('div', 'left').append(':'),
                                div('div', 'select').addClass('min').css('background-color', settings.color).append(
                                    div('span').text('00'),
                                    div('div', 'dropdown').append(clockMin_1)
                                )
                            ),

                            div('div', 'clear'),
                            div('div','people').append(
                                div('span','').text('成员：'),
                                div('div','members'),
                                '<a href="javascript:void(0)" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">Add</a>'
                                )
                        ),
                        div('div', 'events').append(
                            div('h3','').append(
                                div('span', '').html('<b></b> ' + lEvent[settings.lang])
                            ),
                            div('div', 'gradient-wood'),
                            div('div', 'events-list')
                        )
                    )
                )
            );
            
            // Adding day boxes
            for (var i = 0; i < 42; i++) {
                $this.find('.days').append(div('div', 'day'));
            }
            
            // Adding day names fields
            for (var i = 0; i < 7; i++) {
                $this.find('.day-names').append(div('h2').text(dayNames[settings.lang][i]));
            }

            var d = new Date(settings.customDay);
            var year = d.getFullYear();
            var date = d.getDate();
            var month = d.getMonth();
            var isLeapYear = function(year1) {
                var f = new Date();
                f.setYear(year1);
                f.setMonth(1);
                f.setDate(29);
                return f.getDate() == 29;
            };
        
            var feb;
            var febCalc = function(feb) { 
                if (isLeapYear(year) === true) { feb = 29; } else { feb = 28; } 
                return feb;
            };
            var monthDays = new Array(31, febCalc(feb), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

            function calcMonth() {

                monthDays[1] = febCalc(feb);
                
                var weekStart = new Date();
                weekStart.setFullYear(year, month, 0);
                var startDay = weekStart.getDay();  
                
                $this.find('.header h1').html(monthNames[settings.lang][month] + ' ' + year);
        
                $this.find('.day').html('&nbsp;');
                $this.find('.day').removeClass('this-month');
                for (var i = 1; i <= monthDays[month]; i++) {
                    startDay++;
                        $this.find('.day').eq(startDay-1).addClass('this-month').attr('data-date', i+'/'+(month+1)+'/'+year).html("<div class='daycode'>"+i+"</div>");
                }
                if ( month == d.getMonth() ) {
                    $this.find('.day.this-month').removeClass('today').eq(date-1).addClass('today').css('color', settings.color);
                } else {
                    $this.find('.day.this-month').removeClass('today').attr('style', '');
                }
                
                // added event
                $this.find('.added-event').each(function(i){
                    $(this).attr('data-id', i);
                    $this.find('.this-month[data-date="' + $(this).attr('data-date') + '"]').append(
                        div('div','event-single').attr('data-id', i).append(
                            div('p','').text($(this).attr('data-title')),
                            div('div','details').append(
                                div('div', 'clock').text($(this).attr('data-time')),
                                div('div', 'erase')
                            )
                        )
                    );
                    $this.find('.day').has('.event-single').addClass('have-event').prepend(div('i',''));
                });
                
                calcTotalDayAgain();  
                
            }
            
            calcMonth();
            
            var arrows = new Array ($this.find('.prv-m'), $this.find('.nxt-m'));
            var dropdown = new Array ($this.find('.add-time .select span'), $this.find('.add-time .select .dropdown .option'), $this.find('.add-time .select'));
            var allDay = new Array ('.all-day fieldset[data-type="disabled"]', '.all-day fieldset[data-type="enabled"]');
            var $close = $this.find('.add-event > .close-button');
            var $erase = $this.find('.event-single .erase');
            $this.find('.jalendar-pages').css({'width' : $this.find('.jalendar-pages').width() });
            // $this.find('.events').css('height', ($this.height()-197) );
            $this.find('.select .dropdown .option').hover(function() {
                $(this).css('background-color', settings.color); 
            }, function(){
                $(this).css('background-color', 'inherit'); 
            });
            var jalendarWoodW = $this.find('.jalendar-wood').height();

            // calculate for scroll
            function calcScroll() {
                if ( $this.find('.events-list').height() < $this.find('.events').height() ) { $this.find('.gradient-wood').hide(); $this.find('.events-list').css('border', 'none') } else { $this.find('.gradient-wood').show(); }
            }
            
            // Calculate total event again
            function calcTotalDayAgain() {
                var eventCount = $this.find('.this-month .event-single').length;
                $this.find('.total-bar b').text(eventCount);
                $this.find('.events h3 span b').text($this.find('.events .event-single').length)
            }
            
            function prevAddEvent() {
                $this.find('.day').removeClass('selected').removeAttr('style');
                $this.find('.today').css('color', settings.color);
                $this.find('.add-event').hide();
                // $this.children('.jalendar-wood').animate({'height' : jalendarWoodW}, 200);
                $close.hide();
            }
            
            arrows[1].on('click', function () {
                if ( month >= 11 ) {
                    month = 0;
                    year++;
                } else {
                    month++;   
                }
                calcMonth();
                loadTaskFlag();
                prevAddEvent();
            });
            arrows[0].on('click', function () {
                dayClick = $this.find('.this-month');
                if ( month === 0 ) {
                    month = 11;
                    year--;
                } else {
                    month--;   
                }
                calcMonth();
                loadTaskFlag();
                prevAddEvent();
            });

            
            //点击某日，弹出框框
            $this.on('click', '.this-month', function () {

            	var txt = $(this).find(".daycode").text();
                var eventSingle = $(this).find('.event-single')
                $this.find('.events .event-single').remove();
                prevAddEvent();
                $(this).addClass('selected').css({'background-color': settings.color});
    			$.ajax({ 
                    url:basePath+"/getAdminTaskPerDay.do", 
                    type:'GET', 
                    contentType:'application/json;charset=utf-8',
                    data:{
                    	month_now: month+1,
                    	day_now:txt
                    },
                    success: function(data){
                    	if(data.length > 0){
	                        $this.find('.event-single').remove();
	                        for (var i = 0; i < data.length; i++) {
                        		addEvent(data[i].task_id,data[i].taskname,data[i].summary,data[i].totalscore,data[i].members,data[i].start_hour,data[i].start_min,data[i].end_hour,data[i].end_min,data[i].thisDay);
                        	}
                    	}
                    },
                    error: function(data){
                        alert("fail");
                    }
                }); 
                $this.children('.jalendar-wood').animate('', 200, function() {
                    $this.find('.add-event').show().find('.events-list').html(eventSingle.clone())
                    $this.find('.add-new input').select();
                    calcTotalDayAgain();
                    calcScroll();
                    $close.show();
                });
            });
            
            dropdown[0].click(function(){
                dropdown[2].children('.dropdown').hide(0);
                $(this).next('.dropdown').show(0);
            });
            dropdown[1].click(function(){
                $(this).parent().parent().children('span').text($(this).text());
                dropdown[2].children('.dropdown').hide(0);
            });
            $('html').click(function(){
                dropdown[2].children('.dropdown').hide(0); 
            });
            $('.add-time .select span').click(function(event){
                event.stopPropagation(); 
            });
            
            $this.on('click', allDay[0], function(){
                $(this).removeAttr('data-type').attr('data-type', 'enabled').children('.check').children().css('background-color', settings.color);
                dropdown[2].children('.dropdown').hide(0);
                $(this).parents('.all-day').prev('.add-time').css('opacity', '0.4').children('.disabled').css('z-index', '10');
            });
            $this.on('click', allDay[1], function(){
                $(this).removeAttr('data-type').attr('data-type', 'disabled').children('.check').children().css('background-color', 'transparent');
                $(this).parents('.all-day').prev('.add-time').css('opacity', '1').children('.disabled').css('z-index', '-1');
            });
            
            // add new event with panel
            var dataId = parseInt($this.find('.total-bar b').text());
            $this.find('.submit').on('click', function(){

                var title = $(this).parent('.add-new').find('.eventTitle').val();
                var totalscore = $(this).parent('.add-new').find('.eventScore').val();
                var summary = $(this).prev('.eventSummary').val();
                var members = $(this).parents('.add-new').find('.people').find('.members').html();
                var start_hour = $(this).parents('.add-new ').find('.add-time:first').find('.hour > span').text();
                var start_min = $(this).parents('.add-new ').find('.add-time:first').find('.min > span').text();
                var end_hour = $(this).parents('.add-new ').find('.add-time:last').find('.hour > span').text();
                var end_min = $(this).parents('.add-new ').find('.add-time:last').find('.min > span').text();
                var thisDay = $this.find('.day.this-month.selected').attr('data-date');
              
	             $.ajax({ 
	                    url:basePath + "/addTask.do", 
	                    type:'GET', 
	                    contentType:'application/json;charset=utf-8',
	//                    data:'taskname='+title+'&totalscore='+totalscore+'&summary='+summary+'&members='+members+'&start_hour='+start_hour+'&start_min='+start_min+'&end_hour='+end_hour+'&end_min='+end_min+'&thisDay='+thisDay,
	                    data:{
	                    	memberIds:memberIds,
	                    	taskname:title,
	                    	totalscore:totalscore,
	                    	summary:summary,
	                    	start_hour:start_hour,
	                    	start_min:start_min,
	                    	end_hour:end_hour,
	                    	end_min:end_min,
	                    	thisDay:thisDay
	                    },
	                    success: function(data){    
	                    	
	                    	addEvent(data,title,summary,totalscore,members,start_hour,start_min,end_hour,end_min,thisDay);
	
	                        loadTaskFlag();
	                    },
	                    error: function(data){
	                        alert("请检查您的网络或者未添加成员!");
	                    }
	             }); 
            });
            var addEvent =  function(task_id,taskname,summary,totalscore,members,start_hour,start_min,end_hour,end_min,thisDay){
                var start_time;
                var end_time;
                start_time = start_hour + ':' + start_min;
                end_time = end_hour + ':' + end_min;
                $this.prepend(div('div', 'added-event').attr({'task_id':task_id,'data-date':thisDay, 'data-start-time': start_time, 'data-end-time': end_time,'data-title': taskname, 'data-id': dataId}));
                $this.find('.day.this-month.selected').prepend(
                    div('div','event-single').attr('data-id', dataId).attr('task_id',task_id).append(
                        div('p','').html(taskname + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;score:" + totalscore),      
                        div('p','').text(summary),
                        div('div','details').append(
                            div('div', 'clock').text('From' +'   '+ start_time + '   To   ' +end_time),
                            div('div', 'target-people').text(members),
                            div('div', 'erase')
                        )
                    )
                );
                $this.find('.events-list').html($this.find('.day.this-month.selected .event-single').clone());
                $this.find('.events-list .event-single').eq(0).hide().slideDown();
                calcTotalDayAgain();
                calcScroll();
                // scrolltop after adding new event
                $this.find('.events-list').scrollTop(0);
                dataId++;
            };
            var loadTaskFlag = function(){
            	$.ajax({ 
                    url:basePath + "/getDateListAdmin.do", 
                    type:'GET', 
                    contentType:'application/json;charset=utf-8',
                    data:{
                    	month_now: month+1
                    },
                    success: function(data){ 
                 	   for(var i in data){
                    		$this.find(".day").map(function(){
                    			var day_selected = $(this).find('.daycode').text();
                    			if(day_selected == data[i]){
                    				return this;
                    			}
                    		}).removeClass('have-event').prepend(div('i','').text('Task')); 
                    	}       
                    },
                    error: function(data){
                        alert("fail");
                    }
                }); 
            };
           
            loadTaskFlag();
            $close.on('click', function(){
                prevAddEvent(); 
            });
            
            // delete event
            $this.on('click', '.event-single .erase', function(){
            	var data_id = $(this).parent('.details').parent('.event-single').attr('task_id');
            	var this_tmp = $(this);
            	$.ajax({ 
                    url:basePath + "/deleteTask.do", 
                    type:'GET', 
                    contentType:'application/json;charset=utf-8',
                    data:{
                    	data_id:data_id
                    },
                    success: function(data){ 
                        $('div[data-id=' + this_tmp.parent('.details').parents(".event-single").attr("data-id") + ']').animate({'height': 0}, function(){ 
                        	$(this).remove();
                            calcTotalDayAgain();
                            calcScroll();
                        });
                        
                    },
                    error: function(data){
                        alert("gg");
                    }
                }); 
            	
            	
            });

        };
        
    }(jQuery));
    var showmembers = function(){            	
        $(".members").html(function(){
            return members.join(" ");
        });
    }
    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    $(function () {
       $(".dropdown-menu > li > a").click(function(){
    	   var id = parseInt($(this).attr("id").replace("a_",""));
           var val = $(this).html();
           if(members.indexOf(val) == -1){
	           $(".well").html(function(index,value){	        	   
	        	   memberIds.push(id);
	        	   members.push(val);
	               return value + "<a href='javascript:void(0)' class='a_inserted'><span class='badge' id='span_"+id+"'>" + val+ "</span></a>";
	               
	           });
	           showmembers();
	           $(".well > a:last-child").insertBefore("#plus");
	           badge_bind();
           }else{
        	   alert('请不要重复添加');
           }
       });
       badge_bind();
       
   });
   function badge_bind(){
	   
	   var name = "";
       $(".well > a > .badge").mouseover(function(){
           $(this).html(function(index,value){
        	   name = value;
               return value+"<span class='glyphicon glyphicon-remove'></span>";
           });
       }).mouseout(function(){
           $(this).html(function(index,value){
               var index_  =  value.indexOf("span");
               if(index_ != -1){
                   return value.substring(0,index_-1);
               }
           });
       }).click(function(){
    	   var id = parseInt($(this).attr("id").replace("span_",""));
           $(this).parent().remove();
           memberIds.remove(id);
    	   members.remove(name);
    	   showmembers();
       });
   }
    
});

