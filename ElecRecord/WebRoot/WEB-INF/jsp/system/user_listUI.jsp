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

	var queryAction="${basePath}system/user_listUI.action";
	var deleteAction="${basePath}system/user_delete.action";
	function query(){
		/* alert("--------------------"); */
		/* var $radio=$("input[type=radio]:checked"); */
/* 	 	var $condition=$("#condition");
	 	if($radio.val()=="用户编号"){
	 		$condition.attr("name","user.employNo"); 		
	 	}else{
	 		$condition.attr("name","user.employName"); 			
	 	} */
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
 		var url="${basePath}system/user_editorUI.action?user.userId="+id;
 		$("#queryForm").attr("action",url);
	 	$("#queryForm").submit();  
	} 
 	function detail(id){
 		var url="${basePath}system/user_detailUI.action?user.userId="+id;
 		
 		window.open(url) ; //打开窗口
 	}
 	function transform(id){
 		var url="${basePath}system/user_transform.action?user.userId="+id;
 		//alert(url);
 		$.ajax({
	        url:url,
	    	type:"post",
	    	//dataType:"json",//返回数据类型
	    	success: function(data){
	    		//data为0时表示数据库中已经存在数据了
	    		
	    		if(data=="0"){
	    			
	    			
	    			$("#"+id).text("注销");
	    		}else if(data=="1"){
	    			$("#"+id).text("激活");
	    			
	    		}
	    	},
	        error:function(){

	        }
	    
	    }); 
 	}
</script>

</head>



<body>
<div class="title"><h2>用户信息列表</h2></div>
<form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions staff ue-clear">
           <a:if url="/system/user_listUI.action"> <label>查询条件：</label></a:if>
            <!-- 如果employNo的值是空时，表示上一页的查询条件是以用户的方式查询 -->
            <s:textfield id="condition" name="querycon"></s:textfield>            

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
   <a:if url="system/user_add.action">	<a href="${basePath}system/user_addUI.action" class="add">添加</a></a:if>
<!--     <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a> -->
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			<a:if url="system/user_editor.action"> <th  width="5%"> <input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
            	<th width="16%" class="num">用户编号</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="15%" >用户名称</th>
				<th width="15%" >所属机构</th>
				<th width="15%" align="center">联系人电话</th>
				<th width="15%" >用户类型</th>
				<th width="8%" align="center">性别</th>
				<a:if url="system/user_editor.action"><th width="8%" >状态</th>
				<th width="5%">编辑</th>	</a:if>			
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="user">
        	<tr>
			 
			 <a:if url="system/user_editor.action"><th class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#user.userId'/>' /></th></a:if>
            	<td><a href="javascript:detail('<s:property value='#user.userId'/>')"><s:property value="#user.employNo"/></a></td>
				<td ><s:property value="#user.employName"/></td>
				<td><s:property value="#user.organization.orgName"/></td>
				<td><s:property value="#user.tell"/></td>
				<td><s:property value="#user.userType"/></td>
				<td><s:property value="#user.sex? '男':'女'"/></td>
				<a:if url="system/user_editor.action"><td  ><a id="<s:property value='#user.userId'/>" href="javascript:transform('<s:property value='#user.userId'/>')"><s:property value="#user.status? '激活':'注销' "/></a></td>
				<td><a href="javascript:editor('<s:property value='#user.userId'/>')"><img src="../images/edtico.png"/></a></td>
                </a:if>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
</body>
