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
        <div class="title"><h2>编辑学生职务信息</h2>
        </div>
        <div class="main">
            <form id="myForm">
            <input hidden="hidden"  name="studentdutys.id" value="${studentdutys.id}"/>
             <input hidden="hidden"  name="studentdutys.stuId" value="${studentdutys.stuId}"/>
             <input hidden="hidden"  name="studentdutys.studentNo" value="${studentdutys.studentNo}"/>
                      	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_grade" value="${querycon.grade}">
	    <input type="hidden" name="query_college" value="${querycon.college}">
	    <input type="hidden" name="query_className" value="${querycon.className}">
	    <input type="hidden" name="query_duty" value="${querycon.duty}">
            
            <div class="short-input select ue-clear" >
                    <label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
                    <input  hidden="hidden"  name="studentdutys.grade" value="${studentdutys.grade}" class="noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span id="span1"><s:property value="studentdutys.grade"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
	                        <s:iterator value="#request.Grade" var="Grade">
						    	<li id="<s:property value='#Grade.ddlName'/>"><s:property value="#Grade.ddlName"/></li>
						    </s:iterator>  
                        </ul>
                    </div>

                    <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院：</label>
                    <input  hidden="hidden" value="${studentdutys.college}" name="studentdutys.college" class="noNull"/>
                    <div class="select-wrap" >
                        <div class="select-title " id="select-title2">
                        <span id="span2"><s:property value="studentdutys.college"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
                        	<s:iterator value="#request.College" var="College">
					      		<li id="<s:property value='#College.ddlName'/>"><s:property value="#College.ddlName"/></li>
					      	</s:iterator>
                        	 
                        </ul>
                    </div>
                </div>
                
                <p class="short-input ue-clear">
                    <label>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
                    	<input type="text" placeholder="请输入班级" name="studentdutys.ClassName" value="${studentdutys.className}" class="strutsinput noNull"/> 
                    <label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                        <input type="text" placeholder="请输入姓名" name="studentdutys.stuName" value="${studentdutys.stuName}" class="strutsinput noNull"/> 
                </p>
              
                <div class="short-input select ue-clear" >
			    	<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			    	<input  hidden="hidden" value="${studentdutys.sex}" name="studentdutys.sex" class="strutsinput noNull">
			        <div class="select-wrap">
			        	<div class=" select-title ue-clear" ><span><s:property value="studentdutys.sex"/></span><i class="icon"></i></div>
			            <ul class="select-list" >
			            	<li id="男">男</li>
			                <li id="女">女</li>
			            </ul>
			        </div>
			        
			        <label>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</label>
                    <input  hidden="hidden" value="${studentdutys.duty}" name="studentdutys.duty" class="noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span><s:property value="studentdutys.duty"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
	                        <s:iterator value="#request.Duty" var="Duty">
						    	<li id="<s:property value='#Duty.ddlName'/>"><s:property value="#Duty.ddlName"/></li>
						    </s:iterator>  
                        </ul>
                    </div>
                    
			    </div>

                    
                
                <p class="short-input ue-clear">
                    <label>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</label>
                       <input  type="text" placeholder="请输入手机号码" name="studentdutys.telNo" value="${studentdutys.telNo}" class="strutsinput noNull"/>
                    <label>短&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                       <input  type="text"  placeholder="请输入短号" name="studentdutys.shortTelNo" value="${studentdutys.shortTelNo}"/>
                </p>

                <p class="short-input ue-clear">
                    <label>宿&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;舍：</label>   
                        <input type="text" name="studentdutys.address" value="${studentdutys.address}"/>             
               		<label>附加信息：</label>
                        <textarea name="studentdutys.memo"><s:property value="studentdutys.memo"/></textarea>
                </p>
            </form>
        </div>

        <div class="btn ue-clear">
            <a href="javascript:add('myForm','post','${basePath}/studentdutys/studentdutys_editor.action')" class="confirm save">确定</a>
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
