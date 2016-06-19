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
<title>国家奖学金基本信息修改</title>
</head>
<body >

<div class="title"><h2>修改国家奖学金基本信息</h2></div>
<form id="myForm" method="post">
        <input hidden="hidden" value="<s:property value="countryScholarship.stuId"/>" name="countryScholarship.stuId"> 
	   <input hidden="hidden" name="countryScholarship.id" value="${countryScholarship.id}" > 
	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_rewardName" value="${querycon.rewardName}">
	    <input type="hidden" name="query_orgName" value="${querycon.orgName}">
	    <input type="hidden" name="query_stuName" value="${querycon.stuName}">
	    <s:hidden name="pageNO"></s:hidden>
	    
	     <input hidden="hidden" value="<s:property value="countryScholarship.creator"/>" name="countryScholarship.creator">
	   <!-- 将原先的创建时间返回 -->
	  <input type="hidden" name="countryScholarship.createTime" value="${countryScholarship.createTime}"/>
<div class="main">
     <p class="short-input ue-clear">
        <label>姓名：</label>
        <input type="text" name="countryScholarship.stuName" placeholder="请输入姓名" value="${countryScholarship.stuName}" class="strutsinput noNull"  /> 
        <label>学号：</label>
        <input type="text" name="countryScholarship.studentNo" placeholder="请输入学号" value="${countryScholarship.studentNo}" class="strutsinput noNull studentNo" /> 
    </p>
    
     <div class="short-input select ue-clear" >
        
        <label>政治面貌：</label>
        <input  hidden="hidden" class="noNull" name="countryScholarship.politicalStatus" value="<s:property value="countryScholarship.politicalStatus"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${countryScholarship.politicalStatus}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="共青团员">共青团员</li>
            	<li id="党员">党员</li>
                <li id="群众">群众</li>
            </ul>
        </div>
         <label>性别：</label>
        <input  hidden="hidden" class="noNull" name="countryScholarship.sex" value="<s:property value="countryScholarship.sex"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${countryScholarship.sex}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="男">男</li>
            	<li id="女">女</li>
            </ul>
        </div>
    </div>

  <div class="short-input select ue-clear" >
        
        <label>学院：</label>
        <input  hidden="hidden" class="noNull" name="countryScholarship.orgName" value="<s:property value="countryScholarship.orgName"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${countryScholarship.orgName}</span><i class="icon"></i></div>
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
         <label>年级：</label>
        <input  hidden="hidden" class="noNull" name="countryScholarship.grade" value="<s:property value="countryScholarship.grade"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${countryScholarship.grade}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="2012">2012</li>
            	<li id="2013">2013</li>
                <li id="2014">2014</li>
                 <li id="2015">2015</li>
            </ul>
        </div>
    </div>
<div class="short-input select ue-clear" >
  <label>专业：</label>
       <input  hidden="hidden" class="noNull" value='<s:property value='countryScholarship.major'/>' name="countryScholarship.major">
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value='countryScholarship.major' /></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.major" var="major">
					      <li id="<s:property value='#major.ddlName'/>"><s:property value="#major.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<label>获奖名称：</label>
        <input  hidden="hidden"  class="noNull" value="<s:property value="countryScholarship.rewardName"/>" name="countryScholarship.rewardName" >
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span>${countryScholarship.rewardName}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="国家奖学金">国家奖学金</li>
                <li id="光大奖学金">光大奖学金</li>
            </ul>
        </div>
    </div>
    
      <div class="short-input select ue-clear" >
        <label>学年：</label>
        <input  hidden="hidden" class="noNull" value='<s:property value='countryScholarship.academicYear'/>' name="countryScholarship.academicYear">
      <div class="select-wrap">
				<div class="select-title ue-clear" >
					<span id="span1"><s:property value='countryScholarship.academicYear' /></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.academicYear" var="academicYear">
					      <li id="<s:property value='#academicYear.ddlName'/>"><s:property value="#academicYear.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
		<label>学期：</label>
    	 <input  hidden="hidden" class="noNull" value="<s:property value="countryScholarship.term"/>" name="countryScholarship.term">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${countryScholarship.term}</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>
    </div>
  <p class="short-input ue-clear"> 
         <label>职务：</label> 
        <input type="text" name="countryScholarship.duty" placeholder="请输入职务" value="${countryScholarship.duty}"/>  
    </p> 
  
    <p class="short-input ue-clear">
    	<label >本校奖学金情况：</label>
        <textarea name="countryScholarship.schoolScholarInfo" placeholder="请输入本校奖学金情况">${countryScholarship.schoolScholarInfo}</textarea>
    </p>
   <p class="short-input ue-clear">
    	<label >获省级及省级以上奖学金情况：</label>
        <textarea name="countryScholarship.provinceScholarIinfo" placeholder="请输入获省级及省级以上奖学金情况">${countryScholarship.provinceScholarIinfo}</textarea>
    </p>
<p class="short-input ue-clear">
    	<label >评优获奖情况：</label>
        <textarea name="countryScholarship.awardInfo" placeholder="请输入评优获奖情况">${countryScholarship.awardInfo}</textarea>
    </p>
<p class="short-input ue-clear">
    	<label >比赛、竞赛类获奖情况：</label>
        <textarea name="countryScholarship.competitionInfo" placeholder="请输入比赛、竞赛类获奖情况">${countryScholarship.competitionInfo}</textarea>
    </p>
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="countryScholarship.memo" placeholder="请输入备注">${countryScholarship.memo}</textarea>
    </p>
</div>

<div class="btn ue-clear">
	
	 <a href="javascript:editor('myForm','post','${basePath}couscholarship/couscholarship_editor.action') "  class="confirm save">确定</a> 
  
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>


</html>
