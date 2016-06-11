
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

<title>国家奖学金详细信息</title>
</head>
	
<body>
<div class="title"><h2>国家奖学金详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1">${countryScholarship.stuName}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1">${countryScholarship.studentNo}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">性别:</td><td class="colum1">${countryScholarship.sex}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">政治面貌:</td><td class="colum1">${countryScholarship.politicalStatus}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">学院:</td><td class="colum1">${countryScholarship.orgName}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">年级:</td><td class="colum1">${countryScholarship.grade}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">专业:</td><td class="colum1">${countryScholarship.major}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">获奖名称:</td><td class="colum1">${countryScholarship.rewardName}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1">${countryScholarship.academicYear}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1">${countryScholarship.term}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">职务:</td><td class="colum1">${countryScholarship.duty}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">本校奖学金情况:</td><td class="colum1">${countryScholarship.schoolScholarInfo}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">获省级及省级以上奖学金情况:</td><td class="colum1">${countryScholarship.provinceScholarIinfo}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">评优获奖情况:</td><td class="colum1">${countryScholarship.awardInfo}</td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">比赛、竞赛类获奖情况:</td><td class="colum1">${countryScholarship.competitionInfo}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1">${countryScholarship.memo}</td>
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
