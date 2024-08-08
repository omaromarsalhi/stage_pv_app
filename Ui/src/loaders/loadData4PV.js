import { request } from "@/helpers/axios_helper.js";
import { checkToken, getOut } from "@/helpers/refresh_token.js";


export async function generatePv(peName,idStudent) {
  console.log(peName,idStudent);
  return await checkToken().then(() => {
    return request(
      "POST",
      "/pv/generate-pv/generate",
      {
        peName: peName,
        idStudent: idStudent,
      }).then(
      (response) => {
        return response.data
      }).catch(
      (error) => {
        console.log(error);
      },
    );
  });
}

// export async function generatePv(peName,idStudent) {
//   return await checkToken().then(() => {
//     console.log(peName,idStudent);
//     return request(
//       "POST",
//       "/pv/generate-pv/generate",
//       {
//         peName: "1A",
//         idStudent: 923,
//       }).then(
//       (response) => {
//         return response.data
//       }).catch(
//       (error) => {
//         console.log(error);
//       },
//     );
//   });
// }
