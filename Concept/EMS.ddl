CREATE DATABASE IF NOT EXISTS ems;
use ems;

CREATE TABLE IF NOT EXISTS student (id int(10) NOT NULL AUTO_INCREMENT, steward tinyint NOT NULL, groupe_id int(10) NOT NULL, user_id int(10) NOT NULL, interests varchar(100), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS lecturer (id int(10) NOT NULL AUTO_INCREMENT, pulpit_id int(10) NOT NULL, user_id int(10) NOT NULL, education varchar(50), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS subject (id int(10) NOT NULL AUTO_INCREMENT, title varchar(30) NOT NULL, lecturer_id int(10) NOT NULL, book_id int(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS groupe (id int(10) NOT NULL AUTO_INCREMENT, title varchar(20) NOT NULL UNIQUE, pulpit_id int(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS pulpit (id int(10) NOT NULL AUTO_INCREMENT, title varchar(20) NOT NULL UNIQUE, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS verification (id int(10) NOT NULL AUTO_INCREMENT, student_id int(10) NOT NULL, subject_id int(10) NOT NULL, score int(2) NOT NULL, semestr int(2) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS user (id int(10) NOT NULL AUTO_INCREMENT, full_name varchar(30) NOT NULL, password varchar(15) NOT NULL, role varchar(20) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS lecture (id int(10) NOT NULL AUTO_INCREMENT, subject_id int(10) NOT NULL, type varchar(20) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS schedule (id int(10) NOT NULL AUTO_INCREMENT, lecture_id int(10) NOT NULL, groupe_id int(10) NOT NULL, date date NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS book (id int(10) NOT NULL AUTO_INCREMENT, title varchar(50) NOT NULL, author varchar(50) NOT NULL, pages int(4), PRIMARY KEY (id));
ALTER TABLE groupe ADD INDEX FKgroupe535444 (pulpit_id), ADD CONSTRAINT FKgroupe535444 FOREIGN KEY (pulpit_id) REFERENCES pulpit (id);
ALTER TABLE verification ADD INDEX FKverificati47265 (subject_id), ADD CONSTRAINT FKverificati47265 FOREIGN KEY (subject_id) REFERENCES subject (id);
ALTER TABLE verification ADD INDEX FKverificati997460 (student_id), ADD CONSTRAINT FKverificati997460 FOREIGN KEY (student_id) REFERENCES student (id);
ALTER TABLE student ADD INDEX FKstudent127456 (groupe_id), ADD CONSTRAINT FKstudent127456 FOREIGN KEY (groupe_id) REFERENCES groupe (id);
ALTER TABLE groupe ADD INDEX FKgroupe535445 (pulpit_id), ADD CONSTRAINT FKgroupe535445 FOREIGN KEY (pulpit_id) REFERENCES pulpit (id);
ALTER TABLE lecturer ADD INDEX FKlecturer517174 (pulpit_id), ADD CONSTRAINT FKlecturer517174 FOREIGN KEY (pulpit_id) REFERENCES pulpit (id);
ALTER TABLE lecture ADD INDEX FKlecture144325 (subject_id), ADD CONSTRAINT FKlecture144325 FOREIGN KEY (subject_id) REFERENCES subject (id);
ALTER TABLE schedule ADD INDEX FKschedule620818 (lecture_id), ADD CONSTRAINT FKschedule620818 FOREIGN KEY (lecture_id) REFERENCES lecture (id);
ALTER TABLE schedule ADD INDEX FKschedule98777 (groupe_id), ADD CONSTRAINT FKschedule98777 FOREIGN KEY (groupe_id) REFERENCES groupe (id);
ALTER TABLE verification ADD INDEX FKverificati786596 (subject_id), ADD CONSTRAINT FKverificati786596 FOREIGN KEY (subject_id) REFERENCES student (id);
ALTER TABLE verification ADD INDEX FKverificati47266 (subject_id), ADD CONSTRAINT FKverificati47266 FOREIGN KEY (subject_id) REFERENCES subject (id);
ALTER TABLE subject ADD INDEX FKsubject162377 (lecturer_id), ADD CONSTRAINT FKsubject162377 FOREIGN KEY (lecturer_id) REFERENCES lecturer (id);
ALTER TABLE student ADD INDEX FKstudent678198 (user_id), ADD CONSTRAINT FKstudent678198 FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE lecturer ADD INDEX FKlecturer997690 (user_id), ADD CONSTRAINT FKlecturer997690 FOREIGN KEY (user_id) REFERENCES `user` (id);
ALTER TABLE subject ADD INDEX FKsubject177575 (book_id), ADD CONSTRAINT FKsubject177575 FOREIGN KEY (book_id) REFERENCES book (id);
ALTER TABLE schedule ADD INDEX FKschedule620819 (lecture_id), ADD CONSTRAINT FKschedule620819 FOREIGN KEY (lecture_id) REFERENCES lecture (id);
ALTER TABLE schedule ADD INDEX FKschedule620820 (lecture_id), ADD CONSTRAINT FKschedule620820 FOREIGN KEY (lecture_id) REFERENCES lecture (id);
