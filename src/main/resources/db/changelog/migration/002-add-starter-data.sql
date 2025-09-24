--liquibase formatted sql
--changeset Dmitry Pristavka:2

INSERT INTO languages(name, code, created_at, updated_at)
VALUES ('English', 'EU', current_timestamp, current_timestamp),
       ('Ukraine', 'UA', current_timestamp, current_timestamp),
       ('Russian', 'RU', current_timestamp, current_timestamp);

INSERT INTO roles(name, description, created_at, updated_at)
VALUES ('ROLE_USER', 'default user', current_timestamp, current_timestamp),
       ('ROLE_ADMIN', 'ser who has admin rights', current_timestamp, current_timestamp);

INSERT INTO subscriptions(name, description, created_at, updated_at)
VALUES ('FREE', 'General subscription for all users', current_timestamp, current_timestamp),
       ('PRO', 'The subscription for paid users', current_timestamp, current_timestamp);

