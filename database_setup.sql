-- Electricity Billing System Database Setup
-- Run this script in MySQL Workbench

-- Create database
CREATE DATABASE IF NOT EXISTS system_bills;

-- Use the database
USE system_bills;


-- Create Signup table for user registration
CREATE TABLE IF NOT EXISTS Signup (
    meter_no VARCHAR(20),
    username VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    usertype VARCHAR(20) NOT NULL
);

-- Verify table creation
SHOW TABLES;

-- Optional: Insert a test admin user
-- INSERT INTO Signup (meter_no, username, name, password, usertype) 
-- VALUES ('', 'admin', 'Administrator', 'admin123', 'Admin');
