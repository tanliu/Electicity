<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<%@ taglib prefix="a" uri="http://openhome.cc/jstl/fake"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-form.js"></script>
<!-- 行之间的显示效果与选中行的效果 -->
<style type="text/css">
        .even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
        .selected{background:#DDDDDD;color:#003333} /*选中行样式*/
		table tbody tr td{text-align: center;}
		table thead tr th{text-align: center;}
</style>
<script type="text/javascript">
	    var queryAction="${basePath}subjectcontest/subjectcontest_listUI.action";
		var deleteAction="${basePath}subjectcontest/subjectcontest_delete.action";
		var importUrl="${basePath}subjectcontest/subjectcontest_importExcel.action";
		var downloadAction="${basePath}subjectcontest/subjectcontest_exportExcel.action";
		function query(){
		  	$("#pageNo").val(1);
		  	$("#queryForm").attr("action",queryAction);
		 	$("#queryForm").submit(); 
		}
		function doSelectAll(){
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
		} 
		function deleteItem(){
	 		
	 		$('.delDialog').Dialog('open'); 
		} 
	 	function downloadItem(){
	 		$("#queryForm").attr("action",downloadAction);
		 	$("#queryForm").submit();  
		} 

		//向subjectcontest_editorUI.action提交信息
	 	function editor(id){
	 			var url="${basePath}subjectcontest/subjectcontest_editorUI.action?subjectcontest.id="+id;
	 			$("#queryForm").attr("action",url);
	 	 		$("#queryForm").submit();  
	 	} 
		
	    $(function(){
	    	 $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
			    $("tr:even").addClass("even"); /* 偶数行添加样式*/
			
			    
			  	//双击跳转到详情页面
			  	$('tbody>tr').dblclick(function() {
			  		var sid=$(this).find('td').find("#subid").val();
			  		var url="${basePath}subjectcontest/subjectcontest_detailUI.action?subjectcontest.id="+sid;
			  		window.open(url);
			  		//window.location.href="${basePath}subjectcontest/subjectcontest_detailUI.action?subjectcontest.id="+sid;	
	
		    	});	
				//点击改变选中样式
			    $('tbody>tr').click(function() {
				    $(this).addClass('selected').siblings().removeClass('selected').end();
			    });
	    });
	    
</script>
<title>学科竞赛信息</title>
</head>

<body>
<div class="title">
		<h2>学科竞赛信息管理</h2>
	</div>
	<form id="queryForm"
		action="${basePath}subjectcontest/subjectcontest_listUI.action"
		method="post">
		
		<div class="query">
			<div class="query-conditions ue-clear">

				<div class="conditions name ue-clear">
					<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label> <input
						type="text" placeholder="可以直接输入或选择" name="subjectcontest.studentNo" value="${querycon.studentNo}" />
				</div>

				<div class="conditions name ue-clear">
					<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label> <input
						type="text" placeholder="可以直接输入或选择" name="subjectcontest.stuName" value="${querycon.stuName}"/>
				</div>
			
			
				<div class="conditions name ue-clear">
					<label>奖励名称：</label>
					 <input type="text" name="subjectcontest.rewardName" value="${querycon.rewardName}" />
				</div>

				<div class="conditions name ue-clear">
					<label>授予单位：</label> 
					<input type="text" name="subjectcontest.grantUnits" value="${querycon.grantUnits}"/>
			</div>
			</div>
			<div class="query-btn ue-clear">
					<a href="javascript:query()" class="confirm">查询</a>
				</div>
		
		</div>
		<div class="table-operate ue-clear">
			<a:if url="/subjectcontest/subjectcontest_add.action"><a href="${basePath}subjectcontest/subjectcontest_addUI.action" class="add">添加</a></a:if>
			<a:if url="/subjectcontest/subjectcontest_delete.action"><a href="javascript:deleteItem()" class="del">删除</a> </a:if>
			<a:if url="/subjectcontest/subjectcontest_importExcel.action"><a href="javascript:;" class="import clear clear">导入</a></a:if>
    		<a:if url="/subjectcontest/subjectcontest_exportExcel.action"><a href="javascript:downloadItem()">下载</a></a:if>
    		
		</div>
<div class="table-box">
			<table>
				<thead>
					<tr>
						<a:if url="/subjectcontest/subjectcontest_editor.action"><th width="3%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
						<th width="3%">序号</th>
						<th width="6%">学号</th>
						<th width="5%">获奖者姓名</th>
						<th width="8%">奖励名称</th>
						<th width="4%" align="center">获奖级别</th>
						<th width="4%" align="center">获奖等级</th>
						<th width="12%">授予单位</th>
						<th width="12%">获奖项目</th>
						<th width="5%">指导老师</th>
						<th width="6%">获奖时间</th>
						<th width="5%">备注</th>
						<a:if url="/subjectcontest/subjectcontest_editor.action"><th width="5%">编辑</th></a:if>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="subjectcontest" status="stuts">
					
						<tr>
							<a:if url="/subjectcontest/subjectcontest_editor.action"><td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#subjectcontest.id'/>' /></td></a:if>
							<td class="num">${stuts.count+(pageUtils.pageNo-1)*pageUtils.pageSize}</td>
							<td><s:property value="#subjectcontest.studentNo" /></td>
							<td><s:property value="#subjectcontest.stuName" /></td>
							<td><s:property value="#subjectcontest.rewardName" /></td>
							<td><s:property value="#subjectcontest.rewardLevel" /></td>
							<td><s:property value="#subjectcontest.rewardGrade" /></td>
							<td><s:property value="#subjectcontest.grantUnits" /></td>
							<td><s:property value="#subjectcontest.rewardProject" /></td>
							<td><s:property value="#subjectcontest.guidTeacher" /></td>
							<td><s:date name="#subjectcontest.rewardDate" format="yyyy-MM-dd"></s:date></td>
							<td><s:property value="#subjectcontest.memo" /></td>
							<a:if url="/subjectcontest/subjectcontest_editor.action"><td><a href="javascript:editor('<s:property value='#subjectcontest.id'/>')">
								<img src="../images/edtico.png" /></a></td></a:if>
				
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		<jsp:include page="/common/pagination.jsp"></jsp:include>
	</form>
<jsp:include page="/common/inputdialog.jsp"></jsp:include>
</body>
</html>
 
