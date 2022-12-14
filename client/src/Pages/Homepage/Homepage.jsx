import React, { useEffect, useState } from "react";
import "./homepage.css";

import { Header } from "../../Components/Header/Header";
import { Footer } from "../../Components/Footer/Footer";
import Product from "../../Components/Product/Product";

import bannerImage from "../../assets/banner.jpg";

/**
 * Homepage for the E-commerce webapp.
 * Shows list of all products in the database.
 * @returns 
 */
const Homepage = () => {
  const [products, setProducts] = useState([]);

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  /**
   * Fetch all products
   */
  const fetchProducts = async () => {
    await fetch(`${backend_endpoint}/api/v1/product/all/`)
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((error) => console.log(error));
  };

  /**
   * Sorts products based on price using backend SQL query
   * @param {*} ascdesc parameter to change whether price should be ascending or descending
   */
  const sortByPrice = async (ascdesc) => {
    await fetch(`${backend_endpoint}/api/v1/product/all/price/${ascdesc}`)
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="homepage_container">
      <Header />
      <div className="image">
        <img alt="Pink Vectors by Vecteezy" src={bannerImage} />
      </div>
      <div className="product_container">
        <h2>Best Sellers</h2>
        <button onClick={() => sortByPrice("asc")}>
          Sort By Price (Ascending)
        </button>
        <button onClick={() => sortByPrice("desc")}>
          Sort By Price (Descending)
        </button>
        <div className="product_box">
          {products.map((product, index) => (
            <Product product={product} key={index} />
          ))}
        </div>
      </div>
      <footer>
        <Footer />
      </footer>
    </div>
  );
};

export default Homepage;
