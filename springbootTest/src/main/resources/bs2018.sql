/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : bs2018

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-05-23 17:32:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `price` double(10,0) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `flag` int(255) DEFAULT NULL,
  `statdate` datetime DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('24', '商品1', '56', 'brown1', '/page/images/m1.png', null, '2018-05-23 14:50:54', '3寸');
INSERT INTO `product` VALUES ('25', '商品2', '591', 'brown2', '/page/images/m2.png', null, '2018-05-23 14:50:54', '4寸');
INSERT INTO `product` VALUES ('26', '商品3', '550', 'brown3', '/page/images/m3.png', null, '2018-05-23 14:50:54', '5寸');
INSERT INTO `product` VALUES ('27', '商品4', '556', 'brown4', '/page/images/m4.png', null, '2018-05-23 14:50:54', '6寸');
INSERT INTO `product` VALUES ('28', '商品5', '549', 'brown5', '/page/images/m5.png', null, '2018-05-23 14:50:54', '7寸');
INSERT INTO `product` VALUES ('29', '商品6', '510', 'brown6', '/page/images/m6.png', null, '2018-05-23 14:50:54', '8寸');
INSERT INTO `product` VALUES ('30', '商品7', '517', 'brown7', '/page/images/m7.png', null, '2018-05-23 14:50:54', '9寸');
INSERT INTO `product` VALUES ('31', '商品8', '542', 'brown8', '/page/images/m8.png', null, '2018-05-23 14:50:54', '10寸');
INSERT INTO `product` VALUES ('32', '商品9', '546', 'brown9', '/page/images/m9.png', null, '2018-05-23 14:50:54', '11寸');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('19', '0', '用户管理', '0', '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('20', '0', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('21', '0', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('5', '0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('6', '0', 'VIP会员', 'vip');
INSERT INTO `sys_role` VALUES ('7', '1', 'test', 'test');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `pid` (`pid`),
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`rid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `sys_permission` (`pid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('2', '5', '19');
INSERT INTO `sys_role_permission` VALUES ('3', '6', '20');
INSERT INTO `sys_role_permission` VALUES ('4', '7', '21');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `rid` (`rid`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`) ON DELETE SET NULL ON UPDATE NO ACTION,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`rid`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '6', '5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `registertime` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '李常', 'lichang', 'ddf7d0e8fe8f368ff69dd7775c50325e', null, 'man', '15730870204', '845892601', '2018-05-23 10:59:33', 'user', null, '/img/avatar.jpg');
INSERT INTO `user` VALUES ('8', '张三', '张三', 'ddf7d0e8fe8f368ff69dd7775c50325e', null, 'man', '15110148779', '845892601@qq.com', '2018-05-23 12:15:50', 'user', null, '/img/avatar.jpg');
INSERT INTO `user` VALUES ('9', '', '', '2fb1c5cf58867b5bbc9a1b145a86f3a0', null, 'man', '', '', '2018-05-23 12:19:34', 'user', null, '/img/avatar.jpg');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('6', 'admin', '管理员', 'b427273f16677088bdeb2a25c6bccef2', '2ed5638b50433ffef5642fe6008ead29', '0', null, null, null, '0000-00-00 00:00:00', null);
INSERT INTO `user_info` VALUES ('9', 'lichang', 'lichang', '222222222222222', '222222222', null, null, null, null, '2018-05-14 00:00:00', '15730870204');
