<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>添加用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<style type="text/css">
.main {
	padding-top: 21px;
	border: 0px solid #c1d3de;
	border-top: none;
	border-bottom: none;
}

.main p input[type="password"] {
	width: 240px;
	height: 28px;
	line-height: 28px;
	padding: 0 10px;
	border: 1px solid #c5d6e0;
	outline: none;
	background: url(../images/inputbg.png) repeat-x;
}
</style>

<title>修改用户</title>
</head>
<body>
	<div class="title">
		<h2>修改用户</h2>
	</div>
	<form id="myForm">
		<s:hidden name="user.userId"></s:hidden>
		<s:hidden name="queryWay"></s:hidden>
		<s:hidden name="pageNO"></s:hidden>
		<s:hidden name="querycon"></s:hidden>
		<div class="main">
			<p class="short-input ue-clear">
				<label>用户编号：</label>
				<s:textfield name="user.employNo" class="strutsinput noNull"
					readonly="true"></s:textfield>
				<label>用户名称：</label>
				<s:textfield name="user.employName" class="strutsinput"></s:textfield>
			</p>
			<div class="short-input select ue-clear">
				<div class="select-wrap">
					<label>联系电话：</label>
					<s:textfield name="user.tell" class="strutsinput tell"></s:textfield>
				</div>
				<label>所属机构：</label> <input class="noNull" hidden="hidden"
					value='<s:property value='user.organization.orgId'/>'
					name="user.organization.orgId">
				<div class="select-wrap">
					<div class="select-title">
						<span id="span1"><s:property
								value='user.organization.orgName' /></span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li id="">请选择</li>
						<s:iterator value="#request.organizations" var="organization">
							<li id="<s:property value='#organization.orgId'/>"><s:property
									value="#organization.orgName" /></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="short-input select ue-clear">
				<label>密码：</label>
				<div class="select-wrap">
					<s:password value="" id="password" name="" class="strutsinput"
						placeholder="点击修改密码"></s:password>
				</div>
				<label>用户类型：</label> <input class="noNull" hidden="hidden"
					value="<s:property value="user.userType"/>" name="user.userType">
				<div class="select-wrap">
					<div class="select-title">
						<span><s:property value="user.userType" /></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
						<li id="">请选择</li>
						<s:iterator value="#request.systemDlls" var="systemDll">
							<li id="<s:property value='#systemDll.ddlName'/>"><s:property
									value="#systemDll.ddlName" /></li>
						</s:iterator>
					</ul>
				</div>
			</div>

			<p class="short-input ue-clear">
				<label>联系地址：</label>
				<s:textfield name="user.address" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield name="user.email" class="strutsinput email"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>性别：</label>
				<s:radio list="#{'1':'男','0':'女'}" name="user.sex"
					cssStyle="width:25px;" />
				<label>状态：</label>
				<s:radio list="#{'1':'激活','0':'禁用'}" name="user.status"
					cssStyle="width:25px;" />
			</p>

			<div class="btn ue-clear">
				<a
					href="javascript:editor('myForm','post','${basePath}system/user_editor.action')"
					class="confirm save">确定</a> <a href="javascript:back()"
					class="clear clear">返回</a>
			</div>
			<fieldset>
				<legend>用户角色分配</legend>


				<s:iterator value="#request.roles" var="role" status="num">
					<s:set var="falg" value="0"></s:set>
					<s:iterator value="user.userRoles" var="checkrole">
                    <s:if test="#role.roleId==#checkrole.role.roleId">
					<s:set var="falg" value="1"></s:set> 
					            
                    </s:if>
					</s:iterator> 
					<s:if test="#falg==1">
	   <input name="roleIds" value="<s:property value='#role.roleId'/> "
						type=checkbox style="vertical-align: middle;" checked="checked" />
					<span style="vertical-align: middle;"><s:property
							value="#role.roleName" /></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					</s:if>
					<s:else>
	   <input name="roleIds" value="<s:property value='#role.roleId'/> "
						type=checkbox style="vertical-align: middle;"  />
					<span style="vertical-align: middle;"><s:property
							value="#role.roleName" /></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					
					</s:else>
       
        
        <s:if test="(#num.getIndex()+1)%10==0">
						<br>
					</s:if>
				</s:iterator>

			</fieldset>

		</div>
	</form>

	<!-- 修改密码弹出框的设置 -->

	<div class="alertPassword">
		<div class="dialog-content">
			<div class="ui-dialog-text" style="width: 400px;">
				<form id="pwdForm" action="${basePath}system/user_editorPwd.action"
					method="post">
					<s:hidden name="user.userId"></s:hidden>
					<div class="main" align="left">
						<p class="short-input ue-clear" align="left">
							<label style="float: none;">新&nbsp;密&nbsp;码&nbsp;：</label> <input
								id="newpwd" type="text" style="float: none;"
								name="user.password"><br> <br> <label
								style="float: none;">确认密码：</label> <input id="confirmpwd"
								type="text" style="float: none;" name="confirmpwd">
						</p>
					</div>
				</form>
				<div class="buttons" align="center">
					<input type="button" class="button long2 ok" value="确定" /> <input
						type="button" class="button long2 normal" value="返回" />
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function($) {
			$(".alertPassword").Dialog({
				title : '修改密码',
				autoOpen : false,
				width : 400,
				height : 250

			});
		});
		$('.alertPassword input[type=button]')
				.click(
						function(e) {

							if ($(this).hasClass('ok')) { //确认提交

								//判断输入信息是否有校
								var $newpwd = $("#newpwd").val();
								var $confirmpwd = $("#confirmpwd").val();
								var canSubmit = $newpwd == $confirmpwd
										&& $newpwd != "" ? true : false;
								//把提示信息显示出来;
								if (!canSubmit) {
									$("#pwdErrorInfo").remove();
									var $p = "<p id='pwdErrorInfo' style='color:red;'>--&gt两次输入的密码不相同，请重新输入！</p>"
									$("#pwdForm .main").append($p);
								}
								if (canSubmit) {
									var url = $("#pwdForm").attr("action");
									$
											.ajax({
												url : url,
												data : $("#pwdForm")
														.serialize(),
												type : "post",
												//dataType:"json",//返回数据类型
												success : function(data) {
													$("#pwdErrorInfo").remove();
													if (data == "1") {
														var $p = "<p id='pwdErrorInfo' style='color:blue;'>--&gt修改密码成功！</p>"
													} else if (data == "0") {
														var $p = "<p id='pwdErrorInfo' style='color:red;'>--&gt修改密码失败！</p>"
													}
													$("#pwdForm .main").append(
															$p);
												},
												error : function() {
													$("#pwdErrorInfo").remove();
													var $p = "<p id='pwdErrorInfo' style='color:blue;'>--&gt服务器出错，技术人员正在抢修中....！</p>";

													$("#pwdForm .main").append(
															$p);
												}

											});
								}

							} else {
								$('.alertPassword').Dialog('close');
							}
						});
	</script>
</body>
<script type="text/javascript">
	//修改密码的方法
	$(function($) {
		$("#password").focus(function() {
			$('.alertPassword').Dialog('open');
		});

	});
</script>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>

</html>


