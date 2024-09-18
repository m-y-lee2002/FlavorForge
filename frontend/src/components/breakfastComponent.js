import React, { useContext, useEffect, useState } from 'react';
import DishImage from './dishimage';
import DishName from './dishname';
import DishIngredients from './dishingredients';
import EditDishButton from './editdishbutton';
import AdditionalInfoButton from './additionalinfobutton';
import PageLeftButton from './pageleftbutton';
import PageRightButton from './pagerightbutton';
import AddDishButton from './adddishbutton';
import { dishcontext } from './dishcontext';
import { alldishescontext } from './alldishescontext';
import { foodTypeAPI } from '../api/dishapi/foodTypeAPI';
import { useNavigate } from 'react-router-dom';
import { dishpositioncontext } from './dishpositioncontext';
const BreakfastComponent = () => {
    const [allDishes, setAllDishes] = useState(null);
    const [user, setUser] = useState(null);
    const navigate = useNavigate();
    const [dishPosition, setDishPosition] = useState(0);
    const [dish, setDish] = useState(null);

    useEffect(() => {
        const storedUser = sessionStorage.getItem('user');
        if (storedUser) {
            const parsedUser = JSON.parse(storedUser)
            setUser(parsedUser);
            fetchListOfDishes(parsedUser);
        } else {
            navigate('/loginpage');
        }
    }, [navigate]);

    const fetchListOfDishes = async (parsedUser) => {
        try {
            const listOfDishes = await foodTypeAPI('B', parsedUser.email);
            if (listOfDishes.length > 0) {
                setAllDishes(listOfDishes);
                setDish(listOfDishes[dishPosition]);
                console.log(dishPosition);
                // setDishPosition(0);
            }
        } catch (error) {
            console.error('Error in fetchListOfDishes:', error);
            setDish(null);
        }
    }

    if (!user || !dish||!allDishes||dishPosition == null) {
        return <div>Loading...</div>;
    }

    return (

            <div>
                <dishpositioncontext.Provider value={{dishPosition, setDishPosition}}>
                    <alldishescontext.Provider value={{allDishes, setAllDishes}}>
                            <AddDishButton/>
                            <DishImage/>
                            <DishName/>
                            <DishIngredients/>
                            <EditDishButton/>
                            <AdditionalInfoButton/>
                        <PageRightButton/>
                        <PageLeftButton/>
                    </alldishescontext.Provider>
                </dishpositioncontext.Provider>
               


            </div>

    );
}

export default BreakfastComponent;