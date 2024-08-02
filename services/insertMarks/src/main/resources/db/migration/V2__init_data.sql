-- Insert data into PlanEtude table
INSERT INTO PlanEtude (name, level) VALUES ('Computer Science', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Electrical Engineering', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Mechanical Engineering', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Civil Engineering', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Mathematics', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Physics', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Chemistry', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Biology', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Business Administration', 'Undergraduate');
INSERT INTO PlanEtude (name, level) VALUES ('Economics', 'Undergraduate');

-- Insert data into Grade table
INSERT INTO Grade (name, idPE) VALUES ('First Year', 1);
INSERT INTO Grade (name, idPE) VALUES ('Second Year', 1);
INSERT INTO Grade (name, idPE) VALUES ('Third Year', 1);
INSERT INTO Grade (name, idPE) VALUES ('Fourth Year', 1);
INSERT INTO Grade (name, idPE) VALUES ('First Year', 2);
INSERT INTO Grade (name, idPE) VALUES ('Second Year', 2);
INSERT INTO Grade (name, idPE) VALUES ('Third Year', 2);
INSERT INTO Grade (name, idPE) VALUES ('First Year', 3);
INSERT INTO Grade (name, idPE) VALUES ('Second Year', 3);
INSERT INTO Grade (name, idPE) VALUES ('Third Year', 3);

-- Insert data into Transcript table
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (85.0, '2023-07-01', 'Passed', 1, 1);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (78.0, '2023-07-01', 'Passed', 2, 2);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (90.0, '2022-07-01', 'Passed', 3, 3);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (88.0, '2021-07-01', 'Passed', 4, 4);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (76.0, '2020-07-01', 'Passed', 5, 5);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (82.0, '2019-07-01', 'Passed', 6, 6);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (89.0, '2018-07-01', 'Passed', 7, 7);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (91.0, '2017-07-01', 'Passed', 8, 8);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (84.0, '2016-07-01', 'Passed', 9, 9);
INSERT INTO Transcript (averageScore, year, result, idGrade, idUser) VALUES (79.0, '2015-07-01', 'Passed', 10, 10);

-- Insert data into GradeProfessor table
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (1, 1);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (2, 2);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (3, 3);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (4, 4);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (5, 5);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (6, 6);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (7, 7);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (8, 8);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (9, 9);
INSERT INTO GradeProfessor (idUser, idGrade) VALUES (10, 10);

-- Insert data into UniteEnseignement table
INSERT INTO UniteEnseignement (name) VALUES ('Mathematics');
INSERT INTO UniteEnseignement (name) VALUES ('Physics');
INSERT INTO UniteEnseignement (name) VALUES ('Chemistry');
INSERT INTO UniteEnseignement (name) VALUES ('Biology');
INSERT INTO UniteEnseignement (name) VALUES ('Computer Science');
INSERT INTO UniteEnseignement (name) VALUES ('Electrical Engineering');
INSERT INTO UniteEnseignement (name) VALUES ('Mechanical Engineering');
INSERT INTO UniteEnseignement (name) VALUES ('Civil Engineering');
INSERT INTO UniteEnseignement (name) VALUES ('Economics');
INSERT INTO UniteEnseignement (name) VALUES ('Business Administration');

-- Insert data into Module table
INSERT INTO Module (name, coefficient, idUE) VALUES ('Calculus', 4.0, 1);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Quantum Mechanics', 3.5, 2);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Organic Chemistry', 4.0, 3);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Molecular Biology', 4.0, 4);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Data Structures', 3.5, 5);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Circuits', 3.5, 6);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Thermodynamics', 4.0, 7);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Statics', 4.0, 8);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Microeconomics', 3.5, 9);
INSERT INTO Module (name, coefficient, idUE) VALUES ('Accounting', 3.5, 10);

-- Insert data into PlanEtudeUniteEnseignement table
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (1, 1);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (1, 2);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (1, 3);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (2, 4);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (2, 5);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (3, 6);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (3, 7);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (4, 8);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (4, 9);
INSERT INTO PlanEtudeUniteEnseignement (idPE, idUE) VALUES (5, 10);

-- Insert data into Mark table
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (15.0, 18.0, 17.0, 1);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (14.0, 16.0, 15.5, 2);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (13.0, 17.0, 16.0, 3);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (14.5, 18.5, 17.5, 4);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (13.5, 17.5, 16.5, 5);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (14.0, 16.0, 15.5, 6);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (15.0, 18.0, 17.0, 7);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (13.0, 17.0, 16.0, 8);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (14.5, 18.5, 17.5, 9);
INSERT INTO Mark (markCC, markExam, markTp, idModule) VALUES (13.5, 17.5, 16.5, 10);

-- Insert data into StudentMark table
INSERT INTO StudentMark (idStudent, idMark) VALUES (1, 1);
INSERT INTO StudentMark (idStudent, idMark) VALUES (2, 2);
INSERT INTO StudentMark (idStudent, idMark) VALUES (3, 3);
INSERT INTO StudentMark (idStudent, idMark) VALUES (4, 4);
INSERT INTO StudentMark (idStudent, idMark) VALUES (5, 5);
INSERT INTO StudentMark (idStudent, idMark) VALUES (6, 6);
INSERT INTO StudentMark (idStudent, idMark) VALUES (7, 7);
INSERT INTO StudentMark (idStudent, idMark) VALUES (8, 8);
INSERT INTO StudentMark (idStudent, idMark) VALUES (9, 9);
INSERT INTO StudentMark (idStudent, idMark) VALUES (10, 10);