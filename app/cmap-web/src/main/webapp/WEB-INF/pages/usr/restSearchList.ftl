<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>餐地图</title>
<#include "/common/usrCommon.ftl" />
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/jquery.pagination.js"></script>
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function() {
	cmap.searchRestListInit('searchRestListForm', '${rc.contextPath}/rest/count', 'Pagination', 'restCountShow');
	cmap.initPagination('Pagination', ${restCount}, 9);
	$($("#cookingType a").get(${cookingTypeId})).addClass("filter-choose");
});

function pageselectCallback(pageIndex, jq) {
	cmap.paging('searchRestListForm', '${rc.contextPath}/rest', pageIndex, 'restList');
}
</script>
</head>

<body>

<#include "/common/usrHeader.ftl" />

<div id="main-cnt"> <!-- BEGIN main-cnt -->

	<div id="cnt-wrapper"> <!-- BEGIN cnt-wrapper -->
	
		<h1 class="current-addr">
			<span class="ico-pin">&nbsp;</span>
			<span class="addr-desp">${restSearchFormVo.customerAddr}</span>
			<a href="/${rc.contextPath}">重选地点</a>
		</h1>
		
		<div class="rest-list-wrapper"> <!-- BEGIN rest-list-wrapper -->
			
			<h2>选餐条件</h2>
			<ul id="restFarAway" class="rest-filter-list">
				<li>距你多远：</li>
				<li><a class="filter-choose">随便</a></li>
				<li><a>500米以内</a></li>
				<li><a>1公里以内</a></li>
				<li><a>2公里以内</a></li>
			</ul>
			
			<ul id="cookingType" class="rest-filter-list">
				<li>菜式类别：</li>
				<li><a>随便</a></li>
				<li><a>中餐</a></li>
				<li><a>西餐</a></li>
				<li><a>韩式料理</a></li>
				<li><a>日式料理</a></li>
				<li><a>清真</a></li>
				<li><a>南亚菜</a></li>
				<li><a>零食/饮料</a></li>
				<li><a>快餐</a></li>
			</ul>
			
			<div class="restaurant-count">
				共搜索到&nbsp;<span id="restCountShow">${restCount}</span>&nbsp;家餐馆
			</div>
			
			<div class="h549">
				<ul id="restList" class="rest-list">
					<li>&nbsp;</li>
					<li>&nbsp;</li>
					<li class="last">&nbsp;</li>
					<li>&nbsp;</li>
					<li>&nbsp;</li>
					<li class="last">&nbsp;</li>
					<li>&nbsp;</li>
					<li>&nbsp;</li>
					<li class="last">&nbsp;</li>
				</ul>
			</div>
			
			<div class="paging-box">
				<span id="Pagination" class="pagination"></span>
				到第 <input id="pageNum" type="text" maxlength="3" /> 页
				<a id="btnGo" href="#" class="btn-go">GO</a>
			</div>
			
		</div> <!-- END rest-list-wrapper -->
	
	</div> <!-- END cnt-wrapper -->
	
</div> <!-- END main-cnt -->

<#include "/common/usrFooter.ftl" />
<#include "/common/pngFix.ftl" />

<form id="searchRestListForm">
	<input type="hidden" name="restFarWayId" id="restFarWayId" value="0" />
	<input type="hidden" name="cookingTypeId" id="cookingTypeId" value="${restSearchFormVo.cookingTypeId}" />
	<input type="hidden" name="cityId" id="cityId" value="${restSearchFormVo.cityId}" />
	<input type="hidden" name="customerLng" id="customerLng" value="${restSearchFormVo.customerLng}" />
	<input type="hidden" name="customerLat" id="customerLat" value="${restSearchFormVo.customerLat}" />
</form>

<form id="detailParamsForm" name="detailParamsForm" method="post" action="${rc.contextPath}/detail">
	<input type="hidden" name="customerLng" id="customerLng" value="${restSearchFormVo.customerLng}" />
	<input type="hidden" name="customerLat" id="customerLat" value="${restSearchFormVo.customerLat}" />
	<input type="hidden" name="customerAddr" value="${restSearchFormVo.customerAddr}" />
	<input id="restId" name="restId" type="hidden" />
	<input id="btnSubmit" type="submit" />	
</form>

</body>
</html>
