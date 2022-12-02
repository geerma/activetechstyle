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
  const [fetchedBillingId, setFetchedBillingId] = useState();
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
      }
      window.alert("Purchase Successful");
      navigate("/history");
    }
  };

  const handleDelete = () => {
    deleteBilling();
    window.alert("Billing has been deleted");
    window.location.reload();
  }

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
        cardNumber: cardNumber,
        expiryDate: expiryDate,
        cvcNumber: cvcNumber,
      }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("New Billing: ",data);
        attachBillingToCustomer(data.id.toString());
      })
      .catch((error) => window.alert(error));
  };

  const attachBillingToCustomer = async (billingId) => {
    await fetch(`${backend_endpoint}/api/v1/billing/${billingId}/customer/${customerId}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
    })
    .then((res) => res.json())
    .then((data) => console.log("Attach Billing",data))
    .catch((error) => console.log(error));
  };

  const fetchBilling = async () => {
    await fetch(`${backend_endpoint}/api/v1/customer/byId/${customerId}`)
      .then((res) => res.json())
      .then((data) => {
        if (data.billing != null) {
          setHasBilling(true);
          setFetchedBillingId(data.billing.id);
          setCardNumber(data.billing.cardNumber);
          setExpiryDate(data.billing.expiryDate);
          setCvcNumber(data.billing.cvcNumber);
          console.log(data.billing);
        }
      })
      .catch((error) => console.log(error));
  };

  const deleteBilling = async () => {
    await fetch(`${backend_endpoint}/api/v1/billing/delete/${fetchedBillingId}`, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
    })
    .catch((error) => console.log(error));
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
            <button onClick={() => handleDelete()}>Delete Billing</button>
            <button onClick={() => handlePurchase()}>Purchase</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Cartpage;
