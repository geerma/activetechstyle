import React from "react";
import { useNavigate } from "react-router-dom";
import "./product.css";

/**
 * Component for the products displayed to the customer on the home, category, or search pages
 * @param {*} param0 individual product
 * @returns 
 */
const Product = ({ product }) => {
  const navigate = useNavigate();

  const navigateToProductPage = (itemId) => {
    navigate(`/product/${itemId}`);
  };

  return (
    <div className="productcomponent_container">
      <img
        className="page_product_image"
        src={product.image}
        width={200}
        height={200}
        onClick={() => navigateToProductPage(product.id)}
      />
      <p>{product.name}</p>
      <p>${product.price}</p>
    </div>
  );
};

export default Product;
