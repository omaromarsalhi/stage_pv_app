import { checkToken, getOut } from "@/helpers/refresh_token.js";
import { request } from "@/helpers/axios_helper.js";




export async function saveStudentsMarks(idModule,marks) {
  return await checkToken().then(() => {
    return  request(
      "POST",
      "/marks/saveMarks",
      {
        idModule: idModule,
        marks: marks
      },
    ).then(
      (response) => {
        console.log(response);
      }).catch(
      (error) => {
        console.log(error);
      },
    );
  });
}

export async function loadStudentsForSpecificProfessor(gradeName,moduleId) {
  return await checkToken().then(() => {
    return  request(
      "POST",
      "/marks/getStudents/"+gradeName+"/"+moduleId,
    ).then(
      (response) => {
        return response.data;
      }).catch(
      (error) => {
        console.log(error);
      },
    );
  });
}

export async function loadGradesAndModules(idProfessor) {
  return await checkToken().then(() => {
    return  request(
      "POST",
      "/marks/professorCredentials/"+idProfessor,
    ).then(
      (response) => {
        return response.data;
      }).catch(
      (error) => {
        console.log(error);
      },
    );
  });
}