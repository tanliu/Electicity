/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : elecrecord

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-06-08 14:01:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_role`;
CREATE TABLE `tb_sys_user_role` (
  `id` varchar(32) NOT NULL COMMENT '主键标识ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '标识ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '主键ID',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`role_id`),
  KEY `FK_Reference_6` (`user_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`user_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`role_id`) REFERENCES `tb_sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个用户可以有多个角色';

-- ----------------------------
-- Records of tb_sys_user_role
-- ----------------------------
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e0551ffe7c01552004fff10012', null, '8a8fa1e0551ffe7c01552004e06d000b');
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e055202c6801552032bf960020', '8a8fa1e05513be55015513c43af10002', '8a8fa1e0551c312301551c34ff6a0000');
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e055202c6801552032d0560021', '8a8fa1e05513be55015513c8bacf0004', '8a8fa1e0551c312301551c34ff6a0000');
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e055202c6801552032ea8f0022', '8a8fa1e05513be55015513c969150005', '8a8fa1e0551c312301551c34ff6a0000');
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e055202c6801552032fded0023', '8a8fa1e05513be55015513cb90e60006', '8a8fa1e0551c312301551c34ff6a0000');
INSERT INTO `tb_sys_user_role` VALUES ('8a8fa1e0552da07b01552da1eb310002', '8a8fa1e0552da07b01552da1eb2f0001', '8a8fa1e0551ffe7c01552004e06d000b');
