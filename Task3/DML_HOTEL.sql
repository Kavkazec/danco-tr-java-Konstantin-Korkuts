use danco_hotel_korkuts;

INSERT INTO guest_model (guest_name) VALUES ('Kostya');
INSERT INTO guest_model (guest_name) VALUES ('Vasya');
INSERT INTO guest_model (guest_name) VALUES ('Pasha');
INSERT INTO guest_model (guest_name) VALUES ('Serega');
INSERT INTO guest_model (guest_name) VALUES ('Katya');
INSERT INTO guest_model (guest_name) VALUES ('Andrea');
INSERT INTO guest_model (guest_name) VALUES ('Jora');

INSERT INTO room_model (room_number, capasity, numberOfStars, coast, isFreeRoom, isOnRepair) VALUES ('122', 2, 3, 200, false, false);
INSERT INTO room_model (room_number, capasity, numberOfStars, coast, isFreeRoom, isOnRepair) VALUES ('220', 3, 5, 300, false, false);
INSERT INTO room_model (room_number, capasity, numberOfStars, coast, isFreeRoom, isOnRepair) VALUES ('210', 2, 3, 200, true, false);
INSERT INTO room_model (room_number, capasity, numberOfStars, coast, isFreeRoom, isOnRepair) VALUES ('211', 4, 4, 400, false, false);

INSERT INTO service_model (service_name, coast) VALUES ('Champagne in room',50);
INSERT INTO service_model (service_name, coast) VALUES ('Dinner',75);
INSERT INTO service_model (service_name, coast) VALUES ('Girls',8);

INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (1,1,'2015-12-15','2015-12-18');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (2,4,'2015-12-16','2015-12-25');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (3,4,'2015-12-15','2015-12-24');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (4,3,'2015-12-15','2015-12-24');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (5,3,'2015-12-15','2015-12-24');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (6,4,'2015-01-17','2015-12-19');
INSERT INTO room_guests (guest_ID, room_ID, date_arrive, date_departure) VALUES (6,2,'2015-01-17','2015-12-19');

INSERT INTO guest_services (guest_ID, service_ID) VALUES (1,3);
INSERT INTO guest_services (guest_ID, service_ID) VALUES (2,2);
INSERT INTO guest_services (guest_ID, service_ID) VALUES (3,1);