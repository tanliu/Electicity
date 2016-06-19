
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
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1">${loanscholarship.stuName}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1">${loanscholarship.studentNo}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">性别:</td><td class="colum1">${loanscholarship.sex}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">身份证号:</td><td class="colum1">${loanscholarship.idCardNo}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学院:</td><td class="colum1">${loanscholarship.orgName}</td>
            </tr>
            
             <tr>
            	 <td  class="colum" nowrap="nowrap">专业:</td><td class="colum1">${loanscholarship.major}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">班级:</td><td class="colum1">${loanscholarship.className}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">年级:</td><td class="colum1"> ${loanscholarship.grade}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1">${loanscholarship.academicYear}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1">${loanscholarship.term}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">贷款金额:</td><td class="colum1">${loanscholarship.loanAmount}</td>
            </tr>
             
               <tr>
            	 <td  class="colum" nowrap="nowrap">是否通过审核:</td><td class="colum1">${loanscholarship.censoredFlag}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">被拒绝原因:</td><td class="colum1">${loanscholarship.refuseReason}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">是否还贷:</td><td class="colum1">${loanscholarship.repayFlag}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">还贷金额:</td><td class="colum1">${loanscholarship.repayAmount}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">还贷日期:</td><td class="colum1">
            	  <fmt:formatDate value="${loanscholarship.repayDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">修改日期:</td><td class="colum1">
            	  <fmt:formatDate value="${loanscholarship.modifyDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1">${loanscholarship.memo}</td>
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
