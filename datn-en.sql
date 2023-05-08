drop database if exists datn_en;
create database if not exists datn_en;
use datn_en;

DROP TABLE IF EXISTS product; 
CREATE TABLE IF NOT EXISTS product (
	id bigint unsigned auto_increment primary key,
    `name` nvarchar(255) not null,
    product_code nvarchar(25) unique not null,
    manufacturer nvarchar(255) not null,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255),
    is_new bit default null,
    is_best_seller bit default null,
    is_active bit default null
);

DROP TABLE IF EXISTS promotion; 
CREATE TABLE IF NOT EXISTS promotion (  
	id bigint unsigned auto_increment primary key,
    `title` nvarchar(255) not null,
    `content` nvarchar(500),
    `discount_value` decimal,
    `start_at` datetime not null default current_timestamp,
    `end_at` datetime not null default current_timestamp,
    `create_at` datetime not null default current_timestamp,
	`update_at` datetime default current_timestamp,
	`status` nvarchar(255)
);

DROP TABLE IF EXISTS `promotion_detail`; 
CREATE TABLE IF NOT EXISTS `promotion_detail` (  
	id bigint unsigned auto_increment primary key,
    id_product bigint unsigned,
    id_promotion bigint unsigned,
    foreign key (id_product) references product(id),
    foreign key (id_promotion) references promotion(id)
);

DROP TABLE IF EXISTS image; 
CREATE TABLE IF NOT EXISTS image (
	`code` nvarchar(255) primary key,
    `name` nvarchar(255) unique,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
    id_product bigint unsigned,
    foreign key (id_product) references product(id)
);

DROP TABLE IF EXISTS category; 
CREATE TABLE IF NOT EXISTS category (
	id int unsigned auto_increment primary key,
    `name` nvarchar(255) unique not null,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255)
);

DROP TABLE IF EXISTS category_detail; 
CREATE TABLE IF NOT EXISTS category_detail (
	id bigint unsigned auto_increment primary key,
    id_product bigint unsigned,
    id_category int unsigned,
    foreign key (id_product) references product(id),
    foreign key (id_category) references category(id)
);

DROP TABLE IF EXISTS `color`; 
CREATE TABLE IF NOT EXISTS `color` (
	id int unsigned auto_increment primary key,
    `name` nvarchar(55) not null unique,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp
);
DROP TABLE IF EXISTS size; 
CREATE TABLE IF NOT EXISTS size (
	id int unsigned auto_increment primary key,
    `name` nvarchar(55) not null unique,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp
);

DROP TABLE IF EXISTS product_detail; 
CREATE TABLE IF NOT EXISTS product_detail (
	id bigint unsigned auto_increment primary key,
    amount_serial_code int default 0,
    unit_price decimal default 0,
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255),
    id_product bigint  unsigned,
    id_color int unsigned unsigned,
    id_size int unsigned,
    foreign key (id_product) references product(id),
    foreign key (id_color) references `color`(id),
    foreign key (id_size) references size(id)
);

DROP TABLE IF EXISTS serial_code; 
CREATE TABLE IF NOT EXISTS serial_code (
	id bigint unsigned auto_increment primary key,
    `serial_code` nvarchar(255) not null unique,
    import_date datetime not null,
    sale_date datetime not null unique,
    `status` nvarchar(255),
    id_product_detail bigint unsigned not null,
    foreign key (id_product_detail) references product_detail(id)
);

DROP TABLE IF EXISTS customer; 
CREATE TABLE IF NOT EXISTS customer (
	id bigint unsigned primary key,
	customer_name nvarchar(255) not null,
	phone varchar(15) unique not null,
	email nvarchar(255) unique not null ,
	birthday date, 
	username varchar(255) unique not null,
	`password` varchar(255) not null,
	create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255)
	-- id_cart bigint unsigned unique
);
DROP TABLE IF EXISTS `position`; 
CREATE TABLE IF NOT EXISTS `position` (
	id int unsigned auto_increment primary key,
	`name` nvarchar(255) not null unique
);

DROP TABLE IF EXISTS staff; 
CREATE TABLE IF NOT EXISTS staff (
	id bigint unsigned primary key auto_increment,
	staff_name nvarchar(255) not null,
	phone varchar(15) unique not null,
	email nvarchar(255) unique not null ,
	birthday date, 
	username varchar(255) unique not null,
	`password` varchar(255) not null,
	create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255),
	id_position int unsigned not null,
	foreign key (id_position) references `position` (id)
);

DROP TABLE IF EXISTS bill; 
CREATE TABLE IF NOT EXISTS bill (
	id bigint unsigned auto_increment primary key,
    customer_name nvarchar(255) not null,
    phone varchar(15) not null,
    email varchar(255),
    address nvarchar(255),
    total_payment decimal,
    note nvarchar(255),
    create_at datetime default current_timestamp,
    update_at datetime default current_timestamp,
    payment_date datetime default null,
    id_customer bigint unsigned,
    id_staff bigint unsigned,
    foreign key (id_customer) references customer (id),
    foreign key (id_staff) references staff (id)
);

DROP TABLE IF EXISTS bill_detail; 
CREATE TABLE IF NOT EXISTS bill_detail (
	id bigint unsigned auto_increment primary key,
    unit_price decimal default 0,
    amount int unsigned default 0,
    note nvarchar(255),
    id_bill bigint unsigned,
    id_product_details bigint unsigned,
    foreign key (id_bill) references bill (id),
    foreign key (id_product_ct) references product_detail (id)
);

DROP TABLE IF EXISTS `cart`; 
CREATE TABLE IF NOT EXISTS `cart` (
	id bigint unsigned auto_increment primary key,
    create_at datetime default current_timestamp,
    update_at datetime default current_timestamp,
    `status` nvarchar(255),
    id_customer bigint unsigned unique,
    foreign key (id_customer) references customer (id)
);

DROP TABLE IF EXISTS `cart_detail`; 
CREATE TABLE IF NOT EXISTS `cart_detail` (
	id bigint unsigned auto_increment primary key,
    id_cart bigint unsigned, 
    id_product_detail bigint unsigned,
    foreign key (id_cart) references cart (id),
    foreign key (id_product_detail) references product_detail (id)
);

DROP TABLE IF EXISTS `comment`; 
CREATE TABLE IF NOT EXISTS `comment` (
	id bigint unsigned auto_increment primary key,
    `content` nvarchar(500),
    create_at datetime not null default current_timestamp,
	update_at datetime default current_timestamp,
	`status` nvarchar(255),
    id_customer bigint unsigned, 
    id_product bigint unsigned,
    foreign key (id_customer) references customer (id),
    foreign key (id_product) references product (id)
);