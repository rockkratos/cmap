<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
    	<p>
            <label>电子邮箱*</label>
            <input name="detailUsrEmail" type="text" class="text-input w200" readonly="readonly" value="${usrInfoVo.usrEmail}" />
        </p>
        <p>
            <label>手机号*</label>
            <input name="detailUsrCell" type="text" class="text-input w200" value="${usrInfoVo.usrCell}" />
        </p>
        <p>
            <label>重设密码</label>
            <input id="detailLoginPwd" name="loginPwd" type="password" class="text-input w200" />
        </p>
        <p>
            <label>确认密码</label>
            <input id="detailCfmPwd" name="cfmPwd" type="password" class="text-input w200" />
        </p>
    </div>
    
    <div class="column-right">
    	<p>
            <label>昵称</label>
            <input name="detailNickName" type="text" class="text-input w200" value="${usrInfoVo.nickName!}" />
        </p>
        <p>
            <label>真实姓名</label>
            <input name="detailRealName" type="text" class="text-input w200" value="${usrInfoVo.realName!}" />
        </p>
        <p>
            <label>启用/禁用*</label>
            <input name="detailUsrEnabled" type="radio" class="vm" value="true" ${usrInfoVo.usrEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailUsrEnabled" type="radio" class="vm" value="false" ${usrInfoVo.usrEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
    </div>
    
    <div class="cb"></div>
    
    <div>
        <p>
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button">保 存</a>
            <a id="btnDetailClose" href="javascript:void(0);" class="button">关 闭</a>
        </p>
    </div>
    
</div>

<script type="text/javascript" language="javascript">
$("#btnDetailUpdate").click(function() { cmap.save('${rc.contextPath}/adminCustomerMgr/edit/${usrInfoVo.usrId}', 'usrListHint', 'Pagination', 'usrMgrForm', 'cbDetailInfo'); });
$("#btnDetailClose").click(function() { cmap.close('cbDetailInfo', true); });

cmap.bindingSelectEvent('detail', 'usrType');
</script>
