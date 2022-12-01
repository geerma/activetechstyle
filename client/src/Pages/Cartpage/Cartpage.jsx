import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import "./cartpage.css";

const Cartpage = () => {

  const navigate = useNavigate();

  useEffect(() => {
    if (sessionStorage.getItem("customerId") == "null" || sessionStorage.getItem("customerId") == undefined) {
      navigate("/login");
    }
  }, []);

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
