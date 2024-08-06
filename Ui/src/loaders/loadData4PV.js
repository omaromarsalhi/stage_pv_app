import { request } from "@/helpers/axios_helper.js";
import { checkToken, getOut } from "@/helpers/refresh_token.js";


export async function generatePv() {
  return await checkToken().then(() => {
    return request(
      "POST",
      "/pv/generate-pv/generate",
      {
        idPe: 1,
        idStudent: 923,
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