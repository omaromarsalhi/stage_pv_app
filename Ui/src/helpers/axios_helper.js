import axios from 'axios';


export const getAuthToken = () => {
    return window.localStorage.getItem('auth_token');
};

export const getRefreshToken = () => {
    return window.localStorage.getItem('refresh_token');
};

export const setAuthHeader = (token) => {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
};

export const setRefreshHeader = (token) => {
    if (token !== null) {
        window.localStorage.setItem("refresh_token", token);
    } else {
        window.localStorage.removeItem("refresh_token");
    }
};

axios.defaults.baseURL = 'http://localhost:8888/api';
axios.defaults.headers.post['Content-Type'] = 'application/json';

export const request = (method, url, data) => {

    let headers = {};
    if (getAuthToken() !== null && getAuthToken() !== "null") {
        headers = {'Authorization': `Bearer ${getAuthToken()}`};
    }

    return axios({
        method: method,
        url: url,
        headers: headers,
        data: data
    });
};