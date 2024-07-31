import React, { useState, useEffect } from 'react';
import { loadModules, loadGrades, loadStudents, submitMarks } from '../../helpers/api';
import ModuleSelector from '../../widgets/ModuleSelector';
import GradeSelector from '../../widgets/GradeSelector';
import StudentList from '../../widgets/StudentList';

const GradeEntryPage = () => {
    const [modules, setModules] = useState([]);
    const [grades, setGrades] = useState([]);
    const [students, setStudents] = useState([]);
    const [selectedModule, setSelectedModule] = useState(null);
    const [selectedGrade, setSelectedGrade] = useState(null);
    const [marks, setMarks] = useState({});

    useEffect(() => {
        loadModules().then(setModules);
        loadGrades().then(setGrades);
        loadStudents().then(setStudents);
    }, []);

    const handleModuleChange = (module) => setSelectedModule(module);
    const handleGradeChange = (grade) => setSelectedGrade(grade);
    const handleMarkChange = (studentId, markType, value) => {
        setMarks(prevMarks => ({
            ...prevMarks,
            [studentId]: {
                ...prevMarks[studentId],
                [markType]: value
            }
        }));
    };

    const handleSubmit = () => {
        submitMarks({ module: selectedModule, grade: selectedGrade, marks });
    };

    return (
        <div>
            <h1>Grade Entry Page</h1>
            <ModuleSelector modules={modules} onChange={handleModuleChange} />
            <GradeSelector grades={grades} onChange={handleGradeChange} />
            <StudentList
                students={students}
                marks={marks}
                onMarkChange={handleMarkChange}
            />
            <button onClick={handleSubmit}>Submit Marks</button>
        </div>
    );
};

export default GradeEntryPage;
