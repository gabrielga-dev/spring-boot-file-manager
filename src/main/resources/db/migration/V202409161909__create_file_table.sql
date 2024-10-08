CREATE TABLE file
(
    uuid          varchar(36) primary key not null,
    active        boolean                 not null default true,
    name          varchar(300)            not null,
    origin_type   varchar(20)             not null,
    origin_uuid    varchar(36)             not null,
    file_path      varchar(320)            not null,
    creation_date timestamp               not null,
    update_date   timestamp
);
