<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>添加学生信息</title>

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
		<h2>增加教师个人基本信息</h2>
	</div>
	<form id="myForm">
		<div class="main">



			<p class="short-input ue-clear">
				<label>职工号：</label>
				<s:textfield id="teacherNO" name="teacher.employNo" class="strutsinput noNull"></s:textfield>
				<label>姓名：</label>
				<s:textfield name="teacher.employName" class="strutsinput noNull"></s:textfield>

			</p>

			<div class="short-input select ue-clear">
				<label>性别：</label>
				<input type="hidden" class="noNull" value="男" name="teacher.sex">
				<div class="select-wrap">
					<div class="select-title ">
						<span>男</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="男">男</li>
						<li id="女">女</li>
					</ul>
				</div>
				<label>出生日期：</label>
				<div class="select-wrap">
					<input type="text" name="teacher.birthday"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="noNull"
						readonly="readonly" />
				</div>


			</div>

			<!-- ------------------------------------------------- -->
			<div class="short-input select ue-clear">
				<label>（部门）学院：</label> <input type="hidden"  value="" name="teacher.orgName">
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
				<label>科室（系）：</label>
				<div class="select-wrap">
					<s:textfield name="teacher.department" class="strutsinput"></s:textfield>
				</div>


			</div>



			<p class="short-input ue-clear">
				<label>联系电话：</label>
				<s:textfield name="teacher.telNo" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield name="teacher.email" class="strutsinput"></s:textfield>

			</p>
			<!-- ------------- -->
			<div class="short-input select ue-clear">
				<label>教职工类别：</label>
               <input type="hidden"  value="" name="teacher.category">
				<div class="select-wrap">
					<div class="select-title ">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<s:iterator value="#request.teacherTypes" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>

					</ul>
				</div>
				<label>学历：</label> <input type="hidden" value=""
					name="teacher.education">
				<div class="select-wrap">
					<div class="select-title ">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<li id="博士">博士</li>
						<li id="研究生">研究生</li>
						<li id="本科">本科</li>
						<li id="高中">高中</li>

					</ul>
				</div>


			</div>
			<div class="short-input select ue-clear">
				<label>学位：</label> <input type="hidden" value=""
					name="teacher.degree">
				<div class="select-wrap">
					<div class="select-title ">
						<span>硕士</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<li id="学士">学士</li>
						<li id="硕士">硕士</li>
						<li id="博士">博士</li>
					</ul>
				</div>
				<label>职务：</label>
				<div class="select-wrap">
					<s:textfield name="teacher.duty" class="strutsinput"></s:textfield>
				</div>


			</div>
			<!-- ------------------------- -->
			<div class="short-input select ue-clear">
				<label>职称：</label>
				<input type="hidden"  value="" name="teacher.acdemicTitle">
				<div class="select-wrap">
					<div class="select-title ">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<s:iterator value="#request.position" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>

					</ul>
				</div>
				<label>派监考老师可用否：</label> <input type="hidden" value="T"
					name="teacher.invigilatorFlag">
				<div class="select-wrap">
					<div class="select-title ">
						<span>可以</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="T">可以</li>
						<li id="F">不可以</li>
					</ul>
				</div>

			</div>

			<p class="short-input ue-clear">

				<label>教学研究方向：</label>
				<s:textfield name="teacher.researchDirection" class="strutsinput"></s:textfield>
				<!-- ----------------- -->

				<label>民族：</label>
				<s:textfield name="teacher.nation" class="strutsinput"></s:textfield>
			</p>
			<!-- ------------------------------------ -->
			<div class="short-input select ue-clear">
				<label>专业名称：</label> <input type="hidden" value=""
					name="teacher.major">
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
				<label>毕业院校：</label>
				<div class="select-wrap">
					<s:textfield name="teacher.graduate" class="strutsinput"></s:textfield>
				</div>

			</div>


			<div class="short-input select ue-clear">
				<label>教师资格：</label> <input type="hidden" value="Y"
					name="teacher.qualificationFlag">
				<div class="select-wrap">
					<div class="select-title ">
						<span>有</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="Y">有</li>
						<li id="N">无</li>
					</ul>
				</div>
				<label>联系地址：</label>
				<div class="select-wrap">
					<s:textfield name="teacher.address" class="strutsinput"></s:textfield>
				</div>


			</div>

			<div class="short-input select ue-clear">
				<label>在职状态：</label> <input type="hidden" value="Y"
					name="teacher.jobStatus">
				<div class="select-wrap">
					<div class="select-title ">
						<span>在职</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="Y">在职</li>
						<li id="N">离职</li>
					</ul>
				</div>
				<label>教师级别：</label>
				<s:textfield name="teacher.level" class="strutsinput"></s:textfield>
			</div>

			<div class="short-input select ue-clear">
				<label>是否实验室人员：</label> <input type="hidden" value="Y"
					name="teacher.isLab">
				<div class="select-wrap">
					<div class="select-title ">
						<span>是</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="Y">是</li>
						<li id="N">否</li>
					</ul>
				</div>
				<label>是否外聘：</label> <input type="hidden" value="Y"
					name="teacher.isOutHire">
				<div class="select-wrap">
					<div class="select-title ">
						<span>是</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="是">是</li>
						<li id="否">否</li>
					</ul>
				</div>
			</div>

			<p class="short-input ue-clear">
				<label>工作量系数：</label> <input type="text" placeholder="请输入工作量系数" />
				<label>政治面貌：</label>
				<s:textfield name="teacher.politicalStatus" class="strutsinput"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>教师简介：</label>
				<textarea name="teacher.summary" placeholder="请输入教师"></textarea>
			</p>

		</div>


		<div class="btn ue-clear">
			<!-- 			<a
				href="javascript:test()"
				class="confirm save">确定</a> -->
			<a
				href="javascript:add('myForm','post','${basePath}teacher/teacher_add.action')"
				class="confirm save">确定</a> <a
				href="javascript:tolist('myForm','post','${basePath}teacher/teacher_listUI.action')"
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

	$("input[name='teacher.employNo']").blur(function() {
		var value = $(this).val();
		var url = "${basePath}teacher/teacher_hasTeacher.action";
		$.ajax({
			url : url,
			data : {
				'teacher.employNo' : value
			},
			type : "post",
			//dataType:"json",//返回数据类型
			success : function(data) {
				if (data == "1") {
					alert("此工号已经存，请重新输入！");
					myonfocus()
				} else {

				}
			},
			error : function() {
				alert("失败！");
			}
		});

	});
</script>
</html>