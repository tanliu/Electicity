
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<%@ taglib prefix="a" uri="http://openhome.cc/jstl/fake"%>

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />

<style type="text/css">
/*单元格样式*/
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}

/*行显示效果*/
  .even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
        .selected{background:#dddddd;color:#003333} /*选中行样式*/

</style>

<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>

<script type="text/javascript" >

//选择框效果的JS
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
} 


//单击及双击的JS
$(function(){
    
   $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
   $("tr:even").addClass("even"); /* 偶数行添加样式*/
   
    //双击跳转到详情页面
    $('tbody>tr').dblclick(function() {
    
    	 var $id=$(this).children("td").children("input").val();
    	
    	window.open("${basePath}tutor/tutor_detailUI.action?tutor.id="+$id);

     }  
        
    );
    
    //点击改变选中样式
    $('tbody>tr').click(function() {
        $(this)
                .addClass('selected')
                .siblings().removeClass('selected')
                .end();
    });
})


//以下路径用于访问Action
var queryAction="${basePath}attendancemaster/attendancemaster_listUI.action";
var deleteAction="${basePath}attendancemaster/attendancemaster_delete.action";
var importUrl="${basePath}attendancemaster/attendancemaster_importExcel.action";

//向stustatus_listUI.action提交信息
function query(){
	    $("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
	
//向stustatus_addUI.action提交信息
function add(){
		var url="${basePath}attendancemaster/attendancemaster_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向stustatus_editorUI.action提交信息
function editor(id){
		var url="${basePath}attendancemaster/attendancemaster_editorUI.action?attendanceMaster.id="+id;
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 


 </script>
<title>考勤课程信息</title>
</head>

<body>
<div class="title"><h2>考勤课程信息</h2></div>
<form id="queryForm"  action="${basePath}tutor/tutor_listUI.action" method="post">
<div class="query">

	<div class="query-conditions ue-clear" style="width:100%">                  
	                                          
       <div class="conditions staff ue-clear" style="width:25%">
            <label>课程名称：</label>
            <input type="text" placeholder="请输入课程名称进行查询" name="attendanceMatser.coursename" value="${queryCon.coursename}" style="width:233px;height:30px" />
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%">
            <label>教师姓名：</label>
            <input type="text" placeholder="请输入教师姓名进行查询" name="attendanceMatser.employName" value="${queryCon.employName}" style="width:233px;height:30px"/>
            
        </div>
        
            
         <div class="conditions staff ue-clear" >
            <label>上课地点：</label>
            <input type="text" placeholder="请输入上课地点进行查询" name="attendanceMatser.address" value="${queryCon.address}" style="width:233px;height:30px"/>
            
        </div>
       
       
        
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
     <a:if url="/tutor/tutor_addUI.action">	<a href="javascript:add()" class="add">添加</a></a:if>
    <a href="javascript:del()" class="del confirm save">删除</a>
    <a href="javascript:" class="import clear clear">导入</a>
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			<th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()" /></th>
            	<th width="20%" class="num">选课课号</th>
                <th width="15%" >课程名称</th>
				<th width="20%" align="center">教师工号</th>
				<th width="15%" >教师姓名</th>
				<th width="15%" align="center">上课地点</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="attendanceMatser">
        	<tr>
			<td class="num" ><input  type="checkbox" name="selectedRow" value='<s:property value='#attendanceMatser.id'/>'/></td>
            	<td><s:property value="#attendanceMatser.selectedcourseno"/></td>
				<td ><s:property value="#attendanceMatser.coursename"/></td>
				<td><s:property value="#attendanceMatser.employNo"/></td>
				<td><s:property value="#attendanceMatser.employName"/></td>
				<td><s:property value="#attendanceMatser.address"/></td>
				<td><a href="javascript:editor('<s:property value='#attendanceMatser.id'/>')"><img src="../images/edtico.png"/></a></td>
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

function del(){
	var selectedRows=document.getElementsByName("selectedRow");
	
	for(i=0;i<selectedRows.length;i++){
		if(selectedRows[i].checked){
			$('.delDialog').Dialog('open');
		}
	}
	
}

</script>
</html>