import React from 'react';

const StudentList = ({ students = [], marks = {}, onMarkChange }) => {
    return (
        <div>
            <h2>Student List</h2>
            {students.map((student) => (
                <div key={student.idUser}>
                    <span>{student.firstname} {student.lastname}</span>
                    <div>
                        <input
                            type="number"
                            placeholder="CC"
                            value={marks[student.idUser]?.markCc || ''}
                            onChange={(e) => onMarkChange(student.idUser, 'markCc', e.target.value)}
                        />
                        <input
                            type="number"
                            placeholder="Exam"
                            value={marks[student.idUser]?.markExam || ''}
                            onChange={(e) => onMarkChange(student.idUser, 'markExam', e.target.value)}
                        />
                        <input
                            type="number"
                            placeholder="TP"
                            value={marks[student.idUser]?.markTp || ''}
                            onChange={(e) => onMarkChange(student.idUser, 'markTp', e.target.value)}
                        />
                    </div>
                </div>
            ))}
        </div>
    );
};

export default StudentList;
