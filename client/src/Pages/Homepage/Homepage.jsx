import React, { useEffect, useState } from "react";
import "./homepage.css";

import { useNavigate } from "react-router-dom";

import { Header } from "../../Components/Header/Header";
import { Footer } from "../../Components/Footer/Footer";
import Product from "../../Components/Product/Product";

const Homepage = () => {
  const navigate = useNavigate();

  // const [products, setProducts] = useState([
  //   {
  //     id: 0,
  //     name: "Product 1",
  //     category: "active",
  //     price: 7.99,
  //     image: "https://cdn.shopify.com/s/files/1/0286/4077/2235/products/Bottoming-shirt-The-Korean-Fashion_400x.jpg?v=1639578749",
  //     stockQuantity: "",
  //     stockLocation: "",
  //   },
  //   {
  //     id: 1,
  //     name: "Product 2",
  //     category: "tech",
  //     price: 12.99,
  //     image: "https://cdn.shopify.com/s/files/1/0054/9040/9585/articles/6._Featured_Photo_e20a0689-1c6a-49c5-819b-c78a95ef761a_2000x.jpg?v=1653152215",
  //     stockQuantity: "",
  //     stockLocation: "",
  //   },
  //   {
  //     id: 3,
  //     name: "Product 3",
  //     category: "style",
  //     price: 40.99,
  //     image: "https://www.pcworld.com/wp-content/uploads/2022/10/Intel-Arc-A770-Limited-Edition-5-6.jpg?quality=50&strip=all&w=1024",
  //     stockQuantity: "",
  //     stockLocation: "",
  //   },
  // ])

  const [products, setProducts] = useState([]);

  const backend_endpoint = "http://localhost:8080";

  const fetchProducts = async () => {
    await fetch(`${backend_endpoint}/api/v1/product/all/`)
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
      <div>Banner</div>
      <div className="product_container">
        <h2>Best Sellers</h2>
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
