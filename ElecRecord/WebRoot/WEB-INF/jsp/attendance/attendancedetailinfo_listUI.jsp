
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
    	
    	window.open("${basePath}attendanceDetail/attendanceDetail_detailUI.action?attendanceDetail.id="+$id);

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
var queryAction="${basePath}attendancedetail/attendancedetail_listUI.action";
var deleteAction="${basePath}attendancedetail/attendancedetail_delete.action";
var importUrl="${basePath}attendancedetail/attendancedetail_importExcel.action";


function query(){
	    $("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
	

function add(){
		var url="${basePath}attendancedetail/attendancedetail_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 


function editor(id){
		var url="${basePath}attendancedetail/attendancedetail_editorUI.action?attendanceDetail.id="+id;
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 


 </script>
<title>考勤信息</title>
</head>

<body>
<div class="title"><h2>考勤信息</h2></div>
<form id="queryForm"   method="post">
<div class="query">

	<div class="query-conditions ue-clear" style="width:100%">                  
	                                          
       <div class="conditions staff ue-clear" style="width:25%">
            <label style="text-align: right;margin-right: 15px">学号：</label>
            <input type="text" placeholder="请输入学生学号进行查询" name="attendanceDetail.studentno" value="${queryCon.studentno}" style="width:210px;height:30px" />
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%">
            <label style="text-align: right;margin-right: 15px">姓名：</label>
            <input type="text" placeholder="请输入学生姓名进行查询" name="attendanceDetail.stuname" value="${queryCon.stuname}" style="width:210px;height:30px"/>
            
        </div>
       
    </div>
    
    <div class="query-conditions ue-clear" style="width:100%">                  
	                                          
       <div class="conditions staff ue-clear" style="width:25%">
            <label style="text-align: right;margin-right: 15px">考勤时间：</label>
           <input type="text" value="<s:date format="yyyy-MM-dd" name="attendanceDetail.attendanceTime"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="attendanceDetail.attendanceTime" style="width:210px;height:30px"/>
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%">
            <label style="text-align: right;margin-right: 15px">班级：</label>
            <input type="text" placeholder="请输入学生所在班级进行查询" name="attendanceDetail.classname" value="${queryCon.classname}" style="width:210px;height:30px"/>
            
        </div>
       
       
        
    </div>
    
    <div class="query-btn ue-clear" >
    	<a href="javascript:query()" class="confirm" style="margin-left:16px">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
     <a href="javascript:add()" class="add">添加</a>
    <a href="javascript:del()" class="del confirm save">删除</a>
    <a href="javascript:" class="import clear clear">导入</a>
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			<th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()" /></th>
            	<th width="20%" class="num">学号</th>
                <th width="15%" >姓名</th>
                <th width="10%" >性别</th>
				<th width="20%" align="center">所在班级</th>
				<th width="20%" >考勤时间</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="attendanceDetail">
        	<tr>
			<td class="num" ><input  type="checkbox" name="selectedRow" value='<s:property value='#attendanceDetail.id'/>'/></td>
            	<td><s:property value="#attendanceDetail.studentno"/></td>
				<td ><s:property value="#attendanceDetail.stuname"/></td>
				<td ><s:property value="#attendanceDetail.sex"/></td>
				<td><s:property value="#attendanceDetail.classname"/></td>
				<td><s:date format="yyyy-MM-dd" name="#attendanceDetail.attendanceTime"/></td>
				<td><a href="javascript:editor('<s:property value='#attendanceDetail.id'/>')"><img src="../images/edtico.png"/></a></td>
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