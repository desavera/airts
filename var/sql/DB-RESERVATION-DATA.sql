
# Selecting database

USE airtsdev;

# Inserting schedule data

INSERT INTO schedule_spot VALUES(1,'Aeroporto internacional Tom Jobim - RIOGaleao','GIG','BRT');
INSERT INTO schedule_spot VALUES(2,'John F. Kennedy International Airport','JFK','EST');

INSERT INTO schedule VALUES (1,STR_TO_DATE('1/01/2017 13:00','%d/%m/%Y %H:%i'),1,2,300,235.0,STR_TO_DATE('1/01/2017 23:00','%d/%m/%Y %H:%i'));
INSERT INTO schedule VALUES (2,STR_TO_DATE('1/01/2017 16:00','%d/%m/%Y %H:%i'),1,2,500,335.0,STR_TO_DATE('2/01/2017 02:00','%d/%m/%Y %H:%i'));
INSERT INTO schedule VALUES (3,STR_TO_DATE('1/02/2017 13:00','%d/%m/%Y %H:%i'),2,1,300,235.0,STR_TO_DATE('1/02/2017 23:00','%d/%m/%Y %H:%i'));
INSERT INTO schedule VALUES (4,STR_TO_DATE('1/02/2017 16:00','%d/%m/%Y %H:%i'),2,1,500,335.0,STR_TO_DATE('2/02/2017 02:00','%d/%m/%Y %H:%i'));

commit;

# Inserting reservation data
INSERT INTO reservation_transaction VALUES (1,1,322333,NOW());
insert INTO reservation_state VALUES(1,2,0,"PAYMENT_CONFIRMED");
insert INTO reservation_state VALUES(2,3,1,"DEPARTURE_CHECKED_OUT");
insert INTO reservation_state VALUES(3,0,2,"RETURNING_CHECKED_OUT");
insert INTO reservation_owner VALUES(1,"Mario de Sa Vera","HG23H777-BR","desavera@gmail.com");
insert INTO reservation VALUES (1,1,1,1,1,2,580.5,3);

commit;
