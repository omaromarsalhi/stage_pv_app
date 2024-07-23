create table if not exists UniteEnseignement
(
    idUE INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

create table if not exists modules
(    idModule INTEGER PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     coefficient FLOAT NOT NULL,
     idUE INTEGER,
     FOREIGN KEY (idUE) REFERENCES UniteEnseignement(idUE)
);

create table if not exists marks
(
    idMark INTEGER PRIMARY KEY,
    markCc FLOAT,
    markExam FLOAT,
    markTp FLOAT,
    idModule INTEGER,
    FOREIGN KEY (idModule) REFERENCES modules(idModule)
);
