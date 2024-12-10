CREATE TYPE event_type AS ENUM ('gas_detection', 'fan activated');

CREATE TABLE users (
id SERIAL,
username VARCHAR(100) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
PRIMARY KEY (id)
);

CREATE TABLE events (
id SERIAL,
user_id INT,
event_type event_type NOT NULL,
event_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id),
PRIMARY KEY (id)
);

CREATE TABLE settings (
id SERIAL,
fan_activated BOOLEAN NOT NULL,
fan_state BOOLEAN NOT NULL,
last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);