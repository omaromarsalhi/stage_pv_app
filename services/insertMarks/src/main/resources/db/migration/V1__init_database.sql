-- Create the PlanEtude table
CREATE TABLE IF NOT EXISTS PlanEtude
(
    idPE  SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    level VARCHAR(255) NOT NULL
    );

-- Create the Grade table
CREATE TABLE IF NOT EXISTS Grade
(
    idGrade SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    idPE    INTEGER,
    FOREIGN KEY (idPE) REFERENCES PlanEtude (idPE)
    );

-- Create the Transcript table
CREATE TABLE IF NOT EXISTS Transcript
(
    idTranscript SERIAL PRIMARY KEY,
    averageScore FLOAT        NOT NULL,
    year         DATE         NOT NULL,
    result       VARCHAR(255) NOT NULL,
    idGrade      INTEGER,
    idUser       INTEGER,
    FOREIGN KEY (idGrade) REFERENCES Grade (idGrade)
    );

-- Create the GradeProfessor table
CREATE TABLE IF NOT EXISTS GradeProfessor
(
    idUser  INTEGER,
    idGrade INTEGER,
    PRIMARY KEY (idUser, idGrade),
    FOREIGN KEY (idGrade) REFERENCES Grade (idGrade)
    );

-- Create the UniteEnseignement table
CREATE TABLE IF NOT EXISTS UniteEnseignement
(
    idUE SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

-- Create the Module table
CREATE TABLE IF NOT EXISTS Module
(
    idModule    SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    coefficient FLOAT        NOT NULL,
    idUE        INTEGER,
    FOREIGN KEY (idUE) REFERENCES UniteEnseignement (idUE)
    );

-- Create the PlanEtudeUniteEnseignement table
CREATE TABLE IF NOT EXISTS PlanEtudeUniteEnseignement
(
    idPE INTEGER,
    idUE     INTEGER,
    PRIMARY KEY (idPE, idUE),
    FOREIGN KEY (idPE) REFERENCES PlanEtude (idPE),
    FOREIGN KEY (idUE) REFERENCES UniteEnseignement (idUE)
    );




-- Create the Mark table
CREATE TABLE IF NOT EXISTS Mark
(
    idMark   SERIAL PRIMARY KEY,
    markCC   FLOAT NOT NULL,
    markExam FLOAT NOT NULL,
    markTp   FLOAT NOT NULL,
    idModule INTEGER,
    FOREIGN KEY (idModule) REFERENCES Module (idModule)
    );

-- Create the StudentMark table
CREATE TABLE IF NOT EXISTS StudentMark
(
    idStudent INTEGER,
    idMark    INTEGER,
    PRIMARY KEY (idStudent, idMark),
    FOREIGN KEY (idMark) REFERENCES Mark (idMark)
    );

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