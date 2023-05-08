drop database if exists datn;
create database if not exists datn;
use datn;

DROP TABLE IF EXISTS san_pham; 
CREATE TABLE IF NOT EXISTS san_pham (
	id bigint unsigned auto_increment primary key,
    ten nvarchar(255) not null,
    ma_san_pham nvarchar(25) unique not null,
    nsx nvarchar(255) not null,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255),
    is_new bit default null,
    is_best_seller bit default null,
    is_active bit default null
);

DROP TABLE IF EXISTS khuyen_mai; 
CREATE TABLE IF NOT EXISTS khuyen_mai (  
	id bigint unsigned auto_increment primary key,
    title nvarchar(255) not null,
    noi_dung nvarchar(500),
    giam_gia decimal,
    ngay_bat_dau datetime not null default current_timestamp,
    ngay_ket_thuc datetime not null default current_timestamp,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255)
);

DROP TABLE IF EXISTS khuyen_mai_chi_tiet; 
CREATE TABLE IF NOT EXISTS khuyen_mai_chi_tiet (  
	id bigint unsigned auto_increment primary key,
    id_san_pham bigint unsigned,
    id_khuyen_mai bigint unsigned,
    foreign key (id_san_pham) references san_pham(id),
    foreign key (id_khuyen_mai) references khuyen_mai(id)
);

DROP TABLE IF EXISTS anh; 
CREATE TABLE IF NOT EXISTS anh (
	`code` nvarchar(255) primary key,
    ten nvarchar(255) unique,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
    id_san_pham bigint unsigned,
    foreign key (id_san_pham) references san_pham(id)
);

DROP TABLE IF EXISTS danh_muc; 
CREATE TABLE IF NOT EXISTS danh_muc (
	id int unsigned auto_increment primary key,
    ten nvarchar(255) unique not null,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255)
);

DROP TABLE IF EXISTS danh_muc_chi_tiet; 
CREATE TABLE IF NOT EXISTS danh_muc_chi_tiet (
	id bigint unsigned auto_increment primary key,
    id_san_pham bigint unsigned,
    id_danh_muc int unsigned,
    foreign key (id_san_pham) references san_pham(id),
    foreign key (id_danh_muc) references danh_muc(id)
);

DROP TABLE IF EXISTS mau_sac; 
CREATE TABLE IF NOT EXISTS mau_sac (
	id int unsigned auto_increment primary key,
    ten nvarchar(55) not null unique,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp
);
DROP TABLE IF EXISTS size; 
CREATE TABLE IF NOT EXISTS size (
	id int unsigned auto_increment primary key,
    ten nvarchar(55) not null unique,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp
);

DROP TABLE IF EXISTS san_pham_chi_tiet; 
CREATE TABLE IF NOT EXISTS san_pham_chi_tiet (
	id bigint unsigned auto_increment primary key,
    so_luong_serial_code int default 0,
    don_gia decimal default 0,
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255),
    id_san_pham bigint  unsigned,
    id_mau_sac int unsigned unsigned,
    id_size int unsigned,
    foreign key (id_san_pham) references san_pham(id),
    foreign key (id_mau_sac) references mau_sac(id),
    foreign key (id_size) references size(id)
);

DROP TABLE IF EXISTS serial_code; 
CREATE TABLE IF NOT EXISTS serial_code (
	id bigint unsigned auto_increment primary key,
    trang_thai nvarchar(255),
    ngay_nhap datetime not null,
    ngay_ban datetime not null unique,
    id_san_pham_chi_tiet bigint unsigned not null,
    foreign key (id_san_pham_chi_tiet) references san_pham_chi_tiet(id)
);

DROP TABLE IF EXISTS khach_hang; 
CREATE TABLE IF NOT EXISTS khach_hang (
	id bigint unsigned primary key,
	ten_khach_hang nvarchar(255) not null,
	sdt varchar(15) unique not null,
	email nvarchar(255) unique not null ,
	ngay_sinh date, 
	username varchar(255) unique not null,
	`password` varchar(255) not null,
	ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255)
	-- id_gio_hang bigint unsigned unique
);
DROP TABLE IF EXISTS chuc_vu; 
CREATE TABLE IF NOT EXISTS chuc_vu (
	id int unsigned auto_increment primary key,
	ten nvarchar(255) not null unique
);

DROP TABLE IF EXISTS nhan_vien; 
CREATE TABLE IF NOT EXISTS nhan_vien (
	id bigint unsigned primary key auto_increment,
	ten_nhan_vien nvarchar(255) not null,
	sdt varchar(15) unique not null,
	email nvarchar(255) unique not null ,
	ngay_sinh date, 
	username varchar(255) unique not null,
	`password` varchar(255) not null,
	ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255),
	id_chuc_vu int unsigned not null,
	foreign key (id_chuc_vu) references chuc_vu (id)
);

DROP TABLE IF EXISTS hoa_don; 
CREATE TABLE IF NOT EXISTS hoa_don (
	id bigint unsigned auto_increment primary key,
    ten_khach_hang nvarchar(255) not null,
    sdt varchar(15) not null,
    email varchar(255),
    dia_chi nvarchar(255),
    tong_tien decimal default 0,
    chu_thich nvarchar(255),
    ngay_tao datetime default current_timestamp,
    ngay_cap_nhat datetime default current_timestamp,
    ngay_thanh_toan datetime default null,
    id_khach_hang bigint unsigned,
    id_nhan_vien bigint unsigned,
    foreign key (id_khach_hang) references khach_hang (id),
    foreign key (id_nhan_vien) references nhan_vien (id)
);

DROP TABLE IF EXISTS hoa_don_chi_tiet; 
CREATE TABLE IF NOT EXISTS hoa_don_chi_tiet (
	id bigint unsigned auto_increment primary key,
    don_gia decimal default 0,
    so_luong int unsigned default 0,
    chu_thich nvarchar(255),
    id_hoa_don bigint unsigned,
    id_san_pham_ct bigint unsigned,
    foreign key (id_hoa_don) references hoa_don (id),
    foreign key (id_san_pham_ct) references san_pham_chi_tiet (id)
);

DROP TABLE IF EXISTS `gio_hang`; 
CREATE TABLE IF NOT EXISTS `gio_hang` (
	id bigint unsigned auto_increment primary key,
    ngay_tao datetime default current_timestamp,
    ngay_cap_nhat datetime default current_timestamp,
    trang_thai nvarchar(255),
    id_khach_hang bigint unsigned unique,
    foreign key (id_khach_hang) references khach_hang (id)
);

DROP TABLE IF EXISTS `gio_hang_chi_tiet`; 
CREATE TABLE IF NOT EXISTS `gio_hang_chi_tiet` (
	id bigint unsigned auto_increment primary key,
    id_gio_hang bigint unsigned, 
    id_san_pham_chi_tiet bigint unsigned,
    foreign key (id_gio_hang) references gio_hang (id),
    foreign key (id_san_pham_chi_tiet) references san_pham_chi_tiet (id)
);

DROP TABLE IF EXISTS `comment`; 
CREATE TABLE IF NOT EXISTS `comment` (
	id bigint unsigned auto_increment primary key,
    noi_dung nvarchar(500),
    ngay_tao datetime not null default current_timestamp,
	ngay_cap_nhat datetime default current_timestamp,
	trang_thai nvarchar(255),
    id_khach_hang bigint unsigned, 
    id_san_pham bigint unsigned,
    foreign key (id_khach_hang) references khach_hang (id),
    foreign key (id_san_pham) references san_pham (id)
);



