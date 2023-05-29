BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, cars, service, repair_requests;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email_address varchar(100) NOT NULL,
	phone_number varchar(15) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user_id PRIMARY KEY (user_id)
);

CREATE TABLE cars(
    car_id SERIAL,
    user_id int NOT NULL,
    make varchar(50) NOT NULL,
    model varchar(50) NOT NULL,
    color varchar(50) NOT NULL,
    year varchar(50) NOT NULL,
    CONSTRAINT PK_car_id PRIMARY KEY (car_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE service (
    service_id SERIAL,
    car_id int NOT NULL,
    oil varchar(50),
    front_brakes varchar(50),
    back_brakes varchar(50),
    tires varchar(50),
    body varchar(50),
    carbon_air_filter varchar(50),
    battery varchar(50),
    scheduled_maintenance varchar(50),
    misc varchar(500),
    CONSTRAINT PK_service_id PRIMARY KEY (service_id),
    CONSTRAINT FK_car_id FOREIGN KEY (car_id) REFERENCES cars(car_id)
);

CREATE TABLE requests (
    request_id SERIAL,
    service_id int NOT NULL,
    date_reported varchar(50),
    estimated_completion_date varchar(50),
    status varchar(50) NOT NULL,
    labor varchar(50),
    estimated_cost numeric,
    paid boolean NOT NULL,
    CONSTRAINT PK_request_id PRIMARY KEY (request_id),
    CONSTRAINT FK_service_id FOREIGN KEY (service_id) REFERENCES service(service_id)
    );

COMMIT TRANSACTION;
