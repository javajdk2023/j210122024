DROP TABLE IF EXISTS veiculo;

CREATE TABLE veiculo (
    id serial PRIMARY KEY,
    name varchar(20),
    email varchar(50),
    date_of_birth timestamp,
    age int
);