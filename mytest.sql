/*
 Navicat Premium Data Transfer

 Source Server         : 111.230.95.22
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 111.230.95.22:3306
 Source Schema         : mytest

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 25/12/2018 05:23:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
BEGIN;
INSERT INTO `t_classes` VALUES (1, 'senior class');
INSERT INTO `t_classes` VALUES (2, 'middle class');
INSERT INTO `t_classes` VALUES (3, 'primary class');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'zhangsan1', '123456', '139679097722', 1);
INSERT INTO `t_user` VALUES (2, 'zhangsan2', '123456', '139679097722', 1);
INSERT INTO `t_user` VALUES (3, 'zhangsan3', '123456', '139679097722', 1);
INSERT INTO `t_user` VALUES (4, 'zhangsan4', '123456', '139679097722', 1);
INSERT INTO `t_user` VALUES (5, 'lisi1', '123456', '139679097722', 2);
INSERT INTO `t_user` VALUES (6, 'lisi2', '123456', '139679097722', 2);
INSERT INTO `t_user` VALUES (7, 'lisi3', '123456', '139679097722', 2);
INSERT INTO `t_user` VALUES (8, 'wangwu', '123456', '139679097722', 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
