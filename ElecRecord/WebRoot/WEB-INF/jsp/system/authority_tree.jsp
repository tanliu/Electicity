<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${basePath}css/zTreeStyle/zTreeStyle.css" type="text/css">
  <link rel="stylesheet" href="${basePath}css/base.css" />
  <link rel="stylesheet" type="text/css" href="${basePath}css/jquery.dialog.css" />
  <link rel="stylesheet" href="${basePath}css/index.css" />
  <style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	}
	div, p, table, th, td {
		list-style:none;
		margin:0; padding:0;
		color:#333; font-size:12px;
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	#testIframe {margin-left: 10px;}
  </style>
<script type="text/javascript" src="${basePath}js/tree/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${basePath}js/tree/jquery.ztree.exedit.min.js"></script>
  <SCRIPT type="text/javascript" >

	var zTree;
	var demoIframe;
	  <!--
    function click(){
       alert("------");
    }
-->
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true, <!--是否显示线性-->
			selectedMulti: false,
			showIcon:true<!--是否显示图标-->
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
			beforeClick: beforeClick,
				onClick: onClick,
		}
	};

	var zNodes =[
         {id:0, pId:0, name:"学生电子档案管理系统","target":"add", open:true},
         /*{id:1, pId:0, name:"基本信息管理","target":"add", open:true},
		{id:101, pId:1, name:"学生基本信息" },
		{id:102, pId:1, name:"教师基本信息", file:"core/simpleData"},

		{id:2, pId:0, name:"学生学习情况管理", open:false},
		{id:201, pId:2, name:"教师开课信息", file:"excheck/checkbox"},
		{id:206, pId:2, name:"学生选课成绩", file:"excheck/checkbox_nocheck"},


		{id:3, pId:0, name:"奖助贷信息管理", open:false},
		{id:301, pId:3, name:"国家助学金", file:"exedit/drag"},
		{id:302, pId:3, name:"国家奖学金", file:"exedit/drag_super"},
		{id:303, pId:3, name:"贷款信息", file:"exedit/drag_fun"},


		{id:4, pId:0, name:"辅导培训信息管理", open:false},
		{id:401, pId:4, name:"辅导记录维护", file:"bigdata/common"},
		{id:402, pId:4, name:"导学情况维护", file:"bigdata/diy_async"},
		{id:403, pId:4, name:"考勤记录维护", file:"bigdata/page"},
		{id:404, pId:4, name:"培训情况信息管理", file:"bigdata/page"},
		{id:404, pId:4, name:"学科竞赛维护", file:"bigdata/page"},

		{id:5, pId:0, name:"档案信息管理", open:false},
		{id:501, pId:5, name:"学籍异动信息维护", file:"super/oneroot"},
		{id:502, pId:5, name:"档案邮寄信息维护", file:"super/oneclick"},
		{id:5020, pId:502, name:"档案邮寄信息维护", file:"super/oneclick"},

		{id:6, pId:0, name:"身份信v息管理", open:false},
		{id:601, pId:6, name:"党团关系管理", file:"exhide/common"},
		{id:602, pId:6, name:"学生职务信息管理", file:"exhide/checkbox"}, */

	];

	function beforeClick(treeId, treeNode, clickFlag) {
		
	}
	function onClick(event, treeId, treeNode, clickFlag) {
		window.parent.add.location.href="${basePath}system/authority_addUI.action?authority.parentId="+treeNode.id;
		window.parent.editor.location.href="${basePath}system/authority_editorUI.action?authority.authorityId="+treeNode.id;

	}

    function add(newNodes){
       var zTree = $.fn.zTree.getZTreeObj("tree");
       var node = zTree.getNodeByParam("id", newNodes[0].pId);
       //var newNodes = [ {id:103, pId:102, name:"教师基本信息", file:"core/simpleData"}, ];
       var nodes = zTree.addNodes(node, newNodes);

    }

   function deleteNode(id){
       var zTree = $.fn.zTree.getZTreeObj("tree");
       var node = zTree.getNodeByParam("id", id);
       var nodes =zTree.removeNode(node);
    }
    function editormyNode(newNodes){
       
    	//获取结点，对结点信息更改
       var zTree = $.fn.zTree.getZTreeObj("tree");
       var node = zTree.getNodeByParam("id", newNodes[0].id);
       node.name=newNodes[0].name;
       //选择删除结点
       var nodes =zTree.removeNode(node);
       //取得新结点的父结点
       var pnode = zTree.getNodeByParam("id", newNodes[0].pId);
       //把更改后的结点挂到新的结点上
       var newnodes = zTree.addNodes(pnode, node);

    }
    


	$(document).ready(function(){  //异步加载
		
		$.ajax({
			url:"${basePath}system/authority_treeData.action",
			type:"post",
			dataType:"json",//返回数据类型
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


	});

	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}

  //-->
  </SCRIPT>
 </HEAD>

<BODY  >

<TABLE border=0 style="align=center;">
	<TR align=center>
		<TD  >

			<ul id="tree" class="ztree" style="overflow:auto;"></ul>

		</TD>
	</TR>
</TABLE>

</BODY>

</HTML>
