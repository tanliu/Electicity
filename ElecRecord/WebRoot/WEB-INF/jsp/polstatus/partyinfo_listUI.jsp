
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
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
<title>学生党团关系信息</title>
</head>

<body>
<div class="title"><h2>学生党团关系信息</h2></div>
<!-- 跳转页面时表单提交数据，换页显示数据 -->
 <form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>姓名：</label>
        <input type="text" name="politicalstatus.stuName" placeholder="请输入姓名进行查询" value="${politicalstatus.stuName}" />
        </div>
        
         <div class="conditions staff ue-clear" >
          <label>学号：</label>
        <input type="text" name="politicalstatus.studentNo" placeholder="请输入学号进行查询" value="${politicalstatus.studentNo}"/>
    </div>
     <div class="conditions staff ue-clear" >
         <label>入党日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" placeholder="请选择日期进行查询" name="politicalstatus.joinDate" value="<s:date name="politicalstatus.joinDate" format="yyyy-MM-dd"></s:date>"/>
        </div>
  </div>
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="${basePath}polstatus/polstatus_addUI.action" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="20%" class="num">学号</th>
            	 <th width="15%" >姓名</th>
				<th width="15%" >入党日期</th>
				<th width="10%" align="center">政治面貌</th>
				<th width="30%" >备注</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="political">
        	<tr>
			 <td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#'/>' /></td>
              	<td><a href="javascript:detail('<s:property value='#political.id'/>')"><s:property value="#political.studentNo"/></a></td>
				<td ><s:property value="#political.stuName"/></td>
				<td><s:date name="#political.joinDate" format="yyyy-MM-dd"></s:date></td>
				<td><s:property value="#political.politicalStatus"/></td>
				<td><s:property value="#political.memo"/></td>
				<!-- 跳转到editor对应的action。并将对应的查询条件数据传到action -->
				<td><a href="${basePath}polstatus/polstatus_editorUI.action?politicalstatus.id=<s:property value='#political.id'/>"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>        
        </tbody>
    </table>
    
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>
</body>
</html>
<script type="text/javascript" >
<!-- action之间的跳转 ，用于换页-->
var queryAction="${basePath}polstatus/polstatus_listUI.action";
var deleteAction="${basePath}polstatus/polstatus_delete.action";
/* 批量选中*/
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
} 
	$(function(){
      
        $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
        $("tr:even").addClass("even"); /* 偶数行添加样式*/

       
        //双击跳转到详情页面
        $('tbody>tr').dblclick(function() {
            window.open('.....html');
        });
        //点击改变选中样式
        $('tbody>tr').click(function() {
            $(this)
                    .addClass('selected')
                    .siblings().removeClass('selected')
                    .end();
        });
	})
	
	//查询数据时向listUI提交查询条件
	function query(){
		
	 	//--------------提交信息------------------
	  	$("#pageNo").val(1);

	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
 </script>
 <script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
