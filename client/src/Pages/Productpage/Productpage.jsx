import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import "./productpage.css";

/**
 * Dynamic page for one specific product after clicking on the image. URL is based on the product ID.
 * Contains the login to add product to the cart
 * @returns 
 */
const Productpage = () => {
  const [product, setProduct] = useState({});

  const params = useParams(); // Params from the dynamic URL

  let cartList = []; // List of productIds, to be used when checking out.

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  /**
   * Fetch product details from the id
   * @param {*} id Passed in from params.itemId 
   */
  const fetchProductById = async (id) => {
    await fetch(`${backend_endpoint}/api/v1/product/byId/${id}`)
      .then((res) => res.json())
      .then((data) => setProduct(data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchProductById(params.itemId);
  }, []);

  /**
   * Add product id to the sessionStorage cartItems array
   * @returns 
   */
  const addToCart = () => {
    if (sessionStorage.getItem("cartItems") != null) {
      cartList = sessionStorage.getItem("cartItems").split(",");
    } else {
      cartList = [];
    }
    if (cartList.includes(params.itemId)) {
      window.alert("You cannot add duplicate items to the cart");
      return;
    }
    cartList.push(params.itemId); // push product ID to the cartList array
    sessionStorage.setItem("cartItems", cartList);
    window.alert("Product has been added to cart");
    console.log(sessionStorage.getItem("cartItems"));
  };

  return (
    <div className="productpage_container">
      <Header />
      {console.log(product)}
      <div className="individualproduct_container">
        <h2>{product.name}</h2>
        <img src={product.image} />
        <p>{product.description}</p>
        <p>Rating: {product.rating} / 5</p>
        <p>Price: ${product.price}</p>
        <div className="addtocart_button">
          <button onClick={() => addToCart()}>Add to Cart</button>
        </div>
      </div>
      <footer>
        <Footer />
      </footer>
    </div>
  );
};

export default Productpage;
