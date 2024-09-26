import React from 'react';
import { useNavigate } from 'react-router-dom';

const Backtobreakfastbutton = () => {
    const navigate = useNavigate();
    const navigateToBreakfast = ()=>{
        navigate('../breakfast')
    }
    return (
        <div>
            <button onClick={navigateToBreakfast}>Back</button>
        </div>
    );
}

export default Backtobreakfastbutton;
