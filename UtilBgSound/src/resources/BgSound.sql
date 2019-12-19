/*
SQLyog Community
MySQL - 8.0.18 : Database - bgsound
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bgsound` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bgsound`;

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `ClientID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `JMBG` varchar(13) NOT NULL,
  `Phone` varchar(30) NOT NULL,
  PRIMARY KEY (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`ClientID`,`Name`,`Surname`,`JMBG`,`Phone`) values 
(2,'Milos','Mutavdzic','1231231231231','Mutavdzic'),
(3,'Slavica','Mutavdzic','1231231235411','Mutavdzic'),
(4,'Milica','Masal','1911997710089','Masala'),
(5,'Nesa','Jovanovic','1251515123123','asdfasdf'),
(7,'Velja','Veljkovic','123123123123','Veljkovica'),
(8,'Marko','Markovic','1243543252313','2345235235a'),
(15,'Katarina','Miric','234234234234','23542352345');

/*Table structure for table `copy` */

DROP TABLE IF EXISTS `copy`;

CREATE TABLE `copy` (
  `EquipmentID` bigint(20) unsigned NOT NULL,
  `CopyID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Available` tinyint(1) NOT NULL,
  `Working` tinyint(1) NOT NULL,
  `Defect` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`EquipmentID`,`CopyID`),
  KEY `CopyID` (`CopyID`),
  CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`EquipmentID`) REFERENCES `equipment` (`EquipmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

/*Data for the table `copy` */

insert  into `copy`(`EquipmentID`,`CopyID`,`Available`,`Working`,`Defect`) values 
(64,106,1,0,'ad'),
(64,113,1,1,''),
(65,107,1,1,NULL),
(65,108,1,1,NULL),
(65,109,1,1,NULL),
(65,110,1,1,''),
(65,111,1,1,'');

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `EquipmentID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Connection` varchar(30) DEFAULT NULL,
  `Specification` varchar(300) NOT NULL,
  PRIMARY KEY (`EquipmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `equipment` */

insert  into `equipment`(`EquipmentID`,`Name`,`Connection`,`Specification`) values 
(64,'d','d','d'),
(65,'a','a','a');

/*Table structure for table `rent` */

DROP TABLE IF EXISTS `rent`;

CREATE TABLE `rent` (
  `RentID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ClientID` bigint(20) unsigned NOT NULL,
  `EquipmentID` bigint(20) unsigned NOT NULL,
  `CopyID` bigint(20) unsigned NOT NULL,
  `DateFrom` date NOT NULL,
  `DateTo` date DEFAULT NULL,
  `WorkerID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`RentID`),
  KEY `rent_ibfk_1` (`ClientID`),
  KEY `rent_ibfk_2` (`EquipmentID`,`CopyID`),
  KEY `rent_ibfk_3` (`WorkerID`),
  CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`),
  CONSTRAINT `rent_ibfk_2` FOREIGN KEY (`EquipmentID`, `CopyID`) REFERENCES `copy` (`EquipmentID`, `CopyID`),
  CONSTRAINT `rent_ibfk_3` FOREIGN KEY (`WorkerID`) REFERENCES `worker` (`WorkerID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `rent` */

/*Table structure for table `worker` */

DROP TABLE IF EXISTS `worker`;

CREATE TABLE `worker` (
  `WorkerID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `JMBG` varchar(13) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`WorkerID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `worker` */

insert  into `worker`(`WorkerID`,`Name`,`Surname`,`JMBG`,`Username`,`Password`) values 
(1,'Milos','Mutavdzic','0408997710052','mutavdzicmilos','12bf049c116d22e7d9e6e78824d994f4eac8de6e1bfbc0eef5cd16fbf79c7837d52faefb123ba19aa64c3f3047afd9a1192a868cd598c71f4925f5a8e6dbdd99'),
(2,'Stefan','Mutavdzic','0508995710029','mutavdzicstefan','bed4efa1d4fdbd954bd3705d6a2a78270ec9a52ecfbfb010c61862af5c76af1761ffeb1aef6aca1bf5d02b3781aa854fabd2b69c790de74e17ecfec3cb6ac4bf'),
(3,'Dusan','Savic','-','savicdusan','a0198f69d510a15c6ffa1c2fdf6d7f47c52cfdc0cd984284088e49f5d26a32cf076e7ae6c82a9264fff3998a5a9632618b64d3c7eecb63b0ebda52fcbe681b68');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
