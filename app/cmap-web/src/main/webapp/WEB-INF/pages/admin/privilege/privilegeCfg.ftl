<div id="page-title">
	<ul>
		<li class="main-title">权限管理</li>
		<li class="sub-title">权限配置</li>
	</ul>
</div>

<div class="cb"></div>

<ul class="shortcut-buttons-set clearfix">
	
    <li>
        <a id="addPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/add.png" alt="icon" /><br />
                新增权限
            </span>
        </a>
    </li>
	
	<li>
        <a id="queryPrivilegeLink" class="shortcut-button" href="javascript:void(0);">
            <span>
                <img src="${rc.contextPath}/imgs/admin/icons/search.png" alt="icon" /><br />
                查询权限
            </span>
        </a>
    </li>
    
    <li>
    	<a class="shortcut-button" href="#">
        	<span>
        		<img src="${rc.contextPath}/imgs/admin/icons/role.png" alt="icon" /><br />
        		角色维护
    		</span>
		</a>
	</li>
    
</ul>

<div class="dn"></div><!-- error msg wrapper -->

<div id="cbAddPrivilege" class="content-box dynamic-cb">
		
	<div class="content-box-header"><h3>新增权限</h3></div>
    
    <div class="content-box-content clearfix pb0">
    	
        <div class="column-left">
            <p>
                <label>文本输入框</label>
                <input type="text" class="text-input" />
            </p>
            <p>
                <label>复选框</label>
                <input type="checkbox" class="vm" /> <span class="vm">第一复选框</span>
                <input type="checkbox" class="vm" /> <span class="vm">第二复选框</span>
            </p>
            <p>
                <label>单选框</label>
                <input type="radio" name="radio1" class="vm" /> <span class="vm">单选框1</span><br />
                <input type="radio" name="radio2" class="vm" /> <span class="vm">单选框2</span>
            </p>
        </div>
        
        <div class="column-right">
			<p>
            	<label>下拉框</label>              
                <input id="ttt_show" type="text" class="dropdown" readonly="readonly" value="测试" onclick="javascript:showDropDownList(this, 'ttt');" onblur="javascript:dropDownListBlur('ttt');" />
				<div id="ttt" class="dropdown-content">
					<ul>
						<li><a href="javascript:void(0);" value="1" onclick="javascript:updateDropDownListVal(this, 'ttt_val', 'ttt_show');">选项一</a></li>
						<li><a href="javascript:void(0);" value="2" onclick="javascript:updateDropDownListVal(this, 'ttt_val', 'ttt_show');">选项二</a></li>
						<li><a href="javascript:void(0);" value="3" onclick="javascript:updateDropDownListVal(this, 'ttt_val', 'ttt_show');">选项三</a></li>
					</ul>
				</div>
                <input id="ttt_val" type="hidden" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a id="btnAddPrivilege" href="#" class="button">提 交</a>
            </p>
        </div>
        
    </div>
    
</div><!-- END content-box -->

<div id="cbQueryPrivilege" class="content-box dn">
	
	<div class="content-box-header">
		<h3>查询条件</h3>
	</div>
    
    <div class="content-box-content clearfix pb0">
		
        <div class="column-left">
            <p>
                <label>文本输入框</label>
                <input type="text" class="text-input" />
            </p>
            <p>
                <label>复选框</label>
                <input type="checkbox" class="vm" /> <span class="vm">第一复选框</span>
                <input type="checkbox" class="vm" /> <span class="vm">第二复选框</span>
            </p>
            <p>
                <label>单选框</label>
                <input type="radio" name="radio1" class="vm" /> <span class="vm">单选框1</span><br />
                <input type="radio" name="radio2" class="vm" /> <span class="vm">单选框2</span>
            </p>
        </div>
        
        <div class="column-right">
            <p>
                <label>下拉框</label>              
                <input id="ttt_show2" type="text" class="dropdown" readonly="readonly" value="测试2" onclick="javascript:showDropDownList(this, 'ttt2');" onblur="javascript:dropDownListBlur('ttt2');" />
          <div id="ttt2" class="dropdown-content">
                    <ul>
                        <li><a href="javascript:void(0);" value="1" onclick="javascript:updateDropDownListVal(this, 'ttt_val2', 'ttt_show2');">选项1</a></li>
                        <li><a href="javascript:void(0);" value="2" onclick="javascript:updateDropDownListVal(this, 'ttt_val2', 'ttt_show2');">选项2</a></li>
                        <li><a href="javascript:void(0);" value="3" onclick="javascript:updateDropDownListVal(this, 'ttt_val2', 'ttt_show2');">选项3</a></li>
                    </ul>
          </div>
                <input id="ttt_val2" type="hidden" />
            </p>
        </div>
        
        <div class="cb"></div>
        
        <div>
            <p>
                <a href="#" class="button">查 询</a>
            </p>
        </div>
	
    </div>
    
</div><!-- END content-box -->

<div id="privilege_list" class="content-box">
		
	<div class="content-box-header">
		<h3>权限列表</h3>					
	</div>
    
    <div class="content-box-content">
		
		<div class="dn"></div><!-- error msg wrapper -->
		
    	<table class="zebra-tab">
        	<tr>
            	<th><input class="check-all" type="checkbox" /></th>
				<th>序号</th>
				<th>关键字</th>
				<th>资源</th>
				<th>描述</th>
				<th>操作</th>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>
                	<a href="javascript:void(0);" title="启用/禁用"><img src="../../imgs/admin/icons/bulb-off.png" /></a>
					<a href="javascript:void(0);" title="编辑"><img src="../../imgs/admin/icons/edit.png" /></a>
					<a href="javascript:void(0);" title="删除"><img src="../../imgs/admin/icons/cross.png" /></a> 
					<a href="javascript:void(0);" title="查看"><img src="../../imgs/admin/icons/query.png" /></a>
				</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>
                	<a href="javascript:void(0);" title="启用/禁用"><img src="../../imgs/admin/icons/bulb-on.png" /></a>
					<a href="javascript:void(0);" title="编辑"><img src="../../imgs/admin/icons/edit.png" /></a>
					<a href="javascript:void(0);" title="删除"><img src="../../imgs/admin/icons/cross.png" /></a> 
					<a href="javascript:void(0);" title="查看"><img src="../../imgs/admin/icons/query.png" /></a>
                </td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
			<tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr>
            	<td><input type="checkbox" /></td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
                <td>111</td>
            </tr>
            <tr class="tab-bg-white">
            	<td colspan="6" class="tab-btm">
					
					<div class="bulk-actions fl">
						<a class="button" href="#">批量删除</a>
					</div>
					
					<div class="pagination fr">
						<a href="#">&laquo; 首页</a>
						<a href="#">&laquo; 上一页</a>
						<a href="#" class="number">1</a>
						<a href="#" class="number">2</a>
						<a href="#" class="number current">3</a>
						...
						<a href="#" class="number">10</a>
						<a href="#">下一页 &raquo;</a>
						<a href="#">尾页 &raquo;</a>
					</div> <!-- End .pagination -->
				</td>
            </tr>
        </table>
    </div>
    
</div><!-- END content-box -->

<div id="cb_detail_info" class="content-box dn">
		
	<div class="content-box-header">
		<h3>详细信息</h3>					
	</div>
    
    <div class="content-box-content clearfix pb0">
        <div class="column-left">
            <p>
                <label>文本输入框</label>
                <input type="text" class="text-input" />
            </p>
            <p>
                <label>复选框</label>
                <input type="checkbox" class="vm" /> <span class="vm">第一复选框</span> <input type="checkbox" class="vm" /> <span class="vm">第二复选框</span>
            </p>
            <p>
                <label>单选框</label>
                <input type="radio" name="radio1" class="vm" /> <span class="vm">单选框1</span><br />
                <input type="radio" name="radio2" class="vm" /> <span class="vm">单选框2</span>
            </p>
        </div>
        <div class="column-right">
            <p>
                <label>下拉框</label>
                <input id="tt2_show" type="text" class="dropdown" readonly="readonly" value="测试2" onclick="javascript:showDropDownList(this, 'tt2');" onblur="javascript:dropDownListBlur('tt2');" />
          <div id="tt2" class="dropdown-content">
                    <ul>
                        <li><a href="javascript:void(0);" value="1" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项A</a></li>
                        <li><a href="javascript:void(0);" value="2" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项B</a></li>
                        <li><a href="javascript:void(0);" value="3" onclick="javascript:updateDropDownListVal(this, 'tt2_val', 'tt2_show');">选项C</a></li>
                    </ul>
          </div>
                <input id="tt2_val" type="hidden" />
            </p>
        </div>
        <div class="cb"></div>
        <div>
            <p>
                <a href="#" class="button">保 存</a>
                <a id="btn-detail-close" href="javascript:void(0);" class="button">关 闭</a>
            </p>
        </div>
    </div>
    
</div><!-- END content-box -->