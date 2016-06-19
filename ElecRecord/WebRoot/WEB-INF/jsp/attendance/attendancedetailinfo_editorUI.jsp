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
<title>修改考勤信息</title>
</head>

<body>
<div class="title"><h2>修改考勤信息</h2></div>
<form id="myForm">
<div class="main">
<!-- 发送查询条件 -->
	<input type="hidden" name="query_studentno" value="${queryCon.studentno}"> 
	 <input type="hidden" name="query_stuname" value="${queryCon.stuname}"> 
	 <input type="hidden" name="query_attendanceTime" value="${queryCon.attendanceTime}">
	 <input type="hidden" name="query_classname" value="${queryCon.classname}"> 
	  <s:hidden name="pageNO"></s:hidden>  
<!-- 将stu_id发送过去-->
   	<input type="hidden" name="attendanceDetail.stuId" value="${attendanceDetail.stuId}"/>
<!-- 将attendanceDetail传递给对应的editor方法 -->
	<input type="hidden" name="attendanceDetail.id" value="${attendanceDetail.id}"/>
 <!-- 将原先的创建时间返回 -->
	<input type="hidden" name="attendanceDetail.createTime" value="${attendanceDetail.createTime}"/>
    <p class="short-input ue-clear">
    	<label>选课课号：</label>
        <input type="text"  readonly="readonly" value="${attendanceMaster.selectedcourseno }" name="attendanceDetail.selectedcourseno"/>
    </p>
    <p class="short-input ue-clear">
    	<label>课程名称：</label>
        <input type="text"  readonly="readonly" value="${attendanceMaster.coursename }"/>
    </p>
    <p class="short-input ue-clear">
    	<label>教师姓名：</label>
        <input type="text"  readonly="readonly" value="${attendanceMaster.employName }"/>
    </p>
    
     <p class="short-input select ue-clear" >
     <label>学年：</label>
         <input type="text"  readonly="readonly" value="${attendanceMaster.academicyear }"/>
    </p>
    
    <p class="short-input select ue-clear" >
    	<label>学期：</label>
    	 <input type="text" readonly="readonly" value="${attendanceMaster.term }"/>
        </p>
        
    <p class="short-input select ue-clear" >
     <label>开课单位（学院名称）：</label>
        <input type="text" readonly="readonly" value="${attendanceMaster.orgName }"/>
    </p>

    
    <p class="short-input ue-clear">
    	<label>上课时间：</label>
        <input type="text" readonly="readonly" value="${attendanceMaster.schooltime }"/>
    </p>
    
     <p class="short-input ue-clear">
    	<label>上课地点：</label>
        <input type="text" readonly="readonly" value="${attendanceMaster.address }"/>
    </p>
    
     <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" name="attendanceDetail.studentno" placeholder="请输入学生学号" value="${attendanceDetail.studentno }"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>学生姓名：</label>
        <input type="text" name="attendanceDetail.stuname" placeholder="请输入学生姓名" value="${attendanceDetail.stuname }"/>
    </p>
    
    <div class="short-input select ue-clear" >
    	<label>学生性别：</label>
    	 <input  hidden="hidden" value="${attendanceDetail.sex}" name="attendanceDetail.sex">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${attendanceDetail.sex}</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="男">男</li>
                <li id="女">女</li>
            </ul>
        </div>
        </div>
        
        <p class="short-input ue-clear">
    	<label>学生班级：</label>
        <input type="text" name="attendanceDetail.classname" value="${attendanceDetail.classname}" placeholder="请输入学生所在班级"/>
    	</p>
    
    	<p class="short-input ue-clear">
            <label>考勤时间：</label>
            <input type="text" value="<s:date format="yyyy-MM-dd" name="attendanceDetail.attendanceTime"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="attendanceDetail.attendanceTime" value="${attendanceDetail.attendanceTime }"/>      
        </p>
        
        <p class="short-input ue-clear">
            <label>考勤结果：</label>
            <s:radio list="#{'病假':'病假','事假':'事假','旷课':'旷课','迟到':'迟到','早退':'早退','出勤':'出勤'}" name="attendanceDetail.attendanceStatus" value="#{attendanceDetail.attendanceStatus }"  cssStyle="width:25px;" />      
        </p>
   
 		  
</div>
<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}attendancedetail/attendancedetail_editor.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');




</script>
</html>
