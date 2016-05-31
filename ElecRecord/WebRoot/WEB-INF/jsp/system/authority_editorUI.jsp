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
	    <s:hidden value='0' name="authority.parentId"></s:hidden>
		<div class="main">
			<div class="short-input select ue-clear">
				<label>权限名称：</label>
				<div class="select-wrap">
					<s:textfield value="" name="authority.authorityName" class="strutsinput"></s:textfield>
				</div>
				<label>模块名称：</label>
				<s:textfield value="" name="authority.moduleName" class="strutsinput"></s:textfield>
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
				<s:textfield value="" name="authority.authorityType" class="strutsinput"></s:textfield>
				<label>访问地址：</label>
				<s:textfield value="" name="authority.url" class="strutsinput"></s:textfield>			
			</p>

			<p class="short-input ue-clear">
				<label>操作名称：</label> 
				<s:textfield value="" name="authority.operation" class="strutsinput"></s:textfield>
				<label>菜单排号：</label>
				<s:textfield value="" name="authority.menuNo" class="strutsinput"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>备注：</label> 
				<s:textfield value="" name="authority.memo" class="strutsinput"></s:textfield>

			</p>


	<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}/system/authority_add.action')"  class="confirm save">增加权限</a> 
		</div>

</div>
	</form>

</body>
</html>


