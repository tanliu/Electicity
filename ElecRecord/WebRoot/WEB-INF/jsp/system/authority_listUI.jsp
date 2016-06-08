<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<style type="text/css">
.leftdiv{
float:left;
width:15%; 
align:center;
padding: 10px 5px 10px 20px;
}
.rightdiv{
float:left;
width:71%;
padding: 18px 5px 10px 5px;
text-align:center;
}
frame{
	margin: 10px;
	padding: 20px;
}
</style>
</head>

<frameset id="test" name="test" cols="15%,75%">
  <frame src="${basePath}/system/authority_tree.action" id="privilige" name="privilige" frameborder="0" scrolling="no"></frame>
  <frameset rows="50%,50%">
  <frame style="padding-bottom: 0px;" src="${basePath}/system/authority_editorUI.action" id="editor" name="editor"  marginheight="" marginwidth="" frameborder="0" scrolling="yes">
  <frame style="padding-top: 5px;" src="${basePath}/system/authority_addUI.action" id="add" name="add" frameborder="0" scrolling="yes">
  </frameset>
</frameset> 



<script type="text/javascript" src="${basePath}js/tree/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function($){
	$("BODY").width($(window).width());
	$("#editor").height($(window).height()*0.92);
	$("#menu").height($(window).height()*0.92);
	$("#add").height($(window).height()*0.92);
	$("#editor").width($(window).width()*0.72);
	$("#menu").width($(window).width()*0.1);
	$("#add").width($(window).width()*0.72);

  $("#editor",parent.document.body).attr("src","http://www.jb51.net ") 
});


</script>
</HTML>
