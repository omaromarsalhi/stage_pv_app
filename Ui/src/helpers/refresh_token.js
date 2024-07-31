import { getRefreshToken, request, setAuthHeader, setRefreshHeader } from "@/helpers/axios_helper.js";
import { useNavigate } from "react-router-dom";


let username;
let my_refresh_token;

export function setUsernameAndToken(data) {
  username = data;
  my_refresh_token = getRefreshToken();
}

export async function checkThenRefreshToken() {
  checkToken().then(refresh => {
    if (!refresh) {
      setAuthHeader(null);
      return refreshToken(username, my_refresh_token);
    }
  });
}

function checkToken() {
  return request(
    "POST",
    "/auth/checkToken/" + username,
  ).then(
    (response) => {
      console.log("response " + response.data);
      if (response.data === ("Hi " + username + " !"))
        return true;
      else
        getOut();
    }).catch(
    (error) => {
      return false;
    },
  );
}


function refreshToken() {

  request(
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
  const navigate = useNavigate();
  window.localStorage.removeItem("auth_token");
  window.localStorage.removeItem("refresh_token");
  navigate("/auth/sign-in");
}