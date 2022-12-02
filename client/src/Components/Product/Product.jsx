import React from "react";
import { useNavigate } from "react-router-dom";
import "./product.css";

const Product = ({ product }) => {
  const navigate = useNavigate();

  const navigateToProductPage = (itemId) => {
    navigate(`/product/${itemId}`);
  };

  return (
    <div className="productcomponent_container">
      <p>{product.name}</p>
      <img
        className="page_product_image"
        src={product.image}
        width={215}
        height={200}
        onClick={() => navigateToProductPage(product.id)}
      />
      <p>${product.price}</p>
    </div>
  );
};

export default Product;
