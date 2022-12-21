import React, { useEffect, useState } from "react";
import "./homepage.css";

import { Header } from "../../Components/Header/Header";
import { Footer } from "../../Components/Footer/Footer";
import Product from "../../Components/Product/Product";

import bannerImage from "../../assets/banner.jpg";



const Homepage = () => {
  const [products, setProducts] = useState([]);

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  const fetchProducts = async () => {
    await fetch(`${backend_endpoint}/api/v1/product/all/`)
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((error) => console.log(error));
  };

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
