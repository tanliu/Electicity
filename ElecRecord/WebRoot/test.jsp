<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/teacher_alterUI.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />



<title>教师个人基本信息修改</title>
</head>

<body>

<div class="title"><h2>教师个人基本信息修改</h2></div>
<form id="myForm">
<div class="main">

	
     
    <p class="short-input ue-clear">
    	<label>职工号：</label>
        <input type="text" placeholder="请输入职工号" /> 
        <label>姓名：</label>
        <input type="text" placeholder="请输入姓名" /> 
       
    </p>
    
     <div class="short-input select ue-clear" >
    	<label>性别：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title1"><span id="span1">男</span><i class="icon"></i></div>
            <ul class="select-list" id="list1">
            	<li>男</li>
               <li>女</li>
            </ul>
        </div> 
        <label>出生日期：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入出生日期，如19940501" /> 
        </div>
        
        
    </div>
    
    
    <div class="short-input select ue-clear" >
    	<label>（部门）学院：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title2"><span id="span2">计算机学院</span><i class="icon"></i></div>
            <ul class="select-list" id="list2">
            	<li>计算机学院</li>
               <li>会计学院</li>
            </ul>
        </div> 
        <label>科室（系）：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入所在科室（系）" />
        </div>
        
        
    </div>
   
   
    
    <p class="short-input ue-clear">
        <label>联系电话：</label>
        <input type="text" placeholder="请输入联系电话" /> 
        <label>E_mail地址：</label>
        <input type="text" placeholder="请输入E_mail地址" /> 
    	
    </p>
    
    <div class="short-input select ue-clear" >
    	<label>教职工类别：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title3"><span id="span3">校本部</span><i class="icon"></i></div>
            <ul class="select-list" id="list3">
            	<li>校本部</li>
               <li>专任教师</li>
               
            </ul>
        </div> 
        <label>学历：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title4"><span id="span4">本科</span><i class="icon"></i></div>
            <ul class="select-list" id="list4">
            	<li>本科</li>
               <li>研究生</li>
              
            </ul>
        </div>
        
        
    </div>
    <div class="short-input select ue-clear" >
    	<label>学位：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title5"><span id="span5">硕士</span><i class="icon"></i></div>
            <ul class="select-list" id="list5">
            	<li>学士</li>
               <li>硕士</li>
            </ul>
        </div> 
        <label>职务：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入担任职务" />
        </div>
        
        
    </div>
    
    <div class="short-input select ue-clear" >
    	<label>职称：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title6"><span id="span6">校本部</span><i class="icon"></i></div>
            <ul class="select-list" id="list6">
            	<li>校本部</li>
               <li>专任教师</li>
               
            </ul>
        </div> 
        <label>派监考老师可用否：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title7"><span id="span7">T</span><i class="icon"></i></div>
            <ul class="select-list" id="list7">
            	<li>T</li>
               <li>F</li>
              
            </ul>
        </div>
        
        
    </div>
    
     <p class="short-input ue-clear">
     	  
        <label>教学研究方向：</label>
        <input type="text" placeholder="请输入教学研究方向" /> 
        <label>教学质量评价：</label>
        <input type="text" placeholder="请输入教学质量评价" />
        
    </p>
    
    <div class="short-input select ue-clear" >
    	<label>专业名称：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title8"><span id="span8">软件工程</span><i class="icon"></i></div>
            <ul class="select-list" id="list8">
            	<li>软件工程</li>
               <li>国际经济与贸易</li>
            </ul>
        </div> 
        <label>毕业院校：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入毕业院校" />
        </div>
        
        
    </div>
    
    
     <div class="short-input select ue-clear" >
    	<label>教师资格：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title9"><span id="span9">有</span><i class="icon"></i></div>
            <ul class="select-list" id="list9">
            	<li>有</li>
               <li>无</li>
            </ul>
        </div> 
        <label>人事职工号：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入人事职工号" />
        </div>
        
        
    </div>
    
    <p class="short-input ue-clear">
        <label>在职类别：</label>
        <input type="text" placeholder="请输入在职类别" /> 
        <label>教师级别：</label>
        <input type="text" placeholder="请输入教师级别" /> 
    	
    </p>
    
    <div class="short-input select ue-clear" >
     <label>手机号码：</label>
        <div class="select-wrap" >
        	<input type="text" placeholder="请输入手机号码" />
        </div>
    	<label>手机类型：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title10"><span id="span10">移动</span><i class="icon"></i></div>
            <ul class="select-list" id="list10">
            	<li>移动</li>
               <li>联通</li>
               <li>电信</li>
            </ul>
        </div> 
       
    </div>
    <div class="short-input select ue-clear" >
     <label>是否实验室人员：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title11"><span id="span11">是</span><i class="icon"></i></div>
            <ul class="select-list" id="list11">
            	<li>是</li>
               <li>否</li>
               
            </ul>
        </div> 
    	<label>是否外聘：</label>
        <div class="select-wrap" >
        	<div class="select-title " id="select-title12"><span id="span12">是</span><i class="icon"></i></div>
            <ul class="select-list" id="list12">
            	<li>是</li>
               <li>否</li>
            </ul>
        </div> 
    </div>
    
    <p class="short-input ue-clear">
    	<label>工作量系数：</label>
        <input type="text" placeholder="请输入工作量系数" /> 
        <label>政治面貌：</label>
        <input type="text" placeholder="请输入政治面貌" /> 
       
    </p>
    
    <p class="short-input ue-clear">
    	<label>民族：</label>
        <input type="text" placeholder="请输入所属民族" /> 
        <label>参加工作时间：</label>
        <input type="text" placeholder="请输入参加工作时间" /> 
       
    </p>
    
    <p class="short-input ue-clear">
    	<label>教师姓名拼音：</label>
        <input type="text" placeholder="请输入教师姓名拼音" /> 
        <label>社会服务方向：</label>
        <input type="text" placeholder="请输入社会服务方向" /> 
       
    </p>
    
    <p class="short-input ue-clear">
    	<label>教龄：</label>
        <input type="text" placeholder="请输入教龄" /> 
        <label>校龄：</label>
        <input type="text" placeholder="请输入校龄" /> 
       
    </p>
    
    <p class="short-input ue-clear">
    	<label>英文姓名：</label>
        <input type="text" placeholder="请输入英文姓名" /> 
        <label>学缘结构：</label>
        <input type="text" placeholder="请输入学缘结构" /> 
       
    </p>
    
     <p class="short-input ue-clear">
    	<label>教师任职期限时间：</label>
        <input type="text" placeholder="请输入教师任职期限时间" /> 
        
    </p>
    
    <p class="short-input ue-clear">
    	<label >教师简介：</label>
        <textarea placeholder="请输入教师"></textarea>
    </p>
    
</div>

<div class="btn ue-clear">
	<a href="javascript:;" class="confirm save">确定</a>
    <a href="javascript:;" class="clear clear" >重置所有信息</a>
</div>


</form>

<div class="clearDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">您确定要清空输入的所有内容吗？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        </div>
</div>
  
  
<div class="saveDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">您确定要保存输入的所有内容吗？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        </div>
</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>

<script type="text/javascript" src="js/teacher_alterUI.js"></script>
<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');



</script>
</html>
