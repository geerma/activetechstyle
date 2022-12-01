import React, { useEffect, useState } from "react";
import "./header.css";

import { useNavigate } from "react-router-dom";
import logo from "../../assets/activetechstylelogo.png";
import historyLogo from "../../assets/historylogo.jpg"
import cartLogo from "../../assets/cartlogo.jpg";
import magnifyglassLogo from "../../assets/magnifyglass.jpg";

export const Header = () => {
  const navigate = useNavigate();

  const [token, setToken] = useState("null");

  useEffect(() => {
    if (sessionStorage.getItem("customerId") == null) {
      sessionStorage.setItem("customerId", "null");
      setToken("null");
    } else {
      setToken(sessionStorage.getItem("customerId"));
    }
    console.log(sessionStorage.getItem("customerId"))
  }, []);

  const handleSignout = () => {
    sessionStorage.setItem("customerId", "null");
    setToken(sessionStorage.getItem("customerId"));
    navigate("/");
    window.location.reload();
  }

  return (
    <div className="header_container">
      <div className="header_logo">
        <a href="/">
          <img src={logo} height={60} />
        </a>
      </div>
      <div className="header_category">
        <button onClick={() => navigate("/active")}>Active</button>
        <button onClick={() => navigate("/tech")}>Tech</button>
        <button onClick={() => navigate("/style")}>Style</button>
        <input placeholder="Search" />
        <button>
          <img img src={magnifyglassLogo} height={20} />
        </button>
      </div>
      <div className="header_login">
        {(token != "null") ? (
          <button onClick={() => handleSignout()}>Signout</button>
        ) : (
          <button onClick={() => navigate("/login")}>Login / Signup</button>
        )}

        <button><img img src={historyLogo} height={30} onClick={() => navigate("/history")} /></button>
        <button><img img src={cartLogo} height={30} onClick={() => navigate("/cart")} /></button>
      </div>
    </div>
  );
};
