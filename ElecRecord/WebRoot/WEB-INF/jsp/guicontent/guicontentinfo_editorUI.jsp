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
<title>导学信息修改</title>
</head>

<body>
<div class="title"><h2>导学信息修改</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_guidDate" value="${queryCon.guidDate}">
	 <input type="hidden" name="query_studentNo" value="${queryCon.studentNo}">
	 <input type="hidden" name="query_stuName" value="${queryCon.stuName}">
	  <s:hidden name="pageNO"></s:hidden> 
<!-- 将stu_id发送过去-->
   <input type="hidden" name="guiContent.stuId" value="${guiContent.stuId}"/>
<!-- 将guiContent传递给对应的editor方法 -->
<input type="hidden" name="guiContent.id" value="${guiContent.id}"/>
 <!-- 将原先的创建时间返回 -->
	<input type="hidden" name="guiContent.createTime" value="${guiContent.createTime}"/>
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" name="guiContent.studentNo" value="${guiContent.studentNo}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>专业班级：</label>
        <input type="text" placeholder="请输入学生所在专业班级" name="guiContent.className" value="${guiContent.className}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="guiContent.stuName" value="${guiContent.stuName }"/>
    </p>
    <p class="short-input ue-clear">
    	<label>辅导时间：</label>
        <input type="text" value="${guiContent.guidDate }" name="guiContent.guidDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>辅导地点：</label>
        <input name="guiContent.guidAddress" value="${guiContent.guidAddress }" type="text" placeholder="请输入辅导地点"/>
    </p>
    <p class="short-input ue-clear">
    	<label>辅导内容：</label>
        <input type="text" name="guiContent.guidContent" value="${guiContent.guidContent }" placeholder="请输入辅导内容"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="guiContent.memo"  placeholder="请输入备注信息">${guiContent.memo }</textarea>
    </p>
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}guicontent/guicontent_editor.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
