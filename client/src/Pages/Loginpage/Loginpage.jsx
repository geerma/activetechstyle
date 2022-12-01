import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import "./loginpage.css";

const Loginpage = () => {
  const [isRegistering, setIsRegistering] = useState(false);

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  const [registerName, setRegisterName] = useState();
  const [registerEmail, setRegisterEmail] = useState();
  const [registerPassword, setRegisterPassword] = useState();
  const [verifyRegisterPassword, setVerifyRegisterPassword] = useState();

  const navigate = useNavigate();

  const backend_endpoint = "http://localhost:8080";

  const login = async () => {
    await fetch(
      `${backend_endpoint}/api/v1/customer/login/?email=${email}&password=${password}`
    )
      .then((res) => res.json())
      .then((data) => verifyLogin(data))
      .catch(() => window.alert("Incorrect Username or Password"));
  };

  const verifyLogin = (response) => {
    if (response != null) {
      if (response.id == undefined) {
        window.alert("Invalid login. User may not exist.")
      } else {
        sessionStorage.setItem("customerId", response.id);
        navigate("/");
      }
    } else {
      window.alert("Invalid Username or Password");
    }
  }

  const registerRequestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      name: registerName,
      email: registerEmail,
      password: registerPassword,
    }),
  };

  const register = async () => {
    await fetch(`${backend_endpoint}/api/v1/customer/`, registerRequestOptions)
      .then((res) => res.json())
      .then((data) => verifyRegister(data))
      .catch((error) => window.alert(error));
  };

  const verifyRegister = (response) => {
    if (response.id != undefined) {
      window.alert("You have successfully registered.");
      sessionStorage.setItem("customerId", response.id);
      navigate("/");
    } else {
      window.alert("User already exists. Please try again.")
    } 
  }

  const loginSubmit = () => {
    if (email != undefined && password != undefined) {
      login();
    } else {
      window.alert("Please enter a valid email and password.");
    }
  };

  const registerSubmit = () => {
    if (
      registerName == undefined ||
      registerEmail == undefined ||
      registerPassword == undefined
    ) {
      window.alert("Please fill in all inputs.");
    } else if (registerPassword == verifyRegisterPassword) {
      register();
    } else {
      window.alert("Please check that your passwords are matching.");
    }
  };

  return (
    <div className="loginpage_container">
      <Header />
      <div className="loginregister_container">
        <h1>Login</h1>
        <button onClick={() => setIsRegistering(!isRegistering)}>
          {isRegistering ? <div>Login</div> : <div>Register</div>}
        </button>
        {isRegistering ? (
          <div className="register_container">
            <input
              type="text"
              placeholder="Name"
              key={1}
              onChange={(e) => setRegisterName(e.target.value)}
              required
            />
            <input
              type="email"
              placeholder="Email"
              key={2}
              onChange={(e) => setRegisterEmail(e.target.value)}
              required
            />
            <input
              type="password"
              placeholder="Password"
              key={3}
              onChange={(e) => setRegisterPassword(e.target.value)}
              required
            />
            <input
              type="password"
              placeholder="Verify Password"
              key={4}
              onChange={(e) => setVerifyRegisterPassword(e.target.value)}
              required
            />
            <button onClick={() => registerSubmit()}>Register</button>
          </div>
        ) : (
          <div className="login_container">
            <input
              type="email"
              placeholder="Email"
              onChange={(e) => setEmail(e.target.value)}
              key={5}
              required
            />
            <input
              type="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              key={6}
              required
            />
            <button onClick={() => loginSubmit()}>Login</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Loginpage;
