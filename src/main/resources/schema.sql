
CREATE USER 'ohgiraffers'@'%' IDENTIFIED BY 'ohgiraffers';

-- 현재 존재하는 데이터베이스 확인
SHOW databases;

-- mysql 데이터베이스로 계정 정보 확인하기
USE mysql;

SELECT * FROM USER;
DROP DATABASE projectdb;
CREATE DATABASE projectdb;

GRANT ALL PRIVILEGES ON projectdb.* TO 'ohgiraffers'@'%';

SHOW GRANTS FOR 'ohgiraffers'@'%';

USE projectdb;

DROP TABLE comment;
DROP TABLE post;
DROP TABLE board;


CREATE TABLE board (
                       board_id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       user_active BOOLEAN,
                       admin_active BOOLEAN
);


CREATE TABLE post (
                      post_id INT PRIMARY KEY AUTO_INCREMENT,
                      board_id INT NOT NULL,
                      author_id VARCHAR(255) NOT NULL,
                      password VARCHAR(255),
                      title VARCHAR(255) NOT NULL,
                      content TEXT,
                      view_count INT DEFAULT 0,
                      ip_hash VARCHAR(255),
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      attachment_url VARCHAR(500),
                      thumbnail_url VARCHAR(500),
                      access_level INT DEFAULT 0,
                      status VARCHAR(50),
                      is_notice BOOLEAN DEFAULT FALSE,
                      is_secret BOOLEAN DEFAULT FALSE,
                      FOREIGN KEY (board_id) REFERENCES board(board_id)
);
select * from post;
CREATE TABLE comment (
                         comment_id INT PRIMARY KEY AUTO_INCREMENT,
                         post_id INT NOT NULL,
                         author_id  VARCHAR(255) NOT NULL,
                         password VARCHAR(255),
                         content TEXT NOT NULL,
                         ip_hash VARCHAR(255),
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                         updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (post_id) REFERENCES post(post_id)
);
select * from comment;