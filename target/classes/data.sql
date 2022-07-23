Insert into employee Values(1,'haritha@gmail.com','Haritha','Adika');
Insert into employee Values(2,'test@gmail.com','Isha','Reddy');
Insert into employee Values(3,'hello@gmail.com','Ari','Aggarwal');
Insert into employee Values(4,'har@gmail.com','Test','Singh');
Insert into employee Values(5,'test@gmail.com','Charan','Sharma');
Insert into employee Values(6,'hello@gmail.com','Lakesha','Kumari');
Insert into employee Values(7,'haritha@gmail.com','Kavitha','Isha');


INSERT INTO users (user_id, username, password) VALUES 
(1, 'admin', '$2a$12$JuZbDByeRXEy8PwWfOaBkuGAnFZ3gQ/XrooDO5EWU1Ktj7.P5LK16');

INSERT INTO roles (role_id, name) VALUES (1, 'ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);