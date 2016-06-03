<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>修改部门信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
</head>


<body>

	<div class="title">
		<h2>修改部门信息</h2>
	</div>
	<form id="myForm" method="post">
	    <input hidden="hidden" id="orgId" value="<s:property value="organize.orgId"/>" name="organize.orgId">
	    <input hidden="hidden" value="<s:property value="organize.parentId"/>" name="oldparentId">
	    <input hidden="hidden" value="<s:property value="organize.parentIds"/>" name="organize.parentIds">
		<div class="main">
			<div class="short-input select ue-clear">
				<label>机构名称：</label>
				<div class="select-wrap">
					<s:textfield  name="organize.orgName" class="strutsinput"></s:textfield>
				</div>
				<label>父级机构：</label>
				<input  hidden="hidden" value="<s:property value='organize.parentId'/>"  name="organize.parentId">
				<div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:if test="parentName!=null"> <s:property value="parentName"/> </s:if><s:else>--没有父机构--</s:else></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					    <li id="0">北京理工大学珠海学院</li>
					    <s:iterator value="#request.organizations" var="organization">
					      <s:if test="#organization.orgId!=organize.orgId">
					      <li id="<s:property value='#organization.orgId'/>"><s:property value="#organization.orgName"/></li>
					      </s:if>
					    </s:iterator>
					</ul>					
				</div>
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
	<a href="javascript:editororganize('myForm','post','${basePath}/system/organize_editor.action')"  class="confirm save">确定</a> 
		</div>

</div>
	</form>

</body>
<script type="text/javascript">
function editororganize(formID,type,url){
	var id=$("#orgId").val();
    if(id==""||id=="0"){
    	alert("这是最大父结点，不可以修改！");
    	return ;
    }
	var nullEL=isNull();
	//判断是否为空
	if(typeof(nullEL) != "undefined"){
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return;
	}
	nullEL=isEmail();
	//判断是否是Email
	if(typeof(nullEL) != "undefined"){
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return ;
	}
	//判断是否是电话号码
	nullEL=isTell();
	if(typeof(nullEL) != "undefined"){
		alert(nullEL.prev("label").text());
		nullEL.prev("label").addClass("warn");//提示
		nullEL.focus();
		return ;
	}
	if(typeof(nullEL) == "undefined"){//表示没有空的提示信息（表示通过）
		$.ajax({
        url:url,
    	data:$("#"+formID).serialize(),
    	type:type,
    	async:true,
    	dataType:"json",//返回数据类型
    	success: function(data){
              if(data!=0){
            	//var newNodes = [ {id:103, pId:302, name:"教师基本信息", file:"core/simpleData"}, ];
            	var newNodes = [];
                //把数据输入到Znodes	
		    	var val = {id:data.orgId, pId:data.parentId, name:data.orgName, open:true};
		    	newNodes.push(val); 
	    
            	var $mytree=$(window.parent.privilige)[0];
            	$mytree.editormyNode(newNodes);
              }else{
            	  alert("添加失败");
              }
              window.location.href="${basePath}system/organize_editorUI.action";
              
    	},
        error:function(){alert("失败！");}
    
    });
	}


}</script>
</html>


