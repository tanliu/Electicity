<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>辅导信息修改</title>
</head>

<body>
<div class="title"><h2>辅导信息修改</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_guidDate" value="${queryCon.guidDate}">
	 <input type="hidden" name="query_studentNo" value="${queryCon.studentNo}">
	 <input type="hidden" name="query_stuName" value="${queryCon.stuName}">
	  <s:hidden name="pageNO"></s:hidden> 
<!-- 将stu_id发送过去-->
   <input type="hidden" name="tutor.stuId" value="${tutor.stuId}"/>
<!-- 将tutor传递给对应的editor方法 -->
<input type="hidden" name="tutor.id" value="${tutor.id}"/>
 <!-- 将原先的创建时间返回 -->
	<input type="hidden" name="tutor.createTime" value="${tutor.createTime}"/>
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" name="tutor.studentNo" value="${tutor.studentNo}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>专业班级：</label>
        <input type="text" placeholder="请输入学生所在专业班级" name="tutor.className" value="${tutor.className}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="tutor.stuName" value="${tutor.stuName }"/>
    </p>
    <p class="short-input ue-clear">
    	<label>辅导时间：</label>
        <input type="text" value="${tutor.guidDate }" name="tutor.guidDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>辅导地点：</label>
        <input name="tutor.guidAddress" value="${tutor.guidAddress }" type="text" placeholder="请输入辅导地点"/>
    </p>
    <p class="short-input ue-clear">
    	<label>辅导内容：</label>
        <input type="text" name="tutor.guidContent" value="${tutor.guidContent }" placeholder="请输入辅导内容"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="tutor.demo"  placeholder="请输入备注信息">${tutor.demo }</textarea>
    </p>
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}tutor/tutor_editor.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
