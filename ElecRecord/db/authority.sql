/*
Navicat MySQL Data Transfer

Source Server         : Project
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : elecrecord

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-06-08 14:00:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_sys_authority`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_authority`;
CREATE TABLE `tb_sys_authority` (
  `authority_id` varchar(32) NOT NULL COMMENT '权限ID',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父级权限ID',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级权限ID',
  `authority_name` varchar(64) NOT NULL COMMENT '权限名称',
  `authority_type` int(11) NOT NULL COMMENT '权限类型 0-菜单 1-新增 2-修改 3-查询 4-删除 5-导出 6-导入 7-授权',
  `module_name` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `url` varchar(200) DEFAULT NULL COMMENT '访问地址',
  `operation` varchar(32) DEFAULT NULL COMMENT '操作',
  `menu_no` varchar(32) DEFAULT NULL COMMENT '菜单排序号',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_sys_authority
-- ----------------------------
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513be55015513e1b45d0007', '0', '0', '基本信息管理', '0', '基本信息管理', '先不写', '基本信息管理', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513be55015513e30f060008', '8a8fa1e05513be55015513e1b45d0007', '0,8a8fa1e05513be55015513e1b45d0007', '学生基本信息', '0', '学生基本信息', '好是先不写', '学生基本信息', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513e67d015513e801c70000', '8a8fa1e05513be55015513e1b45d0007', '0,8a8fa1e05513be55015513e1b45d0007', '教师基本信息', '0', '教师基本信息', '', '教师基本信息', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f277bf0000', '0', '0', '学生学习情况管理', '0', '学生学习情况管理', '', '学生学习情况管理', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f2b3380001', '8a8fa1e05513ed95015513f277bf0000', '0,8a8fa1e05513ed95015513f277bf0000', '教师开课信息', '0', '教师开课信息', '', '教师开课信息', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f2f18f0002', '8a8fa1e05513ed95015513f277bf0000', '0,8a8fa1e05513ed95015513f277bf0000', '学生选课成绩', '0', '学生选课成绩', '', '学生选课成绩', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f349080003', '0', '0', '奖助贷信息管理', '0', '奖助贷信息管理', '', '奖助贷信息管理', '2', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f394120004', '8a8fa1e05513ed95015513f349080003', '0,8a8fa1e05513ed95015513f349080003', '国家助学金', '0', '国家助学金', '', '国家助学金', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f44de30006', '8a8fa1e05513ed95015513f349080003', '0,8a8fa1e05513ed95015513f349080003', '国家奖学金', '0', '国家奖学金', '', '国家奖学金', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f480720007', '8a8fa1e05513ed95015513f349080003', '0,8a8fa1e05513ed95015513f349080003', '贷款信息', '0', '贷款信息', '', '贷款信息', '2', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f4bf2c0008', '0', '0', '辅导培训信息管理', '0', '辅导培训信息管理', '', '辅导培训信息管理', '3', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f4eef10009', '8a8fa1e05513ed95015513f4bf2c0008', '0,8a8fa1e05513ed95015513f4bf2c0008', '辅导记录维护', '0', '辅导记录维护', '', '辅导记录维护', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f60710000a', '8a8fa1e05513ed95015513f4bf2c0008', '0,8a8fa1e05513ed95015513f4bf2c0008', '导学情况维护', '0', '导学情况维护', '', '导学情况维护', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f66e12000b', '8a8fa1e05513ed95015513f4bf2c0008', '0,8a8fa1e05513ed95015513f4bf2c0008', '考勤记录维护', '0', '考勤记录维护', '', '考勤记录维护', '3', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f6b101000c', '8a8fa1e05513ed95015513f4bf2c0008', '0,8a8fa1e05513ed95015513f4bf2c0008', '培训情况信息管理', '0', '培训情况信息管理', '', '培训情况信息管理', '3', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f728be000e', '8a8fa1e05513ed95015513f4bf2c0008', '0,8a8fa1e05513ed95015513f4bf2c0008', '学科竞赛维护', '0', '学科竞赛维护', '', '学科竞赛维护', '4', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f75f3e000f', '0', '0', '档案信息管理', '0', '档案信息管理', '', '档案信息管理', '4', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05513ed95015513f78da20010', '8a8fa1e05513ed95015513f75f3e000f', '0,8a8fa1e05513ed95015513f75f3e000f', '学籍异动信息维护', '0', '学籍异动信息维护', '', '学籍异动信息维护', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05514000c01551401ad500000', '8a8fa1e05513ed95015513f75f3e000f', '0,8a8fa1e05513ed95015513f75f3e000f', '档案邮寄信息维护', '0', '档案邮寄信息维护', '', '档案邮寄信息维护', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05514000c01551403af160002', '0', '0', '身份信息管理', '0', '身份信v息管理', '', '身份信v息管理', '5', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05514000c01551403e2de0003', '8a8fa1e05514000c01551403af160002', '0,8a8fa1e05514000c01551403af160002', '党团关系管理', '0', '党团关系管理', '', '党团关系管理', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e05514000c015514040ecf0004', '8a8fa1e05514000c01551403af160002', '0,8a8fa1e05514000c01551403af160002', '学生职务信息管理', '0', '学生职务信息管理', '', '学生职务信息管理', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fca3fb60019', '0', '0', '系统管理', '0', '系统管理', '/system/', '系统管理', '6', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fcadea8001a', '8a8fa1e0551fc14801551fca3fb60019', '0,8a8fa1e0551fc14801551fca3fb60019', '用户管理', '0', '用户管理', '/system/user_listUI.action', '用户管理', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fceedd60026', '8a8fa1e0551fc14801551fca3fb60019', '0,8a8fa1e0551fc14801551fca3fb60019', '角色管理', '0', '角色管理', 'system/role_listUI.action', '角色管理', '1', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fd2eb030033', '8a8fa1e0551fc14801551fca3fb60019', '0,8a8fa1e0551fc14801551fca3fb60019', '权限管理', '0', '权限管理', 'system/authority_listUI.action', '权限管理', '2', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fd3a2e60034', '8a8fa1e0551fc14801551fca3fb60019', '0,8a8fa1e0551fc14801551fca3fb60019', '部门信息', '0', '部门信息', 'system/organize_listUI.action', '部门信息', '3', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0551fc14801551fd83d610036', '8a8fa1e0551fc14801551fca3fb60019', '0,8a8fa1e0551fc14801551fca3fb60019', '数据字典', '0', '数据字典', 'system/systemddl_listUI.action', '数据字典', '5', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0552150aa01552152fb680000', '8a8fa1e0551fc14801551fd2eb030033', null, '删除', '4', '删除', 'system/authority_delete.action', '删除', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0552b867601552b8953650001', '0', null, '学生基本信息', '0', '学生基本信息', '', '学生基本信息', '0', '');
INSERT INTO `tb_sys_authority` VALUES ('8a8fa1e0552b867601552b8ad8910002', '8a8fa1e0552b867601552b8953650001', 'null,8a8fa1e0552b867601552b8953650001', '学生信息', '0', '学生信息', 'student/student_addUI.action', '学生信息', '0', '');
