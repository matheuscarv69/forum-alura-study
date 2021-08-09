create table "user"
(
    id    bigint       not null,
    name  varchar(100) not null,
    email varchar(100) not null unique,
    primary key (id)
);

INSERT INTO "user"(id, email, name) VALUES (1, 'yuri.matheus@puz.com', 'Yuri Matheus');
INSERT INTO "user"(id, email, name) VALUES (2, 'rafa.ponte@puz.com', 'Rafael Ponte');
