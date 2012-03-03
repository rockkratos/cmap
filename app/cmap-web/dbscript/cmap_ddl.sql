-- ============================================================
--   Table: http_method_type
-- ============================================================
CREATE TABLE http_method_type (
	method_type_id SMALLINT NOT NULL,
	method_type VARCHAR(10) NOT NULL,
	method_desc VARCHAR(32),
	CONSTRAINT pk_http_method_type PRIMARY KEY (method_type_id),
	CONSTRAINT uk_http_method_type UNIQUE (method_type)
);

-- ============================================================
--   Table: privilege_info
-- ============================================================
CREATE TABLE privilege_info (
	privilege_id CHAR(32) NOT NULL,
	privilege_name VARCHAR(64) NOT NULL,
	res_path VARCHAR(255) NOT NULL,
	method_type_id SMALLINT NOT NULL,
	enabled BOOLEAN NOT NULL,
	privilege_desc VARCHAR(64),
	CONSTRAINT pk_privilege_info PRIMARY KEY (privilege_id),
	CONSTRAINT uk_privilege_info UNIQUE (privilege_name)
);

-- ============================================================
--   Table: role_info
-- ============================================================
CREATE TABLE role_info (
	role_id CHAR(32) NOT NULL,
	role_name VARCHAR(64) NOT NULL,
	enabled BOOLEAN NOT NULL,
	role_desc VARCHAR(64),
	CONSTRAINT pk_role_info PRIMARY KEY (role_id),
	CONSTRAINT uk_role_info UNIQUE (role_name)
);

-- ============================================================
--   Table: role_privilege
-- ============================================================
CREATE TABLE role_privilege (
	role_privilege_id CHAR(32) NOT NULL,
	privilege_id CHAR(32) NOT NULL,
	role_id CHAR(32) NOT NULL,
	CONSTRAINT pk_role_privilege PRIMARY KEY (role_privilege_id)
);

-- ============================================================
--   Table: usr_info
-- ============================================================
CREATE TABLE usr_info (
	usr_id CHAR(32) NOT NULL,
	login_name VARCHAR(64) NOT NULL,
	login_pwd VARCHAR(64) NOT NULL,
	nick_name VARCHAR(64),
	real_name VARCHAR(16),
	usr_cell VARCHAR(16) NOT NULL,
	usr_email VARCHAR(32) NOT NULL,
	reg_time TIMESTAMP NOT NULL,
	bad_pwd_count SMALLINT DEFAULT 0,
	enabled BOOLEAN NOT NULL,
	usr_type_id SMALLINT NOT NULL, 
	last_login_time TIMESTAMP,
	last_login_ip VARCHAR(16),
	CONSTRAINT pk_usr_info PRIMARY KEY (usr_id),
	CONSTRAINT uk_usr_info UNIQUE (login_name, usr_cell, usr_email)
);

-- ============================================================
--   Table: usr_type
-- ============================================================
CREATE TABLE usr_type (
	usr_type_id SMALLINT NOT NULL, 
	usr_type_name VARCHAR(32) NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	usr_type_desc VARCHAR(64), 
	CONSTRAINT pk_usr_type_info PRIMARY KEY (usr_type_id),
	CONSTRAINT uk_usr_type_info UNIQUE (usr_type_name)
);

-- ============================================================
--   Table: usr_type_role
-- ============================================================
CREATE TABLE usr_type_role (
	usr_type_role_id CHAR(32) NOT NULL,
	role_id CHAR(32) NOT NULL,
	usr_type_id SMALLINT NOT NULL,
	CONSTRAINT usr_type_role_pkey PRIMARY KEY (usr_type_role_id)
);

-- ============================================================
--   Table: order_trans_type
-- ============================================================
CREATE TABLE order_trans_type (
	order_trans_type_id SMALLINT NOT NULL,
	order_trans_type_code VARCHAR(10) NOT NULL,
	order_trans_type_name VARCHAR(64),
	CONSTRAINT pk_order_trans_type PRIMARY KEY (order_trans_type_id),
	CONSTRAINT uk_order_trans_type UNIQUE (order_trans_type_code)
);

-- ============================================================
--   Table: cooking_type
-- ============================================================
CREATE TABLE cooking_type (
	cooking_type_id SMALLINT NOT NULL, 
	cooking_type_name VARCHAR(64) NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	CONSTRAINT pk_cooking_sort PRIMARY KEY (cooking_type_id), 
	CONSTRAINT uk_cooking_sort UNIQUE(cooking_type_name)
);

-- ============================================================
--   Table: rest_info
-- ============================================================
CREATE TABLE rest_info (
	rest_id CHAR(32) NOT NULL, 
	rest_name VARCHAR(64) NOT NULL, 
	rest_addr VARCHAR(255) NOT NULL, 
	rest_open_time CHAR(4) NOT NULL, 
	rest_close_time CHAR(4) NOT NULL, 
	rest_lng NUMERIC NOT NULL, 
	rest_lat NUMERIC NOT NULL, 
	order_trans_type_id SMALLINT NOT NULL, 
	cooking_type_id SMALLINT NOT NULL, 
	take_away_radius FLOAT4 NOT NULL, 
	sending_amount FLOAT4 NOT NULL, 
	take_away_fee FLOAT4 NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	rest_start_time TIMESTAMP NOT NULL, 
	rest_end_time TIMESTAMP NOT NULL, 
	take_away_desc VARCHAR(64), 
	rest_phone VARCHAR(64), 
	rest_signed BOOLEAN NOT NULL, 
	city_id SMALLINT NOT NULL, 
	printer_id VARCHAR(16), 
	print_joint_num VARCHAR(1), 
	CONSTRAINT pk_rest_info PRIMARY KEY (rest_id)
);

-- ============================================================
--   Table: dish_sort
-- ============================================================
CREATE TABLE dish_sort (
	dish_sort_id CHAR(32) NOT NULL, 
	dish_sort_name VARCHAR(64) NOT NULL, 
	rest_id CHAR(32) NOT NULL, 
	dish_sort_order SMALLINT NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	CONSTRAINT pk_dish_sort PRIMARY KEY (dish_sort_id)
);

-- ============================================================
--   Table: dish_info
-- ============================================================
CREATE TABLE dish_info (
	dish_id CHAR(32) NOT NULL, 
	dish_name VARCHAR(64) NOT NULL, 
	dish_price FLOAT4 NOT NULL, 
	dish_prmt_price FLOAT4, 
	dish_sort_id CHAR(32) NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	dish_prmt BOOLEAN NOT NULL, 
	dish_desc VARCHAR(64), 
	CONSTRAINT pk_dish_info PRIMARY KEY (dish_id)
);

-- ============================================================
--   Table: cannot_trans_addr
-- ============================================================
CREATE TABLE cannot_trans_addr (
	cannot_trans_id CHAR(32) NOT NULL, 
	addr_coll_id CHAR(32) NOT NULL, 
	rest_id CHAR(32) NOT NULL, 
	CONSTRAINT pk_cannot_trans_addr PRIMARY KEY (cannot_trans_id)
);

-- ============================================================
--   Table: addr_type
-- ============================================================
CREATE TABLE addr_type (
	addr_type_id SMALLINT NOT NULL, 
	addr_type_name VARCHAR(16) NOT NULL, 
	CONSTRAINT pk_addr_type PRIMARY KEY (addr_type_id)
);

-- ============================================================
--   Table: addr_coll
-- ============================================================
CREATE TABLE addr_coll (
	addr_coll_id CHAR(32) NOT NULL, 
	addr_name VARCHAR(64) NOT NULL, 
	sepc_addr VARCHAR(255) NOT NULL, 
	addr_longitude NUMERIC NOT NULL, 
	addr_latitude NUMERIC NOT NULL, 
	city_id SMALLINT NOT NULL, 
	addr_type_id SMALLINT NOT NULL, 
	CONSTRAINT pk_addr_coll PRIMARY KEY (addr_coll_id)
);

-- ============================================================
--   Table: prmt_info
-- ============================================================
CREATE TABLE prmt_info (
	prmt_info_id CHAR(32) NOT NULL, 
	prmt_info_desc VARCHAR(255) NOT NULL, 
	rest_id CHAR(32) NOT NULL, 
	prmt_start_time TIMESTAMP NOT NULL, 
	prmt_end_time TIMESTAMP NOT NULL, 
	enabled BOOLEAN NOT NULL, 
	CONSTRAINT pk_prmt_info PRIMARY KEY (prmt_info_id)
);

-- ============================================================
--   Table: order_info
-- ============================================================
CREATE TABLE order_info (
	order_id CHAR(16) NOT NULL, 
	usr_id CHAR(32) NOT NULL, 
	addr_id CHAR(32) NOT NULL, 
	order_time TIMESTAMP NOT NULL, 
	rest_id CHAR(32) NOT NULL, 
	rest_cfm_time TIMESTAMP, 
	order_amount FLOAT8 NOT NULL, 
	order_status_id SMALLINT NOT NULL, 
	CONSTRAINT pk_order_info PRIMARY KEY (order_id)
);

-- ============================================================
--   Table: order_detail
-- ============================================================
CREATE TABLE order_detail (
	order_detail_id CHAR(32) NOT NULL, 
	dish_id CHAR(32) NOT NULL, 
	dish_quantity SMALLINT NOT NULL, 
	order_id CHAR(16) NOT NULL, 
	CONSTRAINT pk_order_detail PRIMARY KEY (order_detail_id)
);

-- ============================================================
--   Table: order_status
-- ============================================================
CREATE TABLE order_status (
	order_status_id SMALLINT NOT NULL, 
	order_status_type VARCHAR(64) NOT NULL, 
	CONSTRAINT pk_order_status PRIMARY KEY (order_status_id), 
	CONSTRAINT uk_order_status UNIQUE (order_status_type)
);

-- ============================================================
--   Table: push_order_history
-- ============================================================
CREATE TABLE push_order_history (
	poh_id CHAR(32) NOT NULL, 
	order_id CHAR(16) NOT NULL, 
	po_time TIMESTAMP NOT NULL, 
	CONSTRAINT pk_push_order_history PRIMARY KEY (poh_id)
);

-- ============================================================
--   Table: delivery_addr
-- ============================================================
CREATE TABLE delivery_addr (
	addr_id CHAR(32) NOT NULL, 
	spec_addr VARCHAR(255) NOT NULL, 
	phone_nbr VARCHAR(16) NOT NULL, 
	usr_id CHAR(32) NOT NULL, 
	CONSTRAINT pk_delivery_addr PRIMARY KEY (addr_id)
);

-- ============================================================
--   Table: city_info
-- ============================================================
CREATE TABLE city_info (
	city_id SMALLINT NOT NULL, 
	city_name VARCHAR(32) NOT NULL, 
	province_id SMALLINT NOT NULL, 
	CONSTRAINT pk_city_info PRIMARY KEY (city_id), 
	CONSTRAINT uk_city_info UNIQUE (city_name)
);

-- ============================================================
--   Table: province_info
-- ============================================================
CREATE TABLE province_info (
	province_id SMALLINT NOT NULL, 
	province_name VARCHAR(32) NOT NULL, 
	CONSTRAINT pk_province_info PRIMARY KEY (province_id), 
	CONSTRAINT uk_province_info UNIQUE (province_name)
);

-- ============================================================
--   CONSTRAINTS
-- ============================================================
ALTER TABLE privilege_info ADD CONSTRAINT fk_method_type FOREIGN KEY (method_type_id) REFERENCES http_method_type(method_type_id);

ALTER TABLE role_privilege ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role_info(role_id);
ALTER TABLE role_privilege ADD CONSTRAINT fk_privilege FOREIGN KEY (privilege_id) REFERENCES privilege_info(privilege_id);

ALTER TABLE usr_info ADD CONSTRAINT fk_usr_type FOREIGN KEY (usr_type_id) REFERENCES usr_type(usr_type_id);

ALTER TABLE usr_type_role ADD CONSTRAINT fk_usr_type FOREIGN KEY (usr_type_id) REFERENCES usr_type(usr_type_id);
ALTER TABLE usr_type_role ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role_info(role_id);

ALTER TABLE rest_info ADD CONSTRAINT fk_order_trans_type FOREIGN KEY (order_trans_type_id) REFERENCES order_trans_type(order_trans_type_id);
ALTER TABLE rest_info ADD CONSTRAINT fk_cooking_type FOREIGN KEY (cooking_type_id) REFERENCES cooking_type(cooking_type_id);
ALTER TABLE rest_info ADD CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES city_info(city_id);

ALTER TABLE dish_sort ADD CONSTRAINT fk_rest FOREIGN KEY (rest_id) REFERENCES rest_info(rest_id);

ALTER TABLE dish_info ADD CONSTRAINT fk_dish_sort FOREIGN KEY (dish_sort_id) REFERENCES dish_sort(dish_sort_id);

ALTER TABLE cannot_trans_addr ADD CONSTRAINT fk_addr_coll FOREIGN KEY (addr_coll_id) REFERENCES addr_coll(addr_coll_id);
ALTER TABLE cannot_trans_addr ADD CONSTRAINT fk_rest FOREIGN KEY (rest_id) REFERENCES rest_info(rest_id);

ALTER TABLE addr_coll ADD CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES city_info(city_id);
ALTER TABLE addr_coll ADD CONSTRAINT fk_addr_type FOREIGN KEY (addr_type_id) REFERENCES addr_type(addr_type_id);

ALTER TABLE prmt_info ADD CONSTRAINT fk_rest FOREIGN KEY (rest_id) REFERENCES rest_info(rest_id);

ALTER TABLE order_info ADD CONSTRAINT fk_usr FOREIGN KEY (usr_id) REFERENCES usr_info(usr_id);
ALTER TABLE order_info ADD CONSTRAINT fk_addr FOREIGN KEY (addr_id) REFERENCES delivery_addr(addr_id);
ALTER TABLE order_info ADD CONSTRAINT fk_rest FOREIGN KEY (rest_id) REFERENCES rest_info(rest_id);
ALTER TABLE order_info ADD CONSTRAINT fk_order_status FOREIGN KEY (order_status_id) REFERENCES order_status(order_status_id);

ALTER TABLE order_detail ADD CONSTRAINT fk_dish FOREIGN KEY (dish_id) REFERENCES dish_info(dish_id);
ALTER TABLE order_detail ADD CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES order_info(order_id);

ALTER TABLE push_order_history ADD CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES order_info(order_id);

ALTER TABLE delivery_addr ADD CONSTRAINT fk_usr FOREIGN KEY (usr_id) REFERENCES usr_info(usr_id);

ALTER TABLE city_info ADD CONSTRAINT fk_province FOREIGN KEY (province_id) REFERENCES province_info(province_id);