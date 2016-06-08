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
<title>学生干部培训基本信息修改</title>
</head>
<body >

<div class="title"><h2>修改学生干部培训基本信息</h2></div>
<form id="myForm" method="post">
        
   
 	    <input hidden="hidden" value="<s:property value="traininfoMaster.creator"/>" name="traininfoMaster.creator"> 
	   <input hidden="hidden" name="traininfoMaster.id" value="${traininfoMaster.id}" > 
	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_trainsTopic" value="${querycon.trainsTopic}">
	    <input type="hidden" name="query_manager" value="${querycon.manager}">
	    <s:hidden name="pageNO"></s:hidden>
	    
	    <!-- 将原先的创建时间返回 -->
	  <input type="hidden" name="traininfoMaster.createTime" value="${traininfoMaster.createTime}"/>
	  
<div class="main">
    <p class="short-input ue-clear">
    	<label>负责人：</label>
        <input type="text" name="traininfoMaster.manager" placeholder="请输入负责人"  value="${traininfoMaster.manager}" /> 
       <label>培训地点：</label>
        <input type="text" name="traininfoMaster.trainsAddress" placeholder="请输入地点" value="${traininfoMaster.trainsAddress}"/>
    </p>
    
     <div class="short-input select ue-clear" >
        
        <label>培训对象年级：</label>
        <input  hidden="hidden"  value="<s:property value="traininfoMaster.trainsGrade"/>" name="traininfoMaster.trainsGrade">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${traininfoMaster.trainsGrade}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="2012">2012</li>
            	<li id="2013">2013</li>
                <li id="2014">2014</li>
                 <li id="2015">2015</li>
            </ul>
        </div>
         <label>培训日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" placeholder="请选择日期" name="traininfoMaster.trainsDate" value="<s:date name="traininfoMaster.trainsDate" format="yyyy-MM-dd"></s:date>"/>
        </div>
        
    </div>
    
     <p class="short-input ue-clear">
    	<label >培训主题：</label>
        <textarea name="traininfoMaster.trainsTopic" placeholder="请输入主题">${traininfoMaster.trainsTopic}</textarea>
    </p>
     <p class="short-input ue-clear">
    	<label >培训内容：</label>
        <textarea name="traininfoMaster.trainsContent" placeholder="请输入内容">${traininfoMaster.trainsContent}</textarea>
    </p>
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="traininfoMaster.memo" placeholder="请输入备注">${traininfoMaster.memo}</textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	 <a href="javascript:editor('myForm','post','${basePath}train/trainmaster_editor.action') "  class="confirm save">确定</a> 
  
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>


</html>
