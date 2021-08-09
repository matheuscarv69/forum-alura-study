create table forum."user"
(
    id    bigserial       not null,
    name  varchar(100) not null,
    email varchar(100) not null unique,
    primary key (id)
);

INSERT INTO forum."user"(email, name) VALUES ( 'yuri.matheus@puz.com', 'Yuri Matheus');
INSERT INTO forum."user"( email, name) VALUES ('rafa.ponte@puz.com', 'Rafael Ponte');
