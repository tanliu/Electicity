<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<%@ taglib prefix="a" uri="http://openhome.cc/jstl/fake"%>
<html>
<head>
    
<title>学生信息列表</title>

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

	var queryAction="${basePath}student/student_listUI.action";
	var deleteAction="${basePath}student/student_delete.action";
	var importUrl="${basePath}student/student_impotExcel.action";

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
 		var url="${basePath}student/student_editorUI.action?student.stuId="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}student/student_detailUI.action?student.stuId="+id;
 		
 		window.open(url) ; //打开窗口
 	}
</script>

</head>



<body>
<div class="title"><h2>学生信息列表</h2></div>
<form id="queryForm" action="${basePath}student/student_listUI.action" method="post">
<div class="query">
    <div class="main">     
    <p class="short-input ue-clear">    	
        <label>学号：</label>
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
	<a:if url="/student/student_add.action"><a href="${basePath}student/student_addUI.action" class="add">添加</a></a:if>
   <a:if url="/student/student_delete.action"> <a href="javascript:deleteItem()" class="del">删除</a></a:if>
   <a:if url="/student/student_importExcel.action"> <a href="javascript:" style=" width:100px; " id="importstudent" class="import clear clear">导入学生信息</a></a:if>
    <a:if url="/student/student_importExcel.action"><a href="javascript:" style=" width:100px; " id="importfamily" class="import clear clear">导入家庭信息</a></a:if>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <a:if url="/student/student_editor.action"><th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
            	<th width="8%">学号</th>
                <th width="8%" >姓名</th>
				<th width="15%" >学院</th>
				<th width="15%" align="center">专业</th>
				<th width="16%" >班级</th>
				<th width="8%" align="center">性别</th>
				<th width="8%" >入学日期</th>
				<a:if url="/student/student_editor.action"><th width="5%">编辑</th>	</a:if>			
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="student">
        	<tr>
			<a:if url="/student/student_editor.action"> <th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#student.stuId'/>' /></th></a:if>
            	<td><a href="javascript:detail('<s:property value='#student.stuId'/>')"><s:property value="#student.studentNo"/></a></td>
				<td ><s:property value="#student.stuName"/></td>
				<td><s:property value="#student.orgName"/></td>
				<td><s:property value="#student.major"/></td>
				<td><s:property value="#student.className"/></td>
				<td><s:property value="#student.sex"/></td>
				<td> <s:date name="#student.acceptanceDate" format="yyyy-MM-dd"/> </td>
				<a:if url="/student/student_editor.action"><td><a href="javascript:editor('<s:property value='#student.stuId'/>')"><img src="../images/edtico.png"/></a></td></a:if>
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
<script type="text/javascript">
$('#importstudent').click(function(){
	importUrl="${basePath}student/student_importExcel.action";
	$('.importDialog').Dialog('open');
});
$('#importfamily').click(function(){
	importUrl="${basePath}student/student_importFamilyExcel.action";
	$('.importDialog').Dialog('open');
});
</script>
</body>
