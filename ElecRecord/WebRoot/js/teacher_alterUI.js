$('.clearDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
	
});
$('.clear').click(function(){
	$('.clearDialog').Dialog('open');
});



$('.clearDialog input[type=button]').click(function(e) {
    $('.clearDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		reset();
	}
});



$('.saveDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
	
});

$('.save').click(function(){
	$('.saveDialog').Dialog('open');
});



$('.saveDialog input[type=button]').click(function(e) {
    $('.saveDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		reset();
	}
});