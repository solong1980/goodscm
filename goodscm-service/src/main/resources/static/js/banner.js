$(function(){
	//首页banner自适应
	var bannerAuto = function(){
		var width = $(window).width(), height = $(window).height(), opacity = 1;
		var scaleBanner = 1920 / 1000;
		var scaleWindow = width / height;
		//opacity = Math.max(1 - $(window).scrollTop() / $(window).height(), 0.2);
		if(scaleBanner > scaleWindow){
			$(".first-bg").css({
				height: "100%",
				width: height * scaleBanner,
				left: (height * scaleBanner - width) / -2,
				top: 0,
				opacity : opacity
			})
		} else {
			$(".first-bg").css({
				height: width / scaleBanner,
				width: "100%",
				left: 0,
				top: (width / scaleBanner - height) * -0.5,
				opacity : opacity
			})
		}
	}
	
	//滚动一屏
	$(".scroll-arrow").click(function(){$('html,body').animate({scrollTop:$("#screenHover").height()}, 500);});
	
	$("#screenHover").height($(window).height());
	bannerAuto();
	
	$(window).scroll(function() {
		//banner自适应
		bannerAuto();
	});
	

	
})



