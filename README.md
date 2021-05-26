# The task

### Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

#### [Build a voting system for deciding where to have lunch.](https://github.com/JavaWebinar/topjava/blob/doc/doc/graduation.md)

2 types of users: admin and regular users Admin can input a restaurant and it's lunch menu of the day (2-5 items
usually, just a dish name and price)
Menu changes each day (admins do the updates)
Users can vote on which restaurant they want to have lunch at Only one vote counted per user If user votes again the
same day:
If it is before 11:00 we assume that he changed his mind. If it is after 11:00 then it is too late, vote can't be
changed Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and
couple curl commands to test it.

-----------------------------

## Rest API and testing links

#### RESTAURANT CRUD

ADMIN, USER:

* GET /api/restaurant - list all restaurant

```shell 
curl -s http://localhost:8080/api/restaurant --user admin@yandex.ru:passwd
```

* GET /api/restaurant/{restaurantId} - show restaurant profile

```shell 
curl -s http://localhost:8080/api/restaurant --user user@mail.ru:passwd
```

ADMIN:

* POST /api/restaurant - create new restaurant

```shell 
curl -s -X POST -d '{"name": "HAMBURGER"}' -H 'Content-Type: application/json' http://localhost:8080/api/restaurant --user admin@yandex.ru:passwd
```

#### MENU CRUD

ADMIN, USER:

* GET /api/restaurant/{restaurantId}/menu - list all menus for restaurant

```shell 
curl -s http://localhost:8080/api/restaurant/1/menu --user admin@yandex.ru:passwd
```

* GET /api/restaurant/{restaurantId}/menu/{menuId} - show menu details for restaurant

```shell 
curl -s http://localhost:8080/api/restaurant/2/menu/3 --user user@mail.ru:passwd
```

ADMIN:

* POST /api/restaurant/{restaurantId}/menu - create new menu for restaurant

```shell 
curl -s -X POST -d '{"date": "2021-05-22"}' -H 'Content-Type: application/json' http://localhost:8080/api/restaurant/1/menu --user admin@yandex.ru:passwd
```

#### VOTING

ADMIN, USER:

* POST /api/restaurant/{restaurantId}/vote - give the vote for the restaurant

```shell 
curl -s -X POST -H 'Content-Type: application/json' http://localhost:8080/api/restaurant/1/vote --user user@mail.ru:passwd
```

* GET http://localhost:8080/api/restaurant/top - to watch voting result for today
```shell 
curl -s http://localhost:8080/api/restaurant/top --user user@mail.ru:passwd
```


#### USERS CRUD

ANONYMOUS:

* POST /api/account/register - create new account

```shell 
curl -s -X POST -d '{"email": "new@gmail.com", "password": "newpass"}' -H 'Content-Type: application/json' http://localhost:8080/api/account/register
```

ADMIN, USER:

* GET /api/account - show your profile details

```shell 
curl -s http://localhost:8080/api/account --user user@mail.ru:passwd
```

* DELETE /api/account - delete yourself

```shell 
curl -s -X DELETE http://localhost:8080/api/account --user user@mail.ru:passwd
```

* PUT /api/account - update your profile details

```shell 
$ curl -s -X PUT -d '{"email": "newadmin@yandex.ru","password": "newpasswd"}' -H 'Content-Type: application/json'  http://localhost:8080/api/account --user admin@yandex.ru:passwd
```

