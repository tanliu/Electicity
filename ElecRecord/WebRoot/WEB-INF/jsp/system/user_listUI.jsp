<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>添加用户信息</title>
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

	var queryAction="${basePath}system/user_listUI.action";
	var deleteAction="${basePath}system/user_delete.action";
	function query(){
		alert("--------------------");
		var $radio=$("input[type=radio]:checked");
	 	var $condition=$("#condition");
	 	if($radio.val()=="用户编号"){
	 		$condition.attr("name","user.employNo"); 		
	 	}else{
	 		$condition.attr("name","user.employName"); 			
	 	}
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
</script>

</head>



<body>
<div class="title"><h2>用户信息列表</h2></div>
<form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>机构名称：</label>
            <!-- 如果employNo的值是空时，表示上一页的查询条件是以用户的方式查询 -->
            <s:if test="user.employNo==null">
            <s:textfield id="condition" name="user.employName"></s:textfield>
            </s:if>
            <s:else>
            <s:textfield id="condition" name="user.employNo"></s:textfield>            
            </s:else>
        </div>
    </div>
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>查询方式：</label>
            <s:if test="queryWay==null">
            <s:radio list="#{'用户编号':'用户编号','用户名':'用户名'}" name="queryWay" value="'用户编号'" cssStyle="width:50px;"   />
            </s:if>
            <s:else>
            <s:radio list="#{'用户编号':'用户编号','用户名':'用户名'}" name="queryWay" cssStyle="width:50px;"   />
            </s:else>
        </div>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}system/user_addUI.action" class="add">添加</a>
    <a href="javascript:deleteItem()" class="del">删除</a>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="16%" class="num">用户编号</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="15%" >用户名称</th>
				<th width="15%" >所属机构</th>
				<th width="8%" align="center">联系人电话</th>
				<th width="8%" >用户类型</th>
				<th width="8%" align="center">性别</th>
				<th width="8%" >状态</th>
				<th width="5%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="user">
        	<tr>
			 <td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#user.userId'/>' /></td>
            	<td><a href="${basePath}system/user_detailUI.action?user.userId=<s:property value='#user.userId'/>"><s:property value="#user.employNo"/></a></td>
				<td ><s:property value="#user.employName"/></td>
				<td><s:property value="#user.organization.orgName"/></td>
				<td><s:property value="#user.tell"/></td>
				<td><s:property value="#user.userType"/></td>
				<td><s:property value="#user.sex? '男':'女'"/></td>
				<td><s:property value="#user.status? '激活':'关闭' "/></td>
				<td><a href="${basePath}system/user_editorUI.action?user.userId=<s:property value='#user.userId'/>"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>

<!--  <script type="text/javascript">
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
}
function query(){	
	var $radio=$("input[type=radio]:checked");
 	var $condition=$("#condition");
 	if($radio.val()=="用户编号"){
 		$condition.attr("name","user.employNo"); 		
 	}else{
 		$condition.attr("name","user.employName"); 			
 	}
 	//--------------提交信息------------------
  	$("#pageNo").val(1);

  	$("#queryForm").attr("action",queryAction);
 	$("#queryForm").submit(); 
	
}
/**
 * 删除信息
 */
function delete(){
	var $form=$("#queryForm");
	$form.attr("action",deleteAction);
 	$("#queryForm").submit(); 
}
</script>  -->
</body>