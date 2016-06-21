<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>添加选课信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript"
	src="${basePath}js/jquery.validate.min.js"></script>
</head>
<body>

	<div class="title">
		<h2>增加选课信息</h2>
	</div>
	<form id="myForm">
		<div class="main">



			<p class="short-input ue-clear">
				<label>选课号：</label>
				<s:textfield id="courseNO" class="strutsinput noNull"
					name="courseGrade.selectedCourseNo"></s:textfield>
				<label>课程名称：</label>
				<s:textfield id="courseName" class="strutsinput noNull"
					name="courseGrade.courseName"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>学号：</label>
				<s:textfield id="stuNO" class="strutsinput noNull"
					name="courseGrade.studentNo"></s:textfield>
				<label>姓名：</label>
				<s:textfield id="stuName" class="strutsinput noNull" readonly="true"
					name="courseGrade.stuName"></s:textfield>
			</p>

	<%-- 		<div class="short-input select ue-clear">
				<label>专业名称：</label> <input type="hidden" value=""
					name="courseGrade.major">
				<div class="select-wrap">
					<div class="select-title ">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<s:iterator value="#request.majors" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>
					</ul>
				</div>
				<label>学院：</label> <input type="hidden"  value="" name="courseGrade.orgName">
				<div class="select-wrap">
					<div class="select-title ">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<s:iterator value="#request.academys" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>
					</ul>
				</div> 

			</div>
			--%>


			<p class="short-input ue-clear">
				<label>选课简介：</label>
				<textarea name="courseGrade.memo"></textarea>
			</p>

		</div>

		<div class="btn ue-clear">
			<a
				href="javascript:add('myForm','post','${basePath}course/courseGrade_add.action')"
				class="confirm save">确定</a> <a
				href="javascript:tolist('myForm','post','${basePath}course/courseGrade_listUI.action')"
				class="confirm clear">返回</a>
		</div>


	</form>


</body>

<script type="text/javascript">
	
</script>


<script type="text/javascript">
	showRemind('input[type=text], textarea', 'placeholder');

	//--------------------------------------信息唯一性校验------------------------------
	function myonfocus(id) {
		window.setTimeout(function() {
			document.getElementById(id).select();
		}, 0);
		$("#" + id).focus();
	}

	$("input[name='courseGrade.selectedCourseNo']").blur(
			function() {
				$("input[name='courseGrade.courseName']").val("");
				var value = $(this).val();
				var url = "${basePath}course/coursegrade_hasCourseNo.action";
				$.ajax({
					url : url,
					data : {
						'courseGrade.selectedCourseNo' : value
					},
					type : "post",
					dataType : "json",//返回数据类型
					success : function(data) {
						if (data != null) {
							var dataObj = eval(data);//转换为json对象
							$("input[name='courseGrade.courseName']").val(
									dataObj.courseName);
						} else {
							alert("不存在此教师");
							myonfocus("courseNO");
						}
					},
					error : function() {
						alert("失败！");
					}

				});

			});
	$("input[name='courseGrade.studentNo']").blur(

			function() {
				$("input[name='courseGrade.stuName']").val("");
				var value = $(this).val();
				var url = "${basePath}course/coursegrade_hasStudent.action";
				$.ajax({
					url : url,
					data : {
						'courseGrade.studentNo' : value
					},
					type : "post",
					dataType : "json",//返回数据类型
					success : function(data) {
						if (data != null) {
							var dataObj = eval(data);//转换为json对象
							$("input[name='courseGrade.stuName']").val(
									dataObj.stuName);
						} else {
							alert("不存在此学生");
							myonfocus("stuNO");
						}
					},
					error : function() {
						alert("失败！");
					}

				});

			});
</script>
</html>