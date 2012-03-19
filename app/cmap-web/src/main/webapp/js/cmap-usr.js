var defaultSearchTxt = "请输入你所在的楼盘/小区/写字楼，如：南京路新天地大厦";
var myVal, map, mark, infoWindow, cnt;
var cmap = {
	
	isNumber: function (e) {
		if ($.browser.msie) {
			if ((event.keyCode > 47) && (event.keyCode < 58) || event.keyCode == 8) {
				return true;
			} else {
				return false;
			}
		} else {
			if ((e.which > 47) && (e.which < 58) || e.which == 8) {
				return true;
			} else {
				return false;
			}
        }
    }, 
	
	flushSearchRestList: function(formId, reqUrl, paginationId, showNumId) {
		var params = $("#" + formId).formSerialize();
		$.ajax({
			type: "GET", 
			url: reqUrl, 
			data: params, 
			success: function (msg) {
				$("#" + showNumId).html(msg);
				cmap.initPagination(paginationId, parseInt(msg), 9);
			}
		});
	}, 
	
	paging: function(formId, reqUrl, pageIndex, listId) {
		$("#restList").fadeOut("normal", function() {
			var params = $("#" + formId).formSerialize();
			$.ajax({
	 			type: "GET",
				url: reqUrl,
				data: params + "&pageIndex=" + pageIndex,
				success: function (msg) {
					$("#" + listId).html(msg);
					$("#" + listId).fadeIn();
				}
	 		});
		});
	}, 
	
	goBtnPagination: function (paginationId, maxItemNum, pageShowNum, currentPage) {
		$("#" + paginationId).pagination(maxItemNum, {
			callback: pageselectCallback, 
			prev_text: '&lt;&lt;', 
			next_text: '&gt;&gt;', 
			num_display_entries: 4, 
			num_edge_entries: 1, 
			items_per_page: pageShowNum, 
			current_page: currentPage
		}); 
	}, 
	
	initPagination: function (paginationId, maxItemNum, pageShowNum) {
		$("#" + paginationId).pagination(maxItemNum, {
			callback: pageselectCallback, 
			prev_text: '&lt;&lt;', 
			next_text: '&gt;&gt;', 
			num_display_entries: 4, 
			num_edge_entries: 1, 
			items_per_page: pageShowNum
		}); 
	}, 
	
	searchRestListInit: function(formId, reqUrl, paginationId, showNumId) {
		$("#restFarAway a").each(function(i) {
			$(this).click(function() {
				$("#restFarAway a.filter-choose").removeClass("filter-choose");
				$(this).addClass("filter-choose");
				$("#restFarWayId").val(i);
				cmap.flushSearchRestList(formId, reqUrl, paginationId, showNumId);
			});
		});
		
		$("#cookingType a").each(function(i) {
			$(this).click(function() {
				$("#cookingType a.filter-choose").removeClass("filter-choose");
				$(this).addClass("filter-choose");
				$("#cookingTypeId").val(i);
				cmap.flushSearchRestList(formId, reqUrl, paginationId, showNumId);
			});
		});
		
		$("#pageNum").keypress(function(event) {
			return cmap.isNumber(event);
		});
		
		$("#btnGo").click(function() {
			var count = parseInt($("#restCountShow").html());
			var re = /^\d{1,3}$/;
			var pageNum = $("#pageNum").val();
			var pageTotalNum = Math.ceil(count / 9);
			if (re.test(pageNum)) {
				if (pageNum > pageTotalNum) {
					$("#pageNum").val(pageTotalNum);
					cmap.goBtnPagination('Pagination', count, 9, pageTotalNum - 1);
				} else {
					cmap.goBtnPagination('Pagination', count, 9, pageNum - 1);
				}
			}
		});
	}, 
	
	idxInit: function(ctxPath) {
		
		$("#film-cnt").easySlider({auto:true,continuous:true});
		$("#film-wrapper").find("span").remove();
		
		$("ul.cook-type-list a").each(function(i) {
			$(this).click(function() {
				$("ul.cook-type-list li").siblings(".current").removeClass("current");
				$(this).parent().addClass("current");
				$("#cookingTypeId").val(i);
			});
		});
		
		cmap.checkText($("#searchTxt"));
		
		map = new BMap.Map("map-container");
		map.centerAndZoom($("#localCity").val(), 15);
		cmap.setMapEvent(map);//设置地图事件
		cmap.addMapControl(map);//添加地图控件
		
		cmap.setAutocomplete(ctxPath);//设置自动完成
		
		//绑定主页搜索按钮点击函数
		$("#btnSearch").click(function() {
			if($("#searchTxt").val() == defaultSearchTxt || $("#searchTxt").val() == ""){
				$("#prompt-info").css("display", "block");
				return;
			}
			$("#searchTxt").blur();
			myVal = $("#localCity").val() + " " + $("#searchTxt").val();
			cmap.initMapSearch(ctxPath);
		});
		
		$("#close-map").click(function(){cmap.closeMap();});//绑定关闭地图函数
		
	}, 
	
	//地图事件设置函数
	setMapEvent: function() {
		map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
	}, 
	
	//地图控件添加函数
    addMapControl: function(map) {
		var ctrlNav = new BMap.NavigationControl({anchor : BMAP_ANCHOR_TOP_LEFT, type : BMAP_NAVIGATION_CONTROL_LARGE}); //向地图中添加缩放控件
		map.addControl(ctrlNav);
    }, 
	
	//设置 Autocomplete
	setAutocomplete: function(ctxPath) {
		var ac = new BMap.Autocomplete({"location" : $("#localCity").val(), "input" : "searchTxt"});
		ac.addEventListener("onconfirm", function(e) { //鼠标点击下拉列表后的事件
			var clickVal = e.item.value;
			myVal = $("#localCity").val() + clickVal.province + clickVal.city + clickVal.district + clickVal.street + clickVal.business;
			cmap.initMapSearch(ctxPath);
		});
	}, 
	
	initMapSearch: function(ctxPath) {
		$("#main-cnt").hide();
		$("#map-wrapper").show();
		
		var localService;
		
		function searchService() {
			map.clearOverlays(); //清除地图障碍物
			var localNow = localService.getResults().getPoi(0); //获得第一个搜索结果
			if (localNow == null) {
				myVal = $("#localCity").val();
				localService.search(myVal);
				return;
			}
			var point = localNow.point; //获得搜索结果的第一个点的经纬度
			mark = cmap.getMarker(point, ctxPath); //创建mark
			//给marker添加InfoWindow组件用以显示当前位置的信息
			cnt = "<div id='my-local' style='margin:2px;font-size:14px;color:#f00;'>" 
				+ localNow.title 
				+ "</div><hr color='#ccc' size='1'/><div style='margin:2px;'>您在这附近吗？<a class='map-search-btn' onclick='javascript:cmap.searchRest();'>搜附近餐馆</a></div><div style='margin:2px;'>不在这？拖动我试试</div>";
			infoWindow = new BMap.InfoWindow(cnt);
			infoWindow.disableCloseOnClick();
			map.addOverlay(mark);//添加标注
			mark.openInfoWindow(infoWindow);//打开信息窗口
			//将地图中心移动到point中心
			map.setCenter(point);
			map.setZoom(17);
		}
		
		localService = new BMap.LocalSearch(map, {onSearchComplete:searchService}); //构建搜索服务对象
		localService.search(myVal); //开始搜索
	}, 
	
	//构造Marker
	getMarker: function(point, ctxPath) {
		mark = new BMap.Marker(point, {enableDragging : true, icon : new BMap.Icon(ctxPath + "/imgs/usr/marker.png", new BMap.Size(55,55))});
		mark.enableDragging();//mark允许拖动
		mark.addEventListener("dragend", function() {
			cnt = "<div id='my-local' style='margin:2px;font-size:14px;color:#f00;'>你所处的位置</div><hr color='#ccc' size='1'/><div style='margin:2px;'>您在这附近吗？<a class='map-search-btn' onclick='javascript:cmap.searchRest();'>搜附近餐馆</a></div>";	
			infoWindow.setContent(cnt);//重新设置infoWindow的content
			infoWindow.redraw();//重画infoWindow
			mark.openInfoWindow(infoWindow);//打开
			map.setCenter(mark.getPosition());
		});
		return mark;
	}, 
	
	checkText: function(searchTxtObj) {
		$(searchTxtObj).focus(function() {
			$("#prompt-info").css("display", "none");
			if ($(this).val() == defaultSearchTxt) {	
				$(this).val("");
				$(this).css("color", "#000");
			}
		});
		$(searchTxtObj).blur(function(){
			if ($(this).val() == "") {
				$(this).css("color", "#999");
				$(this).val(defaultSearchTxt);
			}
		});
	}, 
	
	//关闭地图函数
	closeMap: function() {
		$("#map-wrapper").hide();
		$("#main-cnt").show();
	}, 
	
	searchRest: function() {
		$("#customerLng").val(mark.getPosition().lng);
		$("#customerLat").val(mark.getPosition().lat);
		$("#customerAddr").val($("#my-local").text());
		$("#btnSubmit").click();
	}
	
};	
