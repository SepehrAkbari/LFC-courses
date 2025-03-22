-- File: populate_videostore_final.sql
-- Purpose: Populate the updated VideoStore database with sample data for testing

-- Ensure we're using the correct database
USE VideoStore;

-- Insert into Store (3 stores)
INSERT INTO Store (Address, Phone) VALUES
    ('123 Main St, City A, CA 90001', '555-0101'),
    ('456 Oak Ave, City B, CA 90002', '555-0102'),
    ('789 Pine Rd, City C, CA 90003', '555-0103');

-- Insert into Member (8 customers, 2 admins)
INSERT INTO Member (Name, Address, Password, Role, Num_disks_rented, Player_rented) VALUES
    ('John Doe', '101 Elm St, City A, CA 90001', 'pass123', 'Customer', 0, FALSE),
    ('Jane Smith', '202 Birch St, City A, CA 90001', 'pass456', 'Customer', 0, FALSE),
    ('Alice Johnson', '303 Cedar St, City B, CA 90002', 'pass789', 'Customer', 0, FALSE),
    ('Bob Brown', '404 Maple St, City B, CA 90002', 'pass101', 'Customer', 0, FALSE),
    ('Charlie Davis', '505 Willow St, City C, CA 90003', 'pass202', 'Customer', 0, FALSE),
    ('Diana Evans', '606 Ash St, City C, CA 90003', 'pass303', 'Customer', 0, FALSE),
    ('Eve Foster', '707 Spruce St, City A, CA 90001', 'pass404', 'Customer', 0, FALSE),
    ('Frank Green', '808 Pine St, City B, CA 90002', 'pass505', 'Customer', 0, FALSE),
    ('Admin One', '123 Admin Rd, City A, CA 90001', 'admin123', 'Admin', 0, FALSE),
    ('Admin Two', '456 Admin Rd, City B, CA 90002', 'admin456', 'Admin', 0, FALSE);

-- Insert into Movie (15 movies)
-- Num_DVD and Num_Blu will be updated after inserting Store_Object
INSERT INTO Movie (Title, Genre, Producer, Director, Actor1, Actor2, Num_DVD, Num_Blu) VALUES
    ('The Sci-Fi Adventure', 'Sci-Fi', 'Star Studios', 'Jane Director', 'Tom Star', 'Emma Lead', 0, 0),
    ('Romantic Getaway', 'Romance', 'Love Productions', 'John Romance', 'Sarah Love', 'Mike Heart', 0, 0),
    ('Action Explosion', 'Action', 'Boom Studios', 'Alex Action', 'Chris Boom', 'Lisa Fire', 0, 0),
    ('Mystery Manor', 'Mystery', 'Clue Films', 'Mystery Mike', 'Nancy Sleuth', 'John Clue', 0, 0),
    ('Comedy Night', 'Comedy', 'Laugh Factory', 'Funny Fred', 'Jim Laugh', 'Amy Giggle', 0, 0),
    ('Space Odyssey', 'Sci-Fi', 'Galaxy Films', 'Space Sally', 'Mark Orbit', 'Luna Star', 0, 0),
    ('Love in Paris', 'Romance', 'Heart Studios', 'Paris Paul', 'Ella Rose', 'Liam Charm', 0, 0),
    ('Thriller Night', 'Thriller', 'Suspense Studios', 'Thrill Tim', 'Kate Fear', 'Sam Edge', 0, 0),
    ('Western Duel', 'Western', 'Cowboy Productions', 'West Wendy', 'Clint Saddle', 'Jane Rider', 0, 0),
    ('Fantasy Quest', 'Fantasy', 'Magic Realm', 'Fantasy Fiona', 'Gandalf Magic', 'Elfie Spark', 0, 0),
    ('Horror House', 'Horror', 'Scare Studios', 'Horror Hannah', 'Ghost Gabe', 'Scream Sara', 0, 0),
    ('Drama Days', 'Drama', 'Tear Productions', 'Drama Dan', 'Sad Sam', 'Cry Cindy', 0, 0),
    ('Superhero Saga', 'Action', 'Hero Studios', 'Hero Henry', 'Cape Carl', 'Power Pam', 0, 0),
    ('Animated Adventure', 'Animation', 'Cartoon Co', 'Toon Tina', 'Mickey Toon', 'Minnie Magic', 0, 0),
    ('Historical Epic', 'History', 'Past Productions', 'History Helen', 'King Leo', 'Queen Mary', 0, 0);

-- Insert into Player (5 players)
INSERT INTO Player () VALUES
    (), -- Player 1
    (), -- Player 2
    (), -- Player 3
    (), -- Player 4
    (); -- Player 5

-- Insert into Store_Object (40 movie copies + 5 players = 45 entries)
-- Movie copies have Movie_ID set and Player_ID as NULL
-- Players have Player_ID set and Movie_ID as NULL
-- Type is 'DVD' or 'Blu-Ray' for movie copies; set to 'DVD' for players to satisfy the CHECK constraint
INSERT INTO Store_Object (Store_ID, Movie_ID, Player_ID, Charge_per_day, Rental_period, Type) VALUES
    (1, 1, NULL, 2.50, 3, 'DVD'), (1, 1, NULL, 2.50, 3, 'DVD'), (2, 1, NULL, 3.00, 3, 'Blu-Ray'), -- Sci-Fi Adventure: 2 DVDs, 1 Blu-Ray
    (1, 2, NULL, 2.00, 3, 'DVD'), (2, 2, NULL, 2.00, 3, 'DVD'), -- Romantic Getaway: 2 DVDs
    (2, 3, NULL, 3.00, 3, 'Blu-Ray'), (3, 3, NULL, 2.50, 3, 'DVD'), (3, 3, NULL, 2.50, 3, 'DVD'), -- Action Explosion: 1 Blu-Ray, 2 DVDs
    (1, 4, NULL, 2.50, 3, 'DVD'), (3, 4, NULL, 2.75, 3, 'Blu-Ray'), (3, 4, NULL, 2.75, 3, 'Blu-Ray'), -- Mystery Manor: 1 DVD, 2 Blu-Ray
    (2, 5, NULL, 1.50, 3, 'DVD'), (3, 5, NULL, 1.50, 3, 'DVD'), -- Comedy Night: 2 DVDs
    (1, 6, NULL, 3.50, 5, 'Blu-Ray'), (2, 6, NULL, 3.00, 3, 'DVD'), (3, 6, NULL, 3.00, 3, 'DVD'), -- Space Odyssey: 1 Blu-Ray, 2 DVDs
    (1, 7, NULL, 2.00, 3, 'DVD'), (2, 7, NULL, 2.00, 3, 'DVD'), -- Love in Paris: 2 DVDs
    (1, 8, NULL, 2.75, 3, 'Blu-Ray'), (3, 8, NULL, 2.50, 3, 'DVD'), (3, 8, NULL, 2.50, 3, 'DVD'), -- Thriller Night: 1 Blu-Ray, 2 DVDs
    (2, 9, NULL, 2.25, 3, 'DVD'), (3, 9, NULL, 2.25, 3, 'DVD'), -- Western Duel: 2 DVDs
    (1, 10, NULL, 3.00, 3, 'Blu-Ray'), (2, 10, NULL, 2.75, 3, 'DVD'), (3, 10, NULL, 2.75, 3, 'DVD'), -- Fantasy Quest: 1 Blu-Ray, 2 DVDs
    (1, 11, NULL, 2.50, 3, 'DVD'), (2, 11, NULL, 2.50, 3, 'DVD'), -- Horror House: 2 DVDs
    (1, 12, NULL, 2.00, 3, 'DVD'), (3, 12, NULL, 2.00, 3, 'DVD'), -- Drama Days: 2 DVDs
    (2, 13, NULL, 3.25, 3, 'Blu-Ray'), (3, 13, NULL, 3.00, 3, 'DVD'), (3, 13, NULL, 3.00, 3, 'DVD'), -- Superhero Saga: 1 Blu-Ray, 2 DVDs
    (1, 14, NULL, 1.75, 3, 'DVD'), (2, 14, NULL, 1.75, 3, 'DVD'), -- Animated Adventure: 2 DVDs
    (1, 15, NULL, 3.00, 3, 'Blu-Ray'), (1, 15, NULL, 2.75, 3, 'DVD'), (3, 15, NULL, 2.75, 3, 'DVD'), -- Historical Epic: 1 Blu-Ray, 2 DVDs
    (1, NULL, 1, 5.00, 7, 'DVD'), -- Player 1 (Store 1)
    (1, NULL, 2, 5.00, 7, 'DVD'), -- Player 2 (Store 1)
    (2, NULL, 3, 5.00, 7, 'DVD'), -- Player 3 (Store 2)
    (2, NULL, 4, 5.00, 7, 'DVD'), -- Player 4 (Store 2)
    (3, NULL, 5, 5.00, 7, 'DVD'); -- Player 5 (Store 3)

-- Update Movie.Num_DVD and Num_Blu based on Store_Object entries
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 1 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 1 AND Type = 'Blu-Ray') WHERE Movie_ID = 1;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 2 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 2 AND Type = 'Blu-Ray') WHERE Movie_ID = 2;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 3 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 3 AND Type = 'Blu-Ray') WHERE Movie_ID = 3;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 4 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 4 AND Type = 'Blu-Ray') WHERE Movie_ID = 4;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 5 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 5 AND Type = 'Blu-Ray') WHERE Movie_ID = 5;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 6 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 6 AND Type = 'Blu-Ray') WHERE Movie_ID = 6;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 7 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 7 AND Type = 'Blu-Ray') WHERE Movie_ID = 7;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 8 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 8 AND Type = 'Blu-Ray') WHERE Movie_ID = 8;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 9 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 9 AND Type = 'Blu-Ray') WHERE Movie_ID = 9;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 10 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 10 AND Type = 'Blu-Ray') WHERE Movie_ID = 10;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 11 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 11 AND Type = 'Blu-Ray') WHERE Movie_ID = 11;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 12 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 12 AND Type = 'Blu-Ray') WHERE Movie_ID = 12;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 13 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 13 AND Type = 'Blu-Ray') WHERE Movie_ID = 13;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 14 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 14 AND Type = 'Blu-Ray') WHERE Movie_ID = 14;
UPDATE Movie SET Num_DVD = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 15 AND Type = 'DVD'), Num_Blu = (SELECT COUNT(*) FROM Store_Object WHERE Movie_ID = 15 AND Type = 'Blu-Ray') WHERE Movie_ID = 15;

-- Insert into Disk (50 disks, distributed across movies based on total copies)
-- Each movie gets 2-4 disks, roughly proportional to Num_DVD + Num_Blu
INSERT INTO Disk (Movie_ID) VALUES
    (1), (1), (1), (1), -- Sci-Fi Adventure: 4 disks (3 copies)
    (2), (2), (2), -- Romantic Getaway: 3 disks (2 copies)
    (3), (3), (3), (3), -- Action Explosion: 4 disks (3 copies)
    (4), (4), (4), (4), -- Mystery Manor: 4 disks (3 copies)
    (5), (5), (5), -- Comedy Night: 3 disks (2 copies)
    (6), (6), (6), (6), -- Space Odyssey: 4 disks (3 copies)
    (7), (7), (7), -- Love in Paris: 3 disks (2 copies)
    (8), (8), (8), (8), -- Thriller Night: 4 disks (3 copies)
    (9), (9), (9), -- Western Duel: 3 disks (2 copies)
    (10), (10), (10), (10), -- Fantasy Quest: 4 disks (3 copies)
    (11), (11), (11), -- Horror House: 3 disks (2 copies)
    (12), (12), (12), -- Drama Days: 3 disks (2 copies)
    (13), (13), (13), (13), -- Superhero Saga: 4 disks (3 copies)
    (14), (14), (14), -- Animated Adventure: 3 disks (2 copies)
    (15), (15), (15), (15); -- Historical Epic: 4 disks (3 copies)

-- Insert into Transaction (20 transactions, mix of rentals and reservations for movies and players)
-- Price is calculated as: Charge_per_day * (End_date - Start_date) for completed rentals
-- Store_ID is taken from the Store_Object entry for the Object_ID
INSERT INTO Transaction (UserID, Object_ID, Store_ID, Start_date, End_date, Type, Status, Price) VALUES
    (1, 3, 2, '2025-03-01', '2025-03-05', 'Rental', 'Completed', 12.00), -- John rents Sci-Fi Adventure Blu-Ray (4 days * $3.00)
    (1, 6, 2, '2025-03-10', NULL, 'Rental', 'Active', 0.00), -- John rents Action Explosion Blu-Ray (active)
    (2, 10, 3, '2025-03-02', NULL, 'Reservation', 'Reserved', 0.00), -- Jane reserves Mystery Manor Blu-Ray
    (2, 17, 1, '2025-03-05', '2025-03-08', 'Rental', 'Completed', 6.00), -- Jane rents Love in Paris DVD (3 days * $2.00)
    (3, 14, 1, '2025-03-03', NULL, 'Rental', 'Active', 0.00), -- Alice rents Space Odyssey Blu-Ray (active)
    (3, 19, 1, '2025-03-01', '2025-03-04', 'Rental', 'Completed', 8.25), -- Alice rents Thriller Night Blu-Ray (3 days * $2.75)
    (4, 24, 1, '2025-03-05', NULL, 'Rental', 'Active', 0.00), -- Bob rents Fantasy Quest Blu-Ray (active)
    (4, 27, 1, '2025-03-02', NULL, 'Reservation', 'Reserved', 0.00), -- Bob reserves Horror House DVD
    (5, 31, 2, '2025-03-04', NULL, 'Rental', 'Active', 0.00), -- Charlie rents Superhero Saga Blu-Ray (active)
    (5, 36, 1, '2025-03-01', '2025-03-06', 'Rental', 'Completed', 15.00), -- Charlie rents Historical Epic Blu-Ray (5 days * $3.00)
    (6, 12, 2, '2025-03-03', '2025-03-05', 'Rental', 'Completed', 3.00), -- Diana rents Comedy Night DVD (2 days * $1.50)
    (6, 16, 2, '2025-03-06', NULL, 'Rental', 'Active', 0.00), -- Diana rents Space Odyssey DVD (active)
    (7, 7, 3, '2025-03-02', '2025-03-04', 'Rental', 'Completed', 5.00), -- Eve rents Action Explosion DVD (2 days * $2.50)
    (7, 41, 1, '2025-03-05', NULL, 'Rental', 'Active', 0.00), -- Eve rents Player 1 (active)
    (8, 8, 3, '2025-03-01', '2025-03-03', 'Rental', 'Completed', 5.00), -- Frank rents Action Explosion DVD (2 days * $2.50)
    (8, 22, 2, '2025-03-04', NULL, 'Reservation', 'Reserved', 0.00), -- Frank reserves Western Duel DVD
    (1, 28, 1, '2025-03-06', NULL, 'Rental', 'Active', 0.00), -- John rents Horror House DVD (active)
    (2, 29, 1, '2025-03-03', '2025-03-05', 'Rental', 'Completed', 4.00), -- Jane rents Drama Days DVD (2 days * $2.00)
    (3, 32, 3, '2025-03-02', NULL, 'Rental', 'Active', 0.00), -- Alice rents Superhero Saga DVD (active)
    (4, 43, 2, '2025-03-01', '2025-03-08', 'Rental', 'Completed', 35.00); -- Bob rents Player 3 (7 days * $5.00)

-- Update Member.Num_disks_rented and Player_rented based on active rentals
UPDATE Member SET Num_disks_rented = 2, Player_rented = FALSE WHERE UserID = 1; -- John: 2 active movie rentals
UPDATE Member SET Num_disks_rented = 0, Player_rented = FALSE WHERE UserID = 2; -- Jane: No active rentals
UPDATE Member SET Num_disks_rented = 2, Player_rented = FALSE WHERE UserID = 3; -- Alice: 2 active movie rentals
UPDATE Member SET Num_disks_rented = 1, Player_rented = FALSE WHERE UserID = 4; -- Bob: 1 active movie rental
UPDATE Member SET Num_disks_rented = 1, Player_rented = FALSE WHERE UserID = 5; -- Charlie: 1 active movie rental
UPDATE Member SET Num_disks_rented = 1, Player_rented = FALSE WHERE UserID = 6; -- Diana: 1 active movie rental
UPDATE Member SET Num_disks_rented = 0, Player_rented = TRUE WHERE UserID = 7; -- Eve: 1 active player rental
UPDATE Member SET Num_disks_rented = 0, Player_rented = FALSE WHERE UserID = 8; -- Frank: No active rentals
UPDATE Member SET Num_disks_rented = 0, Player_rented = FALSE WHERE UserID = 9; -- Admin One
UPDATE Member SET Num_disks_rented = 0, Player_rented = FALSE WHERE UserID = 10; -- Admin Two