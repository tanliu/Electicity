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
<title>用户基本信息</title>
</head>
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/details.css" />
<body>
<div class="title"><h2>教师基本信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
             <td  class="colum" nowrap="nowrap">用户编号:</td>
             <td class="colum1"><s:property value="user.employNo"/> </td>
             <td  class="colum" nowrap="nowrap">用户名称:</td>
             <td class="colum1"><s:property value="user.employName"/> </td>
            </tr>
            
        	<tr>
             <td  class="colum" nowrap="nowrap">创建时间:</td>
             <td class="colum1"><s:property value="user.createTime"/> </td>
             <td  class="colum" nowrap="nowrap">用户名称:</td>
             <td class="colum1"><s:property value="user.employName"/> </td>
            </tr>
            
        	<tr>
             <td  class="colum" nowrap="nowrap">用户编号:</td>
             <td class="colum1"><s:property value="user.employNo"/> </td>
             <td  class="colum" nowrap="nowrap">用户名称:</td>
             <td class="colum1"><s:property value="user.employName"/> </td>
            </tr>
            
        	<tr>
             <td  class="colum" nowrap="nowrap">用户编号:</td>
             <td class="colum1"><s:property value="user.employNo"/> </td>
             <td  class="colum" nowrap="nowrap">用户名称:</td>
             <td class="colum1"><s:property value="user.employName"/> </td>
            </tr>
            
        </tbody>
    </table>
    			 		  											
</div>
<script type="text/javascript" src="${basePath}js/jquery.js"></script>
<script type="text/javascript">
$(function($) {
	
	$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");
	  // 你可以在这里继续使用$作为别名...
	});

</script>

</body>
</html>