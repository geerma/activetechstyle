import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Footer } from "../../Components/Footer/Footer";
import { Header } from "../../Components/Header/Header";
import Order from "../../Components/Order/Order";
import "./orderhistorypage.css";

const Orderhistorypage = () => {
  const navigate = useNavigate();

  const [history, setHistory] = useState();

  const backend_endpoint = import.meta.env.VITE_BACKEND_URL;

  const customerId = sessionStorage.getItem("customerId");

  const fetchHistory = async () => {
    await fetch(`${backend_endpoint}/api/v1/customer/byId/${customerId}`)
      .then((res) => res.json())
      .then((data) => setHistory(data.history))
      .catch((error) => console.log(error));
  };

  useEffect(() => {
    if (
      sessionStorage.getItem("customerId") == "null" ||
      sessionStorage.getItem("customerId") == undefined
    ) {
      navigate("/login");
    } else {
      fetchHistory();
    }
  }, []);

  return (
    <div className="orderhistorypage_container">
      {console.log(history)}
      <Header />
      <h1>Orders:</h1>
      <div className="orderhistory_container">
        {history && history.length != 0 ? (
          history.map((order, index) => <Order order={order} key={index} />)
        ) : (
          <h3>No Orders Found</h3>
        )}
      </div>
      <footer>
        <Footer />
      </footer>
    </div>
  );
};

export default Orderhistorypage;
