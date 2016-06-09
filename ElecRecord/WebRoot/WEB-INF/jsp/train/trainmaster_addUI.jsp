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
<title>学生干部培训基本信息添加</title>
</head>
<body>

<div class="title"><h2>添加学生干部培训基本信息</h2></div>
<form id="myForm" method="post">  
<%-- 	    <input hidden="hidden" value="<s:property value="1"/>" name="traininfoDetail.stuId"> --%>
 	    <input hidden="hidden" value="<s:property value="'罗吉林'"/>" name="traininfoMaster.creator"> 
	    
<div class="main">
    <p class="short-input ue-clear">
    	<label>负责人：</label>
        <input type="text" name="traininfoMaster.manager" placeholder="请输入负责人" /> 
       <label>培训地点：</label>
        <input type="text" name="traininfoMaster.trainsAddress" placeholder="请输入地点" />
    </p>
    
     <div class="short-input select ue-clear" >
        
        <label>培训对象年级：</label>
        <input  hidden="hidden"  name="traininfoMaster.trainsGrade">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="2012">2012</li>
            	<li id="2013">2013</li>
                <li id="2014">2014</li>
                 <li id="2015">2015</li>
            </ul>
        </div>
         <label>培训日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" placeholder="请选择日期" name="traininfoMaster.trainsDate"/>
        </div>
        
    </div>
    
     <p class="short-input ue-clear">
    	<label >培训主题：</label>
        <textarea name="traininfoMaster.trainsTopic" placeholder="请输入主题"></textarea>
    </p>
     <p class="short-input ue-clear">
    	<label >培训内容：</label>
        <textarea name="traininfoMaster.trainsContent" placeholder="请输入内容"></textarea>
    </p>
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="traininfoMaster.memo" placeholder="请输入备注"></textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	<a href="javascript:editor('myForm','post','${basePath}train/trainmaster_add.action')"  class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
</html>
