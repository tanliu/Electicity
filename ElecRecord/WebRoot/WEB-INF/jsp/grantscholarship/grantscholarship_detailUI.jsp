
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 设置时间格式 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${basePath}css/details.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" href="${basePath}css/info-reg.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<script type="text/javascript" src="${basePath}js/jquery.js"></script>

<title>助学金详细信息</title>
</head>
	
<body>
<div class="title"><h2>助学金详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1">${grantScholarship.stuName}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1">${grantScholarship.studentNo}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">性别:</td><td class="colum1">${grantScholarship.sex}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">政治面貌:</td><td class="colum1">${grantScholarship.politicalStatus}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学院:</td><td class="colum1">${grantScholarship.orgName}</td>
            </tr>
            
             <tr>
            	 <td  class="colum" nowrap="nowrap">专业:</td><td class="colum1">${grantScholarship.major}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">民族:</td><td class="colum1">${grantScholarship.nation}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">入学年月:</td><td class="colum1"> ${grantScholarship.acceptanceDate}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1">${grantScholarship.academicYear}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1">${grantScholarship.term}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">经济困难程度:</td><td class="colum1">${grantScholarship.familyEconomic}</td>
            </tr>
             
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1">${grantScholarship.memo}</td>
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
