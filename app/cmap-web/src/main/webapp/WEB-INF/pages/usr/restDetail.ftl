<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>餐地图</title>
<#include "/common/usrCommon.ftl" />
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
						<a>${tmpDishSort.dishSortName}</a>
					</li>
					</#list>
					</#if>
				</ul>
				
				<div class="food-list-wrapper"> <!-- BEGIN food-list-wrapper -->
					
					<#if dishSortList?? && dishList??>
					<#list dishSortList as tmpDishSort>
					<h1 class="food-sort-title">${tmpDishSort.dishSortName}</h1>
					<table class="food-list">
						<#list dishList as tmpDish>
						<#if tmpDishSort.dishSortId == tmpDish.dishSortVo.dishSortId>
						<tr>
							<td class="lh15">
								${tmpDish.dishName}<br />
								<#if tmpDish.dishDesc??><span>${tmpDish.dishDesc}</span></#if>
							</td>
							<td class="tc w100">${tmpDish.dishPrice?string.currency}</td>
							<td class="tc w50">&nbsp;</td>
							<td class="tr w100">
								<a href="#">加入订单</a>
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
				<span class="order-count">共&nbsp;XX&nbsp;份美食</span>
			</p>
			<p class="price-box">
				<span>总价：</span>
				<span class="fc-orange">&yen;99746.20</span>
			</p>
			
			<ul class="my-order-list">
				<li class="bg-order">
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				<li>
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				<li class="bg-order">
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				<li>
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				<li class="bg-order">
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
				<li>
					<span class="del-food">删除</span>
					<h2>辣翅巨无霸</h2>
					<div>
						<span class="unit-price">&yen;195.00</span>
						<a href="#" class="sub-count">&nbsp;</a><span class="cate-num">1</span><a href="#" class="add-count">&nbsp;</a>
						<span class="subtotal-price">&yen;15.00</span>
					</div>
				</li>
			</ul>
			
			<a href="#" class="small-btn">去结算</a>
			
			<div class="fold-box">
				<a href="#">
					<span class="arrow-up">&nbsp;</span>
					<span class="vm">收起</span>
				</a>
				<!--
				<a href="#">
					<span class="arrow-down">&nbsp;</span>
					<span class="vm">打开</span>
				</a>
				-->
			</div>
			
		</div> <!-- END my-order-wrapper -->
		
		<div class="cb"></div>
	
	</div> <!-- END cnt-wrapper -->
	
</div> <!-- END main-cnt -->

<#include "/common/usrFooter.ftl" />
<#include "/common/pngFix.ftl" />

</body>
</html>
