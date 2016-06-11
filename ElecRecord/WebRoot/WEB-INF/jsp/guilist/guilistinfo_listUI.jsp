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


//单击的JS
$(function(){
    
   $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
   $("tr:even").addClass("even"); /* 偶数行添加样式*/
   
    
    //点击改变选中样式
    $('tbody>tr').click(function() {
        $(this)
                .addClass('selected')
                .siblings().removeClass('selected')
                .end();
    });
})

//以下两条路径用于访问Action
var queryAction="${basePath}guilist/guilist_listUI.action";
var deleteAction="${basePath}guilist/guilist_delete.action";

//向guilist_editorUI.action提交信息
function editor(id){
		var url="${basePath}guilist/guilist_editorUI.action?guiList.id="+id;
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 

//向guilist_addUI.action提交信息
function add(){
		var url="${basePath}guilist/guilist_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向guilist_listUI.action提交信息
function query(){
	  	$("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
	
//向guilist_delUI.action提交信息
function del(){
		var url="${basePath}guilist/guilist_delete.action";
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 
 </script>
<title>导学名单</title>
</head>

<body>
<div class="title"><h2>导学名单</h2></div>
<form id="queryForm" action="${basePath}guilist/guilist_listUI.action" method="post">
<div class="query">

	<div class="query-conditions ue-clear" >
                                                               
     
        
       <div class="conditions staff ue-clear" style="width:25%;margin-right:3px;" >
            <label style="margin-left:3px;width:50px">学号：</label>
            <input   type="text" placeholder="请输入学生学号进行查询" name="guiList.studentNo" value="${queryCon.studentNo}" style="width:200px;height:30px" />
            
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%;margin-right:3px;">
            <label style="margin-right:3px;width:60px">学生姓名：</label>
            <input  type="text" placeholder="请输入学生姓名进行查询" name="guiList.stuName" value="${queryCon.stuName}" style="width:200px;height:30px"/>
            
        </div>
        
          <div class="conditions staff ue-clear" style="width:25%;margin-right:3px;">
            <label style="margin-right:3px;width:60px">导师姓名：</label>
            <input  type="text" placeholder="请输入导师姓名进行查询" name="guiList.teacherName" value="${queryCon.teacherName}" style="width:200px;height:30px"/>
            
        </div>
        
        
        
       
        
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
  <a href="javascript:add()" class="add">添加</a>
    <a href="javascript:" class="del confirm save">删除</a>
    <a href="javascript:" class="import clear clear">导入</a>
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			<th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()" /></th>
            	<th width="25%" class="num">学号</th>
                <th width="25%" >专业班级</th>
				<th width="20%" align="center">姓名</th>
				<th width="20%" >导师姓名</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="guilist">
        	<tr>
        	
			<td class="num" ><input  type="checkbox" name="selectedRow" value='<s:property value='#guilist.id'/>' /></td>
			
            	<td><s:property value="#guilist.studentNo"/></td>
            	<td><s:property value="#guilist.className"/></td>
				<td ><s:property value="#guilist.stuName"/></td>		
				<td><s:property value="#guilist.teacherName"/></td>
				<td><a href="javascript:editor('<s:property value='#guilist.id'/>')"><img src="../images/edtico.png"/></a></td>
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
            <form id="fileForm" action="${basePath}guilist/guilist_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel"  id="filename"/></p>
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
<!--实现文本选择框的脚本-->

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
		
		if(document.getElementById("filename").value){//在文件非空的条件下才允许向后台提交请求
			$("#fileForm").submit();
		}
		else{
			$('.importDialog').Dialog('open');//如果用户未选择任何文件，那么窗口保持打开状态
		}
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
		del();
	}
});

</script>
</html>
