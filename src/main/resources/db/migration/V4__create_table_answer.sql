create table answer
(
    id        bigint        not null,
    message   varchar(2000) not null,
    createAt  date          not null,
    author_id bigint        not null,
    topic_id  bigint        not null,
    solution  bool,

    primary key (id),
    foreign key (author_id) references "user" (id),
    foreign key (topic_id) references topic (id)
);

