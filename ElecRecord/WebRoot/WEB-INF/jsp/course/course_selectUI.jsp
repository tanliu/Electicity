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
<script type="text/javascript">
//使用pagination.jsp的这个命名是规定死的

	var queryAction="${basePath}course/course_selectUI.action?course.id=${course.id}";
	var importUrl="${basePath}course/course_importGradeExcel.action";
</script>
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
	<s:hidden name="course.id" ></s:hidden>
		<div class="main">
		<!-- ---------------学生家庭情况---------------------- -->
<div class="table-operate ue-clear">
	<a id="addtable"  class="add">添加</a>
	<a href="javascript:" class="import clear clear">导入成绩</a>
    
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
                <s:iterator value="grades" var="fam"  status="num">
        <tr id="<s:property value='#num.count'/>">
        <td ><input style="width: 70%;" type="text" value="<s:property value='#fam.studentNo'/>" class="noNull"  size="50" name="grades[${num.count-1}].studentNo"/></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.stuName'/>" size="50" name="grades[${num.count-1}].stuName" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.orgName'/>" size="50" name="grades[${num.count-1}].orgName" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.className'/>" size="50" name="grades[${num.count-1}].className" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.major'/>" size="50" name="grades[${num.count-1}].major" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.usualScore'/>" size="50" name="grades[${num.count-1}].usualScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.middleScore'/>" size="50" name="grades[${num.count-1}].middleScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.endScore'/>" size="50" name="grades[${num.count-1}].endScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.labScore'/>" size="50" name="grades[${num.count-1}].labScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.finalScore'/>" size="50" name="grades[${num.count-1}].finalScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.convertScore'/>" size="50" name="grades[${num.count-1}].convertScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.resitScore'/>" size="50" name="grades[${num.count-1}].resitScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.resitMemo'/>" size="50" name="grades[${num.count-1}].resitMemo" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.retakeFlag'/>" size="50" name="grades[${num.count-1}].retakeFlag" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.repairScore'/>" size="50" name="grades[${num.count-1}].repairScore" /></td>
	    <td ><input style="width: 80%;" type="text" value="<s:property value='#fam.gradePoint'/>" size="50" name="grades[${num.count-1}].gradePoint" /></td>			
	    <td hidden="true" ><input style="width: 80%;" type="text" value="<s:property value='#fam.createTime'/>" size="50" name="grades[${num.count-1}].createTime" /></td>			
	    <td hidden="true" ><input style="width: 80%;" type="text" value="<s:property value='#fam.creator'/>" size="50" name="grades[${num.count-1}].creator" /></td>			
	    <td hidden="true" ><input id="grades<s:property value='#num.count'/>" style="width: 80%;" type="text" value="<s:property value='#fam.id'/>" size="50" name="grades[${num.count-1}].id" /></td>			
	    <td class="operate" align='center'><a href="javascript:delTableRow('<s:property value='#num.count'/>');" class="del">删除</a></td>
        
        </tr>
        </s:iterator>
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
  
    var inputId=$("#grades"+rowNum);
    if(typeof(inputId.val()) !== 'undefined'){
     var $input=$("<input type=\"text\" hidden='true' name=\"gradesIds\" value="+inputId.val()+">");
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
  	 
  	 var alterinputId=$("#grades"+i).attr("id");
  	 //更改id
       if(typeof(alterinputId) !== 'undefined'){
      	 $("#grades"+i).attr("id","grades"+(i-1));
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


		<div class="btn ue-clear">
			<a
				href="javascript:editor('myForm','post','${basePath}course/course_updateSelect.action')"
				class="confirm save">确定</a>
		</div>
		<script type="text/javascript">
		
		function editor(formID,type,url){
			
			var nullEL=isNull();
			//判断是否为空
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"不可以为空");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return;
			}
			nullEL=isEmail();
			//判断是否是Email
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"格式不对");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return ;
			}
			//判断是否是电话号码
			nullEL=isTell();
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"输入正确的手机号码！");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return ;
			}
			//判断是否学号
			nullEL=isStuNo();
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"输入的学号不正确！");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return ;
			}
			//判断是否身份证
			nullEL=isidCard();
			if(typeof(nullEL) != "undefined"){
				alert(nullEL.prev("label").text()+"输入的身份证号不正确！");
				nullEL.prev("label").addClass("warn");//提示
				nullEL.focus();
				return ;
			}
			alert(url);
			if(typeof(nullEL) == "undefined"){//表示没有空的提示信息（表示通过）
				$.ajax({
		        url:url,
		    	data:$("#"+formID).serialize(),
		    	type:type,
		    	async:false,
		    	//dataType:"json",//返回数据类型
		    	success: function(data){
		    	   if(data!=null){
                     alert("保存成功！");
                     window.close();
		    	   }
		    	},
		        error:function(){alert("失败！");}
		    
		    });
			}


		}
		
		</script>

</div>

	</form>
	<script type="text/javascript" src="${basePath}js/core.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.dialog.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-form.js"></script>
	<jsp:include page="/common/inputdialog.jsp"></jsp:include>


</body>


</html>