<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
	<title>学生电子档案管理系统</title>
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" href="${basePath}css/jquery.dialog.css" />

	
</head>

    <body>
        <div class="title"><h2>编辑学生档案邮寄信息</h2>
        </div>
        <div class="main">
            <form id="myForm">
            <input hidden="hidden"  name="postinfo.id" value="${postinfo.id}"/>
             <input hidden="hidden"  name="postinfo.stuId" value="${postinfo.stuId}"/>
              <input hidden="hidden"  name="postinfo.createTime" value="${postinfo.createTime}"/>
             <input hidden="hidden"  name="postinfo.creator" value="${postinfo.creator}"/>
                      	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_emsno" value="${querycon.emsno}">
	    <input type="hidden" name="query_mailNo" value="${querycon.mailNo}">
	    <input type="hidden" name="query_major" value="${querycon.major}">
	    <input type="hidden" name="query_stuName" value="${querycon.stuName}">
           <p class="short-input ue-clear">
                    <label>EMS编号：</label>
                    	<input type="text" placeholder="请输入EMS编号" name="postinfo.emsno"class="strutsinput noNull" value="${postinfo.emsno}"/> 
                    <label>北理工编号：</label>
                        <input type="text" placeholder="请输入北理工编号" name="postinfo.schoolNo" class="strutsinput noNull" value="${postinfo.schoolNo}"/> 
                </p>
                <p class="short-input ue-clear">
                    <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                       <input  type="text" placeholder="请输入姓名" name="postinfo.stuName" class="strutsinput noNull" value="${postinfo.stuName}"/>
                    <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                       <input  type="text"  placeholder="请输入学号" name="postinfo.studentNo" value="${postinfo.studentNo}"/>
                </p>
            <div class="short-input select ue-clear" > 
                    <label>专业名称：</label>
                    <input  hidden="hidden" value="${postinfo.major}" name="postinfo.major" class="noNull" value="${postinfo.major}"/>
                    <div class="select-wrap" >
                        <div class="select-title " id="select-title2">
                        <span id="span2"><s:property value="postinfo.major"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
                        	<s:iterator value="#request.major" var="Major">
					      		<li id="<s:property value='#Major.ddlName'/>"><s:property value="#Major.ddlName"/></li>
					      	</s:iterator>
                        	 
                        </ul>
                    </div>
               </div> 
           
                <div class="short-input select ue-clear" >
			    	<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			    	<input  hidden="hidden" value="${postinfo.sex}" name="postinfo.sex" class="strutsinput noNull">
			        <div class="select-wrap">
			        	<div class=" select-title ue-clear" ><span ><s:property value="postinfo.sex"/></span><i class="icon"></i></div>
			            <ul class="select-list" >
			            	<li id="男">男</li>
			                <li id="女">女</li>
			            </ul>
			        </div>
			        
			        <label>派遣性质：</label>
                    <input  hidden="hidden" value="${postinfo.dispatchType}" name="postinfo.dispatchType" class="noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span><s:property value="postinfo.dispatchType"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
	                        <s:iterator value="#request.dispatchType" var="DispatchType">
						    	<li id="<s:property value='#DispatchType.ddlName'/>"><s:property value="#DispatchType.ddlName"/></li>
						    </s:iterator>  
                        </ul>
                    </div>                   
			    </div>
                <p class="short-input ue-clear">
                    <label>主管单位：</label>
                       <input  type="text" placeholder="请输入主管单位" name="postinfo.chargeUnit" class="strutsinput noNull" value="${postinfo.chargeUnit}"/>         
               		<label>邮件号：</label>
                       <input  type="text" placeholder="请输入邮件号" name="postinfo.mailNo" class="strutsinput noNull" value="${postinfo.mailNo}"/>         
                </p>
                <p class="short-input ue-clear">
	                <label>附加信息：</label>
	                        <textarea name="postinfo.memo"><s:property value="postinfo.memo"/></textarea>
                </p>
            </form>
        </div>
           

        <div class="btn ue-clear">
            <a href="javascript:add('myForm','post','${basePath}/postinfo/postinfo_editor.action')" class="confirm save">确定</a>
            <a href="javascript:back()" class="clear" onClick="reset()">返回</a>
        </div>
    </body>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
    <script type="text/javascript" src="../js/stustausinfo-reg.js"></script>
    <script type="text/javascript">
    showRemind('input[type=text], textarea','placeholder');

  
    </script>
</html>
