
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

<title>学生干部培训明细表</title>
</head>
	
<body>
<div class="title"><h2>学生干部培训明细表详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">主题:</td><td class="colum1">${traininfoDetail.master_trainsTopic}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">参训人:</td><td class="colum1">${traininfoDetail.stuName}</td>
            </tr>
          
           <tr>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1">${traininfoDetail.studentNo}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">参训结果:</td><td class="colum1">${traininfoDetail.trainsResult}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1">${traininfoDetail.memo}</td>
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
