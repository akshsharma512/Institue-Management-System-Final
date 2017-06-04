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
-- Table structure for table `feepayment`
--

DROP TABLE IF EXISTS `feepayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feepayment` (
  `AdmissionNum` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `CourseName` varchar(50) DEFAULT NULL,
  `TotalFee` int(11) DEFAULT NULL,
  `Discount` int(11) DEFAULT NULL,
  `PayableAmount` int(11) DEFAULT NULL,
  `PaidAmount` int(11) DEFAULT NULL,
  `DueAmount` int(11) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `ModeofPayment` varchar(50) DEFAULT NULL,
  `ChequeNum` varchar(50) DEFAULT NULL,
  `BankName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feepayment`
--

LOCK TABLES `feepayment` WRITE;
/*!40000 ALTER TABLE `feepayment` DISABLE KEYS */;
INSERT INTO `feepayment` VALUES ('100','deepak','java',10000,500,9500,9000,500,'2016/8/14','Cheque','100','mom'),('100','deepak','java',10000,500,9500,9000,500,'2016/8/14','Cheque','100','om'),('100','deepak','java',10000,500,9500,9000,500,'2016/8/14','Cheque','100','bob'),('deeJava10to12JAVA2016','deepak','Java10to12',5000,0,5000,100,4900,'2016/8/21','Cheque','123','bom'),('deeJava10to12JAVA2016','deepak','Java10to12',5000,0,5000,2000,3000,'2016/8/21','Cheque','1232','vvv'),('deeJava10to12JAVA2016','deepak','Java10to12',5000,0,5000,20,4980,'2016/8/21','Cheque','222','sss'),('deeJava10to12JAVA2016','deepak','Java10to12',5000,0,5000,200,4800,'2016/8/21','Cheque','123','bom'),('deeJava10to12JAVA2016','deepak','Java10to12',5000,0,5000,200,4800,'2016/8/21','Cheque','222','sss');
/*!40000 ALTER TABLE `feepayment` ENABLE KEYS */;
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
