
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
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


<script type="text/javascript" >
//选择框效果的JS
function doSelectAll(){
	$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
} 


//实现选中行的效果
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

//以下两条路径用于访问Action
var queryAction="${basePath}stustatus/stustatus_listUI.action";
var deleteAction="${basePath}stustatus/stustatus_delete.action";

//进入编辑页面的路径
function editor(id){
		var url="${basePath}stustatus/stustatus_editorUI.action?stuStatus.id="+id;
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

 </script>
<title>学生学籍异动信息</title>
</head>

<body>
<div class="title"><h2>学生学籍异动信息</h2></div>
<form id="queryForm" action="${basePath}stustatus/stustatus_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
           <label>学年：</label>
        <input  hidden="hidden" value="" name="stuStatus.academicYear">
      <div class="select-wrap">
				<div class="select-title ue-clear" ><span id="span1">请选择</span><i class="icon"></i></div>
					<ul class="select-list" >
					 <li id="">请选择</li>
					    <s:iterator value="#request.years" var="years">
					      <li id="<s:property value='#years.ddlName'/>"><s:property value="#years.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
        </div>
        
         <div class="conditions staff ue-clear">
            <label>学号：</label>
            <input type="text" placeholder="请输入学生学号进行查询" style="width:223px"/>
        </div>
        
        <div class="conditions name ue-clear">
            <label>学期：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>请选择</span><i class="icon"></i></div>
                <ul class="select-list">
                <li id="">请选择</li>
                    <li id="1">1</li>
                    <li id="2">2</li>
                </ul>
            </div>
            
        </div>
       
       
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="${basePath}stustatus/stustatus_addUI.action" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
    
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="20%" class="num">学号</th>
                <th width="10%" >姓名</th>
				<th width="5%" >性别</th>
				<th width="20%" align="center">身份证号</th>
				<th width="20%" >考生号</th>
				<th width="10%" align="center">学生类别</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="stustatus">
        	<tr>
			<td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#stustatus.id'/>'/></td>
            	<td><a href="javascript:detail('<s:property value='#stustatus.id'/>')"><s:property value="#stustatus.studentNo"/></a></td>
				<td ><s:property value="#stustatus.stuName"/></td>
				<td><s:property value="#stustatus.sex"/></td>
				<td><s:property value="#stustatus.idCardNo"/></td>
				<td><s:property value="#stustatus.examinateNo"/></td>
				<td><s:property value="#stustatus.studentCategory"/></td>
				<td><a href="javascript:editor('<s:property value='#stustatus.id'/>')"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>

<jsp:include page="/common/pagination.jsp"></jsp:include>

</form>
</body>


</html>
