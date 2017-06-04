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
-- Table structure for table `add_expenses`
--

DROP TABLE IF EXISTS `add_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `add_expenses` (
  `capital_lease_cost` int(11) DEFAULT NULL,
  `advertising_cost` int(11) DEFAULT NULL,
  `broadband_cost` int(11) DEFAULT NULL,
  `staff_salary_cost` int(11) DEFAULT NULL,
  `maintainance_cost` int(11) DEFAULT NULL,
  `miscellaneous` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_expenses`
--

LOCK TABLES `add_expenses` WRITE;
/*!40000 ALTER TABLE `add_expenses` DISABLE KEYS */;
INSERT INTO `add_expenses` VALUES (0,0,0,0,0,0),(0,0,0,0,0,0);
/*!40000 ALTER TABLE `add_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attandance_table`
--

DROP TABLE IF EXISTS `attandance_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attandance_table` (
  `attandance_id` int(11) NOT NULL AUTO_INCREMENT,
  `attandance_date` date NOT NULL,
  `studentname` varchar(20) NOT NULL,
  `batchname` varchar(20) NOT NULL,
  PRIMARY KEY (`attandance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attandance_table`
--

LOCK TABLES `attandance_table` WRITE;
/*!40000 ALTER TABLE `attandance_table` DISABLE KEYS */;
INSERT INTO `attandance_table` VALUES (1,'2016-08-23','deepak','java20');
/*!40000 ALTER TABLE `attandance_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch_table`
--

DROP TABLE IF EXISTS `batch_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch_table` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `batchname` varchar(100) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `trainername` varchar(50) NOT NULL,
  `totalsets` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `batch_starts` date NOT NULL,
  `endtime` varchar(20) NOT NULL,
  `starttime` varchar(20) NOT NULL,
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_table`
--

LOCK TABLES `batch_table` WRITE;
/*!40000 ALTER TABLE `batch_table` DISABLE KEYS */;
INSERT INTO `batch_table` VALUES (1,'java20','JAVA','deepak',30,',ll','2016-08-02','1200','1100'),(2,'Java10to12','JAVA','amit',30,'','2016-08-09','','10'),(3,'android10','ANDROID','amit sir',30,'very good','2016-08-25','1200','1100');
/*!40000 ALTER TABLE `batch_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counselor_table`
--

DROP TABLE IF EXISTS `counselor_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counselor_table` (
  `counseler_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`counseler_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counselor_table`
--

LOCK TABLES `counselor_table` WRITE;
/*!40000 ALTER TABLE `counselor_table` DISABLE KEYS */;
INSERT INTO `counselor_table` VALUES (3,'deepak','deepak');
/*!40000 ALTER TABLE `counselor_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_table`
--

DROP TABLE IF EXISTS `courses_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_table` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(32) NOT NULL,
  `fees` int(11) NOT NULL,
  `course_description` varchar(200) NOT NULL,
  `duration` int(11) NOT NULL,
  `trainer_name` varchar(45) NOT NULL,
  PRIMARY KEY (`course_id`,`course_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_table`
--

LOCK TABLES `courses_table` WRITE;
/*!40000 ALTER TABLE `courses_table` DISABLE KEYS */;
INSERT INTO `courses_table` VALUES (6,'ANDROID',5000,'very good',30,'DEEPAK');
/*!40000 ALTER TABLE `courses_table` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `payment_type`
--

DROP TABLE IF EXISTS `payment_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_type` (
  `ModeofPayment` varchar(50) DEFAULT NULL,
  `BankName` varchar(50) DEFAULT NULL,
  `Remarks` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_type`
--

LOCK TABLES `payment_type` WRITE;
/*!40000 ALTER TABLE `payment_type` DISABLE KEYS */;
INSERT INTO `payment_type` VALUES ('Cheque','BOB','na');
/*!40000 ALTER TABLE `payment_type` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `student_iinfo`
--

DROP TABLE IF EXISTS `student_iinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_iinfo` (
  `AdmissionNum` int(11) DEFAULT NULL,
  `StudentName` varchar(50) DEFAULT NULL,
  `CourseName` varchar(50) DEFAULT NULL,
  `TotalFee` varchar(50) DEFAULT NULL,
  `Discount` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_iinfo`
--

LOCK TABLES `student_iinfo` WRITE;
/*!40000 ALTER TABLE `student_iinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_iinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_table`
--

DROP TABLE IF EXISTS `student_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_table` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(100) NOT NULL,
  `fathername` varchar(50) NOT NULL,
  `mothername` varchar(50) NOT NULL,
  `batch_id` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `course_name` date NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_table`
--

LOCK TABLES `student_table` WRITE;
/*!40000 ALTER TABLE `student_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_registration`
--

DROP TABLE IF EXISTS `trainer_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer_registration` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `Trainer_name` varchar(45) NOT NULL,
  `Trainer_age` int(11) NOT NULL,
  `Trainer_gender` varchar(45) NOT NULL,
  `Trainer_mobileno` varchar(45) NOT NULL,
  `Trainer_email` varchar(45) NOT NULL,
  `Trainer_address` varchar(100) NOT NULL,
  `Trainer_image` varchar(45) NOT NULL,
  `Trainer_subject` varchar(45) NOT NULL,
  `Trainer_hiredate` date NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_registration`
--

LOCK TABLES `trainer_registration` WRITE;
/*!40000 ALTER TABLE `trainer_registration` DISABLE KEYS */;
INSERT INTO `trainer_registration` VALUES (9,'sunil',22,'Male','8475963285','asdfasdfasdlfkj;asldkf alsdkfj','vishasdkf@gmail.com','java','aceForIMS/IMS/Imagessunil.jpeg','2016-08-16'),(10,'sunil',22,'Male','8447585692','as;dkfj;askdfj;l','va;ldjf;asid@gmail.com','java','aceForIMS/IMS/Images/sunil.jpeg','2016-08-11'),(11,'fan',89,'Male','8547586593','asdfka;lsdkfj','v;aidjf;aj@gmail.com','java','aceForIMS/IMS/Images/fan.jpeg','2016-08-22'),(12,'ann',45,'Male','8457236595','al;sdfkj;aksdjf;lk	','vishkarma@gmail.com','java','aceForIMS/IMS/Images/ann.jpeg','2016-08-11'),(13,'Sunil',45,'Male','8447586869',';lasdkjf;kasd;f','viahsaldkj;@gmail.com','java','aceForIMS/IMS/Images/Sunil.jpeg','2016-08-10'),(14,'Sunil',22,'Male','8447585986','asdfk\';;lasdkjf;','viahsl@yahoo.com','java','/IMS/Images/Sunil.jpeg','2016-08-19');
/*!40000 ALTER TABLE `trainer_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'deepak','deepak');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'InstituteProject'
--

--
-- Dumping routines for database 'InstituteProject'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-25 15:25:13
