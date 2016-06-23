<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>

<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<title>修改密码</title>
</head>
<body>

<div class="title"><h2>修改密码</h2></div>
<form id="pwdForm" action="${basePath}system/login_alter.action" method="post">  
	    
<div class="main">
    <p class="short-input ue-clear">
       <label>现在密码：</label>
        <input type="password" name="nowpwn" id="dd" class="strutsinput noNull"/>
    </p>
    <p class="short-input ue-clear">
       <label>用户密码：</label>
        <input type="password" id="newpwd" name="newpwd" class="strutsinput noNull"/>
    </p>
    <p class="short-input ue-clear">
       <label>确认密码：</label>
        <input type="password" id="confirmpwd" name="confirmpwd" class="strutsinput noNull"/>
    </p>

    
</div>

<div class="btn ue-clear">
	
	<a id="alter"   class="confirm save">确定</a>
    <a href="javascript:myclose()" class="clear clear" >关闭</a>
</div>
</form>
</body>

<script type="text/javascript">
function myclose(){
	window.close();
}
$('#alter')
.click(
		function(e) {
			var nullEL=isNull();
			//判断是否为空
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"不可以为空");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return;
			}
            
				//判断输入信息是否有校
				var $newpwd = $("#newpwd").val();
				var $confirmpwd = $("#confirmpwd").val();

				var canSubmit = $newpwd == $confirmpwd
						&& $newpwd != "" ? true : false;
				//把提示信息显示出来;
				if (!canSubmit) {
                   alert("两次输入的密码不相同，请重新输入");
				}
				if (canSubmit) {
					var url = $("#pwdForm").attr("action");
					$.ajax({
								url : url,
								data : $("#pwdForm")
										.serialize(),
								type : "post",
								//dataType:"json",//返回数据类型
								success : function(data) {
									$("#pwdErrorInfo").remove();
									if (data == "1") {
										alert("修改密码成功！");
									} else if (data == "0") {
										alert("修改密码失败！");
									}
								},
								error : function() {
									alert("服务器出错，技术人员正在抢修中....");
								}

							});
				}


		});
</script>
</html>
