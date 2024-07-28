import { request } from "@/helpers/axios_helper.js";
export var levelsData;
export var gradesData;
export var studentsData;


export function setUpGeneratePvPage(level, grade) {
  loadPEs().then(data => levelsData=data);
  loadGrades().then(data => gradesData=data);
  loadStudents(level, grade).then(data => studentsData=data);
}


async function loadPEs() {
  return await request(
    "POST",
    "/pv/planetude",
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}

async function loadGrades() {
  return await request(
    "POST",
    "/pv/grades",
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}


async function loadStudents(level, grade) {
  return await request(
    "POST",
    "/pv/generate-pv/getStudents",
    {
      level: level,
      grade: grade,
    }).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      console.log(error);
    },
  );
}
