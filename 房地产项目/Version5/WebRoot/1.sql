/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.22-community-nt : Database - tsur_database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tsur_database` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tsur_database`;

/*Table structure for table `t_card` */

DROP TABLE IF EXISTS `t_card`;

CREATE TABLE `t_card` (
  `id` int(11) NOT NULL auto_increment COMMENT '证件种类表id',
  `cardname` varchar(200) default NULL COMMENT '证件名称',
  `remark` varchar(500) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_card` */

insert  into `t_card`(`id`,`cardname`,`remark`) values (2,'201|居民身份证',NULL),(3,'202|军官证',NULL),(4,'203|武警警官证',NULL),(5,'204|士兵证',NULL),(6,'210|港澳居民来往内地通行证',NULL),(7,'212|中华人民共和国往来港澳通行证',NULL),(8,'227|中国护照',NULL),(9,'101|组织机构代码证',NULL),(10,'199|其他单位证件',NULL),(11,'205|军队离退休干部证',NULL),(12,'206|残疾人证',NULL),(13,'207|残疾军人证（1-8级）',NULL),(14,'208|外国护照',NULL),(15,'213|台湾居民来往大陆通行证',NULL),(16,'214|大陆居民往来台湾通行证',NULL),(17,'215|外国人居留证',NULL),(18,'216|外交官证',NULL),(19,'217|领事馆证',NULL),(20,'218|海员证',NULL),(21,'219|香港身份证',NULL),(22,'220|台湾身份证',NULL),(23,'221|澳门身份证',NULL),(24,'222|外国人身份证件',NULL),(25,'223|高校毕业生自主创业证',NULL),(26,'224|就业失业登记证',NULL),(27,'225|退休证',NULL),(28,'226|离休证',NULL),(29,'228|城镇退役士兵自谋职业证',NULL),(30,'233|外国人永久居留证',NULL),(31,'299|其他个人证件',NULL),(32,'201|居民身份证',NULL),(33,'202|军官证',NULL),(34,'203|武警警官证',NULL),(35,'204|士兵证',NULL),(36,'210|港澳居民来往内地通行证',NULL),(37,'212|中华人民共和国往来港澳通行证',NULL),(38,'227|中国护照',NULL),(39,'101|组织机构代码证',NULL),(40,'199|其他单位证件',NULL),(41,'205|军队离退休干部证',NULL),(42,'206|残疾人证',NULL),(43,'207|残疾军人证（1-8级）',NULL),(44,'208|外国护照',NULL),(45,'213|台湾居民来往大陆通行证',NULL),(46,'214|大陆居民往来台湾通行证',NULL),(47,'215|外国人居留证',NULL),(48,'216|外交官证',NULL),(49,'217|领事馆证',NULL),(50,'218|海员证',NULL),(51,'219|香港身份证',NULL),(52,'220|台湾身份证',NULL),(53,'221|澳门身份证',NULL),(54,'222|外国人身份证件',NULL),(55,'223|高校毕业生自主创业证',NULL),(56,'224|就业失业登记证',NULL),(57,'225|退休证',NULL),(58,'226|离休证',NULL),(59,'228|城镇退役士兵自谋职业证',NULL),(60,'233|外国人永久居留证',NULL),(61,'299|其他个人证件',NULL);

/*Table structure for table `t_house` */

DROP TABLE IF EXISTS `t_house`;

CREATE TABLE `t_house` (
  `id` int(11) NOT NULL auto_increment COMMENT '房屋信息表id',
  `data_2` int(11) default NULL COMMENT '2)楼宇ID：外键',
  `data_3` varchar(50) default NULL COMMENT '房产使用类型：',
  `data_4` varchar(50) default NULL COMMENT '楼层: 数字 （非空）',
  `data_5` varchar(50) default NULL COMMENT '5)房号：字符串存储的数字（非空）',
  `data_6` varchar(100) default NULL COMMENT '6)房源编号：',
  `data_7` varchar(100) default NULL COMMENT '7)产权证书号：UNIQUE 约束',
  `data_8` varchar(100) default NULL COMMENT '8)土地税源编号：',
  `data_9` varchar(50) default NULL COMMENT '9)*房产总原值（元）：',
  `data_10` varchar(50) default NULL COMMENT '10)*房屋面积（平方米）：',
  `data_11` varchar(50) default NULL COMMENT '11)*权属有效期起：日期',
  `data_12` varchar(50) default NULL COMMENT '12)房产证书持有人识别号：',
  `data_13` varchar(50) default NULL COMMENT '房产证书持有人名称：',
  `data_14` int(11) default NULL COMMENT '14)房产证书持有人证件类型ID：外键',
  `data_15` varchar(50) default NULL COMMENT '15)房产证书持有人证件号码：',
  `data_16` varchar(50) default NULL COMMENT '是否有效：如果房产证书持有人变更，置为无效；',
  `data_18` varchar(500) default NULL COMMENT '18 房屋所在地址',
  `data_19` varchar(50) default NULL COMMENT '19 所属税务机关',
  `data_20` varchar(50) default NULL COMMENT '20 行政区划',
  `data_21` varchar(500) default NULL COMMENT '21 房屋所处街乡',
  `data_17` varchar(50) default NULL COMMENT '17)*权属有效期止：日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_house` */

insert  into `t_house`(`id`,`data_2`,`data_3`,`data_4`,`data_5`,`data_6`,`data_7`,`data_8`,`data_9`,`data_10`,`data_11`,`data_12`,`data_13`,`data_14`,`data_15`,`data_16`,`data_18`,`data_19`,`data_20`,`data_21`,`data_17`) values (1,2,'1','5','MN5648912GH','房源编号54895156','X4521546556','X4521546556','1','1','2015-09-01','1','2',18,'1','是','1','1','2','2','2015-09-07');

/*Table structure for table `t_lyjcxx` */

DROP TABLE IF EXISTS `t_lyjcxx`;

CREATE TABLE `t_lyjcxx` (
  `id` int(11) NOT NULL auto_increment COMMENT '楼宇基础信息id',
  `lymc` varchar(500) default NULL COMMENT '楼宇名称',
  `lyzts` varchar(500) default NULL COMMENT '楼宇总套数',
  `lydz` varchar(500) default NULL COMMENT '楼宇坐落地址',
  `swjg_id` int(11) default NULL COMMENT '所属税务机关ID',
  `xzqh` varchar(500) default NULL COMMENT '行政区划',
  `fwscjx` varchar(500) default NULL COMMENT '房屋所处街乡',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_lyjcxx` */

insert  into `t_lyjcxx`(`id`,`lymc`,`lyzts`,`lydz`,`swjg_id`,`xzqh`,`fwscjx`) values (2,'一号楼宇','10','北京市朝阳区',1,'2','北京市朝阳区街乡');

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL auto_increment COMMENT '菜单表id',
  `menuname` varchar(500) default NULL COMMENT '菜单名称',
  `menuurl` varchar(500) default NULL COMMENT '菜单地址',
  `isfather` int(11) default NULL COMMENT '1:1级菜单2:2级菜单',
  `pid` int(11) default NULL COMMENT '父菜单',
  `remark` varchar(500) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`menuname`,`menuurl`,`isfather`,`pid`,`remark`) values (1,'系统管理','',1,0,NULL),(2,'用户信息管理','/user/userList',2,1,NULL),(3,'角色信息管理','/role/roleList',2,1,NULL),(4,'菜单信息管理','/menu/menuList',2,1,NULL),(5,'统计查询',NULL,1,0,NULL),(6,'楼宇查询',NULL,2,5,NULL),(7,'证件信息管理','/role/cardList',2,1,NULL),(8,'楼宇信息管理','/role/lyList',2,1,NULL),(9,'税务机关信息管理','/role/swjgList',2,1,NULL),(10,'行政区划信息管理','/role/xzqhList',2,1,NULL),(11,'房屋信息管理','/role/fwList',2,1,NULL),(12,'房屋使用(非出租)信息管理','/rental/rentalnoList',2,1,NULL);

/*Table structure for table `t_rental_no` */

DROP TABLE IF EXISTS `t_rental_no`;

CREATE TABLE `t_rental_no` (
  `id` int(11) NOT NULL auto_increment COMMENT '2.3.房产使用信息_非出租 id',
  `data_2` varchar(255) default NULL COMMENT '2)房间ID：外键',
  `data_3` varchar(255) default NULL COMMENT '3)*时间戳：更新时间',
  `data_4` varchar(255) default NULL COMMENT '4)*操作人：当前操作的系统用户',
  `data_5` varchar(255) default NULL COMMENT '5)*是否有效：	加索引	当主表“房屋基础信息”字段房产使用类型变为“承租”时，此标记为0。当“使用者名称、使用者证件号码、使用类型”发生变化时，标记位置0，并新生成复制的纪录；',
  `data_6` varchar(255) default NULL COMMENT '6)*使用者名称：	字符串',
  `data_7` int(11) default NULL COMMENT '7)*使用者证件类型ID：	外键',
  `data_8` varchar(255) default NULL COMMENT '8)使用者证件号码：	字符串',
  `data_9` varchar(255) default NULL COMMENT '*使用类型：正常自用、无租使用、承典、融资租赁、闲置；',
  `data_10` varchar(255) default NULL COMMENT '10)使用面积：',
  `data_11` varchar(255) default NULL COMMENT '11)*使用者是否征收房产税：',
  `data_12` varchar(255) default NULL COMMENT '12)*征收品目：',
  `data_13` varchar(255) default NULL COMMENT '13)*房产原值（元）		不得大于“房产总原值（元）”',
  `data_14` varchar(255) default NULL COMMENT '14)*免税原值（元）',
  `data_15` varchar(255) default NULL COMMENT '15)*应税原值（元）',
  `data_16` varchar(255) default NULL COMMENT '16)*有效期起		有条件非空约束	日期类型	加索引	不得小于“权属有效期起”',
  `data_17` varchar(255) default NULL COMMENT '17)*有效期止		有条件非空约束	日期类型	加索引',
  `data_18` varchar(255) default NULL COMMENT '18)备注：',
  `data_19` varchar(255) default NULL COMMENT '19)*房产税纳税人：',
  `data_20` int(11) default NULL COMMENT '20)*房产税纳税人证件类型：',
  `data_21` varchar(255) default NULL COMMENT '21)*房产税纳税人证件号码',
  `data_22` varchar(255) default NULL COMMENT '22)年应纳税额（元）：		=（房产原值-免税原值）*（1-30%）*0.012',
  `data_23` varchar(255) default NULL COMMENT '23)*纳税期限：',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_rental_no` */

insert  into `t_rental_no`(`id`,`data_2`,`data_3`,`data_4`,`data_5`,`data_6`,`data_7`,`data_8`,`data_9`,`data_10`,`data_11`,`data_12`,`data_13`,`data_14`,`data_15`,`data_16`,`data_17`,`data_18`,`data_19`,`data_20`,`data_21`,`data_22`,`data_23`) values (1,'1','null','null','null','1',3,'31','融资租赁','51','61','71','81','91','101','2015-09-11','2015-09-12','131','14',17,'161','171','181');

/*Table structure for table `t_rental_yes` */

DROP TABLE IF EXISTS `t_rental_yes`;

CREATE TABLE `t_rental_yes` (
  `id` int(11) NOT NULL auto_increment COMMENT '2.3.房产使用信息_非出租 id',
  `data_2` varchar(255) default NULL COMMENT '2)房间ID：外键',
  `data_3` varchar(255) default NULL COMMENT '3)*时间戳：更新时间',
  `data_4` varchar(255) default NULL COMMENT '4)*操作人：当前操作的系统用户',
  `data_5` varchar(255) default NULL COMMENT '5)*是否有效：    加索引    当主表“房屋基础信息”字段房产使用类型变为“承租”时，此标记为0。当“使用者名称、使用者证件号码、使用类型”发生变化时，标记位置0，并新生成复制的纪录；',
  `data_6` varchar(255) default NULL COMMENT '6)*使用者名称：    字符串',
  `data_7` varchar(255) default NULL COMMENT '7)*使用者证件类型ID：    外键',
  `data_8` varchar(255) default NULL COMMENT '8)使用者证件号码：    字符串',
  `data_9` varchar(255) default NULL COMMENT '9)*使用者使用类型：承租',
  `data_10` varchar(255) default NULL COMMENT '10)使用面积：',
  `data_11` varchar(255) default NULL COMMENT '11)*使用者是否征收房产税：',
  `data_12` varchar(255) default NULL COMMENT '12)出租人名称：',
  `data_13` int(11) default NULL COMMENT '13)出租人身份证件种类：',
  `data_14` varchar(255) default NULL COMMENT '14)出租人证件号码：',
  `data_15` varchar(255) default NULL COMMENT '15)出租面积',
  `data_16` varchar(255) default NULL COMMENT '16)出租人使用类型：	出租',
  `data_17` varchar(255) default NULL COMMENT '17)*出租者是否征收房产税：',
  `data_18` varchar(255) default NULL COMMENT '18)*征收品目	：	“其他房屋出租“',
  `data_19` varchar(255) default NULL COMMENT '19)*年租金收入（元）：',
  `data_20` varchar(255) default NULL COMMENT '20)*有效期起（注：出租起始时间）	有条件非空约束	日期类型	加索引',
  `data_21` varchar(255) default NULL COMMENT '21)*有效期止（注：出租截止时间）	日期类型	加索引',
  `data_22` varchar(255) default NULL COMMENT '22)备注',
  `data_23` varchar(255) default NULL COMMENT '23)*房产税纳税人：',
  `data_24` int(11) default NULL COMMENT '24)*房产税纳税人证件类型：',
  `data_25` varchar(255) default NULL COMMENT '25)*房产税纳税人证件号码',
  `data_26` varchar(255) default NULL COMMENT '26)*年应纳税额（元）（注：出租）（注：“年应纳税额”是“年租金收入”*“征收品目”对应税率计算出来的。“个人出租住房”对应税率是0.04，“其他房屋出租”对应税率是0.12.）',
  `data_27` varchar(255) default NULL COMMENT '27)*纳税期限：',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_rental_yes` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL auto_increment COMMENT '角色表id',
  `rolename` varchar(50) NOT NULL COMMENT '角色名称',
  `remark` varchar(500) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`rolename`,`remark`) values (1,'超级管理员','无');

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `role_id` int(11) default NULL COMMENT '角色名称',
  `menu_id` int(11) default NULL COMMENT '菜单名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_menu` */

insert  into `t_role_menu`(`role_id`,`menu_id`) values (1,2),(1,3),(1,4),(1,7),(1,8),(1,9),(1,10),(1,6),(1,11),(1,12);

/*Table structure for table `t_swjg` */

DROP TABLE IF EXISTS `t_swjg`;

CREATE TABLE `t_swjg` (
  `id` int(11) NOT NULL auto_increment COMMENT '税务机关表id',
  `jgmc` varchar(500) default NULL COMMENT '机关名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_swjg` */

insert  into `t_swjg`(`id`,`jgmc`) values (1,'郑州市郑东新区地方税务局祭城路税务所'),(2,'郑州市郑东新区地方税务局龙子湖税务所'),(3,'郑州市郑东新区地方税务局如意湖税务所'),(4,'郑州市郑东新区地方税务局博学路税务所'),(5,'郑州市郑东新区地方税务局商都路税务所'),(6,'河南省中牟县地方税务局白沙税务所');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment COMMENT '用户表id',
  `loginname` varchar(50) default NULL COMMENT '用户名',
  `loginpass` varchar(50) default NULL COMMENT '密码',
  `username` varchar(50) default NULL COMMENT '姓名',
  `phone` varchar(50) default NULL COMMENT '电话',
  `email` varchar(50) default NULL COMMENT '邮箱',
  `remark` varchar(500) default NULL COMMENT '备注',
  `sex` varchar(50) default NULL COMMENT '性别',
  `role_id` int(11) default NULL COMMENT '角色id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`loginname`,`loginpass`,`username`,`phone`,`email`,`remark`,`sex`,`role_id`) values (3,'admin','1','张三1','155908878881','yugyut@qq.com1','无1','女',1);

/*Table structure for table `t_xzqh` */

DROP TABLE IF EXISTS `t_xzqh`;

CREATE TABLE `t_xzqh` (
  `id` int(11) NOT NULL auto_increment COMMENT '行政区划表id',
  `xzqhmc` varchar(200) default NULL COMMENT '行政区划名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_xzqh` */

insert  into `t_xzqh`(`id`,`xzqhmc`) values (2,' 行政区划(一)'),(3,' 行政区划(二)'),(4,' 行政区划(三)');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
