import React from "react";
import { Header } from "../../Components/Header/Header";
import "./productpage.css";

const Productpage = () => {

    const addToCart = () => {
        console.log("Added to Cart")
    }

  return (
    <div className="productpage_container">
      <Header />
      <div className="individualproduct_container">
        <h1>Product Name</h1>
        <img
        src="https://cdn.shopify.com/s/files/1/0286/4077/2235/products/Bottoming-shirt-The-Korean-Fashion_400x.jpg?v=1639578749"
        />
        <p>Product Description</p>
        <p>Product Price</p>
        <div className="addtocart_button">
            <button onClick={() => addToCart()} >Add to Cart</button>
        </div>
      </div>
    </div>
  );
};

export default Productpage;
