import React, { useEffect, useState } from "react";
import "./header.css";

import { useNavigate } from "react-router-dom";
import logo from "../../assets/activetechstylelogo.png";

// import historyLogo from "../../assets/historylogo.jpg"
// import cartLogo from "../../assets/cartlogo.jpg";
// import magnifyglassLogo from "../../assets/magnifyglass.jpg";

import SearchIcon from '@mui/icons-material/Search';
import HistoryIcon from '@mui/icons-material/History';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';

export const Header = () => {
  const navigate = useNavigate();

  const [token, setToken] = useState("null");
  const [search, setSearch] = useState();

  useEffect(() => {
    if (sessionStorage.getItem("customerId") == null) {
      sessionStorage.setItem("customerId", "null");
      setToken("null");
    } else {
      setToken(sessionStorage.getItem("customerId"));
    }
  }, []);

  const handleSignout = () => {
    sessionStorage.setItem("customerId", "null");
    setToken(sessionStorage.getItem("customerId"));
    navigate("/");
    window.location.reload();
  }

  const navigateToSearchPage = () => {
    if (search != undefined) {
      if (window.location.pathname.match("search") != null) {
        navigate(`/search/${search}`);
        window.location.reload();
      } else {
        navigate(`/search/${search}`);
      }
    } else {
      window.alert("Please enter text in the search bar.")
    }
  };

  return (
    <div className="header_container">
      <div className="header_logo">
        <a href="/">
          <img src={logo} height={60} />
        </a>
      </div>
      <div className="header_category">
        <button onClick={() => navigate("/active")}>Active</button>
        <button onClick={() => navigate("/tech")}>Tech</button>
        <button onClick={() => navigate("/style")}>Style</button>
        <input placeholder="Search" onChange={(e) => setSearch(e.target.value)}/>
        <button onClick={() => navigateToSearchPage()}>
          <SearchIcon />
        </button>
      </div>
      <div className="header_login">
        {(token != "null") ? (
          <button onClick={() => handleSignout()}>Signout</button>
        ) : (
          <button onClick={() => navigate("/login")}>Login / Signup</button>
        )}

        <button onClick={() => navigate("/history")}>
          {/* <img img src={historyLogo} height={30} />*/}
          <HistoryIcon />
        </button>
        <button onClick={() => navigate("/cart")}>
          {/* <img img src={cartLogo} height={30}*/}
          <ShoppingCartIcon />
        </button>
      </div>
    </div>
  );
};
