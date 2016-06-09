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
		<h2>学生职务详细信息</h2>
	</div>

	<div class="table-box">
		<table>
			<tbody>
				<tr>
					<td width="8%">年级</td>
					<td width="15%"><s:property value="studentdutys.grade"/></td>
					<td width="8%">学院</td>
					<td width="15%"><s:property value="studentdutys.college"/></td>
				</tr>
				<tr>
					<td>班级</td>
					<td><s:property value="studentdutys.className" /></td>
					<td>姓名</td>
					<td><s:property value="studentdutys.stuName" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:property value="studentdutys.sex" /></td>

					<td>职务</td>
					<td><s:property value="studentdutys.duty" /></td>
				</tr>
				<tr>
					<td>手机</td>
					<td><s:property value="studentdutys.telNo" /></td>

					<td>短号</td>
					<td><s:property value="studentdutys.shortTelNo" /></td>
				</tr>
				<tr>
					<td>宿舍</td>
					<td><s:property value="studentdutys.address" /></td>

					<td>备注</td>
					<td><s:property value="studentdutys.memo" /></td>
				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>