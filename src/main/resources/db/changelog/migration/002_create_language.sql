--liquibase formatted sql
--changeset Dmitry Pristavka:2

CREATE TABLE language
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50),
    code VARCHAR(5)
)