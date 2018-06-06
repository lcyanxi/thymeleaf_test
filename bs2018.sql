/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50171
Source Host           : localhost:3306
Source Database       : bs2018

Target Server Type    : MYSQL
Target Server Version : 50171
File Encoding         : 65001

Date: 2018-06-06 10:20:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `add_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `detail_address` varchar(255) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `flag` int(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('15', '4', '张三', '北京市 北京市市辖区 东城区', '北京市朝阳区银河soho', '15730870204', '2018-05-30 08:50:58', '1');
INSERT INTO `address` VALUES ('16', '4', '王刚', '重庆市 重庆市市辖区 万州区', '重庆市万州区岭南路68号', '13525748779', '2018-05-30 16:52:02', '1');
INSERT INTO `address` VALUES ('17', '4', '李四', '吉林省 长春市 南关区', '吉林省长春市南关区88号', '15730870204', '2018-06-05 10:29:14', '1');
INSERT INTO `address` VALUES ('18', '10', '特朗普', '北京市 北京市市辖区 东城区', '北京市东城区朝阳soho68号', '13131340204', '2018-06-06 08:42:42', '1');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('46', '4', '30', '2', '1034', '2018-06-03 10:57:36', '1');
INSERT INTO `cart` VALUES ('47', '4', '28', '1', '549', '2018-06-05 10:27:04', '1');
INSERT INTO `cart` VALUES ('49', '10', '26', '2', '1100', '2018-06-06 08:41:12', '1');
INSERT INTO `cart` VALUES ('50', '10', '27', '3', '1668', '2018-06-06 08:41:33', '1');

-- ----------------------------
-- Table structure for order_detail_info
-- ----------------------------
DROP TABLE IF EXISTS `order_detail_info`;
CREATE TABLE `order_detail_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail_info
-- ----------------------------
INSERT INTO `order_detail_info` VALUES ('181', '20189974', '25', null, null, '2');
INSERT INTO `order_detail_info` VALUES ('182', '20189974', '30', null, null, '2');
INSERT INTO `order_detail_info` VALUES ('183', '20186068', '25', null, null, '2');
INSERT INTO `order_detail_info` VALUES ('184', '20186068', '30', null, null, '2');
INSERT INTO `order_detail_info` VALUES ('185', '20186068', '28', null, null, '1');
INSERT INTO `order_detail_info` VALUES ('186', '20183392', '26', null, null, '2');
INSERT INTO `order_detail_info` VALUES ('187', '20183392', '27', null, null, '3');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `oid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `pay_mak` int(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('20183392', '10', '18', '2018-06-06 08:42:51', '2768', '1', '1');
INSERT INTO `order_info` VALUES ('20186068', '4', '15', '2018-06-05 14:37:06', '2765', '1', '1');
INSERT INTO `order_info` VALUES ('20189974', '4', '17', '2018-06-05 10:29:31', '2216', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

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
INSERT INTO `product` VALUES ('42', '豆果4', '989', 'pink', 'https://localhost:8443/page/images/152819048309389994196_src.png', '1', '2018-06-05 17:21:23', '10寸');
INSERT INTO `product` VALUES ('45', 'aa', '587', 'orange', 'https://localhost:8443/page/images/15282459664155473377_src.png', '1', '2018-06-06 08:46:06', '7寸');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '李常', 'lichang', 'ddf7d0e8fe8f368ff69dd7775c50325e', null, 'man', '15730870204', '2757710657@qq.com', '2018-05-23 10:59:33', 'user', null, '/img/avatar.jpg');
INSERT INTO `user` VALUES ('8', '张三', '张三', 'ddf7d0e8fe8f368ff69dd7775c50325e', null, 'man', '15110148779', '845892601@qq.com', '2018-05-23 12:15:50', 'admin', null, '/img/avatar.jpg');
INSERT INTO `user` VALUES ('10', '特朗普', '特朗普', 'ddf7d0e8fe8f368ff69dd7775c50325e', null, 'man', '13131340204', '845892601@qq.com', '2018-06-06 08:39:22', 'user', null, '/img/avatar.jpg');
