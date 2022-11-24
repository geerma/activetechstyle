import React, { useState } from "react";
import "./homepage.css";

import activeLogo from "../../assets/active.png";
import techLogo from "../../assets/tech.png";
import styleLogo from "../../assets/style.png";
import { useNavigate } from "react-router-dom";

import { Header } from '../../Components/Header/Header'
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
    <div className="Home">
      <Header />
      <div>
        <a href="/active" target="_blank">
          <img src={activeLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="/tech" target="_blank">
          <img src={techLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="/style" target="_blank">
          <img src={styleLogo} className="logo" alt="Vite logo" />
        </a>
      </div>
      <h1>Active Tech Style</h1>
      <div className="card">
        <h2>Best Sellers</h2>
        <div>
          {products.map((product) => <Product product = {product} />)}
        </div>
      </div>
    </div>
  );
};

export default Homepage;
