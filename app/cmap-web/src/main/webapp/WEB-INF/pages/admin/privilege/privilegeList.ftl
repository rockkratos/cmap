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
    	<a href="javascript:void(0);" title="启用/禁用">
    		<#if tmpPrivilege.privilegeEnabled == true>
    		<img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" />
    		<#else>
    		<img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" />
    		</#if>
    	</a>
		<a href="javascript:void(0);" title="编辑"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
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