-- 0取消外键约束 1设置外键约束
SET FOREIGN_KEY_CHECKS = 0;
-- 管理员表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
	`userName` VARCHAR(50) NOT NULL COMMENT '登录账号',
	`pwd` VARCHAR(50) NOT NULL COMMENT '登录密码',
	`nickName` VARCHAR(50) DEFAULT NULL COMMENT '昵称',
	`state` int(2) NOT NULL DEFAULT '0' COMMENT '状态0=可用,1=禁用',
	`loginCount` int(11) DEFAULT NULL COMMENT '登录次数',
	`loginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
	`createTime` datetime DEFAULT NULL COMMENT '创建时间',
	`updateTime` datetime DEFAULT NULL COMMENT '创建时间',
	`superAdmin` int(1) NOT NULL DEFAULT '0' COMMENT '是否超级管理员0=不是,1=是',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 菜单
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
	`url` VARCHAR(100) DEFAULT NULL COMMENT '系统url',
	`parentId` int(10) DEFAULT NULL COMMENT '父id 关联sys_menu.id',
	`state` int(1) NOT NULL DEFAULT '0' COMMENT '0=可用,1=禁用',
	`createTime` datetime DEFAULT NULL COMMENT '创建时间',
	`updateTime` datetime DEFAULT NULL COMMENT '修改时间',
	`rank` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 菜单按钮
DROP TABLE IF EXISTS `sys_menu_btn`;
CREATE TABLE `sys_menu_btn` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`menuid` int(11) NOT NULL COMMENT '菜单id关联 sys_menu.id',
	`btnName` varchar(30) DEFAULT NULL COMMENT '按钮名称',
	`btnType` VARCHAR(30) DEFAULT NULL COMMENT '按钮类型',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 角色管理
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`roleName` VARCHAR(30) DEFAULT NULL COMMENT '角色名称',
	`createTime` datetime DEFAULT NULL COMMENT '创建时间',
	`updateTime` datetime DEFAULT NULL COMMENT '修改时间',
	`state` int(1) DEFAULT '0' COMMENT '0=可用,1=禁用',
	`descr` VARCHAR(100) DEFAULT NULL COMMENT '角色描述',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 角色权限
DROP TABLE IF EXISTS `sys_role_rel`;
CREATE TABLE `sys_role_rel` (
	`roleId` int(11) NOT NULL COMMENT '角色主键 sys_role.id',
	`objId` int(11) not NULL COMMENT '关联主键 type=0管理sys_menu.id,type=1关联sys_user.id',
	`relType` int(1) DEFAULT NULL COMMENT '关联类型 0=菜单 1=用户'
)ENGINE = INNODB DEFAULT CHARSET = utf8;

















