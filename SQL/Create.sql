CREATE TABLE users(
    id SERIAL PRIMARY KEY ,
    username TEXT,
    password TEXT
);

CREATE TABLE roles(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE user_role(
    user_id INT NOT NULL REFERENCES users,
    role_id INT NOT NULL REFERENCES roles,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE trains(
    id SERIAL PRIMARY KEY ,
    train_number INT,
    type TEXT
);

CREATE TABLE stations(
    id SERIAL PRIMARY KEY ,
    name TEXT
);

CREATE TABLE routes(
    id SERIAL PRIMARY KEY ,
    train_id INT,
    station_id INT,
    arrival_time TIME,
    departure_time TIME,
    sequence_number INT,
    FOREIGN KEY (train_id) REFERENCES trains(id),
    FOREIGN KEY (station_id) REFERENCES stations(id)
);

CREATE INDEX idx_routes_station_id ON routes (station_id);
CREATE INDEX idx_routes_train_id ON routes (train_id);
CREATE INDEX idx_routes_sequence_number ON routes (sequence_number);
CREATE INDEX idx_stations_name ON stations (name);