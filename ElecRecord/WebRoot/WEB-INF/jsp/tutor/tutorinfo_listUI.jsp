
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>

<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />

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



//以下路径用于访问Action
var queryAction="${basePath}tutor/tutor_listUI.action";

//向stustatus_listUI.action提交信息
function query(){
	    $("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}

 </script>
<title>辅导信息</title>
</head>

<body>
<div class="title"><h2>辅导信息</h2></div>
<form id="queryForm"  action="${basePath}tutor/tutor_listUI.action" method="get">
<div class="query">

	<div class="query-conditions ue-clear" style="width:100%">                  
	                                          
       <div class="conditions staff ue-clear" style="width:25%">
            <label>学号：</label>
            <input type="text" placeholder="请输入学生学号进行查询" name="tutor.studentNo" value="${queryCon.studentNo}" style="width:233px;height:30px" />
        </div>
        
         <div class="conditions staff ue-clear" style="width:25%">
            <label>姓名：</label>
            <input type="text" placeholder="请输入学生姓名进行查询" name="tutor.stuName" value="${queryCon.stuName}" style="width:233px;height:30px"/>
            
        </div>
        
            
         <div class="conditions staff ue-clear" >
            <label>辅导时间：</label>
            <input type="text" value="<s:date format="yyyy-MM-dd" name="tutor.guidDate"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="tutor.guidDate" style="width:233px;height:30px"/>
            
        </div>
       
       
        
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>

<div class="table-operate ue-clear">
	<a href="javascript:" class="add">添加</a>
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
				<th width="15%" >辅导时间</th>
				<th width="15%" align="center">辅导地点</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="tutors">
        	<tr>
			<td class="num" ><input  type="checkbox" name="selectedRow" value='<s:property value='#tutors.id'/>'/></td>
            	<td><s:property value="#tutors.studentNo"/></td>
				<td ><s:property value="#tutors.stuName"/></td>
				<td><s:property value="#tutors.className"/></td>
				<td><s:date format="yyyy-MM-dd HH:mm:ss" name="#tutors.guidDate"/></td>
				<td><s:property value="#tutors.guidAddress"/></td>
				<td><a href=""><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
    
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>



</body>


</html>