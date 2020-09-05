/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : asdf

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 04/09/2020 23:28:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for certification
-- ----------------------------
DROP TABLE IF EXISTS `certification`;
CREATE TABLE `certification`  (
  `certification_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '认证流水号',
  `team_id` int(0) NULL DEFAULT NULL,
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '团队名称',
  `activity_begin_time` datetime(0) NULL DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime(0) NULL DEFAULT NULL COMMENT '活动结束时间',
  `team_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '团队等级',
  `is_pass` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否通过',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建申请时间',
  `certification_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  `certification_file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核书存储路径',
  PRIMARY KEY (`certification_id`) USING BTREE,
  UNIQUE INDEX `团队唯一申请`(`team_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certification
-- ----------------------------
INSERT INTO `certification` VALUES (27, 30, '兔子和老鹰', '2020-09-11 00:00:00', '2020-09-10 00:00:00', '校级团队', '审核通过', '2020-09-04 22:17:48', '2020-09-04 22:48:51', '/file/a7da3be89a104661bdbc4466654f4143.pdf');

-- ----------------------------
-- Table structure for expense
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense`  (
  `expense_code` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `expense_organization` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销的组织',
  `expense_money` double NOT NULL COMMENT '报销金额',
  `expense_pic` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销单据图片存储地址',
  `expense_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `expense_certifictedCondition` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报销审核状态',
  PRIMARY KEY (`expense_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expense
-- ----------------------------
INSERT INTO `expense` VALUES (30, '兔子和老鹰', 343, '/file/2585fb757bcf4dd79300f3b52536efaa.png', '2020-09-04 23:24:39', '待审核');

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `verify` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`team_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES ('34123', '012001800311', '33207675', '2019-05-08', '46.62', '76939056883466677916');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `log_code` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志流水',
  `log_team_id` int(0) NULL DEFAULT NULL COMMENT '团队id',
  `log_specific` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '日志具体内容',
  `log_operate_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '日志操作时间',
  `log_time` date NULL DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`log_code`) USING BTREE,
  UNIQUE INDEX `test`(`log_team_id`, `log_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (5, 2, '尽诛宵小天策义', '2020-08-29 10:10:46', '2020-08-31');
INSERT INTO `log` VALUES (7, 4, '是的呢', '2020-08-29 14:19:55', '2020-08-31');
INSERT INTO `log` VALUES (31, 1, '你猜', '2020-08-31 11:57:31', '2020-08-31');
INSERT INTO `log` VALUES (66, 30, '312312', '2020-09-04 22:27:22', '2020-09-10');
INSERT INTO `log` VALUES (67, 30, 'dqwdq', '2020-09-04 22:27:41', '2020-09-15');

-- ----------------------------
-- Table structure for route
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`  (
  `route_code` int(0) NOT NULL AUTO_INCREMENT,
  `route_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `route_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_route_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_route_code` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`route_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES (1, '新建团队日志', '2', '/pages/log/log_new.html', '团队日志', 4);
INSERT INTO `route` VALUES (2, '查询本团队日志', '2', '/pages/log/log_myTeamLog.html', '团队日志', 4);
INSERT INTO `route` VALUES (3, '查询所有日志', '2', '/pages/log/log_queryAllLog.html', '团队日志', 4);
INSERT INTO `route` VALUES (4, '团队日志模块', '1', '/pages/log', '团队日志', -1);
INSERT INTO `route` VALUES (5, '团队活动模块', '1', '/pages/teamApply', '团队活动', -1);
INSERT INTO `route` VALUES (6, '团队活动申请', '2', '/pages/teamApply/Teamapply.html', '团队活动', 5);
INSERT INTO `route` VALUES (7, '本团队活动申请查询', '2', '/pages/teamApply/QueryMyApply.html', '团队活动', 5);
INSERT INTO `route` VALUES (8, '团队活动全部查询', '2', '/pages/teamApply/QueryAllApply.html', '团队活动', 5);
INSERT INTO `route` VALUES (9, '团队管理模块', '1', '/pages/team', '团队管理', -1);
INSERT INTO `route` VALUES (10, '添加团队', '2', '/pages/team/add_team.html', '团队管理', 9);
INSERT INTO `route` VALUES (11, '查询团队', '2', '/pages/team/query_team.html', '团队管理', 9);
INSERT INTO `route` VALUES (13, '查询团队成员', '2', '/pages/team/query_member.html', '团队管理', 9);
INSERT INTO `route` VALUES (14, '我的团队管理模块', '1', '/pages/Myteam', '我的团队管理', -1);
INSERT INTO `route` VALUES (16, '查询我的团队', '2', '/pages/Myteam/query_myteam.html', '我的团队管理', 14);
INSERT INTO `route` VALUES (19, '财务报销模块', '1', '/pages/finance', '财务报销', NULL);
INSERT INTO `route` VALUES (20, '报销申请', '2', '/pages/finance/Expenseapply.html', '财务报销', NULL);
INSERT INTO `route` VALUES (21, '查询审核报销申请', '2', '/pages/finance/QueryExpense.html', '财务报销', NULL);

-- ----------------------------
-- Table structure for route_right
-- ----------------------------
DROP TABLE IF EXISTS `route_right`;
CREATE TABLE `route_right`  (
  `route_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `route_parent_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route_right
-- ----------------------------
INSERT INTO `route_right` VALUES ('1', '4', '100');
INSERT INTO `route_right` VALUES ('2', '4', '100');
INSERT INTO `route_right` VALUES ('3', '4', '100');
INSERT INTO `route_right` VALUES ('1', '4', '2');
INSERT INTO `route_right` VALUES ('2', '4', '2');
INSERT INTO `route_right` VALUES ('3', '4', '0');
INSERT INTO `route_right` VALUES ('6', '5', '100');
INSERT INTO `route_right` VALUES ('7', '5', '100');
INSERT INTO `route_right` VALUES ('8', '5', '100');
INSERT INTO `route_right` VALUES ('6', '5', '2');
INSERT INTO `route_right` VALUES ('7', '5', '2');
INSERT INTO `route_right` VALUES ('8', '5', '0');
INSERT INTO `route_right` VALUES ('20', '19', '100');
INSERT INTO `route_right` VALUES ('21', '19', '100');
INSERT INTO `route_right` VALUES ('20', '19', '2');
INSERT INTO `route_right` VALUES ('21', '19', '0');
INSERT INTO `route_right` VALUES ('10', '9', '100');
INSERT INTO `route_right` VALUES ('11', '9', '100');
INSERT INTO `route_right` VALUES ('13', '9', '100');
INSERT INTO `route_right` VALUES ('10', '9', '2');
INSERT INTO `route_right` VALUES ('11', '9', '0');
INSERT INTO `route_right` VALUES ('13', '9', '0');
INSERT INTO `route_right` VALUES ('16', '14', '100');
INSERT INTO `route_right` VALUES ('16', '14', '2');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `team_id` int(0) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '团队名称',
  `team_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '团队所属学院',
  `team_leader_student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '团队队长姓名',
  `team_leader_student_id` int(0) NULL DEFAULT NULL COMMENT '团队队长学号',
  `team_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '团队等级',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`team_id`) USING BTREE,
  UNIQUE INDEX `1q`(`team_leader_student_id`, `team_leader_student_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (30, '兔子和老鹰', '软件工程学院', '白瑶怡', 2017214363, '校级团队', '2020-09-04 21:44:29');

-- ----------------------------
-- Table structure for team_member
-- ----------------------------
DROP TABLE IF EXISTS `team_member`;
CREATE TABLE `team_member`  (
  `team_member_id` int(0) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队名称',
  `team_member_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名字',
  `student_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `team_member_major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `team_member_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `is_leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是队长',
  PRIMARY KEY (`team_member_id`) USING BTREE,
  INDEX `FK_Relationship_4`(`team_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_right
-- ----------------------------
DROP TABLE IF EXISTS `user_right`;
CREATE TABLE `user_right`  (
  `right_level` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_right_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_right
-- ----------------------------
INSERT INTO `user_right` VALUES (100, 41, '2020-08-21 09:53:50');
INSERT INTO `user_right` VALUES (2, 38, '2020-09-04 20:44:24');
INSERT INTO `user_right` VALUES (0, 39, '2020-09-04 22:23:56');

-- ----------------------------
-- Table structure for user_right_level
-- ----------------------------
DROP TABLE IF EXISTS `user_right_level`;
CREATE TABLE `user_right_level`  (
  `right_level` int(0) NOT NULL,
  `right_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`right_level`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_right_level
-- ----------------------------
INSERT INTO `user_right_level` VALUES (0, '老师');
INSERT INTO `user_right_level` VALUES (2, '学生');
INSERT INTO `user_right_level` VALUES (100, '系统高级管理员');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `university_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校内身份认证码，学号或老师工号',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phoneNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `university_code`(`university_code`) USING BTREE COMMENT '确保唯一认证不重复'
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (38, '白瑶怡', '2017214363', 'e579428e98a83cf01490d0c915b50211', '13062332215', 'gPv4', '2020-08-24 12:47:50');
INSERT INTO `users` VALUES (39, '南宫婉', '010233', 'da587c6cd18fb4253d96173c2fedcef8', '13062332215', 'gPv4', '2020-08-24 12:51:28');
INSERT INTO `users` VALUES (41, '冰风', '2017214366', 'da587c6cd18fb4253d96173c2fedcef8', '17782161741', 'gPv4', '2020-08-25 16:32:05');
INSERT INTO `users` VALUES (42, '风清扬', '2017214364', 'da587c6cd18fb4253d96173c2fedcef8', '17782161741', 'gPv4', '2020-09-04 20:42:45');

SET FOREIGN_KEY_CHECKS = 1;
