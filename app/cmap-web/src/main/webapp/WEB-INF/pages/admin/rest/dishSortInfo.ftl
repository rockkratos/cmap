<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
	    <p>
            <label>分类名称*</label>
            <input name="detailDishSortName" type="text" class="text-input w200" value="${dishSortVo.dishSortName}" />
        </p>
        <p>
            <label>启用/禁用*</label>
            <input name="detailDishSortEnabled" type="radio" class="vm" value="true" ${dishSortVo.dishSortEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailDishSortEnabled" type="radio" class="vm" value="false" ${dishSortVo.dishSortEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
	</div>
	
	<div class="column-right">
		<p>
            <label>显示顺序*</label>
            <input name="detailDishSortOrder" type="text" class="text-input w200" value="${dishSortVo.dishSortOrder}" />
        </p>
	</div>
	
	<div class="cb"></div>
    
    <div>
        <p>
        	<@sec.authorize url="/adminDishSort/edit/{id}/{id}" method="PUT">
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button">保 存</a>
            </@sec.authorize>
            <a id="btnDetailClose" href="javascript:void(0);" class="button">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDishSort/edit/{id}/{id}" method="PUT">
$("#btnDetailUpdate").click(function() { cmap.save('${rc.contextPath}/adminDishSort/edit/${restId}/${dishSortVo.dishSortId}', 'dishSortListHint', 'Pagination', 'dishSortCfgForm', 'cbDetailInfo'); });
</@sec.authorize>

$("#btnDetailClose").click(function() { cmap.close('cbDetailInfo', true); });
</script>
