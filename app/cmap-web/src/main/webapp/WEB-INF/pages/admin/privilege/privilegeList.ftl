<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<#list privilegeList as tmpPrivilege>

<tr>
	
	<#if tmpPrivilege.privilegeId?exists>
	
	<td>
		<input name="listPrivilegeId" type="checkbox" value="${tmpPrivilege.privilegeId}" />
	</td>
    <td>${tmpPrivilege.privilegeName}</td>
    <td>${tmpPrivilege.resPath}</td>
    <td>${tmpPrivilege.httpMethodTypeVo.methodType}</td>
    <td>${tmpPrivilege.privilegeDesc}</td>
    <td>
    	<@sec.authorize url="/adminPrivilege/{id}" method="PUT">
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminPrivilege/${tmpPrivilege.privilegeId}', 'privilegeListHint');"><#if tmpPrivilege.privilegeEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
    	</@sec.authorize>
    	<@sec.authorize url="/adminPrivilege/detail/{id}" method="GET">
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminPrivilege/detail/${tmpPrivilege.privilegeId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		</@sec.authorize>
		<@sec.authorize url="/adminPrivilege/{id}" method="DELETE">
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminPrivilege/${tmpPrivilege.privilegeId}', 'privilegeListHint', 'Pagination', 'privilegeForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
		</@sec.authorize>
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