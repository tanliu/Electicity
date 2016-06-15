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
<title>助学金基本信息添加</title>
</head>
<body>

<div class="title"><h2>添加国家助学金基本信息</h2></div>
<form id="myForm" method="post">  
	    <input hidden="hidden" value="<s:property value="1"/>" name="grantScholarship.stuId">
	    <input hidden="hidden" value="<s:property value="'罗吉林'"/>" name="grantScholarship.creator">
	    
<div class="main">
    <p class="short-input ue-clear">
    	
        <label>姓名：</label>
        <input type="text" name="grantScholarship.stuName" placeholder="请输入姓名"  /> 
        <label>学号：</label>
        <input type="text" name="grantScholarship.studentNo" placeholder="请输入学号" /> 
    </p>
    
     <div class="short-input select ue-clear" >
        
        <label>政治面貌：</label>
        <input  hidden="hidden"  name="grantScholarship.politicalStatus">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="共青团员">共青团员</li>
            	<li id="党员">党员</li>
                <li id="群众">群众</li>
            </ul>
        </div>
         <label>性别：</label>
        <input  hidden="hidden"  name="grantScholarship.sex">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="男">男</li>
            	<li id="女">女</li>
            </ul>
        </div>
    </div>

  <div class="short-input select ue-clear" >
        
        <label>学院：</label>
        <input  hidden="hidden"  name="grantScholarship.orgName">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
           <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="计算机学院">计算机学院</li>
                <li id="艺术与设计学院">艺术与设计学院</li>
                <li id="机械与车辆学院">机械与车辆学院</li>
                <li id="化工与材料学院">化工与材料学院</li>
                <li id="会计与金融学院">会计与金融学院</li>
                <li id="商学院">商学院</li>
                <li id="外国语学院">外国语学院</li>
                <li id="航空学院">航空学院</li>
                <li id="文法学院">文法学院</li>
                <li id="数理学院">数理学院</li>
                <li id="信息学院">信息学院</li>
                <li id="布莱恩特学院">布莱恩特学院</li>
            </ul>
        </div>
         <label>经济困难程度：</label>
        <input  hidden="hidden"  name="grantScholarship.familyEconomic">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="困难">困难</li>
            	<li id="一般困难">一般困难</li>
                <li id="特殊困难">特殊困难</li>
                
            </ul>
        </div>
    </div>
<div class="short-input select ue-clear" >
  <label>专业：</label>
       <input  hidden="hidden" value="" name="grantScholarship.major">
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
		 <label>入学年月：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" readonly="readonly" placeholder="请选择日期" name="grantScholarship.acceptanceDate"/>
        </div>
    </div>
    
      <div class="short-input select ue-clear" >
        <label>学年：</label>
        <input  hidden="hidden" value="" name="grantScholarship.academicYear">
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
		<label>学期：</label>
    	 <input  hidden="hidden" value="" name="grantScholarship.term">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>
    </div>
   <p class="short-input ue-clear">
        <label>民族：</label>
        <input type="text" name="grantScholarship.nation" placeholder="请输入姓名"  /> 
    </p>
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="grantScholarship.memo" placeholder="请输入备注"></textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	<a href="javascript:editor('myForm','post','${basePath}grantscholarship/grantscholarship_add.action')"  class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
</html>
