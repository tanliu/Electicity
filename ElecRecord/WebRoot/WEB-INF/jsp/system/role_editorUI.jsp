<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加角色操作</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
  <link rel="stylesheet" href="${basePath}css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.exedit.min.js"></script>
<!---------------tree------------------------------------>
<style type="text/css">
fieldset {
    padding:10px;
    margin:10px;
    width:90%;

    color:#333; 
    border:#06c solid 1px;
} 
.main p input[type="text"] {
	width: 180px;
}

.main p label {
	float: left;
	width: 100px;
	text-align:right;
}
.btn {
	padding: 13px 0 10px 300px;
}
</style>
  <SCRIPT type="text/javascript" >
  <!--
	var zTree;
	var demoIframe;

    function click(){
       alert("------");
    }
-->
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true, <!--是否显示线性-->
			selectedMulti: false,
			showIcon:true,<!--是否显示图标-->
		},
		check:{
			enable: true,
			autoCheckTrigger : true,
			chkStyle : "checkbox",
			chkboxType : {"Y": "ps", "N": "s"},
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {

				beforeCheck: zTreeBeforeCheck,
				onCheck: zTreeOnCheck
		}
	};

	var zNodes =[
	];


	function zTreeBeforeCheck(treeId, treeNode) {
        return true;
    };
    function zTreeOnCheck(event, treeId, treeNode) {

    };

	$(document).ready(function(){  //异步加载
		
		$.ajax({
			url:"${basePath}system/role_treeData.action",
			type:"post",
			dataType:"json",//返回数据类型
			async:false,
	    	success: function(data){	    		
	    		if(data!=null){	    		
	    		var dataObj=eval(data);//转换为json对象
                //把数据输入到Znodes
	    		for(var i=0;i<dataObj.length;i++){
		    		var val = {id:dataObj[i].authorityId, pId:dataObj[i].parentId, name:dataObj[i].authorityName, open:true};
		    		zNodes.push(val); 
	    		}
	    		}
	    		//加载树
	     		var t = $("#tree");
	    		t = $.fn.zTree.init(t, setting, zNodes);
	    		demoIframe = $("#testIframe");
	    		demoIframe.bind("load", loadReady);
	    		var zTree = $.fn.zTree.getZTreeObj("tree");
	    		//zTree.selectNode(zTree.getNodeByParam("id", 101)); 

	    	},
	        error:function(){alert("失败！");}
			
		});
	    var roleId=$("#roleId").val();
		$.ajax({
			url:"${basePath}system/role_check.action",
			type:"post",
			data:{"role.roleId":roleId},
			dataType:"json",//返回数据类型
			async:false,
	    	success: function(data){	    		
	    		if(data!=null){	    		
	    		var dataObj=eval(data);//转换为json对象
	    		var zTree = $.fn.zTree.getZTreeObj("tree");
                //把数据输入到Znodes
	    		for(var i=0;i<dataObj.length;i++){
	    		       var node = zTree.getNodeByParam("id", dataObj[i].authorityId);
	    			   zTree.checkNode(node, true, false);
	    		}
	    		}

	    	},
	        error:function(){}
			
		});


	});




/* 	$(document).ready(function(){
		var t = $("#tree");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		demoIframe.bind("load", loadReady);
		var zTree = $.fn.zTree.getZTreeObj("tree");
		zTree.selectNode(zTree.getNodeByParam("id", 101));	  
       var node = zTree.getNodeByParam("id", 2);
	    zTree.checkNode(node, true, false);

	});
 */
	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}
  </SCRIPT>
  <!-- button按钮的控制 -->
  <script type="text/javascript">
  function editorrole(formID,type,url){   	
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
		var $roleForm=$("#"+formID);
		  //获取勾选到的节点
		var zTree = $.fn.zTree.getZTreeObj("tree");
	   	var nodes = zTree.getCheckedNodes(true);
	   	for (var i=0, l=nodes.length; i < l; i++) {
	   		var $input=$("<input type='hidden' id='authoritys' name='authoritys' value="+nodes[i].id+">");
	   		$roleForm.append($input);
	   	}
	   	
		$.ajax({
        url:url,
    	data:$("#"+formID).serialize(),
    	type:type,
    	async:true,
    	//dataType:"json",//返回数据类型
    	success: function(data){
              if(data!=0){
                 window.location.href="${basePath}system/role_listUI.action?querycon="+data.querycon+"&pageNO="+data.pageNo;
              }else{        	  

            	  $("input[name='authoritys']").remove();
            	  alert("修改失败");
              }              
    	},
        error:function(){        	
        	$("input[name='authoritys']").remove();
        	alert("修改失败");
        }
    
    });

	}

  }
  
  </script>
</head>



<body>


	<div class="title">
		<h2>添加角色操作</h2>
	</div>
	<form id="myForm">
	    <s:hidden name="pageNO"></s:hidden>
	    <s:hidden id="roleId" name="role.roleId"></s:hidden>
	    <s:hidden name="role.createTime"></s:hidden>
		<div class="main" style="text-align: center;align:center;">
			<TABLE style="border: 0;align=center;" >
	       <TR style="border: 0">
		<TD  style="overflow:auto;border: 0;width:100%">
			<p class="short-input ue-clear">
				<label>角色名称：</label>
				<s:textfield  name="role.roleName" class="strutsinput noNull" ></s:textfield>	
								<label>角色编号：</label>
				<s:textfield  name="role.roleNo" class="strutsinput noNull"></s:textfield>	
				<label>备注信息：</label>
				<s:textfield  name="role.memo" class="strutsinput"></s:textfield>	
			</p>
		 <div class="btn ue-clear" >
	     <a href="javascript:editorrole('myForm','post','${basePath}system/role_editor.action')"  class="confirm save">修改角色</a> 
		</div>
		
		</TD>
		</TR>
		
		
		<tr style="border: 0px;">
		<TD  style="border: 0px;">
		<fieldset  >
		<legend>权限分配</legend>
		
		<ul id="tree" class="ztree"  ></ul>

		</fieldset>
		</TD>
		</tr>
		




</TABLE>


</div>
	</form>


</body>
</html>


