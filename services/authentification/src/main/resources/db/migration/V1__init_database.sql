create table if not exists users
(
    idUser     integer primary key,
    identifier varchar(30),
    firstname  varchar,
    lastname   varchar,
    email      varchar,
    password   varchar,
    role       varchar
);

