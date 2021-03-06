<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="deliveryAddrForm">

<div id="page-title">
	<ul>
		<li class="main-title">用户管理</li>
		<li class="sub-title">前台用户</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminDeliveryAddr/{id}" method="POST">
    <li>
        <a id="addDeliveryAddrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增地址
            </span>
        </a>
    </li>
    </@sec.authorize>
	
	<@sec.authorize url="/adminMenu/menuCustomerMgr" method="GET">
	<li>
        <a id="customerLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/customer.png" alt="icon" /><br />
				前台用户
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminMenu/menuUsrMgr" method="GET">
    <li>
        <a id="adminUsrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/admin-usr.png" alt="icon" /><br />
				后台用户
            </span>
        </a>
    </li>
    </@sec.authorize>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<@sec.authorize url="/adminDeliveryAddr/{id}" method="POST">
<div id="cbAddDeliveryAddr" class="content-box dn">
	
	<div class="content-box-header"><h3>新增地址</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="deliveryAddrVo">
    	
        <div class="column-left">
        	<p>
                <label>详细地址*</label>
                <input name="specAddr" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>联系电话*</label>
                <input name="phoneNbr" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddDeliveryAddr" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddDeliveryAddr" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->
</@sec.authorize>

<div id="deliveryAddrList" class="content-box">
		
	<div class="content-box-header">
		<h3>${usrName} -- 地址列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="deliveryAddrListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>地址</th>
				<th>电话</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="4" class="tab-btm pb10">
					
					<div class="bulk-actions fl">&nbsp;</div>
					
					<div id="Pagination" class="pagination fr"></div>
					
				</td>
				
            </tr>
            
        </table>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbDetailInfo" class="content-box dn"></div><!-- detail info box -->

</form>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDeliveryAddr/{id}" method="POST">
$("#addDeliveryAddrLink").click(function() { cmap.triggerContentBox('', 'cbAddDeliveryAddr'); });
$("#btnAddDeliveryAddr").click(function() { cmap.create('deliveryAddrForm', '${rc.contextPath}/adminDeliveryAddr/${usrId}', 'cbAddDeliveryAddr', 'topHint', 'Pagination'); });
$("#btnCleanAddDeliveryAddr").click(function() { cmap.cleanBox('cbAddDeliveryAddr'); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuCustomerMgr" method="GET">
$("#adminUsrLink").click(function() { $("#menuUsrMgr").click(); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuUsrMgr" method="GET">
$("#customerLink").click(function() { $("#menuCustomerMgr").click(); });
</@sec.authorize>

<@sec.authorize url="/adminDeliveryAddr/{id}" method="GET">
cmap.initPagination("Pagination", ${deliveryAddrCount});
function pageselectCallback(pageIndex, jq) { cmap.paging('deliveryAddrForm', '${rc.contextPath}/adminDeliveryAddr/list/${usrId}', pageIndex, 'deliveryAddrList', 'listDeliveryAddrId'); }
</@sec.authorize>
</script>
