<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>用户信息列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>

</head>



<body>
<div class="title"><h2>下载列表</h2></div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th width="100%" class="num">文件名</th>
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="model">
        	<tr>
            	<td><a href="${basePath}upload/<s:property value="#model.filePath"/>"><s:property value="#model.fileName"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
</body>
