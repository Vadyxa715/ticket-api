CREATE TABLE IF NOT EXISTS transporters (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR NOT NULL,
    phone VARCHAR(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS trails (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    point_departure VARCHAR(50) NOT NULL,
    point_arrival VARCHAR(50) NOT NULL,
    duration INTeger,
    transporter_id integer REFERENCES transporters(id)
);

CREATE TABLE IF NOT EXISTS tickets (
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    departure_time DATE NOT NULL,
    place integer NOT NULL,
    price integer NOT NULL,
    paid boolean,
    trail_id integer REFERENCES trails(id)
);

CREATE TABLE IF NOT EXISTS users (
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    full_name VARCHAR not NULL,
    ticket_id integer REFERENCES tickets(id)
);