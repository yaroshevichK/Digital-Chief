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
