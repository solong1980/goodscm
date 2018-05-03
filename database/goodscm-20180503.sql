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
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 正在导出表  goodscm.customer 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 正在导出表  goodscm.goods 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`, `code`, `short_name`, `category_id`, `vendor_goods_code`, `name_zh`, `name_en`, `net_weight`, `weight_after_packing`, `length`, `width`, `height`, `packing_length`, `packing_width`, `packing_height`, `purchase_price`, `retail_price`, `trade_price`, `stock`, `stock_unit`, `memo`, `zh_info`, `en_info`, `ext_info`, `status`, `create_time`, `update_time`) VALUES
	(4, '1111', 'company short name', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-03 21:10:22'),
	(5, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-03 21:10:23'),
	(6, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, NULL, NULL, NULL, NULL, 10, NULL, '2018-05-03 21:10:25'),
	(7, '1111', 'company short name', 10, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, NULL, '2018-05-03 21:10:26'),
	(8, '1111', 'company short name', 11, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:32:31', '2018-05-03 21:10:41'),
	(9, '1111', 'company short name', 11, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:33:04', '2018-05-03 21:10:43'),
	(10, '1111', 'company short name', 12, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:36:27', '2018-05-03 21:10:44'),
	(11, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:40:56', '2018-05-03 21:10:47'),
	(12, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:41:47', '2018-05-03 21:10:48'),
	(13, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:42:09', '2018-05-03 21:10:49'),
	(14, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:44:09', '2018-05-03 21:10:51'),
	(15, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:47:47', '2018-05-03 21:10:52'),
	(16, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 20:48:51', '2018-05-03 21:10:54'),
	(17, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 22:26:21', '2018-05-03 21:10:55'),
	(20, '1111', 'company short name', 9, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 22:54:20', '2018-05-03 21:10:57'),
	(21, '1111', 'company short name', 8, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 22:58:16', '2018-05-03 21:10:59'),
	(22, '1111', 'company short name', 8, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-02 22:58:42', '2018-05-03 21:11:00'),
	(23, '1111', 'company short name', 7, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 19:35:43', '2018-05-03 21:11:02'),
	(24, '1111', 'company short name', 6, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 19:38:14', '2018-05-03 21:11:03'),
	(25, '1111', 'company short name', 5, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 19:39:42', '2018-05-03 21:11:05'),
	(26, '1111', 'company short name', 3, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-03 19:44:47', '2018-05-03 21:11:07');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.goods_category 的数据：~13 rows (大约)
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
	(10, 0, '007000000', '高级镜头', '2018-05-02 21:35:44', '2018-05-02 21:35:44'),
	(11, 10, '007001000', '高级镜头', '2018-05-02 21:39:49', '2018-05-02 21:39:49'),
	(12, 11, '007001001', '高级镜头', '2018-05-02 21:40:24', '2018-05-02 21:40:23');
/*!40000 ALTER TABLE `goods_category` ENABLE KEYS */;


-- 导出  表 goodscm.goods_his 结构
CREATE TABLE IF NOT EXISTS `goods_his` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- 正在导出表  goodscm.goods_his 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods_his` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_his` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 正在导出表  goodscm.goods_pic 的数据：~45 rows (大约)
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
	(31, 22, 0, 'C:\\Users\\solon\\datas\\goodspics\\f62c33477d7a4553b0d1c12b78c768c4', '2016-10-19 2016-10-19 002 001.jpg', b'0', NULL, NULL),
	(32, 22, 1, 'C:\\Users\\solon\\datas\\goodspics\\82dc20856e93475c88ee750b71385687', '2016-10-27 2016-10-27 001 001.jpg', b'1', NULL, NULL),
	(33, 22, 2, 'C:\\Users\\solon\\datas\\goodspics\\42dba2b2797249d983ec5db9f60d0e2d', '2016-11-01 2016-11-01 001 001.gif', b'0', NULL, NULL),
	(34, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\98bf71641ad948e0b34d2a13f88e963e', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-03 19:35:40'),
	(35, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\7e6052fd2ed44d17bd69d3d535beacf6', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-03 19:35:40'),
	(36, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\d8d3ef972ad8442f9d298bea1898f6b3', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-03 19:35:40'),
	(37, NULL, 0, 'C:\\Users\\solon\\datas\\goodspics\\c22eadfa12cb4f6a8d1955fb1754c98b', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-03 19:38:07'),
	(38, NULL, 1, 'C:\\Users\\solon\\datas\\goodspics\\099955b43bea44389becf551789db4ab', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-03 19:38:07'),
	(39, NULL, 2, 'C:\\Users\\solon\\datas\\goodspics\\2c8a620ae08e4b15b275a28b3d080287', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-03 19:38:07'),
	(40, 25, 0, 'C:\\Users\\solon\\datas\\goodspics\\4cad4a9f9f8b4b0bb0c1797151f1254f', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-03 19:39:38'),
	(41, 25, 1, 'C:\\Users\\solon\\datas\\goodspics\\48621e6dcd834214ac460bc353338124', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-03 19:39:38'),
	(42, 25, 2, 'C:\\Users\\solon\\datas\\goodspics\\a976dd5f65f847b3a6eea325b522ab79', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-03 19:39:38'),
	(43, 26, 0, 'C:\\Users\\solon\\datas\\goodspics\\7c3f69eb691f4c5397e9cdc8ed29710b', '2016-10-19 2016-10-19 002 001.jpg', b'1', 0, '2018-05-03 19:44:44'),
	(44, 26, 1, 'C:\\Users\\solon\\datas\\goodspics\\ab0dddc4d0ca4337bad0d98616b0eabe', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-03 19:44:44'),
	(45, 26, 2, 'C:\\Users\\solon\\datas\\goodspics\\1ab0feedc6234575b5306f20cad92f8f', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-03 19:44:44');
/*!40000 ALTER TABLE `goods_pic` ENABLE KEYS */;


-- 导出  表 goodscm.goods_post_recode 结构
CREATE TABLE IF NOT EXISTS `goods_post_recode` (
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

-- 正在导出表  goodscm.goods_post_recode 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods_post_recode` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_post_recode` ENABLE KEYS */;


-- 导出  表 goodscm.platform 结构
CREATE TABLE IF NOT EXISTS `platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '平台名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='电商平台';

-- 正在导出表  goodscm.platform 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `platform` DISABLE KEYS */;
INSERT INTO `platform` (`id`, `code`, `name`, `create_time`) VALUES
	(1, 'TAOBAO', '淘宝', '2018-05-01 21:31:32'),
	(2, 'JD', '京东', '2018-05-01 21:31:47'),
	(3, 'EBAY', 'eBay', '2018-05-01 21:32:01'),
	(4, 'AMAZON', '亚马逊', '2018-05-01 21:32:36');
/*!40000 ALTER TABLE `platform` ENABLE KEYS */;


-- 导出  表 goodscm.platform_release_recode 结构
CREATE TABLE IF NOT EXISTS `platform_release_recode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '销售平台/渠道ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `release_state` smallint(6) DEFAULT NULL COMMENT '渠道上店状态',
  `release_price` decimal(10,0) DEFAULT NULL COMMENT '上店价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='销售平台/渠道记录表';

-- 正在导出表  goodscm.platform_release_recode 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `platform_release_recode` DISABLE KEYS */;
INSERT INTO `platform_release_recode` (`id`, `platform_id`, `goods_id`, `release_state`, `release_price`, `create_time`, `update_time`) VALUES
	(1, 1, 1, 0, NULL, '2018-05-01 22:06:42', '2018-05-01 22:06:43'),
	(3, 2, 1, 0, 12, '2018-05-01 22:07:44', '2018-05-01 22:07:45');
/*!40000 ALTER TABLE `platform_release_recode` ENABLE KEYS */;


-- 导出  表 goodscm.supplier 结构
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '供货商名字',
  `code` varchar(100) NOT NULL COMMENT '编号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='供货商';

-- 正在导出表  goodscm.supplier 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `name`, `code`, `create_time`) VALUES
	(1, '共饮1', '1111', '2018-05-03 21:38:14'),
	(2, '供应2', '2222', '2018-05-03 21:38:37'),
	(3, '龙良华', '3333', '2018-05-03 21:39:01'),
	(4, '肖文强', '4444', '2018-05-03 21:39:14');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- 导出  表 goodscm.supplier_recode 结构
CREATE TABLE IF NOT EXISTS `supplier_recode` (
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

-- 正在导出表  goodscm.supplier_recode 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `supplier_recode` DISABLE KEYS */;
INSERT INTO `supplier_recode` (`id`, `supplier_id`, `goods_id`, `unit_price`, `quantity`, `total_price`, `purchase_time`, `create_time`) VALUES
	(1, 1, 25, 100.00, 1, 100, '2018-05-03 19:39:38', '2018-05-03 19:39:44'),
	(2, 2, 25, 100.00, 1, 100, '2018-05-03 19:39:38', '2018-05-03 19:39:45'),
	(3, 3, 25, 100.00, 1, 100, '2018-05-03 19:39:38', '2018-05-03 19:39:46'),
	(4, 4, 25, 100.00, 1, 100, '2018-05-03 19:39:38', '2018-05-03 19:39:47'),
	(5, 1, 26, 100.00, 1, 100, '2018-05-03 19:44:44', '2018-05-03 19:44:47'),
	(6, 2, 26, 100.00, 1, 100, '2018-05-03 19:44:44', '2018-05-03 19:44:47'),
	(7, 3, 26, 100.00, 1, 100, '2018-05-03 19:44:44', '2018-05-03 19:44:47'),
	(8, 4, 26, 100.00, 1, 100, '2018-05-03 19:44:44', '2018-05-03 19:44:47');
/*!40000 ALTER TABLE `supplier_recode` ENABLE KEYS */;


-- 导出  表 goodscm.sys_permission 结构
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.sys_permission 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` (`id`, `role_id`, `resource_id`) VALUES
	(1, 1, 0),
	(2, 2, 1),
	(3, 2, 2),
	(4, 2, 3);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;


-- 导出  表 goodscm.sys_resources 结构
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_tag_path` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.sys_resources 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `res_tag_path`, `create_time`) VALUES
	(1, '/goods/view', '2018-04-29 10:23:30'),
	(2, '/goods/edit', '2018-04-29 10:23:45'),
	(3, '/goods/delete', '2018-04-29 10:23:54');
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;


-- 导出  表 goodscm.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.sys_role 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `role_name`) VALUES
	(1, 'admin'),
	(2, 'employee');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 goodscm.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '是否为管理员',
  `account` varchar(50) DEFAULT NULL COMMENT '帐号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  goodscm.users 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role_id`, `account`, `password`, `user_name`, `create_time`, `update_time`) VALUES
	(1, 1, 'admin', '4280d89a5a03f812751f504cc10ee8a5', 'longlianghua', '2018-04-29 09:56:08', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
