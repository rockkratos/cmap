<#list dishSortList as tmpDishSort>

<tr>
	
	<#if tmpDishSort.dishSortId?exists>
	
	<td>
		<input name="listDishSortId" type="checkbox" value="${tmpDishSort.dishSortId}" />
	</td>
    <td>${tmpDishSort.dishSortName}</td>
    <td>${tmpDishSort.dishSortOrder}</td>
    <td>
    	<a href="javascript:void(0);" title="启用/禁用"><#if tmpDishSort.dishSortEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		<a href="javascript:void(0);" title="编辑"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminDishSort/${restId}/${tmpDishSort.dishSortId}', 'dishSortListHint', 'Pagination', 'dishSortCfgForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>