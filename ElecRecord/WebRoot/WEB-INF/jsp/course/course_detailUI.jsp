<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师详细信息</title>
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/details.css" />
</head>
<body>
<div class="title"><h2>开课汇总信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
            <tr>
            	 <td  class="colum" nowrap="nowrap">选课课号:</td><td class="colum1"><s:property value="course.selectedCourseNo"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">课程编号:</td><td class="colum1"><s:property value="course.courseCode"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">课程名称:</td><td class="colum1"><s:property value="course.courseName"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">课程性质:</td><td class="colum1"><s:property value="course.courseType"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1"><s:property value="course.academicYear"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1"><s:property value="course.term"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">教师工号:</td><td class="colum1"><s:property value="course.employNo"/></td>    
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">教师姓名:</td><td class="colum1"><s:property value="course.employName"/></td>    
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">教师姓名:</td><td class="colum1"><s:property value="course.employName"/></td>    
            </tr>
          
               <tr>
            	 <td  class="colum" nowrap="nowrap">总学时:</td><td class="colum1"><s:property value="course.totalHours"/></td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">实验学时:</td><td class="colum1"><s:property value="course.labHours"/></td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">学分:</td><td class="colum1"><s:property value="course.credit"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">教学班组成:</td><td class="colum1"><s:property value="course.classInfo"/> </td>
            </tr>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">可选人数:</td><td class="colum1"><s:property value="course.studentNum"/></td>
            </tr>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1"><s:property value="course.memo"/></td>
            </tr>
           
        </tbody>
    </table>
    			 		  											
</div>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">


$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

</script>
</body>
</html>