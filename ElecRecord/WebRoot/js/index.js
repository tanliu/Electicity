$(".nav").on("click","li",function(){
	$(this).siblings().removeClass("current");
	var hasChild = !!$(this).find(".subnav").size();
	if(hasChild){
		$(this).toggleClass("hasChild");
	}
	$(this).addClass("current");
});


$(window).resize(function(e) {
    $("#bd").height($(window).height() - $("#hd").height() - $("#ft").height()-6);
	$(".wrap").height($("#bd").height()-6);
	$(".nav").css("minHeight", $(".sidebar").height() - $(".sidebar-header").height()-1);
	$("#iframe").height($(window).height() - $("#hd").height() - $("#ft").height()-12);
}).resize();

$(".nav>li").css({"borderColor":"#dbe9f1"});
$(".nav>.current").prev().css({"borderColor":"#7ac47f"});
$(".nav").on("click","li",function(e){
	var aurl = $(this).find("a").attr("date-src");
	if(aurl=="no"){
		return false;
	}
	$("#iframe").attr("src",aurl);
	$(".nav>li").css({"borderColor":"#dbe9f1"});
	$(".nav>.current").prev().css({"borderColor":"#7ac47f"});
	return false;
});

$('.exitDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
	
});

$('.exit').click(function(){
	$('.exitDialog').Dialog('open');
});



$('.exitDialog input[type=button]').click(function(e) {
    $('.exitDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		window.location.href = "system/login_logout.action"	;
	}
});

//功能导航的加载---------------------------------------------
function createMenu(treeData,boot){
	//------------------先把父结点给加载----------------------------------
 	for(var i=0;i<treeData.length;i++){
 		if(treeData[i].pId==0){
 		   var $li=$("<li id="+treeData[i].id+" class="+getIco(treeData[i].name)+">"+
 		             "<div class='nav-header'>"+
 		              "<a href='javascript:;' date-src='no' class='ue-clear'>"+
 		              "<span>"+treeData[i].name+"</span>"+
 		              "<i class='icon'></i></a></div></li>");
 		   $(".nav").append($li);
 		}
 	}
 	//------------------------------再加载子结点
   	for(var i=0;i<treeData.length;i++){
 		if(treeData[i].pId!=0){
 		   var $pli=$("#"+treeData[i].pId);
 		   var $ul=$pli.find("ul")
 		   if($ul.length==0){ //表示当前还没有ul
 			   //创建ul
 			   $ul="<ul class='subnav'></ul>";
 			   //把ul加到pli中
 			   $pli.append($ul);
 		   }
 		   var $sonli=$("<li><a href='javascript:;' date-src="+boot+treeData[i].url+">"+treeData[i].name+"</a></li>");
 		   $ul=$pli.children("ul");
 		   $ul.append($sonli);
 		}
 	}   
 } 
/**
 * 获取图标
 * @param name
 * @returns {String}
 */
function getIco(name){
	if((name+"").match("系统")){
		return "system";
	}
	if((name+"").match("培训")){
		return "agency";
	}
	if((name+"").match("基本")){
		return "gongwen";
	}
	if((name+"").match("学习")){
		return "konwledge";
	}
	if((name+"").match("奖助贷")){
		return "konwledge";
	}
	if((name+"").match("档案")){
		return "office";
	}
	if((name+"").match("系统")){
		return "office";
	}
	return "office";
}