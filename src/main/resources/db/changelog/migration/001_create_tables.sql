--liquibase formatted sql
--changeset Dmitry Pristavka:1

DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS languages;

CREATE TABLE languages
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(50) UNIQUE NOT NULL,
    code       VARCHAR(5)         NOT NULL,
    created_at TIMESTAMP          NOT NULL,
    updated_at TIMESTAMP
);
--rollback DROP TABLE languages;

CREATE TABLE subscriptions
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(200),
    created_at  TIMESTAMP          NOT NULL,
    updated_at  TIMESTAMP
);
--rollback DROP TABLE subscriptions;

CREATE TABLE roles
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(200),
    created_at  TIMESTAMP          NOT NULL,
    updated_at  TIMESTAMP
);
--rollback DROP TABLE roles;

CREATE TABLE users
(
    id              SERIAL PRIMARY KEY,
    first_name      VARCHAR(255)        NOT NULL,
    last_name       VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    password        VARCHAR(255)        NULL,
    picture         VARCHAR(255)        NULL,
    birth_date      TIMESTAMP           NULL,
    weight          INT                 NULL,
    height          INT                 NULL,
    gender          VARCHAR(10)         NULL,
    language_id     INTEGER UNIQUE REFERENCES languages (id) ON DELETE CASCADE,
    subscription_id INTEGER UNIQUE REFERENCES subscriptions (id) ON DELETE CASCADE,
    role_id         INTEGER UNIQUE REFERENCES roles (id) ON DELETE CASCADE,
    created_at      TIMESTAMP           NOT NULL,
    updated_at      TIMESTAMP
);
--rollback DROP TABLE users;


CREATE TABLE meals
(
    id              SERIAL PRIMARY KEY,
    screenshot_link VARCHAR(100) NOT NULL,
    created_at      TIMESTAMP    NOT NULL,
    updated_at      TIMESTAMP,
    user_id         INTEGER UNIQUE REFERENCES users (id) ON DELETE CASCADE
--     user_id         INT          NOT NULL,
--     CONSTRAINT fk_user_meal
--         FOREIGN KEY (user_id)
--             REFERENCES users (id)
--             ON DELETE CASCADE
);
--rollback DROP TABLE meals;

CREATE TABLE items
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255),
    weight        INT       NOT NULL,
    kilocalories  REAL      NOT NULL,
    proteins      REAL      NOT NULL,
    fats          REAL      NOT NULL,
    carbohydrates REAL      NOT NULL,
    fiber         REAL      NOT NULL,
    meal_id       INTEGER UNIQUE REFERENCES users (id) ON DELETE CASCADE,
    created_at    TIMESTAMP NOT NULL,
    updated_at    TIMESTAMP
--     meal_id       INT       NOT NULL,
--     CONSTRAINT fk_meal_items
--         FOREIGN KEY (meal_id)
--             REFERENCES meals (id)
--             ON DELETE CASCADE
);
--rollback DROP TABLE items;