CREATE TABLE BOOKS_AUD
(
    EVENT_ID       INT(11)  NOT NULL AUTO_INCREMENT,
    EVENT_DATE     DATETIME NOT NULL,
    EVENT_TYPE     VARCHAR(10) DEFAULT NULL,
    BOOK_ID        INT(11)  NOT NULL,
    OLD_TITLE      VARCHAR(255),
    NEW_TITLE      VARCHAR(255),
    OLD_PUBYEAR    INT(11),
    NEW_PUBYEAR    INT(11),
    OLD_BESTSELLER BOOLEAN,
    NEW_BESTSELLER BOOLEAN,
    PRIMARY KEY (EVENT_ID)
);

DELIMITER $$

CREATE TRIGGER BOOKS_INSERT
    AFTER INSERT
    ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
        VALUE (CURTIME(), "INSERT", NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER);
END $$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE(CURTIME(), "DELETE", OLD.BOOK_ID);
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER, OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLER)
        VALUE(CURTIME(), "UPDATE", OLD.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER, OLD.TITLE, OLD.PUBYEAR, OLD.BESTSELLER);
END $$

DELIMITER ;