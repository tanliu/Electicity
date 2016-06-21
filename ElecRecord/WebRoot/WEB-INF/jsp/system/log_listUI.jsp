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
<!-- ------------注意：设置全局变量时的代码----------------- -->
<script type="text/javascript">
//使用pagination.jsp的这个命名是支付宝死的

	var queryAction="${basePath}system/log_listUI.action";
	var deleteAction="${basePath}system/log_delete.action";
	function query(){

	 	//--------------提交信息------------------
	  	$("#pageNo").val(1);

	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
</script>

</head>



<body>
<div class="title"><h2>登录信息列表</h2></div>
<form id="queryForm" action="${basePath}system/log_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>用户帐号：</label>
            <!-- 如果employNo的值是空时，表示上一页的查询条件是以用户的方式查询 -->
            <s:textfield id="condition" name="querycon"></s:textfield>            

        </div>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 
            	<th width="25%" class="num">用户帐号</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="25%" >登录时间</th>
				<th width="25%" >登录IP</th>
				<th width="25%">登录结果</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="log">
        	<tr>
            	<td><s:property value="#log.employNo"/></td>
				<td><s:date name="#log.loginTime" format="yyyy:MM:dd HH:mm:ss"/> </td>
				<td><s:property value="#log.loginIp"/></td>	            
				<td><s:property value="#log.ifSuccess.equals(1)?'成功':'失败' "/></td>	            
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
</body>
