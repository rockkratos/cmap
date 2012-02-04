var cmap = {
	
	submitForm : function(submitFlag, formName) {
		if (submitFlag) {
			$("form[name='" + formName + "']").submit();
		}
	}, 
	
	checkAdminLoginInfo : function(componentId, errmsg) {
		if ($("#" +componentId).val() == "") {
			$("#errmsg span").text(errmsg);
			$("#errmsg").removeClass("dn");
			return false;
		}
		
		return true;
	}, 
	
	checkLoginInfo : function() {
		var flag = cmap.checkAdminLoginInfo("login_usrname", "用户名不能为空");
		flag = flag && cmap.checkAdminLoginInfo("login_usrpwd", "密码不能为空");
		return flag;
	}
	
};