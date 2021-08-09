create table forum.answer
(
    id         bigserial     not null,
    message    varchar(2000) not null,
    created_at timestamp     not null,
    author_id  bigint        not null,
    topic_id   bigint        not null,
    solution   bool,

    primary key (id),
    foreign key (author_id) references forum."user" (id),
    foreign key (topic_id) references forum.topic (id)
);

