<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/home.css" />
<title>学生电子档案管理系统</title>
</head>

<body>
<div class="article toolbar">
	<div class="title ue-clear">
    	<h2>常用工具</h2>
        <a href="javascript:;" class="more">更多</a>
    </div>
    <div class="content">
    	<ul class="toollist ue-clear">
            <li>
            	<a href="javascript:;" class="img"><img src="images/icon03.png" /></a>
                <p><a href="javascript:;">密码修改</a></p>
            </li>
    	</ul>        
    </div>    
</div>
<div class="article half duty">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>登录情况</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
            	<thead>
                	<tr>
                    	<th width="33%" >登录日期</th>
                        <th width="33%">登录情况</th>
                        <th width="33%">登录ip</th>
                    </tr>
                </thead>
                <tbody>

                 <s:iterator value="logs" var="log">
                	<tr>
                	
                     	<td width="33%"><s:date name="#log.loginTime" format="MM-dd hh:mm:ss"/></td>
                        <td width="33%"><s:property value="#log.ifSuccess==1?'成功':'失败'"/> </td> 
                        <td width="33%"><s:property value="#log.loginIp"/> </td>
<!--                         <td class="contact">139039409876</td>
                        <td class="remark"></td> -->
                    </tr>
                   </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="article half email">
	<div class="wrap-r">
        <div class="title ue-clear">
            <h2>未读邮件</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
            	<thead>
                	<tr>
                    	<th class="icon"></th>
                        <th class="sender">发件人</th>
                        <th class="subject">主题</th>
                        <th class="time last-item">时间</th>
                    </tr>
                </thead>
                <tbody>
                	<tr class="tody">
                    	<td colspan="4"><div class="td-wrap"><em>今天</em><a href="javascript:;">(3封)</a></div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">办公室</div></td>
                        <td class="subject"><div class="td-wrap"><a href="javascript:;">关于移动所有工作人员薪资调整的说明文件</a></div></td>
                        <td class="time"><div class="td-wrap">22分钟前</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">行政部</div></td>
                        <td class="subject"><div class="td-wrap"><a href="javascript:;">行政廉洁形象建设工程要点会议纪要</a></div></td>
                        <td class="time"><div class="td-wrap">1小时前</div></td>
                    </tr>
                    <tr class="open">
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">局长</div></td>
                        <td class="subject"><div class="td-wrap"><a href="javascript:;">部门劳动节放假相关通知</a></div></td>
                        <td class="time"><div class="td-wrap">今天14:23</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">自贡水务</div></td>
                        <td class="subject"><div class="td-wrap"><a href="javascript:;">2014年度所有公务员征税政策文件下载</a></div></td>
                        <td class="time"><div class="td-wrap">今天10:23</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">办公室</div></td>
                        <td class="subject"><div class="td-wrap"><a href="javascript:;">关于移动所有工作人员薪资调整的说明文件</a></div></td>
                        <td class="time"><div class="td-wrap">22分钟前</div></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>