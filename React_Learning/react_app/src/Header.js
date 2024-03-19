import React, { useState } from 'react'
import './Footer.js'
import './App.css'
export const methodName=()=>
{
  return console.log("Hello");
}

const Header = () => {  

  const[name,setName]=useState(()=>onClickEvent);
  const[items,setItem]=useState([
    {
      id:1,
      checked:"true",
      item:"React",
    },
    {
      id:2,
      checked:"false",
      item:"HTML",
    },
    {
      id:3,
      checked:"true",
      item:"CSS",
    }
  ])

   
  function onClickEvent()
  {
    const nameChange=['React','JS','HTML'];
    const int=Math.floor(Math.random()*3);
     setName(nameChange[int]);
  } 
  return (
    <div className="container">
      <div className="background-box">
        <div style={{color:'black',backgroundColor:'pink'}}>
          <p>Welome To React Js {methodName()}</p> 
        </div>
        <div style={{color:'black',backgroundColor:'lightBlue'}}>
          <p> Basic Concept of React : {name} </p>
        </div>
        <div>
          <button className="button" onClick={onClickEvent}>Know More...</button>
        </div>
      </div>
      
       <ul>
        {items.map((item)=>
        (
          <li>
          <input 
          type='checkbox'
          checked={item.checked}
         />
        <label>{item.item}</label>
          </li>
        ))}
       </ul>
    
    </div>

  )
}

export default Header
