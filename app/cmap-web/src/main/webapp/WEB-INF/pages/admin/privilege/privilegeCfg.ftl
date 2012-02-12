<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<form id="privilegeForm">

<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">权限配置</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增权限
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询权限
            </span>
        </a>
    </li>
    
    <li>
    	<a class="shortcut-button" href="#">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role.png" alt="icon" /><br />
        		角色维护
    		</span>
		</a>
	</li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbAddPrivilege" class="content-box dn">
	
	<div class="content-box-header"><h3>新增权限</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="privilegeInfoVo">
    	
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
                <input name="privilegeEnabled" type="radio" class="vm" checked="checked" /> <span class="vm">启用</span>
                <input name="privilegeEnabled" type="radio" class="vm" /> <span class="vm">禁用</span>
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
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->

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
                <a href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryPrivilege" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->

<div id="privilege_list" class="content-box">
		
	<div class="content-box-header">
		<h3>权限列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div class="dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>序号</th>
				<th>关键字</th>
				<th>资源</th>
				<th>描述</th>
				<th>操作</th>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>
                	<a href="javascript:void(0);" title="启用/禁用"><img src="../../imgs/admin/icons/bulb-off.png" /></a>
					<a href="javascript:void(0);" title="编辑"><img src="../../imgs/admin/icons/edit.png" /></a>
					<a href="javascript:void(0);" title="删除"><img src="../../imgs/admin/icons/cross.png" /></a> 
					<a href="javascript:void(0);" title="查看"><img src="../../imgs/admin/icons/query.png" /></a>
				</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>
                	<a href="javascript:void(0);" title="启用/禁用"><img src="../../imgs/admin/icons/bulb-on.png" /></a>
					<a href="javascript:void(0);" title="编辑"><img src="../../imgs/admin/icons/edit.png" /></a>
					<a href="javascript:void(0);" title="删除"><img src="../../imgs/admin/icons/cross.png" /></a> 
					<a href="javascript:void(0);" title="查看"><img src="../../imgs/admin/icons/query.png" /></a>
                </td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
			<tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="6" class="tab-btm pb10">
					
					<div class="bulk-actions fl">
						<a class="button" href="#">批量删除</a>
					</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
    </div>
    
</div><!-- END content-box -->

<div id="cb_detail_info" class="content-box dn">
		
	<div class="content-box-header">
		<h3>详细信息</h3>					
	</div>
    
    <div class="content-box-content clearfix pb0">
        <div class="column-left">
            <p>
                <label>文本输入框</label>
                <input type="text" class="text-input" />
            </p>
            <p>
                <label>复选框</label>
                <input type="checkbox" class="vm" /> <span class="vm">第一复选框</span> <input type="checkbox" class="vm" /> <span class="vm">第二复选框</span>
            </p>
            <p>
                <label>单选框</label>
                <input type="radio" name="radio1" class="vm" /> <span class="vm">单选框1</span><br />
                <input type="radio" name="radio2" class="vm" /> <span class="vm">单选框2</span>
            </p>
        </div>
        <div class="column-right">
            <p>
                <label>下拉框</label>
                <input id="tt2_show" type="text" class="dropdown" readonly="readonly" value="测试2" onclick="javascript:showDropDownList(this, 'tt2');" onblur="javascript:dropDownListBlur('tt2');" />
				<div id="tt2" class="dropdown-content">
		            <ul>
		                <li><a href="javascript:void(0);" value="1" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项A</a></li>
		                <li><a href="javascript:void(0);" value="2" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项B</a></li>
		                <li><a href="javascript:void(0);" value="3" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项C</a></li>
		            </ul>
				</div>
                <input id="tt2_val" type="hidden" />
            </p>
        </div>
        <div class="cb"></div>
        <div>
            <p>
                <a href="#" class="button">保 存</a>
                <a id="btn-detail-close" href="javascript:void(0);" class="button">关 闭</a>
            </p>
        </div>
    </div>
    
</div><!-- END content-box -->

</form>

<script type="text/javascript" language="javascript">
$("#addPrivilegeLink").click(function() { cmap.triggerContentBox('cbQueryPrivilege', 'cbAddPrivilege'); });
$("#queryPrivilegeLink").click(function() { cmap.triggerContentBox('cbAddPrivilege', 'cbQueryPrivilege'); });

$("#methodTypeShow").click(function() { cmap.showDropDownList($(this), 'methodTypeList'); });
$("#methodTypeShow").blur(function() { cmap.dropDownListBlur('methodTypeList'); });
$("#methodTypeList a").click(function() { cmap.updateDropDownListVal($(this), 'methodTypeVal', 'methodTypeShow'); });

$("#queryMethodTypeShow").click(function() { cmap.showDropDownList($(this), 'queryMethodTypeList'); });
$("#queryMethodTypeShow").blur(function() { cmap.dropDownListBlur('queryMethodTypeList'); });
$("#queryMethodTypeList a").click(function() { cmap.updateDropDownListVal($(this), 'queryMethodTypeVal', 'queryMethodTypeShow'); });

$("#btnCleanAddPrivilege").click(function() { cmap.cleanBox('cbAddPrivilege') });
$("#btnCleanQueryPrivilege").click(function() { cmap.cleanBox('cbQueryPrivilege') });

$("#btnAddPrivilege").click(function() {
	var params = $("#privilegeForm").formSerialize();
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "POST",
		url: "${rc.contextPath}/adminPrivilege",
		data: params,
		success: function (msg) {
			dialog.close();
			cmap.callBackOptForCb('cbAddPrivilege', msg, 'topHint');
		}
	});
});

cmap.initPagination("Pagination", 100);

function pageselectCallback(pageIndex, jq) {
	var params = $("#privilegeForm").formSerialize();
 	$.ajax({
 		type: "GET",
		url: "${rc.contextPath}/adminPrivilege",
		data: params + "&pageIndex=" + pageIndex,
		success: function (msg) {
			alert(msg);
		}
 	});
}
</script>