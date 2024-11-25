
CREATE TABLE IF NOT EXISTS  asistencia.users (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    avatar VARCHAR(255),
    gender VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255),
    age INT
);
