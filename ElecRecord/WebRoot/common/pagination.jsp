<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="pagination ue-clear">
<s:if test="pageUtils.items!=null">

<div class="goto"><span class="text">转到第</span><input  id="pageNo" type="text" value="${pageUtils.pageNo}" name="pageNO"><span class="page">页</span><a href="javascript:doGoPage()">转</a></div>
<div class="pagin-list" >
<!------------------------------ 当前页是第一页----------------------------------------->
<s:if test="1==pageUtils.pageNo">
<a class="current prev">&lt;&nbsp;上一页</a>
</s:if>
<s:else>
<a class="prev"  href="javascript:doNextorPrev('<s:property value="pageUtils.pageNo-1"/> ')">&lt;&nbsp;上一页</a>
</s:else>
<!------------------------------ 打印页码 ----------------------------------------->
<s:iterator  var="num" begin="1" end="pageUtils.totalPageCount">
<s:if test="#num==pageUtils.pageNo">
<span class="current">${num}</span>
</s:if>
<s:else>
<a href="javascript:doNextorPrev('${num}');">${num}</a>
</s:else>
</s:iterator>

<!------------------------------ 当前页是第一页----------------------------------------->
<s:if test="pageUtils.totalPageCount==pageUtils.pageNo">
<a class="current next" href="javascript:;">下一页&nbsp;&gt;</a>
</s:if>
<s:else>
<a class="next" href="javascript:doNextorPrev('<s:property value="pageUtils.pageNo+1"/> ')">下一页&nbsp;&gt;</a>
</s:else>

</div>
<div class="pxofy">显示第${(pageUtils.pageNo-1)*pageUtils.pageSize}条到&nbsp;${pageUtils.pageNo*pageUtils.pageSize}&nbsp;条记录，总共&nbsp;${pageUtils.totalCount}&nbsp;条</div>
</s:if>
<s:else>
<div class="pxofy">暂没有数据！！！！</div>
</s:else>
</div>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
function doNextorPrev(pageNO){
	$(".goto input").val(pageNO);
	doGoPage();
}
function doGoPage(){
	$("#queryForm").attr("action",queryAction);
	$("#queryForm").submit();
}

</script>