INSERT INTO author (author_id, name, nationality) values (1, 'Clayton M. Christensen', 'American');
INSERT INTO author (author_id, name, nationality) values (2, 'Yuval Noah Harari', 'Israeli');
INSERT INTO author (author_id, name, nationality) values (3, 'Eric Ries', 'American');
INSERT INTO author (author_id, name, nationality) values (4, 'Daniel Kahneman', 'Israeli and American');
INSERT INTO author (author_id, name, nationality) values (5, 'Peter Thiel', 'American');
INSERT INTO author (author_id, name, nationality) values (6, 'Michael Lewis', 'American');
INSERT INTO author (author_id, name, nationality) values (7, 'Daniel Drescher', 'German');
INSERT INTO author (author_id, name, nationality) values (8, 'Hans Rosling', 'Swedish');
INSERT INTO author (author_id, name, nationality) values (9, 'Ola Rosling', 'Swedish');
INSERT INTO author (author_id, name, nationality) values (10, 'Anna Rosling Rönnlund', 'Swedish');
INSERT INTO author (author_id, name, nationality) values (11, 'Saifedean Ammous', 'Lebanese');
INSERT INTO author (author_id, name, nationality) values (12, 'Robert Iger', 'American');

INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (1, '1997', '1997', 'The Innovator\'s Dilemma', 'The Innovator\'s Dilemma');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (2, '2014', '2011', 'Sapiens: A Brief History of Humankind', 'Sapiens: A Brief History of Humankind');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (3, '2011', '2011', 'The Lean Startup', 'The Lean Startup');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (4, '2011', '2011', 'Thinking, Fast and Slow', 'Thinking, Fast and Slow');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (5, '2014', '2014', 'Zero to One', 'Zero to One: Notes on Startups, or How to Build the Future');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (6, '2014', '2014', 'Flash Boys', 'Flash Boys: A Wall Street Revolt');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (7, '2017', '2017', 'Blockchain Basics', 'Blockchain Basics: A Non-Technical Introduction in 25 Steps');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (8, '2018', '2018', 'Factfulness', 'Factfulness: Ten Reasons We\'re Wrong About the World – and Why Things Are Better Than You Think');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (9, '2018', '2018', 'The Bitcoin Standard', 'The Bitcoin Standard: The Decentralized Alternative to Central Banking');
INSERT INTO book (book_id, exhibition_date, publication_date, descripton, name) values (10, '2019', '2019', 'The Ride of a Lifetime', 'The Ride of a Lifetime: Lessons Learned from 15 Years as CEO of the Walt Disney Company');

INSERT INTO book_author (book_id, author_id) values (1, 1),(2, 2),(3, 3),(4, 4),(5, 5),(6, 6),(7, 7),(8, 8),(8, 9),(8, 10),(9, 11),(10, 12);