import React from 'react';

const GradeSelector = ({ grades = [], onChange }) => {
    return (
        <div>
            <label htmlFor="grade">Select Grade:</label>
            <select id="grade" onChange={(e) => onChange(e.target.value)}>
                <option value="">Select...</option>
                {grades.map((grade) => (
                    <option key={grade.id} value={grade.id}>
                        {grade.name}
                    </option>
                ))}
            </select>
        </div>
    );
};

export default GradeSelector;
