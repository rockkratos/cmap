<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="dishSortCfgForm">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">菜品分类</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminDishSort/{id}" method="POST">
    <li>
        <a id="addDishSortLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增分类
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminDishMgr/{id}" method="GET">
    <li>
        <a id="dishMgrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/dish.png" alt="icon" /><br />
				菜品管理
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

<@sec.authorize url="/adminDishSort/{id}" method="POST">
<div id="cbAddDishSort" class="content-box dn">
	
	<div class="content-box-header"><h3>新增分类</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="dishSortVo">
    	
        <div class="column-left">
            <p>
                <label>分类名称*</label>
                <input name="dishSortName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="dishSortEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="dishSortEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>显示顺序*</label>
                <input name="dishSortOrder" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddDishSort" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddDishSort" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="dishSortList" class="content-box">
		
	<div class="content-box-header">
		<h3>${restName} -- 菜品分类列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="dishSortListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>名称</th>
				<th>显示顺序</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="4" class="tab-btm pb10">
					
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
<@sec.authorize url="/adminDishMgr/{id}" method="GET">
$("#dishMgrLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminDishMgr/${restId}'); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
$("#restInfoLink").click(function() { $("#menuRestMgr").click(); });
</@sec.authorize>

<@sec.authorize url="/adminDishSort/{id}" method="POST">
$("#addDishSortLink").click(function() { cmap.triggerContentBox('', 'cbAddDishSort'); });
$("#btnAddDishSort").click(function() {	cmap.create('dishSortCfgForm', '${rc.contextPath}/adminDishSort/${restId}', 'cbAddDishSort', 'topHint', 'Pagination'); });
$("#btnCleanAddDishSort").click(function() { cmap.cleanBox('cbAddDishSort'); });
</@sec.authorize>

$("#restLogoLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminRestMgr/restlogo/${restId}'); });

cmap.initPagination("Pagination", ${dishSortCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('dishSortCfgForm', '${rc.contextPath}/adminDishSort/list/${restId}', pageIndex, 'dishSortList', 'listDishSortId'); }
</script>
