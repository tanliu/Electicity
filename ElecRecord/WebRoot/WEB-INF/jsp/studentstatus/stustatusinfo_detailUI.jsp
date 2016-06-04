
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="/common/header_js.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${basePath}css/details.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />
<link rel="stylesheet" href="${basePath}css/info-reg.css" />
<link rel="stylesheet" href="${basePath}css/info-mgt.css" />
<script type="text/javascript" src="${basePath}js/jquery.js"></script>

<title>学籍异动信息</title>
</head>
	
<body>
<div class="title"><h2>学籍异动信息</h2></div>

<div class="table-box">
	<table>
        <tbody>
        	<tr>
             <td  class="colum" nowrap="nowrap">学号:</td><td class="colum1">${stuStatus.studentNo}</td>
            	 <td  class="colum" nowrap="nowrap">姓名:</td><td class="colum1">${stuStatus.stuName} </td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">性别:</td><td class="colum1"><s:property value="stuStatus.sex"/></td>
                  <td  class="colum" nowrap="nowrap">身份证号:</td><td class="colum1">${stuStatus.idCardNo}</td>
            </tr>
             <tr>
                  <td  class="colum" nowrap="nowrap">考生号:</td><td class="colum1">${stuStatus.examinateNo}</td>
            	 <td  class="colum" nowrap="nowrap">学生类别:</td><td class="colum1">${stuStatus.studentCategory}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">学年:</td><td class="colum1"><s:property value="stuStatus.academicYear"/></td>
                 <td  class="colum" nowrap="nowrap">学期:</td><td class="colum1"><s:property value="stuStatus.term"/></td>
            </tr>
              <tr>
               <td  class="colum" nowrap="nowrap">异动序号:</td><td class="colum1">${stuStatus.transactionNo}</td>
            	 <td  class="colum" nowrap="nowrap">异动结果 :</td><td class="colum1">${stuStatus.ydresult}</td>
            </tr>
            <tr>
            <td  class="colum" nowrap="nowrap">异动类别:</td><td class="colum1">${stuStatus.tansactionType}</td>
            	 <td  class="colum" nowrap="nowrap">异动原因:</td><td class="colum1"><s:property value="stuStatus.tansactionType"/></td>
                 
            </tr>
              <tr>
            	 <td  class="colum" nowrap="nowrap">异动时间:</td><td class="colum1"><s:date format="yyyy-MM-dd" name="stuStatus.tansactionDate"/></td>
                  <td  class="colum" nowrap="nowrap">行文时间:</td><td class="colum1"><s:date format="yyyy-MM-dd" name="stuStatus.handleDate"/></td>
            </tr>
          
               <tr>
            	 <td  class="colum" nowrap="nowrap">撤消时间:</td><td class="colum1"><s:date format="yyyy-MM-dd" name="stuStatus.cancelDate"/></td>
                  <td  class="colum" nowrap="nowrap">异动说明：</td><td class="colum1">${stuStatus.tansactionMemo}</td>
            </tr>
            
               <tr>
            	 <td  class="colum" nowrap="nowrap">操作人:</td><td class="colum1">${stuStatus.operator}</td>
                  <td  class="colum" nowrap="nowrap">操作时间：</td><td class="colum1"><s:date format="yyyy-MM-dd HH:mm:ss" name="stuStatus.operatorTime"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">处理文号:</td><td class="colum1">${stuStatus.processSymbols}</td>
                  <td  class="colum" nowrap="nowrap">转学前学校名称：</td><td class="colum1">${stuStatus.zxqschool}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">转学前所在年级:</td><td class="colum1"><s:property value="stuStatus.zxqgrade"/></td>
                  <td  class="colum" nowrap="nowrap">转学前专业：</td><td class="colum1"><s:property value="stuStatus.zxqmajor"/></td>
            </tr>
            
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动前学院:</td><td class="colum1"><s:property value="stuStatus.ydqcollege"/></td>
                  <td  class="colum" nowrap="nowrap">异动前系：</td><td class="colum1">${stuStatus.ydqdepartment}</td>
            </tr>
            
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动前专业:</td><td class="colum1"><s:property value="stuStatus.ydqmajor"/></td>
                  <td  class="colum" nowrap="nowrap">异动前学制：</td><td class="colum1"><s:property value="stuStatus.ydqlength"/></td>
            </tr>
            
            <tr>
            	 
                  <td  class="colum" nowrap="nowrap">异动前行政班：</td><td class="colum1">${stuStatus.ydqclassName}</td>
                  <td  class="colum" nowrap="nowrap">异动前专业方向:</td><td class="colum1">${stuStatus.ydqmajorField}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动前培养方向:</td><td class="colum1">${stuStatus.ydqcultivateDirection}</td>
                  <td  class="colum" nowrap="nowrap">异动前所在年级：</td><td class="colum1"><s:property value="stuStatus.ydqgrade"/></td>
            </tr>
               <tr>
            	 <td  class="colum" nowrap="nowrap">异动前专业代码:</td><td class="colum1">${stuStatus.ydqmajorCode}</td>
                 <td  class="colum" nowrap="nowrap">异动前专业类别:</td><td class="colum1">${stuStatus.ydqmajorCategory}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动前学籍状态:</td><td class="colum1"><s:property value="stuStatus.ydqschoolStatus"/></td>
                 <td  class="colum" nowrap="nowrap">异动前是否在校:</td><td class="colum1"><s:property value="stuStatus.ydqinSchool"/></td>
            </tr>
           
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动前是否注册:</td><td class="colum1"><s:property value="stuStatus.ydqisRegiste"/></td>
                 <td  class="colum" nowrap="nowrap">异动前学历层次:</td><td class="colum1"><s:property value="stuStatus.ydqeducation"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">转出后学校名称:</td><td class="colum1">${stuStatus.zchschool}</td>
                 <td  class="colum" nowrap="nowrap">转出后年级:</td><td class="colum1"><s:property value="stuStatus.zchgrade"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">转出后专业:</td><td class="colum1"><s:property value="stuStatus.zchmajor"/></td>
                 <td  class="colum" nowrap="nowrap">异动后学院:</td><td class="colum1"><s:property value="stuStatus.ydhcollege"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动后系:</td><td class="colum1">${stuStatus.ydhdepartment}</td>
                 <td  class="colum" nowrap="nowrap">异动后专业:</td><td class="colum1"><s:property value="stuStatus.ydhmajor"/></td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动后学制:</td><td class="colum1"><s:property value="stuStatus.ydhlength"/></td>
                 <td  class="colum" nowrap="nowrap">异动后行政班:</td><td class="colum1">${stuStatus.tansactionClass}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动后专业方向:</td><td class="colum1">${stuStatus.ydhmajorField}</td>
                 <td  class="colum" nowrap="nowrap">异动后培养方向:</td><td class="colum1">${stuStatus.ydhcultivatedirection}</td>
            </tr>
            <tr>
            	 <td  class="colum" nowrap="nowrap">异动后所在年级:</td><td class="colum1"><s:property value="stuStatus.ydhgrade"/></td>
                 <td  class="colum" nowrap="nowrap">异动后专业代码:</td><td class="colum1">${stuStatus.ydhmajorCode}</td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动后专业类别:</td><td class="colum1">${stuStatus.ydhmajorCategory}</td>
                 <td  class="colum" nowrap="nowrap">异动后学籍状态:</td><td class="colum1"><s:property value="stuStatus.ydhschoolStatus"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动后是否在校:</td><td class="colum1"><s:property value="stuStatus.ydhinSchool"/></td>
                 <td  class="colum" nowrap="nowrap">异动后是否注册:</td><td class="colum1"><s:property value="stuStatus.ydhisRegiste"/></td>
            </tr>
             <tr>
            	 <td  class="colum" nowrap="nowrap">异动后学历层次:</td><td class="colum1"><s:property value="stuStatus.ydheducation"/></td>
                 <td  class="colum" nowrap="nowrap">附加信息:</td><td class="colum1">${stuStatus.memo}</td>
            </tr>
        </tbody>
    </table>
    			 		  											
</div>
</body>

<script type="text/javascript">

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>

</html>
