import React from 'react';
import { useNavigate } from 'react-router-dom';
const Breakfastbutton = ({username}) => {
    const mealType = 'BREAKFAST';
    const navigate = useNavigate();
    const navigateToBreakfast = ()=>{
        navigate('/breakfast');
    }
    return (
        <div>
            <button onClick={navigateToBreakfast}>{mealType}</button>
        </div>
    );
}

export default Breakfastbutton;
