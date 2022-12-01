import React from "react";
import "./order.css";

const Order = ({ order }) => {
  const products = order.products;

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
              <img width={125} src={product.image} />
              <p>{product.name}</p>
              <p>${product.price}</p>
            </div>
          ))}
      </div>
    </div>
  );
};

export default Order;
