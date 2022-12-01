import React, { useEffect, useState } from "react";
import { render } from "react-dom";
import { useNavigate } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import "./cartpage.css";

const Cartpage = () => {
  const navigate = useNavigate();

  const [cartItems, setCartItems] = useState();
  const [hasBilling, setHasBilling] = useState(false);
  const [cardNumber, setCardNumber] = useState();
  const [expiryDate, setExpiryDate] = useState();
  const [cvcNumber, setCvcNumber] = useState();

  const customerId = sessionStorage.getItem("customerId");
  let purchaseCartList = [];

  useEffect(() => {
    if (
      sessionStorage.getItem("customerId") == "null" ||
      sessionStorage.getItem("customerId") == undefined
    ) {
      navigate("/login");
    } else {
      fetchBilling();
    }

    if (sessionStorage.getItem("cartItems") != undefined) {
      setCartItems(sessionStorage.getItem("cartItems").split(","));
    }
  }, []);

  const handlePurchase = () => {
    if (cartItems == undefined) {
      window.alert("Please add items to cart");
    } else {
      purchaseCartList = cartItems.map((item) => parseInt(item));
      console.log(purchaseCartList);
      purchase(purchaseCartList);
      sessionStorage.removeItem("cartItems");
      if (hasBilling == false) {
        addNewBilling();
        // attachBillingToCustomer();
      }
      window.alert("Purchase Successful");
      // navigate("/history");
    }
  };

  const backend_endpoint = "http://localhost:8080";

  const purchase = async (purchaseCartList) => {
    await fetch(`${backend_endpoint}/api/v1/cart/customer/${customerId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        data: purchaseCartList,
      }),
    })
      .then((res) => res.json())
      .then((data) => console.log("Purchase Log: ",data))
      .catch((error) => window.alert(error));
  };

  const addNewBilling = async () => {
    await fetch(`${backend_endpoint}/api/v1/billing/`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        cardNumber: "00875000112",
        expiryDate: "2025-11-01",
        cvcNumber: "183",
      }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("New Billing: ",data);
      })
      .catch((error) => window.alert(error));
  };

  const attachBillingToCustomer = async () => {
    await fetch(`${backend_endpoint}/api/v1/billing/1/customer/${customerId}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
    })
    .then((res) => res.json())
    // .then((data) => console.log(data))
    .catch((error) => console.log(error));
  };

  const fetchBilling = async () => {
    await fetch(`${backend_endpoint}/api/v1/customer/byId/${customerId}`)
      .then((res) => res.json())
      .then((data) => {
        if (data.billing != null) {
          setHasBilling(true);
          setCardNumber(data.billing.cardNumber);
          setExpiryDate(data.billing.expiryDate);
          setCvcNumber(data.billing.cvcNumber);
          console.log(data.billing);
        }
      })
      .catch((error) => console.log(error));
  };

  const deleteBilling = async () => {
    console.log("delete");
  };

  return (
    <div className="cartpage_container">
      <Header />
      <h1>Cart:</h1>
      <p>Cart Items</p>
      <div className="cart_container">
        {cartItems &&
          cartItems.map((item, index) => <div key={index}>{item}</div>)}
      </div>
      <div>
        {hasBilling == false ? (
          <div className="billing_container">
            <h2>Billing Information:</h2>
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
        ) : (
          <div className="billing_container">
            <h2>Billing Information:</h2>
            <p>You already have a credit card in our system</p>
            <p>Ending in: {cardNumber.toString().slice(-4)}</p>
            <p>Expiring in: {expiryDate}</p>
            <button onClick={() => deleteBilling()}>Delete Billing</button>
            <button onClick={() => handlePurchase()}>Purchase</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Cartpage;
