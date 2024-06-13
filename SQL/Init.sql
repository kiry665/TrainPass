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

INSERT INTO roles(name)
VALUES
    ('ADMIN'),
    ('USER');

INSERT INTO stations(name)
VALUES
    ('Нижний Тагил'),
    ('365км'),
    ('Старатель'),
    ('Садоводы'),
    ('Монзино'),
    ('Шайтанка'),
    ('Леневка'),
    ('Анатольская'),
    ('392км'),
    ('Таволги'),
    ('Быньговский'),
    ('Невьянск'),
    ('419км'),
    ('Шурала'),
    ('Нейва'),
    ('Нейво-Рудянская'),
    ('Верх-Нейвинск'),
    ('Мурзинка'),
    ('Калиново'),
    ('Таватуй'),
    ('466км'),
    ('Аять'),
    ('472км'),
    ('Сагра'),
    ('479км'),
    ('Исеть'),
    ('Гать'),
    ('Шувакиш'),
    ('Огородная'),
    ('Екатеринбург-Сорт'),
    ('Электродепо'),
    ('ВИЗ'),
    ('Екатеринбург');

INSERT INTO trains(train_number, type)
VALUES
    (7070, 'Ласточка');

INSERT INTO routes(train_id, station_id, arrival_time, departure_time, sequence_number)
VALUES
    (1, 1, null, '12:00', 1),
    (1, 12, '12:30', '12:32', 2),
    (1, 17, '12:52', '12:54', 3),
    (1, 32, '13:45', '13:47', 4),
    (1, 33, '13:52', null, 5);

INSERT INTO trains(train_number, type)
VALUES
    (6465, 'Обычная');

INSERT INTO routes(train_id, station_id, arrival_time, departure_time, sequence_number)
VALUES
    (2, 1, null, '12:00', 1),
    (2, 2, '12:02', '12:04', 2),
    (2, 3, '12:06', '12:08', 3),
    (2, 4, '12:10', '12:12', 4),
    (2, 5, '12:14', '12:16', 5),
    (2, 6, '12:18', '12:20', 6),
    (2, 7, '12:22', '12:24', 7),
    (2, 8, '12:26', '12:28', 8),
    (2, 9, '12:30', '12:32', 9),
    (2, 10, '12:34', '12:36', 10),
    (2, 11, '12:38', '12:40', 11),
    (2, 12, '12:42', '12:44', 12),
    (2, 13, '12:46', '12:48', 13),
    (2, 14, '12:50', '12:52', 14),
    (2, 15, '12:54', '12:56', 15),
    (2, 16, '12:58', '13:00', 16),
    (2, 17, '13:02', '13:04', 17),
    (2, 18, '13:06', '13:08', 18),
    (2, 19, '13:10', '13:12', 19),
    (2, 20, '13:14', '13:16', 20),
    (2, 21, '13:18', '13:20', 21),
    (2, 22, '13:22', '13:24', 22),
    (2, 23, '13:26', '13:28', 23),
    (2, 24, '13:30', '13:32', 24),
    (2, 25, '13:34', '13:36', 25),
    (2, 26, '13:38', '13:40', 26),
    (2, 27, '13:42', '13:44', 27),
    (2, 28, '13:46', '13:48', 28),
    (2, 29, '13:50', '13:52', 29),
    (2, 30, '13:54', '13:56', 30),
    (2, 31, '13:58', '14:00', 31),
    (2, 32, '14:02', '14:04', 32),
    (2, 33, '14:06', null, 33);

INSERT INTO trains(train_number, type)
VALUES
    (6466, 'Обычная');

INSERT INTO routes(train_id, station_id, arrival_time, departure_time, sequence_number)
VALUES
    (3, 33, null, '12:00', 1),
    (3, 32, '12:02', '12:04', 2),
    (3, 31, '12:06', '12:08', 3),
    (3, 30, '12:10', '12:12', 4),
    (3, 29, '12:14', '12:16', 5),
    (3, 28, '12:18', '12:20', 6),
    (3, 27, '12:22', '12:24', 7),
    (3, 26, '12:26', '12:28', 8),
    (3, 25, '12:30', '12:32', 9),
    (3, 24, '12:34', '12:36', 10),
    (3, 23, '12:38', '12:40', 11),
    (3, 22, '12:42', '12:44', 12),
    (3, 21, '12:46', '12:48', 13),
    (3, 20, '12:50', '12:52', 14),
    (3, 19, '12:54', '12:56', 15),
    (3, 18, '12:58', '13:00', 16),
    (3, 17, '13:02', '13:04', 17),
    (3, 16, '13:06', '13:08', 18),
    (3, 15, '13:10', '13:12', 19),
    (3, 14, '13:14', '13:16', 20),
    (3, 13, '13:18', '13:20', 21),
    (3, 12, '13:22', '13:24', 22),
    (3, 11, '13:26', '13:28', 23),
    (3, 10, '13:30', '13:32', 24),
    (3, 9, '13:34', '13:36', 25),
    (3, 8, '13:38', '13:40', 26),
    (3, 7, '13:42', '13:44', 27),
    (3, 6, '13:46', '13:48', 28),
    (3, 5, '13:50', '13:52', 29),
    (3, 4, '13:54', '13:56', 30),
    (3, 3, '13:58', '14:00', 31),
    (3, 2, '14:02', '14:04', 32),
    (3, 1, '14:06', null, 33);