<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加部门信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>添加部门</title>
</head>


<body>

	<div class="title">
		<h2>添加部门</h2>
	</div>
	<form id="myForm" method="post">
	    <input hidden="hidden" value="<s:property value="organize.orgId"/>" name="organize.orgId">
	    <input hidden="hidden" value="<s:property value="organize.parentId"/>" name="oldparentId">
	    <input hidden="hidden" value="<s:property value="organize.parentIds"/>" name="organize.parentIds">
		<div class="main">
			<div class="short-input select ue-clear">
				<label>机构名称：</label>
				<div class="select-wrap">
					<s:textfield  name="organize.orgName" class="strutsinput"></s:textfield>
				</div>
				<label>父级机构：</label>
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:if test="parentName!=null"> <s:property value="parentName"/> </s:if><s:else>--没有父机构--</s:else></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					    <s:iterator value="#request.organizations" var="organization">
					      <li id="<s:property value='#organization.orgId'/>"><s:property value="#organization.orgName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="<s:property value='organize.parentId'/>"  name="organize.parentId">
			</div>
			<p class="short-input ue-clear">
				<label>详细地址：</label> 
				<s:textfield  name="organize.address" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield  name="organize.email" class="strutsinput"></s:textfield>
				
				
			</p>

			<p class="short-input ue-clear">
				<label>邮编：</label> 
				<s:textfield  name="organize.postCode" class="strutsinput"></s:textfield>
				<label>传真：</label>
				<s:textfield  name="organize.fax" class="strutsinput"></s:textfield>

			</p>

			<p class="short-input ue-clear">
				<label>联系人：</label> 
				<s:textfield  name="organize.contactMan" class="strutsinput"></s:textfield>
				<label>联系电话：</label>
				<s:textfield  name="organize.tell" class="strutsinput"></s:textfield>

			</p>
			<p class="short-input ue-clear" >
				<label>状态：</label>
				<s:radio list="#{'开启':'开启','关闭':'关闭'}" name="organize.state"   cssStyle="width:25px;" />	
			</p>

	<div class="btn ue-clear">
	<a href="javascript:editor('myForm','post','${basePath}/system/organize_editor.action')"  class="confirm save">确定</a> <a
				href="javascript:back()" class="clear clear">返回</a>
		</div>

</div>
	</form>

</body>
</html>


