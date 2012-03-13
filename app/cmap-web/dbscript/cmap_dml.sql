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

--INSERT INTO addr_type VALUES(1, '楼');
--INSERT INTO addr_type VALUES(2, '小区');
--INSERT INTO addr_type VALUES(3, '商铺');

INSERT INTO order_status VALUES(1, '待确认');
INSERT INTO order_status VALUES(2, '配送中');
INSERT INTO order_status VALUES(3, '交易成功');
INSERT INTO order_status VALUES(4, '交易失败');

INSERT INTO province_info VALUES(1, '天津');
INSERT INTO city_info VALUES(21, '天津', 1);

INSERT INTO privilege_info VALUES('e19f4f7ccfb142009a3fb69a774f95f1', 'AUTH_MENU_PRIVILEGE_CFG', '/adminMenu/menuPrivilegeCfg', 1, true, '菜单项权限配置');
INSERT INTO privilege_info VALUES('365c3fbc761146a6b38232073e3bd4fb', 'AUTH_MENU_ROLE_CFG', '/adminMenu/menuRoleCfg', 1, true, '菜单项角色维护');
INSERT INTO privilege_info VALUES('3f5c30be8d7b4422b131c396caac2f8d', 'AUTH_MENU_ROLE_BINDING', '/adminMenu/menuRoleBinding', 1, true, '菜单项角色绑定');
INSERT INTO privilege_info VALUES('6fb5ab2cd5874aee8e35c61e51eb2a10', 'AUTH_MENU_CUSTOMER_MGR', '/adminMenu/menuCustomerMgr', 1, true, '菜单项前台用户');
INSERT INTO privilege_info VALUES('93224967a3914701b5c34814d1d4d93a', 'AUTH_MENU_USR_MGR', '/adminMenu/menuUsrMgr', 1, true, '菜单项后台用户');
INSERT INTO privilege_info VALUES('8f56d66ed0da42ca933c2dfce211f7d9', 'AUTH_MENU_REST_MGR', '/adminMenu/menuRestMgr', 1, true, '菜单项餐馆管理');

INSERT INTO privilege_info VALUES('d342c2e8c720472680a71129ad5676ab', 'AUTH_PRIVILEGE_ADD', '/adminPrivilege', 2, true, '新增权限');
INSERT INTO privilege_info VALUES('7008311c28334f1b811a92080d0efd18', 'AUTH_PRIVILEGE_QUERY', '/adminPrivilege', 1, true, '查询权限');
INSERT INTO privilege_info VALUES('c4a2a8d13f8c4d6f962ac94589abb285', 'AUTH_PRIVILEGE_ENABLE', '/adminPrivilege/{id}', 3, true, '启用禁用权限');
INSERT INTO privilege_info VALUES('54be78cc7d6e431d9c1f19e42b52bb90', 'AUTH_PRIVILEGE_DETAIL', '/adminPrivilege/detail/{id}', 1, true, '显示权限信息');
INSERT INTO privilege_info VALUES('9b0b4d8a7da64ac49875bc196bd8896a', 'AUTH_PRIVILEGE_UPDATE', '/adminPrivilege/edit/{id}', 3, true, '更新权限信息');
INSERT INTO privilege_info VALUES('56c2d5edd4d14adea762dea2a83e42c3', 'AUTH_PRIVILEGE_DELETE', '/adminPrivilege/{id}', 4, true, '删除权限');

INSERT INTO privilege_info VALUES('ac5622ece9404b9383b1dc9166dc1ba5', 'AUTH_ROLE_ADD', '/adminRole', 2, true, '新增角色');
INSERT INTO privilege_info VALUES('44bde001d4e54a068db6cc60817a5554', 'AUTH_ROLE_QUERY', '/adminRole', 1, true, '查询角色');
INSERT INTO privilege_info VALUES('e10aea347d1d456a91842566541b358d', 'AUTH_ROLE_ENABLE', '/adminRole/{id}', 3, true, '启用禁用角色');
INSERT INTO privilege_info VALUES('34941e500a77425e919413690b16f1d3', 'AUTH_ROLE_DETAIL', '/adminRole/detail/{id}', 1, true, '显示角色信息');
INSERT INTO privilege_info VALUES('d70dd60a722a4685b5b0650369f960b5', 'AUTH_ROLE_UPDATE', '/adminRole/edit/{id}', 3, true, '更新角色信息');
INSERT INTO privilege_info VALUES('70e65ac79eaa4b9f98b4406a2dd3a568', 'AUTH_ROLE_DELETE', '/adminRole/{id}', 4, true, '删除角色');

INSERT INTO privilege_info VALUES('bcaac5abc78743a4b05e11baaf165de6', 'AUTH_ROLE_BINDING_UPDATE', '/adminUsrTypeRole/edit/{id}', 3, true, '保存角色绑定');

INSERT INTO privilege_info VALUES('40c93cb5445a4196870437bd7ce1605a', 'AUTH_CUSTOMER_UPDATE', '/adminCustomerMgr/edit/{id}', 3, true, '更新前台用户信息');
INSERT INTO privilege_info VALUES('234b207d1641497a8678a3bc1f87f646', 'AUTH_CUSTOMER_DETAIL', '/adminCustomerMgr/detail/{id}', 1, true, '显示前台用户信息');
INSERT INTO privilege_info VALUES('212f9bcda6d84d04839c1d3b688d1769', 'AUTH_CUSTOMER_DELETE', '/adminCustomerMgr/{id}', 4, true, '删除前台用户');
INSERT INTO privilege_info VALUES('5bff3bf4331b4a258cdec07e42780b41', 'AUTH_CUSTOMER_ADD', '/adminCustomerMgr', 2, true, '新增前台用户');
INSERT INTO privilege_info VALUES('34df738b88f64237b132e3257c9702c1', 'AUTH_CUSTOMER_ENABLE', '/adminCustomerMgr/{id}', 3, true, '启用禁用前台用户');
INSERT INTO privilege_info VALUES('74e55c776b4d43aea43a81b917007694', 'AUTH_CUSTOMER_QUERY', '/adminCustomerMgr', 1, true, '查询前台用户');

INSERT INTO privilege_info VALUES('7e769c3630b14e7999a53cd305f8c3a8', 'AUTH_DELIVERY_ADDR_UPDATE', '/adminDeliveryAddr/edit/{id}/{id}', 3, true, '更新送餐地址信息');
INSERT INTO privilege_info VALUES('f8f377957dd249f7a72d0be49b2215d4', 'AUTH_DELIVERY_ADDR_DEFAULT', '/adminDeliveryAddr/{id}/{id}', 3, true, '设置默认送餐地址');
INSERT INTO privilege_info VALUES('1e488673eb4642868924f5a5a39c670e', 'AUTH_DELIVERY_ADDR_DETAIL', '/adminDeliveryAddr/detail/{id}/{id}', 1, true, '显示送餐地址信息');
INSERT INTO privilege_info VALUES('ee9f98ec61b04e5e8753f7c59abcdeb3', 'AUTH_DELIVERY_ADDR_DELETE', '/adminDeliveryAddr/{id}/{id}', 4, true, '删除送餐地址');
INSERT INTO privilege_info VALUES('5630c3c458e34d38921e959ce484f9c6', 'AUTH_DELIVERY_ADDR_QUERY', '/adminDeliveryAddr/list/{id}', 1, true, '查询送餐地址');
INSERT INTO privilege_info VALUES('f4e695748b09477caa69b7ca88f58723', 'AUTH_DELIVERY_ADDR_ADD', '/adminDeliveryAddr/{id}', 2, true, '新增送餐地址');
INSERT INTO privilege_info VALUES('440f86a17dfb49a7b7e0561e54db0a7a', 'AUTH_DELIVERY_ADDR_SHOW', '/adminDeliveryAddr/{id}', 1, true, '显示送餐地址');

INSERT INTO privilege_info VALUES('a8bd8374b0d442fda83631c1d2cd9886', 'AUTH_USR_UPDATE', '/adminUsrMgr/edit/{id}', 3, true, '更新后台用户信息');
INSERT INTO privilege_info VALUES('4a2227f67e804d43abb1c59e16fbff1e', 'AUTH_USR_DETAIL', '/adminUsrMgr/detail/{id}', 1, true, '显示后台用户信息');
INSERT INTO privilege_info VALUES('9bfbf3ba592b4bbe963ee5720146662b', 'AUTH_USR_DELETE', '/adminUsrMgr/{id}', 4, true, '删除后台用户');
INSERT INTO privilege_info VALUES('3bd745a1e1c14bd08d2b9c2a8532e63b', 'AUTH_USR_ADD', '/adminUsrMgr', 2, true, '新增后台用户');
INSERT INTO privilege_info VALUES('8077681f690c464a9f9909dbd8c21a3b', 'AUTH_USR_ENABLE', '/adminUsrMgr/{id}', 3, true, '启用禁用后台用户');
INSERT INTO privilege_info VALUES('6fc0e40b74054e2199a2653c7fe42556', 'AUTH_USR_QUERY', '/adminUsrMgr', 1, true, '查询后台用户');

INSERT INTO privilege_info VALUES('d39bc668260f42f782eb00d2c248d641', 'AUTH_REST_UPDATE', '/adminRestMgr/edit/{id}', 3, true, '更新餐馆信息');
INSERT INTO privilege_info VALUES('0b8fab6133f8428fafc352d45b97cc7a', 'AUTH_REST_DETAIL', '/adminRestMgr/detail/{id}', 1, true, '显示餐馆信息');
INSERT INTO privilege_info VALUES('be6a945abde64e1ebf94762d5820a7a5', 'AUTH_REST_ENABLE', '/adminRestMgr/{id}', 3, true, '启用禁用餐馆');
INSERT INTO privilege_info VALUES('7552b120a72a4a8d8fd2d9218bd924c5', 'AUTH_REST_DELETE', '/adminRestMgr/{id}', 4, true, '删除餐馆');
INSERT INTO privilege_info VALUES('02de2b5a9e424499bd2e834f95457ab4', 'AUTH_REST_ADD', '/adminRestMgr', 2, true, '新增餐馆');
INSERT INTO privilege_info VALUES('954e9f570ba34c9a87bb2d57126defe0', 'AUTH_REST_QUERY', '/adminRestMgr', 1, true, '查询餐馆');

INSERT INTO privilege_info VALUES('fd27d3a437464fa7bd343f25b52e397a', 'AUTH_DISH_SORT_UPDATE', '/adminDishSort/edit/{id}/{id}', 3, true, '更新菜品分类信息');
INSERT INTO privilege_info VALUES('9791eba71cb64bbbbec31dcd3c038515', 'AUTH_DISH_SORT_ENABLE', '/adminDishSort/{id}', 3, true, '启用禁用菜品分类');
INSERT INTO privilege_info VALUES('5cecf7d81c33433e8f1eb8a691480821', 'AUTH_DISH_SORT_DELETE', '/adminDishSort/{id}/{id}', 4, true, '删除菜品分类');
INSERT INTO privilege_info VALUES('556bf34f660d4cf3af0730d08e32f240', 'AUTH_DISH_SORT_ADD', '/adminDishSort/{id}', 2, true, '新增菜品分类');
INSERT INTO privilege_info VALUES('8534cab0330345279c2e79586a78a449', 'AUTH_DISH_SORT_DETAIL', '/adminDishSort/detail/{id}/{id}', 1, true, '显示菜品分类信息');
INSERT INTO privilege_info VALUES('761235f708ef41c0a97c8ebc67733028', 'AUTH_DISH_SORT_SHOW', '/adminDishSort/{id}', 1, true, '显示菜品分类');
INSERT INTO privilege_info VALUES('f5e349e5a25d440fb7d0d9b39af6621f', 'AUTH_DISH_SORT_QUERY', '/adminDishSort/list/{id}', 1, true, '查询菜品分类');

INSERT INTO privilege_info VALUES('1b848f03ff2f4676a27e485c1ca88caa', 'AUTH_DISH_UPDATE', '/adminDishMgr/edit/{id}/{id}', 3, true, '更新菜品信息');
INSERT INTO privilege_info VALUES('f87557a6dff6406b8c080383ccd17404', 'AUTH_DISH_DETAIL', '/adminDishMgr/detail/{id}/{id}', 1, true, '显示菜品信息');
INSERT INTO privilege_info VALUES('a48b1e6adfef446c897ccc1103865f76', 'AUTH_DISH_ENABLE', '/adminDishMgr/{id}', 3, true, '启用禁用菜品');
INSERT INTO privilege_info VALUES('95d0ea7b090a4abbbfff00ca5590022a', 'AUTH_DISH_DELETE', '/adminDishMgr/{id}/{id}', 4, true, '删除菜品');
INSERT INTO privilege_info VALUES('fb2dd6f336ae49cea5009c2e09f3ae9a', 'AUTH_DISH_ADD', '/adminDishMgr', 2, true, '新增菜品');
INSERT INTO privilege_info VALUES('f60481b900b64790b5bf47e9ff93e8bc', 'AUTH_DISH_QUERY', '/adminDishMgr/list/{id}', 1, true, '查询菜品');
INSERT INTO privilege_info VALUES('3f99d4aa4e71449dbc9c2cf676ac0b12', 'AUTH_DISH_SHOW', '/adminDishMgr/{id}', 1, true, '显示菜品');

INSERT INTO role_info VALUES('7a2d19da508943f2a3b253385e2103b0', 'ROLE_SUPER_ADMIN', true, '超级管理员');

INSERT INTO role_privilege VALUES('dc220e67de9445708f0f11d917bef7c3', '02de2b5a9e424499bd2e834f95457ab4', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('20a1027852364772b6af249fc311b196', '0b8fab6133f8428fafc352d45b97cc7a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('da5543b55791454f93fc05292ef0c6f5', '1b848f03ff2f4676a27e485c1ca88caa', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('f53cd0b2ec9c40deb26f756884cbd748', '1e488673eb4642868924f5a5a39c670e', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('7fe86e0ee7bd40699e39065971e6d7b4', '212f9bcda6d84d04839c1d3b688d1769', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('be5c46cd7e2a4d8782b2c54e324ac54a', '234b207d1641497a8678a3bc1f87f646', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('d8d8af227c284b50811a025252a564d0', '34941e500a77425e919413690b16f1d3', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('28b942961cc546e0b8cff470b48486ac', '34df738b88f64237b132e3257c9702c1', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('38d3fa89c403413299ca33a9f7248dfb', '365c3fbc761146a6b38232073e3bd4fb', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('782f3369c1b749a49575d72800cfc08c', '3bd745a1e1c14bd08d2b9c2a8532e63b', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('659de9de9b3e4664bd31d2caee45f584', '3f5c30be8d7b4422b131c396caac2f8d', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('bb15f646c59e48a598687bdd21e3b229', '3f99d4aa4e71449dbc9c2cf676ac0b12', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('047466fbbcaf47e4acc691c6f4d364da', '40c93cb5445a4196870437bd7ce1605a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('427a3beb487946aa971d07a0750cb6aa', '440f86a17dfb49a7b7e0561e54db0a7a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('053ac435d0ab4d66b06364e4c1b0529e', '44bde001d4e54a068db6cc60817a5554', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('0c6db88fe82341cf9e35408e01af5528', '4a2227f67e804d43abb1c59e16fbff1e', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('ced34d222ccc4d519959e057bff77281', '54be78cc7d6e431d9c1f19e42b52bb90', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('2568c0b9069e41bca6d89e5392bdb4a6', '556bf34f660d4cf3af0730d08e32f240', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('6e97f4acda094f84b0f74202b40ae6bb', '5630c3c458e34d38921e959ce484f9c6', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('491963f8f9f44bf0b23de97febef8376', '56c2d5edd4d14adea762dea2a83e42c3', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('c41978a551b3405d975dfe6714d02001', '5bff3bf4331b4a258cdec07e42780b41', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('60678262334745a1a016afa49024e769', '5cecf7d81c33433e8f1eb8a691480821', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('413bea59a8a94bb9b9829a53cbed5b4b', '6fb5ab2cd5874aee8e35c61e51eb2a10', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('24b765e0709d4dd29bcb7ee12689cacd', '6fc0e40b74054e2199a2653c7fe42556', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('012cf207a23149d292823862102756c2', '7008311c28334f1b811a92080d0efd18', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('469c48e22fdb4b4b91de2383a730f161', '70e65ac79eaa4b9f98b4406a2dd3a568', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('25593821011140898da4990d57e44216', '74e55c776b4d43aea43a81b917007694', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('123db36a53f84cb8b9da6282265093f0', '7552b120a72a4a8d8fd2d9218bd924c5', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('69bdff6906ce4366a0d08fed710189fc', '761235f708ef41c0a97c8ebc67733028', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('0e356da594fe417680358b208107e8e2', '7e769c3630b14e7999a53cd305f8c3a8', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('434e26fd16724b0da178c59b884e2ae8', '8077681f690c464a9f9909dbd8c21a3b', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('f0569bd87cde4522aff094b44648ba3d', '8534cab0330345279c2e79586a78a449', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('282975b718dd4153818badc09713a11a', '8f56d66ed0da42ca933c2dfce211f7d9', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('66b1f337f7c946b9b69de847a835490a', '93224967a3914701b5c34814d1d4d93a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('307bec96e5a24e039c5815793484635d', '954e9f570ba34c9a87bb2d57126defe0', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('b33530de524049549617758e06aad011', '95d0ea7b090a4abbbfff00ca5590022a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('83ca70325c9b4db288ad03a7e7eee9ac', '9791eba71cb64bbbbec31dcd3c038515', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('75cadc566d334a359bc1514cf591f183', '9b0b4d8a7da64ac49875bc196bd8896a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('3454b0d77b904801a433992a183bae47', '9bfbf3ba592b4bbe963ee5720146662b', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('a2f0d712018c4b9e87fd242e438ebdb1', 'a48b1e6adfef446c897ccc1103865f76', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('03f398e76ba04e0eb5684cf0dfbc45e6', 'a8bd8374b0d442fda83631c1d2cd9886', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('5a573538cfd7412aa4c6c3aa7a6f7555', 'ac5622ece9404b9383b1dc9166dc1ba5', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('f27455e5ca2e402d8b7d62960092b4a1', 'bcaac5abc78743a4b05e11baaf165de6', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('0514635feb90418284562030c4e3b939', 'be6a945abde64e1ebf94762d5820a7a5', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('c07a0578664640fe9a79d0b62e111bce', 'c4a2a8d13f8c4d6f962ac94589abb285', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('8e3be62dc13b468c9f5ad935ce8eafeb', 'd342c2e8c720472680a71129ad5676ab', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('b4be5dfd7d824f1fbe21bf0be1a6f47e', 'd39bc668260f42f782eb00d2c248d641', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('362aced2de16472d957c06b1dc685e18', 'd70dd60a722a4685b5b0650369f960b5', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('b6b005370fdc472aae2da5a0c68979f9', 'e10aea347d1d456a91842566541b358d', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('0dc4aafdc7c745fd9b21886318f50d8f', 'e19f4f7ccfb142009a3fb69a774f95f1', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('8f3b6a91e8e44a40991fe835fbc4aef2', 'ee9f98ec61b04e5e8753f7c59abcdeb3', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('28d8da40596143ecb95b7dc1c6876910', 'f4e695748b09477caa69b7ca88f58723', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('c1b0f6c0afb04169aa766450852d43dc', 'f5e349e5a25d440fb7d0d9b39af6621f', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('57d33f8b6293466b9b186ed3ce6372d6', 'f60481b900b64790b5bf47e9ff93e8bc', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('fba9c1a20ced4399949c1dc6b3d1175b', 'f87557a6dff6406b8c080383ccd17404', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('b7edd30643e74ed9875ba58a8bb20ff7', 'f8f377957dd249f7a72d0be49b2215d4', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('44f48fa90c2b44fcb862d1a6aac089ca', 'fb2dd6f336ae49cea5009c2e09f3ae9a', '7a2d19da508943f2a3b253385e2103b0');
INSERT INTO role_privilege VALUES('caac452bab624c40b4b9f4789cf480f6', 'fd27d3a437464fa7bd343f25b52e397a', '7a2d19da508943f2a3b253385e2103b0');

INSERT INTO usr_info VALUES('8a6dd9833605f2e9013605f2ed960000', 'admin', '6ecd3dd03b8905dd7bda7811ee097350f3230a9965f0aac9a06d6a8cdf4fce6c', null, null, '', '', now(), 0, true, 1, null, null);

INSERT INTO usr_type_role VALUES('9a4137b862664e3e897e14f4468be014', '7a2d19da508943f2a3b253385e2103b0', 1);
