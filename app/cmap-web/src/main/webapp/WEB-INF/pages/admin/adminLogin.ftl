<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Canditu Admin Login</title>
<link type="text/css" rel="stylesheet" rev="stylesheet" media="screen" href="${rc.contextPath}/css/base.css" />
<link type="text/css" rel="stylesheet" rev="stylesheet" media="screen" href="${rc.contextPath}/css/admin-login.css" />
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="${rc.contextPath}/js/cmap-admin.js"></script>
</head>

<body>

<form name="adminLoginForm" method="post" action="${rc.contextPath}/admin/logincheck">

<div id="login-wrapper">
	
	<div id="login-top">
		<img id="logo" src="${rc.contextPath}/imgs/admin/cmapadmin-logo.png" alt="Canditu Admin LOGO">
	</div>
	
</div> <!-- End #login-wrapper -->

<div id="login-content">
	
	<div id="errmsg-container">
		<#if SPRING_SECURITY_LAST_EXCEPTION??>
		<div id="errmsg">
			<img src="${rc.contextPath}/imgs/admin/icons/warning.gif" class="vm" />
			<span class="vm">${SPRING_SECURITY_LAST_EXCEPTION.message!}</span>
		</div>
		<#else>
		<div id="errmsg" class="dn">
			<img src="${rc.contextPath}/imgs/admin/icons/warning.gif" class="vm" />
			<span class="vm"></span>
		</div>
		</#if>
	</div>
	
	<div id="login-container">
		<p>
			<label>用户名</label>
			<input id="login_usrname" name="login_usrname" class="text-input" type="text" value="${usr.loginName!}" />
		</p>
		<div class="cb"></div>
		<p>
			<label>密&nbsp;&nbsp;&nbsp;码</label>
			<input id="login_usrpwd" name="login_usrpwd" class="text-input" type="password" value="" />
		</p>
		<div class="cb"></div>
		<p>
			<a href="#" class="login-btn">登 录</a>
		</p>
	</div>
	
</div> <!-- End #login-content -->

</form>

<script type="text/javascript" language="javascript">
$(function(){
	$("a[class='login-btn']").click(function(){
		cmap.submitForm(cmap.checkLoginInfo(), "adminLoginForm");
	});
	
	$("#login_usrpwd").keydown(function(e) {
		if (e.keyCode == 13) {
			cmap.submitForm(cmap.checkLoginInfo(), "adminLoginForm");
		}
	});
	
	$("#login_usrname").focus();
});
</script>

<#include "/common/pngFix.ftl" />
</body>
</html>