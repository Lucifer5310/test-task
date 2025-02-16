CREATE TABLE roles
(
    id bigint PRIMARY KEY NOT NULL,
    name varchar(63)
);

CREATE TABLE users
(
    id            bigint PRIMARY KEY NOT NULL,
    email         varchar(63) unique not null,
    first_name    varchar(31) not null,
    last_name     varchar(31) not null,
    date_of_birth bigint not null,
    password      varchar(255) unique not null,
    role_id       bigint
);

ALTER TABLE users
    ADD CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
            REFERENCES roles(id);

CREATE SEQUENCE users_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    CACHE 10;
CREATE SEQUENCE roles_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    CACHE 10;
