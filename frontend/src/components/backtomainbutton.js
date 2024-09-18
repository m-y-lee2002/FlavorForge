import React from 'react';
import { useNavigate } from 'react-router-dom';

const Backtomainbutton = () => {
    const navigate = useNavigate();
    const navigatetomain = ()=>{
        navigate('../mainpage');
    }
    return (
        <div>
            <button onClick={navigatetomain}>Back</button>
        </div>
    );
}

export default Backtomainbutton;
