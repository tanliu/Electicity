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
<title>导学名单修改</title>
</head>

<body>
<div class="title"><h2>导学名单修改</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_teacherName" value="${queryCon.teacherName}">
	 <input type="hidden" name="query_studentNo" value="${queryCon.studentNo}">
	 <input type="hidden" name="query_stuName" value="${queryCon.stuName}">
	  <s:hidden name="pageNO"></s:hidden> 
<!-- 将stu_id发送过去-->
   <input type="hidden" name="guiList.stuId" value="${guiList.stuId}"/>
<!-- 将guiList传递给对应的editor方法 -->
<input type="hidden" name="guiList.id" value="${guiList.id}"/>
 <!-- 将原先的创建时间返回 -->
<input type="hidden" name="guiList.createTime" value="${guiList.createTime}"/>
	
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" name="guiList.studentNo" value="${guiList.studentNo}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>专业班级：</label>
        <input type="text" placeholder="请输入学生所在专业班级" name="guiList.className" value="${guiList.className}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="guiList.stuName" value="${guiList.stuName }"/>
    </p>
  <p class="short-input ue-clear">
    	<label>导学老师：</label>
        <input type="text" placeholder="请输入导学老师姓名" name="guiList.teacherName" value="${guiList.teacherName }"/>
    </p>
    
    
    
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}guilist/guilist_editor.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
