var clear="../imgs/clear.gif"; //path to clear.gif
var loadingPanel = '<div class="loading-wrapper"><span>系统处理中...</span></div>';

var cmap = {
	
	submitForm: function(submitFlag, formName) {
		if (submitFlag) {
			$("form[name='" + formName + "']").submit();
		}
	}, 
	
	checkAdminLoginInfo: function(componentId, errmsg) {
		if ($("#" +componentId).val() == "") {
			$("#errmsg span").text(errmsg);
			$("#errmsg").removeClass("dn");
			return false;
		}
		
		return true;
	}, 
	
	checkLoginInfo: function() {
		var flag = cmap.checkAdminLoginInfo("login_usrname", "用户名不能为空");
		flag = flag && cmap.checkAdminLoginInfo("login_usrpwd", "密码不能为空");
		return flag;
	}, 
	
	initAdminPage: function(ctxPath) {
		
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
	
		$("#main-nav li a.no-submenu").click(
			function () {
				$("#main-nav a").removeClass("current");
				$(this).addClass("current");
				cmap.loadPage(ctxPath, $(this).attr("id"));
			}
		);
	
		$("ul.submenu li a").click(
			function () {
				$("#main-nav a").removeClass("current");
				$(this).parent().parent().prev().addClass("current");
				$(this).addClass("current");
				cmap.loadPage(ctxPath, $(this).attr("id"));
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
	
	loadPage: function (ctxPath, menuId) {
		var reqUrl = ctxPath + "/adminMenu/" + menuId;
		cmap.flushMainContent(reqUrl);
	}, 
	
	flushMainContent: function(reqUrl) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$.ajax({
			type: "GET",
			url: reqUrl,
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				dialog.close();				
				$("#main-content").fadeOut("normal", function () {
					$("#main-content").html(msg);
					$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
					$("#main-content").fadeIn("normal");
				});
			}
		});
	}, 
	
	triggerContentBox: function (closeId, triggerId) {
		
		var closeCb = "#" + closeId;
		var triggerCb = "#" + triggerId;
		
		$(closeCb).slideUp();
		
		if ($(triggerCb).css("display") == "none") {
			$(triggerCb).slideDown();
		} else {
			$(triggerCb).slideUp();
		}
		
	}, 
	
	showDropDownList: function (self, dropDownListId) {
		var left = $(self).offset().left;
		var top = $(self).offset().top;
		var height = $(self).height();
		var width = $(self).width();
		
		$("#" + dropDownListId).css("top", top + height + 3);
		$("#" + dropDownListId).css("left", left);
	
		$("#" + dropDownListId + " ul").css("width", width + 12);
		
		$("#" + dropDownListId).slideDown();
	}, 
	
	dropDownListBlur: function (dropDownListId) {
		$("#" + dropDownListId).slideUp();
	}, 
	
	updateDropDownListVal: function (self, valId, showId) {
		$("#" + showId).val($(self).text());
		$("#" + valId).val($(self).attr("value"));
	}, 
	
	showHintMsg: function (showId, hintType, msg) {
		
		$("#" + showId).slideUp("normal", function() {
			
			var hintHtml = $("#hint-wrapper .hint" + "-" + hintType).html().replace("[hintmsg]", msg);
			
			$("#" + showId).removeClass();
			$("#" + showId).addClass("hint-box");
			$("#" + showId).addClass("dn");
			$("#" + showId).addClass("hint-" + hintType);
			$("#" + showId).html(hintHtml);
			
			cmap.bindHindBoxClick(showId);
			$("#" + showId).slideDown();
		
		});
		
	}, 
	
	bindHindBoxClick: function(boxId) {
		$("#" + boxId + " a").click(function() {
			$(this).parent().slideUp();
		});
	}, 
	
	cleanBox: function (boxId) {
		$("#" + boxId + " input[type='text']").val('');
		$("#" + boxId + " input[type='radio'][value='true']").attr("checked", true);
		$("#" + boxId + " input[type='hidden']").val('');
		$("#" + boxId + " input[type='checkbox']").attr("checked", false);
		$("#" + boxId + " input[type='password']").val('');
	}, 
	
	callBackOptForCb: function (cbId, jsonStr, hintBoxId, paginationId) {
		
		var type = $.evalJSON(jsonStr).hintType;
		var msg = $.evalJSON(jsonStr).hintMsg;
		
		if ("success" == type) {
			cmap.initPagination(paginationId, parseInt($.evalJSON(jsonStr).recordCount));
			$("#" + cbId).slideUp("normal", function() {
				cmap.showHintMsg(hintBoxId, type, msg);
				cmap.cleanBox(cbId);
			});
		} else {
			cmap.showHintMsg(hintBoxId, type, msg);
		}
		
	}, 
	
	initPagination: function (paginationId, maxItemNum) {
		$("#" + paginationId).pagination(maxItemNum, {
			callback: pageselectCallback, 
			prev_text: '&lt;&lt; 上一页', 
			next_text: '下一页 &gt;&gt;', 
			num_display_entries: 4, 
			num_edge_entries: 1
		}); 
	}, 
	
	chooseAll: function (inputName) {
		if ($(this).attr("checked")) {
			$(this).attr("checked", false);
			$("input[name='" + inputName + "']").attr("checked", false);
		} else {
			$(this).attr("checked", true);
			$("input[name='" + inputName + "']").attr("checked", true);
		}
	}, 
	
	enableDisabled: function (obj, reqUrl, hintBoxId) {
		cmap.close('cbDetailInfo', true);
		$.ajax({
			type: "PUT", 
			url: reqUrl, 
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
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
	
	del: function (reqUrl, hintBoxId, paginationId, formId) {
		cmap.close('cbDetailInfo', true);
		var params = $("#" + formId).formSerialize();
		$.ajax({
			type: "DELETE", 
			url: reqUrl, 
			data: params, 
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					cmap.initPagination(paginationId, parseInt($.evalJSON(msg).recordCount));
				}
				
				cmap.showHintMsg(hintBoxId, msgType, msgContent);
			}
		});
	}, 
	
	edit: function (reqUrl, detailBoxId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$("#" + detailBoxId).slideUp("normal", function() {
			$("#" + detailBoxId).empty();
			$.ajax({
				type: "GET", 
				url: reqUrl, 
				success: function (msg) {
					if (cmap.isLoginPage(msg)) {
						cmap.redirectToLogin();
					}
					$("#" + detailBoxId).empty().append(msg);
					dialog.close();
					$("#" + detailBoxId).slideDown();
				}
			});
		});
	}, 
	
	close: function (contentBoxId, emptyFlag) {
		$("#" + contentBoxId).slideUp("normal", function() {
			if (emptyFlag) {
				$("#" + contentBoxId).empty();
			}
		});
	}, 
	
	setDefault: function (reqUrl, hintBoxId, paginationId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$.ajax({
			type: "PUT", 
			url: reqUrl, 
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				dialog.close();
				var msgType = $.evalJSON(msg).hintType;
				var msgContent = $.evalJSON(msg).hintMsg;
				
				if ("success" == msgType) {
					cmap.initPagination(paginationId, parseInt($.evalJSON(msg).recordCount));
				}
				
				cmap.showHintMsg(hintBoxId, msgType, msgContent);
			}
		});
	}, 
	
	save: function (reqUrl, hintBoxId, paginationId, formId, contentBoxId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		var params = $("#" + formId).formSerialize();
		$.ajax({
			type: "PUT", 
			url: reqUrl, 
			data: params, 
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
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
	}, 
	
	create: function (formId, reqUrl, cbId, hintId, paginationId) {
		var params = $("#" + formId).formSerialize();
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$.ajax({
			type: "POST",
			url: reqUrl,
			data: params,
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				dialog.close();
				cmap.callBackOptForCb(cbId, msg, hintId, paginationId);
			}
		});
	}, 
	
	paging: function (formId, reqUrl, pageIndex, listId, checkBoxName) {
		var params = $("#" + formId).formSerialize();
	 	$.ajax({
	 		type: "GET",
			url: reqUrl,
			data: params + "&pageIndex=" + pageIndex,
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				var firstLine = "<tr>" + $(".zebra-tab tr").first().html() + "</tr>";
				$("table.zebra-tab tr:not(:last)").remove();
				$("table.zebra-tab tr:last").before(firstLine + msg);
				$("table.zebra-tab tr:nth-child(even)").addClass("tab-bg");
				$("#" + listId + " input[class='check-all']").click(function() {cmap.chooseAll(checkBoxName);});
			}
	 	});
	}, 
	
	query: function (formId, reqUrl, paginationId, cbId) {
		var params = $("#" + formId).formSerialize();
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$.ajax({
			type: "GET", 
			url: reqUrl,
			data: params, 
			success: function (msg) {
				if (cmap.isLoginPage(msg)) {
					cmap.redirectToLogin();
				}
				cmap.initPagination(paginationId, parseInt(msg));
				dialog.close();
				$("#" + cbId).slideUp();
			}
		});
	}, 
	
	bindingSelectEvent: function (prefix, key) {
		var prefixId = '';
		if (prefix != '') {
			prefixId = prefix + key.substring(0, 1).toUpperCase( ) + key.substring(1);
		} else {
			prefixId = key;
		}
		var showId = prefixId + "Show";
		var listId = prefixId + "List";
		var valId = prefixId + "Val";
		$("#" + showId).click(function() { cmap.showDropDownList($(this), listId); });
		$("#" + showId).blur(function() { cmap.dropDownListBlur(listId); });
		$("#" + listId + " a").click(function() { cmap.updateDropDownListVal($(this), valId, showId); });
	}, 
	
	isLoginPage: function (msg) {
		var regex = /Canditu Admin Login/;
		return regex.exec(msg) != null ? true : false;
	}, 
	
	redirectToLogin: function () {
		window.location.href = "/cmapweb/admin/login";
	}, 
	
	uploadPic: function(reqUrl, fileInputId, hintBoxId, resetBtnId, previewId) {
		var dialog = new Dialog(loadingPanel);
		dialog.show();
		$.ajaxFileUpload({
			url: reqUrl, 
			secureuri: false, 
			fileElementId: fileInputId, 
			dataType: 'text', 
			success: function(data, status) {
				dialog.close();
				var msgType = $.evalJSON(data).hintType;
				var msgContent = $.evalJSON(data).hintMsg;
				var picPath=$.evalJSON(data).picPath;
				if ("success" == msgType) {
					$("#" + resetBtnId).click();
				}
				$("#" + previewId).attr("src", picPath);
				cmap.showHintMsg(hintBoxId, msgType, decodeURIComponent(msgContent));
			}
		});
	}
	
};