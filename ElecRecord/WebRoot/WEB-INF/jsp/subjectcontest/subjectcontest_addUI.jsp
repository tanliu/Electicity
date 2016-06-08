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
        <div class="title"><h2>学科竞赛信息增加</h2>
        </div>
        <div class="main">
            <form id="myForm">
            <input hidden="hidden"  name="subjectcontest.stuId" value="00001"/>
                <p class="short-input ue-clear">
                    <label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    	<input type="text" placeholder="请输入学生学号" name="subjectcontest.studentNo"class="strutsinput noNull"/> 
                    <label>获奖者姓名：</label>
                        <input type="text" placeholder="请输入学生姓名" name="subjectcontest.stuName" class="strutsinput noNull"/> 
                </p>
                <p class="short-input ue-clear">
                    <label>奖励名称：</label>
                        <input type="text" placeholder="请输入奖励名称" name="subjectcontest.rewardName" class="strutsinput noNull"/> 
                    <label>获奖项目：</label>
                        <input type="text" placeholder="请输入获奖项目" name="subjectcontest.rewardProject" class="strutsinput noNull"/> 
                </p>
                <div class="short-input select ue-clear" >
                    <label>奖励等级：</label>
                    <input  hidden="hidden" value="" name="subjectcontest.rewardGrade" class="noNull"/>
                    <div class="select-wrap">
                        <div class=" select-title" >
                        <span id="span1">请选择</span><i class="icon"></i>
                        </div>
                        <ul class="select-list">
	                        <s:iterator value="#request.rewardGrade" var="rewardGrade">
						    	<li id="<s:property value='#rewardGrade.ddlName'/>"><s:property value="#rewardGrade.ddlName"/></li>
						    </s:iterator>  
                        </ul>
                    </div>

                    <label>奖励级别：</label>
                    <input  hidden="hidden" value="" name="subjectcontest.rewardLevel" class="noNull"/>
                    <div class="select-wrap" >
                        <div class="select-title " id="select-title2">
                        <span id="span2">请选择</span><i class="icon"></i>
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
                       <input  type="text" placeholder="请输入授予单位" name="subjectcontest.grantUnits" class="strutsinput noNull"/>
                    <label>指导老师：</label>
                       <input  type="text"  placeholder="请输入指导老师" name="subjectcontest.guidTeacher"/>
                </p>

                <p class="short-input ue-clear">
                    <label>奖励时间：</label>   
                        <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" name="subjectcontest.rewardDate" class="strutsinput noNull"/>             
               		<label>附加信息：</label>
                        <textarea name="subjectcontest.memo"></textarea>
                </p>
            </form>
        </div>

        <div class="btn ue-clear">
            <a href="javascript:add('myForm','post','${basePath}/subjectcontest/subjectcontest_add.action')" class="confirm save">确定</a>
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