create table t_team
(
    id               uuid      default gen_random_uuid() not null
        primary key,
    name             varchar(50)                             not null,
    product          varchar(50)                             not null,
    created_at       timestamp default now(),
    modified_at      timestamp default now(),
    default_location varchar(50)
);

create table t_rack
(
    id               uuid      default gen_random_uuid() not null
        primary key,
    team_id          uuid
        references t_team,
    serial_number    varchar                                not null,
    status           varchar(20)                         not null,
    default_location varchar,
    assembled_at     timestamp,
    created_at       timestamp default now(),
    modified_at      timestamp default now()
);

create table t_rack_asset
(
    id        uuid default gen_random_uuid() not null
        primary key,
    asset_tag varchar                        not null,
    rack_id   uuid                           not null
        references t_rack
);

create table t_team_member
(
    id          uuid      default gen_random_uuid() not null
        primary key,
    team_id     uuid                                not null
        references t_team,
    ctw_id      varchar(10)                         not null,
    name        varchar                             not null,
    created_at  timestamp default now(),
    modified_at timestamp default now()
);

create table t_booking
(
    id           uuid      default gen_random_uuid() not null
        primary key,
    rack_id      uuid                                not null
        references t_rack,
    requester_id uuid                                not null
        references t_team_member,
    book_from    timestamp                           not null,
    book_to      timestamp                           not null,
    created_at   timestamp default now(),
    modified_at  timestamp default now()
);



