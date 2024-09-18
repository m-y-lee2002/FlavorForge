import React, { useContext } from 'react';
import { alldishescontext } from './alldishescontext';
import { dishpositioncontext } from './dishpositioncontext';

const Dishname = () => {
    const { allDishes } = useContext(alldishescontext);
    const {dishPosition} = useContext(dishpositioncontext);

    if (dishPosition == null||!allDishes) {
        // console.log(allDishes);
        return <div>Dish Name: Context Not Available</div>;
    }

    return (
        
        <div>
            <h1>Dish Name: {allDishes[dishPosition].did.dname}</h1>
        </div>
    );
}

export default Dishname;