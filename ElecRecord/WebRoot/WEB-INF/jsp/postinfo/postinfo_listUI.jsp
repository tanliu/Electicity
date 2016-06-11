
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
<script type="text/javascript">
	    var queryAction="${basePath}postinfo/postinfo_listUI.action";
		var deleteAction="${basePath}postinfo/postinfo_delete.action";
		var downloadAction="${basePath}postinfo/postinfo_exportExcel.action";
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

	 	//向postinfo_editorUI.action提交信息
	 	function editor(id){
	 			var url="${basePath}postinfo/postinfo_editorUI.action?postinfo.id="+id;
	 			$("#queryForm").attr("action",url);
	 	 		$("#queryForm").submit();  
	 	} 
	 	
	    $(function(){
	    	 $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
			    $("tr:even").addClass("even"); /* 偶数行添加样式*/
			
			    
			  	//双击跳转到详情页面
			  	$('tbody>tr').dblclick(function() {
			  		var sid=$(this).find('td').find("#subid").val();
			  		var url="${basePath}postinfo/postinfo_detailUI.action?postinfo.id="+sid;
			  		window.open(url);
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
<div class="title"><h2>学生档案邮寄管理</h2></div>
	<form id="queryForm"
		action="${basePath}postinfo/postinfo_listUI.action"
		method="post">
	<div class="query">
	<div class="query-conditions ue-clear">
		<div class="conditions staff ue-clear">
			<label>EMS编号：</label>
				<input type="text" name="postinfo.emsno" value="${querycon.emsno}" />
		</div>
		<div class="conditions staff ue-clear">
			<label>邮件号：</label>
				<input type="text" name="postinfo.mailNo" value="${querycon.mailNo}" />
		</div>
	</div>
	 <div class="query-conditions ue-clear">
		<div class="conditions name ue-clear">
			<label>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
			<input  hidden="hidden" name="postinfo.major" value="${querycon.major}"/>
			<div class="select-wrap">
				<div class="select-title ue-clear"><span>${querycon.major}</span><i class="icon"></i></div>
				<ul class="select-list">
				 <s:iterator value="#request.major" var="Major">
						<li id="<s:property value='#Major.ddlName'/>"><s:property value="#Major.ddlName"/></li>
					</s:iterator>  
				</ul>
			 </div>
		 </div>
		<div class="conditions staff ue-clear">
			<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
				<input type="text" name="postinfo.stuName" value="${querycon.stuName}" />
		</div>
	</div>
	 
	<div class="query-btn ue-clear">
    		<a href="javascript:query()" class="confirm">查询</a>
	</div>
</div>
		
		
<div class="table-operate ue-clear">
			<a href="${basePath}postinfo/postinfo_addUI.action" class="add">添加</a>
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
						<th width="5%">EMS编号</th>
						<th width="5%">北理工编号</th>
						<th width="8%">专业名称</th>
						<th width="5%">姓名</th>
						<th width="5%">学号</th>
						<th width="3%">性别</th>
						<th width="6%">派遣性质</th>
						<th width="15%">主管单位</th>
						<th width="8%">邮件号</th>
						<th width="8%">备注</th>
						<th width="3%">编辑</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="postinfo" status="stuts">
					
						<tr>
							<td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#postinfo.id'/>' /></td>
							<td class="num">${stuts.count+(pageUtils.pageNo-1)*pageUtils.pageSize}</td>
							<td><s:property value="#postinfo.emsno" /></td>
							<td><s:property value="#postinfo.schoolNo" /></td>
							<td><s:property value="#postinfo.major" /></td>
							<td><s:property value="#postinfo.stuName" /></td>
							<td><s:property value="#postinfo.studentNo" /></td>
							<td><s:property value="#postinfo.sex" /></td>
							<td><s:property value="#postinfo.dispatchType" /></td>
							<td><s:property value="#postinfo.chargeUnit" /></td>
							<td><s:property value="#postinfo.mailNo"/></td>
							<td><s:property value="#postinfo.memo" /></td>
							<td><a href="javascript:editor('<s:property value='#postinfo.id'/>')">
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
            <form id="fileForm" action="${basePath}postinfo/postinfo_importExcel.action" method="post" enctype="multipart/form-data">
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