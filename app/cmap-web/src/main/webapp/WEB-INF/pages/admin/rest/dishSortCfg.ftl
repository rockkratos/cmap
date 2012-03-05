<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="dishSortCfgForm">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">菜品分类</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addDishSortLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增分类
            </span>
        </a>
    </li>
    
    <li>
        <a id="dishMgrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/dish.png" alt="icon" /><br />
				菜品管理
            </span>
        </a>
    </li>
	
	<li>
        <a id="restInfoLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/rest.png" alt="icon" /><br />
				餐馆信息
            </span>
        </a>
    </li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

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
					
					<div class="bulk-actions fl">
						<a class="button" href="javascript:void(0);">批量删除</a>
					</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbDetailInfo" class="content-box dn"></div><!-- detail info box -->

</form>

<script type="text/javascript" language="javascript">
$("#dishMgrLink").click(function() {
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "GET",
		url: '${rc.contextPath}/adminDishMgr/${restId}',
		success: function (msg) {
			dialog.close();
			$("#main-content").fadeOut("normal", function () {
				$("#main-content").html(msg);
				$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
				$("#main-content").fadeIn("normal");
			});
		}
	});
});
$("#restInfoLink").click(function() { $("#menuRestMgr").click(); });
$("#addDishSortLink").click(function() { cmap.triggerContentBox('', 'cbAddDishSort'); });

$("#btnAddDishSort").click(function() {	cmap.create('dishSortCfgForm', '${rc.contextPath}/adminDishSort/${restId}', 'cbAddDishSort', 'topHint', 'Pagination'); });
$("#btnCleanAddDishSort").click(function() { cmap.cleanBox('cbAddDishSort'); });

cmap.initPagination("Pagination", ${dishSortCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('dishSortCfgForm', '${rc.contextPath}/adminDishSort/list/${restId}', pageIndex, 'dishSortList', 'listDishSortId'); }
</script>
