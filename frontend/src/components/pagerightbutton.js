import React, { useContext } from 'react';
import{alldishescontext} from './alldishescontext';
import { dishpositioncontext } from './dishpositioncontext';
import { dishcontext } from './dishcontext';
const Pagerightbutton = () => {
    const {allDishes} = useContext(alldishescontext);
    const {dishPosition, setDishPosition} = useContext(dishpositioncontext);
    // const { dish } = useContext(dishcontext);
    const moveToNextDish = ()=>{
        console.log("Right button pressed");
        console.log(allDishes);
        console.log(dishPosition);
        console.log(allDishes.length)
        if(dishPosition+1 < allDishes.length){
            setDishPosition(dishPosition+1);
        }
    }
    if(!allDishes|| dishPosition == null){
        return <div> All Dishes Name Unavailable</div>;
    }
    if(dishPosition == allDishes.length-1){
        return <div></div>
    }
    return (
        <div>
            <button onClick={moveToNextDish}>Right</button>
        </div>
    );
}

export default Pagerightbutton;
