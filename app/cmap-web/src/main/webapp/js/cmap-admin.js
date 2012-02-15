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
	
	initAdminPage : function(ctxPath) {
		
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
					url: ctxPath + "/adminMenu/" + $(this).attr("id"),
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
	
	showHintMsg : function (showId, hintType, msg) {
		
		$("#" + showId).slideUp("normal", function() {
		
			var hintHtml = $("#hint-wrapper .hint" + "-" + hintType).html().replace("[hintmsg]", msg);
		
			$("#" + showId).addClass("hint-" + hintType);
			$("#" + showId).html(hintHtml);
			
			cmap.bindHindBoxClick(showId);
			$("#" + showId).slideDown();
		
		});
		
	}, 
	
	bindHindBoxClick : function(boxId) {
		$("#" + boxId + " a").click(function() {
			$(this).parent().slideUp();
		});
	}, 
	
	cleanBox : function (boxId) {
		$("#" + boxId + " input[type='text']").val('');
		$($("#" + boxId + " input[type='radio']").get(0)).attr("checked", true);
		$("#" + boxId + " input[type='hidden']").val('');
	}, 
	
	callBackOptForCb : function (cbId, jsonStr, hintBoxId) {
	
		var type = $.evalJSON(jsonStr).hintType;
		var msg = $.evalJSON(jsonStr).hintMsg;
		
		if ("success" == type) {
			$("#" + cbId).slideUp("normal", function() {
				cmap.showHintMsg(hintBoxId, type, msg);
				cmap.cleanBox(cbId);
			});
		} else {
			cmap.showHintMsg(hintBoxId, type, msg);
		}
		
	}, 
	
	initPagination : function (paginationId, maxItemNum) {
		$("#" + paginationId).pagination(maxItemNum, {
			callback: pageselectCallback, 
			prev_text: '&lt;&lt; 上一页', 
			next_text: '下一页 &gt;&gt;', 
			num_display_entries: 4, 
			num_edge_entries: 1
		}); 
	}, 
	
	chooseAll : function (inputName) {
		if ($(this).attr("checked")) {
			$(this).attr("checked", false);
			$("input[name='" + inputName + "']").attr("checked", false);
		} else {
			$(this).attr("checked", true);
			$("input[name='" + inputName + "']").attr("checked", true);
		}
	}, 
	
	enableDisabled : function (obj, reqUrl, hintBoxId) {
		$.ajax({
			type: "PUT", 
			url: reqUrl, 
			success: function (msg) {
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					var imgSrc = $(obj).children().attr("src");
					if (imgSrc.indexOf("bulb-on") != -1) {
						imgSrc = imgSrc.replace(/bulb-on/, "bulb-off");
					} else {
						imgSrc = imgSrc.replace(/bulb-off/, "bulb-on");
					}
					$(obj).children().attr("src", imgSrc);
				}
				
				cmap.showHintMsg(hintBoxId, msgType, msgContent);
			}
		});
	}, 
	
	del : function (reqUrl, hintBoxId, paginationId, formId) {
		var params = $("#" + formId).formSerialize();
		$.ajax({
			type: "DELETE", 
			url: reqUrl, 
			data: params, 
			success: function (msg) {
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					cmap.initPagination(paginationId, parseInt($.evalJSON(msg).recordCount));
				}
				
				cmap.showHintMsg(hintBoxId, msgType, msgContent);
			}
		});
	}, 
	
	edit : function (reqUrl, detailBoxId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$("#" + detailBoxId).slideUp("normal", function() {
			$("#" + detailBoxId).empty();
			$.ajax({
				type: "GET", 
				url: reqUrl, 
				success: function (msg) {
					$("#" + detailBoxId).empty().append(msg);
					dialog.close();
					$("#" + detailBoxId).slideDown();
				}
			});
		});
	}, 
	
	close : function (contentBoxId, emptyFlag) {
		$("#" + contentBoxId).slideUp("normal", function() {
			if (emptyFlag) {
				$("#" + contentBoxId).empty();
			}
		});
	}, 
	
	save : function (reqUrl, hintBoxId, paginationId, formId, contentBoxId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		var params = $("#" + formId).formSerialize();
		$.ajax({
			type: "PUT", 
			url: reqUrl, 
			data: params, 
			success: function (msg) {
				dialog.close();
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					cmap.initPagination(paginationId, parseInt($.evalJSON(msg).recordCount));
					$("#" + contentBoxId).slideUp("normal", function() {
						$("#" + contentBoxId).empty();
					});
				}
				
				cmap.showHintMsg(hintBoxId, msgType, msgContent);
			}
		});
	}
	
};