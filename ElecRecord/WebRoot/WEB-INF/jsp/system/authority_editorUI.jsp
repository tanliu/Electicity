<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>修改权限操作</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

</head>


<body>


	<div class="title">
		<h2>修改权限操作</h2>
	</div>
	<form id="myForm">
	    <s:hidden  name="authority.parentId"></s:hidden>
	    <s:hidden id="authorityId" name="authority.authorityId"></s:hidden>
		<div class="main">
			<div class="short-input select ue-clear">
				<label>权限名称：</label>
				<div class="select-wrap">
					<s:textfield  name="authority.authorityName" class="strutsinput noNull"></s:textfield>
				</div>
				<label>模块名称：</label>
				<s:textfield  name="authority.moduleName" class="strutsinput noNull"></s:textfield>
<%-- 				<input  hidden="hidden" value="" name="authority.moduleName">
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					
					<ul class="select-list" id="list1">
					    <li id="">请选择</li>
					    <s:iterator value="#request.organizations" var="organization">
					      <li id="<s:property value='#organization.orgId'/>"><s:property value="#organization.orgName"/></li>
					    </s:iterator>
					</ul>					
				</div> --%>
			</div>
			<p class="short-input ue-clear">
				<label>访问地址：</label>
				<s:textfield  name="authority.url" class="strutsinput"></s:textfield>			
				<label>权限类型：</label> 			
				<s:radio list="#{'0':'菜单','1':'新增','2':'修改','3':'查询','4':'删除','5':'导出','6':'导入','7':'授权'}" name="authority.authorityType"  cssStyle="width:25px;" />	
			</p>

			<p class="short-input ue-clear">
				<label>操作名称：</label> 
				<s:textfield   name="authority.operation" class="strutsinput noNull"></s:textfield>
				<label>菜单排号：</label>
				<s:textfield   name="authority.menuNo" class="strutsinput noNull"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>备注：</label> 
				<s:textfield   name="authority.memo" class="strutsinput"></s:textfield>

			</p>


	<div class="btn ue-clear">
	<a href="javascript:editorauthority('myForm','post','${basePath}/system/authority_editor.action')"  class="confirm save">增加权限</a> 
	<a href="javascript:deleteauthority('myForm','post','${basePath}/system/authority_delete.action')"  class="confirm save">删除权限</a> 
	
		</div>

</div>
	</form>
		
<!-- 删除权限弹出框的设置 -->

<div class="alertPassword" align="center" >
	<div class="dialog-content">   
 	
        <div class="ui-dialog-text" align="center">
            <p id="info" class="dialog-content">你确定要该权限？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
          
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="返回" />
            </div>
        </div>
        </div>
</div>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript">
$(function($){
	$(".alertPassword").Dialog({
		title:'删除权限',
		autoOpen: false,
		width:250,
		height:180,
		position:[300,30]
		
	});
});
$('.alertPassword input[type=button]').click(function(e) {    
	
	if($(this).hasClass('ok')){  //确认提交
		var id=$("#authorityId").val();
		window.location.href="${basePath}system/authority_delete.action?authority.authorityId="+id;
    	var $mytree=$(window.parent.privilige)[0];
    	$mytree.deleteNode(id);
	}
	$('.alertPassword').Dialog('close');

});

 </script>
<script type="text/javascript">
function editorauthority(formID,type,url){
	var id=$("#authorityId").val();
    if(id==""||id=="0"){
    	alert("这是最大父结点，不可以修改！");
    	return ;
    }
	var nullEL=isNull();
	//判断是否为空
	if(typeof(nullEL) != "undefined"){
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return;
	}
	nullEL=isEmail();
	//判断是否是Email
	if(typeof(nullEL) != "undefined"){
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return ;
	}
	//判断是否是电话号码
	nullEL=isTell();
	if(typeof(nullEL) != "undefined"){
		alert(nullEL.prev("label").text());
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return ;
	}
	
	if(typeof(nullEL) == "undefined"){//表示没有空的提示信息（表示通过）
		$.ajax({
        url:url,
    	data:$("#"+formID).serialize(),
    	type:type,
    	async:true,
    	dataType:"json",//返回数据类型
    	success: function(data){
              if(data!=0){
            	//var newNodes = [ {id:103, pId:302, name:"教师基本信息", file:"core/simpleData"}, ];
            	var newNodes = [];
                //把数据输入到Znodes	    		
		    	var val = {id:data.authorityId, pId:data.parentId, name:data.authorityName, open:true};
		    	newNodes.push(val); 
	    
            	var $mytree=$(window.parent.privilige)[0];
            	$mytree.editormyNode(newNodes);
              }else{
            	  alert("添加失败");
              }
              window.location.href="${basePath}system/authority_editorUI.action";
              
    	},
        error:function(){alert("失败！");}
    
    });
	}


}
function deleteauthority(formID,type,url){
	
	var id=$("#authorityId").val();
    if(id==""||id=="0"){
    	alert("这是最大父结点，不可以删除！");
    	return ;
    }
    $('.alertPassword').Dialog('open');


}

</script>
</body>
</html>


