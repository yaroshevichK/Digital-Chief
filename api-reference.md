# API руководство
В этом справочном руководстве по API представлена подробная информация о доступных методах и параметрах API системы.

## Содержание
* Мероприятия
* Билеты
* Ответ об ошибке

### Мероприятия

Описание: Этот метод добавляет новое мероприятие.
Endpoint: /api/v1/events
HTTP Method: POST

Parameters:

| Name         | Type   | Description                                |
|--------------|--------|--------------------------------------------|
| description  | String | Название мероприятия                       |
| dateEvent    | Date   | Дата мероприятия                           |
| timeEvent    | Time   | Время мероприятия (строка в формате HH:mm) |
| city         | String | Город провдения мероприятия                |
| typeEvent    | String | Тип мероприятия (FILM, ART, CONCERT)       |
| countTicket  | Number | Количество билетов                         |

Пример запроса:
{
    "description": "Art Gallery 2024",
    "dateEvent": "2024-08-15",
    "timeEvent": "11:00",
    "city": "London",
    "typeEvent": "ART",
    "countTicket": 20
}

---
Описание: Этот метод получает мероприятие по id.
Endpoint: /api/v1/events/{id}
HTTP Method: GET

Пример запроса:
http://localhost:8080/api/v1/events/1

---
Описание: Этот метод обновляет данные мероприятия.
Endpoint: /api/v1/events/{id}
HTTP Method: PUT

Parameters:

| Name         | Type   | Description                                |
|--------------|--------|--------------------------------------------|
| description  | String | Название мероприятия                       |
| dateEvent    | Date   | Дата мероприятия                           |
| timeEvent    | Time   | Время мероприятия (строка в формате HH:mm) |
| city         | String | Город провдения мероприятия                |
| typeEvent    | String | Тип мероприятия (FILM, ART, CONCERT)       |
| countTicket  | Number | Количество билетов                         |


Пример запроса:
{
    "description": "Art Gallery 2024",
    "dateEvent": "2024-08-15",
    "timeEvent": "11:00",
    "city": "London",
    "typeEvent": "ART",
    "countTicket": 20
}

---
Описание: Этот метод удаляет мероприятие по id.
Endpoint: /api/v1/events/{id}
HTTP Method: DELETE

Пример запроса:
http://localhost:8080/api/v1/events/1

---
Описание: Этот метод выводит все мероприятия.
Endpoint: /api/v1/events
HTTP Method: GET

Пример запроса:
http://localhost:8080/api/v1/events



### Билеты

Описание: Этот метод добавляет новый билет.
Endpoint: /api/v1/tickets
HTTP Method: POST

Parameters:

| Name       | Type   | Description                    |
|------------|--------|--------------------------------|
| typeTicket | String | Тип билета (SIMPLE, VIP, VIP2) |
| price      | Number | Цена билета                    |
| hall       | Number | Зал                            |
| rowHall    | Number | Ряд                            |
| seat       | Number | Место                          |
| eventId    | Number | Мероприятие (идентификатор)    |

Пример запроса:
JSON
{
    "typeTicket": "SIMPLE",
    "price": 24.0,
    "hall": 2,
    "rowHall": 10,
    "seat": 3,
    "eventId": 2
}

---
Описание: Этот метод получает билет по id.
Endpoint: /api/v1/tickets/{id}
HTTP Method: GET

Пример запроса:
http://localhost:8080/api/v1/tickets/1

---
Описание: Этот метод обновляет данные билета.
Endpoint: /api/v1/tickets
HTTP Method: PUT

Parameters:

| Name       | Type   | Description                    |
|------------|--------|--------------------------------|
| id         | String | Идентификатор билета           |
| typeTicket | String | Тип билета (SIMPLE, VIP, VIP2) |
| price      | Number | Цена билета                    |
| hall       | Number | Зал                            |
| rowHall    | Number | Ряд                            |
| seat       | Number | Место                          |
| eventId    | Number | Мероприятие (идентификатор)    |

Пример запроса:
{
    "id": 1,
    "typeTicket": "VIP",
    "price": 24.0,
    "hall": 2,
    "rowHall": 10,
    "seat": 3,
    "eventId": 2
}


---
Описание: Этот метод удаляет билет по id.
Endpoint: /api/v1/tickets/{id}
HTTP Method: DELETE

Пример запроса:
http://localhost:8080/api/v1/tickets/1

---
Описание: Этот метод выводит все билеты.
Endpoint: /api/v1/tickets
HTTP Method: GET

Пример запроса:
http://localhost:8080/api/v1/tickets


### Ответ об ошибке

Пример ответа об ошибке

{
    "status": 401,
    "message": "User or password not correct"
}