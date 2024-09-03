import React from 'react';
import { useNavigate } from 'react-router-dom';

const Signupbutton = () => {
    const navigate = useNavigate();
    const navigateToRegister = ()=>{
            navigate('/register');
    }
    return (

        <div>
            <button onClick={navigateToRegister}>SIGN UP</button>
        </div>
    );
}

export default Signupbutton;
