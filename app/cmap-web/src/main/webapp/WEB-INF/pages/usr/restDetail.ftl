<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>餐地图</title>
<#include "/common/usrCommon.ftl" />
<script type="text/javascript" language="javascript">
$(document).ready(function() {
	
	$("#linkCloseOrder").click(function() {
		$("ul.my-order-list").slideUp("normal", function() {
			$("#linkCloseOrder").css("display", "none");
			$("#linkOpenOrder").css("display", "block");
		});
	});
	
	$("#linkOpenOrder").click(function() {
		$("ul.my-order-list").slideDown("normal", function() {
			$("#linkOpenOrder").css("display", "none");
			$("#linkCloseOrder").css("display", "block");
		});
	});
	
	$("table.food-list a").click(function() {
	
		var dishId = $(this).next().val();
		var dishInfo = $(this).parent().parent().children();
		var dishName = $($(dishInfo[0]).children("span")[0]).text();
		var unitPrice = $(dishInfo[1]).text().substring(1);
		var dishItem = "<li id=\"" + dishId +  "\"><span class=\"del-food\">删除</span>" 
						    + "<h2>" + dishName + "</h2>" 
						    + "<div><span class=\"unit-price\">&yen;" + unitPrice + "</span>" 
						    + "<a href=\"javascript:void(0);\" class=\"sub-count\">&nbsp;</a><span class=\"cate-num\">1</span><a href=\"javascript:void(0);\" class=\"add-count\">&nbsp;</a>" 
						    + "<span class=\"subtotal-price\">&yen;" + unitPrice + "</span></div></li>";
		var totalAmount = parseFloat($("span.fc-orange").text().substring(1));
		
		if ($(this).text() == "加入订单") {
		
			$(this).text("移出订单");
			$(dishInfo[2]).html($("#chooseDish").html());
			$("ul.my-order-list").append(dishItem);
			var price = cmap.formatNumber(totalAmount + parseFloat(unitPrice), 2);
			$("span.fc-orange").text("¥" + price);
			
			var totalNbr = parseInt($("#totalNbr").text());
			$("#totalNbr").text(++totalNbr);
			
			$("li#" + dishId + " a.sub-count").click(function() {
				var dishCountObj = $(this).next();
				var dishCount = parseInt($(dishCountObj).text());
				if (dishCount == 1) {
					return;
				}
				$(dishCountObj).text(--dishCount);
				var amount = parseFloat($("span.fc-orange").text().substring(1));
				var price = cmap.formatNumber(amount - parseFloat(unitPrice), 2);
				$("span.fc-orange").text("¥" + price);
				var sumPrice = parseFloat($("li#" + dishId + " span.subtotal-price").text().substring(1));
				var newSumPrice = cmap.formatNumber(sumPrice - parseFloat(unitPrice), 2);
				$("li#" + dishId + " span.subtotal-price").text("¥" + newSumPrice);
				var totalNbr = parseInt($("#totalNbr").text());
				$("#totalNbr").text(--totalNbr);
			});
			
			$("li#" + dishId + " a.add-count").click(function() {
				var dishCountObj = $(this).prev();
				var dishCount = parseInt($(dishCountObj).text());
				$(dishCountObj).text(++dishCount);
				var amount = parseFloat($("span.fc-orange").text().substring(1));
				var price = cmap.formatNumber(amount + parseFloat(unitPrice), 2);
				$("span.fc-orange").text("¥" + price);
				var sumPrice = parseFloat($("li#" + dishId + " span.subtotal-price").text().substring(1));
				var newSumPrice = cmap.formatNumber(sumPrice + parseFloat(unitPrice), 2);
				$("li#" + dishId + " span.subtotal-price").text("¥" + newSumPrice);
				var totalNbr = parseInt($("#totalNbr").text());
				$("#totalNbr").text(++totalNbr);
			});
			
			$("li#" + dishId + " span.del-food").click(function() {
				var sumPrice = parseFloat($("li#" + dishId + " span.subtotal-price").text().substring(1));
				var amount = parseFloat($("span.fc-orange").text().substring(1));
				var newAmount = cmap.formatNumber(amount - sumPrice, 2);
				$("span.fc-orange").text("¥" + newAmount);
				var dishCount = parseInt($("li#" + dishId + " span.cate-num").text());
				var totalNbr = parseInt($("#totalNbr").text());
				$("#totalNbr").text(totalNbr - dishCount);
				$("li#" + dishId).remove();
				$("ul.my-order-list li").removeClass("bg-order");
				$("ul.my-order-list li:even").addClass("bg-order");
				var dish = $("input[value='" + dishId + "']").parent().parent().children();
				$(dish[2]).html("");
				$("input[value='" + dishId + "']").prev().text("加入订单");
				
				if ($("ul.my-order-list li").length == 0) {
					$("div.fold-box a").css("display", "none");
				}
				
			});
			
			if ($("ul.my-order-list").css("display") == "none" && $("ul.my-order-list li").length > 0) {
				$("ul.my-order-list").css("display", "block");
				$("#linkCloseOrder").css("display", "block");
			} else if ($("ul.my-order-list li").length > 0 && $("#linkCloseOrder").css("display") == "none") {
				$("#linkCloseOrder").css("display", "block");
			}
			
		} else {
		
			$(this).text("加入订单");
			$(dishInfo[2]).html("");
			var dishCount = parseInt($("li#" + dishId + " span.cate-num").text());
			var totalNbr = parseInt($("#totalNbr").text());
			$("#totalNbr").text(totalNbr - dishCount);
			var sumPrice = parseFloat($("li#" + dishId + " span.subtotal-price").text().substring(1));
			var price = cmap.formatNumber(totalAmount - sumPrice, 2);
			$("span.fc-orange").text("¥" + price);
			$("li#" + dishId).remove();
			
			if ($("ul.my-order-list li").length == 0) {
				$("div.fold-box a").css("display", "none");
			}
			
		}
		
		$("ul.my-order-list li").removeClass("bg-order");
		$("ul.my-order-list li:even").addClass("bg-order");
		
	});
	
});
</script>
</head>

<body>

<#include "/common/usrHeader.ftl" />

<div id="main-cnt"> <!-- BEGIN main-cnt -->
	
	<div id="cnt-wrapper"> <!-- BEGIN cnt-wrapper -->
	
		<h1 class="current-addr">
			<span class="ico-pin"></span>
			<span class="addr-desp">${customerAddr}</span>
			<a href="${rc.contextPath}">重选地点</a>
		</h1>
		
		<div class="step-wrapper first-wrapper">
			<div class="first-step current">选择美食</div>
			<div class="second-step undone">填写订单</div>
			<div class="third-step undone">完成订餐</div>
		</div>
	
		<div id="wood-wrapper"> <!-- BEGIN wood-wrapper -->
			
			<span class="rest-logo">
				<ul>
					<li class="mb10">
						<img src="${rc.contextPath}/imgs/restlogo/logos.gif" />
					</li>
				</ul>
			</span>
			
			<div class="cb"></div>
			
			<h1 class="rest-name-title">${restInfo.restName}</h1>
			
			<div class="menu-wrapper clearfix"> <!-- BEGIN menu-wrapper -->
				
				<ul class="shop-info">
					<li>
						本店地址：${restInfo.restAddr}
					</li>
					<li>
						送餐时间：${restInfo.restOpenTime}&nbsp;-&nbsp;${restInfo.restCloseTime}
					</li>
					<li>
						起送金额：<span class="deliver-fee">${restInfo.sendingAmount?string.currency}</span>&nbsp;起送
					</li>
					<li>
						送餐费用：${restInfo.takeAwayFee?string.currency}<#if restInfo.takeAwayDesc??>&nbsp;/&nbsp;<span class="fb">3km</span>内免费</#if>
					</li>
				</ul>
				
				<div class="contact-wrapper">
					<ul class="contact-list">
						<li><label>联系电话</label></li>
						<li>${restInfo.restPhone}</li>
					</ul>
				</div>
				
				<div class="cb h30"></div>
				
				<ul class="food-sort">
					<#if dishSortList??>
					<#list dishSortList as tmpDishSort>
					<li>
						<a href="#sort${tmpDishSort_index}">${tmpDishSort.dishSortName}</a>
					</li>
					</#list>
					</#if>
				</ul>
				
				<div class="food-list-wrapper"> <!-- BEGIN food-list-wrapper -->
					
					<#if dishSortList?? && dishList??>
					<#list dishSortList as tmpDishSort>
					<h1 class="food-sort-title"><a id="sort${tmpDishSort_index}" name="sort${tmpDishSort_index}"></a>${tmpDishSort.dishSortName}</h1>
					<table class="food-list">
						<#list dishList as tmpDish>
						<#if tmpDishSort.dishSortId == tmpDish.dishSortVo.dishSortId>
						<tr>
							<td class="lh15">
								<span>${tmpDish.dishName}</span>
								<#if tmpDish.dishDesc??><br /><span>${tmpDish.dishDesc}</span></#if>
							</td>
							<td class="tc w100">${tmpDish.dishPrice?string.currency}</td>
							<td class="tc w50">&nbsp;</td>
							<td class="tr w100">
								<a href="javascript:void(0);">加入订单</a>
								<input type="hidden" value="${tmpDish.dishId}" />
							</td>
						</tr>
						</#if>
						</#list>
					</table>
					</#list>
					</#if>
					
				</div><!-- END food-list-wrapper -->
				
				<div class="cb"></div>
				
			</div><!-- END menu-wrapper -->
			
		</div> <!-- END wood-wrapper -->
		
		<div class="my-order-wrapper"> <!-- BEGIN my-order-wrapper -->
			
			<p class="order-title-box">
				<span class="order-title">我的订单</span>
				<span class="order-count">共&nbsp;<span id="totalNbr">0</span>&nbsp;份美食</span>
			</p>
			<p class="price-box">
				<span>总价：</span>
				<span class="fc-orange">&yen;0.00</span>
			</p>
			
			<ul class="my-order-list">
				<!--
				<li class="bg-order">
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				-->
			</ul>
			
			<a href="#" class="small-btn">打电话</a>
			
			<div class="fold-box">
				<a id="linkCloseOrder" href="javascript:void(0);" class="dn">
					<span class="arrow-up">&nbsp;</span>
					<span class="vm">收起</span>
				</a>
				<a id="linkOpenOrder" href="javascript:void(0);" class="dn">
					<span class="arrow-down">&nbsp;</span>
					<span class="vm">打开</span>
				</a>
			</div>
			
		</div> <!-- END my-order-wrapper -->
		
		<div class="cb"></div>
	
	</div> <!-- END cnt-wrapper -->
	
</div> <!-- END main-cnt -->

<#include "/common/usrFooter.ftl" />
<#include "/common/pngFix.ftl" />

<div id="chooseDish" class="dn">
	<span class="ico-tick">&nbsp;</span>
</div>

</body>
</html>
