<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<html>
<head>
    
<title>My JSP 'organize_addUI.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/teacher_alterUI.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />



<title>添加部门</title>
</head>

<body>

	<div class="title">
		<h2>添加部门</h2>
	</div>
	<form id="myForm">
		<div class="main">
			<div class="short-input select ue-clear">
				<label>机构名称：</label>
				<div class="select-wrap">
					<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>
				</div>
				<label>父级机构：</label>
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1">男</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
						<li>男</li>
						<li>女</li>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="">
      

			</div>
			<p class="short-input ue-clear">
				<label>详细地址：</label> 
				<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield value="" class="strutsinput"></s:textfield>
				
				
			</p>

			<p class="short-input ue-clear">
				<label>邮编：</label> 
				<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>
				<label>传真：</label>
				<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>联系人：</label> 
				<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>
				<label>联系电话：</label>
				<s:textfield value="" name="organization.orgName" class="strutsinput"></s:textfield>

			</p>
			<p class="short-input ue-clear" >
				<label>状态：</label>
				<s:radio list="#{'开启':'开启','关闭':'关闭'}" name="user.gender" value="'开启'"  cssStyle="width:25px;" />	


			</p>

	<div class="btn ue-clear">
	<a href="javascript:;" class="confirm save">确定</a> <a
				href="javascript:;" class="clear clear">返回</a>
		</div>

</div>
	</form>

</body>
<script type="text/javascript" src="${basePath}js/jquery.js"></script>
<script type="text/javascript" src="${basePath}js/common.js"></script>
<script type="text/javascript">
    //---------------------------选择数据------------------------
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent().parent().next("input").val(txt);
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
	var idname=$(this).parent($(".select-list")).siblings($(".select-title")).attr("id");
})

</script>
</html>


