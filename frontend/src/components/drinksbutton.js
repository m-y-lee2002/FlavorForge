import React from 'react';
import { useNavigate } from 'react-router-dom';
const Drinksbutton = () => {
    const mealType = 'DRINKS';
    const navigate = useNavigate();
    const navigateToDrinks = ()=>{
        navigate('/drinks');
    }
    return (
        <div>
            <button onClick={navigateToDrinks}>{mealType}</button>
        </div>
    );
}

export default Drinksbutton;
