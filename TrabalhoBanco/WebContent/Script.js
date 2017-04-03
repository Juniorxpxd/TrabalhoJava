$(document).ready(function(){
	$(".dropdown").click(function(){
		$(".dropdown-menu").slideDown("slow");
	});
	$(".dropdown").dblclick(function(){
		$(".dropdown-menu").slideUp("slow");
	});
});