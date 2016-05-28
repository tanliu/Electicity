<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>查看用户信息</title>
</head>
<body>
	<div class="title">
		<h2>查看用户信息</h2>
	</div>
	<form id="myForm">		    
		<div class="main">		
			<p class="short-input ue-clear">
				<label>用户编号：</label> 
				<s:textfield  name="user.employNo" class="strutsinput noNull" readonly="true"></s:textfield>
				<label>用户名称：</label>
				<s:textfield  name="user.employName" class="strutsinput" readonly="true"></s:textfield>						
			</p>
			<p class="short-input ue-clear">
				 <label>联系电话：</label>
			    <s:textfield  name="user.tell" class="strutsinput tell" readonly="true"></s:textfield>
				 <label>所属机构：</label>
			    <s:textfield  name="user.organization.orgName" class="strutsinput tell" readonly="true"></s:textfield>
				
			</p>
			<p class="short-input ue-clear">
				 <label>创建时间：</label>
				<input type="text" value="<s:date name="user.createTime" format="yyyy-MM-dd HH:mm:ss"/>"> 
				
				 <label>用户类型：</label>
			    <s:textfield  name="user.userType" class="strutsinput tell" readonly="true"></s:textfield>
				
			</p>

			
			<p class="short-input ue-clear">
				<label>联系地址：</label> 
				<s:textfield  name="user.address" class="strutsinput" readonly="true"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield  name="user.email" class="strutsinput email" readonly="true"></s:textfield>			
				
			</p>
			
			<p class="short-input ue-clear">
				<label>性别：</label> 
				<input type="text" value="${user.sex==1? '男':'女' }" readonly="readonly"/>
				<label>状态：</label>
				<input type="text" value="${user.status==1? '激活':'禁用' }" readonly="readonly"/>		
				
			</p>

</div>
	</form>
<%-- <!-- 引入弹出框 -->
<jsp:include page="/common/dialog.jsp"></jsp:include> --%>

</body>

</html>


