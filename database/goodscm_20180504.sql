/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `goodscm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goodscm`;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `memo` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

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
	(21, '1111', 'company short name', 1000, NULL, '强强强', 'strongstring', 10.00000, 10.00000, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 10.00, 1, 'Meno', 'zh_info', 'en_info', 'ext_info', 10, '2018-05-04 14:17:04', '2018-05-04 14:17:03');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类ID',
  `category_code` varchar(50) NOT NULL COMMENT '类别编码 ，采用000 000 000（每级最多999个不包括000），支持三级类别，需要可以再加',
  `name` varchar(100) NOT NULL COMMENT '类别名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

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

/*!40000 ALTER TABLE `goods_his` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_his` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

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
	(46, 21, 0, 'C:\\Users\\Travelsky\\datas\\goodspics\\a440028674ac4f3ab659505cd5723a01', '2016-10-19 2016-10-19 002 001.jpg', b'1', 0, '2018-05-04 14:17:03'),
	(47, 21, 1, 'C:\\Users\\Travelsky\\datas\\goodspics\\25e486e2a1b04c4d8ecc7986ccd3198b', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 14:17:03'),
	(48, 21, 2, 'C:\\Users\\Travelsky\\datas\\goodspics\\feda895b2f2e4be8a6731e34a86b2662', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 14:17:03'),
	(49, NULL, 0, 'C:\\Users\\Travelsky\\datas\\goodspics\\d615dc07002045b4acec8514bd81e982', '2016-10-19 2016-10-19 002 001.jpg', b'0', 0, '2018-05-04 14:17:58'),
	(50, NULL, 1, 'C:\\Users\\Travelsky\\datas\\goodspics\\e749197028b846e6b1cbf7d48e56363c', '2016-10-27 2016-10-27 001 001.jpg', b'0', 0, '2018-05-04 14:17:58'),
	(51, NULL, 2, 'C:\\Users\\Travelsky\\datas\\goodspics\\33e75282170441eb8fdc2640394e0a6a', '2016-11-01 2016-11-01 001 001.gif', b'0', 0, '2018-05-04 14:17:58');
/*!40000 ALTER TABLE `goods_pic` ENABLE KEYS */;

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

/*!40000 ALTER TABLE `goods_post_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_post_record` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `plateform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '平台名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='电商平台';

/*!40000 ALTER TABLE `plateform` DISABLE KEYS */;
INSERT INTO `plateform` (`id`, `code`, `name`, `create_time`) VALUES
	(1, 'TAOBAO', '淘宝', '2018-05-01 21:31:32'),
	(2, 'JD', '京东', '2018-05-01 21:31:47'),
	(3, 'EBAY', 'eBay', '2018-05-01 21:32:01'),
	(4, 'AMAZON', '亚马逊', '2018-05-01 21:32:36');
/*!40000 ALTER TABLE `plateform` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `plateform_release_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '销售平台/渠道ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `release_state` smallint(6) DEFAULT NULL COMMENT '渠道上店状态',
  `release_price` decimal(10,0) DEFAULT NULL COMMENT '上店价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='销售平台/渠道记录表';

/*!40000 ALTER TABLE `plateform_release_record` DISABLE KEYS */;
INSERT INTO `plateform_release_record` (`id`, `platform_id`, `goods_id`, `release_state`, `release_price`, `create_time`, `update_time`) VALUES
	(1, 1, 1, 0, NULL, '2018-05-01 22:06:42', '2018-05-01 22:06:43'),
	(3, 2, 1, 0, 12, '2018-05-01 22:07:44', '2018-05-01 22:07:45');
/*!40000 ALTER TABLE `plateform_release_record` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '供货商名字',
  `code` varchar(100) DEFAULT NULL COMMENT '编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商';

/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商';

/*!40000 ALTER TABLE `supplier_record` DISABLE KEYS */;
INSERT INTO `supplier_record` (`id`, `supplier_id`, `goods_id`, `unit_price`, `quantity`, `total_price`, `purchase_time`, `create_time`) VALUES
	(1, 1, 21, 100.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04'),
	(2, 2, 21, 100.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04'),
	(3, 3, 21, 100.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04'),
	(4, 4, 21, 100.00, 1, 100, '2018-05-04 14:17:03', '2018-05-04 14:17:04');
/*!40000 ALTER TABLE `supplier_record` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` (`id`, `role_id`, `resource_id`) VALUES
	(1, 1, 0),
	(2, 2, 1),
	(3, 2, 2),
	(4, 2, 3);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_tag_path` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `sys_resources` DISABLE KEYS */;
INSERT INTO `sys_resources` (`id`, `res_tag_path`, `create_time`) VALUES
	(1, '/goods/view', '2018-04-29 10:23:30'),
	(2, '/goods/edit', '2018-04-29 10:23:45'),
	(3, '/goods/delete', '2018-04-29 10:23:54');
/*!40000 ALTER TABLE `sys_resources` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `role_name`) VALUES
	(1, 'admin'),
	(2, 'employee');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

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

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `role_id`, `account`, `password`, `user_name`, `create_time`, `update_time`) VALUES
	(1, 1, 'admin', '4280d89a5a03f812751f504cc10ee8a5', 'longlianghua', '2018-04-29 09:56:08', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
