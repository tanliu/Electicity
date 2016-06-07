
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

<title>学生干部培训信息</title>
</head>
	
<body>
<div class="title"><h2>学生干部培训详细信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">主题:</td><td class="colum1">${traininfoMaster.trainsTopic}</td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">负责人:</td><td class="colum1">${traininfoMaster.manager}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">日期:</td><td class="colum1"  >
            	 <!-- 将时间格式设置为yyyy-MM-dd的格式 如：2016-09-01 -->
            	 <fmt:formatDate value="${traininfoMaster.trainsDate}" pattern="yyyy-MM-dd"/> </td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">地点:</td><td class="colum1">${traininfoMaster.trainsAddress}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">培训年级:</td><td class="colum1">${traininfoMaster.trainsGrade}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">培训内容:</td><td class="colum1">${traininfoMaster.trainsContent}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1">${traininfoMaster.memo}</td>
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
