<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
	    <p>
            <label>菜品名称*</label>
            <input name="detailDishName" type="text" class="text-input w200" value="${dishInfoVo.dishName}" />
        </p>
        <p>
            <label>菜品价格*</label>
            <input name="detailDishPrice" type="text" class="text-input w200" value="${dishInfoVo.dishPrice}" />
        </p>            
        <p>
            <label>促销价格</label>
            <input name="detailDishPrmtPrice" type="text" class="text-input w200" value="${dishInfoVo.dishPrmtPrice!}" />
        </p>
    	<p>
            <label>是否促销*</label>
            <input name="detailDishPrmt" type="radio" class="vm" value="false" ${dishInfoVo.dishPrmt?string('', 'checked="checked"')} /> <span class="vm">否</span>
            <input name="detailDishPrmt" type="radio" class="vm" value="true" ${dishInfoVo.dishPrmt?string('checked="checked"', '')} /> <span class="vm">是</span>
        </p>
	</div>
	
	<div class="column-right">
		<p>
	    	<label>所属分类*</label>
	        <input id="detailDishSortShow" type="text" class="dropdown w200" readonly="readonly" value="${dishInfoVo.dishSortVo.dishSortName}" />
			<div id="detailDishSortList" class="dropdown-content">
				<ul>
					<#if (dishSortList??) && (dishSortList?size > 0)>
					<#list dishSortList as tmpDishSort> 
					<li><a href="javascript:void(0);" value="${tmpDishSort.dishSortId}">${tmpDishSort.dishSortName}</a></li>
					</#list>
					</#if>
				</ul>
			</div>
	        <input name="detailDishSortVo.dishSortId" id="detailDishSortVal" type="hidden" value="${dishInfoVo.dishSortVo.dishSortId}" />
	    </p>
		<p>
            <label>菜品描述</label>
            <input name="detailDishDesc" type="text" class="text-input w200" value="${dishInfoVo.dishDesc!}" />
        </p>
        <p>
            <label>启用/禁用*</label>
            <input name="detailDishEnabled" type="radio" class="vm" value="true" ${dishInfoVo.dishEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailDishEnabled" type="radio" class="vm" value="false" ${dishInfoVo.dishEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
	</div>
	
	<div class="cb"></div>
    
    <div>
        <p>
        	<@sec.authorize url="/adminDishMgr/edit/{id}/{id}" method="PUT">
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button">保 存</a>
            </@sec.authorize>
            <a id="btnDetailClose" href="javascript:void(0);" class="button">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDishMgr/edit/{id}/{id}" method="PUT">
$("#btnDetailUpdate").click(function() { cmap.save('${rc.contextPath}/adminDishMgr/edit/${restId}/${dishInfoVo.dishId}', 'dishListHint', 'Pagination', 'dishMgrForm', 'cbDetailInfo'); });
cmap.bindingSelectEvent('detail', 'dishSort');
</@sec.authorize>

$("#btnDetailClose").click(function() { cmap.close('cbDetailInfo', true); });
</script>
