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
        const fetchData = async () => {
            try {
                const modulesData = await loadModules();
                setModules(modulesData);

                if (selectedModule) {
                    const gradesData = await loadGrades(selectedModule.idModule);
                    setGrades(gradesData);
                }

                if (selectedGrade) {
                    const usersData = await loadStudents(selectedGrade.idGrade);
                    const studentsData = usersData.filter(user => user.role === 'student'); // Filtrer les étudiants
                    setStudents(studentsData);
                }
            } catch (error) {
                console.error('Error loading data:', error);
            }
        };

        fetchData();
    }, [selectedModule, selectedGrade]);

    const handleModuleChange = (module) => setSelectedModule(module);
    const handleGradeChange = (grade) => setSelectedGrade(grade);
    const handleMarkChange = (studentId, markType, value) => {
        setMarks(prevMarks => ({
            ...prevMarks,
            [studentId]: {
                ...prevMarks[studentId],
                [markType]: parseFloat(value) || 0
            }
        }));
    };

    const handleSubmit = async () => {
        try {
            await submitMarks({ module: selectedModule, grade: selectedGrade, marks });
            alert('Marks submitted successfully');
        } catch (error) {
            console.error('Error submitting marks:', error);
            alert('Failed to submit marks');
        }
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
