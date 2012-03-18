<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>餐地图</title>
<script type="text/javascript" language="javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
<#include "/common/usrCommon.ftl" />
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/easySlider1.5.js"></script>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
	cmap.idxInit('${rc.contextPath}');
});
</script>
</head>

<body>

<#include "/common/usrHeader.ftl" />

<div id="map-wrapper" class="dn">
	<div id="close-map"><a href="javascript:void(0);"></a></div>
	<div id="map-container"></div>
</div>

<div id="main-cnt"> <!-- BEGIN main-cnt -->
	
	<div id="cnt-wrapper"> <!-- BEGIN cnt-wrapper -->
    	
		<div class="cmn-wrapper idx-wrapper clearfix"> <!-- BEGIN cmn-wrapper -->
			
			<div class="mb10">
				<span class="lbl eat-what"></span><!-- 吃点儿啥？ -->
			</div>
			
			<ul class="cook-type-list">
				<li class="casual-food current"><a>随便吃点</a></li>
				<li class="chinese-food"><a>中餐</a></li>
				<li class="west-food"><a>西餐</a></li>
				<li class="korea-food"><a>韩式料理</a></li>
				<li class="japan-food"><a>日式料理</a></li>
				<li class="islamic-food"><a>清真</a></li>
				<li class="south-asia-food"><a>南亚菜</a></li>
				<li class="sock-food"><a>零售/饮料</a></li>
				<li class="fast-food"><a>快餐</a></li>
			</ul>
			
			<div class="cb"></div>
			
			<div>
				<span class="lbl where-are-u"></span> <!-- 你在哪儿？ -->
				<div id="prompt-info">请输入你的大致方位以便地图搜索</div>
			</div>
			
			<div id="search-bar">
				<div id="search-bar-txt">
					<input id="localCity" class="txt-city" type="text" value="天津" /><input id="searchTxt" type="text" class="txt-address" value="请输入你所在的楼盘/小区/写字楼，如：南京路新天地大厦" />
				</div>
				<a id="btnSearch" href="#">
					<img src="${rc.contextPath}/imgs/usr/btn-search.png" />
				</a>
			</div>
			
			<div class="cb mb45"></div>
			
			<div id="film-wrapper"> <!-- BEGIN film-wrapper -->
				
        		<div id="prevBtn" class="toggle fl"><a href="javascript:void(0);">&lt;</a></div>
        		<div id="nextBtn" class="toggle fr"><a href="javascript:void(0);">&gt;</a></div>
				
        		<div id="film-cnt" class="fl"> <!-- BEGIN film-cnt -->
					<ul>
						<li>
							<div class="slide-pic">&nbsp;</div>
							<div class="slide-words-wrapper">
								<h1>基于您的地理位置的餐馆信息</h1>
								<p class="lh20">
									输入一个地理位置，即可获得附近指定距离内的餐馆详细信息。
								</p>
							</div>
						</li>
						<li>
							<div class="slide-pic type-choose">&nbsp;</div>
							<div class="slide-words-wrapper">
								<h1>餐饮信息分类搜索</h1>
								<p class="lh20">
									分类选取您附近感兴趣的美食，或者不限类别随便选。
								</p>
							</div>
						</li>
						<li>
							<div class="slide-pic sale-info">&nbsp;</div>
							<div class="slide-words-wrapper">
								<h1>随时获取促销信息</h1>
								<p class="lh20">
									搜索到餐馆的同时，更会获取您感兴趣的餐馆的美食促销信息。
								</p>
							</div>
						</li>
						<li>
							<div class="slide-pic quick-order">&nbsp;</div>
							<div class="slide-words-wrapper">
								<h1>迅速下单</h1>
								<p class="lh20">
									在线下单功能即将上线，合作餐馆将会有功能强大的即时终端<br />
									设备处理您的订单，保证美食即时送上门。
								</p>
							</div>
						</li>
					</ul>
				</div> <!-- END film-cnt -->
			
			</div> <!-- END film-wrapper -->
			
		</div> <!-- END cmn-wrapper -->
		
    </div> <!-- END cnt-wrapper -->
	
</div> <!-- END main-cnt -->

<#include "/common/usrFooter.ftl" />
<#include "/common/pngFix.ftl" />

<form id="idxForm" name="idxForm" method="post" action="${rc.contextPath}/rest">
	
	<@spring.bind path="restSearchForm">
	<input type="hidden" id="customerLng" name="customerLng" />
	<input type="hidden" id="customerLat" name="customerLat" />
	<input type="hidden" id="cookingTypeId" name="cookingTypeId" value="0" />
	<input type="hidden" id="customerAddr" name="customerAddr" />
	<input type="hidden" id="cityId" name="cityId" value="21" />
	</@spring.bind>
	
</form>

</body>
</html>
