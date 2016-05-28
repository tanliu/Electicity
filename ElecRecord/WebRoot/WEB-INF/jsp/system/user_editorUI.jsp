<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>添加用户</title>
</head>
<body>
	<div class="title">
		<h2>添加用户</h2>
	</div>
	<form id="myForm">	
		<s:hidden name="user.userId"></s:hidden>
	    
		<div class="main">		
			<p class="short-input ue-clear">
				<label>用户编号：</label> 
				<s:textfield  name="user.employNo" class="strutsinput noNull" readonly="true"></s:textfield>
				<label>用户名称：</label>
				<s:textfield  name="user.employName" class="strutsinput"></s:textfield>						
			</p>
			<div class="short-input select ue-clear">				
				<div class="select-wrap">
				<label>联系电话：</label>
					<s:textfield  name="user.tell" class="strutsinput tell"></s:textfield>
				</div>
				<label>所属机构：</label>
				<input class="noNull" hidden="hidden" value='<s:property value='user.organization.orgId'/>' name="user.organization.orgId">
				<div class="select-wrap">
				<div class="select-title">
					<span id="span1"><s:property value='user.organization.orgName'/></span><i class="icon"></i>
					</div>
					<ul class="select-list" >
					    <li id="">请选择</li>
					    <s:iterator value="#request.organizations" var="organization">
					      <li id="<s:property value='#organization.orgId'/>"><s:property value="#organization.orgName"/></li>
					    </s:iterator>
					</ul>					
				</div>
			</div>
			<div class="short-input select ue-clear">
				<label>密码：</label>
				<div class="select-wrap">
					<s:password value="" id="password" name="" class="strutsinput" placeholder="点击修改密码"></s:password>
				</div>
				<label>用户类型：</label>
				<input class="noNull"  hidden="hidden" value="<s:property value="user.userType"/>" name="user.userType">
				<div class="select-wrap">
				<div class="select-title" >
					<span ><s:property value="user.userType"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					    <li id="">请选择</li>
					    <s:iterator value="#request.systemDlls" var="systemDll">
					      <li id="<s:property value='#systemDll.ddlName'/>"><s:property value="#systemDll.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
			</div>
			
			<p class="short-input ue-clear">
				<label>联系地址：</label> 
				<s:textfield  name="user.address" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield  name="user.email" class="strutsinput email"></s:textfield>			
				
			</p>

			<p class="short-input ue-clear" >
				<label>性别：</label>
				<s:radio list="#{'1':'男','0':'女'}" name="user.sex"   cssStyle="width:25px;" />	
				<label>状态：</label>
				<s:radio list="#{'1':'激活','0':'禁用'}" name="user.status"   cssStyle="width:25px;" />	
			</p>

	<div class="btn ue-clear">
	<a href="javascript:editor('myForm','post','${basePath}system/user_editor.action')"  class="confirm save">确定</a> <a
				href="javascript:back()" class="clear clear">返回</a>
		</div>

</div>
	</form>
	

	
	<div class="clearDialog">
    <div class="dialog-content">
        <div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
             <input type="button" class="button long2 ok" value="确定" />
              <input type="button" class="button long2 normal" value="取消" />
            
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
		autoOpen: true,
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
<%-- <!-- 引入弹出框 -->
<jsp:include page="/common/dialog.jsp"></jsp:include> --%>

</body>
<script type="text/javascript">
//修改密码的方法
$(function($){
$("#password").focus(function(){
  alert("-----------");
});
	
});
</script>

</html>


