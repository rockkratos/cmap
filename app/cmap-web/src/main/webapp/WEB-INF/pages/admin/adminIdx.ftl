<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Canditu admin</title>
<#include "/common/adminCommon.ftl" />
<script type="text/javascript" language="javascript">
$(document).ready(function(){
	cmap.initAdminPage('${rc.contextPath}');
});
</script>
</head>

<body>

<div id="container">
	
	<div id="left-sidebar">
		
		<img id="logo" alt="Cmap Admin Logo" src="${rc.contextPath}/imgs/admin/cmapadmin-logo.png" />
			
		<div id="profile-links"><!-- BEGIN profile links -->
			<img src="${rc.contextPath}/imgs/admin/icons/current-user.png" />
			<span class="vm mr10">当前用户</span>
			<img src="${rc.contextPath}/imgs/admin/icons/logout.png" />
			<a href="${rc.contextPath}/admin/logout" class="vm">注销</a>
		</div><!-- END profile links -->
		
        <#include "/common/adminMenu.ftl" />
        
	</div>
		
	<div id="main-content">
		
		
		
	</div>
    
    <div class="cb"></div>
	
</div>

<div id="footer">
	<div>
		&#169; Copyright 2011 Canditu | Powered by <a href="#">Canditu Admin</a> | <a href="#">Top</a>
	</div>
</div>
<#include "/common/adminHintBox.ftl" />
<#include "/common/pngFix.ftl" />
</body>
</html>