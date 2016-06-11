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
        <div class="title"><h2>增加学生档案邮寄信息</h2>
        </div>
        <div class="main">
            <form id="myForm">
             <p class="short-input ue-clear">
                    <label>EMS编号：</label>
                    	<input type="text" placeholder="请输入EMS编号" name="postinfo.emsno"class="strutsinput noNull"/> 
                    <label>北理工编号：</label>
                        <input type="text" placeholder="请输入北理工编号" name="postinfo.schoolNo" class="strutsinput noNull"/> 
                </p>
                <p class="short-input ue-clear">
                    <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                       <input  type="text" placeholder="请输入姓名" name="postinfo.stuName" class="strutsinput noNull"/>
                    <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                       <input  type="text"  placeholder="请输入学号" name="postinfo.studentNo"/>
                </p>
            <div class="short-input select ue-clear" > 
                    <label>专业名称：</label>
                    <input  hidden="hidden" value="" name="postinfo.major" class="noNull"/>
                    <div class="select-wrap" >
                        <div class="select-title " id="select-title2">
                        <span id="span2">请选择</span><i class="icon"></i>
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
			    	<input  hidden="hidden" value="" name="postinfo.sex" class="strutsinput noNull">
			        <div class="select-wrap">
			        	<div class=" select-title ue-clear" ><span >请选择</span><i class="icon"></i></div>
			            <ul class="select-list" >
			            	<li id="男">男</li>
			                <li id="女">女</li>
			            </ul>
			        </div>
			        
			        <label>派遣性质：</label>
                    <input  hidden="hidden" value="" name="postinfo.dispatchType" class="noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span>请选择</span><i class="icon"></i>
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
                       <input  type="text" placeholder="请输入主管单位" name="postinfo.chargeUnit" class="strutsinput noNull"/>         
               		<label>邮件号：</label>
                       <input  type="text" placeholder="请输入邮件号" name="postinfo.mailNo" class="strutsinput noNull"/>         
                </p>
                <p class="short-input ue-clear">
	                <label>附加信息：</label>
	                        <textarea name="postinfo.memo"></textarea>
                </p>
            </form>
        </div>

        <div class="btn ue-clear">
            <a href="javascript:add('myForm','post','${basePath}/postinfo/postinfo_add.action')" class="confirm save">确定</a>
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