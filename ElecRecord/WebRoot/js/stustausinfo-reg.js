<!--ѡ���Ľű�-->
$(document.getElementById('select-title1')).on("click",function(){
	$(document.getElementById('list1')).toggle();
	return false;
});
$(document.getElementById('list1')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span1')).text(txt);
});

$(document.getElementById('select-title2')).on("click",function(){
	$(document.getElementById('list2')).toggle();
	return false;
});
$(document.getElementById('list2')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span2')).text(txt);
});

$(document.getElementById('select-title3')).on("click",function(){
	$(document.getElementById('list3')).toggle();
	return false;
});
$(document.getElementById('list3')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span3')).text(txt);
});

$(document.getElementById('select-title4')).on("click",function(){
	$(document.getElementById('list4')).toggle();
	return false;
});
$(document.getElementById('list4')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span4')).text(txt);
});

$(document.getElementById('select-title5')).on("click",function(){
	$(document.getElementById('list5')).toggle();
	return false;
});
$(document.getElementById('list5')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span5')).text(txt);
});

$(document.getElementById('select-title6')).on("click",function(){
	$(document.getElementById('list6')).toggle();
	return false;
});
$(document.getElementById('list6')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span6')).text(txt);
});

$(document.getElementById('select-title7')).on("click",function(){
	$(document.getElementById('list7')).toggle();
	return false;
});
$(document.getElementById('list7')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span7')).text(txt);
});

$(document.getElementById('select-title8')).on("click",function(){
	$(document.getElementById('list8')).toggle();
	return false;
});
$(document.getElementById('list8')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span8')).text(txt);
});

$(document.getElementById('select-title9')).on("click",function(){
	$(document.getElementById('list9')).toggle();
	return false;
});
$(document.getElementById('list9')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span9')).text(txt);
});

$(document.getElementById('select-title10')).on("click",function(){
	$(document.getElementById('list10')).toggle();
	return false;
});
$(document.getElementById('list10')).on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find(document.getElementById('span10')).text(txt);
});

<!--��չ��ܵĽű�-->
function reset()
  {
  document.getElementById("myForm").reset();
  }
showRemind('input[type=text], textarea','placeholder');
