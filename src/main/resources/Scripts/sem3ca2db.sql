-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: ca2db
-- ------------------------------------------------------
-- Server version	5.7.10-log
CREATE DATABASE sem3ca2;
USE sem3ca2;

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `ID` bigint(20) NOT NULL,
  `ADDITIONALINFO` varchar(255) DEFAULT NULL,
  `STREET` varchar(255) DEFAULT NULL,
  `CITYINFO_ZIP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ADDRESS_CITYINFO_ZIP` (`CITYINFO_ZIP`),
  CONSTRAINT `FK_ADDRESS_CITYINFO_ZIP` FOREIGN KEY (`CITYINFO_ZIP`) REFERENCES `cityinfo` (`ZIP`),
  CONSTRAINT `FK_ADDRESS_ID` FOREIGN KEY (`ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cityinfo`
--

DROP TABLE IF EXISTS `cityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cityinfo` (
  `ZIP` varchar(255) NOT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ZIP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cityinfo`
--

LOCK TABLES `cityinfo` WRITE;
/*!40000 ALTER TABLE `cityinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cityinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `ID` bigint(20) NOT NULL,
  `CVR` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `MARKETVALUE` double DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `NUMEMPLOYEES` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_COMPANY_ID` FOREIGN KEY (`ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hobby` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTON` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infoentity`
--

DROP TABLE IF EXISTS `infoentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `infoentity` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DTYPE` varchar(31) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  `ADRESS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INFOENTITY_ADRESS_ID` (`ADRESS_ID`),
  KEY `FK_INFOENTITY_ADDRESS_ID` (`ADDRESS_ID`),
  CONSTRAINT `FK_INFOENTITY_ADDRESS_ID` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `infoentity` (`ID`),
  CONSTRAINT `FK_INFOENTITY_ADRESS_ID` FOREIGN KEY (`ADRESS_ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infoentity`
--

LOCK TABLES `infoentity` WRITE;
/*!40000 ALTER TABLE `infoentity` DISABLE KEYS */;
INSERT INTO `infoentity` VALUES (1,'Person','sf@hej.com',NULL,NULL),(2,'Person','sf@hej.com',NULL,NULL);
/*!40000 ALTER TABLE `infoentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `ID` bigint(20) NOT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PERSON_ID` FOREIGN KEY (`ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'bjarne','bjarne'),(2,'bjarne','bjarne');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_hobby`
--

DROP TABLE IF EXISTS `person_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_hobby` (
  `persons_ID` bigint(20) NOT NULL,
  `hobbies_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`persons_ID`,`hobbies_ID`),
  KEY `FK_PERSON_HOBBY_hobbies_ID` (`hobbies_ID`),
  CONSTRAINT `FK_PERSON_HOBBY_hobbies_ID` FOREIGN KEY (`hobbies_ID`) REFERENCES `hobby` (`ID`),
  CONSTRAINT `FK_PERSON_HOBBY_persons_ID` FOREIGN KEY (`persons_ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_hobby`
--

LOCK TABLES `person_hobby` WRITE;
/*!40000 ALTER TABLE `person_hobby` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NUMBER` int(11) DEFAULT NULL,
  `INFOENTITY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PHONE_INFOENTITY_ID` (`INFOENTITY_ID`),
  CONSTRAINT `FK_PHONE_INFOENTITY_ID` FOREIGN KEY (`INFOENTITY_ID`) REFERENCES `infoentity` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-17 14:13:56
