$(function(){
	$(window).scroll(function(){
		var top = $(this).scrollTop();
		if(top > 29){
			$(".am-home-nav").removeClass("movedown").addClass("moveup");
			$(".am-home-top").addClass("moveup").removeClass("movedown");
		}else if(top < 29){
			$(".am-home-top").removeClass("moveup");
			$(".am-home-nav").addClass("movedown").removeClass("moveup");		
		}
	});
});



