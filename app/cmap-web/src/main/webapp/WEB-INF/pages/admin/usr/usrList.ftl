<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<#list usrList as tmpUsr>

<tr>
	
	<#if tmpUsr.usrId?exists>
	
	<td>
		<input name="listUsrId" type="checkbox" value="${tmpUsr.usrId}" />
	</td>
    <td>${tmpUsr.loginName}</td>
    <td>${tmpUsr.usrCell}</td>
    <td>${tmpUsr.regTime?string('yyyy-MM-dd HH:mm:ss')}</td>
    <td>
    	<@sec.authorize url="/adminUsrMgr/{id}" method="PUT">
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminUsrMgr/${tmpUsr.usrId}', 'usrListHint');"><#if tmpUsr.usrEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		</@sec.authorize>
		<@sec.authorize url="/adminUsrMgr/detail/{id}" method="GET">
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminUsrMgr/detail/${tmpUsr.usrId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		</@sec.authorize>
		<@sec.authorize url="/adminUsrMgr/{id}" method="DELETE">
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminUsrMgr/${tmpUsr.usrId}', 'usrListHint', 'Pagination', 'usrMgrForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
		</@sec.authorize>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>