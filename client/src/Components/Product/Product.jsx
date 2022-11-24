import React from "react";

const Product = ({ product }) => {
  return (
    <div>
      <p>{product.name}</p>
      <img 
      src="https://cdn.shopify.com/s/files/1/0286/4077/2235/products/Bottoming-shirt-The-Korean-Fashion_400x.jpg?v=1639578749"
      width={200}
      height={200}
      />
      <p>${product.price}</p>
    </div>
  );
};

export default Product;
