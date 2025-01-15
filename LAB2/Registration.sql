-- Create the database
CREATE DATABASE SampleDB;
GO

-- Use the database
USE SampleDB;
GO

-- Create the Registration table
CREATE TABLE Registration (
    UserName VARCHAR(30) NOT NULL PRIMARY KEY,
    Password VARCHAR(30) NOT NULL,
    LastName NVARCHAR(50) NOT NULL,
    isAdmin NVARCHAR(50) NOT NULL
);
GO

-- Insert data into the Registration table
INSERT INTO Registration (UserName, Password, LastName, isAdmin) VALUES
('U001', '123', 'Tom', 'TRUE'),  -- True is represented by 1 in SQL
('U002', '111', 'David', 'FALSE'), -- False is represented by 0 in SQL
('U003', '111', 'John', 'FALSE'),
('U004', '111', 'Marry', 'FALSE'),
('U005', '123', 'Kate', 'TRUE');
GO