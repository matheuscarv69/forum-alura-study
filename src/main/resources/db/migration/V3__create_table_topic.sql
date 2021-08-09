create table topic
(
    id        bigint        not null,
    title     varchar(100)  not null,
    message   varchar(1000) not null,
    createAt  date          not null,
    status    varchar(30)   not null,
    course_id bigint        not null,
    author_id bigint        not null,

    primary key (id),
    foreign key (course_id) references course (id),
    foreign key (author_id) references "user" (id)
);

