<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="privilegeForm">

<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">权限配置</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminPrivilege" method="POST">
    <li>
        <a id="addPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增权限
            </span>
        </a>
    </li>
    </@sec.authorize>
	
	<@sec.authorize url="/adminPrivilege" method="GET">
	<li>
        <a id="queryPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询权限
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminMenu/menuRoleCfg" method="GET">
    <li>
    	<a id="roleCfgLink" class="shortcut-button" href="javascript:void(0);">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role.png" alt="icon" /><br />
        		角色维护
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

<@sec.authorize url="/adminPrivilege" method="POST">
<div id="cbAddPrivilege" class="content-box dn">
	
	<div class="content-box-header"><h3>新增权限</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="privilegeInfoVo">
    	
        <div class="column-left">
            <p>
                <label>权限名称*</label>
                <input name="privilegeName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>资源路径*</label>
                <input name="resPath" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="privilegeEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="privilegeEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
			<p>
            	<label>HTTP方法类型*</label>
                <input id="methodTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="methodTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">查询 -- GET</a></li>
						<li><a href="javascript:void(0);" value="2">新增 -- POST</a></li>
						<li><a href="javascript:void(0);" value="3">修改 -- PUT</a></li>
						<li><a href="javascript:void(0);" value="4">删除 -- DELETE</a></li>
					</ul>
				</div>
                <input name="httpMethodTypeVo.methodTypeId" id="methodTypeVal" type="hidden" />
            </p>
			<p>
                <label>权限描述</label>
                <input name="privilegeDesc" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddPrivilege" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddPrivilege" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<@sec.authorize url="/adminPrivilege" method="GET">
<div id="cbQueryPrivilege" class="content-box dn">
	
	<div class="content-box-header"><h3>查询条件</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
                <label>权限描述</label>
                <input name="queryPrivilegeDesc" type="text" class="text-input w200" />
            </p>
        	<p>
                <label>权限名称</label>
                <input name="queryPrivilegeName" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="column-right">
        	<p>
            	<label>HTTP方法类型</label>
                <input id="queryMethodTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="queryMethodTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">查询 -- GET</a></li>
						<li><a href="javascript:void(0);" value="2">新增 -- POST</a></li>
						<li><a href="javascript:void(0);" value="3">修改 -- PUT</a></li>
						<li><a href="javascript:void(0);" value="4">删除 -- DELETE</a></li>
					</ul>
				</div>
				<input name="queryHttpMethodTypeVo.methodTypeId" id="queryMethodTypeVal" type="hidden" />
            </p>
            <p>
                <label>资源路径</label>
                <input name="queryResPath" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnQueryPrivilege" href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryPrivilege" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="privilegeList" class="content-box">
		
	<div class="content-box-header">
		<h3>权限列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="privilegeListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>名称</th>
				<th>资源路径</th>
				<th>方法类型</th>
				<th>描述</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="6" class="tab-btm pb10">
					
					<div class="bulk-actions fl">&nbsp;</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbDetailInfo" class="content-box dn"></div><!-- detail info box -->

</form>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminPrivilege" method="POST">
$("#addPrivilegeLink").click(function() { cmap.triggerContentBox('cbQueryPrivilege', 'cbAddPrivilege'); });
$("#btnAddPrivilege").click(function() { cmap.create('privilegeForm', '${rc.contextPath}/adminPrivilege', 'cbAddPrivilege', 'topHint', 'Pagination'); });
$("#btnCleanAddPrivilege").click(function() { cmap.cleanBox('cbAddPrivilege'); });
cmap.bindingSelectEvent('', 'methodType');
</@sec.authorize>

<@sec.authorize url="/adminPrivilege" method="GET">
$("#queryPrivilegeLink").click(function() { cmap.triggerContentBox('cbAddPrivilege', 'cbQueryPrivilege'); });
$("#btnQueryPrivilege").click(function() { cmap.query('privilegeForm', '${rc.contextPath}/adminPrivilege/privilegeCount', 'Pagination', 'cbQueryPrivilege'); });
$("#btnCleanQueryPrivilege").click(function() { cmap.cleanBox('cbQueryPrivilege'); });
cmap.bindingSelectEvent('query', 'methodType');
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRoleCfg" method="GET">
$("#roleCfgLink").click(function() { $("#menuRoleCfg").click(); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRoleBinding" method="GET">
$("#roleBindingLink").click(function() { $("#menuRoleBinding").click(); });
</@sec.authorize>

cmap.initPagination("Pagination", ${privilegeCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('privilegeForm', '${rc.contextPath}/adminPrivilege', pageIndex, 'privilegeList', 'listPrivilegeId'); }
</script>
