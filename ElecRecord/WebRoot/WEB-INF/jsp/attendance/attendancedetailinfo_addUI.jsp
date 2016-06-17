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
<title>添加考勤课程信息</title>
</head>

<body>
<div class="title"><h2>添加考勤课程信息</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_coursename" value="${queryCon.coursename}">
	 <input type="hidden" name="query_employName" value="${queryCon.employName}">
	 <input type="hidden" name="query_address" value="${queryCon.address}">
	  <s:hidden name="pageNO"></s:hidden> 

    <p class="short-input ue-clear">
    	<label>选课课号：</label>
        <input type="text" placeholder="请输入选课课号" name="attendanceMatser.selectedcourseno"/>
    </p>
    <p class="short-input ue-clear">
    	<label>课程名称：</label>
        <input type="text" placeholder="请输入课程名称" name="attendanceMatser.coursename"/>
    </p>
    <p class="short-input ue-clear">
    	<label>教师姓名：</label>
        <input type="text" placeholder="请输入教师姓名" name="attendanceMatser.employName"/>
    </p>
    
     <p class="short-input select ue-clear" >
     <label>学年：</label>
         <input type="text"  name="attendanceMatser.employName"/>
    </p>
    
    <p class="short-input select ue-clear" >
    	<label>学期：</label>
    	 <input type="text"  name="attendanceMatser.employName"/>
        </p>
        
    <p class="short-input select ue-clear" >
     <label>开课单位（学院名称）：</label>
        <input type="text"  name="attendanceMatser.employName"/>
    </p>

    
    <p class="short-input ue-clear">
    	<label>上课时间：</label>
        <input type="text" name="attendanceMatser.schooltime" placeholder="示例：周三第2，3节｛第1-13周｝"/>
    </p>
    
     <p class="short-input ue-clear">
    	<label>上课地点：</label>
        <input type="text" name="attendanceMatser.address" placeholder="请输入上课地点"/>
    </p>
    
     <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" name="attendanceMatser.address" placeholder="请输入学生学号"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>学生姓名：</label>
        <input type="text" name="attendanceMatser.address" placeholder="请输入学生姓名"/>
    </p>
    
    <div class="short-input select ue-clear" >
    	<label>学生性别：</label>
    	 <input  hidden="hidden" value="" name="attendanceMatser.term">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="男">男</li>
                <li id="女">女</li>
            </ul>
        </div>
        </div>
        
        <p class="short-input ue-clear">
    	<label>学生班级：</label>
        <input type="text" name="attendanceMatser.address" placeholder="请输入学生所在班级"/>
    	</p>
    
    	<p class="short-input ue-clear">
            <label>考勤时间：</label>
            <input type="text" value="<s:date format="yyyy-MM-dd" name="tutor.guidDate"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="tutor.guidDate" />      
        </p>
        
        <p class="short-input ue-clear">
            <label>考勤结果：</label>
            <input type="text"   readonly="readonly" name="tutor.guidDate" />      
        </p>
   
 		  
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}attendancemaster/attendancemaster_add.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
