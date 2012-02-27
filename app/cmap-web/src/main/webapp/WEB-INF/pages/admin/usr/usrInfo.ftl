<div class="content-box-header">
	<h3>详细信息</h3>
</div>

<div class="content-box-content clearfix">
    
    <div class="column-left">
    	<p>
        	<label>用户类型*</label>
            <input id="detailUsrTypeShow" type="text" class="dropdown w200" readonly="readonly" value="${usrInfoVo.usrTypeVo.usrTypeDesc} -- ${usrInfoVo.usrTypeVo.usrTypeName}" />
			<div id="detailUsrTypeList" class="dropdown-content">
				<ul>
					<li><a href="javascript:void(0);" value="1">管理员 -- ADMIN</a></li>
					<li><a href="javascript:void(0);" value="2">普通用户 -- CUSTOMER</a></li>
					<li><a href="javascript:void(0);" value="3">餐馆用户 -- REST</a></li>
					<li><a href="javascript:void(0);" value="4">客服用户 -- SERVICE</a></li>
					<li><a href="javascript:void(0);" value="5">营销用户 -- MARKET</a></li>
					<li><a href="javascript:void(0);" value="6">业务用户 -- BUSINESS</a></li>
				</ul>
			</div>
            <input name="detailUsrTypeVo.usrTypeId" id="usrTypeVal" type="hidden" value="${usrInfoVo.usrTypeVo.usrTypeId}" />
        </p>
        <p>
            <label>登录名*</label>
            <input name="detailLoginName" type="text" class="text-input w200" value="${usrInfoVo.loginName}" <#if usrInfoVo.usrTypeVo.usrTypeId == 2>readonly="readonly"</#if> />
        </p>
        <p>
            <label>重设密码</label>
            <input id="detailLoginPwd" name="loginPwd" type="password" class="text-input w200" />
        </p>
        <p>
            <label>确认密码</label>
            <input id="detailCfmPwd" name="cfmPwd" type="password" class="text-input w200" />
        </p>
        <p>
            <label>启用/禁用*</label>
            <input name="detailUsrEnabled" type="radio" class="vm" value="true" ${usrInfoVo.usrEnabled?string('checked="checked"', '')} /> <span class="vm">启用</span>
            <input name="detailUsrEnabled" type="radio" class="vm" value="false" ${usrInfoVo.usrEnabled?string('', 'checked="checked"')} /> <span class="vm">禁用</span>
        </p>
    </div>
    
    <div class="column-right">
		<p>
            <label>手机号*</label>
            <input name="detailUsrCell" type="text" class="text-input w200" value="${usrInfoVo.usrCell}" />
        </p>
        <p>
            <label>电子邮箱*</label>
            <input name="detailUsrEmail" type="text" class="text-input w200" value="${usrInfoVo.usrEmail}" />
        </p>
    	<p>
            <label>昵称</label>
            <input name="detailNickName" type="text" class="text-input w200" value="${usrInfoVo.nickName}" />
        </p>
        <p>
            <label>真实姓名</label>
            <input name="detailRealName" type="text" class="text-input w200" value="${usrInfoVo.realName}" />
        </p>
    </div>
    
    <div class="cb"></div>
    
    <div>
        <p>
            <a id="btnDetailUpdate" href="javascript:void(0);" class="button" onclick="javascript:cmap.save('${rc.contextPath}/adminUsrMgr/edit/${usrInfoVo.usrId}', 'usrListHint', 'Pagination', 'usrMgrForm', 'cbDetailInfo');">保 存</a>
            <a id="btnDetailClose" href="javascript:void(0);" class="button" onclick="javascript:cmap.close('cbDetailInfo', true);">关 闭</a>
        </p>
    </div>
    
</div>