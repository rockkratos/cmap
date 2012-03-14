<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<#list dishSortList as tmpDishSort>

<tr>
	
	<#if tmpDishSort.dishSortId?exists>
	
	<td>
		<input name="listDishSortId" type="checkbox" value="${tmpDishSort.dishSortId}" />
	</td>
    <td>${tmpDishSort.dishSortName}</td>
    <td>${tmpDishSort.dishSortOrder}</td>
    <td>
    	<@sec.authorize url="/adminDishSort/{id}" method="PUT">
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminDishSort/${tmpDishSort.dishSortId}', 'dishSortListHint');"><#if tmpDishSort.dishSortEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		</@sec.authorize>
		<@sec.authorize url="/adminDishSort/detail/{id}/{id}" method="GET">
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminDishSort/detail/${restId}/${tmpDishSort.dishSortId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		</@sec.authorize>
		<@sec.authorize url="/adminDishSort/{id}/{id}" method="DELETE">
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminDishSort/${restId}/${tmpDishSort.dishSortId}', 'dishSortListHint', 'Pagination', 'dishSortCfgForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
		</@sec.authorize>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>