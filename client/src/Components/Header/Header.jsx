import React from "react";
import "./header.css";

import { useNavigate } from "react-router-dom";
import logo from "../../assets/activetechstylelogo.png";

export const Header = () => {
  const navigate = useNavigate();

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
      </div>
      <div className="header_login">
        <button onClick={() => navigate("/login")}>Login / Signup</button>
      </div>
    </div>
  );
};
