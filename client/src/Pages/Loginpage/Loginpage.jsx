import React, { useState } from "react";
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

  const backend_endpoint = "http://localhost:8080";

  const login = async () => {
    await fetch(
      `${backend_endpoint}/api/v1/customer/login/?email=${email}&password=${password}`
    )
      .then((res) => res.json())
      .then((data) => console.log(data))
      .catch((error) => window.alert(error));
  };

  const registerRequestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      name: "Default Name",
      email: email,
      password: password,
    }),
  };

  const register = async () => {
    await fetch(`${backend_endpoint}/api/v1/customer/`, registerRequestOptions)
      .then((res) => res.json())
      .then((data) => console.log(data))
      .catch((error) => window.alert(error));
  };

  const loginSubmit = () => {
    if (email != undefined && password != undefined) {
      login();
    } else {
      window.alert("Please enter a valid email and password.")
    }
  };

  const registerSubmit = () => {
    if (registerName == undefined || registerEmail == undefined || registerPassword == undefined) {
      window.alert("Please fill in all inputs.")
    }

    if (registerPassword == verifyRegisterPassword) {
      console.log(email + " " + password);
      register();
    } else {
      window.alert("Please check that your passwords are matching.")
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
            />
            <input
              type="email"
              placeholder="Email"
              key={2}
              onChange={(e) => setRegisterEmail(e.target.value)}
            />
            <input
              type="password"
              placeholder="Password"
              key={3}
              onChange={(e) => setRegisterPassword(e.target.value)}
            />
            <input
              type="password"
              placeholder="Verify Password"
              key={4}
              onChange={(e) => setVerifyRegisterPassword(e.target.value)}
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
            />
            <input
              type="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              key={6}
            />
            <button onClick={() => loginSubmit()}>Login</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Loginpage;
