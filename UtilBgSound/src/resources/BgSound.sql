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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`ClientID`,`Name`,`Surname`,`JMBG`,`Phone`) values 
(2,'milos','Mutavdzic','1231231231231','123123123'),
(3,'Slavica','Mutavdzic','1231231235411','Mutavdzic'),
(4,'Milica','Masala','1911997710089','Masal'),
(5,'Nesa','Jovanovic','1251515123123','Cigan'),
(7,'Velja','Veljkovic','123123123123','Veljkovica'),
(8,'Marko','Markovic','124354325','2345235235'),
(9,'Petar','Markovic','124354325','2345235235'),
(10,'Petar','Petrovicsw','242351234','Petrovic');

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
  CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`EquipmentID`) REFERENCES `equipment` (`EquipmentID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `copy` */

insert  into `copy`(`EquipmentID`,`CopyID`,`Available`,`Working`,`Defect`) values 
(1,6,1,2,'needs reparation'),
(2,1,0,1,'false'),
(3,7,1,1,''),
(25,33,1,1,NULL),
(25,34,1,1,NULL),
(26,35,1,1,''),
(26,36,1,1,NULL),
(26,37,1,1,NULL);

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `EquipmentID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Connection` varchar(30) DEFAULT NULL,
  `Specification` varchar(300) NOT NULL,
  PRIMARY KEY (`EquipmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `equipment` */

insert  into `equipment`(`EquipmentID`,`Name`,`Connection`,`Specification`) values 
(1,'Das sub','Speakon','400w'),
(2,'Beam 7r','DMX','Uses for large areas.'),
(3,'MARTIN WIZZARD','DMX/MUSIC AUTOMATIC','250W'),
(4,'MARTIN WIZZARD','DMX/MUSIC AUTOMATIC','250W'),
(5,'Das bass','Speakon','500w'),
(6,'Kit 1000','DMX-w/o mass','1000w three systems '),
(7,'JBL Go','Bluetooth','5 w Speaker'),
(8,'Das bass','speakon','500W'),
(9,'Speakon 30m','speakon speakon','30m cable speakon speakon'),
(25,'xfgn','gchm','sdfh'),
(26,'wrg','sdgf','sdg'),
(27,'cable','sdf','123'),
(28,'cable','sdf','123'),
(29,'cable','sdf','123'),
(30,'cable','sdf','123'),
(31,'cable','sdf','123'),
(32,'cable','sdf','123');

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
  KEY `rent_ibfk_2` (`EquipmentID`,`CopyID`),
  KEY `rent_ibfk_3` (`WorkerID`),
  KEY `rent_ibfk_1` (`ClientID`),
  CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `rent_ibfk_2` FOREIGN KEY (`EquipmentID`, `CopyID`) REFERENCES `copy` (`EquipmentID`, `CopyID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rent_ibfk_3` FOREIGN KEY (`WorkerID`) REFERENCES `worker` (`WorkerID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `rent` */

insert  into `rent`(`RentID`,`ClientID`,`EquipmentID`,`CopyID`,`DateFrom`,`DateTo`,`WorkerID`) values 
(3,2,2,1,'2019-11-11',NULL,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `worker` */

insert  into `worker`(`WorkerID`,`Name`,`Surname`,`JMBG`,`Username`,`Password`) values 
(1,'Milos','Mutavdzic','0408997710052','mutavdzicmilos','bed4efa1d4fdbd954bd3705d6a2a78270ec9a52ecfbfb010c61862af5c76af1761ffeb1aef6aca1bf5d02b3781aa854fabd2b69c790de74e17ecfec3cb6ac4bf'),
(3,'Stefan','Mutavdzic','0508995710029','mutavdzicstefan','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
