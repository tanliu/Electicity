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


//单击及双击的JS
$(function(){
    
   $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
   $("tr:even").addClass("even"); /* 偶数行添加样式*/
   
    //双击跳转到详情页面
    $('tbody>tr').dblclick(function() {
    
    	 var $id=$(this).children("td").children("input").val();
    	
    	window.open("${basePath}guicontent/guicontent_detailUI.action?guiContent.id="+$id);

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

//以下两条路径用于访问Action
var queryAction="${basePath}guicontent/guicontent_listUI.action";
var deleteAction="${basePath}guicontent/guicontent_delete.action";
var importUrl="${basePath}guicontent/guicontent_importExcel.action";

//向guiContent_editorUI.action提交信息
function editor(id){
		var url="${basePath}guicontent/guicontent_editorUI.action?guiContent.id="+id;
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 

//向guiContent_addUI.action提交信息
function add(){
		var url="${basePath}guicontent/guicontent_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向guiContent_listUI.action提交信息
function query(){
	  	$("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
	
//向guiContent_delUI.action提交信息
function del(){
		var url="${basePath}guicontent/guicontent_delete.action";
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 
 </script>
<title>导学信息</title>
</head>

<body>
<div class="title"><h2>导学信息</h2></div>
<form id="queryForm" action="${basePath}guicontent/guicontent_listUI.action" method="post">
<div class="query">

	<div class="query-conditions ue-clear" >
                                                               
     
        
       <div class="conditions staff ue-clear" style="width:25%;margin-right:3px;" >
            <label style="margin-left:3px;width:50px">学号：</label>
            <input   type="text" placeholder="请输入学生学号进行查询" name="guiContent.studentNo" value="${queryCon.studentNo}" style="width:200px;height:30px" />
            
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%;margin-right:3px;">
            <label style="margin-right:3px;width:50px">姓名：</label>
            <input  type="text" placeholder="请输入学生姓名进行查询" name="guiContent.stuName" value="${queryCon.stuName}" style="width:200px;height:30px"/>
            
        </div>
        
          <div class="conditions staff ue-clear" >
            <label>导学时间：</label>
            <input type="text" value="<s:date format="yyyy-MM-dd" name="guiContent.guidDate"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="guiContent.guidDate" style="width:233px;height:30px"/>
            
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
            	<th width="20%" class="num">学号</th>
                <th width="15%" >姓名</th>
				<th width="20%" align="center">专业班级</th>
				<th width="15%" >导学时间</th>
				<th width="15%" align="center">导学地点</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="guiContent">
        	<tr>
        	
			<td class="num" ><input  type="checkbox" name="selectedRow" value='<s:property value='#guiContent.id'/>' /></td>
			
            	<td><s:property value="#guiContent.studentNo"/></td>
				<td ><s:property value="#guiContent.stuName"/></td>
				<td><s:property value="#guiContent.className"/></td>
				<td><s:date format="yyyy-MM-dd HH:mm:ss" name="#guiContent.guidDate"/></td>
				<td><s:property value="#guiContent.guidAddress"/></td>
				<td><a href="javascript:editor('<s:property value='#guiContent.id'/>')"><img src="../images/edtico.png"/></a></td>
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

</html>
