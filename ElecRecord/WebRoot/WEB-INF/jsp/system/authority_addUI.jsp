<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加权限操作</title>

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
		<h2>添加(<s:property value="authority.authorityName"/>)子权限操作</h2>
	</div>
	<form id="myForm">
	    <s:hidden  name="authority.parentId"></s:hidden>
	     
		<div class="main">
			<div class="short-input select ue-clear">
				<label>权限名称：</label>
				<div class="select-wrap">
					<s:textfield value=""  name="authority.authorityName" class="strutsinput noNull"></s:textfield>
				</div>
				<label>模块名称：</label>
				<s:textfield value="" name="authority.moduleName" class="strutsinput noNull"></s:textfield>
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
				<label>权限类型：</label> 
				<s:textfield value="" name="authority.authorityType" class="strutsinput noNull"></s:textfield>
				<label>访问地址：</label>
				<s:textfield value="" name="authority.url" class="strutsinput noNull"></s:textfield>			
			</p>

			<p class="short-input ue-clear">
				<label>操作名称：</label> 
				<s:textfield value="" name="authority.operation" class="strutsinput noNull"></s:textfield>
				<label>菜单排号：</label>
				<s:textfield value="" name="authority.menuNo" class="strutsinput noNull"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>备注：</label> 
				<s:textfield value="" name="authority.memo" class="strutsinput"></s:textfield>

			</p>


	<div class="btn ue-clear">
	<a href="javascript:addauthority('myForm','post','${basePath}system/authority_add.action')"  class="confirm save">增加权限</a> 
		</div>

</div>
	</form>

<script type="text/javascript">
function addauthority(formID,type,url){
	
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
            	$mytree.add(newNodes);
              }else{
            	  alert("添加失败");
              }
              window.location.href="${basePath}system/authority_addUI.action";
              
    	},
        error:function(){alert("失败！");}
    
    });
		
	/* 	$("#"+formID).attr("method",type);
		$("#"+formID).attr("action",url);
		$("#"+formID).submit(); */
	}


}

</script>
</body>
</html>


