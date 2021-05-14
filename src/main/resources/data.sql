INSERT INTO USERS (EMAIL, PASSWD)
VALUES ('user@yandex.ru', '{noop}user'),
       ('admin@yandex.ru', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 2);

INSERT INTO RESTAURANT (NAME)
VALUES ('BUSINESS LUNCH'),
       ('OSTANKINO'),
       ('HLEB');

INSERT INTO MENU (LOCAL_DATE, RESTAURANT_ID)
VALUES ('2021-01-01', 1),
       ('2021-01-02', 1),
       ('2021-01-01', 2),
       ('2021-01-01', 3);

INSERT INTO DISH (NAME, PRICE, MENU_ID)
VALUES ('BORSH', 10.50, 1),
       ('PORK', 100.33, 1),
       ('ICE CREAM', 5.00, 2),
       ('COFFEE', 5.00, 2),
       ('KVAS', 3.00, 3);