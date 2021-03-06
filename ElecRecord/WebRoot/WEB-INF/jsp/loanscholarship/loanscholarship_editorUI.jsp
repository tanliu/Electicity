<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>

<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<title>国家助学贷款基本信息修改</title>
</head>
<body >

<div class="title"><h2>修改国家助学贷款基本信息</h2></div>
<form id="myForm" method="post">
        <input hidden="hidden" value="<s:property value="loanscholarship.stuId"/>" name="loanscholarship.stuId"> 
	   <input hidden="hidden" name="loanscholarship.id" value="${loanscholarship.id}" > 
	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_rewardName" value="${querycon.censoredFlag}">
	    <input type="hidden" name="query_studentNo" value="${querycon.studentNo}">
	    <input type="hidden" name="query_stuName" value="${querycon.stuName}">
	    <s:hidden name="pageNO"></s:hidden>
	    
	     <input hidden="hidden" value="<s:property value="loanscholarship.creator"/>" name="loanscholarship.creator">
	   <!-- 将原先的创建时间返回 -->
	  <input type="hidden" name="loanscholarship.createTime" value="${loanscholarship.createTime}"/>
<div class="main">
      <p class="short-input ue-clear">
    	
        <label>姓名：</label>
        <input type="text" class="strutsinput noNull" name="loanscholarship.stuName" placeholder="请输入姓名"  value="${loanscholarship.stuName}"/> 
        <label>学号：</label>
        <input type="text" class="strutsinput noNull studentNo" name="loanscholarship.studentNo" placeholder="请输入学号"  value="${loanscholarship.studentNo}"/> 
    </p>
    
    <p class="short-input ue-clear">
    	
        <label>身份证：</label>
        <input type="text" class="strutsinput noNull idCard" name="loanscholarship.idCardNo" placeholder="请输入身份证号码"  value="${loanscholarship.idCardNo}"/> 
        <label>班级：</label>
        <input type="text" class="strutsinput noNull" name="loanscholarship.className" placeholder="请输入班级 " value="${loanscholarship.className}"/> 
    </p>
     <div class="short-input select ue-clear" >
         <label>性别：</label>
        <input  hidden="hidden" class="noNull" name="loanscholarship.sex" value="<s:property value="loanscholarship.sex"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.sex}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="男">男</li>
            	<li id="女">女</li>
            </ul>
        </div>
        <label>年级：</label>
        <input  hidden="hidden"  class="noNull" name="loanscholarship.grade" value="<s:property value="loanscholarship.grade"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.grade}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="2012">2012</li>
            	<li id="2013">2013</li>
                <li id="2014">2014</li>
                <li id="2015">2015</li>
            </ul>
        </div>
        
    </div>

  <div class="short-input select ue-clear" >
        
        <label>学院：</label>
        <input  hidden="hidden" class="noNull" name="loanscholarship.orgName" value="<s:property value="loanscholarship.orgName"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.orgName}</span><i class="icon"></i></div>
           <ul class="select-list" >
                <li id="">请选择</li>
            	<li id="计算机学院">计算机学院</li>
                <li id="艺术与设计学院">艺术与设计学院</li>
                <li id="机械与车辆学院">机械与车辆学院</li>
                <li id="化工与材料学院">化工与材料学院</li>
                <li id="会计与金融学院">会计与金融学院</li>
                <li id="商学院">商学院</li>
                <li id="外国语学院">外国语学院</li>
                <li id="航空学院">航空学院</li>
                <li id="文法学院">文法学院</li>
                <li id="数理学院">数理学院</li>
                <li id="信息学院">信息学院</li>
                <li id="布莱恩特学院">布莱恩特学院</li>
            </ul>
        </div>
         <label>贷款金额：</label>
        <input  hidden="hidden" class="noNull" name="loanscholarship.loanAmount"  value="<s:property value="loanscholarship.loanAmount"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.loanAmount}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="8000">8000</li>
            	<li id="6000">6000</li>
            </ul>
        </div>
    </div>
<div class="short-input select ue-clear" >
  <label>专业：</label>
       <input  hidden="hidden" class="noNull" value='<s:property value='loanscholarship.major'/>' name="loanscholarship.major">
        <div class="select-wrap">
				<div class="select-title" >
					<span id="span1"><s:property value='loanscholarship.major'/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.major" var="major">
					      <li id="<s:property value='#major.ddlName'/>"><s:property value="#major.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
		   <label>是否通过审核：</label>
        <input  hidden="hidden" class="noNull" name="loanscholarship.censoredFlag" value="<s:property value="loanscholarship.censoredFlag"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.censoredFlag}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="是">是</li>
            	<li id="否">否</li>
            </ul>
        </div>
    </div>
    
      <div class="short-input select ue-clear" >
        <label>学年：</label>
        <input  hidden="hidden" class="noNull" value='<s:property value='loanscholarship.academicYear'/>' name="loanscholarship.academicYear">
      <div class="select-wrap">
				<div class="select-title ue-clear" >
					<span id="span1"><s:property value='loanscholarship.academicYear'/></span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
					 <li id="">请选择</li>
					    <s:iterator value="#request.academicYear" var="academicYear">
					      <li id="<s:property value='#academicYear.ddlName'/>"><s:property value="#academicYear.ddlName"/></li>
					    </s:iterator>
					</ul>					
				</div>
		<label>学期：</label>
    	 <input  hidden="hidden" class="noNull" value="<s:property value="loanscholarship.term"/>" name="loanscholarship.term">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.term}</span><i class="icon"></i></div>
            <ul class="select-list" >
             <li id="">请选择</li>
            	<li id="1">1</li>
                <li id="2">2</li>
            </ul>
        </div>
    </div>
    <p class="short-input ue-clear">
    	<label >被拒绝原因：</label>
        <textarea name="loanscholarship.refuseReason" placeholder="请输入原因">${loanscholarship.refuseReason}</textarea>
    </p>
    
    <div class="short-input select ue-clear" >
		   <label>是否还贷：</label>
        <input  hidden="hidden"  class="noNull" name="loanscholarship.repayFlag" value="<s:property value="loanscholarship.repayFlag"/>">
        <div class="select-wrap">
        	<div class=" select-title ue-clear" ><span >${loanscholarship.repayFlag}</span><i class="icon"></i></div>
            <ul class="select-list" >
                <li id="">请选择</li>
                <li id="是">是</li>
            	<li id="否">否</li>
            </ul>
        </div>
         <label>还贷金额：</label>
        <input type="text" class="noNull" name="loanscholarship.repayAmount" placeholder="请输入还贷金额" value="${loanscholarship.repayAmount}" /> 
    </div>
    
    <div class="short-input select ue-clear" >
        
        <label>还贷日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" class="noNull" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" placeholder="请选择日期" name="loanscholarship.repayDate"
        	  value="<s:date name="loanscholarship.repayDate" format="yyyy-MM-dd"></s:date>"/>
        </div>
        <label>修改日期：</label>
        <div class="select-wrap" > 
        	 <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" placeholder="请选择日期" name="loanscholarship.modifyDate"
        	   value="<s:date name="loanscholarship.modifyDate" format="yyyy-MM-dd"></s:date>"/>
        </div>
    </div>
    
    <p class="short-input ue-clear">
    	<label >备注：</label>
        <textarea name="loanscholarship.memo" placeholder="请输入备注">${loanscholarship.memo}</textarea>
    </p>
</div>

<div class="btn ue-clear">
	
	 <a href="javascript:editor('myForm','post','${basePath}loanscholarship/loanscholarship_editor.action') "  class="confirm save">确定</a> 
  
    <a href="javascript:back()" class="clear clear" >返回</a>
</div>
</form>
</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>


</html>
