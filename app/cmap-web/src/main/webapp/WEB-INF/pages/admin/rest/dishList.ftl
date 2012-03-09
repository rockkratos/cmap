<#list dishList as tmpDish>

<tr>
	
	<#if tmpDish.dishId?exists>
	
	<td>
		<input name="listDishId" type="checkbox" value="${tmpDish.dishId}" />
	</td>
    <td>${tmpDish.dishName}</td>
    <td>${tmpDish.dishPrice}</td>
    <td>${tmpDish.dishPrmt?string('是', '否')}</td>
    <td>
    	<a href="javascript:void(0);" title="启用/禁用" onclick="javascript:cmap.enableDisabled(this, '${rc.contextPath}/adminDishMgr/${tmpDish.dishId}', 'dishListHint');"><#if tmpDish.dishEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		<a href="javascript:void(0);" title="编辑" onclick="javascript:cmap.edit('${rc.contextPath}/adminDishMgr/detail/${restId}/${tmpDish.dishId}', 'cbDetailInfo');"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除" onclick="javascript:cmap.del('${rc.contextPath}/adminDishMgr/${restId}/${tmpDish.dishId}', 'dishListHint', 'Pagination', 'dishMgrForm');"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
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