import React from "react";
import { Header } from "../../Components/Header/Header";
import "./cartpage.css";

const Cartpage = () => {
  return (
    <div className="cartpage_container">
      <Header />
      <h1>Cart</h1>
      <div className="cart_container">
        <p>Cart Items</p>
      </div>
    </div>
  );
};

export default Cartpage;
