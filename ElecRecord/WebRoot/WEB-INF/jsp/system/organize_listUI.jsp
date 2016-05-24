<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加部门信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<title>添加部门</title>
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>
</head>



<body>
<div class="title"><h2>机构信息列表</h2></div>
<form id="queryFrom" action="${basePath}system/organize_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
            <label>机构名称：</label>
            <s:textfield id="condition" name="organize.orgName"></s:textfield>
        </div>
    </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
        <a href="javascript:;" class="clear">查询部门下的所有部门</a> 
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}system/organize_addUI.action" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="16%" class="num">机构名称</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="15%" >详细地址</th>
				<th width="15%" >E_mail地址</th>
				<th width="8%" >邮编</th>
				<th width="8%" align="center">传真</th>
				<th width="8%" align="center">联系人</th>
				<th width="8%" align="center">联系人电话</th>
				<th width="8%" >状态</th>
				<th width="5%">操作</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="org">
        	<tr>
			 <td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#org.orgId'/>' /></td>
            	<td><s:property value="#org.orgName"/></td>
				<td ><s:property value="#org.address"/></td>
				<td><s:property value="#org.email"/></td>
				<td><s:property value="#org.postCode"/></td>
				<td><s:property value="#org.fax"/></td>
				<td><s:property value="#org.contactMan"/></td>
				<td><s:property value="#org.tell"/></td>
				<td><s:property value="#org.state"/></td>

				<td><a href="${basePath}system/organize_editorUI.action?organize.orgId=<s:property value='#org.orgId'/>"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>

<div class="pagination ue-clear">
<s:if test="pageUtils.items!=null">

<div class="goto"><span class="text">转到第</span><input  id="pageNo" type="text" value="${pageUtils.pageNo}" name="pageNO"><span class="page">页</span><a href="javascript:doGoPage()">转</a></div>
<div class="pagin-list" >
<!------------------------------ 当前页是第一页----------------------------------------->
<s:if test="1==pageUtils.pageNo">
<a class="current prev">&lt;&nbsp;上一页</a>
</s:if>
<s:else>
<a class="prev"  href="javascript:doNextorPrev('<s:property value="pageUtils.pageNo-1"/> ')">&lt;&nbsp;上一页</a>
</s:else>
<!------------------------------ 打印页码 ----------------------------------------->
<s:iterator  var="num" begin="1" end="pageUtils.totalPageCount">
<s:if test="#num==pageUtils.pageNo">
<span class="current">${num}</span>
</s:if>
<s:else>
<a href="javascript:doNextorPrev('${num}');">${num}</a>
</s:else>
</s:iterator>

<!------------------------------ 当前页是第一页----------------------------------------->
<s:if test="pageUtils.totalPageCount==pageUtils.pageNo">
<a class="current next" href="javascript:;">下一页&nbsp;&gt;</a>
</s:if>
<s:else>
<a class="next" href="javascript:doNextorPrev('<s:property value="pageUtils.pageNo+1"/> ')">下一页&nbsp;&gt;</a>
</s:else>

</div>
<div class="pxofy">显示第${(pageUtils.pageNo-1)*pageUtils.pageSize}条到&nbsp;${pageUtils.pageNo*pageUtils.pageSize}&nbsp;条记录，总共&nbsp;${pageUtils.totalCount}&nbsp;条</div>
</s:if>
<s:else>
<div class="pxofy">暂没有数据！！！！</div>
</s:else>
</div>
</form>
<script type="text/javascript">
function doNextorPrev(pageNO){
	$(".goto input").val(pageNO);
	doGoPage();
}
function doGoPage(){
    $("#queryFrom").submit();
}

</script>

<script type="text/javascript">
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
}
function query(){
/*  	var txt=$("#condition").val();
	var path=$("#queryFrom").attr("action")+"?"+"organize.orgName="+txt; 
 	alert(path); */
 	$("#pageNo").val(1);
 	$("#queryFrom").submit();
	
}
</script>

</body>
