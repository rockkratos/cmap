var loadingPanel = '<div class="loading-wrapper"><span>系统处理中...</span></div>';

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
	}, 
	
	initAdminPage : function() {
		
		if (!$.browser.mozilla && !($.browser.msie && $.browser.version == 9)) {
			$("#main-content").css("margin-bottom", "50px");
		}
		
		$("#main-nav li ul").hide(); // Hide all sub menus
		$("#main-nav li a.current").parent().find("ul").slideToggle("slow"); // Slide down the current menu item's sub menu
		
		$("#main-nav li a.nav-top-item").click( // When a top menu item is clicked...
			function () {
				$(this).parent().siblings().find("ul").slideUp("normal"); // Slide up all sub menus except the one clicked
				$(this).next().slideToggle("normal"); // Slide down the clicked sub menu
				return false;
			}
		);
	
		$("#main-nav li a.no-submenu").click( // When a menu item with no sub menu is clicked...
			function () {
				window.location.href = (this.href); // Just open the link instead of a sub menu
				$("#main-nav a").removeClass("current");
				$(this).addClass("current");
				return false;
			}
		);
	
		$("ul.submenu li a").click(
			function () {
				$("#main-nav a").removeClass("current");
				$(this).parent().parent().prev().addClass("current");
				$(this).addClass("current");
				var dialog = new Dialog(loadingPanel);
				dialog.show();
				$.ajax({
					type: "GET",
					url: "/cmapweb/adminMenu/" + $(this).attr("id"),
					success: function (msg) {
						dialog.close();
						$("#main-content").fadeOut("normal", function () {
							$("#main-content").html(msg);
							$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
							$("#main-content").fadeIn("normal");
						});
					}
				});
			}
		);
		
		$("#main-nav li .nav-top-item").hover(
			function () {
				$(this).stop().animate({ paddingRight: "25px" }, 200);
			}, 
			function () {
				$(this).stop().animate({ paddingRight: "15px" });
			}
		);
		
		$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
		
		$("#hint-wrapper a").click(function() {
			$(this).parent().slideUp();
		});
		
	}, 
	
	triggerContentBox : function (closeId, triggerId) {
		
		var closeCb = "#" + closeId;
		var triggerCb = "#" + triggerId;
		
		$(closeCb).slideUp();
		
		if ($(triggerCb).css("display") == "none") {
			$(triggerCb).slideDown();
		} else {
			$(triggerCb).slideUp();
		}
		
	}, 
	
	showDropDownList : function (self, dropDownListId) {
		var left = $(self).offset().left;
		var top = $(self).offset().top;
		var height = $(self).height();
		var width = $(self).width();
		
		$("#" + dropDownListId).css("top", top + height + 15);
		$("#" + dropDownListId).css("left", left);
	
		$("#" + dropDownListId + " ul").css("width", width + 12);
		
		$("#" + dropDownListId).slideDown();
	}, 
	
	dropDownListBlur : function (dropDownListId) {
		$("#" + dropDownListId).slideUp();
	}, 
	
	updateDropDownListVal : function (self, valId, showId) {
		$("#" + showId).val($(self).text());
		$("#" + valId).val($(self).attr("value"));
	}, 
	
	showHintMsg : function (showId, jsonStr) {
		 var type = $.evalJSON(jsonStr).hintType;
		 var msg = $.evalJSON(jsonStr).hintMsg;
		 var hintHtml = $(".hint" + "-" + type).html().replace("[hintmsg]", msg);
		 $("#" + showId).addClass("hint-" + type);
		 $("#" + showId).html(hintHtml);
		 $("#" + showId).slideDown();
	}
	
};