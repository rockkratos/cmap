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
    	<a href="javascript:void(0);" title="启用/禁用"><#if tmpDish.dishEnabled == true><img src="${rc.contextPath}/imgs/admin/icons/bulb-on.png" /><#else><img src="${rc.contextPath}/imgs/admin/icons/bulb-off.png" /></#if></a>
		<a href="javascript:void(0);" title="编辑"><img src="${rc.contextPath}/imgs/admin/icons/edit.png" /></a>
		<a href="javascript:void(0);" title="删除"><img src="${rc.contextPath}/imgs/admin/icons/cross.png" /></a>
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