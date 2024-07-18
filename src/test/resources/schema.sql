CREATE TABLE IF NOT EXISTS event
(
    id           bigserial PRIMARY KEY,
    description  varchar(255),
    date_event   date,
    time_event   time,
    city         varchar(50),
    type_event   varchar(30),
    count_ticket int
);

CREATE TABLE IF NOT EXISTS ticket
(
    id          bigserial PRIMARY KEY,
    event_id    bigserial references event (id),
    type_ticket varchar(30),
    price       float,
    hall        int,
    row_hall    int,
    seat        int
);

insert into event (description, date_event, time_event, city, type_event, count_ticket)
values ('Organization', '6/24/2024', '12:08 PM', 'Minsk', 'ART', 8),
       ('Elizabeth: The Golden Age', '2/15/2024', '3:48 AM', 'Brest', 'FILM', 91),
       ('Oh Boy (A Coffee in Berlin)', '6/18/2024', '8:33 AM', 'Grodno', 'FILM', 27);

insert into ticket (event_id, type_ticket, price, hall, row_hall, seat)
values (1, 'VIP', 69, 3, 3, 9),
       (2, 'SIMPLE', 24, 2, 10, 3),
       (3, 'VIP', 19, 2, 10, 11),
       (1, 'VIP', 30, 2, 2, 4),
       (2, 'SIMPLE', 71, 1, 5, 2),
       (3, 'VIP2', 13, 2, 6, 17),
       (2, 'VIP', 66, 2, 5, 8);
