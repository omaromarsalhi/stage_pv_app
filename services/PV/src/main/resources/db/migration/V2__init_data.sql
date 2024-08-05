-- INSERT INTO Mark (idMark, markCC, markExam, markTp, idModule)
-- VALUES (16, 15.5, 14.0, 16.5, 16),
--        (17, 13.5, 12.0, 14.5, 17),
--        (18, 11.5, 10.0, 12.5, 18),
--        (19, 14.5, 13.0, 15.5, 19),
--        (20, 12.5, 11.0, 13.5, 20),
--        (21, 16.5, 15.0, 17.5, 21),
--        (22, 14.0, 13.5, 15.0, 22),
--        (23, 14.0, 13.5, 15.0, 23)
-- ON CONFLICT (idMark) DO NOTHING;


DO
$$
    DECLARE
        grade_id    INT;
        student_id  INT;
        mark_id     INT = 1;
        sub_mark_id INT = 1;
        v1          INT = 923;
        v2          INT = 953;
    BEGIN
        FOR grade_id IN 1..15
            LOOP
                FOR student_id IN v1..v2
                    LOOP
                        FOR sub_mark_id IN 1..23
                            LOOP
                                INSERT INTO StudentMark (idStudent, idMark)
                                VALUES (student_id, sub_mark_id)
                                ON CONFLICT (idStudent, idMark) DO NOTHING;
                            END LOOP;
                    END LOOP;
                v1 := v2 + 1;
                v2 := v2 + 30;
            END LOOP;
    END
$$;

