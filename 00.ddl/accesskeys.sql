/*
 Navicat Premium Data Transfer

 Source Server         : 172.24.5.242
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 172.24.5.242:3306
 Source Schema         : mysqlapi

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 17/10/2019 17:47:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accesskeys
-- ----------------------------
DROP TABLE IF EXISTS `accesskeys`;
CREATE TABLE `accesskeys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accesskey` varchar(255) DEFAULT NULL,
  `securitykey` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accesskeys
-- ----------------------------
BEGIN;
INSERT INTO `accesskeys` VALUES (1, 'asdf', 'asdf');
INSERT INTO `accesskeys` VALUES (2, 'aaa', 'asdf');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
