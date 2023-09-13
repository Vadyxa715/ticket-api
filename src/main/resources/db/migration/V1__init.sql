CREATE TABLE IF NOT EXISTS transporters (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR NOT NULL,
    phone VARCHAR(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    full_name VARCHAR not NULL
);

CREATE TABLE IF NOT EXISTS trails (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    point_departure VARCHAR(50) NOT NULL,
    point_arrival VARCHAR(50) NOT NULL,
    duration INTeger,
    transporter_id bigint REFERENCES transporters(id)
);

CREATE TABLE IF NOT EXISTS tickets (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    departure_time DATE NOT NULL,
    place integer NOT NULL,
    price integer NOT NULL,
    paid boolean,
    user_id bigint REFERENCES users(id),
    trail_id bigint REFERENCES trails(id)
);