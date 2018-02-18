-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestioneorari
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `disponibilitadocente`
--

DROP TABLE IF EXISTS `disponibilitadocente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disponibilitadocente` (
  `identificativoDisponibilita` char(36) NOT NULL DEFAULT 'uuid()',
  `disponibilitaDa` datetime NOT NULL,
  `disponibilitaA` datetime NOT NULL,
  `identificativoDocente` char(36) NOT NULL,
  PRIMARY KEY (`identificativoDisponibilita`),
  KEY `DisponibilitaDocente_idx` (`identificativoDocente`),
  CONSTRAINT `DisponibilitaDocente` FOREIGN KEY (`identificativoDocente`) REFERENCES `docente` (`identificativoDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disponibilitadocente`
--

LOCK TABLES `disponibilitadocente` WRITE;
/*!40000 ALTER TABLE `disponibilitadocente` DISABLE KEYS */;
INSERT INTO `disponibilitadocente` VALUES ('4028b88161a44e160161a45079db0000','2018-02-26 00:00:00','2018-02-28 00:00:00','pppppp'),('8ac5874c619159dd01619160f2690000','2018-02-19 00:00:00','2018-02-23 00:00:00','pppppp');
/*!40000 ALTER TABLE `disponibilitadocente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-18 16:48:59
