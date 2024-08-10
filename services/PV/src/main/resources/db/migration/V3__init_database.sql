-- Create the GradeProfessor table
CREATE TABLE IF NOT EXISTS GradeProfessor
(
    idGradeProfessor  INTEGER primary key ,
    idUser  INTEGER,
    idGrade INTEGER,
    idModule INTEGER
);