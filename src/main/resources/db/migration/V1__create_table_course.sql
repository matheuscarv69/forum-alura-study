create schema if not exists forum;

create table forum.course
(
    id       bigserial    not null,
    name     varchar(100) not null unique,
    category varchar(100) not null,
    primary key (id)
);

insert into forum.course(name, category) VALUES ('API REST - Kotlin Spring Boot - Web Layer', 'Kotlin Formation');
