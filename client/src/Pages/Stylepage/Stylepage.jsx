import React, { useEffect, useState } from "react";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import Product from "../../Components/Product/Product";
import "./stylepage.css";

const Stylepage = () => {

  const [products, setProducts] = useState([])

  const backend_endpoint = "http://localhost:8080";

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
        <h2>Best Style Products</h2>
        <div>
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
