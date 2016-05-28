<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="../css/info-mgt.css" />
<link rel="stylesheet" href="../css/WdatePicker.css" />
<script src="../js/jquery.js"></script>
 <script type="text/javascript" >
	$(function(){
		$('.checkall').change(function()
		{
		$(this).parents('table:first')
				.find('input')
				.attr('checked',$(this).is(':checked')); 
		});
	})
 </script>
<title>学生党团关系信息管理</title>
</head>
<body>
<div class="title"><h2>学生党团关系信息管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>筛选条件：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>年级</span><i class="icon"></i></div>
                <ul class="select-list">
					<li>年级</li>
					<li>学院</li>
                    <li>班级</li>
                    <li>姓名</li>
                    <li>性别</li>
                </ul>
            </div>
        </div>
       
        <div class="conditions name ue-clear">
            <label>年级：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>2013级</span><i class="icon"></i></div>
                <ul class="select-list">
					<li>2012级</li>
                    <li>2013级</li>
                    <li>2014级</li>
                    <li>2015级</li>
                </ul>
            </div>
        </div>
		<div class="conditions name ue-clear">
            <label>学院：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>计算机学院</span><i class="icon"></i></div>
                <ul class="select-list">
					<li>计算机学院</li>
                    <li>信息学院</li>
                    <li>外语学院</li>
                    <li>机车学院</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="job_addUI.html" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
    <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
			 <th><input type="checkbox" class="checkall"/></th>
             <th >姓名</th>
            	<th >学号</th>
                
                <th>入党日期</th>
                <th >政治面貌</th>
                
                <th>备注</th>
				<th class="detail">编辑</th>
            </tr>
        </thead>
        <tbody>
        	<tr>
			 <td><input type="checkbox" /></td>
             <td >罗兰</td>
            	<td >130202061099</td>
                
               
                <td >19940505</td>
                 <td >党员</td>
                <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
            <tr>
			<td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
               
                <td >19940505</td>
                 <td >党员</td>
                  <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
            <tr>
			<td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
                <td >19940505</td>
                 <td >党员</td>
               <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
            <tr>
			<td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
               
                <td >19940505</td>
                 <td >党员</td>
                <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
            <tr>
			 <td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
               
                <td >19940505</td>
                 <td >党员</td>
                <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
            <tr>
			<td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
               
                <td >19940505</td>
                 <td >党员</td>
               <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            <tr>
			<td><input type="checkbox" /></td>
            	 <td >罗兰</td>
            	<td >130202061099</td>
               
                <td >19940505</td>
                 <td >党员</td>
                <td style="width:400px" nowrap=true>备注</td>
				
				<td class="detail"><a href="job_editorUI.html"><img src="../images/edtico.png"/></a></td>
            </tr>
          
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})



$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>