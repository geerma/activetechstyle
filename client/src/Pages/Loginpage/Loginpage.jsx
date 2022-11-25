import React, { useState } from "react";
import { Header } from "../../Components/Header/Header";
import "./loginpage.css";

const Loginpage = () => {
  const [isRegistering, setIsRegistering] = useState(false);

  const loginSubmit = () => {
    console.log("login")
  }

  const registerSubmit = () => {
    console.log("Register")
  }

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
            <input type="text" placeholder="Name" />
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <input type="password" placeholder="Verify Password" />
            <button onClick={() => registerSubmit()}>Register</button>
          </div>
        ) : (
          <div className="login_container">
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <button onClick={() => loginSubmit()}>Login</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Loginpage;
