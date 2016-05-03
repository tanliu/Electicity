<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <%@include file="/common/header.jsp"%>
    <title>数据字典</title>

  </head>

<body>
<div class="title"><h2>数据字典维护</h2></div>
<form id="dateFrom" method="post">
<div class="query" >
	<div class="query-conditions ue-clear"  >
        <div class="conditions name ue-clear"   >
            <label>类型列表</label>
            <div class="select-wrap"  style="">
                <div class="select-title ue-clear"  id="test"><span>若添加新类型可以不选择</span><i class="icon"></i></div>
                
                <ul class="select-list">
                    <li>--请选择--</li>
                    <s:iterator value="#request.systemDlls" var="systemdll">
                    <li><s:property value="#systemdll.keyword"/></li>                    
                    </s:iterator>                    
                </ul>
            </div>
        </div>

    </div>
        <div id="addtype" class="conditions staff ue-clear">
            <label>类型名称：</label>
            <input type='text' id='type' name='systemDll.keyword'/>
        </div>
        <br>
        <br>
        <br>

</div>

<div class="table-operate ue-clear">
	<a id="addtable"  class="add">添加</a>
    
</div>
<div class="table-box" >
	<table id="edit_table" align="center">
    	<thead>
        	<tr>
            	<th  width="25%">编号</th>
                <th  width="50%">名称</th>
                <th  width="25%">操作</th>
            </tr>
        </thead>
        <tbody id="edit_tbody">
			<tr id="1">
				<td class="num">1</td>
				<td class="name" align='center'>
				<input type="text" value="" size="50" name="ddlNames" />
				<td class="operate" align='center'><a
					href="javascript:delTableRow(1);" class="del">删除</a></td>
			</tr>
        </tbody>
    </table>

</div>
 <div class="query-btn ue-clear" align="center">
        <a  class="confirm">保存</a> 
 </div>
 </form>
</body>
<script type="text/javascript" src="${basePath}js/WdatePicker.js"></script>
<script type="text/javascript">

var method="add";

//------------------------------点击添加时的js---------------------------------
$("#addtable").on("click",function(){
    var tempRow=$("table tbody tr").size();  //获取显示了多少
    
    var td=$("<td class='num'></td>");   //第一个列的代码
    td.html(tempRow+1);
    
    var $tdName = $("<td class='name' align='center'></td>");
	$tdName.html("<input name=\"ddlNames\" type=\"text\" size=\"50\" maxlength=25>");
	
	var $tdDel = $("<td class='operate' align='center'></td>");
	$tdDel.html("<a href='javascript:delTableRow(\""+(tempRow+1)+"\")' class='del'>删除</a>");
	
                   
    var tr=$("<tr id=\""+(tempRow+1)+"\" ></tr>");
    tr.append(td);
    tr.append($tdName);
    tr.append($tdDel);
    $("table tbody").append(tr);

})
//-----------------------------删除一行数据---------------------
function delTableRow(rowNum){
  
   var tempRow=$("table tbody tr").size();  //获取显示了多少
  // alert(rowNum);
   $("#"+rowNum).remove();
   //删除后更改编号
   for(var i=parseInt(rowNum)+1;i<tempRow+1;i++){
      $("#"+i+" .num").html(i-1);

      //更改删除的值
      $("#"+i+" .operate").html("<a href='javascript:delTableRow(\""+(i-1)+"\")' class='del'>删除</a>");
            //更改tr的id
      $("#"+i).attr("id",(i-1));//将id设置成i-1
      
      
   }
   
}
//---------------------------判断输入的类型名称是否为空-----------------------------
$("#addtype input").blur(function(){
  var inputval=$(this).val();  
  if(inputval!=""){
    $(".select-list li").each(function(){
       if(inputval==$(this).text()){
         alert("您填入的数据在选择项中已经存在！");
         $("#addtype input").val("");
         $("#addtype input").focus();         
         return false;
       }
     });
    
  }


});

//----------------------------------校验填入的数据是否合理-------------------------
$(".confirm").on("click",function(){
    var keyword=$("#type").val();
    
    if(keyword==""){  //判断类型名称是否正确
       alert("请输入或选择类型名称");
       return false;   //退出
    }
   
    var tempRow=$("table tbody tr").size();  //获取显示了多少
    var size=parseInt(tempRow);
    //判断数据项是否为空同时也去除表格
    $("tr td input").each(function() {
        var text=$(this).val();
        text=text.replace(/\s+/g,"");  
        if(text==""){
          alert("输入的名称中有空的！");
        }else{
          $(this).val(text);
        }   
    	return true;
    })
    //判断是否有重复的
    for(var i=1;i<size;i++){
        var name1=$("#"+i+" td input").val();
       for(var j=i+1;j<size+1;j++){           
           var name2=$("#"+j+" td input").val();
           if(name1==name2){
             alert("编号为"+i+"和"+j+"名称重复！");
             $("#"+j).focus();
             return false;
           }
       }
    
    }
    
    if(method=="add"){
       $("#dateFrom").attr("action","${basePath}system/systemddl_add.action");
    }else if(method="editor"){
       $("#dateFrom").attr("action","${basePath}system/systemddl_editor.action");
    }
    
    $("#dateFrom").submit();



});


//---------------------------选择数据------------------------
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
	var idname=$(this).parent($(".select-list")).siblings($(".select-title")).attr("id");
	$("#type").remove();
	if("--请选择--"==txt){  //如果内容是“--请选择--”，则显示类型输入框 
	    method="add";
	  	var $input=$("<input type='text' id='type' name='systemDll.keyword'/>");
	    $("#addtype").append($input);
	    $("#addtype").show();
	}else{
	   method="editor";
	   $("#addtype").hide();
	   var $input=$("<input type='text' id='type' name='systemDll.keyword'/>");
	   //设置input中的值
	    $(this).parent().parent().append($input);
	    $("#type").val(txt);
	    $("#type").hide();
	   /* $(this).parent().parent().next("input").val(txt);
	    $(this).parent().parent().next("input").hide(); */
	    //获取数据字典的代码

	}
	 $.ajax({
	        url:"${basePath}system/systemddl_editorUI.action",
	    	data:{"systemDll.keyword":txt},
	    	type:"post",
	    	//dataType:"json",//返回数据类型
	    	success: function(data){
	    	   $("#edit_tbody").remove();
	    	   $("#edit_table").append(data);
	    	},
	        error:function(){alert("失败！");}
	    
	    });


})

$('.pagination').pagination(100,{
	callback: function(page){
		alert(page);	
	},
	display_msg: true,
	setPageNo: true
});

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
