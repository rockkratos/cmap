<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="usrMgrForm">

<div id="page-title">
	<span>用户管理</span>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addUsrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增用户
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryUsrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询用户
            </span>
        </a>
    </li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbAddUsr" class="content-box dn">
	
	<div class="content-box-header"><h3>新增用户</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
            <p>
                <label>权限名称</label>
                <input name="privilegeName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>资源路径</label>
                <input name="resPath" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用</label>
                <input name="privilegeEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="privilegeEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
			<p>
            	<label>HTTP方法类型</label>
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
        
    </div>
    
</div><!-- END content-box -->

<div id="cbQueryUsr" class="content-box dn">
	
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

<div id="usrList" class="content-box">
		
	<div class="content-box-header">
		<h3>用户列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="usrListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>用户名</th>
				<th>昵称</th>
				<th>手机号</th>
				<th>注册时间</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="6" class="tab-btm pb10">
					
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

</script>