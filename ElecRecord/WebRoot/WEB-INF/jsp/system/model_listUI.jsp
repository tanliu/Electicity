<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>模块信息列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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

	var queryAction="${basePath}system/model_listUI.action";
	var deleteAction="${basePath}system/model_delete.action";
	function query(){

	 	//--------------提交信息------------------
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
 	function editor(id){
 		var url="${basePath}system/model_editorUI.action?model.id="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}system/model_detailUI.action?model.id="+id;
 		
 		window.open(url) ; //打开窗口
 	}
</script>

</head>



<body>
<div class="title"><h2>角色信息列表</h2></div>
<form id="queryForm" action="${basePath}system/model_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>模块名称：</label>
            <!-- 如果employNo的值是空时，表示上一页的查询条件是以用户的方式查询 -->
            <s:textfield id="condition" name="querycon"></s:textfield>            

        </div>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}system/model_addUI.action" class="add">添加</a>
    <a href="javascript:deleteItem()" class="del">删除</a>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="40%" class="num">文件名</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="40%" >创建人</th>
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="model">
        	<tr>
			 <th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#model.id'/>' /></th>
            	<td><s:property value="#model.fileName"/></td>
				<td><s:property value="#model.creator"/></td>	            
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
</body>
