CREATE TABLE IF NOT EXISTS veiculo (
    id serial PRIMARY KEY,
    name varchar(20),
    email varchar(50),
    date_of_birth timestamp,
    age int
);