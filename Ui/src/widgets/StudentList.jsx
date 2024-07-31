import React from 'react';

const StudentList = ({ students = [], marks = {}, onMarkChange }) => {
    return (
        <div>
            <h2>Student List</h2>
            {students.map((student) => (
                <div key={student.id}>
                    <span>{student.name}</span>
                    {/* Add form elements to input marks */}
                </div>
            ))}
        </div>
    );
};

export default StudentList;
