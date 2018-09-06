
// header
$(document).ready(function(e) {
  $(window).scroll(function(){
    if($(window).scrollTop() > 100 ){
      
      $(".header-top").fadeOut();
      $(".header-drop").fadeIn();
    }else{
      $(".header-top").fadeIn();
      $(".header-drop").fadeOut();
    } 
  });
});


//ani-view
$(function(){
});
function Hover(obj, calssName) {
	obj.hover(function(){
		$(this).addClass(calssName);
	},function(){
		$(this).removeClass(calssName);
	})
}
$(window).scroll(function () {

	var _ismobile = false;
	var windowTop = $(window).scrollTop();
	var windowBottom = windowTop + $(window).height();
	var showNum = !_ismobile ? 4 : 16;
	$('.ani-view').each(function(){

		var pageQ1 = $(this).offset().top + $(this).height() / showNum;
		var pageQ3 = $(this).offset().top  + $(this).height() / 1;


		if( ( pageQ1 <= windowBottom ) && ( pageQ3 >= windowTop ) ){

			if( $(this).hasClass("fade-in-down") ) $(this).addClass('a-fadeinB');
			if( $(this).hasClass("fade-in-left") )  $(this).addClass('a-fadeinL');
			if( $(this).hasClass("fade-in-right") )  $(this).addClass('a-fadeinR');
			if( $(this).hasClass("fade-in-top") )  $(this).addClass('a-fadeinT');
				
		}else {
			if( $(this).hasClass('a-fadeinB') ) $(this).removeClass('ani-view fade-in-down a-fadeinB');
			if( $(this).hasClass('a-fadeinL') ) $(this).removeClass('ani-view fade-in-left a-fadeinL');
			if( $(this).hasClass('a-fadeinR') ) $(this).removeClass('ani-view fade-in-right a-fadeinR');
			if( $(this).hasClass('a-fadeinT') ) $(this).removeClass('ani-view fade-in-top a-fadeinT');
		}

	});
});

//elevator
$(function() {
	$(window).scroll(function(){
		var scrolltop=$(this).scrollTop();		
		if(scrolltop>=200){		
			$("#elevator_item").show();
		}else{
			$("#elevator_item").hide();
		}
	});		
	$("#elevator").click(function(){
		$("html,body").animate({scrollTop: 0}, 500);	
	});		
	$(".qr").hover(function(){
		$(".qr-popup").show();
	},function(){
		$(".qr-popup").hide();
	});	
});



