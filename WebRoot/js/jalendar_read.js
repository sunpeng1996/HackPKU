

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
            var lAllDay = {};
            var lTotalEvents = {};
            var lEvent = {};
            dayNames['EN'] = new Array('Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun');
            dayNames['TR'] = new Array('Pzt', 'Sal', 'Çar', 'Per', 'Cum', 'Cmt', 'Pzr');
            dayNames['ES'] = new Array('Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Såb', 'Dom');
            monthNames['EN'] = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'); 
            monthNames['TR'] = new Array('Ocak', 'Şubat', 'Mart', 'Nisan', 'Mayıs', 'Haziran', 'Temmuz', 'Ağustos', 'Eylül', 'Ekim', 'Kasım', 'Aralık'); 
            monthNames['ES'] = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'); 
            lAddEvent['EN'] = 'Add New Event';
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
                    $this.find('.day').eq(startDay-1).addClass('this-month').attr('data-date', i+'/'+(month+1)+'/'+year).html(i);

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
           var $close = $this.find('.add-event > .close-button');
            $this.find('.jalendar-pages').css({'width' : $this.find('.jalendar-pages').width() });
            // calculate for scroll
            function calcScroll() {
                if ( $this.find('.events-list').height() < $this.find('.events').height() ) { $this.find('.gradient-wood').hide(); $this.find('.events-list').css('border', 'none'); } else { $this.find('.gradient-wood').show(); }
            }
            
            // Calculate total event again
            function calcTotalDayAgain() {
                var eventCount = $this.find('.this-month .event-single').length;
//                $this.find('.total-bar b').text(eventCount);
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
                loadEventDays();
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
                loadEventDays();
                prevAddEvent();
            });            
            
            // add new event with panel
            var dataId = parseInt($this.find('.total-bar b').text());
            var addEvent =  function(taskname,summary,totalscore,members,start_hour,start_min,end_hour,end_min,thisDay){
                var start_time;
                var end_time;
                start_time = start_hour + ':' + start_min;
                end_time = end_hour + ':' + end_min;
                $this.prepend(div('div', 'added-event').attr({'data-date':thisDay, 'data-start-time': start_time, 'data-end-time': end_time,'data-title': taskname, 'data-id': dataId}));
                $this.find('.day.this-month.selected').prepend(
                    div('div','event-single').attr('data-id', dataId).append(
                        div('p','').text(taskname + "score:" + totalscore),      
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
            //动态加载New标签,并注册点击事件
            function loadEventDays(){
            	$.ajax({ 
                    url:basePath + "/getDateList.do", 
                    type:'GET', 
                    contentType:'application/json;charset=utf-8',
                    data:{
                    	month_now:month+1
                    },
                    success: function(data){ 
                    	for(var i in data){
                    		$this.find(".day").map(function(){
                    			var day_selected = $(this).text();
                    			if(day_selected == data[i]){
                    				$(this).on('click',function () {
                    	                prevAddEvent();

                    	                $(this).addClass('selected').css({'background-color': settings.color});
                    	                $this.children('.jalendar-wood').animate('', 200, function() {
                    	                	$.ajax({ 
                    	                        url:basePath+"/getUserEventPerDay.do", 
                    	                        type:'GET', 
                    	                        contentType:'application/json;charset=utf-8',
                    	                        data:{
                    	                        	month_now: month+1,
                    	                        	day_now:day_selected
                    	                        },
                    	                        success: function(data){
                    	                            $this.find('.event-single').remove();
                    	                        	for(var i in data){
                    	                        		addEvent(data[i].taskname,data[i].summary,data[i].totalscore,data[i].members,data[i].start_hour,data[i].start_min,data[i].end_hour,data[i].end_min,data[i].thisDay);
                    	                        	}
                    	                        },
                    	                        error: function(data){
                    	                            alert("fail");
                    	                        }
                    	                    }); 
                    	                    $this.find('.add-event').show().find('.events-list');
                    	                    $this.find('.add-new input').select();
                    	                    calcTotalDayAgain();
                    	                    calcScroll();
                    	                    $close.show();
                    	                });
                    	            });
                    				return this;
                    			}
                    		}).removeClass('have-event').prepend(div('i','').text('New')); 
                    	}
                    },
                    error: function(data){
                        alert("fail");
                    }
                }); 
            }
            loadEventDays();
            $close.on('click', function(){
                prevAddEvent(); 
            });
        };

    }(jQuery));
    
});

