<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<!-- 行之间的显示效果与选中行的效果 -->
<style type="text/css">
        .even{ background:#FFF;color:#000;}  /* 偶数行样式*/
        .odd{ background:#eff6fa;color:#000;}  /* 奇数行样式*/
        .selected{background:#DDDDDD;color:#003333} /*选中行样式*/

		table tbody tr td{text-align: center;}
		table thead tr th{text-align: center;}
</style>
<script type="text/javascript">
	    var queryAction="${basePath}subjectcontest/subjectcontest_listUI.action";
		var deleteAction="${basePath}subjectcontest/subjectcontest_delete.action";
		var downloadAction="${basePath}subjectcontest/subjectcontest_exportExcel.action";
		function query(){
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
	 	function downloadItem(){
	 		$("#queryForm").attr("action",downloadAction);
		 	$("#queryForm").submit();  
		} 
 	
	    //字符格式装换，去掉&nbsp和冒号
	    function  formalString(s){
		    var reg=/&nbsp;/g;
		    s = s.replace(reg,"");
		    s=s.replace("：","");
		    return s;
	    }
  		
	    $(function(){
	    	 $("tr:odd").addClass("odd");  /* 奇数行添加样式*/
			    $("tr:even").addClass("even"); /* 偶数行添加样式*/
			
			    //隐藏div
			    $('#jiangliName_div').hide();
			    $('#jiangliOrganization_div').hide();
			    $('#guideTeacher_div').hide();
			    
			  	//双击跳转到详情页面
			  	$('tbody>tr').dblclick(function() {
			  		var sid=$(this).find('td').find("#subid").val();
			  		var url="${basePath}subjectcontest/subjectcontest_detailUI.action?subjectcontest.id="+sid;
			  		window.open(url);
			  		//window.location.href="${basePath}subjectcontest/subjectcontest_detailUI.action?subjectcontest.id="+sid;	
	
		    	});	
				//点击改变选中样式
			    $('tbody>tr').click(function() {
				    $(this).addClass('selected').siblings().removeClass('selected').end();
			    });
				
			    //选择筛选条件
			    $('.select-list>li').click(function(){
			     	switch($(this).text()){
				     case formalString($('#jiangliName').html()):
					     $('#jiangliName_div').show();
					     $('#jiangliOrganization_div').hide();
					     $('#guideTeacher_div').hide();
				     	break;
				     case  formalString($('#jiangliOrganization').html()):
					     $('#jiangliName_div').hide();
					     $('#jiangliOrganization_div').show();
					     $('#guideTeacher_div').hide();
				     	break;
				     case  formalString($('#guideTeacher').html()):
					     $('#jiangliName_div').hide();
					     $('#jiangliOrganization_div').hide();
					     $('#guideTeacher_div').show();
					     break;
				     default:
				     }
				});
	    });
	    
</script>
	<title>学生电子档案管理系统</title>
</head>

<body>
	<div class="title">
		<h2>学科竞赛信息管理</h2>
	</div>
	<form id="queryForm"
		action="${basePath}subjectcontest/subjectcontest_listUI.action"
		method="post">
		<input hidden="hidden" name="subjectcontest.id" value="#subjectcontest.id"/>
		<div class="query">
			<div class="query-conditions ue-clear">
				<div class="conditions name ue-clear">
					<label>筛选条件：</label>
					<div class="select-wrap">
						<div class="select-title ue-clear">
							<span>请选择</span><i class="icon"></i>
						</div>
						<ul class="select-list">
							<li>奖励名称</li>
							<li>授予单位</li>
							<li>指导老师</li>
						</ul>
					</div>
				</div>

				<div class="conditions staff ue-clear">
					<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label> <input
						type="text" placeholder="可以直接输入或选择" name="subjectcontest.studentNo" value="${querycon.studentNo}" />
				</div>

				<div class="conditions staff ue-clear">
					<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label> <input
						type="text" placeholder="可以直接输入或选择" name="subjectcontest.stuName" value="${querycon.stuName}"/>
				</div>
			
			
				<div class="conditions staff ue-clear" id="jiangliName_div">
					<label id="jiangliName">奖励名称：</label> <input type="text"
						placeholder="可以直接输入或选择" name="con_name" />
				</div>

				<div class="conditions staff ue-clear" id="jiangliOrganization_div">
					<label id="jiangliOrganization">授予单位：</label> <input type="text"
						placeholder="可以直接输入或选择" name="con_organization" />
				</div>
				<div class="conditions staff ue-clear" id="guideTeacher_div">
					<label id="guideTeacher">指导老师：</label> <input type="text"
						placeholder="可以直接输入或选择" name="guideTeacher" />
				</div>
			</div>
			<div class="query-btn ue-clear">
					<a href="javascript:query()" class="confirm">查询</a>
				</div>
		</div>
		<div class="table-operate ue-clear">
			<a href="${basePath}subjectcontest/subjectcontest_addUI.action" class="add">添加</a>
			<a href="javascript:deleteItem()" class="del">删除</a> 
			<a href="javascript:;" class="import">导入</a>
    		<a href="javascript:;" class="upload">上传</a>
    		<a href="javascript:downloadItem()" class="del">下载</a>
    		
		</div>
		<div class="table-box">
			<table>
				<thead>
					<tr>
						<th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
						<th width="3%">序号</th>
						<th width="8%">学号</th>
						<th width="6%">获奖者姓名</th>
						<th width="8%">奖励名称</th>
						<th width="4%" align="center">获奖级别</th>
						<th width="4%" align="center">获奖等级</th>
						<th width="10%">授予单位</th>
						<th width="8%">获奖项目</th>
						<th width="6%">指导老师</th>
						<th width="8%">获奖时间</th>
						<th width="8%">备注</th>
						<th width="5%">编辑</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pageUtils.items" var="subjectcontest">
						<tr>
							<td><input type="checkbox" name="selectedRow" id="subid"
								value='<s:property value='#subjectcontest.id'/>' /></td>
							<td class="num">1</td>
							<td><s:property value="#subjectcontest.studentNo" /></td>
							<td><s:property value="#subjectcontest.stuName" /></td>
							<td><s:property value="#subjectcontest.rewardName" /></td>
							<td><s:property value="#subjectcontest.rewardLevel" /></td>
							<td><s:property value="#subjectcontest.rewardGrade" /></td>
							<td><s:property value="#subjectcontest.grantUnits" /></td>
							<td><s:property value="#subjectcontest.rewardProject" /></td>
							<td><s:property value="#subjectcontest.guidTeacher" /></td>
							<td><s:date name="#subjectcontest.rewardDate" format="yyyy-MM-dd"></s:date></td>
							<td><s:property value="#subjectcontest.memo" /></td>
							<td><a href="${basePath}subjectcontest/subjectcontest_editorUI.action?subjectcontest.id=<s:property value='#subjectcontest.id'/>">
								<img src="../images/edtico.png" /></a></td>
						</tr>
						
					</s:iterator>
				</tbody>
			</table>
		</div>
		<jsp:include page="/common/pagination.jsp"></jsp:include>
	</form>
	
<div class="importDialog" align="center" >
	<div class="dialog-content" align="center">   
        <div class="ui-dialog-text" align="center">
            <p class="dialog-content">请选择要导入的excel文件</p>
            <form id="fileForm" action="${basePath}subjectcontest/subjectcontest_importExcel.action" method="post" enctype="multipart/form-data">
            <p><input style="margin-left:30px; margin-top:5px;margin-bottom:10px;outline:0;" type="file"  name="excel"  /></p>
          </form>
            <div class="buttons" align="center">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="返回" />
            </div>
        </div>
       </div>
</div>
</body>

<script type="text/javascript">
<!--实现清空弹出框的脚本-->

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
		var $form=$("#fileForm");
		$("#fileForm").submit();
	}
});
</script>
</html>