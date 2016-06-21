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
<style type="text/css">
/*表单主体*/
.main {
	padding-top: 5px;
}
.btn {
	padding: 13px 0 10px 300px;
	border: 1px solid #c1d3de;
	border-top: none;
}

</style>
</head>


<body>

	<div class="title">
		<h2>添加(<s:property value="organize.orgName"/>)子部门</h2>
	</div>
	<form id="myForm">
	 <input hidden="hidden" value="<s:property value="organize.parentId"/>" name="organize.parentId">
		<div class="main">
			<div class="short-input select ue-clear">
				<label>机构名称：</label>
				<div class="select-wrap">
					<s:textfield value="" name="organize.orgName" class="strutsinput"></s:textfield>
				</div>
				<label>联系人：</label> 
				<s:textfield value="" name="organize.contactMan" class="strutsinput"></s:textfield>
			</div>
			<p class="short-input ue-clear">
				<label>详细地址：</label> 
				<s:textfield value="" name="organize.address" class="strutsinput"></s:textfield>
				<label>E_mail地址：</label>
				<s:textfield value="" name="organize.email" class="strutsinput"></s:textfield>
				
				
			</p>

			<p class="short-input ue-clear">
				<label>邮编：</label> 
				<s:textfield value="" name="organize.postCode" class="strutsinput"></s:textfield>
				<label>传真：</label>
				<s:textfield value="" name="organize.fax" class="strutsinput"></s:textfield>

			</p>

			<p class="short-input ue-clear">

				<label>联系电话：</label>
				<s:textfield value="" name="organize.tell" class="strutsinput"></s:textfield>
				<label>状态：</label>
				<s:radio list="#{'开启':'开启','关闭':'关闭'}" name="organize.state" value="'开启'"  cssStyle="width:25px;" />	

			</p>


	<div class="btn ue-clear">
	<a href="javascript:addauthority('myForm','post','${basePath}/system/organize_add.action')"  class="confirm save">确定</a> 
		</div>

</div>
	</form>
<script type="text/javascript">
function addauthority(formID,type,url){
	
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
            	$mytree.add(newNodes);
              }else{
            	  alert("添加失败");
              }
              window.location.href="${basePath}system/organize_addUI.action";
              
    	},
        error:function(){alert("失败！");}
    
    });

	}


}

</script>
</body>
</html>


