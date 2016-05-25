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
		<div class="main">
		
			<p class="short-input ue-clear">
				<label>用户编号：</label> 
				<s:textfield  name="user.employNo" class="strutsinput"></s:textfield>
				<label>用户名称：</label>
				<s:textfield  name="user.employName" class="strutsinput"></s:textfield>
				
				
			</p>
			<div class="short-input select ue-clear">
				<label>联系电话：</label>
				<div class="select-wrap">
					<s:textfield value="" name="user.tell" class="strutsinput"></s:textfield>
				</div>
				<label>所属机构：</label>
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" >
					    <li id="">请选择</li>
					    <s:iterator value="#request.organizations" var="organization">
					      <li id="<s:property value='#organization.orgId'/>"><s:property value="#organization.orgName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="user.organization.orgId">
			</div>
			<div class="short-input select ue-clear">
				<label>密码：</label>
				<div class="select-wrap">
					<s:textfield value="" name="user.password" class="strutsinput"></s:textfield>
				</div>
				<label>用户类型：</label>
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					    <li id="">请选择</li>
					    <s:iterator value="#request.systemDlls" var="systemDll">
					      <li id="<s:property value='#systemDll.ddlName'/>"><s:property value="#systemDll.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="user.userType">
			</div>
			
			<p class="short-input ue-clear">
				<label>联系地址：</label> 
				<s:textfield value="" name="user.address" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield value="" name="user.email" class="strutsinput"></s:textfield>			
				
			</p>

			<p class="short-input ue-clear" >
				<label>性别：</label>
				<s:radio list="#{'1':'男','0':'女'}" name="user.sex" value="1"  cssStyle="width:25px;" />	
				<label>状态：</label>
				<s:radio list="#{'1':'激活','0':'禁用'}" name="user.status" value="1"  cssStyle="width:25px;" />	
			</p>

	<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}/system/user_add.action')"  class="confirm save">确定</a> <a
				href="javascript:back()" class="clear clear">返回</a>
		</div>

</div>
	</form>

</body>
</html>


