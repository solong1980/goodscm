-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.19-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 goodscm 的数据库结构
CREATE DATABASE IF NOT EXISTS `goodscm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goodscm`;


-- 导出  表 goodscm.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) NOT NULL COMMENT '客户分类',
  `code` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `memo` text COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 正在导出表  goodscm.customer 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `type`, `code`, `name`, `address`, `phone`, `qq`, `email`, `memo`, `create_time`, `update_time`) VALUES
	(2, '2222', '2222', '223sadfasf', NULL, NULL, NULL, '3asdfas33', NULL, '2018-05-04 20:54:12', '2018-05-04 20:57:32'),
	(3, '1', '00000', 'abcdefg', NULL, NULL, NULL, 'afasfd', NULL, '2018-05-04 20:54:17', '2018-05-04 20:54:16');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- 导出  表 goodscm.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `short_name` varchar(100) DEFAULT NULL COMMENT '简短产品型号名称',
  `category_id` bigint(20) DEFAULT NULL COMMENT '产品分类',
  `vendor_goods_code` varchar(50) DEFAULT NULL COMMENT '供应商产品编号',
  `name_zh` varchar(255) DEFAULT NULL COMMENT '品名中文',
  `name_en` varchar(255) DEFAULT NULL COMMENT '品名英文',
  `net_weight` decimal(10,5) DEFAULT NULL COMMENT '净重',
  `weight_after_packing` decimal(10,5) DEFAULT NULL COMMENT '包装后重量',
  `length` decimal(10,2) DEFAULT NULL COMMENT '包装前体积(Cm) - 长',
  `width` decimal(10,2) DEFAULT NULL COMMENT '包装前体积(Cm) - 宽',
  `height` decimal(10,2) DEFAULT NULL COMMENT '包装前体积(Cm) - 高',
  `packing_length` decimal(10,2) DEFAULT NULL COMMENT '包装后体积(Cm) - 长',
  `packing_width` decimal(10,2) DEFAULT NULL COMMENT '包装后体积(Cm) - 宽',
  `packing_height` decimal(10,2) DEFAULT NULL COMMENT '包装后体积(Cm) - 高',
  `purchase_price` decimal(10,2) DEFAULT NULL COMMENT '最新采购价',
  `retail_price` decimal(10,2) DEFAULT NULL COMMENT '零售价',
  `trade_price` decimal(10,2) DEFAULT NULL COMMENT '批发价',
  `stock` decimal(10,2) DEFAULT NULL COMMENT '库存数',
  `stock_unit` smallint(6) DEFAULT NULL COMMENT '数量单位',
  `memo` text COMMENT '备注',
  `zh_info` text COMMENT '中文信息',
  `en_info` text COMMENT '英文信息',
  `ext_info` text COMMENT '备注信息',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 正在导出表  goodscm.goods 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `code`, `short_name`, `category_id`, `vendor_goods_code`, `name_zh`, `name_en`, `net_weight`, `weight_after_packing`, `length`, `width`, `height`, `packing_length`, `packing_width`, `packing_height`, `purchase_price`, `retail_price`, `trade_price`, `stock`, `stock_unit`, `memo`, `zh_info`, `en_info`, `ext_info`, `status`, `create_time`, `update_time`) VALUES
	(1, '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
	(3, '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL),
	(4, '1111', 'company short name', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-04 16:50:05'),
	(5, '1111', 'company short name', 2, NULL, '强强强', 'strongstring', 10.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-04 16:50:06'),
	(6, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-04 16:50:09'),
	(7, '1111', 'company short name', 11, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, NULL, '2018-05-04 16:50:11'),
	(8, '1111', 'company short name', 12, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:32:31', '2018-05-04 16:50:12'),
	(9, '1111', 'company short name', 1, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:33:04', '2018-05-04 16:50:13'),
	(10, '1111', 'company short name', 2, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:36:27', '2018-05-04 16:50:17'),
	(11, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:40:56', '2018-05-04 16:50:44'),
	(12, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:41:47', '2018-05-04 16:50:46'),
	(13, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:42:09', '2018-05-02 20:42:08'),
	(14, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:44:09', '2018-05-02 20:44:09'),
	(15, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:47:47', '2018-05-02 20:47:47'),
	(16, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:48:51', '2018-05-02 20:48:51'),
	(17, '1111', 'company short name', 1000, NULL, '???', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 08:37:51', '2018-05-03 08:37:51'),
	(18, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 08:42:54', '2018-05-03 08:42:54'),
	(19, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 08:59:19', '2018-05-03 08:59:19'),
	(20, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 10:27:06', '2018-05-03 10:27:05'),
	(21, NULL, '酷比科技', 10, NULL, '中国酷比科技有限公司', 'chinese koobi tec \'ltd', 3.00000, 3.00000, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 3.00, 2200.00, 200.00, 33.00, 2, '中国最酷逼的科技公司', 'zh_info', 'en_info', 'ext_info', 2, '2018-05-04 14:17:04', '2018-05-13 17:30:15');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


-- 导出  表 goodscm.goods_category 结构
CREATE TABLE IF NOT EXISTS `goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类ID',
  `category_code` varchar(50) NOT NULL COMMENT '类别编码 ，采用000 000 000（每级最多999个不包括000），支持三级类别，需要可以再加',
  `name` varchar(100) NOT NULL COMMENT '类别名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.goods_category 的数据：~14 rows (大约)
/*!40000 ALTER TABLE `goods_category` DISABLE KEYS */;
INSERT INTO `goods_category` (`id`, `parent_id`, `category_code`, `name`, `create_time`, `update_time`) VALUES
	(0, -1, '000000000', '~', '2018-04-30 17:31:03', '2018-04-30 17:31:59'),
	(1, 0, '001000000', '滤镜', '2018-04-30 17:16:15', '2018-04-30 17:31:49'),
	(2, 0, '002000000', '遮光罩', '2018-04-30 17:16:35', '2018-04-30 17:31:49'),
	(3, 0, '003000000', '机身配件类', '2018-04-30 17:16:55', '2018-04-30 17:31:49'),
	(4, 0, '004000000', '镜头配件类', '2018-04-30 17:17:13', '2018-04-30 17:31:49'),
	(5, 0, '005000000', '闪光灯配件类', '2018-04-30 17:17:39', '2018-04-30 17:31:49'),
	(6, 0, '006000000', '清洁产品类', '2018-04-30 17:18:00', '2018-04-30 17:31:49'),
	(7, 6, '006002000', '背带腕带包类', '2018-04-30 17:22:30', '2018-04-30 17:32:16'),
	(8, 6, '006003000', '三角架类', '2018-04-30 17:22:41', '2018-04-30 17:32:17'),
	(9, 6, '006001000', '清洁产品类', '2018-04-30 17:24:28', '2018-04-30 17:32:18'),
	(10, 0, '007000000', '高级镜头2', '2018-05-02 21:35:44', '2018-05-04 10:01:02'),
	(11, 10, '008007000', '高级镜头', '2018-05-02 21:39:49', '2018-05-04 08:46:04'),
	(12, 11, '007001001', '高级镜头', '2018-05-02 21:40:24', '2018-05-02 21:40:23'),
	(13, 11, '008007002', '高级镜头', '2018-05-04 14:18:04', '2018-05-04 14:18:04');
/*!40000 ALTER TABLE `goods_category` ENABLE KEYS */;


-- 导出  表 goodscm.goods_pic 结构
CREATE TABLE IF NOT EXISTS `goods_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `no` smallint(6) DEFAULT NULL COMMENT '序号',
  `relative_path` varchar(512) DEFAULT NULL COMMENT '相对完整路径',
  `name` varchar(512) DEFAULT NULL COMMENT '图片名称',
  `is_thumbnail` bit(1) DEFAULT b'0' COMMENT '是否为缩略图',
  `state` tinyint(4) DEFAULT '0' COMMENT '状态 0：正常 ，1：无效',
  `create_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 正在导出表  goodscm.goods_pic 的数据：~66 rows (大约)
/*!40000 ALTER TABLE `goods_pic` DISABLE KEYS */;
INSERT INTO `goods_pic` (`id`, `goods_id`, `no`, `relative_path`, `name`, `is_thumbnail`, `state`, `create_time`) VALUES
	(1, 1, NULL, 'C:\\Users\\solon\\datas\\goodspics\\3ab87e64b3a34c458a85fd40d6dc5da1', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(2, 1, NULL, 'C:\\Users\\solon\\datas\\goodspics\\767b71b606c94d2493a7356f1889cabc', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(3, 1, NULL, 'C:\\Users\\solon\\datas\\goodspics\\625d61307d9e447db38a5c13e21e3495', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(4, 2, 0, 'C:\\Users\\solon\\datas\\goodspics\\42717a1024564f7fb9aa88fb7ff2bcdf', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(5, 2, 1, 'C:\\Users\\solon\\datas\\goodspics\\0fbe631c8c294b7f989fc35fbf505e80', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(6, 2, 2, 'C:\\Users\\solon\\datas\\goodspics\\873fee9c58df4affac9d613f2c34c190', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(7, 3, 0, 'C:\\Users\\solon\\datas\\goodspics\\0059bbeb035e477696d832cab1b70d56', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(8, 3, 1, 'C:\\Users\\solon\\datas\\goodspics\\91c26bfe638a4a47a67d603324f3833b', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(9, 3, 2, 'C:\\Users\\solon\\datas\\goodspics\\ab45fbb1ffa9467cba1e2a5bb28e3bcf', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(10, 4, 0, 'C:\\Users\\solon\\datas\\goodspics\\2b76d6ab6a9f4b498b0a57b842e75d5c', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(11, 4, 1, 'C:\\Users\\solon\\datas\\goodspics\\470773208cfb43d998d71f9ab36adca9', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(12, 4, 2, 'C:\\Users\\solon\\datas\\goodspics\\d93c11791f44449fbbf54545f2409473', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(13, 5, 0, 'C:\\Users\\solon\\datas\\goodspics\\b36d3ddf321c46668b3597c856fd6d4b', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(14, 5, 1, 'C:\\Users\\solon\\datas\\goodspics\\12ab0f9d442741519a3e1e9cd2fb4523', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(15, 5, 2, 'C:\\Users\\solon\\datas\\goodspics\\ee8c7a597385491380e1d26a680cec30', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(16, 6, 0, 'C:\\Users\\solon\\datas\\goodspics\\e8ccbb0d28524001adf8d248b9704501', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(17, 6, 1, 'C:\\Users\\solon\\datas\\goodspics\\ed5a4e9288e44e92a79e8183cc4528fc', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(18, 6, 2, 'C:\\Users\\solon\\datas\\goodspics\\8dbf0ded7f7e43dbb703ccd2915c0359', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(19, 7, 0, 'C:\\Users\\solon\\datas\\goodspics\\8d4675e7f40e40ca8e61c045edce5aa0', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(20, 7, 1, 'C:\\Users\\solon\\datas\\goodspics\\659331be7df54ca7950ce22749c03d89', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(21, 7, 2, 'C:\\Users\\solon\\datas\\goodspics\\500921d8e302479b8ab1b8858f505cba', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(22, 8, 0, 'C:\\Users\\solon\\datas\\goodspics\\346f02007c62416ba2b28ef214e5ec9a', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(23, 8, 1, 'C:\\Users\\solon\\datas\\goodspics\\d90eebf5d9f248e58f8ec67d64378b0f', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(24, 8, 2, 'C:\\Users\\solon\\datas\\goodspics\\ed55b494d45c4da2a01ed2b6d6d6fabf', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(25, 9, 0, 'C:\\Users\\solon\\datas\\goodspics\\6fb4d2a930094618a3c34af61213383c', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(26, 9, 1, 'C:\\Users\\solon\\datas\\goodspics\\dc098d27eaea45558787b9adc1940e7b', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(27, 9, 2, 'C:\\Users\\solon\\datas\\goodspics\\ab835aa7944a4328847c3e493ef3ba55', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(28, 10, 0, 'C:\\Users\\solon\\datas\\goodspics\\480d0d26e11e4ca59e37675b9c0ab7ba', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(29, 10, 1, 'C:\\Users\\solon\\datas\\goodspics\\646bf121978e4f469c35e88e93fb977a', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(30, 10, 2, 'C:\\Users\\solon\\datas\\goodspics\\aba1f819b2734588ad5a1bc45245cf36', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(31, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\1ac53fb5b15a4370a9eaebca9bd49a94', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(32, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\494e9f401785460287424e01948fedac', '2016-10-27 2016-10-27 001 001.jpg', b'0', NULL, NULL),
	(33, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\234a299997a6416c94c0ba17b51da365', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(34, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\1ece23a81fa143aeb02f876e829346a4', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(35, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\079fc20c20de47c8940b66c9b35015ca', '2016-10-27 2016-10-27 001 001.jpg', b'0', NULL, NULL),
	(36, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\56d190998bce4bd8994c22d3ae81a7e3', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(37, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\58725b029333404fa7d2e58093ec6941', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(38, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\cc4fdd7aea044cc4b94483de8d8e3f0d', '2016-10-27 2016-10-27 001 001.jpg', b'0', NULL, NULL),
	(39, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\d836c3ed651743e1824ea3ef95b09a50', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(40, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\2f4b4e78b15f4ee4875baf868b9590fa', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(41, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\24d634283729485d8e46cb44b36f5bcd', '2016-10-27 2016-10-27 001 001.jpg', b'0', NULL, NULL),
	(42, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\7b888fd6291e49e2b0bc04c1688d0dd7', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(43, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\b61a3a709bc9409186b41ceaabc0047b', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(44, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\83e641e358df4e009abfacc875196d8f', '2016-10-27 2016-10-27 001 001.jpg', b'0', NULL, NULL),
	(45, NULL, NULL, 'C:\\Users\\Travelsky\\datas\\goodspics\\4461fc1e0b164f439c2f38c972a12c31', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(46, 21, 0, 'C:\\Users\\Travelsky\\datas\\goodspics\\a440028674ac4f3ab659505cd5723a01', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 14:17:03'),
	(47, 21, 1, 'C:\\Users\\Travelsky\\datas\\goodspics\\25e486e2a1b04c4d8ecc7986ccd3198b', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 14:17:03'),
	(48, 21, 2, 'C:\\Users\\Travelsky\\datas\\goodspics\\feda895b2f2e4be8a6731e34a86b2662', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 14:17:03'),
	(49, NULL, 0, 'C:\\Users\\Travelsky\\datas\\goodspics\\d615dc07002045b4acec8514bd81e982', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 14:17:58'),
	(50, NULL, 1, 'C:\\Users\\Travelsky\\datas\\goodspics\\e749197028b846e6b1cbf7d48e56363c', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 14:17:58'),
	(51, NULL, 2, 'C:\\Users\\Travelsky\\datas\\goodspics\\33e75282170441eb8fdc2640394e0a6a', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 14:17:58'),
	(52, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\e86ed24e54d44cfdbf4b0b7240329768', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 21:32:57'),
	(53, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\c707dc395a73485ba8c28b2189fa5319', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 21:32:57'),
	(54, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\b11d6215f59c4452a4d937644eb2398a', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 21:32:57'),
	(55, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\a3dd31a661bb4ca6be08d92fff1e06bb', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 21:38:04'),
	(56, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\d35950b30da1405e880acd2ac9e89641', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 21:38:04'),
	(57, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\997eaa7fae08407ab3e70170c236c935', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 21:38:04'),
	(58, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\3ae9e85d76384a79a41174b65c1d0e2b', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 21:41:08'),
	(59, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\83fbcc3d2983410c9be7bc936e2db0b3', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 21:41:08'),
	(60, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\4bfd9f32f5fb427198ec47eb91003b99', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 21:41:08'),
	(61, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\8318f4963a764c07be58697188998ec0', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 21:42:58'),
	(62, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\4954f94d0a8d45259c5be317ca8af1cd', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 21:42:58'),
	(63, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\108f78af3110477fb440b2dfec540636', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 21:42:58'),
	(64, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\32ed7cfb96dd4e6f8561936010f939d1', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 21:45:08'),
	(65, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\e9eb2c088fe0450e87f904ddd85fc714', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 21:45:08'),
	(66, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\e5d66c2296f84ec195dc3baa37adeadf', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 21:45:08'),
	(67, 21, 0, 'C:\\Users\\solon\\datas\\goodspics\\f4cd109e4b074d5293cf3682f0e4e821', '2016-10-19 2016-10-19 002 001.jpg', b'1', 0, '2018-05-04 21:49:39'),
	(68, 21, 1, 'C:\\Users\\solon\\datas\\goodspics\\f5ffc28d807e40c8902bef1babacf78e', '2016-10-27 2016-10-27 001 001.jpg', b'1', 0, '2018-05-04 21:49:39'),
	(69, 21, 2, 'C:\\Users\\solon\\datas\\goodspics\\ff0c6faf586e4ba89f33d18626e14535', '2016-11-01 2016-11-01 001 001.gif', b'1', 0, '2018-05-04 21:49:39');
/*!40000 ALTER TABLE `goods_pic` ENABLE KEYS */;


-- 导出  表 goodscm.goods_post_cart 结构
CREATE TABLE IF NOT EXISTS `goods_post_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `name_zh` varchar(50) DEFAULT NULL COMMENT '品名中文',
  `name_en` varchar(50) DEFAULT NULL COMMENT '品名英文',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品信息呈递车';

-- 正在导出表  goodscm.goods_post_cart 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods_post_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_post_cart` ENABLE KEYS */;


-- 导出  表 goodscm.goods_post_record 结构
CREATE TABLE IF NOT EXISTS `goods_post_record` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `goods_his_id` bigint(20) DEFAULT NULL COMMENT '商品历史记录ID，对应历史信息',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `post_status` smallint(6) DEFAULT NULL COMMENT '呈递状态',
  `export_time` datetime DEFAULT NULL COMMENT '导出时间',
  `post_time` datetime DEFAULT NULL COMMENT '呈递时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建世间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品导出呈递记录表';

-- 正在导出表  goodscm.goods_post_record 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods_post_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_post_record` ENABLE KEYS */;


-- 导出  表 goodscm.plateform 结构
CREATE TABLE IF NOT EXISTS `plateform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '平台名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='电商平台';

-- 正在导出表  goodscm.plateform 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `plateform` DISABLE KEYS */;
INSERT INTO `plateform` (`id`, `code`, `name`, `create_time`) VALUES
	(1, 'TAOBAO', '淘宝', '2018-05-01 21:31:32'),
	(2, 'JD', '京东', '2018-05-01 21:31:47'),
	(3, 'EBAY', 'eBay', '2018-05-01 21:32:01'),
	(4, 'AMAZON', '亚马逊', '2018-05-01 21:32:36');
/*!40000 ALTER TABLE `plateform` ENABLE KEYS */;


-- 导出  表 goodscm.plateform_release_record 结构
CREATE TABLE IF NOT EXISTS `plateform_release_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) NOT NULL COMMENT '销售平台/渠道ID',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `release_state` smallint(6) DEFAULT NULL COMMENT '渠道上店状态',
  `release_price` decimal(10,2) DEFAULT NULL COMMENT '上店价格',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='销售平台/渠道记录表';

-- 正在导出表  goodscm.plateform_release_record 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `plateform_release_record` DISABLE KEYS */;
INSERT INTO `plateform_release_record` (`id`, `platform_id`, `goods_id`, `release_state`, `release_price`, `create_time`, `update_time`) VALUES
	(1, 1, 1, 0, NULL, '2018-05-01 22:06:42', '2018-05-01 22:06:43'),
	(3, 2, 1, 0, 12.00, '2018-05-01 22:07:44', '2018-05-01 22:07:45'),
	(4, 1, 25, 1, 100.00, '2018-05-04 19:36:10', '2018-05-04 19:43:09'),
	(5, 1, 25, 0, 1000.00, '2018-05-04 19:38:44', '2018-05-04 19:46:47');
/*!40000 ALTER TABLE `plateform_release_record` ENABLE KEYS */;


-- 导出  表 goodscm.supplier 结构
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` bigint(20) NOT NULL COMMENT '分组ID',
  `name` varchar(255) NOT NULL COMMENT '供货商名字',
  `code` varchar(100) NOT NULL COMMENT '编号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='供货商';

-- 正在导出表  goodscm.supplier 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `group_id`, `name`, `code`, `create_time`, `update_time`) VALUES
	(1, 0, '中国电信', '0001', '2018-05-04 21:36:05', '2018-05-14 19:00:29'),
	(2, 0, '中国石油', '0002', '2018-05-04 21:36:16', '2018-05-14 19:00:29'),
	(3, 0, '中国移动', '0003', '2018-05-04 21:36:28', '2018-05-14 19:00:29'),
	(4, 0, '中国工商', '0004', '2018-05-04 21:36:56', '2018-05-14 19:00:29');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- 导出  表 goodscm.supplier_group 结构
CREATE TABLE IF NOT EXISTS `supplier_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '组名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商分组';

-- 正在导出表  goodscm.supplier_group 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `supplier_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_group` ENABLE KEYS */;


-- 导出  表 goodscm.supplier_record 结构
CREATE TABLE IF NOT EXISTS `supplier_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供货商ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `total_price` decimal(10,0) DEFAULT NULL COMMENT '总价',
  `purchase_time` datetime DEFAULT NULL COMMENT '上次拿货时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商';

-- 正在导出表  goodscm.supplier_record 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `supplier_record` DISABLE KEYS */;
INSERT INTO `supplier_record` (`id`, `supplier_id`, `goods_id`, `unit_price`, `quantity`, `total_price`, `purchase_time`, `create_time`) VALUES
	(1, 1, 21, 100.00, 1, 100, '2018-04-04 14:17:03', '2018-05-04 14:17:04'),
	(2, 2, 21, 100.00, 1, 100, '2018-02-04 14:17:03', '2018-05-04 14:17:04'),
	(3, 3, 21, 10.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04'),
	(4, 4, 21, 100.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04'),
	(5, 1, 21, 100.00, 1, 100, '2018-05-04 21:49:40', '2018-05-04 21:50:03'),
	(6, 2, 21, 100.00, 1, 100, '2018-05-04 21:49:40', '2018-05-04 21:50:05'),
	(7, 1, 21, 100.00, 1, 100, '2018-05-04 21:49:40', '2018-05-04 21:51:00'),
	(8, 2, 21, 100.00, 1, 100, '2018-05-04 21:49:40', '2018-05-04 21:51:00');
/*!40000 ALTER TABLE `supplier_record` ENABLE KEYS */;


-- 导出  表 goodscm.sys_menu 结构
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- 正在导出表  goodscm.sys_menu 的数据：~39 rows (大约)
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES
	(1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 0),
	(2, 1, '管理员管理', 'modules/sys/user.html', NULL, 1, 'fa fa-user', 1),
	(3, 1, '角色管理', 'modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 2),
	(4, 1, '菜单管理', 'modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 3),
	(5, 1, 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug', 4),
	(6, 1, '定时任务', 'modules/job/schedule.html', NULL, 1, 'fa fa-tasks', 5),
	(7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0),
	(8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0),
	(9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0),
	(10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0),
	(11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0),
	(12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0),
	(13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0),
	(14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0),
	(15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0),
	(16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0),
	(17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0),
	(18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0),
	(19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0),
	(20, 3, '新增', NULL, 'sys:role:save,sys:menu:perms', 2, NULL, 0),
	(21, 3, '修改', NULL, 'sys:role:update,sys:menu:perms', 2, NULL, 0),
	(22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0),
	(23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0),
	(24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0),
	(25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0),
	(26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0),
	(27, 1, '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'fa fa-sun-o', 6),
	(29, 1, '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-file-text-o', 7),
	(30, 1, '文件上传', 'modules/oss/oss.html', 'sys:oss:all', 1, 'fa fa-file-image-o', 6),
	(31, 1, '部门管理', 'modules/sys/dept.html', NULL, 1, 'fa fa-file-code-o', 1),
	(32, 31, '查看', NULL, 'sys:dept:list,sys:dept:info', 2, NULL, 0),
	(33, 31, '新增', NULL, 'sys:dept:save,sys:dept:select', 2, NULL, 0),
	(34, 31, '修改', NULL, 'sys:dept:update,sys:dept:select', 2, NULL, 0),
	(35, 31, '删除', NULL, 'sys:dept:delete', 2, NULL, 0),
	(36, 1, '字典管理', 'modules/sys/dict.html', NULL, 1, 'fa fa-bookmark-o', 6),
	(37, 36, '查看', NULL, 'sys:dict:list,sys:dict:info', 2, NULL, 6),
	(38, 36, '新增', NULL, 'sys:dict:save', 2, NULL, 6),
	(39, 36, '修改', NULL, 'sys:dict:update', 2, NULL, 6),
	(40, 36, '删除', NULL, 'sys:dict:delete', 2, NULL, 6);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;


-- 导出  表 goodscm.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

-- 正在导出表  goodscm.sys_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`role_id`, `role_name`, `remark`, `dept_id`, `create_time`) VALUES
	(1, 'super', '超级管理员', NULL, '2018-05-15 22:19:50'),
	(2, 'admin', '业务管理员', NULL, '2018-05-15 22:20:07'),
	(3, 'staff', '职员', NULL, '2018-05-15 22:21:01');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 goodscm.sys_role_menu 结构
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- 正在导出表  goodscm.sys_role_menu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`id`, `role_id`, `menu_id`) VALUES
	(1, 2, 1),
	(2, 3, 2);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;


-- 导出  表 goodscm.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- 正在导出表  goodscm.sys_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `salt`, `email`, `mobile`, `status`, `dept_id`, `create_time`) VALUES
	(1, 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', 1, 1, '2018-05-15 22:22:22'),
	(2, 'wangshengui', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', NULL, NULL, 1, 1, '2018-05-15 22:22:48'),
	(3, 'longlianghua', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', NULL, NULL, 1, 1, '2018-05-15 22:23:36'),
	(4, 'xiaowenqiang', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', NULL, NULL, 1, 1, '2018-05-15 22:23:57');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 goodscm.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- 正在导出表  goodscm.sys_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 3);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
