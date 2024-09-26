import React from 'react';
import { useNavigate } from 'react-router-dom';

const Adddishbutton = () => {
    const navigate = useNavigate();
    const moveToAddDish = ()=>{
        navigate('../createdish')
    }
    return (
        <div>
            <button onClick={moveToAddDish}>Add Dish</button>
        </div>
    );
}

export default Adddishbutton;
