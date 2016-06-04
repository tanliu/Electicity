<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="/common/header_js.jsp"%>
<html>
<head>

<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

<title>学籍异动信息修改</title>
</head>

<body>

<div class="title"><h2>学籍异动信息修改</h2></div>
<form id="myForm">
<div class="main">	    
	    <input type="hidden" name="query_academicYear" value="${queryCon.academicYear}">
	    <input type="hidden" name="query_studentNo" value="${queryCon.studentNo}">
	    <input type="hidden" name="query_stuName" value="${queryCon.stuName}">
	    <s:hidden name="pageNO"></s:hidden>
	<!-- 这里先将stuid设定死，用于测试 -->
	<input type="hidden" name="stuStatus.stuId" value="${stuStatus.stuId}"/>
	<!-- 将StuStatus传递给对应的editor方法 -->
	<input type="hidden" name="stuStatus.id" value="${stuStatus.id}"/>
	<!-- 记得将原先的创建时间返回 -->
	<input type="hidden" name="stuStatus.createTime" value="${stuStatus.createTime}"/>
	<fieldset >
    <legend>学生信息</legend>
     
    <p class="short-input ue-clear">
    	<label>学号：</label>
        <input type="text" placeholder="请输入学生学号" readonly="readonly" name="stuStatus.studentNo" value="${stuStatus.studentNo}" /> 
        <label>姓名：</label>
        <input type="text" placeholder="请输入学生姓名" name="stuStatus.stuName" value="${stuStatus.stuName} "/> 
    </p>
    
  
    <div class="short-input select ue-clear" >
   
    	<label>性别：</label>
    	<input class="noNull"  hidden="hidden" value="<s:property value="stuStatus.sex"/>" name="stuStatus.sex">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.sex"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="男">男</li>
                <li id="女">女</li>
            </ul>
        </div>
        
    </div>
    <p class="short-input ue-clear">
      <label>身份证号：</label>
      <input type="text" placeholder="请输入学生身份证号" readonly="readonly" name="stuStatus.idCardNo" value="${stuStatus.idCardNo}"/> 
       <label>考生号：</label>
        <input type="text" placeholder="请输入学生考生号" readonly="readonly" name="stuStatus.examinateNo" value="${stuStatus.examinateNo}"/> 
       
      </p>
      
      <div class="short-input select ue-clear" >
    	
    	<div >
    	<label >学生类别：</label>
        <input class="select-wrap " type="text" placeholder="请输入学生类别" name="stuStatus.studentCategory" value="${stuStatus.studentCategory}"/> 
        </div>
        <label>学年：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.academicYear"/>" name="stuStatus.academicYear" >
      <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.academicYear"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.years" var="years">
					      <li id="<s:property value='#years.ddlName'/>"><s:property value="#years.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
    </div>
      
     
  
      <div class="short-input select ue-clear" >
    	<label>学期：</label>
    	 <input  hidden="hidden" value="<s:property value="stuStatus.term"/>" name="stuStatus.term">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.term"/></span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>

    </div>
    
     
     </fieldset>
     <fieldset>
     <legend>异动信息</legend>
      <p class="short-input ue-clear">
    	<label>异动序号：</label>
      <input type="text" placeholder="请输入异动文号" name="stuStatus.transactionNo" value="${stuStatus.transactionNo}"/> 
       <label>异动结果：</label>
      <input type="text" placeholder="请输入异动结果" name="stuStatus.ydresult" value="${stuStatus.ydresult}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>异动类别：</label>
        <input type="text" placeholder="请输入异动类别" name="stuStatus.tansactionType" value="${stuStatus.tansactionType}"/>
        <label>异动原因：</label>
        <input type="text" placeholder="请输入异动原因" name="stuStatus.tansactionReason" value="${stuStatus.tansactionReason}"/>
    </p>
     <p class="short-input ue-clear">
    	<label>异动时间：</label>
    	
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="stuStatus.tansactionDate" value="<s:date format="yyyy-MM-dd" name="stuStatus.tansactionDate"/>">
        <label>行文时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="stuStatus.handleDate" value="<s:date format="yyyy-MM-dd" name="stuStatus.handleDate"/>"/>
    </p>
    <p class="short-input ue-clear">
    	<label>撤消时间：</label>
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="stuStatus.cancelDate" value="<s:date format="yyyy-MM-dd" name="stuStatus.cancelDate"/>"/>
        <label>异动说明：</label>
        <input type="text" placeholder="异动说明" name="stuStatus.tansactionMemo" value="${stuStatus.tansactionMemo}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>操作人：</label>
        <input type="text" placeholder="请输入操作人姓名" name="stuStatus.operator" value="${stuStatus.operator}"/> 
        <label>操作时间：</label>
        
        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="stuStatus.operatorTime" value="<s:date format="yyyy-MM-dd" name="stuStatus.operatorTime"/>"/>
       
    </p>
    <p class="short-input ue-clear">
    	<label>处理文号：</label>
      <input type="text" placeholder="请输入处理文号" name="stuStatus.processSymbols" value="${stuStatus.processSymbols}"/> 
    </p>
    </fieldset>
    
   
    <fieldset>
    <legend>学生异动前信息</legend>
   <div class="short-input select ue-clear" >
    	
    	 <div >
    	 <label>转出前学校名称：</label>
        <input type="text" class="select-wrap"  placeholder="请输入学生转出前学校名称" name="stuStatus.zxqschool" value="${stuStatus.zxqschool}"/>
        </div>
        <label>转出前所在年级：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.zxqgrade"/>" name="stuStatus.zxqgrade">
         <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.zxqgrade"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
         
    </div>
     <div class="short-input select ue-clear" >
        <label>转出前专业：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.zxqmajor"/>" name="stuStatus.zxqmajor">
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.zxqmajor"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
        <label>异动前学院：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.ydqcollege"/>" name="stuStatus.ydqcollege">
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.ydqcollege"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.colleges" var="colleges">
					      <li id="<s:property value='#colleges.ddlName'/>"><s:property value="#colleges.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
       </div>
   
   <div class="short-input select ue-clear" >
        
        <div  >
        <label>异动前系：</label>
        <input class="select-wrap" type="text" placeholder="请输入学生异动前系" name="stuStatus.ydqdepartment" value="${stuStatus.ydqdepartment}"/> 
        </div>
       <label>异动前专业：</label>
       <input  hidden="hidden" value="<s:property value="stuStatus.ydqmajor"/>" name="stuStatus.ydqmajor">
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.ydqmajor"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
    </div>
    <div class="short-input select ue-clear" >
    	
        <label>异动前学制：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.ydqlength"/>" name="stuStatus.ydqlength">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.ydqlength"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
                <li id="3">3</li>
                <li id="4">4</li>
            </ul>
        </div>
         
        
        <div >
        <label>异动前行政班：</label>
        <input type="text" class="select-wrap" placeholder="请输入异动前行政班" name="stuStatus.ydqclassName" value="${stuStatus.ydqclassName}"/> 
       </div>
    </div>
   
    <p class="short-input ue-clear">
    	<label>异动前专业方向：</label>
        <input type="text" placeholder="请输入学生异动前专业方向" name="stuStatus.ydqmajorField" value="${stuStatus.ydqmajorField}"/> 
        <label>异动前培养方向：</label>
        <input type="text" placeholder="请输入学生异动前培养方向" name="stuStatus.ydqcultivateDirection" value="${stuStatus.ydqcultivateDirection}"/> 
    </p>
    
    
       <div class="short-input select ue-clear">
      <label>异动前所在年级：</label>
      <input  hidden="hidden" value="<s:property value="stuStatus.ydqgrade"/>" name="stuStatus.ydqgrade">
       <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.ydqgrade"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
        
      
      <div >
      <label>异动前专业代码：</label>
      <input type="text" class="select-wrap" placeholder="请输入异动前专业业代码" name="stuStatus.ydqmajorCode" value="${stuStatus.ydqmajorCode}"/> 
      </div>
     </div>
     
      <p class="short-input ue-clear">
       <label>异动前专业类别：</label>
      <input type="text" placeholder="请输入异动前专业类别" name="stuStatus.ydqmajorCategory" value="${stuStatus.ydqmajorCategory}"/>
       
     </p>
    
     <div class="short-input select ue-clear" >
    	<label>异动前学籍状态：</label>
    	<input  hidden="hidden" value="<s:property value="stuStatus.ydqschoolStatus"/>" name="stuStatus.ydqschoolStatus">
         <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydqschoolStatus"/></span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">有</li>
                <li id="0">无</li>
         
            </ul>
        </div>
         
        <label>异动前是否在校：</label>
         <input  hidden="hidden" value="<s:property value="stuStatus.ydqinSchool"/>" name="stuStatus.ydqinSchool">
         <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydqinSchool"/></span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
       
    </div>
     
    <div class="short-input select ue-clear" >
    	<label>异动前是否注册：</label>
    	 <input  hidden="hidden" value="<s:property value="stuStatus.ydqisRegiste"/>" name="stuStatus.ydqisRegiste">
         <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydqisRegiste"/></span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
       
        <label>异动前学历层次：</label>
         <input  hidden="hidden" value="<s:property value="stuStatus.ydqeducation"/>" name="stuStatus.ydqeducation">
      <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydqeducation"/></span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="本科">本科</li>
               <li id="研究生">研究生</li>
         
            </ul>
        </div>
        
    </div>
      
     </fieldset>
      <fieldset>
    <legend>学生异动后信息</legend>
    <div class="short-input select ue-clear" >
    	
    	 <div  >
    	 <label>转出后学校名称：</label>
        <input type="text" class="select-wrap" placeholder="请输入学生转出后学校名称" name="stuStatus.zchschool" value="${stuStatus.zchschool}"/>
        </div>
        <label>转出后所在年级：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.zchgrade"/>" name="stuStatus.zchgrade">
         <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.zchgrade"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
        
    </div>
     <div class="short-input select ue-clear" >
        <label>转出后专业：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.zchmajor"/>" name="stuStatus.zchmajor" />
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.zchmajor"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
        <label>异动后学院：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.ydhcollege"/>" name="stuStatus.ydhcollege" >
         <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.ydhcollege"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.colleges" var="colleges">
					      <li id="<s:property value='#colleges.ddlName'/>"><s:property value="#colleges.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
       </div>
   
  <div class="short-input select ue-clear" >
       
        <div >
         <label>异动后系：</label>
        <input type="text" class="select-wrap" placeholder="请输入学生异动后系" name="stuStatus.ydhdepartment" value="${stuStatus.ydhdepartment}"/> 
        </div>
       <label>异动后专业：</label>
       <input  hidden="hidden" value="<s:property value="stuStatus.ydhmajor"/>" name="stuStatus.ydhmajor">
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value="stuStatus.ydhmajor"/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.majors" var="majors">
					      <li id="<s:property value='#majors.ddlName'/>"><s:property value="#majors.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
				
    </div>
    <div class="short-input select ue-clear" >
    	
        <label>异动后学制：</label>
         <input  hidden="hidden" value="<s:property value="stuStatus.ydhlength"/>" name="stuStatus.ydhlength">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.ydhlength"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
                <li id="3">3</li>
                <li id="4">4</li>
            </ul>
        </div>
       
       
        <div >
         <label>异动后行政班：</label>
        <input type="text" class="select-wrap" placeholder="请输入异动后行政班" name="stuStatus.tansactionClass" value="${stuStatus.tansactionClass}"/> 
       </div>
    </div>
   
    <p class="short-input ue-clear">
    	<label>异动后专业方向：</label>
        <input type="text" placeholder="请输入学生异动后专业方向" name="stuStatus.ydhmajorField" value="${stuStatus.ydhmajorField}"/> 
        <label>异动后培养方向：</label>
        <input type="text" placeholder="请输入学生异动后培养方向" name="stuStatus.ydhcultivatedirection" value="${stuStatus.ydhcultivatedirection}"/> 
    </p>
    
     <div class="short-input select ue-clear">
      <label>异动后所在年级：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.ydhgrade"/>" name="stuStatus.ydhgrade">
       <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span ><s:property value="stuStatus.ydhgrade"/></span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="大一">大一</li>
                <li id="大二">大二</li>
                <li id="大三">大三</li>
                <li id="大四">大四</li>
            </ul>
        </div>
      
      
      <div >
      <label>异动后专业代码：</label>
      <input type="text" class="select-wrap" placeholder="请输入异动后专业代码" name="stuStatus.ydhmajorCode" value="${stuStatus.ydhmajorCode}"/> 
      </div>
     </div>
     
      <p class="short-input ue-clear">
       <label>异动后专业类别：</label>
      <input type="text" placeholder="请输入异动后专业类别" name="stuStatus.ydhmajorCategory" value="${stuStatus.ydhmajorCategory}"/>
     </p>
     
     <div class="short-input select ue-clear" >
    	<label>异动后学籍状态：</label>
    	<input  hidden="hidden" value="<s:property value="stuStatus.ydhschoolStatus"/>" name="stuStatus.ydhschoolStatus">
      <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydhschoolStatus"/></span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">有</li>
                <li id="0">无</li>
         
            </ul>
        </div>
        
        <label>异动后是否在校：</label>
        <input  hidden="hidden" value="<s:property value="stuStatus.ydhinSchool"/>" name="stuStatus.ydhinSchool">
       <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydhinSchool"/></span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
         
            </ul>
        </div>
         
    </div>
    
    <div class="short-input select ue-clear" >
    	<label>异动后是否注册：</label>
    	<input  hidden="hidden" value="<s:property value="stuStatus.ydhisRegiste"/>" name="stuStatus.ydhisRegiste">
         <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydhisRegiste"/></span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="1">是</li>
                <li id="0">否</li>
            </ul>
        </div>
         
        <label>异动后学历层次：</label>
          <input  hidden="hidden" value="<s:property value="stuStatus.ydheducation"/>" name="stuStatus.ydheducation">
         <div class="select-wrap" >
        	<div class="select-title " ><span ><s:property value="stuStatus.ydheducation"/></span><i class="icon"></i></div>
            <ul class="select-list" >
            <li id="">请选择</li>
            	<li id="本科">本科</li>
                <li id="研究生">研究生</li>
         
            </ul>
        </div>
      
    </div>
      
     
     </fieldset>
    <p class="short-input ue-clear">
    	<label style="width:180px">附加信息：</label>
        <textarea placeholder="请输入附加信息" name="stuStatus.memo" >${stuStatus.memo}</textarea>
    </p>
   
    
</div>

<div class="btn ue-clear">
	<a href="javascript:add('myForm','post','${basePath}stustatus/stustatus_editor.action')" class="confirm save">确定</a>
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>


</form>


  

</body>

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');



</script>
</html>
