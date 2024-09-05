import React, { useState, useEffect } from 'react';
import { loginAuth } from '../api/loginAuth';
import { useNavigate } from 'react-router-dom';

const Loginform = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
    const [isLoginSuccessful, setIsLoginSuccessful] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        if (isLoginSuccessful) {
            const handleSuccessfulLogin = async () => {
                await storeUserInformation();
                navigateToMainPage();
            };
            handleSuccessfulLogin();
        }
    }, [isLoginSuccessful]);

    const navigateToMainPage = () => {
        navigate('/mainpage');
    }

    const storeUserInformation = () => {
        sessionStorage.setItem('email', email);
        sessionStorage.setItem('password', password);
        sessionStorage.setItem('username', username);
    }

    const submitHandler = async (event) => {
        event.preventDefault();
        let validLogin = await loginAuth(email, password);
        console.log(validLogin);
        if (validLogin != null) {
            setUsername(validLogin.username);
            setIsLoginSuccessful(true);
        } else {
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
                <input placeholder='email' type='text' onChange={changeEmail} />
                <input placeholder='password' type='password' onChange={changePassword} />
                <button type='submit'> Login </button>
            </form>
        </div>
    );
}

export default Loginform;