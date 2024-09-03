import React from 'react';
import { useNavigate } from 'react-router-dom';

const Loginbutton = () => {
    const navigate = useNavigate();
    const buttonHandler = ()=>{
        navigate('loginpage');
    }
    return (
        <div>
            <button className='btn' onClick={buttonHandler}>LOG IN</button>
        </div>
    );
}

export default Loginbutton;
