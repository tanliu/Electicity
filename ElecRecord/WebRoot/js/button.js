/**
 * 创建人:谭柳
 * 描述：对button事件的回应方法
 */

function add(formID,type,url){
	
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
	
	if(typeof(nullEL) == "undefined"){//表示没有空的提示信息（表示通过）
/*		$.ajax({
        url:url,
    	data:$("#"+formID).serialize(),
    	type:type,
    	async:false,
    	//dataType:"json",//返回数据类型
    	success: function(data){

    	},
        error:function(){alert("失败！");}
    
    });*/
		
		$("#"+formID).attr("method",type);
		$("#"+formID).attr("action",url);
		$("#"+formID).submit();
	}


}
function editor(formID,type,url){	
	add(formID,type,url);
	
}
function editor1(formID,type,url){	
	add(formID,type,url);
	
}

function back(){
	history.go(-1);
}

function tolist(formID,type,url){
	$("#"+formID).attr("method",type);
	$("#"+formID).attr("action",url);
	$("#"+formID).submit();
}


