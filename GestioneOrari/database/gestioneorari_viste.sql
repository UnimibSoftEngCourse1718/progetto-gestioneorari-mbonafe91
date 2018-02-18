CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `impegnidocente` AS
    SELECT 
        'LEZIONE' AS `tipo`,
        `lezione`.`identificativoDocente` AS `identificativodocente`,
        `lezione`.`identificativoLezione` AS `identificativo`,
        `lezione`.`inizioLezione` AS `inizio`,
        `lezione`.`fineLezione` AS `fine`
    FROM
        `lezione` 
    UNION SELECT 
        'ESAME' AS `tipo`,
        `esame`.`identificativoDocente` AS `identificativodocente`,
        `esame`.`identificativoEsame` AS `identificativo`,
        `esame`.`inizioEsame` AS `inizio`,
        `esame`.`fineEsame` AS `fine`
    FROM
        `esame`;

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `occupazioneaula` AS
    SELECT 
        'Lezione' AS `Tipo`,
        `l`.`identificativoAula` AS `identificativoAula`,
        `l`.`identificativoLezione` AS `identificativo`,
        `l`.`inizioLezione` AS `inizio`,
        `l`.`fineLezione` AS `fine`
    FROM
        `lezione` `l` 
    UNION ALL SELECT 
        'Esame' AS `Tipo`,
        `e`.`identificativoAula` AS `identificativoAula`,
        `e`.`identificativoEsame` AS `identificativo`,
        `e`.`inizioEsame` AS `inizio`,
        `e`.`fineEsame` AS `fine`
    FROM
        `esame` `e`;

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `controlloimpegnidocente` AS
    SELECT DISTINCT
        `b`.`tipo` AS `tipo`,
        `b`.`identificativodocente` AS `identificativodocente`,
        `b`.`identificativo` AS `identificativoimpegnodocente`,
        `b`.`inizio` AS `inizioimpegnodocente`,
        `b`.`fine` AS `fineimpegnodocente`,
        (CASE
            WHEN (`b`.`inizio` BETWEEN `a`.`inizio` AND `a`.`fine`) THEN 'inizio lezione/esame sovrapposto ad un altro impegno'
            WHEN (`b`.`fine` BETWEEN `a`.`inizio` AND `a`.`fine`) THEN 'fine lezione/esame sovrapposto ad un altro impegno'
        END) AS `Messaggio`
    FROM
        (`impegnidocente` `a`
        JOIN `impegnidocente` `b`)
    WHERE
        ((`a`.`identificativodocente` = `b`.`identificativodocente`)
            AND (`a`.`identificativo` <> `b`.`identificativo`)
            AND ((`b`.`inizio` BETWEEN `a`.`inizio` AND `a`.`fine`)
            OR (`b`.`fine` BETWEEN `a`.`inizio` AND `a`.`fine`)));

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `controllooccupazioneaula` AS
    SELECT DISTINCT
        `b`.`Tipo` AS `tipo`,
        `b`.`identificativoAula` AS `identificativoAula`,
        `b`.`identificativo` AS `identificativo`,
        `b`.`inizio` AS `iniziooccupazioneaula`,
        `b`.`fine` AS `fineoccupazioneaula`,
        `c`.`nomeAula` AS `nomeaula`,
        `c`.`edificioAula` AS `edificioaula`,
        (CASE
            WHEN (`b`.`inizio` BETWEEN `a`.`inizio` AND `a`.`fine`) THEN 'allocazione aula sovrapposta, verificare inizio esame lezione'
            WHEN (`b`.`fine` BETWEEN `a`.`inizio` AND `a`.`fine`) THEN 'allocazione aula sovrapposta, verificare la fine esame lezione'
        END) AS `Messaggio`
    FROM
        ((`occupazioneaula` `a`
        JOIN `occupazioneaula` `b`)
        JOIN `aula` `c`)
    WHERE
        ((`a`.`identificativoAula` = `b`.`identificativoAula`)
            AND (`a`.`identificativo` <> `b`.`identificativo`)
            AND ((`b`.`inizio` BETWEEN `a`.`inizio` AND `a`.`fine`)
            OR (`b`.`fine` BETWEEN `a`.`inizio` AND `a`.`fine`))
            AND (`b`.`identificativoAula` = `c`.`identificativoAula`));

