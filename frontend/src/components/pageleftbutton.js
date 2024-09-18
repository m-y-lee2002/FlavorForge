import React, { useContext } from 'react';
import{alldishescontext} from './alldishescontext';
import { dishpositioncontext } from './dishpositioncontext';
const Pageleftbutton = () => {
    const {allDishes} = useContext(alldishescontext);
    const {dishPosition, setDishPosition} = useContext(dishpositioncontext);
    // const { dish } = useContext(dishcontext);
    const moveToNextDish = ()=>{
        console.log("Left button pressed");
        console.log(allDishes);
        console.log(dishPosition);
        if(dishPosition - 1 >= 0){
            setDishPosition(dishPosition-1);
        }
    }
    if(!allDishes|| dishPosition == null){
        return <div> All Dishes Name Unavailable</div>;
    }
    if(dishPosition == 0){
        return <div></div>
    }
    return (
        <div>
            <button onClick={moveToNextDish}>left</button>
        </div>
    );
}

export default Pageleftbutton;
