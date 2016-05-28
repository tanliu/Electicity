<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

<title>学籍异动信息修改</title>
</head>

<body>

<div class="title"><h2>学籍异动信息修改</h2></div>
<form id="myForm">
<div class="main">

	<fieldset >
    <legend>学生信息</legend>
     
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" /> 
        <label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" /> 
       
    </p>
    
  
    <div class="short-input select ue-clear" >
   
    	<label>性别：</label>
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >男</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>男</li>
                <li>女</li>
            </ul>
     
        </div>
    </div>
    <p class="short-input ue-clear">
      <label>身份证号：</label>
      <input type="text" placeholder="请输入学生身份证号" /> 
       <label>考生号：</label>
        <input type="text" placeholder="请输入学生考生号" /> 
       
      </p>
      <p class="short-input ue-clear">
    	<label>学生类别：</label>
        <input type="text" placeholder="请输入学生类别" /> 
        <label>学年：</label>
      <input type="text" placeholder="请输入学年" /> 
   
    </p>
  
      <div class="short-input select ue-clear" >
    	<label>学期：</label>
        <div class="select-wrap" >
        	<div class="select-title " ><span >1</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>1</li>
                <li>2</li>
         
            </ul>
        </div>
       
    </div>
    
     
     </fieldset>
     <fieldset>
     <legend>异动信息</legend>
      <p class="short-input ue-clear">
    	<label>异动序号：</label>
      <input type="text" placeholder="请输入处理文号" /> 
       <label>异动结果：</label>
      <input type="text" placeholder="请输入异动结果" />
    </p>
    <p class="short-input ue-clear">
    	<label>异动类别：</label>
        <input type="text" placeholder="请输入异动类别" />
        <label>异动原因：</label>
        <input type="text" placeholder="请输入异动原因" />
    </p>
     <p class="short-input ue-clear">
    	<label>异动时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
        <label>行文时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
    </p>
    <p class="short-input ue-clear">
    	<label>撤消时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
        <label>异动说明：</label>
        <input type="text" placeholder="异动说明" />
    </p>
    <p class="short-input ue-clear">
    	<label>操作人：</label>
        <input type="text" placeholder="请输入操作人姓名" /> 
        <label>操作时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
       
    </p>
    <p class="short-input ue-clear">
    	<label>处理文号：</label>
      <input type="text" placeholder="请输入处理文号" /> 
    </p>
    </fieldset>
    
   
    <fieldset>
    <legend>学生异动前信息</legend>
    <p class="short-input ue-clear">
    	<label>转学前学校名称：</label>
        <input type="text" placeholder="请输入学生转学前学校名称" />
        <label>转学前所在年级：</label>
        <input type="text" placeholder="请输入学生转学前所在年级" /> 
    </p>
     <p class="short-input ue-clear">
        <label>转学前专业：</label>
        <input type="text" placeholder="请输入学生转学前专业" /> 
        <label>异动前学院：</label>
        <input type="text" placeholder="请输入学生异动前学院" /> 
       
    </p>
    <p class="short-input ue-clear">
        <label>异动前系：</label>
        <input type="text" placeholder="请输入学生异动前系" /> 
       <label>异动前专业：</label>
        <input type="text" placeholder="请输入学生异动前专业" /> 
    </p>
    <p class="short-input ue-clear">
    	
        <label>异动前学制：</label>
        <input type="text" placeholder="请输入学生异动前学制" /> 
        <label>异动前行政班：</label>
        <input type="text" placeholder="请输入异动前行政班" /> 
       
    </p>
   
    <p class="short-input ue-clear">
    	<label>异动前专业方向：</label>
        <input type="text" placeholder="请输入学生异动前专业方向" /> 
        <label>异动前培养方向：</label>
        <input type="text" placeholder="请输入学生异动前培养方向" /> 
    </p>
    
    
       <p class="short-input ue-clear">
      <label>异动前所在年级：</label>
      <input type="text" placeholder="请输入异动前所在年级" /> 
      <label>异动前专业代码：</label>
      <input type="text" placeholder="请输入异动前专业业代码" /> 
     </p>
     
      <p class="short-input ue-clear">
       <label>异动前专业类别：</label>
      <input type="text" placeholder="请输入异动前专业类别" />
       
     </p>
    
     <div class="short-input select ue-clear" >
    	<label>异动前学籍状态：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >有</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>有</li>
                <li>无</li>
         
            </ul>
        </div>
        <label>异动前是否在校：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >是</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>是</li>
                <li>否</li>
         
            </ul>
        </div>
    </div>
     
    <div class="short-input select ue-clear" >
    	<label>异动前是否注册：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >是</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>是</li>
                <li>否</li>
         
            </ul>
        </div>
        <label>异动前学历层次：</label>
      <div class="select-wrap" >
        	<div class="select-title " ><span >本科</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>本科</li>
                <li>硕士</li>
                <li>博士</li>
         
            </ul>
        </div>
    </div>
      
     </fieldset>
      <fieldset>
    <legend>学生异动后信息</legend>
    <p class="short-input ue-clear">
    	<label>转出后学校名称：</label>
        <input type="text" placeholder="请输入学生转出后学校名称" />
        <label>转出后年级：</label>
        <input type="text" placeholder="请输入学生转出后所在年级" /> 
    </p>
     <p class="short-input ue-clear">
    	
        <label>转出后专业：</label>
        <input type="text" placeholder="请输入学生转出后专业" /> 
        <label>异动后学院：</label>
        <input type="text" placeholder="请输入学生异动后学院" /> 
        </p>
  <p class="short-input ue-clear">
    	
        <label>异动后系：</label>
        <input type="text" placeholder="请输入学生异动后系" /> 
       <label>异动后专业：</label>
        <input type="text" placeholder="请输入学生异动后专业" /> 
    </p>
    <p class="short-input ue-clear">
    	
        <label>异动后学制：</label>
        <input type="text" placeholder="请输入学生异动后学制" /> 
       <label>异动后行政班：</label>
        <input type="text" placeholder="请输入异动后行政班" /> 
    </p>
   
    <p class="short-input ue-clear">
    	<label>异动后专业方向：</label>
        <input type="text" placeholder="请输入学生异动后专业方向" /> 
        <label>异动后培养方向：</label>
        <input type="text" placeholder="请输入学生异动后培养方向" /> 
    </p>
    
      <p class="short-input ue-clear">
      <label>异动后所在年级：</label>
      <input type="text" placeholder="请输入异动后所在年级" /> 
      <label>异动后专业代码：</label>
      <input type="text" placeholder="请输入异动后专业代码" /> 
     </p>
     
      <p class="short-input ue-clear">
       <label>异动后专业类别：</label>
      <input type="text" placeholder="请输入异动后专业类别" />
     </p>
     
     <div class="short-input select ue-clear" >
    	<label>异动后学籍状态：</label>
      <div class="select-wrap" >
        	<div class="select-title " ><span >有</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>有</li>
                <li>无</li>
         
            </ul>
        </div>
        <label>异动后是否在校：</label>
       <div class="select-wrap" >
        	<div class="select-title " ><span >是</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>是</li>
                <li>否</li>
         
            </ul>
        </div>
    </div>
    
    <div class="short-input select ue-clear" >
    	<label>异动后是否注册：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >是</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>是</li>
                <li>否</li>
         
            </ul>
        </div>
        <label>异动后学历层次：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >本科</span><i class="icon"></i></div>
            <ul class="select-list" >
            	<li>本科</li>
                <li>硕士</li>
                <li>博士</li>
         
            </ul>
        </div>
    </div>
      
     
     </fieldset>
    <p class="short-input ue-clear">
    	<label style="width:180px">附加信息：</label>
        <textarea placeholder="请输入附加信息"></textarea>
    </p>
   
    
</div>

<div class="btn ue-clear">
	<a href="javascript:;" class="confirm save">确定</a>
    <a href="javascript:;" class="clear clear" >返回</a>
</div>


</form>


  

</body>


<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');



</script>
</html>
