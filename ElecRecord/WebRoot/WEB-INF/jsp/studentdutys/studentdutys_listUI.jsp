<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />
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
	    var queryAction="${basePath}studentdutys/studentdutys_listUI.action";
		var deleteAction="${basePath}studentdutys/studentdutys_delete.action";
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
	 		$("#queryForm").attr("action",deleteAction);
		 	$("#queryForm").submit();  
		} 
	 	function downloadItem(){
	 		$("#queryForm").attr("action",downloadAction);
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
		<input hidden="hidden" name="studentdutys.id" value="#studentdutys.id"/>
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
                </ul>
            </div>
        </div>
	</div>
	</div>
 <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
		<div class="table-operate ue-clear">
			<a href="${basePath}studentdutys/studentdutys_addUI.action" class="add">添加</a>
			<a href="javascript:deleteItem()" class="del">删除</a> 
			<a href="javascript:;" class="import">导入</a>
    		<a href="javascript:;" class="upload">上传</a>
    		<a href="javascript:downloadItem()" class="del">下载</a>
    		
		</div>
	
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
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
						<th width="5%">编辑</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="studentdutys" status="stuts">
					
						<tr>
							<td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#studentdutys.id'/>' /></td>
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
							<td><a href="${basePath}studentdutys/studentdutys_editorUI.action?studentdutys.id=<s:property value='#studentdutys.id'/>">
								<img src="../images/edtico.png" /></a></td>
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/pagination.jsp"></jsp:include>
	</form>
<div class="importDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center">
            <p class="dialog-content">请选择要导入的excel文件</p>
            <form id="fileForm" action="${basePath}studentdutys/studentdutys_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel"  /></p>
          </form>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="返回" />
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
</script>
</html>