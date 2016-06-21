<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

<title>学生详细信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>

<center>
<h1>学生基本情况登记表</h1>
学院：<label>计算机学院</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
班级名称：<label>软件工程6班</label>
</center>
</br>
<table width="100%" border="1">
  <tr align="center" border="0">
    <td width="14%" height="10" >姓名</td>
    <td width="15%"><s:property value="student.stuName"/> </td>
    <td width="9%">性别</td>
    <td width="16%"><s:property value="student.sex"/></td>
    <td width="11%">身高</td>
    <td width="18%"><s:property value="student.stuName"/></td>
    <td width="17%" rowspan="5">照片</td>
  </tr>
  <tr align="center">
    <td>出生年月日</td>
    <td><s:date name="student.birthday" format="yyyyMMdd"/> </td>
    <td>民族</td>
    <td><s:property value="student.nation"/></td>
    <td>年级</td>
    <td><s:date name="student.acceptanceDate" format="yyyy"/></td>
  </tr>
  <tr align="center">
    <td>政治面貌</td>
    <td><s:property value="student.politicalStatus"/></td>
    <td>专业</td>
    <td colspan="3"><s:property value="student.major"/></td>
  </tr>
  <tr align="center">
    <td>身份证号</td>
    <td colspan="3"><s:property value="student.idCardNo"/></td>
    <td>本人手机</td>
    <td><s:property value="student.mobileNo"/></td>
  </tr>
  <tr align="center">
    <td>籍     贯</td>
    <td colspan="3"><s:property value="student.nativePlace"/></td>
    <td>家庭电话</td>
    <td><s:property value="student.familyTelNo"/></td>
  </tr>
  <tr align="center">
    <td>假期乘车区间</td>
    <td colspan="3"><s:property value="student.travelRange"/></td>
    <td>邮政编码</td>
    <td colspan="3"><s:property value="student.postCode"/></td>
  </tr>

  <tr align="center">
    <td>家庭详细地址</td>
    <td colspan="6"><s:property value="student.address"/></td>
  </tr>
  <tr align="center">
    <td height="110">特    长</td>
    <td colspan="6" align="left"><s:property value="student.skill"/></td>
  </tr>
  <tr align="center">
    <td height="112">自 我 描 述</td>
    <td colspan="6" align="left"><s:property value="student.selfDescription"/></td>
  </tr>
  <tr align="center">
    <td height="115">所 获 奖 励</td>
    <td colspan="6" align="left"><s:property value="student.awards"/></td>
  </tr>
  <!-- ---------------学习经历（从初中起）---------------------------- -->
  <tr align="center">
    <td colspan="7">学习经历（从初中起）</td>
  </tr>
  <tr align="center">
    <td>时 间</td>
    <td colspan="5">学校名称</td>
    <td>担任职务</td>
  </tr>
  <s:if test="experiences.size()>0">
  <s:iterator value="experiences" var="experience">
  <tr align="center">
    <td height="42"><s:property value="#experience.duration"/></td>
    <td colspan="5"><s:property value="#experience.schoolName"/></td>
    <td><s:property value="#experience.duty"/></td>
  </tr>
  </s:iterator>
  </s:if>
  <s:else>
  <tr align="center">
    <td height="42">&nbsp;</td>
    <td colspan="5">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </s:else>
  <tr align="center">
    <td colspan="7">家庭成员及主要社会关系</td>
  </tr>
  <tr align="center">
    <td>称呼</td>
    <td>姓    名</td>
    <td>政治面貌</td>
    <td>工作单位</td>
    <td>职 务</td>
    <td colspan="2">联系电话</td>
  </tr>
   <s:if test="family.size()>0">
  <s:iterator value="family" var="fam">
  <tr align="center">
    <td><s:property value="#fam.relation"/></td>
    <td><s:property value="#fam.name"/></td>
    <td><s:property value="#fam.politicalStatus"/></td>
    <td><s:property value="#fam.company"/></td>
    <td><s:property value="#fam.jobDuty"/></td>
    <td colspan="2"><s:property value="#fam.telNo"/></td>
  </tr>
  </s:iterator>
  </s:if>
  <s:else>
  <tr align="center">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  </s:else>
 
</table>


</body>


</html>