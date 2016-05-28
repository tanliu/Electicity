<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/base.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<link rel="stylesheet" href="${basePath}css/alter.css" />
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>
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
                <div class="select-title ue-clear"><span>请选择</span><i class="icon"></i></div>
                <ul class="select-list">
                <li id="">请选择</li>
                    <li id="1">1</li>
                    <li id="2">2</li>
                </ul>
            </div>       
        </div>
       
        <div class="conditions staff ue-clear" >
            <label>学号：</label>
            <input type="text" placeholder="请输入学生学号进行查询" style="width:223px"/>
    </div>
  
   </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
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
			 <th  width="5%"><input type="checkbox" id="selAll" class="checkall" onclick="doSelectAll()"/></th>
            	<th width="16%" class="num">用户编号</th>
				<!-- <th class="class">上级机构</th> -->
                <th width="15%" >用户名称</th>
				<th width="15%" >所属机构</th>
				<th width="8%" align="center">联系人电话</th>
				<th width="8%" >用户类型</th>
				<th width="8%" align="center">性别</th>
				<th width="8%" >状态</th>
				<th width="5%">编辑</th>				
            </tr>
        </thead>
        <tbody>
           <s:iterator value="pageUtils.items" var="user">
        	<tr>
			 <td class="num"><input type="checkbox" name="selectedRow" value='<s:property value='#user.userId'/>' /></td>
            	<td><a href="javascript:detail('<s:property value='#user.userId'/>')"><s:property value="#user.employNo"/></a></td>
				<td ><s:property value="#user.employName"/></td>
				<td><s:property value="#user.organization.orgName"/></td>
				<td><s:property value="#user.tell"/></td>
				<td><s:property value="#user.userType"/></td>
				<td><s:property value="#user.sex? '男':'女'"/></td>
				<td><s:property value="#user.status? '激活':'关闭' "/></td>
				<td><a href="javascript:editor('<s:property value='#user.userId'/>')"><img src="../images/edtico.png"/></a></td>
            </tr> 
            </s:iterator>          
        </tbody>
    </table>
</div>
<jsp:include page="/common/pagination.jsp"></jsp:include>

</body>


</html>
