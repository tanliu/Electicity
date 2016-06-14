
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<script type="text/javascript" >
<!-- action之间的跳转 ，用于换页-->
var queryAction="${basePath}train/trainmaster_listUI.action";
var deleteAction="${basePath}train/trainmaster_delete.action";
var importUrl="${basePath}train/trainmaster_importExcel.action";
</script>

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
<title>学生干部培训信息</title>
</head>

<body>
<div class="title"><h2>学生干部培训信息</h2></div>
<!-- 跳转页面时表单提交数据，换页显示数据 -->
 <form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear" style="width:100%">
       <div class="conditions staff ue-clear" style="width:25%" >
          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主题：</label>
        <input type="text" name="traininfoMaster.trainsTopic" placeholder="请输入主题进行查询" value="${querycon.trainsTopic}" style="width:200px;height:30px"/>
    </div>
        
         <div class="conditions staff ue-clear" style="width:25%">
          <label>&nbsp;&nbsp;&nbsp;负责人：</label>
        <input type="text" name="traininfoMaster.manager" placeholder="请输入负责人进行查询" value="${querycon.manager}" style="width:200px;height:30px"/>
    </div>

<div class="conditions staff ue-clear" style="width:25%">
            <label>&nbsp;&nbsp;培训日期：</label>
             <div class="select-wrap" >
            <input type="text" value="<s:date format="yyyy-MM-dd" name="traininfoMaster.trainsDate"/>" placeholder="请输入日期进行查询" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="traininfoMaster.trainsDate" style="width:200px;height:30px"/>
            </div>
        </div>
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="javascript:add()" class="add">添加</a>
    <a href="javascript:del()" class="del confirm save">删除</a>
    <a href="javascript:;" class="import clear clear">导入</a>
<!--     <a href="javascript:;" class="upload">上传</a> -->
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="20%" >主题</th>
            	 <th width="10%" >负责人</th>
				<th width="10%" >地点</th>
				<th width="20%" align="center">日期</th>
				<th width="10%" align="center">培训年级</th>
				<th width="20%" >备注</th>
				<th width="10%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="traininfoMaster">
        	<tr>
			<td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#traininfoMaster.id'/>'/></td>
              	<td><s:property value="#traininfoMaster.trainsTopic"/></td>
				<td ><s:property value="#traininfoMaster.manager"/></td>
				
				<td><s:property value="#traininfoMaster.trainsAddress"/></td>
				<td><s:date name="#traininfoMaster.trainsDate" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
				<td><s:property value="#traininfoMaster.trainsGrade"/></td>
				<td><s:property value="#traininfoMaster.memo"/></td>
				<!-- 跳转到editor对应的action。并将对应的查询条件数据传到action -->
				<td><a href="javascript:editor('<s:property value='#traininfoMaster.id'/>')"><img src="../images/edtico.png"/></a></td>
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

<script type="text/javascript" >

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
       	 var $id=$(this).children("td").children("input").val();
       	//跳转到详情页
       	window.open("${basePath}train/trainmaster_detailUI.action?traininfoMaster.id="+$id);
        });
        
        
        
        //点击改变选中样式
        $('tbody>tr').click(function() {
            $(this)
                    .addClass('selected')
                    .siblings().removeClass('selected')
                    .end();
        });
	})
	//向trainmaster_editorUI.action提交信息
function editor(id){
		var url="${basePath}train/trainmaster_editorUI.action?traininfoMaster.id="+id;
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向trainmaster_addUI.action提交信息
function add(){
		var url="${basePath}train/trainmaster_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向trainmaster_listUI.action提交信息
function query(){
	 	$("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
//向trainmaster_delete().action提交信息
function del(){
	$('.delDialog').Dialog('open');
} 
 </script>
</html>

 
