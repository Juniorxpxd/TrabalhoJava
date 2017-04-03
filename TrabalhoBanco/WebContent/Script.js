$(document).ready(function(){
	$(".dropdown-toggle").click(function(){
		$(".dropdown-menu").slideDown("slow");
	});
	$(".dropdown-toggle").dblclick(function(){
		$(".dropdown-menu").slideUp("slow");
	});
});