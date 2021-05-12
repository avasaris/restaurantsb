INSERT INTO USERS (EMAIL, PASSWD)
VALUES ('user@yandex.ru', '{noop}user'),
       ('admin@yandex.ru', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 2);
