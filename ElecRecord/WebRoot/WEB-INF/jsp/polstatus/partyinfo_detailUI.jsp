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
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<title>党团关系详细信息</title>
</head>
<body>

<div class="title"><h2>党团关系详细信息</h2></div>
<form id="myForm" method="post">
      
	   
	  
<div class="main">
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" name="politicalstatus.studentNo"  /> 
        <label>姓名：</label>
        <input type="text" name="politicalstatus.stuName"   /> 
       
    </p>
     
     <p class="short-input  ue-clear" >
       <label>政治面貌 ：</label>
        <input type="text" name="politicalstatus.politicalStatus"   /> 
        <label>入党日期：</label>
          <input type="text" name="politicalstatus.joinDate"   />
    </p>

    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="politicalstatus.memo" ></textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	<a href="javascript:editor('myForm','post','${basePath}polstatus/polstatus_add.action')"  class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
</html>
