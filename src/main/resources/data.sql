DROP TABLE IF EXISTS USER_AUTH;
CREATE TABLE USER_AUTH (
USER_ID BIGINT NOT NULL,
FIRST_NAME VARCHAR(50) NOT NULL,
LAST_NAME VARCHAR(50) NOT NULL,
EMAIL_ID VARCHAR(50) NOT NULL,
CONTACT_NO VARCHAR(50) NOT NULL,
PASSWORD VARCHAR(50) NOT NULL
);

INSERT INTO USER_AUTH (USER_ID,FIRST_NAME, LAST_NAME, EMAIL_ID,CONTACT_NO, PASSWORD) VALUES
  (1,'Sukanya', 'M', 'sukanya123@gmail.com','9123456789','pass@123');