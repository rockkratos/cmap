<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="roleForm">

<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">角色维护</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addRoleLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增角色
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryRoleLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询角色
            </span>
        </a>
    </li>
    
    <li>
    	<a id="privilegeCfgLink" class="shortcut-button" href="#">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/privilege.png" alt="icon" /><br />
        		权限配置
    		</span>
		</a>
	</li>
	
	<li>
    	<a id="roleBindingLink" class="shortcut-button" href="javascript:void(0);">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role-binding.png" alt="icon" /><br />
        		角色绑定
    		</span>
		</a>
	</li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbAddRole" class="content-box dn">
	
	<div class="content-box-header"><h3>新增角色</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="roleInfoVo">
    	
        <div class="column-left">
            <p>
                <label>角色名称</label>
                <input name="roleName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>角色描述</label>
                <input name="roleDesc" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用</label>
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
						<a class="button" href="javascript:void(0);">刷 新</a>
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
$("#addRoleLink").click(function() { cmap.triggerContentBox('cbQueryRole', 'cbAddRole'); });
$("#queryRoleLink").click(function() { cmap.triggerContentBox('cbAddRole', 'cbQueryRole'); });

$("#btnCleanAddRole").click(function() { cmap.cleanBox('cbAddRole'); });
$("#btnCleanQueryRole").click(function() { cmap.cleanBox('cbQueryRole'); });

$("#privilegeCfgLink").click(function() { $("#menuPrivilegeCfg").click(); });
$("#roleBindingLink").click(function() { $("#menuRoleBinding").click(); });

$("#btnAddRole").click(function() {
	var params = $("#roleForm").formSerialize();
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "POST",
		url: "${rc.contextPath}/adminRole",
		data: params,
		success: function (msg) {
			dialog.close();
			cmap.callBackOptForCb('cbAddRole', msg, 'topHint', 'Pagination');
		}
	});
});

$("#btnQueryRole").click(function() {
	var params = $("#roleForm").formSerialize();
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "GET", 
		url: "${rc.contextPath}/adminRole/roleCount",
		data: params, 
		success: function (msg) {
			cmap.initPagination("Pagination", msg);
			dialog.close();
			$("#cbQueryRole").slideUp();
		}
	});
});

cmap.initPagination("Pagination", ${roleCount});

function pageselectCallback(pageIndex, jq) {
	var params = $("#roleForm").formSerialize();
 	$.ajax({
 		type: "GET",
		url: "${rc.contextPath}/adminRole",
		data: params + "&pageIndex=" + pageIndex,
		success: function (msg) {
			var firstLine = "<tr>" + $(".zebra-tab tr").first().html() + "</tr>";
			$("table.zebra-tab tr:not(:last)").remove();
			$("table.zebra-tab tr:last").before(firstLine + msg);
			$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
			$("#roleList input[class='check-all']").click(function() {cmap.chooseAll('listRoleId');});
		}
 	});
}
</script>