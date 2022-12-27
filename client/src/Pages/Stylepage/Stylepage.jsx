import React, { useEffect, useState } from "react";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import Product from "../../Components/Product/Product";
import "./stylepage.css";

/**
 * Page containing products in the "style" category
 * @returns 
 */
const Stylepage = () => {
  const [products, setProducts] = useState([]);

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  /**
   * Fetches all products in the style category from the API endpoint
   */
  const fetchProducts = async () => {
    await fetch(`${backend_endpoint}/api/v1/product/byCategory/style/`)
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="style_container">
      <Header />
      <div className="product_container">
        <h2>Style Products</h2>
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

export default Stylepage;
