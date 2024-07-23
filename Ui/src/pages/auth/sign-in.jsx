import {
  Input,
  Checkbox,
  Button,
  Typography,
} from "@material-tailwind/react";
import { Link, useNavigate } from "react-router-dom";
import { func } from "prop-types";
import { request, setAuthHeader, setRefreshHeader } from "@/helpers/axios_helper.js";
import { useState } from "react";


export function SignIn() {

  const [formData, setFormData] = useState({
    email: "",
    password: "",
    agreeToTerms: false,
  });

  const [errors, setErrors] = useState({
    email: "",
    password: "",
    user: "",
  });

  const navigate = useNavigate();

  let onChangeHandler = (event) => {
    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value,
    }));
  };

  let onLogin = (e) => {
    e.preventDefault();
    request(
      "POST",
      "auth/login",
      {
        email: formData.email,
        password: formData.password,
      }).then(
      (response) => {
        setAuthHeader(response.data.token);
        setRefreshHeader(response.data.refreshToken);
        navigate('/dashboard/profile')
      }).catch(
      (error) => {
        setAuthHeader(null);
        setErrors(error.response.data);
      },
    );
  };


  return (
    <section className="m-8 flex gap-4">
      <div className="w-full lg:w-3/5 mt-24">
        <div className="text-center">
          <Typography variant="h2" className="font-bold mb-4">Sign In</Typography>
          <Typography variant="paragraph" color="blue-gray" className="text-lg font-normal">Enter your email and
            password to Sign In.</Typography>
        </div>
        <form className="mt-8 mb-2 mx-auto w-80 max-w-screen-lg lg:w-1/2">
          {errors.email && (
            <div className="mb-4 text-red-500 text-center">
              <Typography variant="h6">{errors.email}</Typography>
            </div>
          )}
          {errors.password && (
            <div className="mb-4 text-red-500 text-center">
              <Typography variant="h6">{errors.password}</Typography>
            </div>
          )}
          {errors.user && (
            <div className="mb-4 text-red-500 text-center">
              <Typography variant="h6">{errors.user}</Typography>
            </div>
          )}
          <div className="mb-1 flex flex-col gap-6">
            <Typography variant="small" color="blue-gray" className="-mb-3 font-medium">
              Your email
            </Typography>
            <Input
              name="email"
              onChange={onChangeHandler}
              size="lg"
              placeholder="name@mail.com"
              className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
              labelProps={{
                className: "before:content-none after:content-none",
              }}
            />
            <Typography variant="small" color="blue-gray" className="-mb-3 font-medium">
              Password
            </Typography>
            <Input
              name="password"
              onChange={onChangeHandler}
              type="password"
              size="lg"
              placeholder="********"
              className=" !border-t-blue-gray-200 focus:!border-t-gray-900"
              labelProps={{
                className: "before:content-none after:content-none",
              }}
            />
          </div>
          <Button onClick={onLogin} className="mt-6" fullWidth>
            Sign In
          </Button>
          <div className="flex items-center justify-between gap-2 mt-6">
            <Typography variant="small" className="font-medium text-gray-900">
              <a href="#">
                Forgot Password
              </a>
            </Typography>
          </div>
        </form>
      </div>
      <div className="w-2/5 h-full hidden lg:block">
        <img
          src="/img/pattern.png"
          className="h-full w-full object-cover rounded-3xl"
        />
      </div>

    </section>
  );
}

export default SignIn;
