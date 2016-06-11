/**
 * 创建人：谭柳
 * 文件描述：系统用到的校验器
 */

/**
 * 判断是否输入框是否是空的
 */
function isNull(){
	var warn;//当数据为空时，就返回对象，不为空是返回undefined
	  //查找到所有指定非空的属性
	  $(".noNull").each(function(i){ 
		  //获取指定非空的属性的值
		   var txt=$(this).val();
		   txt=txt.trim();
		   if(txt==""){//当值为空时
			  /*var $label=$(this).prev("label").text();//获取输入框前一个label的名称
			  $label=$label.replace("：","");
			  warn=$label+"不可以为空";	*/	
			  warn=$(this);
			  return false;
		   }
		 });
	  return warn;
}
/**
 * 判断输入框信息是内容是否符合Email格式
 */

function isEmail(){
	var re=/\w@\w*\.\w/;  //表达式中不可以加双引号
	var warn;//当email不正常时，就返回对象，正常时是返回undefined
	  //查找到所有指定非空的属性
	  $(".email").each(function(i){ 
		  //获取指定非空的属性的值
		   var txt=$(this).val();
		   if(txt!=""&&!re.test(txt)){//当值为空时
			  warn=$(this);
			  return false;
		   }
		 });
	  return warn;
}
/**
 * 判断输入框信息是内容是否符合电话的格式
 */
function isTell(){
	var warn;//当电话号码不符合时，就返回对象，正常时是返回undefined
	var retell=/^0\d{2,3}-?\d{7,8}$/; //表达式中不可以加双引号
	var rephone= /^1\d{10}$/; //表达式中不可以加双引号
    $(".tell").each(function(i){ //获取指定非空的属性的值
    	var txt=$(this).val();
    	if(txt!=""&&!rephone.test(txt)&&!retell.test(txt)){
    		warn=$(this);
    		return false;
    		}
    	});
	
	return warn;
}
/**
 * 判断输入框信息是学生学号
 */
function isStuNo(){
	var warn;//当电话号码不符合时，就返回对象，正常时是返回undefined
	var retell=/^\d{12}$/; //表达式中不可以加双引号
	$(".studentNo").each(function(i){ //获取指定非空的属性的值
		var txt=$(this).val();
		if(txt!=""&&!retell.test(txt)){
			warn=$(this);
			return false;
		}
	});
	
	return warn;
}
/**
 * 判断输入框信息是身份证信息
 */
function isidCard(){
	var warn;//当电话号码不符合时，就返回对象，正常时是返回undefined
	var retell=/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/; //表达式中不可以加双引号
	$(".idCard").each(function(i){ //获取指定非空的属性的值
		var txt=$(this).val();
		if(txt!=""&&!retell.test(txt)){
			warn=$(this);
			return false;
		}
	});
	
	return warn;
}