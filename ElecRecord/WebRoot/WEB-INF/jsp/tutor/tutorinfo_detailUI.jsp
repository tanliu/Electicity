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
<title>辅导信息</title>
</head>

<body>
<div class="title"><h2>辅导信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
            	 <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1"><s:property value="tutor.studentNo"/></td>
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">专业班级:</td><td class="colum1"><s:property value="tutor.className"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1"><s:property value="tutor.stuName"/></td>
                 
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">辅导时间:</td><td class="colum1"><s:property value="tutor.guidDate"/></td>
            </tr>
             
            <tr>
            	 <td  class="colum" nowrap="nowrap">辅导地点:</td><td class="colum1"><s:property value="tutor.guidAddress"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">辅导内容:</td><td class="colum1"><s:property value="tutor.guidContent"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">备注:</td><td class="colum1"><s:property value="tutor.demo"/></td>
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
