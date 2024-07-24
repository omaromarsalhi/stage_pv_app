create table if not exists UniteEnseignement
(
    idUE INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

create table if not exists modules
(
    idModule INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    coefficient FLOAT NOT NULL,
    idUE INTEGER,
    FOREIGN KEY (idUE) REFERENCES UniteEnseignement(idUE)
    );

create table if not exists users
(
    idUser INTEGER PRIMARY KEY,
    identifier VARCHAR(30) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
    );

create table if not exists marks
(
    idMark INTEGER PRIMARY KEY,
    markCc FLOAT,
    markExam FLOAT,
    markTp FLOAT,
    idModule INTEGER,
    idUser INTEGER,
    FOREIGN KEY (idModule) REFERENCES modules(idModule),
    FOREIGN KEY (idUser) REFERENCES users(idUser)
    );
