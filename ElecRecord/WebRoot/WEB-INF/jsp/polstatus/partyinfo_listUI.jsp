
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<script type="text/javascript">
<!-- action之间的跳转 ，用于换页-->
var queryAction="${basePath}polstatus/polstatus_listUI.action";
var deleteAction="${basePath}polstatus/polstatus_delete.action";
var importUrl="${basePath}polstatus/polstatus_importExcel.action";
</script>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" href="${basePath}css/list.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<!-- 行之间的显示效果与选中行的效果 -->
<style type="text/css">
        .even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
        .selected{background:#DDDDDD;color:#003333} /*选中行样式*/
</style>
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<title>学生党团关系信息</title>
</head>

<body>
<div class="title"><h2>学生党团关系信息</h2></div>
<!-- 跳转页面时表单提交数据，换页显示数据 -->
 <form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">

 <div class="main">     
    <p class="short-input ue-clear"> 
            <label>&nbsp;&nbsp;&nbsp;&nbsp;姓名：</label>
        <input type="text" name="politicalstatus.stuName" placeholder="请输入姓名进行查询" value="${querycon.stuName}" style="width:200px;height:30px"/>

        

          <label>&nbsp;&nbsp;&nbsp;&nbsp;学号：</label>
        <input type="text" name="politicalstatus.studentNo" placeholder="请输入学号进行查询" value="${querycon.studentNo}" style="width:200px;height:30px" />

            <label>&nbsp;&nbsp;入党日期：</label>
            <input type="text" value="<s:date format="yyyy-MM-dd" name="politicalstatus.joinDate"/>" placeholder="请输入日期进行查询" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="politicalstatus.joinDate" style="width:200px;height:30px"/>
</p>
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a:if url="/polstatus/polstatus_add.action"><a href="javascript:add()" class="add">添加</a></a:if>
    <a:if url="/polstatus/polstatus_delete.action"><a href="javascript:del()" class="del confirm save">删除</a></a:if>
    <a:if url="/polstatus/polstatus_importExcel.action"><a href="javascript:;" class="import clear clear">导入</a></a:if>
<!--     <a href="javascript:;" class="upload">上传</a> -->
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			<a:if url="/polstatus/polstatus_editor.action"> <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
            	<th width="20%" class="num">学号</th>
            	 <th width="15%" >姓名</th>
				<th width="15%" >入党日期</th>
				<th width="10%" align="center">政治面貌</th>
				<th width="30%" >备注</th>
				<a:if url="/polstatus/polstatus_editor.action"><th width="10%">编辑</th></a:if>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="political">
        	<tr>
			<a:if url="/polstatus/polstatus_editor.action"><td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#political.id'/>'/></td></a:if>
              		<input type="hidden" name="select" value='<s:property value='#political.id'/>'/>
              	<td><s:property value="#political.studentNo"/></td>
				<td ><s:property value="#political.stuName"/></td>
				<td><s:date name="#political.joinDate" format="yyyy-MM-dd"></s:date></td>
				<td><s:property value="#political.politicalStatus"/></td>
				<td><s:property value="#political.memo"/></td>
				<!-- 跳转到editor对应的action。并将对应的查询条件数据传到action -->
				<a:if url="/polstatus/polstatus_editor.action"><td><a href="javascript:editor('<s:property value='#political.id'/>')"><img src="../images/edtico.png"/></a></td></a:if>
            </tr> 
            </s:iterator>        
        </tbody>
    </table>
    
</div>
<!-- 跳转页面  页码    （将这语句置于form表单之内  才能提交页码）-->
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-form.js"></script>
<jsp:include page="/common/inputdialog.jsp"></jsp:include>
</body>

<script type="text/javascript">

/* 批量选中*/
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
} 
//单击及双击的JS样式
	$(function(){
      //单击
        $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
        $("tr:even").addClass("even"); /* 偶数行添加样式*/

       
        //双击跳转到详情页面
        $('tbody>tr').dblclick(function() {
        //双击得到当前行数据的id
       	var $id=$(this).find('input[name=select]').val();
       	//跳转到详情页
       	window.open("${basePath}polstatus/polstatus_detailUI.action?politicalstatus.id="+$id);
        });
        
        
        
        //点击改变选中样式
        $('tbody>tr').click(function() {
            $(this)
                    .addClass('selected')
                    .siblings().removeClass('selected')
                    .end();
        });
	})
	//向polstatus_editorUI.action提交信息
function editor(id){
		var url="${basePath}polstatus/polstatus_editorUI.action?politicalstatus.id="+id;
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向polstatus_addUI.action提交信息
function add(){
		var url="${basePath}polstatus/polstatus_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向polstatus_listUI.action提交信息
function query(){
	 	$("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
//向polstatus_delete().action提交信息
function del(){
	$('.delDialog').Dialog('open'); 
} 
 </script>
</html>

 
