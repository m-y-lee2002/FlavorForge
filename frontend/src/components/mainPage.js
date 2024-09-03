import React from 'react';

const MainPage = () => {
    let username = sessionStorage.getItem('email');
    return (
        <div>
            <h1> HomePage: {username}</h1>
        </div>
    );
}

export default MainPage;