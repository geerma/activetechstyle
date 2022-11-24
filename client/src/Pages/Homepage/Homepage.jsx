import React, { useState } from "react";
import "./homepage.css";

import { useNavigate } from "react-router-dom";

import { Header } from '../../Components/Header/Header'
import { Footer } from '../../Components/Footer/Footer'
import Product from "../../Components/Product/Product";

const Homepage = () => {
  const navigate = useNavigate();

  const [products, setProducts] = useState([
    {
      id: 0,
      name: "Product 1",
      price: 7.99,
    },
    {
      id: 1,
      name: "Product 2",
      price: 12.99,
    },   
    {
      id: 3,
      name: "Product 3",
      price: 40.99,
    },   
  ])

  return (
    <div className="home_container">
      <Header />
      <div>
        Banner
      </div>
      <div className="product_container">
        <h2>Best Sellers</h2>
        <div>
          {products.map((product) => <Product product = {product} />)}
        </div>
      </div>
      <footer>
        <Footer />
      </footer>
    </div>
  );
};

export default Homepage;
