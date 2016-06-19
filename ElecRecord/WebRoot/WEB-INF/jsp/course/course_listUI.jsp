<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<%@ taglib prefix="a" uri="http://openhome.cc/jstl/fake"%>
<html>
<head>
    
<title>开课信息列表</title>

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

	var queryAction="${basePath}course/course_listUI.action";
	var deleteAction="${basePath}course/course_delete.action";
	var importUrl="${basePath}course/course_importExcel.action";
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
 		var url="${basePath}course/course_editorUI.action?course.id="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}course/course_detailUI.action?course.id="+id;
 		
 		window.open(url) ; //打开窗口
 	}
 	function selectCourse(id){
 		var url="${basePath}course/course_selectUI.action?course.id="+id;
 		
 		window.open(url) ; //打开窗口
 	}
</script>

</head>



<body>
<div class="title"><h2>开课信息列表</h2></div>
<form id="queryForm" action="${basePath}course/course_listUI.action" method="post">
<div class="query">
    <div class="main">     
    <p class="short-input ue-clear">    	
        <label>教师工号：</label>
        <s:textfield name="queryNO" class="strutsinput"></s:textfield>
        <label>教师姓名：</label>
        <s:textfield name="qeuryName" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>课程号：</label>
        <s:textfield name="courseNO" class="strutsinput"></s:textfield>
        <label>课程名称：</label>
        <s:textfield name="courseName" class="strutsinput"></s:textfield>
        <label>学年：</label>
        <s:textfield name="studyYear" class="strutsinput"></s:textfield>
    </p>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}course/course_addUI.action" class="add">添加</a>
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
				<th width="15%" align="center">课程名称</th>
				<th width="8%" >学年</th>
				<th width="8%" align="center">学期</th>
				<th width="8%" >课程性质</th>
				<th width="6%" >总学时</th>
				<th width="8%" >选课人数</th>
				<th width="14%" >教学班组成</th>
				<th width="6%" >选课情况</th>				
				<th width="5%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="course">
        	<tr>
			 <th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#course.id'/>' /></th>
            	<td><a href="javascript:detail('<s:property value='#course.id'/>')"><s:property value="#course.employNo"/></a></td>
				<td ><s:property value="#course.employName"/></td>
				<td><s:property value="#course.courseName"/></td>
				<td><s:property value="#course.academicYear"/></td>
				<td><s:property value="#course.term"/></td>
				<td><s:property value="#course.courseType"/></td>
				<td><s:property value="#course.totalHours"/></td>
				<td><s:property value="#course.studentNum"/></td>
				<td><s:property value="#course.classInfo.substring(0, 6)+'...'"/></td>
				<td><a href="javascript:selectCourse('<s:property value='#course.id'/>')">查看</a></td>
				<td><a href="javascript:editor('<s:property value='#course.id'/>')"><img src="../images/edtico.png"/></a></td>
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
