import React, { useState } from "react";
import { Header } from "../../Components/Header/Header";
import "./loginpage.css";

const Loginpage = () => {
  const [isRegistering, setIsRegistering] = useState(false);

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
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <input type="password" placeholder="Verify Password" />
            <button>Register</button>
          </div>
        ) : (
          <div className="login_container">
            <input type="email" placeholder="Email" />
            <input type="password" placeholder="Password" />
            <button>Login</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Loginpage;
