import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; 
import { userRegister } from '../api/userRegister';
const Registerform = ()=>{
    const[email, setEmail] = useState(null);
    const[password, setPassword] = useState(null);
    const[username, setUsername] = useState(null);
    const navigate = useNavigate();
    const navigateToMainPage = () =>{
        navigate('/mainpage');
    }
    const storeUserInformation = ()=>{
        sessionStorage.setItem('email', email);
        sessionStorage.setItem('password',password);
        sessionStorage.setItem('username', username);
    }
    const submitHandler = async (event)=>{
        event.preventDefault()
        let newUser = {
            "email": email,
            "password": password,
            "username": username
        };
        let result = await userRegister(newUser);
        if(result === "Email in use."){
            alert("An account with this email already exists.");
        }else if(result === "Username in use."){
            alert("Username has been taken");
        }else{
            storeUserInformation();
            navigateToMainPage();
        }
    }   

    const changeEmail = (event) => {
        setEmail(event.target.value);
    }

    const changePassword = (event) => {
        setPassword(event.target.value);
    }

    const changeUsername = (event) =>{
        setUsername(event.target.value);
    }

    return(
        <div>
            <form onSubmit={submitHandler}>
                <input placeholder='email' type='text' onChange={changeEmail}/>
                <input placeholder='username' type='text' onChange={changeUsername}/>
                <input placeholder='password' type='password' onChange={changePassword}/>
                <button type='submit'> Register </button>
            </form>
        </div>
    );
}
export default Registerform;