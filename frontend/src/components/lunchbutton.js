import React from 'react';
import { useNavigate } from 'react-router-dom';

const Lunchbutton = () => {
    const mealType = 'LUNCH';
    const navigate = useNavigate();
    const navigateToLunch = ()=>{
        navigate('/lunch');
    }
    return (
        <div>
            <button onClick={navigateToLunch}>{mealType}</button>
        </div>
    );
}

export default Lunchbutton;
