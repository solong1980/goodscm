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


-- 导出  表 goodscm.channel_sale_recode 结构
CREATE TABLE IF NOT EXISTS `channel_sale_recode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `channel` bigint(20) DEFAULT NULL COMMENT '渠道ID',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `release_state` smallint(6) DEFAULT NULL COMMENT '渠道上店状态',
  `release_price` decimal(10,0) DEFAULT NULL COMMENT '上店价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售渠道记录表';

-- 正在导出表  goodscm.channel_sale_recode 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `channel_sale_recode` DISABLE KEYS */;
/*!40000 ALTER TABLE `channel_sale_recode` ENABLE KEYS */;


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
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 正在导出表  goodscm.goods 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  goodscm.goods_category 的数据：~10 rows (大约)
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
	(9, 6, '006001000', '清洁产品类', '2018-04-30 17:24:28', '2018-04-30 17:32:18');
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


-- 导出  表 goodscm.supplier 结构
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商';

-- 正在导出表  goodscm.supplier 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- 导出  表 goodscm.supplier_recode 结构
CREATE TABLE IF NOT EXISTS `supplier_recode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_id` bigint(20) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商';

-- 正在导出表  goodscm.supplier_recode 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `supplier_recode` DISABLE KEYS */;
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
