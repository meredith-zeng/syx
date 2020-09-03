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

 Date: 03/09/2020 20:42:09
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
  `certification_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  `certification_file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核书存储路径',
  PRIMARY KEY (`certification_id`) USING BTREE,
  UNIQUE INDEX `团队唯一申请`(`team_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certification
-- ----------------------------
INSERT INTO `certification` VALUES (5, 1, '123', '2020-09-03 17:29:22', '2020-09-03 17:29:26', '校级团队', '审核通过', '2020-08-19 11:11:53', '2020-09-03 20:01:01', '12321');
INSERT INTO `certification` VALUES (6, 2, '十七万四千五', '2020-09-03 17:29:16', '2020-09-03 17:29:19', '无', '审核不通过', '2020-08-25 14:37:35', '2020-09-03 19:36:41', '1431');
INSERT INTO `certification` VALUES (7, 3, '321', '2020-09-03 17:29:11', '2020-09-03 17:29:13', '无', '审核不通过', '2020-08-25 14:37:53', '2020-09-03 19:36:39', '/file/c9a0932952b54968ba8cd7211b20f7c6.pdf');
INSERT INTO `certification` VALUES (8, 4, '322威威', '2020-09-03 17:27:47', '2020-09-03 17:27:49', '', '待审核', '2020-08-25 14:38:12', '2020-09-03 19:37:10', '213312312');
INSERT INTO `certification` VALUES (9, 5, '432423', '2020-09-26 00:00:00', '2020-09-24 00:00:00', '无', '审核不通过', '2020-09-03 18:13:18', '2020-09-03 19:36:37', '');
INSERT INTO `certification` VALUES (10, NULL, NULL, '2020-09-12 00:00:00', '2020-09-24 00:00:00', NULL, '未审核', '2020-09-03 19:59:03', '2020-09-03 19:59:03', '/file/cc462d7650af4d70b454629e294b9479.pdf');

-- ----------------------------
-- Table structure for expense
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense`  (
  `expense_code` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `expense_team_id` int(0) NULL DEFAULT NULL COMMENT '报销团队的团队id',
  `expense_time` date NULL DEFAULT NULL COMMENT '报销的时间',
  `expense_money` double NULL DEFAULT NULL COMMENT '报销金额',
  `expense_event` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销原由',
  `expense_agent` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销经办人',
  `expense_pic` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销单据图片存储地址',
  `expense_certifictedCondition` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销审核状态',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  PRIMARY KEY (`expense_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (5, 2, '尽诛宵小天策义', '2020-08-29 10:10:46', '2020-08-31');
INSERT INTO `log` VALUES (7, 4, '是的呢', '2020-08-29 14:19:55', '2020-08-31');
INSERT INTO `log` VALUES (31, 1, '你猜', '2020-08-31 11:57:31', '2020-08-31');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES (1, '新建团队日志', '2', '/pages/log/log_new.html', '团队日志', 4);
INSERT INTO `route` VALUES (2, '查询本团队日志', '2', '/pages/log/log_myTeamLog.html', '团队日志', 4);
INSERT INTO `route` VALUES (3, '查询所有日志', '2', '/pages/log/log_queryAllLog.html', '团队日志', 4);
INSERT INTO `route` VALUES (4, '团队日志模块', '1', '/pages/log', '团队日志', -1);
INSERT INTO `route` VALUES (5, '团队活动模块', '1', '/pages/teamApply', '团队活动', -1);
INSERT INTO `route` VALUES (6, '团队活动申请', '2', '/pages/teamApply/Teamapply.html', '团队活动', 5);
INSERT INTO `route` VALUES (7, '团队活动个人查询', '2', '/pages/teamApply/QueryMyApply.html', '团队活动', 5);
INSERT INTO `route` VALUES (8, '团队活动全部查询', '2', '/pages/teamApply/QueryAllApply.html', '团队活动', 5);

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
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`team_id`) USING BTREE,
  UNIQUE INDEX `唯一标识`(`team_name`, `team_leader_student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, '阿西吧', '1', NULL, NULL, NULL, '2020-08-19 11:11:53');
INSERT INTO `team` VALUES (2, '组织部门', '重庆市', NULL, NULL, NULL, '2020-08-25 14:37:35');
INSERT INTO `team` VALUES (3, '党史局', '北京市', NULL, 10233, NULL, '2020-08-25 14:37:53');
INSERT INTO `team` VALUES (4, '芜湖', 'dqwubui', NULL, NULL, NULL, '2020-08-25 14:38:12');

-- ----------------------------
-- Table structure for team_member
-- ----------------------------
DROP TABLE IF EXISTS `team_member`;
CREATE TABLE `team_member`  (
  `team_member_id` int(0) NOT NULL AUTO_INCREMENT,
  `team_name` int(0) NULL DEFAULT NULL COMMENT '团队名称',
  `team_member_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名字',
  `student_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `team_member_major` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `team_member_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `is_leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是队长',
  PRIMARY KEY (`team_member_id`) USING BTREE,
  INDEX `FK_Relationship_4`(`team_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_member
-- ----------------------------
INSERT INTO `team_member` VALUES (1, 1, '1', NULL, NULL, NULL, NULL);
INSERT INTO `team_member` VALUES (2, NULL, '134234132', '2020-08-25 14:39:01', 'dab', '审核通过', NULL);
INSERT INTO `team_member` VALUES (3, NULL, '2134234', '2020-08-25 16:03:24', 'xxx', '审核通过', NULL);
INSERT INTO `team_member` VALUES (4, NULL, '2134', '2020-08-25 16:03:59', NULL, NULL, NULL);
INSERT INTO `team_member` VALUES (5, NULL, '2134', '2020-08-25 16:04:00', NULL, NULL, NULL);
INSERT INTO `team_member` VALUES (6, NULL, '2134', '2020-08-25 16:04:04', NULL, NULL, NULL);

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
INSERT INTO `user_right` VALUES (2, 39, '2020-09-02 15:54:45');
INSERT INTO `user_right` VALUES (2, 38, '2020-09-02 16:04:06');

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
INSERT INTO `users` VALUES (38, '白瑶怡', '2017214363', 'b63789cdcc1063fec5bf369bc388f9df', '17782161746', '2&#c', '2020-08-24 12:47:50');
INSERT INTO `users` VALUES (39, '南宫婉', '010233', 'da587c6cd18fb4253d96173c2fedcef8', '13062332215', 'gPv4', '2020-08-24 12:51:28');
INSERT INTO `users` VALUES (41, '南宫婉', '2017214366', '356b1bf04d2c888337fc5c22e2399dd1', '17782161748', 'RgSg', '2020-08-25 16:32:05');

SET FOREIGN_KEY_CHECKS = 1;
