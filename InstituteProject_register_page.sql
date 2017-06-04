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
-- Table structure for table `register_page`
--

DROP TABLE IF EXISTS `register_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `register_page` (
  `EnrollmentNumber` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Course` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Fname` varchar(45) NOT NULL,
  `Bname` varchar(45) NOT NULL,
  `TotalFees` varchar(45) NOT NULL,
  `DueAmt` varchar(45) DEFAULT NULL,
  `DueDate` varchar(45) DEFAULT NULL,
  `ImgPath` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `Discount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EnrollmentNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register_page`
--

LOCK TABLES `register_page` WRITE;
/*!40000 ALTER TABLE `register_page` DISABLE KEYS */;
INSERT INTO `register_page` VALUES ('deeJava10to12JAVA2016','deepak','sec24','Java10to12','85000','dddd','JAVA','5000','0','0','/home/deepak/BRACKETS/Flipkartimages/a2.jpeg','er.d.ahuja@gmail.com',NULL),('deejava20JAVA2016','deepak','sss','java20','sss','sss','java20','5000','0','0','/home/deepak/BRACKETS/Flipkartimages/a2.jpeg','er.d.ahuja@gmail.com',NULL),('ojajava20JAVA2016','ojaswi','into the wild','java20','100','shahenshah','JAVA','5000','0','0','/home/deepak/BRACKETS/Flipkartimages/a2.jpeg','kuchhai@gmail.com',NULL);
/*!40000 ALTER TABLE `register_page` ENABLE KEYS */;
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
