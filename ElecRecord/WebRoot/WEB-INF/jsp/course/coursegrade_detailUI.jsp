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
<title>选课详细信息</title>
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/details.css" />
</head>
<body>
<div class="title"><h2>选课详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1"><s:property value="courseGrade.stuName"/></td>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1"><s:property value="courseGrade.studentNo"/></td>
                 
            </tr>
        	<tr>
            <td  class="colum" nowrap="nowrap">课程名称:</td><td class="colum1"><s:property value="courseGrade.courseName"/></td>
            <td  class="colum" nowrap="nowrap">选课号:</td><td class="colum1"><s:property value="courseGrade.selectedCourseNo"/></td>            
                 
            </tr>
        	<tr>
            <td  class="colum" nowrap="nowrap">开课教师工号:</td><td class="colum1"><s:property value="courseGrade.employNo"/></td>
            <td  class="colum" nowrap="nowrap">开课教师:</td><td class="colum1"><s:property value="courseGrade.employName"/></td>            
                 
            </tr>
             <tr>
            	  <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1"><s:property value="courseGrade.selectedCourseNo.substring(1, 10)"/></td>
                  <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1"><s:property value="courseGrade.selectedCourseNo.substring(11, 12)"/></td>
 
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">课程性质:</td><td class="colum1"><s:property value="courseGrade.courseType"/></td>
            	 <td  class="colum" nowrap="nowrap">班级:</td><td class="colum1"> <s:property value="courseGrade.className"/></td>
              </tr>
             <tr>
                 <td  class="colum" nowrap="nowrap">折算成绩:</td><td class="colum1"><s:property value="courseGrade.convertScore"/> </td>
                 <td  class="colum" nowrap="nowrap">期末成绩:</td><td class="colum1"><s:property value="courseGrade.endScore"/></td>      
            </tr>
            
             <tr>
              <td  class="colum" nowrap="nowrap">学院:</td><td class="colum1"><s:property value="courseGrade.orgName"/></td>
               <td  class="colum" nowrap="nowrap">平时成绩:</td><td class="colum1"><s:property value="courseGrade.usualScore"/></td>
            </tr>
            
            
              <tr>
                <td  class="colum" nowrap="nowrap">专业名称:</td><td class="colum1"><s:property value="courseGrade.major"/> </td>
                
            	<td  class="colum" nowrap="nowrap">期中成绩:</td><td class="colum1"><s:property value="courseGrade.middleScore"/></td>
                
            </tr>
                    
               <tr>
                  <td  class="colum" nowrap="nowrap">总评成绩:</td><td class="colum1"><s:property value="courseGrade.finalScore"/></td>
             <td  class="colum" nowrap="nowrap">实验成绩:</td><td class="colum1"><s:property value="courseGrade.labScore"/></td>
                
                  
            </tr>

              <tr>
                  
                  <td  class="colum" nowrap="nowrap">绩点:</td><td class="colum1"><s:property value="courseGrade.gradePoint"/></td>
                   <td  class="colum" nowrap="nowrap">补考成绩:</td><td class="colum1"> <s:property value="courseGrade.resitScore"/></td>
            </tr>
            
             
  
            <tr>
            	
                 <td  class="colum" nowrap="nowrap">重修标记:</td><td class="colum1"> <s:property value="courseGrade.retakeFlag"/></td>
                 <td  class="colum" nowrap="nowrap">重修成绩:</td><td class="colum1"><s:property value="courseGrade.repairScore"/> </td>
            </tr>

             <tr>
            	
               <td  class="colum" nowrap="nowrap">补考成绩备注:</td><td class="colum1"><s:property value="courseGrade.resitMemo"/> </td>
                 
                 
            </tr>
             

           <tr>
            <td class="colum" nowrap="nowrap">备注：</td><td class="colum1"><s:property value="courseGrade.memo"/></td>
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