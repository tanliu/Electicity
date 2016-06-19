<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>添加开课信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${basePath}css/alter.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}css/jquery.dialog.css" />
<link rel="stylesheet" href="${basePath}css/WdatePicker.css" />

<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript"
	src="${basePath}js/jquery.validate.min.js"></script>
<style type="text/css">
table tbody tr td{
	 text-align: center;
}
table tbody tr{
	 text-align: center;
}
table thead tr th{
	 text-align: center;
}
</style>
</head>
<body style="width: 1360px;align: center;">

	<div class="title">
		<h2>增加开课信息</h2>
	</div>
	<form id="myForm">
		<div class="main">
		<!-- ---------------学生家庭情况---------------------- -->
<div class="table-operate ue-clear">
	<a id="addtable"  class="add">添加</a>
    
</div>
<div class="table-box" >
	<table id="edit_table" align="center">
    	<thead>
        	<tr  align="center">
            	<th  width="8%">学号</th>
                <th  width="6%">姓名</th>
                <th  width="6%">学院名称</th>
                <th  width="6%">班级</th>
                <th  width="6%">专业</th>
                <th  width="4%">平时成绩</th>
                <th  width="4%">期中成绩</th>
                <th  width="4%">期末成绩</th>
                <th  width="4%">实验成绩</th>
                <th  width="4%">总评成绩</th>
                <th  width="4%">折算成绩</th>
                <th  width="4%">补考成绩</th>
                <th  width="10%">补考成绩备注</th>
                <th  width="4%">重修标记</th>
                <th  width="4%">重修成绩</th>
                <th  width="4%">绩点</th>
                <th  width="5%">操作</th>
            </tr>
        </thead>
        <tbody id="edit_tbody" >
        </tbody>
    </table>
</div>
<script type="text/javascript">
$("#addtable").on("click",function(){
    var tempRow=$("table #edit_tbody tr").size();  //获取显示了多少
    
    
    
    var tr=$("<tr id=\""+(tempRow+1)+"\" ></tr>");
    tr.html("<td ><input style=\"width: 70%;\" type=\"text\" class=\"noNull \"  size=\"50\" name=\"grades["+tempRow+"].studentNo\"/></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].stuName\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].orgName\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].className\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].major\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].usualScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].middleScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].endScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].labScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].finalScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].convertScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].resitScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].resitMemo\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].retakeFlag\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].repairScore\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"grades["+tempRow+"].gradePoint\" /></td>"+				
	"<td class=\"operate\" align='center'><a href=\"javascript:delTableRow("+(tempRow+1)+");\" class=\"del\">删除</a></td>");                  

    $("table #edit_tbody").append(tr);

})
function delTableRow(rowNum){
  
    var inputId=$("#family"+rowNum);
    if(typeof(inputId.val()) !== 'undefined'){
     var $input=$("<input type=\"text\" hidden='true' name=\"familyIds\" value="+inputId.val()+">");
     $("table #edit_tbody").append($input);   
 }   
 
 var tempRow=$("table #edit_tbody tr").size();  //获取显示了多少
// alert(rowNum);
 $("#edit_tbody #"+rowNum).remove();
 //删除后更改编号
 for(var i=parseInt(rowNum)+1;i<tempRow+1;i++){
   $("#edit_tbody #"+i+" td input").each(function(){
  	 var test=$(this).attr("name");
  	 
  	 //更换
  	 var my=test.replace(/\d+/g, (i-2));
  	 $(this).attr("name",my);
  	 
  	 var alterinputId=$("#family"+i).attr("id");
  	 //更改id
       if(typeof(alterinputId) !== 'undefined'){
      	 $("#family"+i).attr("id","family"+(i-1));
       }   
  	 
  	//alert("---------");
   });

     //更改删除的值
    $("#edit_tbody #"+i+" .operate").html("<a href='javascript:delTableRow(\""+(i-1)+"\")' class='del'>删除</a>");
          //更改tr的id
    $("#edit_tbody #"+i).attr("id",(i-1));//将id设置成i-1 
    
    
 }
   
}

</script>


</div>

	</form>


</body>


</html>