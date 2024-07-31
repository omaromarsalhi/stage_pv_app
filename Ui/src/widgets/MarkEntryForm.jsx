import React, { useState } from 'react';

const MarkEntryForm = ({ users, onSubmit }) => {
    const [marks, setMarks] = useState([]);

    const handleMarkChange = (idUser, mark) => {
        setMarks(prevMarks => {
            const updatedMarks = [...prevMarks];
            const markIndex = updatedMarks.findIndex(m => m.idUser === idUser);
            if (markIndex > -1) {
                updatedMarks[markIndex].mark = mark;
            } else {
                updatedMarks.push({ idUser, mark });
            }
            return updatedMarks;
        });
    };

    return (
        <div>
            <h3>Enter Marks</h3>
            {users.map(user => (
                <div key={user.id}>
                    <span>{user.firstname} {user.lastname}</span>
                    <input
                        type="number"
                        placeholder="Enter mark"
                        onChange={(e) => handleMarkChange(user.id, e.target.value)}
                    />
                </div>
            ))}
            <button onClick={() => onSubmit(marks)}>Submit Marks</button>
        </div>
    );
};

export default MarkEntryForm;
