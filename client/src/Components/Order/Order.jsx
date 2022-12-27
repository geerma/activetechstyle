import React from "react";
import { useNavigate } from "react-router-dom";
import "./order.css";

/**
 * Component for each individual order history
 * @param {*} param0 each order
 * @returns div containing a list of products for one order
 */
const Order = ({ order }) => {
  const navigate = useNavigate();
  const products = order.products; // All products from the order

  /**
   * Navigate to the product when the image is clicked on
   * @param {*} itemId itemId of the product
   */
  const navigateToProductPage = (itemId) => {
    navigate(`/product/${itemId}`);
  };

  return (
    <div className="order_container">
      <div className="order_info_container">
        <h2>Order Placed: {order.purchaseDate}</h2>
        <h2>Total: ${order.totalPay}</h2>
      </div>
      <div className="order_products_container">
        {products &&
          products.map((product, index) => (
            <div className = "order_individualproduct_container" key={index}>
              <img width={125} src={product.image} onClick={() => navigateToProductPage(product.id)} />
              <p>{product.name}</p>
              <p>|</p>
              <p>${product.price}</p>
            </div>
          ))}
      </div>
    </div>
  );
};

export default Order;
