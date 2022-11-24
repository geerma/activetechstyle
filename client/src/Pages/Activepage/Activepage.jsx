import React from "react";
import { Header } from "../../Components/Header/Header";
import "./activepage.css";

const Activepage = () => {
  return (
    <div className="active_container">
      <Header />
      <h1>Active</h1>
      <div className="product_container">
        <p>Paragraph</p>
      </div>
    </div>
  );
};

export default Activepage;
