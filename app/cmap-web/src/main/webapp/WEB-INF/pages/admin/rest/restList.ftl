<#list restList as tmpRest>

<tr>
	
	<#if tmpRest.restId?exists>
	
	<td>
		<input name="listUsrId" type="checkbox" value="${tmpRest.restId}" />
	</td>
    <td>${tmpRest.restName}</td>
    <td>${tmpRest.restPhone}</td>
    <td>${tmpRest.restStartTime?string('yyyy-MM-dd')}</td>
    <td>${tmpRest.restEndTime?string('yyyy-MM-dd')}</td>
    <td>
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminRestMgr/${tmpRest.restId}', 'restListHint');"><#if tmpRest.restEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminRestMgr/${tmpRest.restId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminUsrMgr/${tmpRest.restId}', 'restListHint', 'Pagination', 'restMgrForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>