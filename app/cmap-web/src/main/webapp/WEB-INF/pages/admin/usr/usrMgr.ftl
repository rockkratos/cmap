<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="usrMgrForm">

<div id="page-title">
	<span>用户管理</span>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addUsrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
				新增用户
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryUsrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
				查询用户
            </span>
        </a>
    </li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbAddUsr" class="content-box dn">
	
	<div class="content-box-header"><h3>新增用户</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<@spring.bind path="usrInfoVo">
    	
        <div class="column-left">
        	<p>
            	<label>用户类型*</label>
                <input id="usrTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="usrTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">管理员 -- ADMIN</a></li>
						<li><a href="javascript:void(0);" value="2">普通用户 -- CUSTOMER</a></li>
						<li><a href="javascript:void(0);" value="3">餐馆用户 -- REST</a></li>
						<li><a href="javascript:void(0);" value="4">客服用户 -- SERVICE</a></li>
						<li><a href="javascript:void(0);" value="5">营销用户 -- MARKET</a></li>
						<li><a href="javascript:void(0);" value="6">业务用户 -- BUSINESS</a></li>
					</ul>
				</div>
                <input name="usrTypeVo.usrTypeId" id="usrTypeVal" type="hidden" />
            </p>
            <p>
                <label>登录名*</label>
                <input name="loginName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>登录密码*</label>
                <input id="loginPwd" name="loginPwd" type="password" class="text-input w200" />
            </p>
            <p>
                <label>确认密码*</label>
                <input id="cfmPwd" name="cfmPwd" type="password" class="text-input w200" />
            </p>
            <p>
                <label>启用/禁用*</label>
                <input name="usrEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="usrEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>手机号*</label>
                <input name="usrCell" type="text" class="text-input w200" />
            </p>
            <p>
                <label>电子邮箱*</label>
                <input name="usrEmail" type="text" class="text-input w200" />
            </p>
        	<p>
                <label>昵称</label>
                <input name="nickName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>真实姓名</label>
                <input name="realName" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddUsr" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanAddUsr" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
        </@spring.bind>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbQueryUsr" class="content-box dn">
	
	<div class="content-box-header"><h3>查询条件</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
            	<label>用户类型</label>
                <input id="queryUsrTypeShow" type="text" class="dropdown w200" readonly="readonly" />
				<div id="queryUsrTypeList" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1">管理员 -- ADMIN</a></li>
						<li><a href="javascript:void(0);" value="2">普通用户 -- CUSTOMER</a></li>
						<li><a href="javascript:void(0);" value="3">餐馆用户 -- REST</a></li>
						<li><a href="javascript:void(0);" value="4">客服用户 -- SERVICE</a></li>
						<li><a href="javascript:void(0);" value="5">营销用户 -- MARKET</a></li>
						<li><a href="javascript:void(0);" value="6">业务用户 -- BUSINESS</a></li>
					</ul>
				</div>
                <input name="queryUsrTypeVo.usrTypeId" id="queryUsrTypeVal" type="hidden" />
            </p>
        	<p>
                <label>昵称</label>
                <input name="queryNickName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>真实姓名</label>
                <input name="queryRealName" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="column-right">
        	<p>
                <label>登录名</label>
                <input name="queryLoginName" type="text" class="text-input w200" />
            </p>
            <p>
                <label>手机号</label>
                <input name="queryUsrCell" type="text" class="text-input w200" />
            </p>
            <p>
                <label>电子邮箱</label>
                <input name="queryUsrEmail" type="text" class="text-input w200" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnQueryUsr" href="javascript:void(0);" class="button">查 询</a>
                <a id="btnCleanQueryUsr" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
		
    </div>
    
</div><!-- END content-box -->

<div id="usrList" class="content-box">
		
	<div class="content-box-header">
		<h3>用户列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div id="usrListHint" class="hint-box dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>用户名</th>
				<th>手机号</th>
				<th>注册时间</th>
				<th>操作</th>
            </tr>
            
            <tr class="tab-bg-white">
            
            	<td colspan="5" class="tab-btm pb10">
					
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
$("#addUsrLink").click(function() { cmap.triggerContentBox('cbQueryUsr', 'cbAddUsr'); });
$("#queryUsrLink").click(function() { cmap.triggerContentBox('cbAddUsr', 'cbQueryUsr'); });

$("#usrTypeShow").click(function() { cmap.showDropDownList($(this), 'usrTypeList'); });
$("#usrTypeShow").blur(function() { cmap.dropDownListBlur('usrTypeList'); });
$("#usrTypeList a").click(function() { cmap.updateDropDownListVal($(this), 'usrTypeVal', 'usrTypeShow'); });

$("#queryUsrTypeShow").click(function() { cmap.showDropDownList($(this), 'queryUsrTypeList'); });
$("#queryUsrTypeShow").blur(function() { cmap.dropDownListBlur('queryUsrTypeList'); });
$("#queryUsrTypeList a").click(function() { cmap.updateDropDownListVal($(this), 'queryUsrTypeVal', 'queryUsrTypeShow'); });

$("#btnCleanAddUsr").click(function() { cmap.cleanBox('cbAddUsr'); });
$("#btnCleanQueryUsr").click(function() { cmap.cleanBox('cbQueryUsr'); });

$("#btnAddUsr").click(function() {
	var params = $("#usrMgrForm").formSerialize();
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "POST",
		url: "${rc.contextPath}/adminUsrMgr",
		data: params,
		success: function (msg) {
			dialog.close();
			cmap.callBackOptForCb('cbAddUsr', msg, 'topHint', 'Pagination');
		}
	});
});

$("#btnQueryUsr").click(function() {
	var params = $("#usrMgrForm").formSerialize();
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	$.ajax({
		type: "GET", 
		url: "${rc.contextPath}/adminUsrMgr/usrCount",
		data: params, 
		success: function (msg) {
			cmap.initPagination("Pagination", msg);
			dialog.close();
			$("#cbQueryUsr").slideUp();
		}
	});
});

cmap.initPagination("Pagination", ${usrCount});

function pageselectCallback(pageIndex, jq) {
	var params = $("#usrMgrForm").formSerialize();
 	$.ajax({
 		type: "GET",
		url: "${rc.contextPath}/adminUsrMgr",
		data: params + "&pageIndex=" + pageIndex,
		success: function (msg) {
			var firstLine = "<tr>" + $(".zebra-tab tr").first().html() + "</tr>";
			$("table.zebra-tab tr:not(:last)").remove();
			$("table.zebra-tab tr:last").before(firstLine + msg);
			$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
			$("#usrList input[class='check-all']").click(function() {cmap.chooseAll('listUsrId');});
		}
 	});
}
</script>
