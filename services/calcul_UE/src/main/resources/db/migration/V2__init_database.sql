create table if not exists modules
(    idModule INTEGER PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
    coefficient FLOAT NOT NULL,
    idUE INTEGER
);
