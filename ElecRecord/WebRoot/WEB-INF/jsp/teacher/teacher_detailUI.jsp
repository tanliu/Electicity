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
<div class="title"><h2>教师详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
             <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1"><s:property value="teacher.employName"/></td>
                  <td  class="colum" nowrap="nowrap">性别:</td><td class="colum1"><s:property value="teacher.sex"/></td>
            </tr>
             <tr>
                  <td  class="colum" nowrap="nowrap">职工号:</td><td class="colum1"><s:property value="teacher.employNo"/></td>
            	 <td  class="colum" nowrap="nowrap">民族:</td><td class="colum1"><s:property value="teacher.nation"/></td>
            </tr>
             <tr>
                  <td  class="colum" nowrap="nowrap">教师资格:</td><td class="colum1"><s:property value='teacher.qualificationFlag.equals("Y")?"有":"无"'/></td>
                 <td  class="colum" nowrap="nowrap">政治面貌:</td><td class="colum1"><s:property value="teacher.politicalStatus"/></td>
            </tr>
              <tr>
               <td  class="colum" nowrap="nowrap">部门（学院）:</td><td class="colum1"><s:property value="teacher.orgName"/></td>
            	 <td  class="colum" nowrap="nowrap">出生日期 :</td><td class="colum1"><s:date name="teacher.birthday" format="yyyy-MM-dd"/></td>
            </tr>
            <tr>
            <td  class="colum" nowrap="nowrap">科室（系）:</td><td class="colum1"><s:property value="teacher.department"/></td>
            	 <td  class="colum" nowrap="nowrap">职称:</td><td class="colum1"><s:property value="teacher.acdemicTitle"/></td>
                 
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">教职工类别:</td><td class="colum1"><s:property value="teacher.category"/></td>
                  <td  class="colum" nowrap="nowrap">联系电话:</td><td class="colum1"><s:property value="teacher.telNo"/></td>
            </tr>
          
               <tr>
            	 <td  class="colum" nowrap="nowrap">职务:</td><td class="colum1"><s:property value="teacher.duty"/></td>
                  <td  class="colum" nowrap="nowrap">E_mail地址：</td><td class="colum1"><s:property value="teacher.email"/></td>
            </tr>

            <tr>
            	 <td  class="colum" nowrap="nowrap">教学研究方向:</td><td class="colum1"><s:property value="teacher.researchDirection"/></td>
                 <td  class="colum" nowrap="nowrap">是否外聘:</td><td class="colum1"><s:property value="teacher.isOutHire"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">派监考老师可用否:</td><td class="colum1"><s:property value="teacher.invigilatorFlag"/></td>
                  <td  class="colum" nowrap="nowrap">是否实验室人员：</td><td class="colum1"><s:property value='teacher.isLab.equals("Y")?"是":"否"'/></td>
            </tr>
            
             <tr>
            	 <td  class="colum" nowrap="nowrap">学历:</td><td class="colum1"><s:property value="teacher.education"/></td>
                  <td  class="colum" nowrap="nowrap">学位：</td><td class="colum1"><s:property value="teacher.degree"/></td>
            </tr>
            
            <tr>
            	 <td  class="colum" nowrap="nowrap">毕业院校:</td><td class="colum1"><s:property value="teacher.graduate"/></td>
                  <td  class="colum" nowrap="nowrap">专业名称：</td><td class="colum1"><s:property value="teacher.major"/></td>
            </tr>
            
            <tr>
            	 
                 <td  class="colum" nowrap="nowrap">教师简介:</td><td class="colum1"><s:property value="teacher.summary"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">在职状态:</td><td class="colum1"><s:property value="teacher.jobStatus"/></td>
                  <td  class="colum" nowrap="nowrap">教师级别：</td><td class="colum1"><s:property value="teacher.level"/></td>
            </tr>

          
            <tr>
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