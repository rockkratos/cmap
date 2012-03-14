<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<#list deliveryAddrList as tmpDeliveryAddr>

<tr>
	
	<#if tmpDeliveryAddr.addrId?exists>
	
	<td>
		<input name="listDeliveryAddrId" type="checkbox" value="${tmpDeliveryAddr.addrId}" />
	</td>
    <td>${tmpDeliveryAddr.specAddr}</td>
    <td>${tmpDeliveryAddr.phoneNbr}</td>
    <td>
    	<@sec.authorize url="/adminDeliveryAddr/{id}/{id}" method="PUT">
    	<a href="javascript:void(0);" title="设为默认" onclick="javascript:cmap.setDefault('${rc.contextPath}/adminDeliveryAddr/${usrId}/${tmpDeliveryAddr.addrId}', 'deliveryAddrListHint', 'Pagination');"><#if tmpDeliveryAddr.defaultAddrFlag == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
    	</@sec.authorize>
    	<@sec.authorize url="/adminDeliveryAddr/detail/{id}/{id}" method="GET">
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminDeliveryAddr/detail/${usrId}/${tmpDeliveryAddr.addrId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		</@sec.authorize>
		<@sec.authorize url="/adminDeliveryAddr/{id}/{id}" method="DELETE">
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminDeliveryAddr/${usrId}/${tmpDeliveryAddr.addrId}', 'deliveryAddrListHint', 'Pagination', 'deliveryAddrForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
		</@sec.authorize>
	</td>
	
	<#else>
	
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
	
	</#if>
	
</tr>

</#list>