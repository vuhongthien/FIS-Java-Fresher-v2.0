CREATE TABLE EMPLOYEE (
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(100) NOT NULL,
SALARY DECIMAL(15, 2) NOT NULL,
CREATED_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (ID) );