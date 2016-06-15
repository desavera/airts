
# Selecting database

USE airtsdev;

# Inserting schedule data

INSERT INTO schedule_spot values(1,'Aeroporto internacional Tom Jobim - RIOGaleao','GIG');
INSERT INTO schedule_spot values(2,'John F. Kennedy International Airport','JFK');
INSERT INTO schedule_spot values(3,'Aeropuerto Internacional Ezeiza','EZE');
INSERT INTO schedule_spot values(4,'Paris Charles De Gaulle','CDG');

INSERT into schedule values (1,STR_TO_DATE('1-01-2017 13:00','%d-%m-%Y HH:MM'),1,2,300,STR_TO_DATE('2-01-2017 01:30', '%d-%m-%Y HH:MM'));
INSERT into schedule values (2,STR_TO_DATE('1-01-2017 16:00','%d-%m-%Y HH:MM'),1,2,500,STR_TO_DATE('2-01-2017 04:30', '%d-%m-%Y HH:MM'));
INSERT into schedule values (3,STR_TO_DATE('2-01-2017 13:00','%d-%m-%Y HH:MM'),1,2,300,STR_TO_DATE('3-01-2017 01:30', '%d-%m-%Y HH:MM'));
INSERT into schedule values (4,STR_TO_DATE('2-01-2017 16:00','%d-%m-%Y HH:MM'),1,2,500,STR_TO_DATE('3-01-2017 04:30', '%d-%m-%Y HH:MM'));

commit;
