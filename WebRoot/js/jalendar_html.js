////////////////////////////////
// Author: Bora DAN — http://codecanyon.net/user/bqra
// 18 August 2013
// E-mail: bora_dan@hotmail.com
////////////////////////////////

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
                    if (i == date) {
                        $this.find('.day').eq(startDay-1).addClass('this-month').attr('data-date', i+'/'+(month+1)+'/'+year).html('Today');
                    }else{
                        $this.find('.day').eq(startDay-1).addClass('this-month').attr('data-date', i+'/'+(month+1)+'/'+year).html(i);
                    }
                    
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
				if ($this.find('.events-list').height() < $this.find('.events').height()) {
					$this.find('.gradient-wood').hide();
					$this.find('.events-list').css('border', 'none')
				} else {
					$this.find('.gradient-wood').show();
				}
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
                prevAddEvent();
            });
            
            $this.on('click', '.this-month', function () {
                var eventSingle = $(this).find('.event-single')
                $this.find('.events .event-single').remove();
                prevAddEvent();
                $(this).addClass('selected').css({'background-color': settings.color});
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
                var title = $(this).prev('input').val();
                var members = $(this).parents('.add-new').find('.people').find('.members').html();
                var start_hour = $(this).parents('.add-new ').find('.add-time:first').find('.hour > span').text();
                var start_min = $(this).parents('.add-new ').find('.add-time:first').find('.min > span').text();
                var end_hour = $(this).parents('.add-new ').find('.add-time:last').find('.hour > span').text();
                var end_min = $(this).parents('.add-new ').find('.add-time:last').find('.min > span').text();
                
                var thisDay = $this.find('.day.this-month.selected').attr('data-date');
                var start_time;
                var end_time;

                
                start_time = start_hour + ':' + start_min;
                end_time = end_hour + ':' + end_min;
                $this.prepend(div('div', 'added-event').attr({'data-date':thisDay, 'data-start-time': start_time, 'data-end-time': end_time,'data-title': title, 'data-id': dataId}));
                $this.find('.day.this-month.selected').prepend(
                    div('div','event-single').attr('data-id', dataId).append(
                        div('p','').text(title),
                        div('div','details').append(
                            div('div', 'clock').text('From' +'   '+ start_time + '   To   ' +end_time),
                            div('div', 'target-people').text(members),
                            div('div', 'erase')
                        )
                    )
                );
                $this.find('.day').has('.event-single').addClass('have-event').prepend(div('i','').text('New'));
                $this.find('.events-list').html($this.find('.day.this-month.selected .event-single').clone())
                $this.find('.events-list .event-single').eq(0).hide().slideDown();
                calcTotalDayAgain();
                calcScroll();
                // scrolltop after adding new event
                $this.find('.events-list').scrollTop(0);
                // form reset
                $this.find('.add-new > input[type="text"]').val(lAddEvent[settings.lang]).select();
                $(this).parents('.add-new').find('.people').find('.members').empty();
                dataId++;
            });
            
            $close.on('click', function(){
                prevAddEvent(); 
            });
            
            // delete event
            $this.on('click', '.event-single .erase', function(){
                $('div[data-id=' + $(this).parents(".event-single").attr("data-id") + ']').animate({'height': 0}, function(){ 
                    $(this).remove();
                    calcTotalDayAgain();
                    calcScroll();
                });
            });

        };

    }(jQuery));
    
        $(function () {
           $(".dropdown-menu > li > a").click(function(){
               var val = $(this).html();
               $(".well").html(function(index,value){
                   return value + "<a href='javascript:void(0)' class='a_inserted'><span class='badge'>" + val+ "</span></a>";
               });
               $(".members").html(function(index,value){
                   return value  + val+ "、";
               });
               $(".well > a:last-child").insertBefore("#plus");
               badge_bind();
           });
           $("textarea:eq(0)").keyup(function(){
               $(this).text(function(index,value){
                      var len = value.length;
                      if(len > 70){
                          alert("长度超限！");
                          return value.substring(0,70);
                      }
                });
           }).blur(function(){
               $(this).text(function(index,value){
                      var len = value.length;
                      if(len < 20){
                          alert("真的只有那么一点描述吗？");
                      }
                });
           });
           badge_bind();
       });
       function badge_bind(){
           $(".well > a > .badge").mouseover(function(){
               $(this).html(function(index,value){
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
               $(this).parent().remove();
           });
       }

});

