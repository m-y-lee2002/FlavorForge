import React from 'react';
import { useNavigate } from 'react-router-dom';

const Logoutbutton = () => {
    const navigate = useNavigate();

    const navigateToHome = ()=>{
        sessionStorage.clear();
        navigate('/');
    }
    return (
        <div>
            <button onClick={navigateToHome}>Log Out</button>
        </div>
    );
}

export default Logoutbutton;
