CREATE TABLE book
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) DEFAULT NULL,
    description VARCHAR(255) DEFAULT NULL,
    unitcost float DEFAULT NULL,
    isbn VARCHAR(255) DEFAULT NULL,
    nbOfPage INTEGER DEFAULT NULL
);