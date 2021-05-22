INSERT INTO USERS (EMAIL, PASSWD)
VALUES ('user@mail.ru', '{noop}passwd'),
       ('admin@yandex.ru', '{noop}passwd');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 2);

INSERT INTO RESTAURANT (NAME)
VALUES ('BUSINESS LUNCH'),
       ('OSTANKINO'),
       ('HLEB');

INSERT INTO MENU (LOCAL_DATE, RESTAURANT_ID)
VALUES (CURRENT_DATE(), 1),
       (CURRENT_DATE(), 2),
       (CURRENT_DATE(), 3),
       (CURRENT_DATE() - 1, 1);

INSERT INTO DISH (NAME, PRICE, MENU_ID)
VALUES ('BORSH', 10.50, 1),
       ('PORK', 100.33, 1),
       ('ICE CREAM', 5.00, 2),
       ('COFFEE', 5.00, 2),
       ('KVAS', 3.00, 3);