BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,first_name,last_name,email_address,phone_number,role)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Bob','Bobberson','bob@bobinc.com','123-123-1234','ROLE_USER');

INSERT INTO users (username,password_hash,first_name,last_name,email_address,phone_number,role)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','Ann', 'Anna','ann@carrepair.com','567-567-5678','ROLE_ADMIN');

INSERT INTO users (username,password_hash,first_name,last_name,email_address,phone_number,role)
VALUES ('emp','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Jim', 'Jimbob', 'jim@carrepair.com', '234-345-3456','ROLE_EMPLOYEE');

COMMIT TRANSACTION;
