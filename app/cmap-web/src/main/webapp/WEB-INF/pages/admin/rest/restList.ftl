<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<#list restList as tmpRest>

<tr>
	
	<#if tmpRest.restId?exists>
	
	<td>
		<input name="listRestId" type="checkbox" value="${tmpRest.restId}" />
	</td>
    <td>${tmpRest.restName}</td>
    <td>${tmpRest.restPhone}</td>
    <td>${tmpRest.restStartTime?string('yyyy-MM-dd')}</td>
    <td>${tmpRest.restEndTime?string('yyyy-MM-dd')}</td>
    <td>
    	<#if tmpRest.logoFlag == 3>
    	全
    	<#elseif tmpRest.logoFlag == 2>
    	大
    	<#elseif tmpRest.logoFlag == 1>
    	<#else>
    	默认
    	</#if>
    </td>
    <td>
    	<@sec.authorize url="/adminRestMgr/{id}" method="PUT">
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminRestMgr/${tmpRest.restId}', 'restListHint');"><#if tmpRest.restEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		</@sec.authorize>
		<@sec.authorize url="/adminRestMgr/detail/{id}" method="GET">
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminRestMgr/detail/${tmpRest.restId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		</@sec.authorize>
		<@sec.authorize url="/adminRestMgr/{id}" method="DELETE">
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminRestMgr/${tmpRest.restId}', 'restListHint', 'Pagination', 'restMgrForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
		</@sec.authorize>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>