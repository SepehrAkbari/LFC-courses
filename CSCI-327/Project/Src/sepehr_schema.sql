-- RESET
DROP DATABASE IF EXISTS VideoStore;
CREATE DATABASE VideoStore;

-- USING
USE VideoStore;

-- Store Table
CREATE TABLE Store (
    Store_ID INT PRIMARY KEY AUTO_INCREMENT,
    Address VARCHAR(255) UNIQUE NOT NULL,
    Phone VARCHAR(15) UNIQUE NOT NULL
);

-- Member Table
CREATE TABLE Member (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Role VARCHAR(20) NOT NULL CHECK (Role IN ('Customer', 'Admin')),
    Num_disks_rented INT DEFAULT 0 CHECK (Num_disks_rented <= 10),
    Player_rented BOOLEAN
);

-- Movie Table
CREATE TABLE Movie (
    Movie_ID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255) NOT NULL,
    Genre VARCHAR(50),
    Producer VARCHAR(100),
    Director VARCHAR(100),
    Actor1 VARCHAR(100),
    Actor2 VARCHAR(100),
    Num_DVD INT DEFAULT 0,
    Num_Blu INT DEFAULT 0
);

-- Player Table
CREATE TABLE Player (
    Player_ID INT PRIMARY KEY AUTO_INCREMENT
);

-- Store_Object Table
CREATE TABLE Store_Object (
    Object_ID INT PRIMARY KEY AUTO_INCREMENT,
    Store_ID INT NOT NULL,
    Movie_ID INT, 
    Player_ID INT,
    Charge_per_day DECIMAL(5, 2) DEFAULT 2.00,
    Rental_period INT DEFAULT 3,
    Type VARCHAR(20) NOT NULL CHECK (Type IN ('DVD', 'Blu-Ray')),
    FOREIGN KEY (Store_ID) REFERENCES Store(Store_ID),
    FOREIGN KEY (Movie_ID) REFERENCES Movie(Movie_ID),
    FOREIGN KEY (Player_ID) REFERENCES Player (Player_ID),
    CHECK(
        (Movie_ID IS NOT NULL AND Player_ID IS NULL) OR
        (Movie_ID IS NULL AND Player_ID IS NOT NULL)
    )
);

-- Transaction Table
CREATE TABLE Transaction (
    Trans_ID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT NOT NULL,
    Object_ID INT NOT NULL,
    Store_ID INT NOT NULL,
    Start_date DATE NOT NULL,
    End_date DATE,
    Type VARCHAR(20) NOT NULL CHECK (Type IN ('Rental', 'Reservation')),
    Status VARCHAR(20) NOT NULL CHECK (Status IN ('Active', 'Completed', 'Reserved')),
    Price DECIMAL(10, 2) DEFAULT 0.00,
    FOREIGN KEY (UserID) REFERENCES Member(UserID),
    FOREIGN KEY (Object_ID) REFERENCES Store_Object(Object_ID),
    FOREIGN Key (Store_ID) REFERENCES Store (Store_ID)
);

-- Disk Table
CREATE TABLE Disk (
    Disk_ID INT PRIMARY KEY AUTO_INCREMENT,
    Movie_ID INT,
    FOREIGN KEY (Movie_ID) REFERENCES Movie(Movie_ID)
);

-- Indexes
CREATE INDEX idx_movie_title ON Movie(Title);
CREATE INDEX idx_movie_genre ON Movie(Genre);
CREATE INDEX idx_movie_director ON Movie(Director);
CREATE INDEX idx_transaction_userid ON Transaction(UserID);