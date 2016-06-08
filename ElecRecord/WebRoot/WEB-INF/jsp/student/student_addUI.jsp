<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
    
<title>添加学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
</head>
<body>

<div class="title"><h2>学生个人基本信息修改</h2></div>
<form id="myForm">
<div class="main">     
    <p class="short-input ue-clear">    	
        <label>学号：</label>
        <s:textfield name="student.studentNo" class="strutsinput"></s:textfield>
        <label>姓名：</label>
        <s:textfield name="student.stuName" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>身份证号码：</label>
        <s:textfield name="student.idCardNo" class="strutsinput"></s:textfield>
        <label>本人手机号码：</label>
        <s:textfield name="student.mobileNo" class="strutsinput"></s:textfield>
    </p>
    
     <div class="short-input select ue-clear" >
    	<label>性别：</label>
    	<input type="hidden" value="男" name="student.sex">
        <div class="select-wrap" >
        	<div class="select-title " id="select-title1"><span id="span1">男</span><i class="icon"></i></div>
            <ul class="select-list" id="list1">
            	<li id="男">男</li>
               <li id="女">女</li>
            </ul>
        </div> 
        <label>出生日期：</label>
        <div class="select-wrap" >
        	<input type="text" name="student.birthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" /> 
        </div>        
    </div>
       <div class="short-input select ue-clear" >
    	<label>政治面貌：</label>
    	<input type="hidden" value="党员" name="student.politicalStatus">
        <div class="select-wrap" >
        	<div class="select-title " id="select-title3"><span id="span3">群众</span><i class="icon"></i></div>
            <ul class="select-list" id="list3">
            	<li id="党员">党员</li>
               <li id="群众">群众</li>
            </ul>
        </div> 
        <div class="select-wrap" >
        <label>民族：</label>
            <s:textfield name="student.nation" class="strutsinput"></s:textfield>
        </div>
    </div>
        
    <p class="short-input ue-clear">
        <label>籍贯：</label>
        <s:textfield name="student.nativePlace" class="strutsinput"></s:textfield>
        <label>来源地区：</label>
        <s:textfield name="student.fromPlace" class="strutsinput"></s:textfield>
    	</p>
    
    <p class="short-input ue-clear">    	
        <label>学院id：</label>
        <s:textfield name="student.orgId" class="strutsinput"></s:textfield>
        <label>学院名称：</label>
        <s:textfield name="student.orgName" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>系：</label>
        <s:textfield name="student.department" class="strutsinput"></s:textfield>
        <label>专业：</label>
        <s:textfield name="student.major" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>专业方向：</label>
        <s:textfield name="student.majorField" class="strutsinput"></s:textfield>
        <label>专业类别：</label>
        <s:textfield name="student.majorCategories" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>培育方向：</label>
        <s:textfield name="student.cultivateDirection" class="strutsinput"></s:textfield>
        <label>班级：</label>
        <s:textfield name="student.className" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>学制：</label>
        <s:textfield name="student.educationSystem" class="strutsinput"></s:textfield>
        <label>学习年限：</label>
        <s:textfield name="student.schoolingLength" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>入学日期：</label>
        <s:textfield name="student.acceptanceDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true" class="strutsinput"></s:textfield>
        <label>毕业中学：</label>
        <s:textfield name="student.middleSchool" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>家庭电话：</label>
        <s:textfield name="student.familyTelNo" class="strutsinput"></s:textfield>
        <label>邮政编码：</label>
        <s:textfield name="student.postCode" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>乘车区间：</label>
        <s:textfield name="student.travelRange" class="strutsinput"></s:textfield>
        <label>家庭地址：</label>
        <s:textfield name="student.address" class="strutsinput"></s:textfield>
    </p>
    <p class="short-input ue-clear">    	
        <label>学籍状态：</label>
        <s:textfield name="student.schoolStatus" class="strutsinput"></s:textfield>
        <label>dqszj：</label>
        <s:textfield name="student.dqszj" class="strutsinput"></s:textfield>
    </p>   

    <p class="short-input ue-clear" >
		<label>毕业审核标志：</label>
		<s:radio list="#{'Y':'通过','N':'没通过'}" name="student.graduateFlag" value="'Y'"  cssStyle="width:35px;" />	
				
		<label>导入校友会标志：</label>
		<s:radio list="#{'Y':'已导入','N':'未导入'}" name="student.alumniFlag" value="'Y'"  cssStyle="width:45px;" />	
	</p>

    <p class="short-input ue-clear">
    	<label >自我描述：</label>
        <textarea name="student.selfDescription"></textarea>
    </p>
      <p class="short-input ue-clear">
    	<label >特长：</label>
        <textarea name="student.skill"></textarea>
    </p>

    <p class="short-input ue-clear">
    	<label >所获奖励：</label>
        <textarea name="student.awards"></textarea>
    </p>
    
   
</div>

	<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}student/student_add.action')"  class="confirm save">确定</a> 
		</div>


</form>


</body>



<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');



</script>
</html>