<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("Path", request.getContextPath() + "/");
%>
	<!-- 弹出框 -->
<div class="clearDialog">
    <div class="dialog-content">
        <div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
            <p class="dialog-content">信息提交成功</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        </div>
</div>
<script type="text/javascript" src="${Path}js/core.js"></script>
<script type="text/javascript" src="${Path}js/jquery.dialog.js"></script>
<script type="text/javascript">
$(function($){
	$(".clearDialog").Dialog({
		title:'提示信息',
		autoOpen: false,
		width:400,
		height:200
		
	});
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
</script>
