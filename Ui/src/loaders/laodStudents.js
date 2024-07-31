import { request } from "@/helpers/axios_helper.js";
import { checkThenRefreshToken, getOut } from "@/helpers/refresh_token.js";


export async function loadPEs() {
  return await request(
    "POST",
    "/pv/planetude",
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      if (error.response.status === 401) {
        checkThenRefreshToken();
        throw error;
      } else
        getOut();
    },
  );
}

 export async function loadGrades(level)  {
  try {
    return loadGradesLocally("1A").then(data => {
      return data;
    });
  } catch (error) {
    console.log("omar");
    console.log(error);
    if (error.response.status === 401) {
      console.log("omar 401");

      // checkThenRefreshToken().then(() => loadGrades(level));
    } else
      getOut();
  }
}

async function loadGradesLocally(level) {
  return await request(
    "POST",
    "/pv/grades/" + level,
  ).then(
    (response) => {
      return response.data;
    });
}


export async function loadStudents(grade) {
  return await request(
    "POST",
    "/pv/generate-pv/getStudents",
    {
      grade: grade,
    }).then(
    (response) => {
      return response.data.map(student => ({
        img: "/img/team-2.jpeg",
        name: student.firstName + " " + student.lastName,
        email: student.email,
        identifier: student.identifier,
        online: true,
        score: "-",
      }));
    }).catch(
    (error) => {
      if (error.response.status === 401) {
        checkThenRefreshToken().then(() => loadStudents(grade));
      } else
        getOut();
    },
  );
}


// async function loadGradesLocally(level) {
//   return await request(
//     "POST",
//     "/pv/grades/" + level,
//   ).then(
//     (response) => {
//       return response.data;
//     }).catch(
//     (error) => {
//       if (error.response.status === 401) {
//         checkThenRefreshToken().then(() => loadGrades(level));
//       } else
//         getOut();
//     },
//   );
// }