<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />

        <title>学生电子档案管理系统</title>
    </head>

    <body>
        <div class="title"><h2>学科竞赛信息编辑</h2>
        </div>
   		
	   
		
        <div class="main">
            <form id="myForm">
            	<input hidden="hidden" name="subjectcontest.id" value="${subjectcontest.id}"/>
               <input hidden="hidden"  name="subjectcontest.stuId" value="${subjectcontest.stuId}"/>
               	 <input hidden="hidden"  name="subjectcontest.createTime" value="${subjectcontest.createTime}"/>
             <input hidden="hidden"  name="subjectcontest.creator" value="${subjectcontest.creator}"/>
               	   <!-- 将listUI传过来的查询条件赋值 -->
	    <input type="hidden" name="query_studentNo" value="${querycon.studentNo}">
	    <input type="hidden" name="query_stuName" value="${querycon.stuName}">
	    <input type="hidden" name="query_grantUnits" value="${querycon.grantUnits}">
	    <input type="hidden" name="query_rewardName" value="${querycon.rewardName}">
                <p class="short-input ue-clear">
                    <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    	<input type="text" readonly="readonly" name="subjectcontest.studentNo"  value="${subjectcontest.studentNo}" class="strutsinput noNull"/> 
                    <label>获奖者姓名：</label>
                        <input type="text" readonly="readonly" name="subjectcontest.stuName" value="${subjectcontest.stuName}" class="strutsinput noNull"/>  
                </p>
                <p class="short-input ue-clear">
                    <label>奖励名称：</label>
                        <input type="text" placeholder="请输入奖励名称" name="subjectcontest.rewardName" value="${subjectcontest.rewardName}" class="strutsinput noNull"/> 
                    <label>获奖项目：</label>
                        <input type="text" placeholder="请输入获奖项目" name="subjectcontest.rewardProject" value="${subjectcontest.rewardProject}" class="strutsinput noNull"/> 
                </p>
                <div class="short-input select ue-clear" >
                    <label>奖励等级：</label>
                    <input  hidden="hidden" value="<s:property value="subjectcontest.rewardGrade"/>" name="subjectcontest.rewardGrade" class="strutsinput noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span id="span1"><s:property value="subjectcontest.rewardGrade"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
	                        <s:iterator value="#request.rewardGrade" var="rewardGrade">
						    	<li id="<s:property value='#rewardGrade.ddlName'/>"><s:property value="#rewardGrade.ddlName"/></li>
						    </s:iterator>  
                        </ul>
                    </div>

                    <label>奖励级别：</label>
                    <input  hidden="hidden" value="<s:property value="subjectcontest.rewardLevel"/>" name="subjectcontest.rewardLevel" class="strutsinput noNull"/>
                    <div class="select-wrap" >
                        <div class="select-title " id="select-title2">
                        <span id="span2"><s:property value="subjectcontest.rewardLevel"/></span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
                        	<s:iterator value="#request.rewardLevel" var="rewardLevel">
					      		<li id="<s:property value='#rewardLevel.ddlName'/>"><s:property value="#rewardLevel.ddlName"/></li>
					      	</s:iterator>                       	 
                        </ul>
                    </div>
                </div>
                <p class="short-input ue-clear">
                  <label>授予单位：</label>
                       <input  type="text" placeholder="请输入授予单位" name="subjectcontest.grantUnits" value="${subjectcontest.grantUnits}"/>
                  <label>指导老师：</label>
                       <input  type="text"  placeholder="请输入指导老师" name="subjectcontest.guidTeacher" value="${subjectcontest.guidTeacher}"/>
                </p>             
                   
                <p class="short-input ue-clear">
                 <label>奖励时间：</label>   
                        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="subjectcontest.rewardDate" value="<s:date name="subjectcontest.rewardDate" format="yyyy-MM-dd"></s:date>" class="strutsinput noNull"/>       
                 <label>附加信息：</label>
                        <textarea name="subjectcontest.memo"><s:property value="subjectcontest.memo"/></textarea>
                </p>
            </form>
        </div>

        <div class="btn ue-clear">
            <a href="javascript:editor('myForm','post','${basePath}/subjectcontest/subjectcontest_editor.action')" class="confirm save">确定</a>
            <a href="javascript:;" class="clear" onClick="reset()">清空内容</a>
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