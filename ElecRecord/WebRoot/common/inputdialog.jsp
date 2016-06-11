<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />


</head>
<body>

<div class="importDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center">
            <p class="dialog-content">请选择要导入的excel文件</p>
            <form id="fileForm" action="${basePath}stustatus/stustatus_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel"  id="filename"/></p>
          </form>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="返回" />
            </div>
        </div>
        </div>
</div>

<div class="infoDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center" style=" width:400px; height:250px;overflow:auto;">
        </div>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
            </div>
        </div>
</div>

<!--弹出删除提示框的窗口-->
<div class="delDialog">
	<div class="dialog-content">
    	<div class="ui-deldialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">您确定要删除选中的记录吗？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        </div>
</div>

</body>


<script type="text/javascript">
<!--实现文本选择框的脚本-->

$('.importDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:250,
	height:220
	
});

$('.import').click(function(){
	$('.importDialog').Dialog('open');
});



$('.importDialog input[type=button]').click(function(e) {

    $('.importDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		
		if(document.getElementById("filename").value){//在文件非空的条件下才允许向后台提交请求
			var value=document.getElementById("filename").value;
			 var f=value.substring(value.lastIndexOf("."),value.length);
			if(".xls"!=f){
				$('.importDialog').Dialog('open');
				alert("请选择正确的文档！");
				return;
			}
			
			var options={
					url:importUrl,
			    	type:"POST",
			    	dataType:"html",
			    	success: function(data){
			    		$('.infoDialog .dialog-content .ui-dialog-text').append(data); 
			    		$('.infoDialog').Dialog('open');
			    	},
			        error:function(){alert("失败！");}
				
		    };
		    
		    $("#fileForm").ajaxSubmit(options);
			
			
/* 			//采用异步提交
			$.ajax({
				url:importUrl,
		    	data:$("#fileForm").serialize(),
		    	success: function(data){
		    		
                       alert(data);

		    	},
		        error:function(){alert("失败！");}
				
			}); */
		}
		else{
			$('.importDialog').Dialog('open');//如果用户未选择任何文件，那么窗口保持打开状态
		}
	}
});

//-----------------------------返回信息提示框
$('.infoDialog').Dialog({
	title:'导入信息提示',
	autoOpen: false,
	width:400,
	height:300,
});

$('.infoDialog input[type=button]').click(function(e) {
    $('.infoDialog').Dialog('close');
    if($(this).hasClass('ok')){
    	
    	refrese();
    	
    }
    
});
//-------------------------------------------------------
<!--实现删除提示框的脚本-->

$('.delDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
	
});



$('.delDialog input[type=button]').click(function(e) {
    $('.delDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
 		$("#queryForm").attr("action",deleteAction);
	 	$("#queryForm").submit();  
	}
});
//-------------------------刷新窗口----------------------------
function refrese(){
	window.location.href=queryAction;
}
</script>