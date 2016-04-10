CREATE TABLE millpix.Users(
    username        VARCHAR(30),
    firstname       VARCHAR(30),
    lastname        VARCHAR(30),
    email           VARCHAR(40),
    password        VARCHAR(60),
    confirmed       BOOLEAN,
    datecreated     DATE,
    pixelsbought    INTEGER
);