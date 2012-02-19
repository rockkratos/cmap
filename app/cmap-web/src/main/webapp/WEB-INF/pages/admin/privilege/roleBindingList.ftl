<#list roleMarkedUsrType as tmpUsrTypeRole>
<li>
	<input name="setRoleId" type="checkbox" value="${tmpUsrTypeRole.roleInfoVo.roleId}" <#if tmpUsrTypeRole.usrTypeVo.usrTypeId != -1>checked="checked"</#if> />
	<span>${tmpUsrTypeRole.roleInfoVo.roleDesc} -- ${tmpUsrTypeRole.roleInfoVo.roleName}</span>
</li>
</#list>