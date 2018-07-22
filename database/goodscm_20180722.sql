-- --------------------------------------------------------
-- 主机:                           120.55.189.150
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
  `group_id` bigint(20) DEFAULT NULL COMMENT '分组ID',
  `price_level_id` bigint(20) DEFAULT NULL COMMENT '价格等级',
  `code` varchar(50) DEFAULT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `full_name` varchar(255) NOT NULL COMMENT '客户完整公司名',
  `contact` varchar(255) NOT NULL COMMENT '联系人',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `fax` varchar(50) DEFAULT NULL COMMENT '传真',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(50) DEFAULT NULL COMMENT '微信',
  `wangwang_no` varchar(50) DEFAULT NULL COMMENT '旺旺号',
  `other_contact` varchar(50) DEFAULT NULL COMMENT '其它联系方式',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(512) DEFAULT NULL COMMENT '网站',
  `address` varchar(255) DEFAULT NULL COMMENT '经营地址',
  `memo` text COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 数据导出被取消选择。


-- 导出  表 goodscm.customer_group 结构
CREATE TABLE IF NOT EXISTS `customer_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '组名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户分组表';

-- 数据导出被取消选择。


-- 导出  表 goodscm.customer_level_price 结构
CREATE TABLE IF NOT EXISTS `customer_level_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '客户等级价格名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户等级价格';

-- 数据导出被取消选择。


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
  PRIMARY KEY (`id`),
  UNIQUE KEY `short_name` (`short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 数据导出被取消选择。


-- 导出  表 goodscm.goods_category 结构
CREATE TABLE IF NOT EXISTS `goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父类ID',
  `category_code` varchar(50) NOT NULL COMMENT '类别编码 ，采用000 000 000（每级最多999个不包括000），支持三级类别，需要可以再加',
  `name` varchar(100) NOT NULL COMMENT '类别名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 数据导出被取消选择。


-- 导出  表 goodscm.goods_post_cart 结构
CREATE TABLE IF NOT EXISTS `goods_post_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `short_name` varchar(50) DEFAULT NULL COMMENT '品名中文',
  `status` smallint(6) DEFAULT '1' COMMENT '状态 (0：以导出，1：未导出)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品信息呈递车';

-- 数据导出被取消选择。


-- 导出  表 goodscm.goods_unit 结构
CREATE TABLE IF NOT EXISTS `goods_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '单位名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品数量单位表\r\n包，本，把，袋，打，个，盒，件，斤，块，瓶，片，双，套，台，条，只，支';

-- 数据导出被取消选择。


-- 导出  表 goodscm.plateform 结构
CREATE TABLE IF NOT EXISTS `plateform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '平台名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电商平台';

-- 数据导出被取消选择。


-- 导出  表 goodscm.plateform_release_record 结构
CREATE TABLE IF NOT EXISTS `plateform_release_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '销售平台/渠道ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `release_state` smallint(6) DEFAULT NULL COMMENT '渠道上店状态',
  `release_price` decimal(10,0) DEFAULT NULL COMMENT '上店价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售平台/渠道记录表';

-- 数据导出被取消选择。


-- 导出  表 goodscm.supplier 结构
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` bigint(20) DEFAULT NULL COMMENT '分组ID',
  `name` varchar(255) NOT NULL COMMENT '供货商名字',
  `code` varchar(100) NOT NULL COMMENT '编号',
  `description` text COMMENT '供应商完整公司名或主要产品',
  `contacts` varchar(50) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `fax` varchar(50) DEFAULT NULL COMMENT '传真',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ号码',
  `wechat` varchar(50) DEFAULT NULL COMMENT '微信',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `website` varchar(512) DEFAULT NULL COMMENT '网站',
  `address` varchar(255) DEFAULT NULL COMMENT '经营地址',
  `memo` text COMMENT '备注',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '状态(0:正常, 1停用)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供货商';

-- 数据导出被取消选择。


-- 导出  表 goodscm.supplier_group 结构
CREATE TABLE IF NOT EXISTS `supplier_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '组名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商分组';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供货商';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- 数据导出被取消选择。


-- 导出  表 goodscm.sys_permission 结构
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 goodscm.sys_resources 结构
CREATE TABLE IF NOT EXISTS `sys_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_tag_path` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 goodscm.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- 数据导出被取消选择。


-- 导出  表 goodscm.sys_role_menu 结构
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- 数据导出被取消选择。


-- 导出  表 goodscm.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- 数据导出被取消选择。


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
