CREATE DATABASE IF NOT EXISTS danco_hotel_korkuts;

USE danco_hotel_korkuts;


CREATE TABLE IF NOT EXISTS guest_model(
   id INT NOT NULL PRIMARY KEY,
   guest_name VARCHAR(30) NOT NULL,
   dateOfAdd DATE NOT NULL,
   dateOfEvi DATE NOT NULL,
   service_name VARCHAR(30) NULL,
   FOREIGN KEY (service_name) REFERENCES service_model(service_name)
);

CREATE TABLE IF NOT EXISTS room_model(
    room_number INT NOT NULL PRIMARY KEY,
	capasity INT NOT NULL,
	numberOfStars INT NOT NULL,
	coast INT NOT NULL,
	isFreeRoom BOOLEAN NOT NULL,
	isOnRepair BOOLEAN NOT NULL,
	guest_id INT NULL,
	FOREIGN KEY (guest_id) REFERENCES guest_model(id)
);

CREATE TABLE IF NOT EXISTS service_model(
    service_name VARCHAR(30) NOT NULL PRIMARY KEY,
	coast INT NOT NULL 
);
