--liquibase formatted sql

--changeset Dmitry Pristavka:1

DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255)        NOT NULL,
    last_name  VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    birth_date TIMESTAMP           NOT NULL,
    created_at TIMESTAMP           NOT NULL,
    updated_at TIMESTAMP
);
--rollback DROP TABLE users;


CREATE TABLE meals
(
    id              SERIAL PRIMARY KEY,
    screenshot_link VARCHAR(100) NOT NULL,
    created_at      TIMESTAMP    NOT NULL,
    updated_at      TIMESTAMP,
    user_id         INT          NOT NULL,
    CONSTRAINT fk_user_id
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);
--rollback DROP TABLE meals;

CREATE TABLE items
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    weight        INT       NOT NULL,
    proteins      REAL      NOT NULL,
    fats          REAL      NOT NULL,
    carbohydrates REAL      NOT NULL,
    fiber         REAL      NOT NULL,
    created_at    TIMESTAMP NOT NULL,
    updated_at    TIMESTAMP,
    meal_id       INT       NOT NULL,
    CONSTRAINT fk_meal_id
        FOREIGN KEY (meal_id)
            REFERENCES meals (id)
            ON DELETE CASCADE
)
--rollback DROP TABLE items;