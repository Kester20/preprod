addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
	window.scrollTo(0, 1);
}


$(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			      	auto: true,
			      	pager:true,
			      	nav:false,
			      	speed: 500,
			      	namespace: "callbacks",
			      	before: function () {
			      		$('.events').append("<li>before event fired.</li>");
			      	},
			      	after: function () {
			      		$('.events').append("<li>after event fired.</li>");
			      	}
			      });

			  });


$(window).load(function() {
	$("#flexiselDemo3").flexisel({
		visibleItems: 4,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,
		pauseOnHover: true,
		enableResponsiveBreakpoints: true,
		responsiveBreakpoints: {
			portrait: {
				changePoint:480,
				visibleItems: 1
			},
			landscape: {
				changePoint:640,
				visibleItems: 2
			},
			tablet: {
				changePoint:768,
				visibleItems: 3
			}
		}
	});

});