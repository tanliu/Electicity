<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="${basePath}js/jquery.js"></script>
<script type="text/javascript" src="${basePath}js/common.js"></script>
<link rel="stylesheet" href="${basePath}css/base.css" /> 
<link rel="stylesheet" href="${basePath}css/login.css" /> 
<link rel="stylesheet" href="${basePath}css/struts.css" />
<script type="text/javascript">
var url="${basePath}system/login_login.action";
if(window!=window.parent){
	window.parent.location.reload(true);
}
function login(){
	//$("input[name='username']")
	$("#Loginform").attr("action",url);
	$("#Loginform").submit();
	
}
function checkNumberImage(){
	var imageNumber = document.getElementById("viladImg");
	imageNumber.src = "${pageContext.request.contextPath}/image.jsp?timestamp="+new Date().getTime();
}

</script>
</head>
<body>
	<div id="container">
	   
		<div id="bd">
			<div class="login1" >
                   <form id="Loginform" action="" method="post">
            	<div class="login-top"><h1 class="logo"></h1></div>
                <div class="login-input">                   
                	<p class="user ue-clear">
                    	<label>用户名</label>
                         <input type="text" name="username" value="${requestScope.username} " /> 
                        <%-- <s:textfield name="#username" class="strutsinput"></s:textfield> --%>
                    </p>
                    <p class="password ue-clear">
                    	<label>密&nbsp;&nbsp;&nbsp;码</label>
                        <input type="text" name="password" value="${requestScope.password}" />
                       <%--  <s:password name="#password" class="strutsinput"></s:password> --%>
                    </p>
                     <p class="yzm ue-clear">
                    	<label>验证码</label>
                        <input type="text" name="checkNumber" />
                        <cite><img id="viladImg" src="${basePath}image.jsp" onclick="checkNumberImage();"></cite>
                    </p>

                    <div style="margin-left: 65px;">
                   <font  color="red" size="3" ><s:fielderror name="error"></s:fielderror></font>
                   </div>
                </div>
                <div class="login-btn ue-clear">
                	<a href="javascript:login();" class="btn">登录</a>
                    <div class="remember ue-clear">
                    	<input type="checkbox" name="remeberMe" ${requestScope.checked}  value="yes" id="remember" />
                        <em></em>
                        <label for="remember">记住密码</label>
                    </div>
                </div>
               </form>
            </div>
		</div>
	</div>
    <div id="ft">CopyRight&nbsp;2016&nbsp;&nbsp;版权所有&nbsp;&nbsp;北京理工大学珠海学院&nbsp;&nbsp;粤ICP备05063448号-1</div>
</body>
<script type="text/javascript">
var height = $(window).height();
$("#container").height(height);
$("#bd").css("padding-top",height/2 - $("#bd").height()/2);

$(window).resize(function(){
	var height = $(window).height();
	$("#bd").css("padding-top",$(window).height()/2 - $("#bd").height()/2);
	$("#container").height(height);
	
});

$('#remember').focus(function(){
   $(this).blur();
});

$('#remember').click(function(e) {
	checkRemember($(this));
});

function checkRemember($this){
	if(!-[1,]){
		 if($this.prop("checked")){
			$this.parent().addClass('checked');
		}else{
			$this.parent().removeClass('checked');
		}
	}
}
</script>
</html>