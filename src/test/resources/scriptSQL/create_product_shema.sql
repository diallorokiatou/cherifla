CREATE TABLE if not exists product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price_per_kg DOUBLE PRECISION NOT NULL,
    available BOOLEAN NOT NULL
);