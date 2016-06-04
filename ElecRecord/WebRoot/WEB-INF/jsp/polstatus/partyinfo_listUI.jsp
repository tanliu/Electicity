
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
	<div class="query-conditions ue-clear" style="width:100%">
        <div class="conditions name ue-clear" style="width:25%">
            <label>姓名：</label>
        <input type="text" name="politicalstatus.stuName" placeholder="请输入姓名进行查询" value="${querycon.stuName}" />
        </div>
        
         <div class="conditions name ue-clear" style="width:25%">
          <label>学号：</label>
        <input type="text" name="politicalstatus.studentNo" placeholder="请输入学号进行查询" value="${querycon.studentNo}" />
    </div>
     <div class="conditions name ue-clear" style="width:30%">
         <label>入党日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" placeholder="请选择日期进行查询" name="politicalstatus.joinDate" value="<s:date name="querycon.joinDate" format="yyyy-MM-dd"></s:date>"/>
        </div>
  </div>
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="javascript:add()" class="add">添加</a>
    <a href="javascript:del();" class="del">删除</a>
    <a href="javascript:;" class="import clear clear">导入</a>
<!--     <a href="javascript:;" class="upload">上传</a> -->
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
			<td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#political.id'/>'/></td>
              	<td><s:property value="#political.studentNo"/></td>
				<td ><s:property value="#political.stuName"/></td>
				<td><s:date name="#political.joinDate" format="yyyy-MM-dd"></s:date></td>
				<td><s:property value="#political.politicalStatus"/></td>
				<td><s:property value="#political.memo"/></td>
				<!-- 跳转到editor对应的action。并将对应的查询条件数据传到action -->
				<td><a href="javascript:editor('<s:property value='#political.id'/>')"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>        
        </tbody>
    </table>
    
</div>
<!-- 跳转页面  页码    （将这语句置于form表单之内  才能提交页码）-->
<jsp:include page="/common/pagination.jsp"></jsp:include>
</form>

<div class="importDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center">
            <p class="dialog-content">请选择要导入的excel文件</p>
<!--          上传表格文件工具   enctype="multipart/form-data"  name必须等于"excel"-->
            <form  id="fileForm" action="${basePath}polstatus/polstatus_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel" value="" id="filename"/></p>
          </form>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok"  value="确定" />
                <input type="button" class="button long2 normal" value="取消 " />
            </div>
        </div>
        </div>
</div>
</body>

<script type="text/javascript">

<!--实现上传文件弹出框的脚本-->

$('.importDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:250,
	height:220
	
});

$('.import').click(function(){
	$('.importDialog').Dialog('open');
});



$('.importDialog input[type=button]').click(function(e) {
    $('.importDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		//判断是否有选择文件
		if(document.getElementById("filename").value){//在文件非空的条件下才允许向后台提交请求
			$("#fileForm").submit();
		}
		else{
			//alert('未选择文件!!!!');
			$('.importDialog').Dialog('open');//如果用户未选择任何文件，那么窗口保持打开状态
		}
	}
	
});




</script>
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
		var url="${basePath}polstatus/polstatus_delete.action";
		$("#queryForm").attr("action",url);
 		$("#queryForm").submit();  
} 
 </script>
</html>

 
