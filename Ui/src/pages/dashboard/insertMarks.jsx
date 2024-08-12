import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import {
  loadGradesAndModules,
  loadStudentsForSpecificProfessor,
  saveStudentsMarks,
} from "@/loaders/loadProfessorData.js";
import { Avatar, Typography } from "@material-tailwind/react";
import SuccessPopup from "@/widgets/layout/SuccessPopup.jsx";

export function InsertMarks() {
  const [gradesAndModule, setGradesAndModule] = useState([]);
  const [grade, setGrade] = useState("");
  const [module, setModule] = useState([{ moduleName: "", moduleId: 0 }]);
  const [studentMarks, setStudentMarks] = useState({});
  const [students, setStudents] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [isTpEnabled, setIsTpEnabled] = useState(false);
  const [showPopup, setShowPopup] = useState(false);

  const user = useSelector((state) => state.user);

  useEffect(() => {
    loadGradesAndModules(user.idUser).then((data) => {
      const gradeName = data.data[0].gradeName;
      const moduleName = data.data[0].moduleName;
      const moduleId = data.data[0].moduleId;
      setModule({ moduleName, moduleId });
      setGrade(gradeName);
      setGradesAndModule(data.data);
    });
  }, []);

  useEffect(() => {
    if (grade !== "")
      loadStudentsForSpecificProfessor(grade, module.moduleId).then((data) => {
        setStudents(data);
        setIsLoading(false);
      });
  }, [grade]);

  const handleGradeChange = (event) => {
    setGrade(event.target.value);
    gradesAndModule.map(({ gradeName, moduleName, moduleId }) => {
      if (event.target.value === gradeName) {
        setModule({ moduleName, moduleId });
      }
    });
  };

  const handleMarksChange = (id, type, value) => {
    if (isTpEnabled) {
      setStudentMarks((prevMarks) => ({
        ...prevMarks,
        [id]: {
          ...prevMarks[id],
          [type]: value,
        },
      }));
    } else {
      setStudentMarks((prevMarks) => ({
        ...prevMarks,
        [id]: {
          ...prevMarks[id],
          [type]: value,
          tp: -1,
        },
      }));
    }
  };


  const handleTpToggle = () => {
    setIsTpEnabled(!isTpEnabled);
  };


  const handleSubmit = (event) => {
    event.preventDefault();
    saveStudentsMarks(module.moduleId, studentMarks).then((data) => {
        if (data === "done")
          setShowPopup(true);
      },
    );
  };

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto p-4">
      <h2 className="text-2xl font-bold mb-4">Insert Student Marks</h2>

      <div className="mb-4 flex flex-row items-center gap-5">
        <div className="flex gap-5 justify-center items-center w-full">
          <label className="block text-sm font-medium text-gray-700">
            Select Grade:
          </label>
          <select
            value={grade}
            onChange={handleGradeChange}
            className="mt-1 block w-full p-2 border border-gray-300 rounded-md"
          >
            {gradesAndModule.map(({ gradeName }) => {
              return <option value={gradeName}>{gradeName}</option>;
            })}
          </select>
        </div>
        <div className="flex gap-5 justify-center items-center w-full">
          <label className="block text-size[20px] text-gray-700">
            <h2>
              Module: <span className="text-red-700">{module.moduleName}</span>
            </h2>
          </label>
        </div>
      </div>

      <div className="mb-4">
        <label className="flex items-center">
          <input
            type="checkbox"
            checked={isTpEnabled}
            onClick={handleTpToggle}
            className="mr-2"
          />
          Enable TP Marks
        </label>
      </div>

      <form onSubmit={handleSubmit} className="pt-4">
        <table className="min-w-full bg-white">
          <thead>
          <tr>
            <th className="py-2 px-4 border-b flex justify-start">Student</th>
            <th className="py-2 px-4 border-b">Exam Mark</th>
            <th className="py-2 px-4 border-b">TP</th>
            <th className="py-2 px-4 border-b">CC</th>
          </tr>
          </thead>
          <tbody>
          {students.map((data, index) => (
            <tr key={data.student.idUser}>
              <td className="py-2 px-4 border-b flex justify-start">
                <div className="flex items-center gap-4">
                  <Avatar src="/img/team-2.jpeg" size="sm" variant="rounded" />
                  <div>
                    <Typography
                      variant="small"
                      color="blue-gray"
                      className="font-semibold"
                    >
                      {data.student.firstName + " " + data.student.lastName}
                    </Typography>
                    <Typography className="text-xs font-normal text-blue-gray-500">
                      {data.student.email}
                    </Typography>
                  </div>
                </div>
              </td>
              <td className="py-2 px-4 border-b">
                <input
                  type="number"
                  placeholder="Exam Mark"
                  value={
                    studentMarks[data.student.idUser]?.exam ||
                    data.marks.exam
                  }
                  onChange={(e) =>
                    handleMarksChange(data.student.idUser, "exam", e.target.value)
                  }
                  className="border p-2 rounded w-full"
                />
              </td>
              <td className="py-2 px-4 border-b">
                <input
                  type="number"
                  placeholder="TP"
                  value={
                    isTpEnabled
                      ? studentMarks[data.student.idUser]?.tp ||
                      data.marks.tp
                      : -1
                  }
                  onChange={(e) =>
                    handleMarksChange(data.student.idUser, "tp", e.target.value)
                  }
                  className="border p-2 rounded w-full"
                  disabled={!isTpEnabled}
                />
              </td>
              <td className="py-2 px-4 border-b">
                <input
                  type="number"
                  placeholder="CC"
                  value={
                    studentMarks[data.student.idUser]?.cc || data.marks.cc
                  }
                  onChange={(e) =>
                    handleMarksChange(data.student.idUser, "cc", e.target.value)
                  }
                  className="border p-2 rounded w-full"
                />
              </td>
            </tr>
          ))}
          </tbody>
        </table>

        <div className="flex items-center justify-end">
          <button
            type="submit"
            className="mt-4 bg-blue-500 text-white px-4 py-2 rounded-md"
          >
            Submit Marks
          </button>
          {showPopup &&
            <SuccessPopup message="Success! Marks have been inserted successfully"
                          onClose={() => setShowPopup(false)} />}
        </div>
      </form>
    </div>
  );
}

export default InsertMarks;



