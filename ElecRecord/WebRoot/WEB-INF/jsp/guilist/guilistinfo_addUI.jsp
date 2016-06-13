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
<title>添加导学名单</title>
</head>

<body>
<div class="title"><h2>添加导学名单</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_teacherName" value="${queryCon.teacherName}"> 
 	 <input type="hidden" name="query_studentNo" value="${queryCon.studentNo}"> 
	 <input type="hidden" name="query_stuName" value="${queryCon.stuName}"> 
	  <s:hidden name="pageNO"></s:hidden>  
<!-- 先默认stu_id为9528 -->
   <input type="hidden" name="guiList.stuId" value="9528"/>
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" name="guiList.studentNo"/>
    </p>
    <p class="short-input ue-clear">
    	<label>专业班级：</label>
        <input type="text" placeholder="请输入学生所在专业班级" name="guiList.className"/>
    </p> 
    <p class="short-input ue-clear">
    	<label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="guiList.stuName"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>导学老师：</label>
        <input name="guiList.teacherName" type="text" placeholder="请输入导学老师姓名"/>
    </p>
    
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}guilist/guilist_add.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
