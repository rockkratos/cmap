<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<form id="restLogoForm" name="restLogoForm" enctype="multipart/form-data">

<div id="page-title">
	<ul>
		<li class="main-title">餐馆管理</li>
		<li class="sub-title">餐馆LOGO</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
	<@sec.authorize url="/adminDishSort/{id}" method="GET">
    <li>
        <a id="dishSortLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/dish-sort.png" alt="icon" /><br />
				菜品分类
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminDishMgr/{id}" method="GET">
    <li>
        <a id="dishMgrLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/dish.png" alt="icon" /><br />
				菜品管理
            </span>
        </a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
	<li>
        <a id="restInfoLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/rest.png" alt="icon" /><br />
				餐馆信息
            </span>
        </a>
    </li>
    </@sec.authorize>
    
</ul>

<div id="topHint" class="hint-box dn"></div><!-- error msg wrapper -->

<div id="cbRestLogo" class="content-box">
	
	<div class="content-box-header"><h3>LOGO上传</h3></div>
    
    <div class="content-box-content clearfix">
    	
        <div class="column-left">
        	<p>
        		<label>大LOGO预览</label>
        		<#if restInfoVo.bigLogoName??>
        		<img id="bigLogo" width="118" height="118" src="${rc.contextPath}/imgs/restlogo/${restInfoVo.bigLogoName}" />
        		<#else>
        		<img id="bigLogo" width="118" height="118" src="${rc.contextPath}/imgs/restlogo/logob.gif" />
        		</#if>
        	</p>
            <p>
                <label>大LOGO上传</label>
                <input id="bigLogoFile" name="bigLogoFile" type="file" />
            </p>
            <p>
            	<a id="btnBigLogo" href="javascript:void(0);" class="button">上传大LOGO</a>
            </p>
        </div>
        
        <div class="column-right">
        	<p>
        		<label>小LOGO预览</label>
        		<#if restInfoVo.smallLogoName??>
        		<img id="smallLogo" width="118" height="118" src="${rc.contextPath}/imgs/restlogo/${restInfoVo.smallLogoName}" />
        		<#else>
        		<img id="smallLogo" width="118" height="118" src="${rc.contextPath}/imgs/restlogo/logos.gif" />
        		</#if>
        	</p>
        	<p>
                <label>小LOGO上传</label>
                <input id="smallLogoFile" name="smallLogoFile" type="file" />
            </p>
            <p>
            	<a id="btnSmallLogo" href="javascript:void(0);" class="button">上传小LOGO</a>
            </p>
        </div>
        
    </div>
    
</div><!-- END content-box -->

<input id="resetBtn" type="reset" class="dn" />

</form>

<script type="text/javascript" language="javascript">
<@sec.authorize url="/adminDishSort/{id}" method="GET">
$("#dishSortLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminDishSort/${restId}'); });
</@sec.authorize>

<@sec.authorize url="/adminDishMgr/{id}" method="GET">
$("#dishMgrLink").click(function() { cmap.flushMainContent('${rc.contextPath}/adminDishMgr/${restId}'); });
</@sec.authorize>

<@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
$("#restInfoLink").click(function() { $("#menuRestMgr").click(); });
</@sec.authorize>

$("#btnBigLogo").click(function() { cmap.uploadPic('${rc.contextPath}/adminRestMgr/upload/biglogo/${restId}', 'bigLogoFile', 'topHint', 'resetBtn', 'bigLogo') });
$("#btnSmallLogo").click(function() { cmap.uploadPic('${rc.contextPath}/adminRestMgr/upload/smalllogo/${restId}', 'smallLogoFile', 'topHint', 'resetBtn', 'smallLogo') });
</script>
