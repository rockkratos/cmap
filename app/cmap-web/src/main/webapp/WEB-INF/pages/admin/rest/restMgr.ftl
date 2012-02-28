<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="restForm">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">餐馆信息</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addRestLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增餐馆
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryRestLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询餐馆
            </span>
        </a>
    </li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbAddRest" class="content-box dn">
	
	<div class="content-box-header"><h3>新增餐馆</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="restInfoVo">
    	
        <div class="column-left">
            <p>
                <label>餐馆名称</label>
                <input name="restName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆地址</label>
                <input name="resAddr" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆经度</label>
                <input name="restLng" type="text" class="text-input w200" />
            </p>
            <p>
                <label>餐馆纬度</label>
                <input name="restLat" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐起始时间</label>
                <input name="restOpenTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐结束时间</label>
                <input name="restCloseTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>送餐半径</label>
                <input name="takeAwayRadius" type="text" class="text-input w200" />
            </p>
            <p>
                <label>起送价格</label>
                <input name="sendingAmount" type="text" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用</label>
                <input name="restEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="restEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>送餐费用</label>
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
            	<label>所属城市</label>
                <input id="cityShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="cityList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="21">天津</a></li>
					</ul>
				</div>
                <input name="cityInfoVo.cityId" id="cityVal" type="hidden" />
            </p>
        	<p>
            	<label>订单传输类型</label>
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
            	<label>餐馆类型</label>
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
                <label>生效时间</label>
                <input name="restStartTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>失效时间</label>
                <input name="restEndTime" type="text" class="text-input w200" />
            </p>
            <p>
                <label>是否签约</label>
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
						<a class="button" href="javascript:void(0);">批量删除</a>
						<a class="button" href="javascript:void(0);">刷 新</a>
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

</script>
