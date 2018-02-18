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
-- Temporary view structure for view `impegnidocente`
--

DROP TABLE IF EXISTS `impegnidocente`;
/*!50001 DROP VIEW IF EXISTS `impegnidocente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `impegnidocente` AS SELECT 
 1 AS `tipo`,
 1 AS `identificativodocente`,
 1 AS `identificativo`,
 1 AS `inizio`,
 1 AS `fine`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `controlloimpegnidocente`
--

DROP TABLE IF EXISTS `controlloimpegnidocente`;
/*!50001 DROP VIEW IF EXISTS `controlloimpegnidocente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `controlloimpegnidocente` AS SELECT 
 1 AS `tipo`,
 1 AS `identificativodocente`,
 1 AS `identificativoimpegnodocente`,
 1 AS `inizioimpegnodocente`,
 1 AS `fineimpegnodocente`,
 1 AS `Messaggio`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `occupazioneaula`
--

DROP TABLE IF EXISTS `occupazioneaula`;
/*!50001 DROP VIEW IF EXISTS `occupazioneaula`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `occupazioneaula` AS SELECT 
 1 AS `Tipo`,
 1 AS `identificativoAula`,
 1 AS `identificativo`,
 1 AS `inizio`,
 1 AS `fine`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `controllooccupazioneaula`
--

DROP TABLE IF EXISTS `controllooccupazioneaula`;
/*!50001 DROP VIEW IF EXISTS `controllooccupazioneaula`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `controllooccupazioneaula` AS SELECT 
 1 AS `tipo`,
 1 AS `identificativoAula`,
 1 AS `identificativo`,
 1 AS `iniziooccupazioneaula`,
 1 AS `fineoccupazioneaula`,
 1 AS `nomeaula`,
 1 AS `edificioaula`,
 1 AS `Messaggio`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `impegnidocente`
--

/*!50001 DROP VIEW IF EXISTS `impegnidocente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `impegnidocente` AS select 'LEZIONE' AS `tipo`,`lezione`.`identificativoDocente` AS `identificativodocente`,`lezione`.`identificativoLezione` AS `identificativo`,`lezione`.`inizioLezione` AS `inizio`,`lezione`.`fineLezione` AS `fine` from `lezione` union select 'ESAME' AS `tipo`,`esame`.`identificativoDocente` AS `identificativodocente`,`esame`.`identificativoEsame` AS `identificativo`,`esame`.`inizioEsame` AS `inizio`,`esame`.`fineEsame` AS `fine` from `esame` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `controlloimpegnidocente`
--

/*!50001 DROP VIEW IF EXISTS `controlloimpegnidocente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `controlloimpegnidocente` AS select distinct `b`.`tipo` AS `tipo`,`b`.`identificativodocente` AS `identificativodocente`,`b`.`identificativo` AS `identificativoimpegnodocente`,`b`.`inizio` AS `inizioimpegnodocente`,`b`.`fine` AS `fineimpegnodocente`,(case when (`b`.`inizio` between `a`.`inizio` and `a`.`fine`) then 'inizio lezione/esame sovrapposto ad un altro impegno' when (`b`.`fine` between `a`.`inizio` and `a`.`fine`) then 'fine lezione/esame sovrapposto ad un altro impegno' end) AS `Messaggio` from (`impegnidocente` `a` join `impegnidocente` `b`) where ((`a`.`identificativodocente` = `b`.`identificativodocente`) and (`a`.`identificativo` <> `b`.`identificativo`) and ((`b`.`inizio` between `a`.`inizio` and `a`.`fine`) or (`b`.`fine` between `a`.`inizio` and `a`.`fine`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `occupazioneaula`
--

/*!50001 DROP VIEW IF EXISTS `occupazioneaula`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `occupazioneaula` AS select 'Lezione' AS `Tipo`,`l`.`identificativoAula` AS `identificativoAula`,`l`.`identificativoLezione` AS `identificativo`,`l`.`inizioLezione` AS `inizio`,`l`.`fineLezione` AS `fine` from `lezione` `l` union all select 'Esame' AS `Tipo`,`e`.`identificativoAula` AS `identificativoAula`,`e`.`identificativoEsame` AS `identificativo`,`e`.`inizioEsame` AS `inizio`,`e`.`fineEsame` AS `fine` from `esame` `e` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `controllooccupazioneaula`
--

/*!50001 DROP VIEW IF EXISTS `controllooccupazioneaula`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `controllooccupazioneaula` AS select distinct `b`.`Tipo` AS `tipo`,`b`.`identificativoAula` AS `identificativoAula`,`b`.`identificativo` AS `identificativo`,`b`.`inizio` AS `iniziooccupazioneaula`,`b`.`fine` AS `fineoccupazioneaula`,`c`.`nomeAula` AS `nomeaula`,`c`.`edificioAula` AS `edificioaula`,(case when (`b`.`inizio` between `a`.`inizio` and `a`.`fine`) then 'allocazione aula sovrapposta, verificare l\'inizio dell\'esamelezione' when (`b`.`fine` between `a`.`inizio` and `a`.`fine`) then 'allocazione aula sovrapposta, verificare la fine dell\'esamelezione' end) AS `Messaggio` from ((`occupazioneaula` `a` join `occupazioneaula` `b`) join `aula` `c`) where ((`a`.`identificativoAula` = `b`.`identificativoAula`) and (`a`.`identificativo` <> `b`.`identificativo`) and ((`b`.`inizio` between `a`.`inizio` and `a`.`fine`) or (`b`.`fine` between `a`.`inizio` and `a`.`fine`)) and (`b`.`identificativoAula` = `c`.`identificativoAula`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-18 16:49:00
