import React from "react";
import "./homepage.css";

import activeLogo from "../../assets/active.png";
import techLogo from "../../assets/tech.png";
import styleLogo from "../../assets/style.png";
import { useNavigate } from "react-router-dom";

const Homepage = () => {

  const navigate = useNavigate();

  return (
    <div className="Home">
      <div>
        <a href="/active" target="_blank">
          <img src={activeLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="/tech" target="_blank">
          <img src={techLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="/style" target="_blank">
          <img src={styleLogo} className="logo" alt="Vite logo" />
        </a>
      </div>
      <h1>Active Tech Style</h1>
      <div className="card">
        <button onClick={() => navigate("/active")}>
          Active
        </button>
        <button onClick={() => navigate("/tech")}>
          Tech
        </button>
        <button onClick={() => navigate("/style")}>
          Style
        </button>
        <p>Paragraph</p>
      </div>
    </div>
  );
};

export default Homepage;
