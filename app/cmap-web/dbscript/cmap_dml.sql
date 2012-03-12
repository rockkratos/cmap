INSERT INTO privilege_info VALUES('266fa9c339f6468a8129698698d11145', 'AUTH_MENU_PRIVILEGE_CFG', '/adminMenu/menuPrivilegeCfg', 1, true, '菜单项权限配置');
INSERT INTO privilege_info VALUES('63c9afb416704a2f9e9b18c7d20c56b1', 'AUTH_MENU_ROLE_CFG', '/adminMenu/menuRoleCfg', 1, true, '菜单项角色维护');
INSERT INTO privilege_info VALUES('f362f90a1dd74446a98f66d5444784e9', 'AUTH_MENU_ROLE_BINDING', '/adminMenu/menuRoleBinding', 1, true, '菜单项角色绑定');
INSERT INTO privilege_info VALUES('16163b1d8ea04b0482e899a8bd77e649', 'AUTH_MENU_CUSTOMER_MGR', '/adminMenu/menuCustomerMgr', 1, true, '菜单项前台用户');
INSERT INTO privilege_info VALUES('6e70e6b8291b48359a98b16b1d557e8a', 'AUTH_MENU_USR_MGR', '/adminMenu/menuUsrMgr', 1, true, '菜单项后台用户');
INSERT INTO privilege_info VALUES('3cf5959357aa4f51bf2be6862c54a3ad', 'AUTH_MENU_REST_MGR', '/adminMenu/menuRestMgr', 1, true, '菜单项餐馆管理');

INSERT INTO privilege_info VALUES('ec4d71e121934e93bd4f8427e5164a4a', 'AUTH_PRIVILEGE_ADD', '/adminPrivilege', 2, true, '新增权限');
INSERT INTO privilege_info VALUES('522884d8a0294559a32ab40af2e4b47f', 'AUTH_PRIVILEGE_QUERY', '/adminPrivilege', 1, true, '查询权限');
INSERT INTO privilege_info VALUES('2fa9a1806dd04a2d99a1dddadf037717', 'AUTH_PRIVILEGE_ENABLE', '/adminPrivilege/{id}', 3, true, '启用禁用权限');
INSERT INTO privilege_info VALUES('01d1d9870f4e438d87a301c7b0ad1865', 'AUTH_PRIVILEGE_DETAIL', '/adminPrivilege/detail/{id}', 1, true, '显示权限信息');
INSERT INTO privilege_info VALUES('653df2214fd64314941d7b3430cc8843', 'AUTH_PRIVILEGE_UPDATE', '/adminPrivilege/edit/{id}', 3, true, '更新权限信息');
INSERT INTO privilege_info VALUES('9f306c2d34394cfaaeb7211213a0a53a', 'AUTH_PRIVILEGE_DELETE', '/adminPrivilege/{id}', 4, true, '删除权限');

INSERT INTO privilege_info VALUES('72dd4b47d36c4395b89148667626a8ba', 'AUTH_ROLE_ADD', '/adminRole', 2, true, '新增角色');
INSERT INTO privilege_info VALUES('2aaefabdc7b543b0bcdc6c6949ba5eab', 'AUTH_ROLE_QUERY', '/adminRole', 1, true, '查询角色');
INSERT INTO privilege_info VALUES('cdf0731c76d84c6e909a67145e633fbc', 'AUTH_ROLE_ENABLE', '/adminRole/{id}', 3, true, '启用禁用角色');
INSERT INTO privilege_info VALUES('c6b36f6d4ef8444da29cf6bffb542426', 'AUTH_ROLE_DETAIL', '/adminRole/detail/{id}', 1, true, '显示角色信息');
INSERT INTO privilege_info VALUES('14e28e4c17c845fab5f45fecf88441ca', 'AUTH_ROLE_UPDATE', '/adminRole/edit/{id}', 3, true, '更新角色信息');
INSERT INTO privilege_info VALUES('50c97789926c4e53adb1447ecc6c560f', 'AUTH_ROLE_DELETE', '/adminRole/{id}', 4, true, '删除角色');

INSERT INTO privilege_info VALUES('2064359b42ac46508545dda258ff502b', 'AUTH_ROLE_BINDING_UPDATE', '/adminUsrTypeRole/edit/{id}', 3, true, '保存角色绑定');

INSERT INTO privilege_info VALUES('76556319c9ea425dab3ce035774ba3a8', 'AUTH_CUSTOMER_QUERY', '/adminCustomerMgr', 1, true, '查询前台用户');
INSERT INTO privilege_info VALUES('39a4c535dccd4cceb93dfe7079c943ec', 'AUTH_CUSTOMER_ENABLE', '/adminCustomerMgr/{id}', 3, true, '启用禁用前台用户');
INSERT INTO privilege_info VALUES('5a0b543a2c6a4ee78edd5d3e21b42bc5', 'AUTH_CUSTOMER_ADD', '/adminCustomerMgr', 2, true, '新增前台用户');
INSERT INTO privilege_info VALUES('bb27569bb4d24beab1858cd42b2a6b06', 'AUTH_CUSTOMER_DELETE', '/adminCustomerMgr/{id}', 4, true, '删除前台用户');
INSERT INTO privilege_info VALUES('8c5aa533826340f781069f49316ccf80', 'AUTH_CUSTOMER_DETAIL', '/adminCustomerMgr/detail/{id}', 1, true, '显示前台用户信息');
INSERT INTO privilege_info VALUES('afcae3a2a4ac4467a7ad40525fcc4b53', 'AUTH_CUSTOMER_UPDATE', '/adminCustomerMgr/edit/{id}', 3, true, '更新前台用户信息');

INSERT INTO privilege_info VALUES('2213ade731cf4aab8e8d1d19e1c4721e', 'AUTH_DELIVERY_ADDR_SHOW', '/adminDeliveryAddr/{id}', 1, true, '显示送餐地址');
INSERT INTO privilege_info VALUES('80185147b90745388f717d42c91839b6', 'AUTH_DELIVERY_ADDR_ADD', '/adminDeliveryAddr/{id}', 2, true, '新增送餐地址');
INSERT INTO privilege_info VALUES('9cd8486531b1460186d524124f218414', 'AUTH_DELIVERY_ADDR_QUERY', '/adminDeliveryAddr/list/{id}', 1, true, '查询送餐地址');
INSERT INTO privilege_info VALUES('2f6070f7a2964a0781d7da00cc378d7a', 'AUTH_DELIVERY_ADDR_DELETE', '/adminDeliveryAddr/{id}/{id}', 4, true, '删除送餐地址');
INSERT INTO privilege_info VALUES('57c0cefd2d954e81b3d45249231a12a3', 'AUTH_DELIVERY_ADDR_DETAIL', '/adminDeliveryAddr/detail/{id}/{id}', 1, true, '显示送餐地址信息');
INSERT INTO privilege_info VALUES('0c5b90f4bb0a41c2a2e6f7b8a44338ab', 'AUTH_DELIVERY_ADDR_DEFAULT', '/adminDeliveryAddr/{id}/{id}', 3, true, '设置默认送餐地址');
INSERT INTO privilege_info VALUES('6db702278a364f5e8a2ee243cb20119f', 'AUTH_DELIVERY_ADDR_UPDATE', '/adminDeliveryAddr/edit/{id}/{id}', 3, true, '更新送餐地址信息');

INSERT INTO privilege_info VALUES('beecbfb5aaa04befa5a4afb032ca9274', 'AUTH_USR_QUERY', '/adminUsrMgr', 1, true, '查询后台用户');
INSERT INTO privilege_info VALUES('3bd6d3248b294fa89ed729e34f9af409', 'AUTH_USR_ENABLE', '/adminUsrMgr/{id}', 3, true, '启用禁用后台用户');
INSERT INTO privilege_info VALUES('595dbe58e17249209eecf32d722a7e49', 'AUTH_USR_ADD', '/adminUsrMgr', 2, true, '新增后台用户');
INSERT INTO privilege_info VALUES('59a8648ccee74e8d9459190b9c775647', 'AUTH_USR_DELETE', '/adminUsrMgr/{id}', 4, true, '删除后台用户');
INSERT INTO privilege_info VALUES('dbe5ab7f02904563b0e859b1560d3c41', 'AUTH_USR_DETAIL', '/adminUsrMgr/detail/{id}', 1, true, '显示后台用户信息');
INSERT INTO privilege_info VALUES('b3c885be6ec945c89e0de979b35d5bbe', 'AUTH_USR_UPDATE', '/adminUsrMgr/edit/{id}', 3, true, '更新后台用户信息');

INSERT INTO privilege_info VALUES('46bfa626e8214a358ca50c28e3d35a3b', 'AUTH_REST_QUERY', '/adminRestMgr', 1, true, '查询餐馆');
INSERT INTO privilege_info VALUES('1d9e45d9f72a41609a9c5e0598dffd1e', 'AUTH_REST_ADD', '/adminRestMgr', 2, true, '新增餐馆');
INSERT INTO privilege_info VALUES('0b406d85c0da4b5db6903fbbdf7532c7', 'AUTH_REST_DELETE', '/adminRestMgr/{id}', 4, true, '删除餐馆');
INSERT INTO privilege_info VALUES('c62acd834c8545a391ea6ce54bdcb6ab', 'AUTH_REST_ENABLE', '/adminRestMgr/{id}', 3, true, '启用禁用餐馆');
INSERT INTO privilege_info VALUES('a885d78030ad4c5cb8f61d9d33c788ad', 'AUTH_REST_DETAIL', '/adminRestMgr/detail/{id}', 1, true, '显示餐馆信息');
INSERT INTO privilege_info VALUES('421bb61fd49f4e01842eed6ec202856b', 'AUTH_REST_UPDATE', '/adminRestMgr/edit/{id}', 3, true, '更新餐馆信息');

INSERT INTO privilege_info VALUES('6fdfe4f755834868b6c8c023d61d7625', 'AUTH_DISH_SORT_QUERY', '/adminDishSort/list/{id}', 1, true, '查询菜品分类');
INSERT INTO privilege_info VALUES('0b7a9b3ae39a489893b988f10867a33e', 'AUTH_DISH_SORT_SHOW', '/adminDishSort/{id}', 1, true, '显示菜品分类');
INSERT INTO privilege_info VALUES('1bf995976373415ebc95353921b74751', 'AUTH_DISH_SORT_DETAIL', '/adminDishSort/detail/{id}/{id}', 1, true, '显示菜品分类信息');
INSERT INTO privilege_info VALUES('233f35aa8da6434788e11be0c459ff06', 'AUTH_DISH_SORT_ADD', '/adminDishSort/{id}', 2, true, '新增菜品分类');
INSERT INTO privilege_info VALUES('9dd64e2800e3480dbd02651041d6b49f', 'AUTH_DISH_SORT_DELETE', '/adminDishSort/{id}/{id}', 4, true, '删除菜品分类');
INSERT INTO privilege_info VALUES('e47e78da14944ef6b13f136d95119c03', 'AUTH_DISH_SORT_ENABLE', '/adminDishSort/{id}', 3, true, '启用禁用菜品分类');
INSERT INTO privilege_info VALUES('f169928db9644b7b88c9d8c9f1a537ca', 'AUTH_DISH_SORT_UPDATE', '/adminDishSort/edit/{id}/{id}', 3, true, '更新菜品分类信息');

INSERT INTO privilege_info VALUES('5f8637adbfd5429f96b6779335fa8dc6', 'AUTH_DISH_SHOW', '/adminDishMgr/{id}', 1, true, '显示菜品');
INSERT INTO privilege_info VALUES('8e10e038701d4a69ae70caaf90cf9992', 'AUTH_DISH_QUERY', '/adminDishMgr/list/{id}', 1, true, '查询菜品');
INSERT INTO privilege_info VALUES('07347cf329604787b3f6675cf9b54fdb', 'AUTH_DISH_ADD', '/adminDishMgr', 2, true, '新增菜品');
INSERT INTO privilege_info VALUES('16dcd7c835994123ad02c22138f0855f', 'AUTH_DISH_DELETE', '/adminDishMgr/{id}/{id}', 4, true, '删除菜品');
INSERT INTO privilege_info VALUES('80f9a165f98f46d3b4176caf7211c80c', 'AUTH_DISH_ENABLE', '/adminDishMgr/{id}', 3, true, '启用禁用菜品');
INSERT INTO privilege_info VALUES('3fd3592b3a23442bb7853961544bf2dc', 'AUTH_DISH_DETAIL', '/adminDishMgr/detail/{id}/{id}', 1, true, '显示菜品信息');
INSERT INTO privilege_info VALUES('d22eccee2eda4ee6b2129ee773dea21a', 'AUTH_DISH_UPDATE', '/adminDishMgr/edit/{id}/{id}', 3, true, '更新菜品信息');

INSERT INTO http_method_type VALUES(1, 'GET', '查询');
INSERT INTO http_method_type VALUES(2, 'POST', '新增');
INSERT INTO http_method_type VALUES(3, 'PUT', '修改');
INSERT INTO http_method_type VALUES(4, 'DELETE', '删除');

INSERT INTO usr_type VALUES(1, 'ADMIN', true, '管理员');
INSERT INTO usr_type VALUES(2, 'CUSTOMER', true, '普通用户');
INSERT INTO usr_type VALUES(3, 'REST', true, '餐馆用户');
INSERT INTO usr_type VALUES(4, 'SERVICE', true, '客服用户');
INSERT INTO usr_type VALUES(5, 'MARKET', true, '营销用户');
INSERT INTO usr_type VALUES(6, 'BUSINESS', true, '业务用户');

INSERT INTO order_trans_type VALUES(1, 'PHONE', '电话');
INSERT INTO order_trans_type VALUES(2, 'SMS', '短信');
INSERT INTO order_trans_type VALUES(3, 'EMAIL', '电子邮件');
INSERT INTO order_trans_type VALUES(4, 'CLIENT', '客户端');
INSERT INTO order_trans_type VALUES(5, 'PRINTER', '打印机');

INSERT INTO cooking_type VALUES(1, '中餐', true);
INSERT INTO cooking_type VALUES(2, '西餐', true);
INSERT INTO cooking_type VALUES(3, '快餐', true);
INSERT INTO cooking_type VALUES(4, '日式料理', true);
INSERT INTO cooking_type VALUES(5, '韩式料理', true);
INSERT INTO cooking_type VALUES(6, '清真', true);
INSERT INTO cooking_type VALUES(7, '零食/饮料', true);
INSERT INTO cooking_type VALUES(8, '随便吃点', true);

INSERT INTO addr_type VALUES(1, '楼');
INSERT INTO addr_type VALUES(2, '小区');
INSERT INTO addr_type VALUES(3, '商铺');

INSERT INTO order_status VALUES(1, '待确认');
INSERT INTO order_status VALUES(2, '配送中');
INSERT INTO order_status VALUES(3, '交易成功');
INSERT INTO order_status VALUES(4, '交易失败');

INSERT INTO province_info VALUES(1, '天津');
INSERT INTO city_info VALUES(21, '天津', 1);