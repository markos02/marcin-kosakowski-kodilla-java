EXPLAIN
SELECT *
FROM READERS
WHERE FIRSTNAME = "JOHN";

CREATE INDEX NAME ON READERS (FIRSTNAME);

CREATE INDEX SURNAME ON READERS (LASTNAME);

CREATE INDEX TITLE ON BOOKS (TITLE);

EXPLAIN
SELECT *
FROM READERS
WHERE FIRSTNAME = "JOHN";