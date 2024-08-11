import { request } from "@/helpers/axios_helper.js";
import { checkToken, getOut } from "@/helpers/refresh_token.js";


export async function loadPEs() {
  return await checkToken().then(() => {
  return  request(
    "POST",
    "/pv/planetude",
  ).then(
    (response) => {
      return response.data;
    }).catch(
    (error) => {
      getOut();
    },
  );
  });
}

export async function loadGrades(level) {
  return await checkToken().then(() => {
    return request(
      "POST",
      "/pv/grades/" + level,
    ).then(
      (response) => {
        return response.data;
      }).catch(
      (error) => {
        getOut();
      },
    );
  });
}


export async function loadStudents(grade) {
  return await checkToken().then(() => {
    return request(
      "POST",
      "/pv/generate-pv/getStudents",
      {
        grade: grade,
      }).then(
      (response) => {
        return response.data.map(student => ({
          img: "/img/team-2.jpeg",
          idUser: student.idUser,
          name: student.firstName + " " + student.lastName,
          email: student.email,
          identifier: student.identifier,
          online: true,
          score: "-",
        }));
      }).catch(
      (error) => {
        getOut();
      },
    );
  });
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