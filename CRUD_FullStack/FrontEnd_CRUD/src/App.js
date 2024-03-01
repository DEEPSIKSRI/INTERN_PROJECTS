import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router,Route,Routes } from 'react-router-dom';
import LoginForm from './LoginForm';
import FrontPage from './FrontPage';
import React,{useState} from "react";
import Main from './Main';
import Signup from './Signup';
function App() {
  return (
    <div>
     <Router>
      <Routes>
      <Route  path="/user" element={<FrontPage/>}></Route>
      <Route path="/edit-user/:id" element={<LoginForm/>}></Route>
      <Route  path="/login/" element={<LoginForm/>}></Route>
      <Route path="/signup/" element={<Signup/>}></Route>
      {/* <Route exact path="/" element={<FrontPage/>}></Route> */}
      <Route exact path="/" element={<Main/>}></Route>
      
      </Routes>
      </Router>
    </div>
  );
}

export default App;
