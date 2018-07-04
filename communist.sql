/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : communist

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/06/2018 11:47:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person_data
-- ----------------------------
DROP TABLE IF EXISTS `person_data`;
CREATE TABLE `person_data`  (
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '每个党员唯一标识',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `photo` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个人照片',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0为男性，1为女性',
  `birthday` date NOT NULL COMMENT '出生年月日',
  `nation` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '民族',
  `native_place` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `marry_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '婚姻状况（0为未婚，1为已婚，2为离婚，3为丧偶）',
  `time_for_join_communist_party` date NOT NULL COMMENT '入党时间',
  `time_for_become_full` date NOT NULL COMMENT '转正时间',
  `time_for_working` date NOT NULL COMMENT '参加工作时间',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
  `where_before_join_communist_party` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入党时所在支部',
  `introducer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入党介绍人',
  `time_for_join_this` date NOT NULL COMMENT '转入当前支部日期',
  `name_before_join` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '转出党支部名称',
  `now_incumbent_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现任党内职务',
  `academic_degree` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历学位',
  `graduation` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '毕业院校系及专业',
  `current_career` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '当前职业',
  `present_working_units_and_duties` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现工作单位及职务',
  `registered_permanent_residence` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '户籍所在地',
  `family_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '家庭住址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `qq` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `wechat` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uk_IDcard`(`id_card`) USING BTREE,
  INDEX `uk_qq`(`qq`) USING BTREE,
  INDEX `uk_wechat`(`wechat`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person_data
-- ----------------------------
INSERT INTO `person_data` VALUES ('1', '丘武', 'http://...', '0', '1997-12-30', '汉族', '广西陆川', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199712300014', '......', '丘大武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '....', '....', '2018-06-24 00:00:00', '2018-06-24 00:00:00');
INSERT INTO `person_data` VALUES ('10', '张三', 'http://...', '0', '1997-12-30', '汉族', '云南', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300018', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '6', '6', '2018-06-24 00:00:00', '2018-06-26 17:19:48');
INSERT INTO `person_data` VALUES ('12', '张三', 'http://...', '0', '1997-12-30', '汉族', '云南', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300018', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '6', '6', '2018-06-24 17:19:48', '2018-06-26 17:19:48');
INSERT INTO `person_data` VALUES ('2', '胖子', 'http://...', '0', '1997-12-30', '壮族', '云南曲靖', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199712300016', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '2', '2', '2018-06-24 22:41:00', '2018-06-26 19:53:28');
INSERT INTO `person_data` VALUES ('3', '狗州', 'http://...', '0', '1997-12-30', '汉族', '广西贵港', '1', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300014', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '3', '3', '2018-06-24 22:41:00', '2018-06-26 11:21:20');
INSERT INTO `person_data` VALUES ('4', '狗吴超', 'http://...', '0', '1997-12-30', '汉族', '云南', '1', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300016', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '4', '4', '2018-06-24 22:41:00', '2018-06-26 11:21:23');
INSERT INTO `person_data` VALUES ('5', '狗比龚华健', 'http://...', '0', '1997-12-30', '汉族', '湖北', '1', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300017', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '5', '5', '2018-06-24 22:41:00', '2018-06-26 11:21:26');
INSERT INTO `person_data` VALUES ('6', '狗黄磊', 'http://...', '0', '1997-12-30', '汉族', '云南', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300018', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '6', '6', '2018-06-24 22:41:00', '2018-06-26 12:59:28');
INSERT INTO `person_data` VALUES ('7', '狗', 'http://...', '0', '2018-06-26', '汉族', '昆明', '0', '2018-06-26', '2018-06-26', '2018-06-26', '452527199712300001', '...', '狗州', '2018-06-26', '...', '...', '本科', '云大软院', '学生', '...', '...', '...', '...', '...', '...', '2018-06-26 13:02:13', '2018-06-26 19:53:50');
INSERT INTO `person_data` VALUES ('8', '小狗', 'http://...', '0', '1997-12-30', '汉族', '昆明', '0', '2018-06-26', '2018-06-26', '2018-06-26', '452527199712300001', '...', '狗州', '2018-06-26', '...', '...', '本科', '云大软院', '学生', '...', '...', '...', '...', '...', '...', '2018-06-26 13:13:21', '2018-06-26 19:53:52');
INSERT INTO `person_data` VALUES ('9', '张三', 'http://...', '0', '1997-12-30', '汉族', '云南', '0', '2018-06-24', '2018-06-24', '2018-06-24', '452527199812300018', '......', '丘武', '2018-06-24', '.....', '.....', '本科', '云大软院', '学生', '....', '....', '....', '....', '6', '6', '2018-06-24 00:00:00', '2018-06-26 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
