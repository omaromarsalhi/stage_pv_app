import { checkToken, getOut } from "@/helpers/refresh_token.js";
import { request } from "@/helpers/axios_helper.js";



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