<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="../css/info-mgt.css" />
<style type="text/css">
table tbody tr td {
	text-align: center;
}
.even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
	 $(function(){
	    	 $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
			    $("tr:even").addClass("even"); /* 偶数行添加样式*/
	 });
</script>

<title>学生电子档案管理系统</title>
</head>

<body>
	<div class="title">
		<h2>学生档案邮寄信息</h2>
	</div>

	<div class="table-box">
		<table>
			<tbody>
				<tr>
					<td width="8%">EMS编号</td>
					<td width="15%"><s:property value="postinfo.emsno"/></td>
					<td width="8%">北理工编号</td>
					<td width="15%"><s:property value="postinfo.schoolNo"/></td>
				</tr>
				<tr>
					<td>专业名称</td>
					<td><s:property value="postinfo.major" /></td>
					<td>姓名</td>
					<td><s:property value="postinfo.stuName" /></td>
				</tr>
				<tr>
					<td>学号</td>
					<td><s:property value="postinfo.studentNo" /></td>
					<td>性别</td>
					<td><s:property value="postinfo.sex" /></td>
				</tr>
				<tr>
					<td>派遣性质</td>
					<td><s:property value="postinfo.dispatchType" /></td>
					<td>主管单位</td>
					<td><s:property value="postinfo.chargeUnit" /></td>
				</tr>
				<tr>
					<td>邮件号</td>
					<td><s:property value="postinfo.mailNo" /></td>
					<td>备注</td>
					<td><s:property value="postinfo.memo" /></td>
				</tr>
				<tr>
					<td>创建人</td>
					<td><s:property value="postinfo.creator" /></td>
					<td>创建时间</td>
					<td><s:property value="postinfo.createTime" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>