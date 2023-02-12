DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;

DROP TABLE IF EXISTS board;
CREATE TABLE board (
            board_Id INT AUTO_INCREMENT PRIMARY KEY,
            board_name VARCHAR(255) DEFAULT NULL
)ENGINE=INNODB;

DROP TABLE IF EXISTS column1;
CREATE TABLE column1 (
            column_Id INT AUTO_INCREMENT PRIMARY KEY,
            column_name VARCHAR(255) DEFAULT NULL,
            column_order INT DEFAULT NULL,
            fk_column INT REFERENCES board(board_Id) ON DELETE CASCADE
)ENGINE=INNODB;

DROP TABLE IF EXISTS task;
CREATE TABLE task (
            task_Id INT AUTO_INCREMENT PRIMARY KEY,
            task_name VARCHAR(255) DEFAULT NULL,
            task_description VARCHAR(10000) DEFAULT NULL,
            task_date VARCHAR(255) DEFAULT NULL,
            task_order INT DEFAULT NULL,
            fk_task INT REFERENCES column1(column_Id) ON DELETE CASCADE
)ENGINE=INNODB;