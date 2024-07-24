CREATE TABLE IF NOT EXISTS UniteEnseignement
(
    idUE BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS academicModules
(
    idModule BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    coefficient FLOAT NOT NULL,
    idUE BIGINT,
    FOREIGN KEY (idUE) REFERENCES UniteEnseignement(idUE)
    );

CREATE TABLE IF NOT EXISTS users
(
    idUser BIGINT PRIMARY KEY,
    identifier VARCHAR(30) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS marks
(
    idMark BIGINT PRIMARY KEY,
    markCc FLOAT,
    markExam FLOAT,
    markTp FLOAT,
    idModule BIGINT,
    idUser BIGINT,
    FOREIGN KEY (idModule) REFERENCES academicModules(idModule),
    FOREIGN KEY (idUser) REFERENCES users(idUser)
    );
