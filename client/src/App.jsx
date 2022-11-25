import "./App.css";
import { Route, Routes } from "react-router-dom";
import Homepage from "./Pages/Homepage/Homepage";
import Stylepage from "./Pages/Stylepage/Stylepage";
import Activepage from "./Pages/Activepage/Activepage";
import Techpage from "./Pages/Techpage/Techpage";
import Loginpage from "./Pages/Loginpage/Loginpage";
import Productpage from "./Pages/Productpage/Productpage";
import Cartpage from "./Pages/Cartpage/Cartpage";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Homepage />}></Route>
      <Route path="/active" element={<Activepage />}></Route>
      <Route path="/tech" element={<Techpage />}></Route>
      <Route path="/style" element={<Stylepage />}></Route>
      <Route path="/login" element={<Loginpage />}></Route>
      <Route path="/product/:itemId" element={<Productpage />}></Route>
      <Route path="/cart" element={<Cartpage />}></Route>
    </Routes>
  );
}

export default App;
