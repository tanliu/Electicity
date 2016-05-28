<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />

<title>学生学籍异动信息</title>
</head>

<body>
<div class="title"><h2>学生学籍异动信息</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>学年：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span></span><i class="icon"></i></div>
                <ul class="select-list">
                    <li>2014-2015</li>
                    
                </ul>
            </div>
        </div>
        <div class="conditions operate-time ue-clear">
            <label>学期：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>1</span><i class="icon"></i></div>
                <ul class="select-list">
                    <li>1</li>
                    
                </ul>
            </div>
            
        </div>
       
        <div class="conditions staff ue-clear">
            <label>学号：</label>
            <input type="text" placeholder="请输入学生学号进行查询" />
        </div>
    </div>
    
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
        <a href="javascript:;" class="clear">清空条件</a> 
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="javascript:;" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
    
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="num">学号</th>
                <th class="name">姓名</th>
                <th class="process">性别</th>
                <th class="node">身份证号</th>
                <th class="time">考生号</th>
                <th class="operate">操作</th>
            </tr>
        </thead>
        <tbody>
        	<tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看详情</a></td>
            </tr>
            
        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>

<script type="text/javascript">


showRemind('input[type=text], textarea','placeholder');
</script>
</html>
