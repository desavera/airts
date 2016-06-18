# Create schemas
# Create database

CREATE DATABASE airtsdev;

# Selecting database

USE airtsdev;

# Create tables
CREATE TABLE IF NOT EXISTS reservation
(
    id INT NOT NULL,
    reservation_owner BIGINT,
    reservation_state INT,
    reservation_departure_schedule BIGINT,
    reservation_transaction BIGINT,
    reservation_return_schedule BIGINT,
    reservation_total_costs DOUBLE,
    reservation_nseats INT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS reservation_state
(
    id INT NOT NULL,
    next_state INT,
    previous_state INT,
    name CHARACTER(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS reservation_owner
(
    id BIGINT NOT NULL,
    owner_name CHARACTER(50),
    owner_passport_number CHARACTER(50),
    owner_email CHARACTER(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS schedule
(
    id BIGINT NOT NULL,
    schedule_departure_time DATE,
    schedule_origin INT,
    schedule_destiny INT,
    schedule_available_seats CHARACTER(250),
    schedule_costs DOUBLE,
    schedule_arriving_time DATE    
);

CREATE TABLE IF NOT EXISTS schedule_spot
(
    id INT NOT NULL,
    spot_name CHARACTER(50),
    spot_code CHARACTER(5),
    spot_timezone CHARACTER(5),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS user_session
(
    session_id INT NOT NULL,
    auth_flag TINYINT(1),
    auth_broker INT,
    auth_broker_token_id BIGINT,
    reservation_owner BIGINT,
    session_start DATE,
    session_end DATE,
    PRIMARY KEY(session_id)
);

CREATE TABLE IF NOT EXISTS reservation_transaction
(
    id BIGINT NOT NULL,
    transaction_broker INT,
    transaction_broker_transaction_id BIGINT,
    transaction_timestamp DATE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS auth_broker
(
    broker_id INT NOT NULL,
    broker_name CHARACTER(50),
    PRIMARY KEY(broker_id)
);

CREATE TABLE IF NOT EXISTS owner_auth_broker_map
(
    broker_owner_id BIGINT NOT NULL,
    auth_broker INT,
    reservation_owner BIGINT,
    PRIMARY KEY(broker_owner_id)
);

CREATE TABLE IF NOT EXISTS reservation_message_log
(
    reservation BIGINT,
    message_delivery_status TINYINT(1),
    message_sent_timestamp DATE,
    message_type BIGINT    
);

CREATE TABLE IF NOT EXISTS reservation_message_type
(
    id BIGINT NOT NULL,
    message_type_name CHARACTER(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS checkout_control
(
    id INT NOT NULL,
    checkout_departure_timestamp DATE,
    checkout_departure_seats CHARACTER(250),
    checkout_return_timestamp DATE,
    checkout_return_seats CHARACTER(250),
    PRIMARY KEY(id)
);


# Create FKs
ALTER TABLE reservation_state
    ADD    FOREIGN KEY (id)
    REFERENCES reservation_state(previous_state)
;
    
ALTER TABLE reservation
    ADD    FOREIGN KEY (reservation_owner)
    REFERENCES reservation_owner(id)
;
    
ALTER TABLE reservation
    ADD    FOREIGN KEY (reservation_state)
    REFERENCES reservation_state(id)
;
    
ALTER TABLE schedule
    ADD    FOREIGN KEY (schedule_origin)
    REFERENCES schedule_spot(id)
;
    
ALTER TABLE schedule
    ADD    FOREIGN KEY (schedule_destiny)
    REFERENCES schedule_spot(id)
;
    
ALTER TABLE reservation_state
    ADD    FOREIGN KEY (id)
    REFERENCES reservation_state(next_state)
;
    
ALTER TABLE reservation
    ADD    FOREIGN KEY (reservation_transaction)
    REFERENCES reservation_transaction(id)
;
    
ALTER TABLE user_session
    ADD    FOREIGN KEY (auth_broker)
    REFERENCES auth_broker(broker_id)
;
    
ALTER TABLE user_session
    ADD    FOREIGN KEY (reservation_owner)
    REFERENCES reservation_owner(id)
;
    
ALTER TABLE owner_auth_broker_map
    ADD    FOREIGN KEY (auth_broker)
    REFERENCES auth_broker(broker_id)
;
    
ALTER TABLE owner_auth_broker_map
    ADD    FOREIGN KEY (reservation_owner)
    REFERENCES reservation_owner(id)
;
    
ALTER TABLE reservation_message_log
    ADD    FOREIGN KEY (reservation)
    REFERENCES reservation(id)
;
    
ALTER TABLE reservation_message_log
    ADD    FOREIGN KEY (message_type)
    REFERENCES reservation_message_type(id)
;
    
ALTER TABLE schedule
    ADD    FOREIGN KEY (id)
    REFERENCES reservation(reservation_departure_schedule)
;
    
ALTER TABLE schedule
    ADD    FOREIGN KEY (id)
    REFERENCES reservation(reservation_return_schedule)
;
    
ALTER TABLE checkout_control
    ADD    FOREIGN KEY (id)
    REFERENCES reservation(id)
;
    

