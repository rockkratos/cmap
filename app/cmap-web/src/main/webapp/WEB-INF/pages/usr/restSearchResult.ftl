<#list restList as tmpRest>

<#if tmpRest.restId??>

<li <#if ((tmpRest_index + 1) % 3) == 0>class="last"</#if>>
	<#if tmpRest.restStatus == 0>
	<span class="ico-rest">休息中</span>
	</#if>
	<a id="${tmpRest.restId}" href="#" <#if tmpRest.restStatus == 0>class="closed"</#if>>
		<#if tmpRest.bigLogoName??>
		<div class="rest-pic-wrapper"><img src="${rc.contextPath}/imgs/restlogo/${tmpRest.bigLogoName}" /></div>
		<#else>
		<div class="rest-pic-wrapper"><img <#if tmpRest.restStatus == 0>class="closed"</#if> src="${rc.contextPath}/imgs/restlogo/logob.gif" /></div>
		</#if>
		<ul class="rest-detail-list">
			<li class="tc"><h3 title="${tmpRest.restName}"><#if (tmpRest.restName?length > 7)>${tmpRest.restName?substring(0, 7)}...<#else>${tmpRest.restName}</#if></h3></li>
			<li>送餐时间：${tmpRest.restOpenTime}-${tmpRest.restCloseTime}</li>
			<!--
			<li>起送价格：${tmpRest.sendingAmount?string.currency}</li>
			<li>送餐费用：<#if tmpRest.takeAwayFee == 0>--<#else>${tmpRest.takeAwayFee?string.currency}</#if></li>
			-->
			<li>送餐半径：${tmpRest.takeAwayRadius}km</li>
		</ul>
	</a>
</li>

<#else>

<li <#if ((tmpRest_index + 1) % 3) == 0>class="last"</#if>>&nbsp;</li>

</#if>

</#list>

<script  type="text/javascript" language="javascript">
$("#restList a").click(function() {
	var restId = $(this).attr("id");
	$("#restId").val(restId);
	$("#btnSubmit").click();
});
</script>
