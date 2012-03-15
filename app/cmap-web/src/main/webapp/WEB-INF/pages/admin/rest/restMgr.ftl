<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="restMgrForm">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">餐馆信息</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminRestMgr" method="POST">
    <li>
        <a id="addRestLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增餐馆
            </span>
        </a>
    </li>
    </@sec.authorize>
	
	<@sec.authorize url="/adminRestMgr" method="GET">
	<li>
        <a id="queryRestLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询餐馆
            </span>
        </a>
    </li>
    </@sec.authorize>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<@sec.authorize url="/adminRestMgr" method="POST">
<div id="cbAddRest" class="content-box dn">
	
	<div class="content-box-header"><h3>新增餐馆</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="restInfoVo">
    	
        <div class="column-left">
            <p>
                <label>餐馆名称*</label>
                <input name="restName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆地址*</label>
                <input name="restAddr" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆经度*</label>
                <input name="restLng" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆纬度*</label>
                <input name="restLat" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐起始时间*</label>
                <input name="restOpenTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐结束时间*</label>
                <input name="restCloseTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐半径*</label>
                <input name="takeAwayRadius" type="text" class="text-input w200" />
            </p>
            <p>
                <label>起送价格*</label>
                <input name="sendingAmount" type="text" class="text-input w200" />
            </p>
            <p>
                <label>网络打印机ID</label>
                <input name="printerId" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="restEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="restEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>送餐费用*</label>
                <input name="takeAwayFee" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐费用说明</label>
                <input name="takeAwayDesc" type="text" class="text-input w200" />
            </p>
            <p>
                <label>联系电话</label>
                <input name="restPhone" type="text" class="text-input w200" />
            </p>
            <p>
            	<label>所属城市*</label>
                <input id="cityShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="cityList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="21">天津</a></li>
					</ul>
				</div>
                <input name="cityInfoVo.cityId" id="cityVal" type="hidden" />
            </p>
        	<p>
            	<label>订单传输类型*</label>
                <input id="orderTransTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="orderTransTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">电话 -- PHONE</a></li>
						<li><a href="javascript:void(0);" value="2">短信 -- SMS</a></li>
						<li><a href="javascript:void(0);" value="3">电子邮件 -- EMAIL</a></li>
						<li><a href="javascript:void(0);" value="4">客户端 -- CLIENT</a></li>
						<li><a href="javascript:void(0);" value="5">打印机 -- PRINTER</a></li>
					</ul>
				</div>
                <input name="orderTransTypeVo.orderTransTypeId" id="orderTransTypeVal" type="hidden" />
            </p>
            <p>
            	<label>餐馆类型*</label>
                <input id="cookingTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="cookingTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">中餐</a></li>
						<li><a href="javascript:void(0);" value="2">西餐</a></li>
						<li><a href="javascript:void(0);" value="3">快餐</a></li>
						<li><a href="javascript:void(0);" value="4">日式料理</a></li>
						<li><a href="javascript:void(0);" value="5">韩式料理</a></li>
						<li><a href="javascript:void(0);" value="6">清真</a></li>
						<li><a href="javascript:void(0);" value="7">零食/饮料</a></li>
					</ul>
				</div>
                <input name="cookingTypeVo.cookingTypeId" id="cookingTypeVal" type="hidden" />
            </p>
			<p>
                <label>生效时间*</label>
                <input id="restStartTime" name="restStartTime" type="text" readonly="readonly" class="date-txt w200" />
            </p>
            <p>
                <label>失效时间*</label>
                <input id="restEndTime" name="restEndTime" type="text" readonly="readonly" class="date-txt w200" />
            </p>
            <p>
                <label>打印联数</label>
                <input id="printJointNumShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="printJointNumList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="">--</a></li>
						<li><a href="javascript:void(0);" value="2">二联</a></li>
						<li><a href="javascript:void(0);" value="3">三联</a></li>
					</ul>
				</div>
                <input name="printJointNum" id="printJointNumVal" type="hidden" />
            </p>
            <p>
                <label>是否签约*</label>
                <input name="restSigned" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">已签</span>
                <input name="restSigned" type="radio" class="vm" value="false" /> <span class="vm">未签</span>
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddRest" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddRest" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<@sec.authorize url="/adminRestMgr" method="GET">
<div id="cbQueryRest" class="content-box dn">
	
	<div class="content-box-header"><h3>查询条件</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
                <label>餐馆名称</label>
                <input name="queryRestName" type="text" class="text-input w200" />
            </p>
        	<p>
            	<label>所属城市</label>
                <input id="queryCityShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="queryCityList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="21">天津</a></li>
					</ul>
				</div>
                <input name="queryCityInfoVo.cityId" id="queryCityVal" type="hidden" />
            </p>
        </div>
        
        <div class="column-right">
        	<p>
            	<label>餐馆类型</label>
                <input id="queryCookingTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="queryCookingTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">中餐</a></li>
						<li><a href="javascript:void(0);" value="2">西餐</a></li>
						<li><a href="javascript:void(0);" value="3">快餐</a></li>
						<li><a href="javascript:void(0);" value="4">日式料理</a></li>
						<li><a href="javascript:void(0);" value="5">韩式料理</a></li>
						<li><a href="javascript:void(0);" value="6">清真</a></li>
						<li><a href="javascript:void(0);" value="7">零食/饮料</a></li>
					</ul>
				</div>
                <input name="queryCookingTypeVo.cookingTypeId" id="queryCookingTypeVal" type="hidden" />
            </p>
            <p>
                <label>是否签约</label>
                <input name="queryRestSigned" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">已签</span>
                <input name="queryRestSigned" type="radio" class="vm" value="false" /> <span class="vm">未签</span>
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnQueryRest" href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryRest" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="restList" class="content-box">
		
	<div class="content-box-header">
		<h3>餐馆列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="restListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>名称</th>
				<th>联系电话</th>
				<th>生效时间</th>
				<th>失效时间</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="6" class="tab-btm pb10">
					
					<div class="bulk-actions fl">
						<@sec.authorize url="/adminDishSort/{id}" method="GET">
						<a id="btnDishSort" class="button" href="javascript:void(0);">菜品分类</a>
						</@sec.authorize>
						<@sec.authorize url="/adminDishMgr/{id}" method="GET">
						<a id="btnDishMgr" class="button" href="javascript:void(0);">菜品管理</a>
						</@sec.authorize>
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
<@sec.authorize url="/adminDishSort/{id}" method="GET">
$("#btnDishSort").click(function() {
	if (checkChooseRest()) {
		var restId = $("input[name='listRestId']:checked").val();
		cmap.flushMainContent('${rc.contextPath}/adminDishSort/' + restId);
	}
});
</@sec.authorize>

<@sec.authorize url="/adminDishMgr/{id}" method="GET">
$("#btnDishMgr").click(function() {
	if (checkChooseRest()) {
		var restId = $("input[name='listRestId']:checked").val();
		cmap.flushMainContent('${rc.contextPath}/adminDishMgr/' + restId);
	}
});
</@sec.authorize>

<@sec.authorize url="/adminRestMgr" method="POST">
$("#addRestLink").click(function() { cmap.triggerContentBox('cbQueryRest', 'cbAddRest'); });
cmap.bindingSelectEvent('', 'city');
cmap.bindingSelectEvent('', 'orderTransType');
cmap.bindingSelectEvent('', 'cookingType');
cmap.bindingSelectEvent('', 'printJointNum');
$("#restStartTime").focus(function() { WdatePicker(); });
$("#restEndTime").focus(function() { WdatePicker(); });

$("#btnAddRest").click(function() { cmap.create('restMgrForm', '${rc.contextPath}/adminRestMgr', 'cbAddRest', 'topHint', 'Pagination'); });

$("#btnCleanAddRest").click(function() { cmap.cleanBox('cbAddRest'); });
</@sec.authorize>

<@sec.authorize url="/adminRestMgr" method="GET">
$("#queryRestLink").click(function() { cmap.triggerContentBox('cbAddRest', 'cbQueryRest'); });
cmap.bindingSelectEvent('query', 'cookingType');
cmap.bindingSelectEvent('query', 'city');
$("#btnQueryRest").click(function() { cmap.query('restMgrForm', '${rc.contextPath}/adminRestMgr/restCount', 'Pagination', 'cbQueryRest'); });
$("#btnCleanQueryRest").click(function() { cmap.cleanBox('cbQueryRest'); });
</@sec.authorize>

cmap.initPagination("Pagination", ${restCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('restMgrForm', '${rc.contextPath}/adminRestMgr', pageIndex, 'restList', 'listRestId'); }

function checkChooseRest() {
	var restIdNum = $("input[name='listRestId']:checked").size();
	if (restIdNum == 0) {
		cmap.showHintMsg('restListHint', 'error', '请选择餐馆');
		return false;
	} else if (restIdNum != 1) {
		cmap.showHintMsg('restListHint', 'warning', '请选择一个餐馆');
		return false;
	} else {
		return true;
	}
}
</script>
