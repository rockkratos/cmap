<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<form id="roleBindingForm">

<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">角色绑定</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
    
    <li>
    	<a id="privilegeCfgLink" class="shortcut-button" href="#">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/privilege.png" alt="icon" /><br />
        		权限配置
    		</span>
		</a>
	</li>
	
	<li>
    	<a id="roleCfgLink" class="shortcut-button" href="javascript:void(0);">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role.png" alt="icon" /><br />
        		角色维护
    		</span>
		</a>
	</li>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbRoleBinding" class="content-box">
	
	<div class="content-box-header"><h3>角色绑定</h3></div>
    
    <div class="content-box-content clearfix">
    	
    	<div class="column-left">
			<label>角色列表</label>
        	<ul id="roleList" class="cb-list mb20"></ul>
        </div>
    	
        <div class="column-right">
            <p>
                <label>用户类型</label>
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
                <input name="usrTypeId" id="usrTypeVal" type="hidden" />
            </p>
            <p>
                <label>启用/禁用</label>
                <input name="usrTypeEnabled" type="radio" class="vm" checked="checked" value="true" /> <span class="vm">启用</span>
                <input name="usrTypeEnabled" type="radio" class="vm" value="false" /> <span class="vm">禁用</span>
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnRoleBinding" href="javascript:void(0);" class="button">保 存</a>
                <a id="btnCleanRoleBinding" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
    </div>
    
</div><!-- END content-box -->

</form>

<script type="text/javascript" language="javascript">
$("#usrTypeShow").click(function() { cmap.showDropDownList($(this), 'usrTypeList'); });
$("#usrTypeShow").blur(function() { cmap.dropDownListBlur('usrTypeList'); });

$("#usrTypeList a").click(function() {
	cmap.updateDropDownListVal($(this), 'usrTypeVal', 'usrTypeShow');
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	loadRoleList(dialog);
});

$("#privilegeCfgLink").click(function() { $("#menuPrivilegeCfg").click(); });
$("#roleCfgLink").click(function() { $("#menuRoleCfg").click(); });

$("#btnCleanRoleBinding").click(function() { cmap.cleanBox('cbRoleBinding'); $("#roleList").empty(); });

$("#btnRoleBinding").click(function() {
	var dialog = new Dialog(loadingPanel);
	dialog.show();
	var reqUrl = "${rc.contextPath}/adminUsrTypeRole/edit/" + $("#usrTypeVal").val();
	var params = $("#roleBindingForm").formSerialize();
	$.ajax({
		type: "PUT", 
		url: reqUrl, 
		data: params, 
		success: function (msg) {
			var msgType = $.evalJSON(msg).hintType;
			var msgContent = $.evalJSON(msg).hintMsg;
			if ("success" == msgType) {
				loadRoleList(dialog);
			}
			cmap.showHintMsg('topHint', msgType, msgContent);
		}
	});
});

function loadRoleList(dialog) {
	var reqUrl = "${rc.contextPath}/adminUsrTypeRole/" + $("#usrTypeVal").val();
	$.ajax({
		type: "GET", 
		url: reqUrl, 
		success: function (msg) {
			var roleList = $.evalJSON(msg).roleList;
			var usrTypeEnabled = $.evalJSON(msg).usrTypeEnabled;
			
			if (null != roleList) {
				$("#roleList").empty().append(roleList);
			}
			
			if ("true" == usrTypeEnabled) {
				$($("input[name='usrTypeEnabled']").get(0)).attr("checked", true);
			} else {
				$($("input[name='usrTypeEnabled']").get(1)).attr("checked", true);
			}
			
			dialog.close();
		}
	});
}
</script>