<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="dishMgrForm">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">菜品维护</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminDishMgr" method="POST">
    <li>
        <a id="addDishLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增菜品
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminDishMgr/list/{id}" method="GET">
    <li>
        <a id="queryDishLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询菜品
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminDishSort/{id}" method="GET">
    <li>
        <a id="dishSortLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/dish-sort.png" alt="icon" /><br />
				菜品分类
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <li>
        <a id="restLogoLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/rest-logo.png" alt="icon" /><br />
				餐馆LOGO
            </span>
        </a>
    </li>
	
	<@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
	<li>
        <a id="restInfoLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/rest.png" alt="icon" /><br />
				餐馆信息
            </span>
        </a>
    </li>
    </@sec.authorize>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<@sec.authorize url="/adminDishMgr" method="POST">
<div id="cbAddDish" class="content-box dn">
	
	<div class="content-box-header"><h3>新增菜品</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="dishInfoVo">
    	
        <div class="column-left">
            <p>
                <label>菜品名称*</label>
                <input name="dishName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>菜品价格*</label>
                <input name="dishPrice" type="text" class="text-input w200" />
            </p>            
            <p>
                <label>促销价格</label>
                <input name="dishPrmtPrice" type="text" class="text-input w200" />
            </p>
        	<p>
                <label>是否促销*</label>
                <input name="dishPrmt" type="radio" class="vm" value="false" checked="checked" /> <span class="vm">否</span>
                <input name="dishPrmt" type="radio" class="vm" value="true" /> <span class="vm">是</span>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
		    	<label>所属分类*</label>
		        <input id="dishSortShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="dishSortList" class="dropdown-content">
					<ul>
						<#if (dishSortList??) && (dishSortList?size > 0)>
						<#list dishSortList as tmpDishSort> 
						<li><a href="javascript:void(0);" value="${tmpDishSort.dishSortId}">${tmpDishSort.dishSortName}</a></li>
						</#list>
						</#if>
					</ul>
				</div>
		        <input name="dishSortVo.dishSortId" id="dishSortVal" type="hidden" />
		    </p>
        	<p>
                <label>菜品描述</label>
                <input name="dishDesc" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="dishEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="dishEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddDish" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddDish" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<@sec.authorize url="/adminDishMgr/list/{id}" method="GET">
<div id="cbQueryDish" class="content-box dn">
	
	<div class="content-box-header"><h3>查询条件</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
                <label>菜品名称</label>
                <input name="queryDishName" type="text" class="text-input w200" />
            </p>
        	<p>
            	<label>所属分类</label>
                <input id="queryDishSortShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="queryDishSortList" class="dropdown-content">
					<ul>
						<#if (dishSortList??) && (dishSortList?size > 0)>
						<#list dishSortList as tmpDishSort> 
						<li><a href="javascript:void(0);" value="${tmpDishSort.dishSortId}">${tmpDishSort.dishSortName}</a></li>
						</#list>
						</#if>
					</ul>
				</div>
                <input name="queryDishSortVo.dishSortId" id="queryDishSortVal" type="hidden" />
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>菜品描述</label>
                <input name="queryDishDesc" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnQueryDish" href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryDish" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="dishList" class="content-box">
		
	<div class="content-box-header">
		<h3>${restName} -- 菜品列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="dishListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>名称</th>
				<th>价格</th>
				<th>促销</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="5" class="tab-btm pb10">
					
					<div class="bulk-actions fl">&nbsp;</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbDetailInfo" class="content-box dn"></div><!-- detail info box -->

</form>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDishMgr" method="POST">
$("#addDishLink").click(function() { cmap.triggerContentBox('cbQueryDish', 'cbAddDish'); });
$("#btnAddDish").click(function() { cmap.create('dishMgrForm', '${rc.contextPath}/adminDishMgr', 'cbAddDish', 'topHint', 'Pagination'); });
$("#btnCleanAddDish").click(function() { cmap.cleanBox('cbAddDish'); });
cmap.bindingSelectEvent('', 'dishSort');
</@sec.authorize>

<@sec.authorize url="/adminDishMgr/list/{id}" method="GET">
$("#queryDishLink").click(function() { cmap.triggerContentBox('cbAddDish', 'cbQueryDish'); });
$("#btnQueryDish").click(function() { cmap.query('dishMgrForm', '${rc.contextPath}/adminDishMgr/dishCount/${restId}', 'Pagination', 'cbQueryDish'); });
$("#btnCleanQueryDish").click(function() { cmap.cleanBox('cbQueryDish'); });
cmap.bindingSelectEvent('query', 'dishSort');
</@sec.authorize>

<@sec.authorize url="/adminDishSort/{id}" method="GET">
$("#dishSortLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminDishSort/${restId}'); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
$("#restInfoLink").click(function() { $("#menuRestMgr").click(); });
</@sec.authorize>

$("#restLogoLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminRestMgr/restlogo/${restId}'); });

cmap.initPagination("Pagination", ${dishCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('dishMgrForm', '${rc.contextPath}/adminDishMgr/list/${restId}', pageIndex, 'dishList', 'listDishId'); }
</script>
