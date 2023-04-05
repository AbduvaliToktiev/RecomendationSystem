insert into recomendation_system.roles (created, status, updated, name) values (current_timestamp, 'ACTIVE', current_timestamp, 'USER');
insert into recomendation_system.roles (created, status, updated, name) values (current_timestamp, 'ACTIVE', current_timestamp, 'ADMIN');
insert into recomendation_system.users (created, status, updated, age, email, gender, password, username) values (current_timestamp, 'ACTIVE', current_timestamp, 22, 'testtestovvv7@gmail.com', 'MALE', '$2a$12$ZicRN7/2I6xitKMWcF.wk.W46XPQEHEh1bYeVhpS4kCG8W9ojVdD.', 'test');
insert into recomendation_system.user_roles (user_id, role_id) values (1, 2);
