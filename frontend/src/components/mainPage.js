    import React, { useContext, useEffect, useState } from 'react';
    import LogOutButton from './logoutbutton';
    import BreakfastButton from './breakfastbutton';
    import LunchButton from './lunchbutton';
    import DinnerButton from './dinnerbutton';
    import DessertButton from './dessertbutton';
    import DrinksButton from './drinksbutton';
    import { useNavigate } from 'react-router-dom';
    const MainPage = () => {
        const [user, setUser] = useState(null);
        const navigate = useNavigate();
    
        useEffect(() => {
            const storedUser = sessionStorage.getItem('user');
            if (storedUser) {
                setUser(JSON.parse(storedUser));
            } else {
                navigate('/loginpage');
            }
        }, [navigate]);
    
        if (!user) {
            return <div>Loading...</div>;
        }
        return (
            <div>
                <LogOutButton/>
                <h1> HomePage: {user.username}</h1>
                <BreakfastButton/>
                <LunchButton/>
                <DinnerButton/>
                <DessertButton/>
                <DrinksButton/>
            </div>
        );
    }

    export default MainPage;