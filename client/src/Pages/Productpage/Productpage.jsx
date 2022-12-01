import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import "./productpage.css";

const Productpage = () => {
  const [product, setProduct] = useState({});

  const params = useParams();
  
  let cartList = [];

  const backend_endpoint = "http://localhost:8080";

  const fetchProductById = async (id) => {
    await fetch(`${backend_endpoint}/api/v1/product/byId/${id}`)
      .then((res) => res.json())
      .then((data) => setProduct(data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchProductById(params.itemId);
  }, []);

  const addToCart = () => {
    if (sessionStorage.getItem("cartItems") != null) {
      cartList = sessionStorage.getItem("cartItems").split(",");
    } else {
      cartList = [];
    }
    cartList.push(params.itemId);
    sessionStorage.setItem("cartItems", cartList);
    console.log(sessionStorage.getItem("cartItems"));
  };

  return (
    <div className="productpage_container">
      <Header />
      <div className="individualproduct_container">
        <h1>{product.name}</h1>
        <img src={product.image} />
        <p>{product.description}</p>
        <p>${product.price}</p>
        <div className="addtocart_button">
          <button onClick={() => addToCart()}>Add to Cart</button>
        </div>
      </div>
    </div>
  );
};

export default Productpage;
