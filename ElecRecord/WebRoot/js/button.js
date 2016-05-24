/**
 * 创建人:谭柳
 * 描述：对button事件的回应方法
 */

function add(formID,type,url){	
	 $.ajax({
	        url:url,
	    	data:$("#"+formID).serialize(),
	    	type:type,
	    	//dataType:"json",//返回数据类型
	    	success: function(data){
	    		alert("成功！");
	    	},
	        error:function(){alert("失败！");}
	    
	    });

}
function editor(formID,type,url){	
	$.ajax({
		url:url,
		data:$("#"+formID).serialize(),
		type:type,
		//dataType:"json",//返回数据类型
		async:false,
		success: function(data){
			alert("成功！");
		},
		error:function(){alert("失败！");}
		
	});
	
}

function back(){
	history.go(-1);
}
