/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.58 : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel`;

/*Table structure for table `membership` */

DROP TABLE IF EXISTS `membership`;

CREATE TABLE `membership` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `membership_num` varchar(50) DEFAULT NULL COMMENT '会员编号',
  `customer_name` varchar(40) DEFAULT NULL COMMENT '会员姓名',
  `gender` varchar(2) DEFAULT '1' COMMENT '性别',
  `discount` float(2,1) DEFAULT '0.9' COMMENT '会员优惠（1~9折）',
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '手机号',
  `create_date` datetime DEFAULT NULL COMMENT '会员创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `membership` */

insert  into `membership`(`id`,`membership_num`,`customer_name`,`gender`,`discount`,`idcard`,`phone_num`,`create_date`) values (1,'8888','赵子龙','1',0.8,'411311199001015500','13512345678','2020-07-15 11:16:56'),(2,'1b7dd235-0fb2-4478-9cdc-427956b13a5d','张三','1',0.8,'411524199801243288','13223344556','2020-07-15 18:19:12'),(3,'3c1790b6-b69c-4553-a1dd-a5010f34e7cb','张飞','1',0.8,'411311199001015544','13223344556','2020-07-15 18:44:43'),(4,'59841a3e-a167-4937-8df0-e103ed6d3b0b','张三','0',0.8,'411524199801243210','13569747832','2020-07-15 18:45:54');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_num` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `total` float(10,2) DEFAULT NULL COMMENT '订单总价',
  `create_date` datetime DEFAULT NULL COMMENT '下单日期',
  `order_status` varchar(2) DEFAULT '0' COMMENT '是否已结算（0：未结算，1：已结算）',
  `room_id` bigint(20) DEFAULT NULL COMMENT '房间主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`order_num`,`total`,`create_date`,`order_status`,`room_id`) values (8,'18e226e5-4d07-4421-a722-55f7d753871e',200.00,'2020-07-14 16:07:23','0',3),(9,'764ebeb0-0212-4aec-98ac-98a3c57675d3',4.50,'2020-07-14 16:12:30','0',2),(10,'9cae4676-9d5e-47f9-8f03-f486dff76616',5.50,'2020-07-14 16:13:31','0',4),(11,'b273c178-5689-4d54-b9a7-710284ff6a4f',200.00,'2020-07-14 17:50:05','0',2),(12,'d03e94aa-44c2-4802-b8c1-e0f6a9fbc603',2.50,'2020-07-14 17:52:33','0',2),(13,'18f5ab9e-4cb2-4ff5-a50c-75e34ce362f2',5.50,'2020-07-14 17:54:17','0',3),(14,'9d9c7ba9-88eb-43a4-9490-36daa2c164e1',200.00,'2020-07-15 09:06:33','0',3);

/*Table structure for table `room_check` */

DROP TABLE IF EXISTS `room_check`;

CREATE TABLE `room_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_name` varchar(40) DEFAULT NULL COMMENT '客人姓名',
  `gender` varchar(2) DEFAULT '1' COMMENT '客人性别（1：男，0：女）',
  `is_membership` varchar(2) DEFAULT NULL COMMENT '是否是会员（1：是，0：不是）',
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '手机号',
  `deposit` float(10,2) DEFAULT NULL COMMENT '押金',
  `check_date` datetime DEFAULT NULL COMMENT '入住时间',
  `room_id` bigint(20) DEFAULT NULL COMMENT '房间主键',
  `status` varchar(2) DEFAULT '1' COMMENT '客房状态信息：1显示，0隐藏',
  `checkout_status` varchar(2) DEFAULT '0' COMMENT '退房状态0：未退房1：已退房',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `room_check` */

insert  into `room_check`(`id`,`customer_name`,`gender`,`is_membership`,`idcard`,`phone_num`,`deposit`,`check_date`,`room_id`,`status`,`checkout_status`) values (1,'赵子龙','1','0','411311199001015500','13512345678',200.00,'2020-07-08 19:28:07',1,'0','0'),(2,'张飞','1','0','411311199001015544','16812345678',200.00,'2020-07-08 19:29:32',2,'0','0'),(3,'曹操','1','1','411311199001015533','17512345678',200.00,'2020-07-08 19:32:42',3,'1','0'),(4,'科比','1','1','411311199001015522','13266773322',400.00,'2020-07-08 19:33:28',4,'1','0'),(5,'马化腾','1','1','411311199001015511','13569747832',200.00,'2020-07-09 21:27:57',5,'1','1'),(6,'马云','1','1','411311199001015566','13678423368',300.00,'2020-07-09 21:28:00',6,'1','1'),(14,'张三','1','1','411524199801243210','13569747832',200.00,'2020-07-10 00:00:00',7,'1','0');

/*Table structure for table `room_type` */

DROP TABLE IF EXISTS `room_type`;

CREATE TABLE `room_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_type` varchar(20) DEFAULT NULL COMMENT '房间类型',
  `room_price` float(10,2) DEFAULT NULL COMMENT '房间类型单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `room_type` */

insert  into `room_type`(`id`,`room_type`,`room_price`) values (1,'单人间',140.00),(2,'双人间',180.00),(3,'豪华间',280.00),(4,'总统套房',500.00);

/*Table structure for table `rooms` */

DROP TABLE IF EXISTS `rooms`;

CREATE TABLE `rooms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `room_num` varchar(10) DEFAULT NULL COMMENT '房间号',
  `room_status` varchar(2) DEFAULT '0' COMMENT '房间状态（0：空闲，1：已入住，3：待打扫）',
  `room_type_id` bigint(20) DEFAULT NULL COMMENT '房间类型主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `rooms` */

insert  into `rooms`(`id`,`room_num`,`room_status`,`room_type_id`) values (1,'8201','1',1),(2,'8202','2',1),(3,'8203','2',1),(4,'8204','2',3),(5,'8205','2',2),(6,'8206','2',2),(7,'8207','1',1),(8,'8208','0',2),(9,'8209','2',1),(10,'8210','0',1),(11,'8212','0',1),(12,'8211','0',1),(13,'8213','2',1),(14,'8214','2',1),(15,'8215','0',2),(16,'8216','0',3),(17,'8217','2',4),(18,'8218','0',1);

/*Table structure for table `sys_limit` */

DROP TABLE IF EXISTS `sys_limit`;

CREATE TABLE `sys_limit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `limit_name` varchar(40) DEFAULT NULL COMMENT '权限名',
  `url` varchar(200) DEFAULT '#' COMMENT '权限地址',
  `parent_limit_id` bigint(20) DEFAULT '0' COMMENT '权限父级（0：父级）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `sys_limit` */

insert  into `sys_limit`(`id`,`limit_name`,`url`,`parent_limit_id`) values (1,'入住管理','#',0),(2,'订单管理','#',0),(3,'会员管理','#',0),(4,'客房管理','#',0),(5,'用户管理','#',0),(6,'客人意见','#',0),(7,'入住信息查询','getInfo.do',1),(8,'入住信息添加','checkInfoAdd.do',1),(9,'消费记录','#',1),(10,'结账退房','checkout.do',1),(11,'订单信息','getorders.do',2),(12,'添加订单','addorders.do',2),(13,'会员信息查询','getmembership.do',3),(14,'会员信息管理','getMembershipInfoByid.do',3),(15,'添加会员','addmembership.do',3),(16,'客房信息查询','getHouseInfo.do',4),(17,'客房信息管理','HouseManage.do',4),(18,'添加客房','addHouse.do',4),(19,'用户信息查询','getSysUserInfo.do',5),(20,'用户信息管理','#',5),(21,'添加用户','addUserLimit.do',5),(22,'意见反馈','#',6);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(40) DEFAULT NULL COMMENT '账号',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `status` varchar(2) DEFAULT '1' COMMENT '0禁用1启用',
  `is_admin` varchar(2) DEFAULT NULL COMMENT '1超级管理员0普通管理员',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`status`,`is_admin`,`create_date`) values (1,'admin','5f1d7a84db00d2fce00b31a7fc73224f','1','1','2020-07-15 14:54:32'),(12,'taozi','5f1d7a84db00d2fce00b31a7fc73224f','0','0','2020-07-19 06:53:21'),(13,'heitao','5f1d7a84db00d2fce00b31a7fc73224f','1','0','2020-07-19 08:18:33');

/*Table structure for table `user_limit` */

DROP TABLE IF EXISTS `user_limit`;

CREATE TABLE `user_limit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sys_id` bigint(20) DEFAULT NULL COMMENT '系统用户主键',
  `limit_id` bigint(20) DEFAULT NULL COMMENT '系统权限主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Data for the table `user_limit` */

insert  into `user_limit`(`id`,`sys_id`,`limit_id`) values (1,1,1),(2,1,7),(3,1,8),(4,1,9),(5,1,10),(6,1,2),(7,1,11),(8,1,12),(9,1,3),(10,1,13),(11,1,14),(12,1,15),(13,1,4),(14,1,16),(15,1,17),(16,1,18),(17,1,5),(18,1,19),(19,1,20),(20,1,21),(21,1,6),(58,12,1),(59,12,7),(60,12,8),(61,12,9),(62,12,10),(63,13,1),(64,13,4),(65,13,7),(66,13,8),(67,13,9),(68,13,10),(69,13,16),(70,13,17),(71,13,18);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
