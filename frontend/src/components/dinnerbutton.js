import React from 'react';
import { useNavigate } from 'react-router-dom';
const Dinnerbutton = () => {
    const mealType = 'DINNER';
    const navigate = useNavigate();
    const navigateToDinner = ()=>{
        navigate('/dinner');
    }
    return (
        <div>
            <button onClick={navigateToDinner}>{mealType}</button>
        </div>
    );
}

export default Dinnerbutton;
