import { request } from "@/helpers/axios_helper.js";
import { checkToken, getOut } from "@/helpers/refresh_token.js";




export async function loadStudentData() {
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