DROP DATABASE IF EXISTS KVMCAIRLINES;
CREATE DATABASE KVMCAIRLINES; 
USE KVMCAIRLINES;

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
	userid		int not null AUTO_INCREMENT,
    firstname	varchar(25),
	lastname	varchar(25),
    email		varchar(25),
	address 	varchar(25),
	primary key (userid)
);



DROP TABLE IF EXISTS REG_USERS;
CREATE TABLE REG_USERS (
	userid 			int,
	username		varchar(25),
	pass			varchar(25),
	registerid		int,
    email			varchar(25),
	address 		varchar(25),
    notifications	varchar(25),
	primary key (userid)
);



DROP TABLE IF EXISTS AGENTS;
CREATE TABLE AGENTS (
	userid		int,
	firstname	varchar(25),
	lastname	varchar(25),
	agentid		int,
	companyname varchar(25),
	primary key (userid)
);

#needs to add through the "login" interface

DROP TABLE IF EXISTS ADMINS;
CREATE TABLE ADMINS (
	adminID		int,
    username	varchar(25),
	pass		varchar(25),
	primary key (adminid)
);

INSERT INTO ADMINS(adminID, username, pass) VALUES
(0, "kenzy", "Kvmc#kenzy"),
(1, "vera", "kVmc#vera"),
(2, "meet", "kvMc#meet"),
(3, "chris", "kvmC#chris");

DROP TABLE IF EXISTS CREWS;
CREATE TABLE CREWS (
	crewID		int not null AUTO_INCREMENT,
    crewNum		int,
	primary key (crewID)
);
#should increment the crew number on its own, as it addes more crew to the database.
INSERT INTO CREWS(crewNum) VALUES
(1),
(2),
(3);

DROP TABLE IF EXISTS STAFFS;
CREATE TABLE STAFFS (
	staffID		int not null AUTO_INCREMENT,
    crewID		int,
	firstName 	varchar(25),
    lastName 	varchar(25),
	stafftype varchar(1),#A: attendant, P: pilot.
	primary key (staffID)
);

INSERT INTO STAFFS(crewID, firstName, lastName, stafftype) VALUES
(0, "John", "Smith", "P"),
(0, "Tyrion", "Dutch", "A"),
(1, "Kate", "Jackson", "P"),
(1, "Rebecca", "Scott", "A"),
(2, "Stacey", "Miller", "P"),
(2, "Bob", "Turner", "A");

DROP TABLE IF EXISTS FLIGHTS;
CREATE TABLE FLIGHTS (
	flightID		int not null AUTO_INCREMENT,
    flightName		varchar(25),
    destination		varchar(25),
    origin			varchar(25),
    date_leaves		date,
    aircraftID		int,
	crewID			int,
	primary key (flightID)

);

INSERT INTO FLIGHTS(flightName, destination, origin, date_leaves, aircraftID, crewID) VALUES
("WS1400", "Les Vegas", "Calgary", "2023-12-31", 0, 0),
("WS350", "Regina", "Calgary", "2023-12-16", 0, 0),
("AC8140", "Edmonton", "Calgary", "2023-12-31", 1, 1),
("WS676", "Toronto", "Calgary", "2023-12-16", 1, 1),
("AC225", "Vancouver", "Calgary", "2023-12-31", 2, 2),
("AC150", "Toronto", "Calgary", "2023-12-16", 2, 2);

DROP TABLE IF EXISTS BOOKING;
CREATE TABLE BOOKING (
	userID			int,
	flightID		int,
	seatID 			int,
	primary key (seatID, userID)
);

#program starts with empty BOOKING table. Needs to add through the Booking interface. 

DROP TABLE IF EXISTS SEATS;
CREATE TABLE SEATS(
	seatID 			int not null AUTO_INCREMENT,
    aircraftID		int,
    columnLetter	varchar(1),
    rowNumber		int,
    seatStatus		bool,#0 is False, 1 is True.
    seatType		varchar(1),#B: business, C: comfert, R: regular.
    primary key(seatID, aircraftID)
);

INSERT INTO SEATS(aircraftID, columnLetter, rowNumber, seatStatus, seatType) VALUES
(0, "B", 1, 0, "B"),
(0, "C", 1, 0, "B"),
(0, "B", 2, 0, "C"),
(0, "C", 2, 0, "C"),
(0, "D", 2, 0, "C"),
(0, "A", 3, 0, "R"),
(0, "B", 3, 0, "R"),
(0, "C", 3, 0, "R"),
(0, "D", 3, 0, "R"),
(0, "B", 4, 0, "R"),

(1, "B", 1, 0, "B"),
(1, "C", 1, 0, "B"),
(1, "B", 2, 0, "C"),
(1, "C", 2, 0, "C"),
(1, "D", 2, 0, "C"),
(1, "A", 3, 0, "R"),
(1, "B", 3, 0, "R"),
(1, "C", 3, 0, "R"),
(1, "D", 3, 0, "R"),
(1, "B", 4, 0, "R"),

(2, "B", 1, 0, "B"),
(2, "C", 1, 0, "B"),
(2, "B", 2, 0, "C"),
(2, "C", 2, 0, "C"),
(2, "D", 2, 0, "C"),
(2, "A", 3, 0, "R"),
(2, "B", 3, 0, "R"),
(2, "C", 3, 0, "R"),
(2, "D", 3, 0, "R"),
(2, "B", 4, 0, "R");

DROP TABLE IF EXISTS AIRCRAFTS;
CREATE TABLE AIRCRAFTS (
	aircraftID		int,
    model			varchar(25),
	primary key (aircraftID)

);
#Our interface will have to assign an int ID for aircraft depending on the number of aircrafts in the database.
INSERT INTO AIRCRAFTS(aircraftID, model) VALUES
(0, "Boeing 787"),
(1, "Boeing 777"),
(2, "Boeing B747");




