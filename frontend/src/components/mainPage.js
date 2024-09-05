import React from 'react';
import LogOutButton from './logoutbutton';
import BreakfastButton from './breakfastbutton';
import LunchButton from './lunchbutton';
import DinnerButton from './dinnerbutton';
import DessertButton from './dessertbutton';
import DrinksButton from './drinksbutton';
const MainPage = () => {
    let username = sessionStorage.getItem('username');
    return (
        <div>
            <LogOutButton/>
            <h1> HomePage: {username}</h1>
            <BreakfastButton/>
            <LunchButton/>
            <DinnerButton/>
            <DessertButton/>
            <DrinksButton/>
        </div>
    );
}

export default MainPage;