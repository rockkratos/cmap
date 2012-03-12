<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="changePwdForm">

<div id="page-title">
	<span>修改密码</span>
</div>

<div class="cb"></div>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbChangePwd" class="content-box">
	
	<div class="content-box-header">&nbsp;</div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
            <p>
                <label>旧密码*</label>
                <input id="oldPwd" name="oldPwd" type="password" class="text-input w200" />
            </p>
            <p>
                <label>新密码*</label>
                <input id="newPwd" name="newPwd" type="password" class="text-input w200" />
            </p>
            <p>
                <label>再输一次*</label>
                <input id="cfmPwd" name="cfmPwd" type="password" class="text-input w200" />
            </p>
        </div>
        
        <div class="column-right">&nbsp;</div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnChangePwd" href="javascript:void(0);" class="button">提 交</a>
                <a id="btnCleanChangePwd" href="javascript:void(0);" class="button">清 空</a>
            </p>
        </div>
        
    </div>
    
</div><!-- END content-box -->

</form>

<script type="text/javascript" language="javascript">
$("#btnChangePwd").click(function() {
	
	if ($("#oldPwd").val() == '') {
		cmap.showHintMsg('topHint', 'warning', "旧密码不能为空");
	} else if ($("#newPwd").val() == '') {
		cmap.showHintMsg('topHint', 'warning', "新密码不能为空");
	} else if ($("#cfmPwd").val() == '') {
		cmap.showHintMsg('topHint', 'warning', "确认新密码不能为空");
	} else if ($("#newPwd").val() != $("#cfmPwd").val()) {
		cmap.showHintMsg('topHint', 'error', "新密码两次输入不一致");
	} else {
		
		var params = $("#changePwdForm").formSerialize();
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		
		$.ajax({
			type: "PUT", 
			url: '${rc.contextPath}/adminUsrProfile/changePwd/<@sec.authentication property="principal.usrInfoVo.usrId" />',
			data: params, 
			success: function (msg) {
				dialog.close();
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					$("#btnCleanChangePwd").click();
				}
				
				cmap.showHintMsg('topHint', msgType, msgContent);
			}
		});
		
	}
	
});

$("#btnCleanChangePwd").click(function() { cmap.cleanBox('cbChangePwd'); });
</script>
