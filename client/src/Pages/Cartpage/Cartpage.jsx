import React, { useEffect, useRef, useState } from "react";
import { render } from "react-dom";
import { useNavigate } from "react-router-dom";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import Order from "../../Components/Order/Order";
import "./cartpage.css";

/**
 * Page for the user's cart prior to checkout.
 * Contains the products within the cart and billing information inputs.
 * @returns
 */
const Cartpage = () => {
  const navigate = useNavigate();
  const effectRan = useRef(false);

  // Cart variables
  const [cartProducts, setCartProducts] = useState([]);
  const [cartItems, setCartItems] = useState();

  // Billing variables
  const [hasBilling, setHasBilling] = useState(false);
  const [cardNumber, setCardNumber] = useState();
  const [expiryDate, setExpiryDate] = useState();
  const [cvcNumber, setCvcNumber] = useState();

  // Variables to retrieve billing information from signed-in user
  const customerId = sessionStorage.getItem("customerId");
  const [fetchedBillingId, setFetchedBillingId] = useState();
  let purchaseCartList = [];

  /**
   * On page load, useEffect will do the following:
   * - If user is not logged in, navigate to "login" page
   * - If user is logged in, get product ids from the sessionStorage "cartItems", then fetch their data from the API
   */
  useEffect(() => {
    if (
      sessionStorage.getItem("customerId") == "null" ||
      sessionStorage.getItem("customerId") == undefined
    ) {
      navigate("/login");
    } else {
      fetchBilling();
    }

    if (effectRan.current) return;

    if (sessionStorage.getItem("cartItems") != undefined) {
      setCartItems(sessionStorage.getItem("cartItems").split(","));
      const cart = sessionStorage.getItem("cartItems").split(",");
      cart.forEach((itemId) => fetchProducts(itemId));
    }

    return () => (effectRan.current = true);
  }, []);

  /**
   * Function is called when the submit button is pressed.
   * Handles checks for if there are no items in the cart, and if billing info is empty
   */
  const handlePurchase = () => {
    if (cartItems == undefined) {
      window.alert("Please add items to cart");
    } else if (
      cardNumber == undefined ||
      expiryDate == undefined ||
      cvcNumber == undefined
    ) {
      window.alert("Please input a card number, expiry date, or CVC Number");
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

  /**
   * Function is called when the delete billing information is pressed
   */
  const handleDelete = () => {
    deleteBilling();
    window.alert("Billing has been deleted");
    // window.location.reload();
    navigate("/");
  };

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  /**
   * Fetches a product from the given itemId parameter, and pushes it to the cartProducts variable
   * @param {*} itemId 
   */
  const fetchProducts = async (itemId) => {
    await fetch(`${backend_endpoint}/api/v1/product/byId/${itemId}`)
      .then((res) => res.json())
      .then((data) => setCartProducts((cart) => [...cart, data]))
      .catch((error) => console.log(error));
  };

  /**
   * Function to purchase cart items and send it to be database
   * @param {*} purchaseCartList 
   */
  const purchase = async (purchaseCartList) => {
    await fetch(`${backend_endpoint}/api/v1/cart/customer/${customerId}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        data: purchaseCartList,
      }),
    })
      .then((res) => res.json())
      .then((data) => console.log("Purchase Log: ", data))
      .catch((error) => window.alert(error));
  };

  /**
   * Adds new billing and attaches it to the customer
   */
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
        console.log("New Billing: ", data);
        attachBillingToCustomer(data.id.toString());
      })
      .catch((error) => window.alert(error));
  };

  /**
   * Attaches the billing to the customer
   * @param {*} billingId 
   */
  const attachBillingToCustomer = async (billingId) => {
    await fetch(
      `${backend_endpoint}/api/v1/billing/${billingId}/customer/${customerId}`,
      {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
      }
    )
      .then((res) => res.json())
      .then((data) => console.log("Attach Billing", data))
      .catch((error) => console.log(error));
  };

  /**
   * Fetches billing information based on the customerId
   */
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

  /**
   * Delete billing from the customer
   */
  const deleteBilling = async () => {
    await fetch(
      `${backend_endpoint}/api/v1/billing/delete/${fetchedBillingId}`,
      {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
      }
    ).catch((error) => console.log(error));
  };

  /**
   * Navigates to the product page after purchase is made
   * @param {*} itemId 
   */
  const navigateToProductPage = (itemId) => {
    navigate(`/product/${itemId}`);
  };

  return (
    <div className="cartpage_container">
      <Header />
      {console.log(cartProducts)}
      <h1 id="h1">Cart:</h1>
      <div className="cart_container">
        {cartProducts && cartProducts.length != 0 ? (
          cartProducts.map((product, index) => (
            <div className="cart_individualproduct_container" key={index}>
              <img
                width={125}
                src={product.image}
                onClick={() => navigateToProductPage(product.id)}
              />
              <p>{product.name}</p>
              <p>|</p>
              <p>${product.price}</p>
            </div>
          ))
        ) : (
          <h3>No Cart Items Found</h3>
        )}
      </div>
      <div>
        {hasBilling == false ? (
          <div className="billing_container">
            <h2>Billing Information:</h2>
            <label>Credit Card (ex. 123456789123):</label>
            <input
              placeholder="Card Number"
              onChange={(e) => setCardNumber(e.target.value)}
            />
            <label>Expiry Date: (ex. 2026-01-15)</label>
            <input
              placeholder="Expiry Date (YYYY-MM-DD)"
              onChange={(e) => setExpiryDate(e.target.value)}
            />
            <label>CVC Number: (ex. 143)</label>
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
      <footer>
        <Footer />
      </footer>
    </div>
  );
};

export default Cartpage;
