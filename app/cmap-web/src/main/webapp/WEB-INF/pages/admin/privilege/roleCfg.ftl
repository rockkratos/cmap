<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="roleForm">

<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">角色维护</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminRole" method="POST">
    <li>
        <a id="addRoleLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增角色
            </span>
        </a>
    </li>
    </@sec.authorize>
	
	<@sec.authorize url="/adminRole" method="GET">
	<li>
        <a id="queryRoleLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询角色
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminMenu/menuPrivilegeCfg" method="GET">
    <li>
    	<a id="privilegeCfgLink" class="shortcut-button" href="#">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/privilege.png" alt="icon" /><br />
        		权限配置
    		</span>
		</a>
	</li>
	</@sec.authorize>
	
	<@sec.authorize url="/adminMenu/menuRoleBinding" method="GET">
	<li>
    	<a id="roleBindingLink" class="shortcut-button" href="javascript:void(0);">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role-binding.png" alt="icon" /><br />
        		角色绑定
    		</span>
		</a>
	</li>
	</@sec.authorize>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<@sec.authorize url="/adminRole" method="POST">
<div id="cbAddRole" class="content-box dn">
	
	<div class="content-box-header"><h3>新增角色</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="roleInfoVo">
    	
        <div class="column-left">
            <p>
                <label>角色名称*</label>
                <input name="roleName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>角色描述</label>
                <input name="roleDesc" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="roleEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="roleEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
			<label>权限列表</label>
        	<ul class="cb-list">
        		<#list allPrivileges as tmpPrivilege>
				<li>
					<input name="setRolePrivilegeId" type="checkbox" value="${tmpPrivilege.privilegeId}" />
					<span>${tmpPrivilege.privilegeDesc} -- ${tmpPrivilege.privilegeName}</span>
				</li>
				</#list>
			</ul>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddRole" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddRole" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<@sec.authorize url="/adminRole" method="GET">
<div id="cbQueryRole" class="content-box dn">
	
	<div class="content-box-header"><h3>查询条件</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
                <label>角色描述</label>
                <input name="queryRoleDesc" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="column-right">
            <p>
                <label>角色名称</label>
                <input name="queryRoleName" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnQueryRole" href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryRole" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="roleList" class="content-box">
		
	<div class="content-box-header">
		<h3>角色列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="roleListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>名称</th>
				<th>描述</th>
				<th>操作</th>
            </tr>
            
            
            
            <tr class="tab-bg-white">
            
            	<td colspan="4" class="tab-btm pb10">
					
					<div class="bulk-actions fl">
						<a class="button" href="javascript:void(0);">批量删除</a>
					</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbDetailInfo" class="content-box dn"></div><!-- detail info box -->

</form>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminRole" method="POST">
$("#addRoleLink").click(function() { cmap.triggerContentBox('cbQueryRole', 'cbAddRole'); });
$("#btnAddRole").click(function() { cmap.create('roleForm', '${rc.contextPath}/adminRole', 'cbAddRole', 'topHint', 'Pagination'); });
$("#btnCleanAddRole").click(function() { cmap.cleanBox('cbAddRole'); });
</@sec.authorize>

<@sec.authorize url="/adminRole" method="GET">
$("#queryRoleLink").click(function() { cmap.triggerContentBox('cbAddRole', 'cbQueryRole'); });
$("#btnQueryRole").click(function() { cmap.query('roleForm', '${rc.contextPath}/adminRole/roleCount', 'Pagination', 'cbQueryRole'); });
$("#btnCleanQueryRole").click(function() { cmap.cleanBox('cbQueryRole'); });
cmap.initPagination("Pagination", ${roleCount});
function pageselectCallback(pageIndex, jq) {	cmap.paging('roleForm', '${rc.contextPath}/adminRole', pageIndex, 'roleList', 'listRoleId'); }
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuPrivilegeCfg" method="GET">
$("#privilegeCfgLink").click(function() { $("#menuPrivilegeCfg").click(); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRoleBinding" method="GET">
$("#roleBindingLink").click(function() { $("#menuRoleBinding").click(); });
</@sec.authorize>
</script>