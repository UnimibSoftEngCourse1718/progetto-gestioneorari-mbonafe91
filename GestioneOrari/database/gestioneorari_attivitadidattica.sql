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
-- Table structure for table `attivitadidattica`
--

DROP TABLE IF EXISTS `attivitadidattica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attivitadidattica` (
  `identificativoAttivita` char(36) NOT NULL DEFAULT 'uuid()',
  `nomeAttivita` varchar(100) NOT NULL,
  `descrizioneAttivita` longtext NOT NULL,
  `CFU` int(11) NOT NULL,
  `annoDiCorso` int(11) NOT NULL,
  `annoAccademico` varchar(9) NOT NULL,
  `identificativoCorso` char(36) NOT NULL,
  `identificativoDocente` char(36) NOT NULL,
  PRIMARY KEY (`identificativoAttivita`),
  KEY `AttivitaCorso_idx` (`identificativoCorso`),
  KEY `ResponsabileAttivita_idx` (`identificativoDocente`),
  CONSTRAINT `AttivitaCorso` FOREIGN KEY (`identificativoCorso`) REFERENCES `corso` (`identificativoCorso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ResponsabileAttivita` FOREIGN KEY (`identificativoDocente`) REFERENCES `docente` (`identificativoDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivitadidattica`
--

LOCK TABLES `attivitadidattica` WRITE;
/*!40000 ALTER TABLE `attivitadidattica` DISABLE KEYS */;
INSERT INTO `attivitadidattica` VALUES ('4028b881618545280161855bb3ac0000','Algoritmi e Strutture Dati','Algoritmi e Strutture Dati',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0001','Architettura degli Elaboratori','Architettura degli Elaboratori',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0002','Complementi di Matematica','Complementi di Matematica',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0003','Fondamenti di Informatica','Fondamenti di Informatica',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0004','Analisi Matematica','Analisi Matematica',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0005','Programmazione 1','Programmazzione 1',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0006','Programmazione 2','Programmazione 2',8,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0007','Inglese','Inglese',3,1,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0010','Analisi e Progettazione del Software','Analisi e Progettazione del Software',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0011','Basi di Dati','Basi di Dati',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0012','Fisica','Fisica',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0013','Linguaggi di Programmazione','Linguaggi di Programmazione',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0014','Statistica','Statistica',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0015','Reti e Sistemi Operativi','Reti e Sistemi Operativi',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('4028b881618545280161855bb3ac0016','Sistemi Distribuiti','Sistemi Distribuiti',8,2,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('8ac5870f6143d1a1016143d274b30000','Ingegneria del Software','Ingegneria del Software',8,3,'2017/2018','4028b88161852449016185273f9d0000','pppppp'),('8ac5870f6143dcb7016143de13b70000','Diritto Privato','Diritto Privato',12,1,'2017/2018','4028b8816137faa4016137fef8c80001','pppppp');
/*!40000 ALTER TABLE `attivitadidattica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-18 16:48:56
