<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>模板添加</title>

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
		<h2>添加模板</h2>
	</div>
	<form id="myForm" enctype="multipart/form-data">	
		<div class="main">		
			<p class="short-input ue-clear">
				<label >请选择文件：</label> 
				<input name="excel" type="file">					
			</p>


</div>
				<div class="btn ue-clear" style="margin-left: 0px;padding-left: 110px;">
	<a href="javascript:add('myForm','post','${basePath}system/model_add.action')"  class="confirm save">确定</a> <a
				href="javascript:back()" class="clear clear">返回</a>
	</form>

</body>

</html>


