import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Header } from "../../Components/Header/Header";
import Product from "../../Components/Product/Product";
import "./searchpage.css";

const Searchpage = () => {
    const params = useParams();

    const [products, setProducts] = useState([]);

    const backend_endpoint = "http://localhost:8080";
  
    const fetchSearchProducts = async () => {
      await fetch(`${backend_endpoint}/api/v1/product/byName/${params.query}`)
        .then((res) => res.json())
        .then((data) => {
            if (data && data.status == 500) {
                console.log("No Products Found");
            } else {
                setProducts(data);
            }
        })
        .catch((error) => console.log(error))
    };
  
    useEffect(() => {
      fetchSearchProducts();
    }, []);

  return (
    <div className="tech_container">
      <Header />
      <h1>Search</h1>
      <div className="product_container">
          {products && (products.length != 0) ? products.map((product, index) => (
            <Product product={product} key={index} />
          )) : (<h3>No Products Found</h3>)}
      </div>
    </div>
  );
};

export default Searchpage;
