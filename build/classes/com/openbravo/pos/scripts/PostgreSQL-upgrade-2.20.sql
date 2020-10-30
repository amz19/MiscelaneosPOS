-- Database upgrade script for POSTGRESQL

-- v2.20 - v2.30beta

INSERT INTO RESOURCES(ID, NAME, RESTYPE, CONTENT) VALUES('30', 'Printer.PartialCash', 0, $FILE{/com/openbravo/pos/templates/Printer.PartialCash.xml});

CREATE TABLE _PRODUCTS_COM (
    ID VARCHAR NOT NULL,
    PRODUCT VARCHAR NOT NULL,
    PRODUCT2 VARCHAR NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO _PRODUCTS_COM(ID, PRODUCT, PRODUCT2) SELECT PRODUCT || PRODUCT2, PRODUCT, PRODUCT2 FROM PRODUCTS_COM;

ALTER TABLE PRODUCTS_COM DROP CONSTRAINT PRODUCTS_COM_FK_1; 
ALTER TABLE PRODUCTS_COM DROP CONSTRAINT PRODUCTS_COM_FK_2; 
DROP TABLE PRODUCTS_COM;

CREATE TABLE PRODUCTS_COM (
    ID VARCHAR NOT NULL,
    PRODUCT VARCHAR NOT NULL,
    PRODUCT2 VARCHAR NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT PRODUCTS_COM_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID),
    CONSTRAINT PRODUCTS_COM_FK_2 FOREIGN KEY (PRODUCT2) REFERENCES PRODUCTS(ID)
);
CREATE UNIQUE INDEX PCOM_INX_PROD ON PRODUCTS_COM(PRODUCT, PRODUCT2);

INSERT INTO PRODUCTS_COM(ID, PRODUCT, PRODUCT2) SELECT ID, PRODUCT, PRODUCT2 FROM _PRODUCTS_COM;

DROP TABLE _PRODUCTS_COM;

ALTER TABLE TICKETS ADD COLUMN TICKETTYPE INTEGER DEFAULT 0 NOT NULL;
DROP INDEX TICKETS_TICKETID;
CREATE INDEX TICKETS_TICKETID ON TICKETS(TICKETTYPE, TICKETID);
UPDATE TICKETS SET TICKETTYPE = 1 WHERE ID IN (SELECT RECEIPT FROM PAYMENTS WHERE TOTAL<0);

CREATE SEQUENCE TICKETSNUM_REFUND START WITH 1;
CREATE SEQUENCE TICKETSNUM_PAYMENT START WITH 1;

ALTER TABLE PAYMENTS ADD COLUMN TRANSID VARCHAR;
ALTER TABLE PAYMENTS ADD COLUMN RETURNMSG BYTEA;

CREATE TABLE ATTRIBUTE (
    ID VARCHAR NOT NULL,
    NAME VARCHAR NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE ATTRIBUTEVALUE (
    ID VARCHAR NOT NULL,
    ATTRIBUTE_ID VARCHAR NOT NULL,
    VALUE VARCHAR,
    PRIMARY KEY (ID),
    CONSTRAINT ATTVAL_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID)
);

CREATE TABLE ATTRIBUTESET (
    ID VARCHAR NOT NULL,
    NAME VARCHAR NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE ATTRIBUTEUSE (
    ID VARCHAR NOT NULL,
    ATTRIBUTESET_ID VARCHAR NOT NULL,
    ATTRIBUTE_ID VARCHAR NOT NULL,
    LINENO INTEGER,
    PRIMARY KEY (ID),
    CONSTRAINT ATTUSE_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID),
    CONSTRAINT ATTUSE_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID)
);
CREATE UNIQUE INDEX ATTUSE_LINE ON ATTRIBUTEUSE(ATTRIBUTESET_ID, LINENO);

CREATE TABLE ATTRIBUTESETINSTANCE (
    ID VARCHAR NOT NULL,
    ATTRIBUTESET_ID VARCHAR NOT NULL,
    DESCRIPTION VARCHAR,
    PRIMARY KEY (ID),
    CONSTRAINT ATTSETINST_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID)
);

CREATE TABLE ATTRIBUTEINSTANCE (
    ID VARCHAR NOT NULL,
    ATTRIBUTESETINSTANCE_ID VARCHAR NOT NULL,
    ATTRIBUTE_ID VARCHAR NOT NULL,
    VALUE VARCHAR,
    PRIMARY KEY (ID),
    CONSTRAINT ATTINST_SET FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID),
    CONSTRAINT ATTINST_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID)
);

ALTER TABLE PRODUCTS ADD COLUMN ATTRIBUTESET_ID VARCHAR;
ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_ATTRSET_FK FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID);

ALTER TABLE STOCKDIARY ADD COLUMN ATTRIBUTESETINSTANCE_ID VARCHAR;
ALTER TABLE STOCKDIARY ADD CONSTRAINT STOCKDIARY_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID);

CREATE TABLE STOCKLEVEL (
    ID VARCHAR NOT NULL,
    LOCATION VARCHAR NOT NULL,
    PRODUCT VARCHAR NOT NULL,
    STOCKSECURITY DOUBLE PRECISION,
    STOCKMAXIMUM DOUBLE PRECISION,
    PRIMARY KEY (ID),
    CONSTRAINT STOCKLEVEL_PRODUCT FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID),
    CONSTRAINT STOCKLEVEL_LOCATION FOREIGN KEY (LOCATION) REFERENCES LOCATIONS(ID)
);

INSERT INTO STOCKLEVEL(ID, LOCATION, PRODUCT, STOCKSECURITY, STOCKMAXIMUM) SELECT LOCATION || PRODUCT, LOCATION, PRODUCT, STOCKSECURITY, STOCKMAXIMUM FROM STOCKCURRENT;

CREATE TABLE _STOCKCURRENT (
    LOCATION VARCHAR NOT NULL,
    PRODUCT VARCHAR NOT NULL,
    ATTRIBUTESETINSTANCE_ID VARCHAR,
    UNITS DOUBLE PRECISION NOT NULL
);

INSERT INTO _STOCKCURRENT(LOCATION, PRODUCT, UNITS) SELECT LOCATION, PRODUCT, UNITS FROM STOCKCURRENT;

ALTER TABLE STOCKCURRENT DROP CONSTRAINT STOCKCURRENT_FK_1;
ALTER TABLE STOCKCURRENT DROP CONSTRAINT STOCKCURRENT_FK_2;
DROP TABLE STOCKCURRENT;

CREATE TABLE STOCKCURRENT (
    LOCATION VARCHAR NOT NULL,
    PRODUCT VARCHAR NOT NULL,
    ATTRIBUTESETINSTANCE_ID VARCHAR,
    UNITS DOUBLE PRECISION NOT NULL,
    CONSTRAINT STOCKCURRENT_FK_1 FOREIGN KEY (PRODUCT) REFERENCES PRODUCTS(ID),
    CONSTRAINT STOCKCURRENT_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID),
    CONSTRAINT STOCKCURRENT_FK_2 FOREIGN KEY (LOCATION) REFERENCES LOCATIONS(ID)
);
CREATE UNIQUE INDEX STOCKCURRENT_INX ON STOCKCURRENT(LOCATION, PRODUCT, ATTRIBUTESETINSTANCE_ID);

INSERT INTO STOCKCURRENT(LOCATION, PRODUCT, UNITS) SELECT LOCATION, PRODUCT, UNITS FROM _STOCKCURRENT;

DROP TABLE _STOCKCURRENT;

ALTER TABLE TICKETLINES ADD COLUMN ATTRIBUTESETINSTANCE_ID VARCHAR;
ALTER TABLE TICKETLINES ADD CONSTRAINT TICKETLINES_ATTSETINST FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID);

-- v2.30beta - v2.30

ALTER TABLE ATTRIBUTEVALUE DROP CONSTRAINT ATTVAL_ATT;
ALTER TABLE ATTRIBUTEVALUE ADD CONSTRAINT ATTVAL_ATT FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTEUSE DROP CONSTRAINT ATTUSE_SET;
ALTER TABLE ATTRIBUTEUSE ADD CONSTRAINT ATTUSE_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTESETINSTANCE DROP CONSTRAINT ATTSETINST_SET;
ALTER TABLE ATTRIBUTESETINSTANCE ADD CONSTRAINT ATTSETINST_SET FOREIGN KEY (ATTRIBUTESET_ID) REFERENCES ATTRIBUTESET(ID) ON DELETE CASCADE;

ALTER TABLE ATTRIBUTEINSTANCE DROP CONSTRAINT ATTINST_SET;
ALTER TABLE ATTRIBUTEINSTANCE ADD CONSTRAINT ATTINST_SET FOREIGN KEY (ATTRIBUTESETINSTANCE_ID) REFERENCES ATTRIBUTESETINSTANCE(ID) ON DELETE CASCADE;

ALTER TABLE PRODUCTS ALTER COLUMN ISCOM SET DEFAULT FALSE;
ALTER TABLE PRODUCTS ALTER COLUMN ISSCALE SET DEFAULT FALSE;
ALTER TABLE TAXES ALTER COLUMN RATECASCADE SET DEFAULT FALSE;
ALTER TABLE CUSTOMERS ALTER COLUMN VISIBLE SET DEFAULT TRUE;

-- v2.30 - v2.30.1

ALTER TABLE TAXES ADD COLUMN VALIDFROM TIMESTAMP DEFAULT '2001-01-01 00:00:00' NOT NULL;

-- v2.30.1 - v2.30.2

-- final script

DELETE FROM SHAREDTICKETS;

UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};