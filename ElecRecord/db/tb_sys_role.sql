/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : elecrecord

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-06-08 14:01:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_role`;
CREATE TABLE `tb_sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT '主键ID',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `role_no` varchar(32) DEFAULT NULL COMMENT '排序号',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_role
-- ----------------------------
INSERT INTO `tb_sys_role` VALUES ('8a8fa1e0551c312301551c34ff6a0000', '系统超级管理员', null, '3', '试');
INSERT INTO `tb_sys_role` VALUES ('8a8fa1e0551ffe7c01552004e06d000b', '测试', null, '0759', '0000');
