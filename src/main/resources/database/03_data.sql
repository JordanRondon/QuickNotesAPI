--Unencrypted password is user01
INSERT INTO users (users_role, first_name, last_name, email, users_password, creation_date)
VALUES ('ADMIN', 'Mario Jose', 'Rodriguez Lujan', 'MarioLujan@gmail.com', '$2a$10$16t1Irwza094BK6g3jOW8uM4sDZSy2UTC6g9ysoENX3Shk2GiFXRi', '04/01/2025 00:00:00');

--Unencrypted password is user02
INSERT INTO users (users_role, first_name, last_name, email, users_password, creation_date)
VALUES ('USER', 'Jesus Nir', 'Roman Tanli', 'NirRoman@gmail.com', '$2a$10$w/DyKn8XUxwk/cFheaMgAOy73X3yTHJX43Ckguth9/ad4seAdpt2q', '04/02/2025 00:00:00');

INSERT INTO note (title, text_note, creation_date, number_characters, users_id)
VALUES ('First Note', 'This is the first note for user 01.', '05/01/2025 05:15:00', 36, 1);

INSERT INTO note (title, text_note, creation_date, number_characters, users_id)
VALUES ('Second Note', 'A shorter note.', '05/01/2025 06:30:45', 16, 1);

INSERT INTO note (title, text_note, creation_date, number_characters, users_id)
VALUES ('User 02 - First', 'The first note for user 02, more descriptive.', '05/01/2025 07:20:10', 46, 2);

INSERT INTO note (title, text_note, creation_date, number_characters, users_id)
VALUES (null, 'Second note for user 02.', '05/01/2025 08:45:22', 25, 2);