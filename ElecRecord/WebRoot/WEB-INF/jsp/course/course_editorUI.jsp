<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>修改开课信息</title>

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
		<h2>修改开课信息</h2>
	</div>
	<form id="myForm">
		 <s:hidden name="course.id"></s:hidden>
	    <s:hidden name="course.createTime"></s:hidden>
	    <s:hidden name="course.creator"></s:hidden>
	    
	    <s:hidden name="queryNO"></s:hidden>
	    <s:hidden name="qeuryName"></s:hidden>
	    <s:hidden name="courseNO"></s:hidden>
	    <s:hidden name="studyYear"></s:hidden>
	    <s:hidden name="courseName"></s:hidden>
	    <s:hidden name="pageNO"></s:hidden>
	
		<div class="main">
			<p class="short-input ue-clear">
				<label>教师工号：</label>
				<s:textfield id="teacherNO" class="strutsinput noNull" name="course.employNo"></s:textfield>
				<label>教师姓名：</label>
				<s:textfield id="teacherName" class="strutsinput noNull" name="course.employName"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>选课代号：</label>
				<s:textfield class="strutsinput noNull" name="course.courseCode"></s:textfield>
				<label>课程名称：</label>
				<s:textfield class="strutsinput noNull" name="course.courseName"></s:textfield>
			</p>

			<div class="short-input select ue-clear">
				<label>学年：</label> <input type="hidden" class="noNull" value='<s:property value="course.academicYear"/>' name="course.academicYear">
				<div class="select-wrap">
					<div class="select-title ">
						<span> <s:property value="course.academicYear"/> </span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<s:iterator value="#request.terms" var="term">
							<li id="<s:property value='#term'/>"><s:property
									value="#term" /></li>
						</s:iterator>
					</ul>
				</div>
				<label>学期：</label> <input class="noNull" type="hidden" value="<s:property value='course.term'/>" name="course.term">
				<div class="select-wrap">
					<div class="select-title ">
						<span><s:property value="course.term"/></span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="1">1</li>
						<li id="2">2</li>
					</ul>
				</div>

			</div>
			<div class="short-input select ue-clear">
				<label>课程性质：</label> <input class="noNull" type="hidden" value="<s:property value='course.courseType'/>" name="course.courseType">
				<div class="select-wrap">
					<div class="select-title ">
						<span> <s:property value='course.courseType'/> </span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<s:iterator value="#request.systemDlls" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>
					</ul>
				</div>
				<label>总学时：</label>
				<s:textfield class="strutsinput noNull" name="course.totalHours"></s:textfield>
			</div>

			<p class="short-input ue-clear">
				<label>实验学时：</label>
				<s:textfield class="strutsinput noNull" name="course.labHours"></s:textfield>
				<label>教学班组成：</label>
				<s:textfield class="strutsinput noNull" name="course.classInfo"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>选课人数：</label>
				<s:textfield class="strutsinput noNull" name="course.studentNum"></s:textfield>

			</p>


			<p class="short-input ue-clear">
				<label>课程简介：</label>
				<textarea name="course.memo" placeholder="请输入教师"></textarea>
			</p>

		</div>

		<div class="btn ue-clear">
			<a
				href="javascript:editor('myForm','post','${basePath}course/course_editor.action')"
				class="confirm save">确定</a> <a
				href="javascript:tolist('myForm','post','${basePath}course/course_listUI.action')"
				class="confirm clear">返回</a>
		</div>


	</form>


</body>

<script type="text/javascript">
	function test() {
		$("#myForm").submit();
	}

	$(function() {
		$("#myForm").validate({
			rules : {
				'teacher.teacherNo' : {
					required : true
				}

			}
		});

	});
</script>


<script type="text/javascript">
	showRemind('input[type=text], textarea', 'placeholder');

	//--------------------------------------信息唯一性校验------------------------------
	function myonfocus() {
		window.setTimeout(function() {
			document.getElementById('teacherNO').select();
		}, 0);
		$("#teacherNO").focus();
	}

	$("input[name='course.employNo']").blur(function() {
		var value = $(this).val();
		var url = "${basePath}course/course_hasTeacher.action";
		$.ajax({
			url : url,
			data : {
				'course.employNo' : value
			},
			type : "post",
			dataType:"json",//返回数据类型
			success : function(data) {
				if (data != null) {
		    		var dataObj=eval(data);//转换为json对象
		    		$("input[name='course.employName']").val(dataObj.employName);
				} else {
                    alert("不存在此教师");
                    myonfocus();
				}
			},
			error : function() {
				alert("失败！");
			}

		});

	});
</script>
</html>