create table course
(
    id       bigint       not null,
    name     varchar(100) not null unique,
    category varchar(100) not null,
    primary key (id)
);

insert into course(id, name, category) VALUES (1, 'Kotlin Formation', 'API REST - Kotlin Spring Boot - Web Layer');
