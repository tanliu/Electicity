/**
 * 创建人：谭柳
 * 主要功能是对下拉框选择时作出的操作
 */
$(document).ready(function(){
    //---------------------------选择数据------------------------
	$(".select-title").on("click",function(){
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	//-----------------------------选择下拉框的内容----------------------------
	$(".select-list").on("click","li",function(){
		var txt = $(this).text();
		var txtId=$(this).attr("id");
		//把值保存到input中去
		$(this).parent().parent().next("input").val(txtId);
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
		var idname=$(this).parent($(".select-list")).siblings($(".select-title")).attr("id");
	})
});