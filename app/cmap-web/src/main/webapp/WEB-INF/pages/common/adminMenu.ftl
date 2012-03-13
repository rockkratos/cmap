<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<ul id="main-nav"><!-- BEGIN left menu -->
    
    <@sec.authorize url="/adminMenu/menuRestMgr" method="GET">
    <li>
        <a id="menuRestMgr" href="javascript:void(0);" class="nav-top-item no-submenu">餐馆管理</a>
    </li>
    </@sec.authorize>
    
    <@sec.authorize ifAnyGranted="ROLE_SUPER_ADMIN">
    <li>
        <a href="javascript:void(0);" class="nav-top-item">用户管理</a>
        <ul class="submenu">
        	
        	<@sec.authorize url="/adminMenu/menuCustomerMgr" method="GET">
            <li><a id="menuCustomerMgr" href="javascript:void(0);">前台用户</a></li>
            </@sec.authorize>
            
            <@sec.authorize url="/adminMenu/menuUsrMgr" method="GET">
            <li><a id="menuUsrMgr" href="javascript:void(0);">后台用户</a></li>
            </@sec.authorize>
            
        </ul>
    </li>
    </@sec.authorize>
    
    <@sec.authorize ifAnyGranted="ROLE_SUPER_ADMIN">
    <li>
        <a href="javascript:void(0);" class="nav-top-item">权限管理</a>
        <ul class="submenu">
        	
        	<@sec.authorize url="/adminMenu/menuPrivilegeCfg" method="GET">
            <li><a id="menuPrivilegeCfg" href="javascript:void(0);">权限配置</a></li>
            </@sec.authorize>
            
            <@sec.authorize url="/adminMenu/menuRoleCfg" method="GET">
            <li><a id="menuRoleCfg" href="javascript:void(0);">角色维护</a></li>
            </@sec.authorize>
            
            <@sec.authorize url="/adminMenu/menuRoleBinding" method="GET">
            <li><a id="menuRoleBinding" href="javascript:void(0);">角色绑定</a></li>
            </@sec.authorize>
            
        </ul>
    </li>
    </@sec.authorize>
    
    <li>
        <a id="menuChangePwd" href="javascript:void(0);" class="nav-top-item no-submenu">修改密码</a>
    </li>
    
</ul><!-- END left menu -->
