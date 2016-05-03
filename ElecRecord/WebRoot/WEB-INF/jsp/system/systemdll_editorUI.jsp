<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<tbody id="edit_tbody">
	<s:iterator value="#request.systemDlls" var="systemDll" status="num">

		<tr id="<s:property value='#num.count'/>">
			<td class="num"><s:property value="#num.count" /></td>
			<td class="name" align='center'><input type="text"
				value="<s:property value="#systemDll.ddlName"/>"
				name="ddlNames" size="50" /></td>
			<td class="operate" align='center'><a
				href="javascript:delTableRow('<s:property value='#num.count'/>');"
				class="del">删除</a></td>
		</tr>
	</s:iterator>
    	<s:if test="#request.systemDlls==null">
			<tr id="1">
				<td class="num">1</td>
				<td class="name" align='center'><input type="text" value=""
					size="50" name="systemDll.ddlName" />
				<td class="operate" align='center'><a
					href="javascript:delTableRow(1);" class="del">删除</a></td>
			</tr>
	</s:if>
</tbody>

