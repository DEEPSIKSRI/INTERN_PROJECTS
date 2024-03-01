// import React from "react";
// import { Link } from "react-router-dom";
// import './Main.css';
// function Main(){
// return(
// <div class="entire">
//     <div class="head">
//         <div class="img">
//             <h1>LOGIN FORM</h1>
//         </div>
//         </div>
//         <div class="details">
//         <form class="User-need">
//         <Link to="/login"><button type="onClick" name="signup" id="signup" >SIGN UP</button></Link>
//         <Link to="/login"> <button type="onClick" name="login" id="login">LOGIN</button></Link>
//         {/* <Link to="/edit-user/:id"> <button type="onClick" name="Update" id="Update">UPDATE DETAILS</button></Link> */}
//         </form>
//  </div>
// </div>
// );
// }
// export default Main;
import React from "react";
import { Link } from "react-router-dom";
import './Main.css';
function Main(){
return(
<div class="entire">
    <div class="head">
        <div class="img">
            <h1>LOGIN FORM</h1>
        </div>
        </div>
        <div class="details">
        <form class="User-need">
        <Link to="/user"><button type="onClick" name="view" id="view" >VIEW DETAILS</button></Link>
        <Link to="/login"> <button type="onClick" name="Add" id="Add">ADD USER</button></Link>
        {/* <Link to="/edit-user/:id"> <button type="onClick" name="Update" id="Update">UPDATE DETAILS</button></Link> */}
        </form>
 </div>
</div>
);
}
export default Main;