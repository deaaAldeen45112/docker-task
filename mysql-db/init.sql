CREATE DATABASE IF NOT EXISTS video_db;
USE video_db;

CREATE TABLE video (
    id INT AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT,
    filesize BIGINT NOT NULL,
    path VARCHAR(255) NOT NULL,
    upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);