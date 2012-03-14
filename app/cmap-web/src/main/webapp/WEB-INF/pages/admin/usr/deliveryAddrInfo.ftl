<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
    	<p>
            <label>详细地址*</label>
            <input name="detailSpecAddr" type="text" class="text-input w200" value="${deliveryAddrVo.specAddr}" />
        </p>
    </div>
    
    <div class="column-right">
    	<p>
            <label>联系电话*</label>
            <input name="detailPhoneNbr" type="text" class="text-input w200" value="${deliveryAddrVo.phoneNbr}" />
        </p>
    </div>
    
    <div class="cb"></div>
    
    <div>
        <p>
        	<@sec.authorize url="/adminDeliveryAddr/edit/{id}/{id}" method="PUT">
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button">保 存</a>
            </@sec.authorize>
            <a id="btnDetailClose" href="javascript:void(0);" class="button">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDeliveryAddr/edit/{id}/{id}" method="PUT">
$("#btnDetailUpdate").click(function() { cmap.save('${rc.contextPath}/adminDeliveryAddr/edit/${usrId}/${deliveryAddrVo.addrId}', 'deliveryAddrListHint', 'Pagination', 'deliveryAddrForm', 'cbDetailInfo'); });
</@sec.authorize>

$("#btnDetailClose").click(function() { cmap.close('cbDetailInfo', true); });
</script>
