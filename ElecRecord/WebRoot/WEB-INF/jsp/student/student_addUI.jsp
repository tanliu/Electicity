<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/header_js.jsp"%>
<html>
<head>

<title>添加学生信息</title>

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
<script type="text/javascript" src="${basePath}js/jquery.validate.min.js"></script>
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
<body>

	<div class="title">
		<h2>增加学生个人基本信息</h2>
	</div>
	<form id="myForm">
		<div class="main">
			<p class="short-input ue-clear">
				<label>学号：</label>
				<s:textfield id="stuNO" name="student.studentNo" class="strutsinput noNull studentNo"></s:textfield>
				<label>姓名：</label>
				<s:textfield name="student.stuName" class="strutsinput noNull"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>身份证号码：</label>
				<s:textfield name="student.idCardNo" class="strutsinput noNull idCard"></s:textfield>
				<label>本人手机号码：</label>
				<s:textfield name="student.mobileNo" class="strutsinput noNull tell"></s:textfield>
			</p>

			<div class="short-input select ue-clear">
				<label>性别：</label>
				 <input type="hidden" class="noNull" value="男" name="student.sex">
				<div class="select-wrap">
					<div class="select-title " id="select-title1">
						<span id="span1">男</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list1">
						<li id="男">男</li>
						<li id="女">女</li>
					</ul>
				</div>
				<label>出生日期：</label>
				<div class="select-wrap">
					<input type="text" name="student.birthday"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="noNull" readonly="readonly" />
				</div>
			</div>
			<div class="short-input select ue-clear">
				<label>政治面貌：</label> <input type="hidden" class="noNull" value="党员"
					name="student.politicalStatus">
				<div class="select-wrap">
					<div class="select-title " id="select-title3">
						<span id="span3">群众</span><i class="icon"></i>
					</div>
					<ul class="select-list" id="list3">
						<li id="党员">党员</li>
						<li id="群众">群众</li>
						<li id="共青团员">共青团员</li>
					</ul>
				</div>
				<div class="select-wrap">
					<label>民族：</label>
					<s:textfield name="student.nation" class="strutsinput"></s:textfield>
				</div>
			</div>

			<p class="short-input ue-clear">
				<label>籍贯：</label>
				<s:textfield name="student.nativePlace" class="strutsinput"></s:textfield>
				<label>来源地区：</label>
				<s:textfield name="student.fromPlace" class="strutsinput"></s:textfield>
			</p>

			<p class="short-input ue-clear">
				<label>学院id：</label>
				<s:textfield name="student.orgId" class="strutsinput"></s:textfield>
				<label>学院名称：</label>
				<s:textfield name="student.orgName" class="strutsinput noNull"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>系：</label>
				<s:textfield name="student.department" class="strutsinput"></s:textfield>
				<label>专业：</label>
				<s:textfield name="student.major" class="strutsinput noNull"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>专业方向：</label>
				<s:textfield name="student.majorField" class="strutsinput"></s:textfield>
				<label>专业类别：</label>
				<s:textfield name="student.majorCategories" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>培育方向：</label>
				<s:textfield name="student.cultivateDirection" class="strutsinput"></s:textfield>
				<label>班级：</label>
				<s:textfield name="student.className" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>学制：</label>
				<s:textfield name="student.educationSystem" class="strutsinput"></s:textfield>
				<label>学习年限：</label>
				<s:textfield name="student.schoolingLength" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>入学日期：</label>
				<s:textfield name="student.acceptanceDate"  
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="true"
					class="strutsinput"></s:textfield>
				<label>毕业中学：</label>
				<s:textfield name="student.middleSchool" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>家庭电话：</label>
				<s:textfield name="student.familyTelNo" class="strutsinput"></s:textfield>
				<label>邮政编码：</label>
				<s:textfield name="student.postCode" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>乘车区间：</label>
				<s:textfield name="student.travelRange" class="strutsinput"></s:textfield>
				<label>家庭地址：</label>
				<s:textfield name="student.address" class="strutsinput"></s:textfield>
			</p>
			<p class="short-input ue-clear">
				<label>学籍状态：</label>
				<s:textfield name="student.schoolStatus" class="strutsinput"></s:textfield>
				<label>dqszj：</label>
				<s:textfield name="student.dqszj" class="strutsinput"></s:textfield>
			</p>

			<p class="short-input ue-clear">
				<label>毕业审核标志：</label>
				<s:radio list="#{'Y':'通过','N':'没通过'}" name="student.graduateFlag"
					value="'Y'" cssStyle="width:35px;" />

				<label>导入校友会标志：</label>
				<s:radio list="#{'Y':'已导入','N':'未导入'}" name="student.alumniFlag"
					value="'Y'" cssStyle="width:45px;" />
			</p>

			<p class="short-input ue-clear">
				<label>自我描述：</label>
				<textarea name="student.selfDescription"></textarea>
			</p>
			<p class="short-input ue-clear">
				<label>特长：</label>
				<textarea name="student.skill"></textarea>
			</p>

			<p class="short-input ue-clear">
				<label>所获奖励：</label>
				<textarea name="student.awards"></textarea>
			</p>
<!-- ---------------学生家庭情况---------------------- -->
<fieldset style="width: 98%;">
<legend>学生家庭情况</legend>
<div class="table-operate ue-clear">
	<a id="addtable"  class="add">添加</a>
    
</div>
<div class="table-box" >
	<table id="edit_table" align="center">
    	<thead>
        	<tr  align="center">
            	<th  width="8%">称呼</th>
                <th  width="10%">家庭成员姓名</th>
                <th  width="10%">政治面貌</th>
                <th  width="10%">职务</th>
                <th  width="10%">电话号码</th>
                <th  width="15%">家庭成员单位</th>
                <th  width="15%">单位地址</th>
                <th  width="10%">邮政编码</th>
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
    tr.html("<td ><input style=\"width: 70%;\" type=\"text\" class=\"noNull \"  size=\"50\" name=\"family["+tempRow+"].relation\"/></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].name\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].politicalStatus\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].jobDuty\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].telNo\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].company\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].companyAddress\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"family["+tempRow+"].postCode\" /></td>"+				
	"<td class=\"operate\" align='center'><a href=\"javascript:delTableRow("+(tempRow+1)+");\" class=\"del\">删除</a></td>");                  

    $("table #edit_tbody").append(tr);

})
function delTableRow(rowNum){
  
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
    	//alert("---------");
     });

       //更改删除的值
      $("#edit_tbody #"+i+" .operate").html("<a href='javascript:delTableRow(\""+(i-1)+"\")' class='del'>删除</a>");
            //更改tr的id
      $("#edit_tbody #"+i).attr("id",(i-1));//将id设置成i-1 
      
      
   }
   
}

</script>
</fieldset>
<!-- ---------------学生学历情况---------------------- -->
<fieldset style="width: 98%;">
<legend>学生学历情况</legend>
<div class="table-operate ue-clear">
	<a href="javascript:addExperience()"  class="add">添加</a>
    
</div>
<div class="table-box" >
	<table id="edit_table" align="center">
    	<thead>
        	<tr  align="center">
            	<th  width="20%">学习期间</th>
                <th  width="20%">学校名称</th>
                <th  width="20%">担任职务</th>
                <th  width="15%">证明人</th>
                <th  width="5%">操作</th>
            </tr>
        </thead>
        <tbody id="edit_experience" >
        </tbody>
    </table>
</div>
<script type="text/javascript">
function addExperience(){
    var tempRow=$("table #edit_experience tr").size();  //获取显示了多少
    
    
    
    var tr=$("<tr id=\""+(tempRow+1)+"\" ></tr>");
    tr.html("<td ><input style=\"width: 70%;\" type=\"text\" class=\"noNull \"  size=\"50\" name=\"experiences["+tempRow+"].duration\"/></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"experiences["+tempRow+"].schoolName\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"experiences["+tempRow+"].duty\" /></td>"+
	"<td ><input style=\"width: 80%;\" type=\"text\"  size=\"50\" name=\"experiences["+tempRow+"].witness\" /></td>"+
	"<td class=\"operate\" align='center'><a href=\"javascript:delRow("+(tempRow+1)+");\" class=\"del\">删除</a></td>");                  

    $("table #edit_experience").append(tr);

}
function delRow(rowNum){
  
   var tempRow=$("table #edit_experience tr").size();  //获取显示了多少
  // alert(rowNum);
   var t= $("#edit_experience").children("#"+rowNum);
   t.remove();
   //删除后更改编号
 
   for(var i=parseInt(rowNum)+1;i<tempRow+1;i++){
     $("#edit_experience #"+i+" td input").each(function(){
    	 var test=$(this).attr("name");
    	 //更换
    	 var my=test.replace(/\d+/g, (i-2));
    	 $(this).attr("name",my);
    	//alert("---------");
     });

     //更改删除的值
     //alert("删除"+rowNum+"行把删除值"+i+"__>"+(i-1));
     var $index=$("#edit_experience").children("#"+i);
     $index.children(" .operate").html("<a href='javascript:delRow(\""+(i-1)+"\")' class='del'>删除</a>");
           //更改tr的id
     $index.attr("id",(i-1));//将id设置成i-1 
      
      
   }
   
}

</script>
</fieldset>
		</div>

		<div class="btn ue-clear">
<!-- 			<a
				href="javascript:test()"
				class="confirm save">确定</a> -->
			<a
				href="javascript:add('myForm','post','${basePath}student/student_add.action')"
				class="confirm save">确定</a>
						<a
				href="javascript:tolist('myForm','post','${basePath}student/student_listUI.action')"
				class="confirm clear">返回</a>
		</div>

	</form>


</body>

<script type="text/javascript">


function test(){
	$("#myForm").submit();
}


</script>


<script type="text/javascript">
	showRemind('input[type=text], textarea', 'placeholder');
	
	//----------------------------------------学生家庭情况-----------------------
	

	//--------------------------------------信息唯一性校验------------------------------
	function myonfocus() {
		window.setTimeout(function() {
			document.getElementById('stuNO').select();
		}, 0);
		$("#stuNO").focus();

	}

		$("input[name='student.studentNo']").blur(function() {
			var value = $(this).val();
			var url="${basePath}student/student_hasStudent.action";
 			$.ajax({
				url : url,
				data : {'student.studentNo':value},
				type : "post",
				//dataType:"json",//返回数据类型
				success : function(data) {
                   if(data=="1"){
                	   alert("些学号已经存，请重新输入！");
                	  myonfocus() 
                   }else{
                	   
                   }
				},
				error : function() {
					alert("失败！");
				}

			});  

		});

</script>
</html>