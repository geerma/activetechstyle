import React from "react";
import { Header } from "../../Components/Header/Header";
import "./stylepage.css";

const Stylepage = () => {
  return (
    <div className="style_container">
      <Header />
      <h1>Style</h1>
      <div className="product_container">
        <p>Paragraph</p>
      </div>
    </div>
  );
};

export default Stylepage;
