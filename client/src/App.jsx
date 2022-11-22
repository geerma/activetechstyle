import "./App.css";
import { Route, Routes } from "react-router-dom";
import Homepage from "./Pages/Homepage/Homepage";
import Stylepage from "./Pages/Stylepage/Stylepage";
import Activepage from "./Pages/Activepage/Activepage";
import Techpage from "./Pages/Techpage/Techpage";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Homepage />}></Route>
      <Route path="/active" element={<Activepage />}></Route>
      <Route path="/tech" element={<Techpage />}></Route>
      <Route path="/style" element={<Stylepage />}></Route>
    </Routes>
  );
}

export default App;
