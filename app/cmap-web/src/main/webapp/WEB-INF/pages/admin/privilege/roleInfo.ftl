<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
    	<p>
            <label>角色名称</label>
            <input name="detailRoleName" type="text" class="text-input w200" value="${roleInfoVo.roleName}" />
        </p>
        <p>
            <label>角色描述</label>
            <input name="detailRoleDesc" type="text" class="text-input w200" value="${roleInfoVo.roleDesc}" />
        </p>
        <p>
            <label>启用/禁用</label>
            <input name="detailRoleEnabled" type="radio" class="vm" value="true" ${roleInfoVo.roleEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailRoleEnabled" type="radio" class="vm" value="false" ${roleInfoVo.roleEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
    </div>
    
    <div class="column-right">
		<label>权限列表</label>
    	<ul class="cb-list">
    		<#list privilegeMarkedRole as tmpRolePrivilege>
			<li>
				<input name="editRolePrivilegeId" type="checkbox" value="${tmpRolePrivilege.privilegeInfoVo.privilegeId}" <#if tmpRolePrivilege.roleInfoVo.roleId??>checked="checked"</#if> />
				<span>${tmpRolePrivilege.privilegeInfoVo.privilegeDesc} -- ${tmpRolePrivilege.privilegeInfoVo.privilegeName}</span>
			</li>
			</#list>
		</ul>
    </div>
    
    <div class="cb"></div>
    
    <div>
        <p>
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button" onclick="javascript:cmap.save('${rc.contextPath}/adminRole/edit/${roleInfoVo.roleId}', 'roleListHint', 'Pagination', 'roleForm', 'cbDetailInfo');">保 存</a>
            <a id="btnDetailClose" href="javascript:void(0);" class="button" onclick="javascript:cmap.close('cbDetailInfo', true);">关 闭</a>
        </p>
    </div>
    
</div>