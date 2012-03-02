<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
	    <p>
	        <label>餐馆名称</label>
	        <input name="detailRestName" type="text" class="text-input w200" value="${restInfoVo.restName}" />
	    </p>
	    <p>
	        <label>餐馆地址</label>
	        <input name="detailRestAddr" type="text" class="text-input w200" value="${restInfoVo.restAddr}" />
	    </p>
	    <p>
	        <label>餐馆经度</label>
	        <input name="detailRestLng" type="text" class="text-input w200" value="${restInfoVo.restLng}" />
	    </p>
	    <p>
	        <label>餐馆纬度</label>
	        <input name="detailRestLat" type="text" class="text-input w200" value="${restInfoVo.restLat}" />
	    </p>
	    <p>
	        <label>送餐起始时间</label>
	        <input name="detailRestOpenTime" type="text" class="text-input w200" value="${restInfoVo.restOpenTime}" />
	    </p>
	    <p>
	        <label>送餐结束时间</label>
	        <input name="detailRestCloseTime" type="text" class="text-input w200" value="${restInfoVo.restCloseTime}" />
	    </p>
	    <p>
	        <label>送餐半径</label>
	        <input name="detailTakeAwayRadius" type="text" class="text-input w200" value="${restInfoVo.takeAwayRadius}" />
	    </p>
	    <p>
	        <label>起送价格</label>
	        <input name="detailSendingAmount" type="text" class="text-input w200" value="${restInfoVo.sendingAmount}" />
	    </p>
	    <p>
	        <label>网络打印机ID</label>
	        <input name="detailPrinterId" type="text" class="text-input w200" value="${restInfoVo.printerId}" />
	    </p>
	    <p>
	        <label>启用/禁用</label>
	        <input name="detailRestEnabled" type="radio" class="vm" value="true" ${restInfoVo.restEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
	        <input name="detailRestEnabled" type="radio" class="vm" value="false" ${restInfoVo.restEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
	    </p>
	</div>
	
	<div class="column-right">
		<p>
	        <label>送餐费用</label>
	        <input name="detailTakeAwayFee" type="text" class="text-input w200" value="${restInfoVo.takeAwayFee}" />
	    </p>
	    <p>
	        <label>送餐费用说明</label>
	        <input name="detailTakeAwayDesc" type="text" class="text-input w200" value="${restInfoVo.takeAwayDesc}" />
	    </p>
	    <p>
	        <label>联系电话</label>
	        <input name="detailRestPhone" type="text" class="text-input w200" value="${restInfoVo.restPhone}" />
	    </p>
	    <p>
	    	<label>所属城市</label>
	        <input id="detailCityShow" type="text" class="dropdown w200" readonly="readonly" value="${restInfoVo.cityInfoVo.cityName}" />
			<div id="detailCityList" class="dropdown-content">
				<ul>
					<li><a href="javascript:void(0);" value="21">天津</a></li>
				</ul>
			</div>
	        <input name="detailCityInfoVo.cityId" id="detailCityVal" type="hidden" value="${restInfoVo.cityInfoVo.cityId}" />
	    </p>
		<p>
	    	<label>订单传输类型</label>
	        <input id="detailOrderTransTypeShow" type="text" class="dropdown w200" readonly="readonly" value="${restInfoVo.orderTransTypeVo.orderTransTypeName} -- ${restInfoVo.orderTransTypeVo.orderTransTypeCode}" />
			<div id="detailOrderTransTypeList" class="dropdown-content">
				<ul>
					<li><a href="javascript:void(0);" value="1">电话 -- PHONE</a></li>
					<li><a href="javascript:void(0);" value="2">短信 -- SMS</a></li>
					<li><a href="javascript:void(0);" value="3">电子邮件 -- EMAIL</a></li>
					<li><a href="javascript:void(0);" value="4">客户端 -- CLIENT</a></li>
					<li><a href="javascript:void(0);" value="5">打印机 -- PRINTER</a></li>
				</ul>
			</div>
	        <input name="detailOrderTransTypeVo.orderTransTypeId" id="detailOrderTransTypeVal" type="hidden" value="${restInfoVo.orderTransTypeVo.orderTransTypeId}" />
	    </p>
	    <p>
	    	<label>餐馆类型</label>
	        <input id="detailCookingTypeShow" type="text" class="dropdown w200" readonly="readonly" value="${restInfoVo.cookingTypeVo.cookingTypeName}" />
			<div id="detailCookingTypeList" class="dropdown-content">
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
	        <input name="detailCookingTypeVo.cookingTypeId" id="detailCookingTypeVal" type="hidden" value="${restInfoVo.cookingTypeVo.cookingTypeId}" />
	    </p>
		<p>
	        <label>生效时间</label>
	        <input id="detailRestStartTime" name="detailRestStartTime" type="text" readonly="readonly" class="date-txt w200" value="${restInfoVo.restStartTime}" />
	    </p>
	    <p>
	        <label>失效时间</label>
	        <input id="detailRestEndTime" name="detailRestEndTime" type="text" readonly="readonly" class="date-txt w200" value="${restInfoVo.restEndTime}" />
	    </p>
	    <p>
	        <label>打印联数</label>
	        <input id="detailPrintJointNumShow" type="text" class="dropdown w200" readonly="readonly" value="" />
			<div id="detailPrintJointNumList" class="dropdown-content">
				<ul>
					<li><a href="javascript:void(0);" value="2">二联</a></li>
					<li><a href="javascript:void(0);" value="3">三联</a></li>
				</ul>
			</div>
	        <input name="detailPrintJointNum" id="detailPrintJointNumVal" type="hidden" value="${restInfoVo.printJointNum}" />
	    </p>
	    <p>
	        <label>是否签约</label>
	        <input name="detailRestSigned" type="radio" class="vm" value="true" ${restInfoVo.restSigned?string('checked="checked"', '')} /> <span class="vm">已签</span>
	        <input name="detailRestSigned" type="radio" class="vm" value="false" ${restInfoVo.restSigned?string('', 'checked="checked"')} /> <span class="vm">未签</span>
	    </p>
	</div>
	
	<div class="cb"></div>
    
    <div>
        <p>
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button" onclick="javascript:cmap.save('${rc.contextPath}/adminRestMgr/edit/${restInfoVo.restId}', 'restListHint', 'Pagination', 'restMgrForm', 'cbDetailInfo');">保 存</a>
            <a id="btnDetailClose" href="javascript:void(0);" class="button" onclick="javascript:cmap.close('cbDetailInfo', true);">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
cmap.bindingSelectEvent('detail', 'City');
cmap.bindingSelectEvent('detail', 'OrderTransType');
cmap.bindingSelectEvent('detail', 'CookingType');
cmap.bindingSelectEvent('detail', 'PrintJointNum');
</script>
