import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import "./cartpage.css";

const Cartpage = () => {
  const navigate = useNavigate();

  const [cartItems, setCartItems] = useState();
  const [cardNumber, setCardNumber] = useState();
  const [expiryDate, setExpiryDate] = useState();
  const [cvcNumber, setCvcNumber] = useState();

  useEffect(() => {
    if (
      sessionStorage.getItem("customerId") == "null" ||
      sessionStorage.getItem("customerId") == undefined
    ) {
      navigate("/login");
    }

    if (sessionStorage.getItem("cartItems") != undefined) {
      setCartItems(sessionStorage.getItem("cartItems").split(","));
    }
  }, []);

  const handlePurchase = () => {
    const purchaseCartList = cartItems.map((item) => parseInt(item));
    console.log(purchaseCartList);
  };

  return (
    <div className="cartpage_container">
      {/* {sessionStorage.setItem("cartItems", [4,5,6])} */}
      {/* {console.log(cartItems)} */}
      <Header />
      <h1>Cart:</h1>
      <p>Cart Items</p>
      <div className="cart_container">
        {cartItems &&
          cartItems.map((item, index) => <div key={index}>{item}</div>)}
      </div>
      <div className="billing_container">
        <input
          placeholder="Card Number"
          onChange={(e) => setCardNumber(e.target.value)}
        />
        <input
          placeholder="Expiry Date (YYYY-MM-DD)"
          onChange={(e) => setExpiryDate(e.target.value)}
        />
        <input
          placeholder="CVC Number"
          onChange={(e) => setCvcNumber(e.target.value)}
        />
        <button onClick={() => handlePurchase()}>Purchase</button>
      </div>
    </div>
  );
};

export default Cartpage;
