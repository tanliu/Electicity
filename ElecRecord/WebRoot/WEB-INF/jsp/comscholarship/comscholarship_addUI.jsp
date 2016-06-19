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
<title>普通奖学金基本信息添加</title>
</head>
<body>

<div class="title"><h2>添加普通奖学金基本信息</h2></div>
<form id="myForm" method="post">  
	    <input hidden="hidden" value="<s:property value="1"/>" name="commonScholarship.stuId">
	    <input hidden="hidden" value="<s:property value="'罗吉林'"/>" name="commonScholarship.creator">
	    
<div class="main">
    <p class="short-input ue-clear">
    	
        <label>姓名：</label>
        <input type="text" name="commonScholarship.stuName" placeholder="请输入姓名" class="strutsinput noNull" /> 
        <label>学号：</label>
        <input type="text" name="commonScholarship.studentNo" placeholder="请输入学号" class="strutsinput noNull studentNo"/> 
    </p>
    
     <div class="short-input select ue-clear" >
        
        <label>获奖名称：</label>
        <input  hidden="hidden"  name="commonScholarship.rewardName" class="noNull">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
               <li id="">请选择</li>
            	<li id="特等奖学金">特等奖学金</li>
                <li id="一等奖学金">一等奖学金</li>
                <li id="二等奖学金">二等奖学金</li>
                <li id="三等奖学金">三等奖学金</li>
            </ul>
        </div>
       	<label>学期：</label>
    	 <input  hidden="hidden" value="" name="commonScholarship.term" class="noNull">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>
    </div>

<div class="short-input select ue-clear" >
  <label>专业：</label>
       <input  hidden="hidden" value="" name="commonScholarship.major" class="noNull">
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.major" var="major">
					      <li id="<s:property value='#major.ddlName'/>"><s:property value="#major.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
		 <label>学年：</label>
        <input  hidden="hidden" value="" name="commonScholarship.academicYear" class="noNull">
      <div class="select-wrap">
				<div class="select-title ue-clear" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.academicYear" var="academicYear">
					      <li id="<s:property value='#academicYear.ddlName'/>"><s:property value="#academicYear.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
    </div>
  
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="commonScholarship.memo" placeholder="请输入备注"></textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	<a href="javascript:editor('myForm','post','${basePath}comscholarship/comscholarship_add.action')"  class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
</html>
