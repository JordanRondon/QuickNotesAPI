CREATE TABLE users (
	users_id SERIAL PRIMARY KEY,
	users_role VARCHAR(5) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	users_password VARCHAR(255) NOT NULL,
	creation_date TIMESTAMP NOT NULL,
	visible BOOL NOT NULL
);

CREATE TABLE note (
	note_id SERIAL PRIMARY KEY,
	title VARCHAR(40) NULL,
	text_note TEXT NOT NULL,
	creation_date TIMESTAMP NOT NULL,
	number_characters INT NOT NULL,
	users_id INT NOT NULL
);

ALTER TABLE note
ADD CONSTRAINT fk_note_users FOREIGN KEY (users_id) REFERENCES users (users_id);
