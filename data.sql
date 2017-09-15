CREATE DATABASE  IF NOT EXISTS `mysql` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mysql`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: mysql
-- ------------------------------------------------------
-- Server version	5.5.24

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-03 20:33:39
CREATE DATABASE  IF NOT EXISTS `nupur` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nupur`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: nupur
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `java`
--

DROP TABLE IF EXISTS `java`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `java` (
  `stid` varchar(10) NOT NULL,
  `stname` varchar(45) NOT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `java`
--

LOCK TABLES `java` WRITE;
/*!40000 ALTER TABLE `java` DISABLE KEYS */;
/*!40000 ALTER TABLE `java` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `python`
--

DROP TABLE IF EXISTS `python`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `python` (
  `stid` varchar(10) NOT NULL,
  `stname` varchar(45) NOT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `python`
--

LOCK TABLES `python` WRITE;
/*!40000 ALTER TABLE `python` DISABLE KEYS */;
INSERT INTO `python` VALUES ('s5','pakhi',NULL),('s9','Mansha',NULL);
/*!40000 ALTER TABLE `python` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_info`
--

DROP TABLE IF EXISTS `t_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_info` (
  `tid` varchar(10) NOT NULL,
  `tname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_info`
--

LOCK TABLES `t_info` WRITE;
/*!40000 ALTER TABLE `t_info` DISABLE KEYS */;
INSERT INTO `t_info` VALUES ('t1','qwerty','qwerty'),('t4','neelam','neelam'),('t7','Kavita Pandey','Kavita Pandey'),('t8','Asha','Asha');
/*!40000 ALTER TABLE `t_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `eid` int(11) NOT NULL,
  `ename` varchar(45) DEFAULT NULL,
  `egender` varchar(6) DEFAULT NULL,
  `ecity` varchar(25) DEFAULT NULL,
  `esalary` int(11) DEFAULT NULL,
  `etax` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'neelam ','Female','Delhi',500000,10000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stid` int(11) NOT NULL,
  `stname` varchar(30) NOT NULL,
  `stclass` varchar(15) NOT NULL,
  `marks1` int(11) DEFAULT NULL,
  `marks2` int(11) DEFAULT NULL,
  `marks3` int(11) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Riya','Twelth',90,80,70),(2,'Simran','Twelth',91,87,78),(4,'Saumya','Twelth',70,76,78),(9,'Taj','B.Tech.',98,93,94);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_info`
--

DROP TABLE IF EXISTS `s_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s_info` (
  `stid` varchar(10) NOT NULL,
  `stname` varchar(45) NOT NULL,
  `stbatch` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_info`
--

LOCK TABLES `s_info` WRITE;
/*!40000 ALTER TABLE `s_info` DISABLE KEYS */;
INSERT INTO `s_info` VALUES ('s10','Kashish','Android','Kashish'),('s2','Simran','Android','Simran'),('s5','pakhi','Python','pakhi'),('s6','bharat','Android','bharat'),('s9','Mansha','Python','Mansha');
/*!40000 ALTER TABLE `s_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `android`
--

DROP TABLE IF EXISTS `android`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `android` (
  `stid` varchar(10) NOT NULL,
  `stname` varchar(45) NOT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `android`
--

LOCK TABLES `android` WRITE;
/*!40000 ALTER TABLE `android` DISABLE KEYS */;
INSERT INTO `android` VALUES ('s10','Kashish',NULL),('s2','Simran','A'),('s6','bharat','A');
/*!40000 ALTER TABLE `android` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('a','b'),('c','d');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-03 20:33:41
