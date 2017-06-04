-- MySQL dump 10.13  Distrib 5.7.13, for Linux (x86_64)
--
-- Host: localhost    Database: InstituteProject
-- ------------------------------------------------------
-- Server version	5.7.13-0ubuntu0.16.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enquire_sql`
--

DROP TABLE IF EXISTS `enquire_sql`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enquire_sql` (
  `EnquireID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `secondName` varchar(45) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `address2` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobileContact` varchar(45) DEFAULT NULL,
  `otherContact` varchar(45) DEFAULT NULL,
  `slot1` varchar(45) DEFAULT NULL,
  `slot2` varchar(45) DEFAULT NULL,
  `fatherFirstName` varchar(45) DEFAULT NULL,
  `fatherSecondName` varchar(45) DEFAULT NULL,
  `fatherMobileContact` varchar(45) DEFAULT NULL,
  `fatherOtherContact` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `reference` varchar(45) DEFAULT NULL,
  `EnquireDate` timestamp NULL DEFAULT NULL,
  `EnquireContactDate` date DEFAULT NULL,
  `Coursename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EnquireID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enquire_sql`
--

LOCK TABLES `enquire_sql` WRITE;
/*!40000 ALTER TABLE `enquire_sql` DISABLE KEYS */;
INSERT INTO `enquire_sql` VALUES (1,'Deepak','','sss','','sss','sss','','ss','','ss','','ss','','ss','sss','sss','2016-08-22 05:02:01','2016-08-09','JAVA'),(2,'deepak','','hh','hhh','hhh','hhh','hhh','jjj','kjj','j','jjj','mj','jjjj','kkk','jjj','mm','2016-08-22 05:09:30','2016-08-18','JAVA'),(3,'deepak','jj','jjj','jjj','jjj','jjj','jjj','kk','kkk','kkk','kkk','kkk','kkk','kk','hjh','hh','2016-08-22 10:37:23','2016-08-23','JAVA'),(4,'ddh','hhhh','hhh','hhh','hhh','hhh','hhh','hhh','hh','hh','h','h','hh','h','h','h','2016-08-22 10:38:26','2016-08-22','JAVA');
/*!40000 ALTER TABLE `enquire_sql` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-25 15:16:52
