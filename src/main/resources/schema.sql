DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;

DROP TABLE IF EXISTS board;
CREATE TABLE board (
            board_Id INT PRIMARY KEY,
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

-- 1. створити колонку: POST /api/column/create
-- {
--     "columnName": "columnName123",
--     "columnOrder": "1"
-- }
--
-- 2.отримати колонку по id: GET /api/column/1
--
-- 3 оновити колонку: PUT /api/column/update/1
-- {
--     "columnName" : "columnNameUpdated4"
-- }
--
-- 4 оновити чергу колонки по id: PUT /api/column/update/order/1
-- {
--     "columnOrder" : 2
-- }
--
-- 5 видалити колонку по id DELETE /api/column/1
--
-- 6 отримати всi колонки: GET /api/column/getAll
--
-- 7 створити задачу: POST /api/task/create
-- {
--      "taskName": "task180194",
--     "taskDescription": "task180194 task180194 task180194",
--     "taskOrder": 1,
--     "fkTask": 1
-- }
--
-- 8 отримати задачу по id: GET /api/task/1
--
-- 9 оновити задачу по id: PUT /api/task/update/1
-- {
--      "taskName": "taskUpdated",
--      "taskDescription": "taskUpdated"
-- }
--
-- 10 оновити чергу задачi по id: PUT /api/task/update/order/1
-- {
--     "taskOrder": 2
-- }
--
-- 11 оновити задачу в колонцi по id: PUT /api/task/update/column/1
--
-- 12 видалити задачу по id: DELETE /api/task/1
--
-- 13 отримати всi задачi: GET /api/task/getAll




