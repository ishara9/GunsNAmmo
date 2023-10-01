CREATE SCHEMA guns_schema;

CREATE TABLE GUN(
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    EMAIL varchar(500),
    SECURITY_KEY varchar(500),
    PRIMARY KEY (ID)
)