/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : elecrecord

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-06-08 14:01:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `user_id` varchar(32) NOT NULL COMMENT '标识ID',
  `org_id` varchar(32) DEFAULT NULL COMMENT '标识ID',
  `employ_no` varchar(10) DEFAULT NULL COMMENT '用户编号',
  `employ_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sex` int(11) DEFAULT NULL COMMENT '性别 0-男 1-女',
  `tell` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `status` int(11) DEFAULT NULL COMMENT '状态 0-启用 1-禁用',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_type` varchar(2) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_7` (`org_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`org_id`) REFERENCES `tb_sys_organization` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_user
-- ----------------------------
INSERT INTO `tb_sys_user` VALUES ('8a8fa1e05513be55015513c43af10002', '8a8fa1e05513be55015513c6e4930003', '1000', '谭柳', '2016-06-03 08:57:55', '1', '13172661290', '1', '37栋323', '987420817@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '学生');
INSERT INTO `tb_sys_user` VALUES ('8a8fa1e05513be55015513c8bacf0004', '8a8fa1e05513be55015513c6e4930003', '1001', '罗吉林', '2016-06-03 09:02:50', '1', '13172661290', '1', '37栋315', '98742084@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '学生');
INSERT INTO `tb_sys_user` VALUES ('8a8fa1e05513be55015513c969150005', '8a8fa1e05513be55015513c6e4930003', '1002', '罗建鑫', '2016-06-03 09:03:34', '1', '13172661290', '1', '37栋323', '98742084@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '学生');
INSERT INTO `tb_sys_user` VALUES ('8a8fa1e05513be55015513cb90e60006', '8a8fa1e05513be55015513c6e4930003', '1003', '朱嘉鑫', '2016-06-03 09:05:55', '1', '13172661290', '1', '37栋211', '98742084@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '学生');
INSERT INTO `tb_sys_user` VALUES ('8a8fa1e0552da07b01552da1eb2f0001', '8a8fa1e05513b1e2015513b4714a0000', '9527', '只是测试一下', '2016-06-08 09:30:34', '1', '13172661290', '1', '广东', '987420817@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '学生');
