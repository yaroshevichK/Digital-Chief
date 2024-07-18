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
       ('Oh Boy (A Coffee in Berlin)', '6/18/2024', '8:33 AM', 'Grodno', 'FILM', 27),
       ('Yesterday Was a Lie', '5/27/2024', '12:05 AM', 'Mogilev', 'CONCERT', 78),
       ('American Perfect', '4/17/2024', '6:45 PM', 'Brest', 'FILM', 33),
       ('Man with No Shadow', '5/24/2024', '3:46 PM', 'Minsk', 'ART', 75),
       ('Man with No Shadow', '5/24/2024', '3:46 PM', 'Grodno', 'ART', 75),
       ('Vera Drake', '5/13/2024', '12:22 PM', 'Vitebsk', 'FILM', 20),
       ('Honeymooners', '6/30/2024', '9:38 PM', 'Vitebsk', 'ART', 78),
       ('Bullet in the Head', '1/17/2024', '7:45 AM', 'Mogilev', 'FILM', 88);

insert into ticket (event_id, type_ticket, price, hall, row_hall, seat)
values (5, 'VIP', 69, 3, 3, 9),
       (2, 'SIMPLE', 24, 2, 10, 3),
       (8, 'VIP', 19, 2, 10, 11),
       (2, 'VIP', 30, 2, 2, 4),
       (2, 'SIMPLE', 71, 1, 5, 2),
       (4, 'VIP2', 13, 2, 6, 17),
       (8, 'VIP', 66, 2, 5, 8),
       (2, 'VIP2', 31, 2, 4, 8),
       (3, 'VIP2', 37, 2, 10, 12),
       (7, 'VIP2', 30, 1, 7, 12),
       (5, 'VIP', 13, 3, 9, 15),
       (7, 'VIP2', 67, 1, 4, 8),
       (2, 'VIP2', 91, 3, 7, 15),
       (4, 'VIP2', 60, 2, 5, 7),
       (3, 'VIP', 52, 1, 2, 2),
       (4, 'VIP', 72, 3, 4, 1),
       (4, 'SIMPLE', 23, 1, 8, 18),
       (4, 'VIP', 96, 1, 1, 16),
       (2, 'VIP2', 45, 3, 2, 20),
       (5, 'VIP2', 12, 1, 10, 17),
       (8, 'VIP2', 64, 1, 6, 13),
       (5, 'VIP', 31, 2, 9, 12),
       (10, 'VIP', 41, 2, 7, 10),
       (8, 'SIMPLE', 87, 1, 3, 3),
       (6, 'SIMPLE', 64, 2, 5, 1),
       (5, 'VIP2', 76, 3, 8, 2),
       (2, 'SIMPLE', 86, 1, 7, 1),
       (10, 'SIMPLE', 82, 1, 3, 7),
       (10, 'VIP2', 26, 1, 10, 17),
       (10, 'VIP2', 28, 3, 10, 6);
