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