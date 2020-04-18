#create script
CREATE DATABASE MEMBER;

#create table
CREATE TABLE MYTABLE (
  id int(11) NOT NULL AUTO_INCREMENT,
  username char(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  passwd char(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  systime datetime NULL DEFAULT NULL,
  PRIMARY KEY (id)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;
