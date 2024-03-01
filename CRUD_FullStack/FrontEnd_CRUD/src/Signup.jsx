import React from "react";
import { Link } from "react-router-dom";
import './Main.css';
function Signup(){
return(
<div class="entire">
    <div class="head">
        <div class="img">
            <h1>SIGNUP</h1>
        </div>
        </div>
        <div class="details">
        <form class="User-need">
        <Link to="/user"><button type="onClick" name="view" id="view" >VIEW DETAILS</button></Link>
        <Link to="/login"> <button type="onClick" name="edit" id="edit">EDIT DETAILS</button></Link>
        {/* <Link to="/edit-user/:id"> <button type="onClick" name="Update" id="Update">UPDATE DETAILS</button></Link> */}
        </form>
 </div>
</div>
);
}
export default Signup;