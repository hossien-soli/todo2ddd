
drop type if exists UserRole;
drop domain if exists UserUsername;
drop domain if exists BCryptHashResult;
drop table if exists users;
drop table if exists statistics_events;

create type UserRole as enum('CLIENT','ADMIN');
create domain UserUsername as varchar(30);
create domain BCryptHashResult as char(60);

create table users
(
    id UUID primary key,

    full_name varchar(40) not null,

    username UserUsername not null unique,
    password BCryptHashResult not null,

    banned boolean not null,

    registered_at timestamp not null,

    role UserRole not null,

    version int null
);

create table statistics_events
(
    event_name varchar(50) not null,
    entity_name varchar(50) null,
    entity_id varchar(100) null,
    occurred_at timestamp not null
);
