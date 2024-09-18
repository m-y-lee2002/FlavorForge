import React from 'react';
import { useNavigate } from 'react-router-dom';
const Dessertbutton = () => {
    const mealType = 'DESSERT';
    const navigate = useNavigate();
    const navigateToDessert = ()=>{
        navigate('/dessert');
    }
    return (
        <div>
            <button onClick={navigateToDessert}>{mealType}</button>
        </div>
    );
}

export default Dessertbutton;
