<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<head>
    
<title>学生电子档案管理系统</title>
<link rel="stylesheet" href="${basePath}css/base.css" /> 
<link rel="stylesheet" type="text/css" href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/index.css" />
</head>
<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
        	<div class="top-light"></div>
            <h1 class="logo"></h1>
            <div class="login-info ue-clear">
                <div class="welcome ue-clear"><span>欢迎您,</span><a href="javascript:;" class="user-name">${user.employName}</a></div>
                <div class="login-msg ue-clear">
<!--                     <a href="javascript:;" class="msg-txt">消息</a>
                    <a href="javascript:;" class="msg-num">10</a> -->
                </div>
            </div>
            <div class="toolbar ue-clear">
                <a href="javascript:;" class="home-btn">首页</a>
                <a href="javascript:;" class="quit-btn exit"></a>
            </div>
        </div>
    </div>
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
                	<li class="office current"><div class="nav-header"><a href="javascript:;" date-src="${basePath}system/login_personInfo.action" class="ue-clear"><span>个人信息</span><i class="icon"></i></a></div></li>
<%--                 	<li class="office current"><div class="nav-header"><a href="javascript:;" date-src="info-reg.html" class="ue-clear"><span>系统管理</span><i class="icon"></i></a></div></li>
                    <li class="gongwen"><div class="nav-header"><a href="javascript:;" date-src="home.html"class="ue-clear"><span>用户管理</span><i class="icon"></i></a></div></li>
                    <li class="nav-info">
                    	<div class="nav-header"><a href="javascript:;" class="ue-clear"><span>导航信息管理</span><i class="icon"></i></a></div>
                        <ul class="subnav">
                        	<li><a href="javascript:;" date-src="info-reg.html">信息录入</a></li>
                            <li><a href="javascript:;" date-src="info-mgt.html">信息管理</a></li>
                            <li><a href="javascript:;" date-src="info-det.html">领导值岗管理</a></li>
                            <li><a href="javascript:;">中层领导管理</a></li>
                            <li><a href="javascript:;">领导值班记录</a></li>
                        </ul>
                    </li>
                    <li class="konwledge"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>知识管理</span><i class="icon"></i></a></div></li>
                    <li class="agency"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>组织结构</span><i class="icon"></i></a></div></li>
                    <li class="email"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>邮件管理</span><i class="icon"></i></a></div></li>
                    <li class="system"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>系统管理</span><i class="icon"></i></a></div></li>
                 --%></ul>
            </div>
            <div class="content">
            	<iframe src="${basePath}system/login_personInfo.action" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
            </div>
        </div>
    </div>
    <div id="ft" class="ue-clear">
    	<div class="ft-left">
            <span>北京理工大学珠海学院</span>
            <em>Office&nbsp;System</em>
        </div>
        <div class="ft-right">
            <span>Automation</span>
            <em>V2.0&nbsp;2016</em>
        </div>
    </div>
</div>

<div class="exitDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        
    </div>
</div>
<script type="text/javascript" src="${basePath}js/jquery.js"></script>
<script type="text/javascript" src="${basePath}js/common.js"></script>
<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/index.js"></script>
<script type="text/javascript">
var treeData =[
     	];

$(function(){
	
	$.ajax({
		url:"${basePath}system/login_menu.action",
		type:"post",
		dataType:"json",//返回数据类型
    	success: function(data){
    		
    		if(data!=null){
    		
    		var dataObj=eval(data);//转换为json对象

            //把数据输入到Znodes
    		for(var i=0;i<dataObj.length;i++){
	    		var val = {id:dataObj[i].authorityId, pId:dataObj[i].parentId, name:dataObj[i].authorityName,url:dataObj[i].url};
	    		treeData.push(val); 
    		}
    		}
    		
    		createMenu(treeData,'${basePath}'); 

    	},
        error:function(){alert("失败！");}
		
	});
	


});
</script>
</body>

</html>