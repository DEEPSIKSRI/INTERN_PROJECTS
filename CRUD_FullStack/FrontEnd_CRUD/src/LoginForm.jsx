import React, { useState, useEffect } from "react";
import './LoginStyle.css';
import { Link, useParams } from "react-router-dom";
import EmployeeService from "./services/EmployeeService";
import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

export const validateFname = (firstName) => {
    let space = firstName;
    space = space.replaceAll(" ", "");
    const namePattern = /^[A-Za-z]+$/;
    console.log("fffff",namePattern.test(space));
    return namePattern.test(space);
   
}
export const validateLname = (lastName) => {
    let space = lastName;
    space = space.replaceAll(" ", "");
    const namePattern = /^[A-Za-z]+$/;
    return namePattern.test(space);
}
export const validateEmail = (email) => {
    const emailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return emailPattern.test(email);
}
export const validateMobile = (mobile) => {
    console.log(mobile, "deepsi");
    const mobpattern = /^[0-9]/;
    console.log("mobile-->", mobile)
    return mobpattern.test(mobile);

}


const LoginForm = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [mobileNumber, setMobilenumber] = useState("");
    const [dob, setDOB] = useState("");
    const [address, setAddress] = useState("");
    const [overAll, setOverAll] = useState("");
    const { id } = useParams();
    const navigate = useNavigate();

    let fname;
    let email1;
    let lname;
    let DateOfBirth;
    let mobile;

    function onClick(e) {
        e.preventDefault();
        handle();
    }
    const handle = (e) => {
        e.preventDefault();
        const user = { email, firstName, lastName, mobileNumber, dob, address };
        console.log("jjj", user);
        if (id) {
            console.log("Id: " + id);
            console.log("Object: " + user);
            if (email.length > 0 && firstName.length > 0 && lastName.length > 0 && mobileNumber.length > 0 && address.length > 0 && errorDiv.innerHTML=='')  {

                EmployeeService.updateRecords(id, user).then((response) => {
                    <link to="/user"></link>;
                    navigate('/user')
                    Swal.fire({
                        title: 'Updated Successfully!!',
                        width: 600,
                        padding: '3em',
                        color: 'black',
                        backdrop: `
                        rgba((108, 122, 137);, 1
                          left top
                          no-repeat
                        `
                      })
                    
                    // Swal.fire({
                    
                    
                    
                    //     title: 'Updated Successfully',
                    //     showClass: {
                    //         popup: 'Updated Successfully'
                    //     }})
                    //     hideClass: {
                    //         popup: 'Updated Successfully'
                    //     }
                    // })
                }).catch(error => {
                    <link to="/user"></link>;
                    console.log("update err" + error);
                })
            } else {
                alert("Some fields are in complete")
            }

        }
        else {
            console.log("INSERT");
            console.log("Object: " + user);
            if (email?.length > 0 && firstName?.length > 0 && lastName?.length > 0 && mobileNumber?.length > 0 && address?.length > 0 && errorDiv.innerHTML=='') {
                EmployeeService.saveRecords(user).then((response) => {
                    console.log("insert page");
                    // <Link to="/user"></Link>; 
                    navigate('/user')

                }).catch(error => {
                    console.log("Error is" + error)
                })
            } else {
                alert("Some fields are in-complete")
            }
        }
    }

    const mailEXist = () => {
        EmployeeService.getMail(id).then((response) => {
            console.log("respone", response);
            const validate = response;
            if (response.data == Boolean(true)) {
                return Boolean(true);
            }
            
            else {
                return Boolean(false);

            }
        })
    }
    // }
    // const validateDOB=()=>{

    //     const today = new Date();
    //     const selectedDate = new Date(this.state.dob);
    //      if (selectedDate > today) {
    //     return setDOB("fghjk");
    //   }
    //   else{
    //     return selectedDate;
    //   }
    // }


    // const setValues=(e) =>
    // {
    //     switch(e.target.name)
    //     {
    //         case 'email':
    //             setEmail(e.target.value);
    //             if(!validateEmail(e.target.value))
    //             setError(emailAddress,"Email id invalid");
    //             else
    //             setSuccess(emailaddress);
    //     }


    // }
    useEffect(() => {

    })

    useEffect(() => {
        EmployeeService.getUserById(id).then((response) => {
            // console.log("rtyk",response,response.data.mobileNumber);
            setOverAll(response);
        }).catch(error => {
            console.log("user" + error)
        })
    }, [])

    useEffect(() => {
        console.log("overAll--->", overAll)
        setFirstName(overAll?.data?.firstName)
        setLastName(overAll?.data?.lastName)
        setEmail(overAll?.data?.email)
        setMobilenumber(overAll?.data?.mobileNumber)
        setAddress(overAll?.data?.address)
        setDOB(overAll?.data?.dob)

    }, [overAll])

    const dobSet = () => {
        var dob = new Date().toISOString().split('T')[0];
        // console.log(dob,"jkl");
        // console.log(d.toISOString(),"Date of birth")
        console.log(dob)
        return String(dob);
    }

    function setError(element, message) {
        //console.log(element);
        const inputGroup = element.parentElement;
        const errorGroup = inputGroup.querySelector('.error');
        errorGroup.innerText = message;
        inputGroup.classList.add('.error');
        inputGroup.classList.remove('success');

    }
    function setSuccess(element) {
        const inputGroup = element.parentElement;
        const errorGroup = inputGroup.querySelector('.error');
        errorGroup.innerText = "";
        inputGroup.classList.remove('.error');
        inputGroup.classList.add('success');
    }

    const errorDiv = document.querySelector('.error');

    const valueSet = (e) => {
        switch (e.target.name) 
        {
            case 'fname':
                fname = document.querySelector('#fname');

                setFirstName(e.target.value);
                if (e.target.value == '') {
                    setError(fname, "Firstname is required")
                }
                else if (!validateFname(e.target.value)) {
                    setError(fname, "Firstname is invalid")
                }
                else {
                    setSuccess(fname);
                }
                // else{
                //     setError(fname,"Name should not be empty")
                // }
                break;

            case 'lname':
                lname = document.querySelector('#lname');
                setLastName(e.target.value);
                if (e.target.value == '') {
                    setError(lname, "Lastname is required")
                }
                else if (!validateLname(e.target.value)) {
                    setError(lname, "Lastname is invalid")
                }
                else {
                    setSuccess(lname);
                }
                break;

            case 'mobile':
                mobile = document.querySelector('#mobile');
                // console.log(e.target.value,"asd");
                setMobilenumber(e.target.value);
                console.log("--->", String(e.target.value).length)
                // console.log("hgfhg", !validateMobile(e.target.value), validateMobile(e.target.value))
                if (e.target.value == '') {

                    setError(mobile, "mobile number is required")
                }
                else if (!validateMobile(e.target.value)) {
                    //console.log((JSON.stringify(mobile)).length,"mobile number");
                    console.log(typeof (mobile), "mobile length");
                    setError(mobile, "mobile number is invalid")
                }
                else if (String(e.target.value).length != 10) {
                    console.log("ph check");
                    setError(mobile, "mobile number is invalid")
                }
                else if (String(e.target.value).length == 10) {
                    setSuccess(mobile)
                }
                break;

            case 'email':
                email1 = document.querySelector('#email');

                setEmail(e.target.value);
                if (e.target.value == '') {
                    setError(email1, "Email is required")
                }
                else if (!validateEmail(email)) {
                    // console.log(email,"email is inavlid")
                    setError(email1, "Email is invalid")
                }
                else if (!mailEXist) {
                    setError(email1, "Email already exist")
                }
                else {
                    setSuccess(email1)
                }
                break;

            // case 'dob':
            //     DateOfBirth = document.querySelector('#date');
            //     setDOB(e.target.value);
            //     const inputDate = new Date(dob);
            //     const currentDate = new Date();
            //     if (inputDate < currentDate) {
            //         console.log('success');
            //         setSuccess(DateOfBirth);
            //     } else {
            //         console.log('fail');
            //         setError(DateOfBirth, "Date cannot be in Future Date");
            //     }
            case 'dob':


        }

    }
    return (
        <>
            <form >
                <div class="whole">
                    <div class="top">
                        <img id="img" src="https://divum.in/images/logo/Divum%20LOGO%202022.svg" />
                    </div>
                    <div class="front-view">
                        <div class="head">
                            <h1><b>ADD&nbsp;DETAILS</b></h1>
                            <div class="body" >
                                <div class="input">
                                    <label>FIRSTNAME:</label>
                                    <input type="text" name="fname" id="fname" required value={firstName}
                                        onChange={valueSet} autoComplete="off"
                                        placeholder="Enter your firstname"></input>
                                    <div className="error"></div>
                                    <br></br><br></br></div>

                                <div class="input">
                                    <label>LASTNAME :</label>
                                    <input type="text" value={lastName} onChange={valueSet} id="lname" autoComplete="off" required name='lname' placeholder="Enter your lastname"></input>
                                    <div className="error"></div></div>
                                <br></br><br></br>
                                <div class="input">
                                    <label>EMAIL :</label>
                                    <input type="text" value={email} onChange={valueSet} id="email" name="email" required autoComplete="off" placeholder="Enter your email"></input>
                                    <div className="error"></div>
                                    <br></br><br></br>
                                </div>

                                <div class="input">
                                    <label>MOBILENUMBER :</label>
                                    <input type="text" value={mobileNumber} onChange={valueSet} id="mobile" name="mobile" required autoComplete="off" placeholder="Enter your MobileNo" ></input>
                                    <div className="error"></div>
                                    <br></br><br></br>

                                </div>

                                <div class="input">
                                    <label>DOB :</label>
                                    <input type="date" value={dob} placeholder="dd/mm/yyyy" name="dob" required onChange={(e) => setDOB(e.target.value)} max={dobSet()} autoComplete="off" id="date"></input>
                                    <br></br><br></br>
                                </div>


                                <div class="input">
                                    <label>ADDRESS :</label><br></br>
                                    <textarea value={address} onChange={(e) => setAddress(e.target.value)} autoComplete="off" maxLength="50" placeholder="Enter your Address" id="address" rows="3" cols="50" required ></textarea>
                                    <div className="error"></div>
                                    <br></br><br></br>
                                </div>
                                <div class="buttons">
                                    <div class="btn">
                                        <Link to="/user"><button type="onClick" id="submit" onClick={(e) => handle(e)}> SUBMIT</button></Link>
                                    </div>
                                    <div class="back">
                                        <Link to="/user"><button type="onClick" id="back">BACK</button></Link></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </>
    );
}
export default LoginForm;



