import React from "react";

import { useNavigate } from "react-router-dom";

export const Header = () => {
  const navigate = useNavigate();

  return (
    <div>
      <button onClick={() => navigate("/active")}>Active</button>
      <button onClick={() => navigate("/tech")}>Tech</button>
      <button onClick={() => navigate("/style")}>Style</button>
    </div>
  );
};
