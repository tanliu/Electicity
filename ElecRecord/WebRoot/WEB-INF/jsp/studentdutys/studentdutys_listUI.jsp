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
<!-- 行之间的显示效果与选中行的效果 -->
<style type="text/css">
        .even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
        .selected{background:#DDDDDD;color:#003333} /*选中行样式*/
		table tbody tr td{text-align: center;}
		table thead tr th{text-align: center;}
</style>


<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-form.js"></script>
<script type="text/javascript">
	    var queryAction="${basePath}studentdutys/studentdutys_listUI.action";
		var deleteAction="${basePath}studentdutys/studentdutys_delete.action";
		var importUrl="${basePath}studentdutys/studentdutys_importExcel.action";
		var downloadAction="${basePath}studentdutys/studentdutys_exportExcel.action";
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

	 	//向studentdutys_editorUI.action提交信息
	 	function editor(id){
	 			var url="${basePath}studentdutys/studentdutys_editorUI.action?studentdutys.id="+id;
	 			$("#queryForm").attr("action",url);
	 	 		$("#queryForm").submit();  
	 	} 
	 	
	    $(function(){
	    	 $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
			    $("tr:even").addClass("even"); /* 偶数行添加样式*/
			
			    
			  	//双击跳转到详情页面
			  	$('tbody>tr').dblclick(function() {
			  		var sid=$(this).find('td').find("#subid").val();
			  		var url="${basePath}studentdutys/studentdutys_detailUI.action?studentdutys.id="+sid;
			  		window.open(url);
			  		//window.location.href="${basePath}subjectcontest/subjectcontest_detailUI.action?subjectcontest.id="+sid;	
	
		    	});	
				//点击改变选中样式
			    $('tbody>tr').click(function() {
				    $(this).addClass('selected').siblings().removeClass('selected').end();
			    });
	    });
	    
</script>
	<title>学生电子档案管理系统</title>
</head>

<body>
<div class="title"><h2>学生职务信息管理</h2></div>
	<form id="queryForm"
		action="${basePath}studentdutys/studentdutys_listUI.action"
		method="post">
	<div class="query">
	<div class="query-conditions ue-clear">
		<div class="conditions name ue-clear">
		<label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
		<input  hidden="hidden" value="" name="studentdutys.grade" value="${querycon.grade}"/>
		<div class="select-wrap">
			<div class="select-title ue-clear"><span>${querycon.grade}</span><i class="icon"></i></div>
		 <ul class="select-list">
	                <s:iterator value="#request.Grade" var="Grade">
						<li id="<s:property value='#Grade.ddlName'/>"><s:property value="#Grade.ddlName"/></li>
					</s:iterator>  
					<li>&nbsp;</li>
                </ul>
		</div>
		</div>
        
		<div class="conditions name ue-clear">
			<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院：</label>
			<input  hidden="hidden" name="studentdutys.college" value="${querycon.college}"/>
			<div class="select-wrap">
				<div class="select-title ue-clear"><span>${querycon.college}</span><i class="icon"></i></div>
				<ul class="select-list">
				 <s:iterator value="#request.College" var="College">
						<li id="<s:property value='#College.ddlName'/>"><s:property value="#College.ddlName"/></li>
					</s:iterator>  
					<li>&nbsp;</li>
				</ul>
			 </div>
		 </div>
	</div>
	<div class="query-conditions ue-clear">
		<div class="conditions staff ue-clear">
			<label>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
				<input type="text" name="studentdutys.className" value="${querycon.className}" />
		</div>
		
		<div class="conditions name ue-clear">
			    <label>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</label>
			    <input  hidden="hidden"  name="studentdutys.duty" value="${querycon.duty}"/>
			<div class="select-wrap">
				<div class="select-title ue-clear"><span>${querycon.duty}</span><i class="icon"></i></div>
				<ul class="select-list">
				        <s:iterator value="#request.Duty" var="Duty">
						<li id="<s:property value='#Duty.ddlName'/>"><s:property value="#Duty.ddlName"/></li>
						</s:iterator> 
						<li>&nbsp;</li> 
				 </ul>
			</div>
		 </div>
	</div>
	 
	<div class="query-btn ue-clear">
    		<a href="javascript:query()" class="confirm">查询</a>
	</div>
</div>
		
		
<div class="table-operate ue-clear">
			<a:if url="/studentdutys/studentdutys_add.action"><a href="${basePath}studentdutys/studentdutys_addUI.action" class="add">添加</a></a:if>
			<a:if url="/studentdutys/studentdutys_delete.action"><a href="javascript:deleteItem()" class="del">删除</a> </a:if>
			<a:if url="/studentdutys/studentdutys_importExcel.action"><a href="javascript:;" class="import clear clear">导入</a></a:if>
    		<a:if url="/studentdutys/studentdutys_exportExcel.action"><a href="javascript:downloadItem()">下载</a></a:if>
 
		</div>
<div class="table-box">
	<table>
				<thead>
					<tr>
						<a:if url="/studentdutys/studentdutys_editor.action"><th width="5%">
							<input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
						<th width="3%">序号</th>
						<th width="8%">年级</th>
						<th width="6%">学院</th>
						<th width="8%">班级</th>
						<th width="4%">姓名</th>
						<th width="4%">性别</th>
						<th width="10%">职务</th>
						<th width="8%">手机</th>
						<th width="6%">短号</th>
						<th width="8%">宿舍</th>
						<th width="8%">备注</th>
						<a:if url="/studentdutys/studentdutys_editor.action"><th width="5%">编辑</th></a:if>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="studentdutys" status="stuts">
					
						<tr>
							<a:if url="/studentdutys/studentdutys_editor.action"><td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#studentdutys.id'/>' /></td></a:if>
							<td class="num">${stuts.count+(pageUtils.pageNo-1)*pageUtils.pageSize}</td>
							<td><s:property value="#studentdutys.grade" /></td>
							<td><s:property value="#studentdutys.college" /></td>
							<td><s:property value="#studentdutys.className" /></td>
							<td><s:property value="#studentdutys.stuName" /></td>
							<td><s:property value="#studentdutys.sex" /></td>
							<td><s:property value="#studentdutys.duty" /></td>
							<td><s:property value="#studentdutys.telNo" /></td>
							<td><s:property value="#studentdutys.shortTelNo" /></td>
							<td><s:property value="#studentdutys.address"/></td>
							<td><s:property value="#studentdutys.memo" /></td>
							<a:if url="/studentdutys/studentdutys_editor.action"><td><a href="javascript:editor('<s:property value='#studentdutys.id'/>')">
								<img src="../images/edtico.png" /></a></td></a:if>
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
    </div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
	</form>
<jsp:include page="/common/inputdialog.jsp"></jsp:include>
</body>

</html>