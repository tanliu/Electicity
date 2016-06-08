/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : elecrecord

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-06-08 14:00:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sys_organization`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_organization`;
CREATE TABLE `tb_sys_organization` (
  `org_id` varchar(32) NOT NULL COMMENT '标识ID',
  `org_name` varchar(128) DEFAULT NULL COMMENT '机构名称',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级机构ID',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级机构ID',
  `address` varchar(128) DEFAULT NULL COMMENT '详细地址',
  `post_code` varchar(16) DEFAULT NULL COMMENT '邮编',
  `contact_man` varchar(32) DEFAULT NULL COMMENT '联系人（负责人）',
  `tell` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `fax` varchar(16) DEFAULT NULL COMMENT '传真',
  `email` varchar(32) DEFAULT NULL COMMENT 'Email',
  `state` varchar(16) DEFAULT NULL COMMENT '0停用;1启用',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_organization
-- ----------------------------
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513b1e2015513b4714a0000', '计算机学院', '0', '0', '知行楼A栋', '524431', '某老师', '13172661290', '0756-6936542', '987420817@qq.com', '开启');
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513b1e2015513b863050001', '软件工程', '8a8fa1e05513b1e2015513b4714a0000', '0,8a8fa1e05513b1e2015513b4714a0000', '知行楼', '524431', '王老师', '13172661290', '0759-6396542', '987420817@qq.com', '开启');
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513b1e2015513b9e0160002', '云计算科研室', '8a8fa1e05513b1e2015513b4714a0000', '0,8a8fa1e05513b1e2015513b4714a0000', '知行楼A栋', '524431', '吴老师', '13172661290', '0759-6936542', '987420817@qq.com', '开启');
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513be55015513c0f5c60000', '测试科研室', '8a8fa1e05513b1e2015513b4714a0000', '0,8a8fa1e05513b1e2015513b4714a0000', '知行楼A栋', '524431', '张教师', '13172661290', '0759-6936542', '98742017@qq.com', '开启');
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513be55015513c28d1d0001', '数据库科研室', '8a8fa1e05513b1e2015513b4714a0000', '0,8a8fa1e05513b1e2015513b4714a0000', '知行楼科研室', '524431', '张老师', '13172661290', '5729-6396542', '987420817@qq.com', '开启');
INSERT INTO `tb_sys_organization` VALUES ('8a8fa1e05513be55015513c6e4930003', '开发小组', '8a8fa1e05513b1e2015513b4714a0000', '0,8a8fa1e05513b1e2015513b4714a0000', 'ZA403', '524431', '谭柳', '13172661290', '0759-6396542', '987420817', '开启');
