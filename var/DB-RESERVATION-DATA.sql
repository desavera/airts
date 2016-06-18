
# Selecting database

USE airtsdev;

# Inserting schedule data

INSERT INTO schedule_spot VALUES(1,'Aeroporto internacional Tom Jobim - RIOGaleao','GIG');
INSERT INTO schedule_spot VALUES(2,'John F. Kennedy International Airport','JFK');
INSERT INTO schedule_spot VALUES(3,'Aeropuerto Internacional Ezeiza','EZE');
INSERT INTO schedule_spot VALUES(4,'Paris Charles De Gaulle','CDG');

INSERT INTO schedule VALUES (1,STR_TO_DATE('1-01-2017 13:00','%d-%m-%Y HH:MM'),1,2,300,STR_TO_DATE('2-01-2017 01:30', '%d-%m-%Y HH:MM'));
INSERT INTO schedule VALUES (2,STR_TO_DATE('1-01-2017 16:00','%d-%m-%Y HH:MM'),1,2,500,STR_TO_DATE('2-01-2017 04:30', '%d-%m-%Y HH:MM'));
INSERT INTO schedule VALUES (3,STR_TO_DATE('2-01-2017 13:00','%d-%m-%Y HH:MM'),1,2,300,STR_TO_DATE('3-01-2017 01:30', '%d-%m-%Y HH:MM'));
INSERT INTO schedule VALUES (4,STR_TO_DATE('2-01-2017 16:00','%d-%m-%Y HH:MM'),1,2,500,STR_TO_DATE('3-01-2017 04:30', '%d-%m-%Y HH:MM'));

commit;

# Inserting reservation data
INSERT INTO reservation_transaction VALUES (1,1,322333);
insert INTO reservation_state VALUES(1,2,0,"PENDING_PAYMENT");
insert INTO reservation_owner VALUES(1,"Mario de Sa Vera","HG23H777-BR","desavera@gmail.com");
insert INTO reservation VALUES (1,1,1,1,1,1,"23",NOW());

commit;
