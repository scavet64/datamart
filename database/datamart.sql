DROP DATABASE IF EXISTS datamart;
DROP USER IF EXISTS 'datamart'@'localhost';
CREATE DATABASE datamart;
CREATE USER 'datamart'@'localhost' IDENTIFIED BY 'datamartPassword';
GRANT ALL PRIVILEGES ON datamart.* TO 'datamart'@'localhost';
USE datamart;

CREATE TABLE store (
	store_id INT PRIMARY KEY NOT NULL,
    manager VARCHAR(255) NOT NULL,
    street_address VARCHAR(255) NOT NULL,
    town VARCHAR(255) NOT NULL,
    zip VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL
)Engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO store(store_id, manager, street_address, town, zip, phone_number, state) VALUES(10, "Eric Lynn", "8679 Pennington Rd", "Somerset", "08873", "0000000000", "NJ");
INSERT INTO store(store_id, manager, street_address, town, zip, phone_number, state) VALUES(11, "Phillip Quinn", "27 Walt Whitman Ave", "Springfield", "19064", "1111111111", "PA");
INSERT INTO store(store_id, manager, street_address, town, zip, phone_number, state) VALUES(12, "Joe Scavetta", "501 Green Hill St", "Blackwood", "08012", "2222222222", "NJ");
INSERT INTO store(store_id, manager, street_address, town, zip, phone_number, state) VALUES(13, "Thomas Smyth", "8761 Orchard Lane", "Bloomfield", "07003", "3333333333", "NJ");
            
CREATE TABLE date_dimension (
	date_id INT PRIMARY KEY NOT NULL,
    date DATETIME NOT NULL,
    day_number_in_month INT NOT NULL,
    day_number_in_year INT NOT NULL,
    week_number_in_year INT NOT NULL,
    month_num INT NOT NULL,
    month_txt VARCHAR(255) NOT NULL,
    quarter INT NOT NULL,
    year INT NOT NULL,
    fiscal_year INT NOT NULL,
    is_holiday BOOL NOT NULL,
    is_weekend BOOL NOT NULL,
    season VARCHAR(255) NOT NULL
)Engine=InnoDB DEFAULT CHARSET=utf8;
