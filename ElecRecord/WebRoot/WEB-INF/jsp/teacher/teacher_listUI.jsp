<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<%@ taglib prefix="a" uri="http://openhome.cc/jstl/fake"%>
<html>
<head>
    
<title>教师信息列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/list.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>
<!-- ------------注意：设置全局变量时的代码----------------- -->
<script type="text/javascript">
//使用pagination.jsp的这个命名是支付宝死的

	var queryAction="${basePath}teacher/teacher_listUI.action";
	var deleteAction="${basePath}teacher/teacher_delete.action";
	var importUrl="${basePath}teacher/teacher_importExcel.action";
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
 	function editor(id){
 		var url="${basePath}teacher/teacher_editorUI.action?teacher.id="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}teacher/teacher_detailUI.action?teacher.id="+id;
 		
 		window.open(url) ; //打开窗口
 	}
</script>

</head>



<body>
<div class="title"><h2>教师信息列表</h2></div>
<form id="queryForm" action="${basePath}teacher/teacher_listUI.action" method="post">
<div class="query">
    <div class="main">     
    <p class="short-input ue-clear">    	
        <label>工号：</label>
        <s:textfield name="queryNO" class="strutsinput"></s:textfield>
        <label>姓名：</label>
        <s:textfield name="qeuryName" class="strutsinput"></s:textfield>
    </p>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}teacher/teacher_addUI.action" class="add">添加</a>
    <a href="javascript:deleteItem()" class="del">删除</a>
    <a href="javascript:" class="import clear clear">导入</a>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="8%">工号</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="8%" >姓名</th>
				<th width="8%" align="center">性别</th>
				<th width="15%" >学院</th>
				<th width="8%" align="center">职务</th>
				<th width="8%" >联系电话</th>
				<th width="10%" >政治面貌</th>
				<th width="12%" >毕业院校</th>
				<th width="5%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="teacher">
        	<tr>
			 <th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#teacher.id'/>' /></th>
            	<td><a href="javascript:detail('<s:property value='#teacher.id'/>')"><s:property value="#teacher.employNo"/></a></td>
				<td ><s:property value="#teacher.employName"/></td>
				<td><s:property value="#teacher.sex"/></td>
				<td><s:property value="#teacher.orgName"/></td>
				<td><s:property value="#teacher.duty"/></td>
				<td><s:property value="#teacher.telNo"/></td>
				<td><s:property value="#teacher.politicalStatus"/></td>
				<td><s:property value="#teacher.graduate"/></td>
				<td><a href="javascript:editor('<s:property value='#teacher.id'/>')"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-form.js"></script>
<jsp:include page="/common/inputdialog.jsp"></jsp:include>
</body>
