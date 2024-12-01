/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - nastavni_programi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nastavni_programi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `nastavni_programi`;

/*Table structure for table `kurs` */

DROP TABLE IF EXISTS `kurs`;

CREATE TABLE `kurs` (
  `RBrKursa` bigint(20) NOT NULL,
  `brojESPB` bigint(10) NOT NULL,
  `cenaESPB` decimal(10,2) NOT NULL,
  `program` bigint(20) unsigned NOT NULL,
  `prijavljivanje` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`RBrKursa`,`prijavljivanje`),
  KEY `program` (`program`),
  CONSTRAINT `kurs_ibfk_1` FOREIGN KEY (`program`) REFERENCES `programi` (`programID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kurs` */

insert  into `kurs`(`RBrKursa`,`brojESPB`,`cenaESPB`,`program`,`prijavljivanje`) values 
(1,5,200.00,1,1),
(1,5,500.00,4,25),
(1,5,500.00,4,26),
(1,6,1250.00,1,27),
(1,5,1200.00,1,28),
(1,7,1250.00,4,29),
(1,5,1000.00,1,30),
(2,4,250.00,1,2),
(2,5,1300.00,1,4),
(2,5,500.00,4,25),
(2,5,500.00,4,26),
(2,7,1200.00,6,28),
(2,5,1500.00,2,29),
(2,5,1000.00,2,30),
(3,7,350.00,1,3);

/*Table structure for table `predavac` */

DROP TABLE IF EXISTS `predavac`;

CREATE TABLE `predavac` (
  `predavacID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`predavacID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `predavac` */

insert  into `predavac`(`predavacID`,`ime`,`prezime`,`username`,`password`) values 
(1,'Marko','Markovic','markom','marko123'),
(2,'Nikola','Nikolic','nikolan','nikola123'),
(4,'Marija','Makic','marijam','marija123'),
(5,'Stasa','Stankovic','stasas','stasa123'),
(6,'Ana','Antic','anaa','ana123'),
(7,'Ivana','Ivkovic','ivana123','ivana123');

/*Table structure for table `prijavljivanje` */

DROP TABLE IF EXISTS `prijavljivanje`;

CREATE TABLE `prijavljivanje` (
  `prijavljivanjeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `ukupnaCena` decimal(10,0) NOT NULL,
  `predavac` bigint(20) NOT NULL,
  `student` bigint(20) NOT NULL,
  PRIMARY KEY (`prijavljivanjeID`),
  KEY `predavac` (`predavac`),
  KEY `student` (`student`),
  CONSTRAINT `prijavljivanje_ibfk_1` FOREIGN KEY (`predavac`) REFERENCES `predavac` (`predavacID`),
  CONSTRAINT `prijavljivanje_ibfk_2` FOREIGN KEY (`student`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `prijavljivanje` */

insert  into `prijavljivanje`(`prijavljivanjeID`,`datum`,`ukupnaCena`,`predavac`,`student`) values 
(2,'2024-09-12',1500,7,4),
(4,'2024-02-19',8000,7,1),
(27,'2024-06-04',7500,7,7),
(30,'2024-02-19',10000,7,1);

/*Table structure for table `programi` */

DROP TABLE IF EXISTS `programi`;

CREATE TABLE `programi` (
  `programID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `semestar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`programID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `programi` */

insert  into `programi`(`programID`,`naziv`,`semestar`) values 
(1,'ELEKTRONSKO POSLOVANJE','zimski'),
(2,'PRINCIPI PROGRAMIRANJA','letnji'),
(3,'UVOD U INFORMACIONE SISTEME','letnji'),
(4,'MATEMATIKA 2','letnji'),
(5,'EKONOMIJA','zimski'),
(6,'MATEMATIKA 1','zimski'),
(7,'INZENJERING PROCESA','letnji');

/*Table structure for table `statistika` */

DROP TABLE IF EXISTS `statistika`;

CREATE TABLE `statistika` (
  `statistikaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ocena` int(20) NOT NULL,
  `program` bigint(20) unsigned NOT NULL,
  `student` bigint(20) NOT NULL,
  PRIMARY KEY (`statistikaID`),
  KEY `program` (`program`),
  KEY `student` (`student`),
  CONSTRAINT `statistika_ibfk_1` FOREIGN KEY (`program`) REFERENCES `programi` (`programID`),
  CONSTRAINT `statistika_ibfk_2` FOREIGN KEY (`student`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `statistika` */

insert  into `statistika`(`statistikaID`,`ocena`,`program`,`student`) values 
(1,9,1,1),
(2,8,2,2),
(3,7,1,3),
(4,9,1,2);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `student` */

insert  into `student`(`studentID`,`ime`,`prezime`,`email`) values 
(1,'Uros','Jovanovic','urosj@gmail.com'),
(2,'Nikola','Markoviccc','nikolam@gmail.com'),
(3,'Jovana','Jankovic','jovanaj@gmail.com'),
(4,'Milica','Jovanic','milicaj@gmail.com'),
(7,'Ivana','Ercegovac','ivana123@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
