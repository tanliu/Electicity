
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<script type="text/javascript" >
<!-- action之间的跳转 ，用于换页-->
var queryAction="${basePath}loanscholarship/loanscholarship_listUI.action";
var deleteAction="${basePath}loanscholarship/loanscholarship_delete.action";
var importUrl="${basePath}loanscholarship/loanscholarship_importExcel.action";
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
<title>助学贷款信息管理</title>
</head>

<body>
<div class="title"><h2>助学贷款信息管理</h2></div>
<!-- 跳转页面时表单提交数据，换页显示数据 -->
 <form id="queryForm" action="${basePath}system/user_listUI.action" method="post">
<div class="query">
	<div class="query-conditions ue-clear" style="width:100%">
        <div class="conditions staff ue-clear" style="width:25%">
            <label>姓名：</label>
        <input type="text" name="loanscholarship.stuName" placeholder="请输入姓名进行查询" value="${querycon.stuName}" style="width:200px;height:30px"/>
        </div>
        
      <div class="conditions staff ue-clear" style="width:25%">
            <label>学号：</label>
        <input type="text" name="loanscholarship.studentNo" placeholder="请输入姓名进行查询" value="${querycon.studentNo}" style="width:200px;height:30px"/>
        </div>
  
  <div class="conditions name ue-clear" style="width:25%">
         <label>是否通过：</label>
        <input  hidden="hidden"  value="${querycon.censoredFlag}" name="loanscholarship.censoredFlag" style="width:200px;height:30px">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span>${querycon.censoredFlag}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="是">是</li>
                <li id="否">否</li>
                
            </ul>
        </div>
  </div>
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:query()" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a:if url="/loanscholarship/loanscholarship_add.action"><a href="javascript:add()" class="add">添加</a></a:if>
    <a:if url="/loanscholarship/loanscholarship_delete.action"><a href="javascript:del()" class="del confirm save">删除</a></a:if>
    <a:if url="/loanscholarship/loanscholarship_importExcel.action"><a href="javascript:;" class="import clear clear">导入</a></a:if>
<!--     <a href="javascript:;" class="upload">上传</a> -->
</div>

<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <a:if url="/loanscholarship/loanscholarship_editor.action"><th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th></a:if>
            	 <th width="5%" >姓名</th>
            	 <th width="15%" class="num">学号</th>
            	 <th width="10%">身份证号</th>
				<th width="10%" >学院</th>
				<th width="10%">专业</th>
				<th width="10%">贷款金额</th>
				 <th width="15%">是否通过审核</th>
				<th width="15%" >备注</th>
				 <a:if url="/loanscholarship/loanscholarship_editor.action"><th width="10%">编辑</th></a:if>			
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="loanscholarship">
        	<tr>
			 <a:if url="/loanscholarship/loanscholarship_editor.action"><td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#loanscholarship.id'/>'/></td></a:if>
              	<td ><s:property value="#loanscholarship.stuName"/></td>
              	<td><s:property value="#loanscholarship.studentNo"/></td>
              	<td><s:property value="#loanscholarship.idCardNo"/></td>
				<td><s:property value="#loanscholarship.orgName"/></td>
				<td><s:property value="#loanscholarship.major"/></td>
				<td><s:property value="#loanscholarship.loanAmount"/></td>
				<td><s:property value="#loanscholarship.censoredFlag"/></td>
				<td><s:property value="#loanscholarship.memo"/></td>
				<!-- 跳转到editor对应的action。并将对应的查询条件数据传到action -->
				 <a:if url="/loanscholarship/loanscholarship_editor.action"><td><a href="javascript:editor('<s:property value='#loanscholarship.id'/>')"><img src="../images/edtico.png"/></a></td></a:if>
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

<script type="text/javascript">

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
       	window.open("${basePath}loanscholarship/loanscholarship_detailUI.action?loanscholarship.id="+$id);
        });
        
        
        
        //点击改变选中样式
        $('tbody>tr').click(function() {
            $(this)
                    .addClass('selected')
                    .siblings().removeClass('selected')
                    .end();
        });
	})
	//向couscholarship_editorUI.action提交信息
function editor(id){
		var url="${basePath}loanscholarship/loanscholarship_editorUI.action?loanscholarship.id="+id;
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向couscholarship_addUI.action提交信息
function add(){
		var url="${basePath}loanscholarship/loanscholarship_addUI.action";
		$("#queryForm").attr("action",url);
 	$("#queryForm").submit();  
} 

//向couscholarship_listUI.action提交信息
function query(){
	 	$("#pageNo").val(1);
	  	$("#queryForm").attr("action",queryAction);
	 	$("#queryForm").submit(); 
	}
//向couscholarship_delete().action提交信息
function del(){
	$('.delDialog').Dialog('open'); 
} 
 </script>
</html>

 
