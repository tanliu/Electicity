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
		<h2>学科竞赛详细信息</h2>
	</div>

	<div class="table-box">
		<table>
			<tbody>
				<tr>
					<td width="8%">学号</td>
					<td width="15%"><s:property value="subjectcontest.studentNo"/></td>
					<td width="8%">获奖者姓名</td>
					<td width="15%"><s:property value="subjectcontest.stuName"/></td>
				</tr>
				<tr>
					<td class="colums" nowrap="nowrap">奖励名称</td>
					<td><s:property value="subjectcontest.rewardName" /></td>
					<td>获奖级别</td>
					<td><s:property value="subjectcontest.rewardLevel" /></td>
				</tr>
				<tr>
					<td>获奖等级</td>
					<td><s:property value="subjectcontest.rewardGrade" /></td>

					<td>授予单位</td>
					<td><s:property value="subjectcontest.grantUnits" /></td>
				</tr>
				<tr>
					<td>获奖项目</td>
					<td><s:property value="subjectcontest.rewardProject" /></td>

					<td>指导老师</td>
					<td><s:property value="subjectcontest.guidTeacher" /></td>
				</tr>
				<tr>
					<td>获奖时间</td>
					<td><s:property value="subjectcontest.rewardDate" /></td>

					<td>备注</td>
					<td><s:property value="subjectcontest.memo" /></td>
				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>