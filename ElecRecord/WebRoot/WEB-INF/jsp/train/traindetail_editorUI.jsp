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
<title>学生干部培训明细表修改</title>
</head>
<body >

<div class="title"><h2>修改学生干部培训明细表</h2></div>
<form id="myForm" method="post">
        <input hidden="hidden" value="<s:property value="traininfoDetail.stuId"/>" name="traininfoDetail.stuId"> 
	   <input hidden="hidden" name="traininfoDetail.id" value="${traininfoDetail.id}" > 
	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_trainsResult" value="${querycon.trainsResult}">
	    <input type="hidden" name="query_trainsTopic" value="${querycon.master_trainsTopic}">
	    <input type="hidden" name="query_stuName" value="${querycon.stuName}">
	    <s:hidden name="pageNO"></s:hidden>
	  
<div class="main">
     <p class="short-input ue-clear">
    	<label>参训人：</label>
        <input type="text" name="traininfoDetail.stuName" placeholder="请输入参训人" value="${traininfoDetail.stuName}" /> 
       <label>学号：</label>
        <input type="text" name="traininfoDetail.studentNo" placeholder="请输入学号" value="${traininfoDetail.studentNo}" />
    </p>
    <!-- 迭代选择   根据 traininfoMaster的id找到对应的trainTopic-->
     <div class="short-input select ue-clear" >
         <label>培训主题：</label>
        <input  class="noNull" hidden="hidden" value='<s:property value='traininfoDetail.master_trainsTopic'/>' name="traininfoDetail.master_trainsTopic">
				<div class="select-wrap">
				<div class="select-title">
					<span id="span1"><s:property value='traininfoDetail.master_trainsTopic' /></span><i class="icon"></i>
					</div>
					<ul class="select-list" >
					    <li id="">请选择</li>
					    <s:iterator value="#request.traininfoMaster" var="traininfoMaster">
					      <li id="<s:property value='#traininfoMaster.trainsTopic'/>"><s:property value="#traininfoMaster.trainsTopic"/></li>
					    </s:iterator>
					</ul>					
				</div>
			

        <label>培训结果：</label>
        <input  hidden="hidden"  value="<s:property value="traininfoDetail.trainsResult"/>" name="traininfoDetail.trainsResult">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span>${traininfoDetail.trainsResult}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="合格">合格</li>
            	<li id="不合格">不合格</li>
            </ul>
        </div> 
    </div>
    
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="traininfoDetail.memo" placeholder="请输入备注">${traininfoDetail.memo}</textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	
	 <a href="javascript:editor('myForm','post','${basePath}train/traindetail_editor.action') "  class="confirm save">确定</a> 
  
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>


</html>
