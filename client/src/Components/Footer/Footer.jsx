import React from "react";
import "./footer.css";

export const Footer = () => {
  return (
    <div>
      <div className="footerinfo_container">
        <ul>
          <li>
            <span>COMPANY: ActiveTechStyle </span>
          </li>
          <li>
            <span>TELEPHONE: +1 (403) 123-4567 </span>
          </li>
          <li>
            <span>E-MAIL: activetechstyle@activetechstyle.com </span>
          </li>
          <li>
            <span>ADDRESS: Calgary, Alberta, Canada </span>
          </li>
        </ul>
      </div>
      <div className="copyright_container">
        <a href="https://www.vecteezy.com/free-vector/pink">
          Banner Image: Pink Vectors by Vecteezy
        </a>
        <p>
          Copyright © ActiveTechStyle. All Rights Reserved. Design by Geer,
          Kendall & Mike
        </p>
      </div>
    </div>
  );
};
