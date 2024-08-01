import { getRefreshToken, request, setAuthHeader, setRefreshHeader } from "@/helpers/axios_helper.js";
import { useNavigate } from "react-router-dom";


let username;
let my_refresh_token;
let navigate;

export function setUsernameAndToken(data) {
  username = data;
  my_refresh_token = getRefreshToken();
  navigate = useNavigate();
}



export async function checkToken() {
  return await request(
    "POST",
    "/auth/checkToken/" + username,
  ).then(
    (response) => {
      console.log("response " + response.data);
      if (response.data !== ("Hi " + username + " !"))
        getOut();
    }).catch(
    async (error) => {
      setAuthHeader(null);
      await refreshToken();
    },
  );
}


async function refreshToken() {
  await request(
    "POST",
    "/auth/refresh",
    {
      username: username,
      refreshToken: my_refresh_token,
    },
  ).then(
    (response) => {
      setAuthHeader(response.data.token);
      setRefreshHeader(response.data.refreshToken);
    }).catch(
    (error) => {
      getOut();
    },
  );
}

export function getOut() {
  window.localStorage.removeItem("auth_token");
  window.localStorage.removeItem("refresh_token");
  navigate("/auth/sign-in");
}