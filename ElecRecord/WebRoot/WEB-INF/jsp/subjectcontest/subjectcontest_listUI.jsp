
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
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
	 		$("#queryForm").attr("action",deleteAction);
		 	$("#queryForm").submit();  
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
			<a href="${basePath}subjectcontest/subjectcontest_addUI.action" class="add">添加</a>
			<a href="javascript:;" class="del">删除</a> 
			<a href="javascript:;" class="import">导入</a>
    		<a href="javascript:;" class="upload">上传</a>
    		<a href="javascript:downloadItem()">下载</a>
    		
		</div>
<div class="table-box">
			<table>
				<thead>
					<tr>
						<th width="3%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
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
						<th width="5%">编辑</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="subjectcontest" status="stuts">
					
						<tr>
							<td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#subjectcontest.id'/>' /></td>
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
							<td><a href="javascript:editor('<s:property value='#subjectcontest.id'/>')">
								<img src="../images/edtico.png" /></a></td>
				
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		<jsp:include page="/common/pagination.jsp"></jsp:include>
	</form>
<div class="importDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center">
            <p class="dialog-content">请选择要导入的excel文件</p>
            <form id="fileForm" action="${basePath}subjectcontest/subjectcontest_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel"  /></p>
          </form>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="返回" />
            </div>
        </div>
       </div>
</div>

<!--弹出删除提示框的窗口-->
<div class="delDialog">
	<div class="dialog-content">
    	<div class="ui-deldialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">您确定要删除选中的记录吗？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        </div>
</div>

</body>

<script type="text/javascript">
<!--实现清空弹出框的脚本-->
$('.importDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:250,
	height:220
	
});
$('.import').click(function(){
	$('.importDialog').Dialog('open');
});
$('.importDialog input[type=button]').click(function(e) {
    $('.importDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		var $form=$("#fileForm");
		$("#fileForm").submit();
	}
});

<!--实现删除提示框的脚本-->

$('.delDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
	
});

$('.del').click(function(){
	//在弹出前先判断是否已经选中了相关记录
	var selectedRows=document.getElementsByName("selectedRow");
	
	var i=0;
	var length=selectedRows.length;
	
	while(i<length){//如果有记录被选中，则弹出对话框
		if(selectedRows[i++].checked){
			$('.delDialog').Dialog('open');
		}
	}
});

$('.delDialog input[type=button]').click(function(e) {
    $('.delDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		deleteItem();
	}
});

</script>
</html>
 
