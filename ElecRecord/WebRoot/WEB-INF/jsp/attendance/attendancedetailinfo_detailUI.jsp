<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${basePath}css/details.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" href="${basePath}css/info-reg.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<script type="text/javascript" src="${basePath}js/jquery.js"></script>
<title>考勤信息</title>
</head>

<body>
<div class="title"><h2>考勤信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">选课课号：</td><td class="colum1"><s:property value="attendanceMaster.selectedcourseno"/></td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">课程名称：</td><td class="colum1">${attendanceMaster.coursename }</td>
            </tr>
          
            <tr>
            	 <td  class="colum" nowrap="nowrap">教师姓名：</td><td class="colum1"><s:property value="attendanceMaster.employName"/></td>
            </tr>
             
            <tr>
            	 <td  class="colum" nowrap="nowrap">学年：</td><td class="colum1"><s:property value="attendanceMaster.academicyear"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学期：</td><td class="colum1"><s:property value="attendanceMaster.term"/></td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">开课单位（学院名称）：</td><td class="colum1"><s:property value="attendanceMaster.orgName"/></td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">上课时间：</td><td class="colum1"><s:property value="attendanceMaster.schooltime"/></td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">上课地点：</td><td class="colum1"><s:property value="attendanceMaster.address"/></td>
            </tr>
           <tr>
            	 <td  class="colum" nowrap="nowrap">学号：</td><td class="colum1"><s:property value="attendanceDetail.studentno"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学生姓名：</td><td class="colum1"><s:property value="attendanceDetail.stuname"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学生性别：</td><td class="colum1"><s:property value="attendanceDetail.sex"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学生班级：</td><td class="colum1"><s:property value="attendanceDetail.classname"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">考勤时间：</td><td class="colum1"><s:property value="attendanceDetail.attendanceTime"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">考勤结果：</td><td class="colum1"><s:property value="attendanceDetail.attendanceStatus"/></td>
            </tr>
        </tbody>
    </table>
</div>
</body>

<script type="text/javascript">

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>

</html>
