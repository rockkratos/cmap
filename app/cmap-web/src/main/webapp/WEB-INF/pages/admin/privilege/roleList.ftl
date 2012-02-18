<#list roleList as tmpRole>

<tr>
	
	<#if tmpRole.roleId?exists>
	
	<td>
		<input name="listRoleId" type="checkbox" value="${tmpRole.roleId}" />
	</td>
    <td>${tmpRole.roleName}</td>
    <td>${tmpRole.roleDesc}</td>
    <td>
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminRole/${tmpRole.roleId}', 'roleListHint');"><#if tmpRole.roleEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminRole/${tmpRole.roleId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminRole/${tmpRole.roleId}', 'roleListHint', 'Pagination', 'roleForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
	</td>
	
	<#else>
	
	<td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>