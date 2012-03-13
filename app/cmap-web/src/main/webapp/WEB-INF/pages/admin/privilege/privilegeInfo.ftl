<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
        <p>
            <label>权限名称*</label>
            <input name="detailPrivilegeName" type="text" class="text-input w200" value="${privilegeInfoVo.privilegeName}" />
        </p>
        <p>
            <label>资源路径*</label>
            <input name="detailResPath" type="text" class="text-input w200" value="${privilegeInfoVo.resPath}" />
        </p>
        <p>
            <label>启用/禁用*</label>
            <input name="detailPrivilegeEnabled" type="radio" class="vm" value="true" ${privilegeInfoVo.privilegeEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailPrivilegeEnabled" type="radio" class="vm" value="false" ${privilegeInfoVo.privilegeEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
    </div>
    
    <div class="column-right">
		<p>
        	<label>HTTP方法类型*</label>
        	<#if privilegeInfoVo.httpMethodTypeVo.methodTypeId ==1>
            <input id="detailMethodTypeShow" type="text" class="dropdown w200" readonly="readonly" value="查询 -- GET" />
            <#elseif privilegeInfoVo.httpMethodTypeVo.methodTypeId ==2>
            <input id="detailMethodTypeShow" type="text" class="dropdown w200" readonly="readonly" value="新增 -- POST" />
            <#elseif privilegeInfoVo.httpMethodTypeVo.methodTypeId ==3>
            <input id="detailMethodTypeShow" type="text" class="dropdown w200" readonly="readonly" value="修改 -- PUT" />
            <#elseif privilegeInfoVo.httpMethodTypeVo.methodTypeId ==4>
            <input id="detailMethodTypeShow" type="text" class="dropdown w200" readonly="readonly" value="删除 -- DELETE" />
            </#if>
			<div id="detailMethodTypeList" class="dropdown-content">
				<ul>
					<li><a href="javascript:void(0);" value="1">查询 -- GET</a></li>
					<li><a href="javascript:void(0);" value="2">新增 -- POST</a></li>
					<li><a href="javascript:void(0);" value="3">修改 -- PUT</a></li>
					<li><a href="javascript:void(0);" value="4">删除 -- DELETE</a></li>
				</ul>
			</div>
            <input name="detailHttpMethodTypeVo.methodTypeId" id="detailMethodTypeVal" type="hidden" value="${privilegeInfoVo.httpMethodTypeVo.methodTypeId}" />
        </p>
		<p>
            <label>权限描述</label>
            <input name="detailPrivilegeDesc" type="text" class="text-input w200" value="${privilegeInfoVo.privilegeDesc}" />
        </p>
    </div>
    
    <div class="cb"></div>
    
    <div>
        <p>
        	<@sec.authorize url="/adminPrivilege/edit/{id}" method="PUT">
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button">保 存</a>
            </@sec.authorize>
            <a id="btnDetailClose" href="javascript:void(0);" class="button">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminPrivilege/edit/{id}" method="PUT">
$("#btnDetailUpdate").click(function() { cmap.save('${rc.contextPath}/adminPrivilege/edit/${privilegeInfoVo.privilegeId}', 'privilegeListHint', 'Pagination', 'privilegeForm', 'cbDetailInfo'); });
</@sec.authorize>

$("#btnDetailClose").click(function() { cmap.close('cbDetailInfo', true); });

cmap.bindingSelectEvent('detail', 'methodType');
</script>
