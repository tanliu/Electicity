<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>用户信息列表</title>

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

	var queryAction="${basePath}system/role_listUI.action";
	var deleteAction="${basePath}system/role_delete.action";
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
 		var url="${basePath}system/role_editorUI.action?role.roleId="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}system/role_detailUI.action?role.roleId="+id;
 		
 		window.open(url) ; //打开窗口
 	}
</script>

</head>



<body>
<div class="title"><h2>角色信息列表</h2></div>
<form id="queryForm" action="${basePath}system/role_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>角色名称：</label>
            <!-- 如果employNo的值是空时，表示上一页的查询条件是以用户的方式查询 -->
            <s:textfield id="condition" name="querycon"></s:textfield>            

        </div>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}system/role_addUI.action" class="add">添加</a>
    <a href="javascript:deleteItem()" class="del">删除</a>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="25%" class="num">角色名称</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="25%" >创建时间</th>
				<th width="25%" >备注</th>
				<th width="15%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="role">
        	<tr>
			 <th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#role.roleId'/>' /></th>
            	<td><a href="javascript:detail('<s:property value='#role.roleId'/>')"><s:property value="#role.roleName"/></a></td>
				<td><s:date name="#role.createTime" format="yyyy:MM:dd HH:mm:ss"/> </td>
				<td><s:property value="#role.memo"/></td>	            
				<td><a href="javascript:editor('<s:property value='#role.roleId'/>')"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
</body>
