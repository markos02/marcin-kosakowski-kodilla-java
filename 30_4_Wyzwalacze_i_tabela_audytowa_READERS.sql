CREATE TABLE READERS_AUD
(
    EVENT_ID      INT(11)  NOT NULL AUTO_INCREMENT,
    EVENT_DATE    DATETIME NOT NULL,
    EVENT_TYPE    VARCHAR(10) DEFAULT NULL,
    READER_ID     INT(11)  NOT NULL,
    OLD_FIRSTNAME VARCHAR(255),
    NEW_FIRSTNAME VARCHAR(255),
    OLD_LASTNAME  VARCHAR(255),
    NEW_LASTNAME  VARCHAR(255),
    OLD_PESELID   VARCHAR(11),
    NEW_PESELID   VARCHAR(11),
    OLD_VIP_LEVEL VARCHAR(20),
    NEW_VIP_LEVEL VARCHAR(20),
    PRIMARY KEY (EVENT_ID)
);

DELIMITER $$

CREATE TRIGGER READERS_INSERT
    AFTER INSERT
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL)
        VALUE (CURTIME(), "INSERT", NEW.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW_PESELID, NEW.VIP_LEVEL);
END $$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER READERS_DELETE
    AFTER DELETE
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE (CURTIME(), "DELETE", OLD.READER_ID);
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER READERS_UPDATE
    AFTER UPDATE
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL,
                             OLD_FIRSTNAME, OLD_LASTNAME, OLD_PESELID, OLD_VIP_LEVEL)
        VALUE (CURTIME(), "UPDATE", OLD.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID, NEW.VIP_LEVEL,
               OLD.FIRSTNAME, OLD.LASTNAME, OLD.PESELID, OLD.VIP_LEVEL);
END $$

DELIMITER ;