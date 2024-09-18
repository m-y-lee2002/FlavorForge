import React, { useState, useEffect, useContext } from 'react';
import { loginAuth } from '../api/loginAuth';
import { useNavigate } from 'react-router-dom';

const Loginform = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [user, setUser] = useState(null);
    const navigate = useNavigate();

    useEffect(()=>{
        if(user != null){
            storeUserSession();
            navigateToMainPage();
        }
    }, [user]);
    const storeUserSession = () =>{
        alert(user.email);
        sessionStorage.setItem('user', JSON.stringify(user))
    }

    const navigateToMainPage = () => {
        navigate('/mainpage');
    }


    const submitHandler = async (event) => {
        event.preventDefault();
        let validLogin = await loginAuth(email, password);
        console.log(validLogin);
        if (validLogin != null) {
            setUser(validLogin);
        } else {
            alert("Incorrect Email or Password");
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
                <input placeholder='email' type='text' onChange={changeEmail} />
                <input placeholder='password' type='password' onChange={changePassword} />
                <button type='submit'> Login </button>
            </form>
        </div>
    );
}

export default Loginform;