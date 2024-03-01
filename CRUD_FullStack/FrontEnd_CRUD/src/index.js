import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
// import {
//   createBrowserRouter,
//   RouterProvider,
// } from "react-router-dom"; 
// import FrontPage from '/home/divum/firstproject/src/FrontPage';
// import LoginForm from '/home/divum/firstproject/src/LoginForm';
// const router = createBrowserRouter([
//   {
//     path: "/",
//     element: <App/>
//   },
//   {
//     path: "/",
//     element: <FrontPage/>
//   },
//   {
//     path: "/",
//     element: <LoginForm/>
//   },
// ]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // <RouterProvider router={router}/>
    <React.StrictMode>
      <App/>
    </React.StrictMode>
);

// reportWebVitals();
