import React, { useEffect, useState } from "react";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import Product from "../../Components/Product/Product";
import "./activepage.css";

/**
 * Page containing products in the "active" category
 * @returns 
 */
const Activepage = () => {
  const [products, setProducts] = useState([]);

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  /**
   * Fetches all products in the active category from the API endpoint
   */
  const fetchProducts = async () => {
    await fetch(`${backend_endpoint}/api/v1/product/byCategory/active/`)
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="active_container">
      <Header />
      <div className="product_container">
        <h2>Active Products</h2>
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

export default Activepage;
