<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

<title>添加学籍异动信息</title>
</head>

<body>

<div class="title"><h2>添加学籍异动信息</h2></div>
<form id="myForm">
<div class="main">
	<!-- 这里先将stuid设定死，用于测试 -->
	<input type="hidden" name="stuStatus.stuId" value="0145214"/>
	<fieldset >
    <legend>学生信息</legend>
     
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" name="stuStatus.studentNo"/> 
        <label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="stuStatus.stuName"/> 
    </p>
    
  
    <div class="short-input select ue-clear" >
   
    	<label>性别：</label>
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="男">男</li>
                <li id="女">女</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.sex">
        
    </div>
    <p class="short-input ue-clear">
      <label>身份证号：</label>
      <input type="text" placeholder="请输入学生身份证号" name="stuStatus.idCardNo"/> 
       <label>考生号：</label>
        <input type="text" placeholder="请输入学生考生号" name="stuStatus.examinateNo"/> 
       
      </p>
      
      <div class="short-input select ue-clear" >
    	<label>学生类别：</label>
    	<div class="select-wrap" >
        <input type="text" placeholder="请输入学生类别" name="stuStatus.studentCategory"/> 
        </div>
        <label>学年：</label>
      <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.years" var="years">
					      <li id="<s:property value='#years.ddlName'/>"><s:property value="#years.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.academicYear">
    </div>
      
     
  
      <div class="short-input select ue-clear" >
    	<label>学期：</label>
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.term">
    </div>
    
     
     </fieldset>
     <fieldset>
     <legend>异动信息</legend>
      <p class="short-input ue-clear">
    	<label>异动序号：</label>
      <input type="text" placeholder="请输入异动文号" name="stuStatus.transactionNo"/> 
       <label>异动结果：</label>
      <input type="text" placeholder="请输入异动结果" name="stuStatus.ydresult"/>
    </p>
    <p class="short-input ue-clear">
    	<label>异动类别：</label>
        <input type="text" placeholder="请输入异动类别" name="stuStatus.tansactionType"/>
        <label>异动原因：</label>
        <input type="text" placeholder="请输入异动原因" name="stuStatus.tansactionReason"/>
    </p>
     <p class="short-input ue-clear">
    	<label>异动时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="stuStatus.tansactionDate"/>
        <label>行文时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="stuStatus.handleDate"/>
    </p>
    <p class="short-input ue-clear">
    	<label>撤消时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="stuStatus.cancelDate"/>
        <label>异动说明：</label>
        <input type="text" placeholder="异动说明" name="stuStatus.tansactionMemo"/>
    </p>
    <p class="short-input ue-clear">
    	<label>操作人：</label>
        <input type="text" placeholder="请输入操作人姓名" name="stuStatus.operator"/> 
        <label>操作时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="stuStatus.operatorTime"/>
       
    </p>
    <p class="short-input ue-clear">
    	<label>处理文号：</label>
      <input type="text" placeholder="请输入处理文号" name="stuStatus.processSymbols"/> 
    </p>
    </fieldset>
    
   
    <fieldset>
    <legend>学生异动前信息</legend>
   <div class="short-input select ue-clear" >
    	<label>转出前学校名称：</label>
    	 <div class="select-wrap" >
        <input type="text" placeholder="请输入学生转出前学校名称" name="stuStatus.zxqschool"/>
        </div>
        <label>转出前所在年级：</label>
         <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.zxqgrade">
    </div>
     <div class="short-input select ue-clear" >
        <label>转出前专业：</label>
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.zxqmajor">
        <label>异动前学院：</label>
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.colleges" var="colleges">
					      <li id="<s:property value='#colleges.ddlName'/>"><s:property value="#colleges.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.ydqcollege">
       </div>
   
   <div class="short-input select ue-clear" >
        <label>异动前系：</label>
        <div class="select-wrap" >
        <input type="text" placeholder="请输入学生异动前系" name="stuStatus.ydqdepartment"/> 
        </div>
       <label>异动前专业：</label>
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.ydqmajor">
    </div>
    <div class="short-input select ue-clear" >
    	
        <label>异动前学制：</label>
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
                <li id="3">3</li>
                <li id="4">4</li>
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.ydqlength">
        <label>异动前行政班：</label>
        <div class="select-wrap">
        <input type="text" placeholder="请输入异动前行政班" name="stuStatus.ydqclassName"/> 
       </div>
    </div>
   
    <p class="short-input ue-clear">
    	<label>异动前专业方向：</label>
        <input type="text" placeholder="请输入学生异动前专业方向" name="stuStatus.ydqmajorField"/> 
        <label>异动前培养方向：</label>
        <input type="text" placeholder="请输入学生异动前培养方向" name="stuStatus.ydqcultivateDirection"/> 
    </p>
    
    
       <div class="short-input select ue-clear">
      <label>异动前所在年级：</label>
       <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydqgrade">
      <label>异动前专业代码：</label>
      <div class="select-wrap">
      <input type="text" placeholder="请输入异动前专业业代码" name="stuStatus.ydqmajorCode"/> 
      </div>
     </div>
     
      <p class="short-input ue-clear">
       <label>异动前专业类别：</label>
      <input type="text" placeholder="请输入异动前专业类别" name="stuStatus.ydqmajorCategory"/>
       
     </p>
    
     <div class="short-input select ue-clear" >
    	<label>异动前学籍状态：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">有</li>
                <li id="0">无</li>
         
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.ydqschoolStatus">
        <label>异动前是否在校：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydqinSchool">
    </div>
     
    <div class="short-input select ue-clear" >
    	<label>异动前是否注册：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydqisRegiste">
        <label>异动前学历层次：</label>
      <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="本科">本科</li>
               <li id="研究生">研究生</li>
         
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.ydqeducation">
    </div>
      
     </fieldset>
      <fieldset>
    <legend>学生异动后信息</legend>
    <div class="short-input select ue-clear" >
    	<label>转出后学校名称：</label>
    	 <div class="select-wrap" >
        <input type="text" placeholder="请输入学生转出后学校名称" name="stuStatus.zchschool"/>
        </div>
        <label>转出后所在年级：</label>
         <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.zchgrade">
    </div>
     <div class="short-input select ue-clear" >
        <label>转出后专业：</label>
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.zchmajor">
        <label>异动后学院：</label>
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.colleges" var="colleges">
					      <li id="<s:property value='#colleges.ddlName'/>"><s:property value="#colleges.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.ydhcollege">
       </div>
   
  <div class="short-input select ue-clear" >
        <label>异动后系：</label>
        <div class="select-wrap">
        <input type="text" placeholder="请输入学生异动后系" name="stuStatus.ydhdepartment"/> 
        </div>
       <label>异动后专业：</label>
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1">请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				<input  hidden="hidden" value="" name="stuStatus.ydhmajor">
    </div>
    <div class="short-input select ue-clear" >
    	
        <label>异动后学制：</label>
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
                <li id="3">3</li>
                <li id="4">4</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydhlength">
        <label>异动后行政班：</label>
        <div class="select-wrap">
        <input type="text" placeholder="请输入异动后行政班" name="stuStatus.tansactionClass"/> 
       </div>
    </div>
   
    <p class="short-input ue-clear">
    	<label>异动后专业方向：</label>
        <input type="text" placeholder="请输入学生异动后专业方向" name="stuStatus.ydhmajorField"/> 
        <label>异动后培养方向：</label>
        <input type="text" placeholder="请输入学生异动后培养方向" name="stuStatus.ydhcultivatedirection"/> 
    </p>
    
     <div class="short-input select ue-clear">
      <label>异动后所在年级：</label>
       <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydhgrade">
      <label>异动后专业代码：</label>
      <div class="select-wrap">
      <input type="text" placeholder="请输入异动后专业代码" name="stuStatus.ydhmajorCode"/> 
      </div>
     </div>
     
      <p class="short-input ue-clear">
       <label>异动后专业类别：</label>
      <input type="text" placeholder="请输入异动后专业类别" name="stuStatus.ydhmajorCategory"/>
     </p>
     
     <div class="short-input select ue-clear" >
    	<label>异动后学籍状态：</label>
      <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">有</li>
                <li id="0">无</li>
         
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydhschoolStatus">
        <label>异动后是否在校：</label>
       <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.ydhinSchool">
    </div>
    
    <div class="short-input select ue-clear" >
    	<label>异动后是否注册：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
            </ul>
        </div>
         <input  hidden="hidden" value="" name="stuStatus.ydhisRegiste">
        <label>异动后学历层次：</label>
         <div class="select-wrap" >
        	<div class="select-title " ><span >请选择</span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="本科">本科</li>
                <li id="研究生">研究生</li>
         
            </ul>
        </div>
        <input  hidden="hidden" value="" name="stuStatus.ydheducation">
    </div>
      
     
     </fieldset>
    <p class="short-input ue-clear">
    	<label style="width:180px">附加信息：</label>
        <textarea placeholder="请输入附加信息" name="stuStatus.memo"></textarea>
    </p>
   
    
</div>

<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}/stustatus/stustatus_add.action')" class="confirm save">确定</a>
    <a href="javascript:;" class="clear clear" >返回</a>
</div>


</form>


  

</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');



</script>
</html>