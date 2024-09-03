import React, { useState } from 'react';
import { loginAuth } from '../api/loginAuth';
import { useNavigate } from 'react-router-dom';

const Loginform = () => {

    const[email, setEmail] = useState(null);
    const[password, setPassword] = useState(null);
    const navigate = useNavigate();
    const navigateToMainPage = () =>{
        navigate('/mainpage');
    }
    const storeUserInformation = ()=>{
        sessionStorage.setItem('email', email);
        sessionStorage.setItem('password',password);
    }
    const submitHandler = async (event)=>{
        event.preventDefault()
        
        let validLogin = await loginAuth(email, password);
        console.log(validLogin);
        if(validLogin){
            storeUserInformation();
            navigateToMainPage();
        }else{
            alert("Incorrect Username or Password");
        }
    }   

    const changeEmail = (event) => {
        setEmail(event.target.value);
    }

    const changePassword = (event) => {
        setPassword(event.target.value);
    }

    return (
        <div>
            <form onSubmit={submitHandler}>
                <input placeholder='email' type='text' onChange={changeEmail}/>
                <input placeholder='password' type='password' onChange={changePassword}/>
                <button type='submit'> Login </button>
            </form>
        </div>
    );
}

export default Loginform;
