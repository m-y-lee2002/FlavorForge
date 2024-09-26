import React, { useEffect, useState } from 'react';
import BackToMainButton from './backtomainbutton';
import BreakfastComponent from './breakfastComponent';
import { dishcontext } from './dishcontext';
import '../styles/breakfastPage.css';
const BreakfastPage = () => {
    
    return (
        <div className='BreakfastPage'>
            <h1>Breakfast</h1>
            <BackToMainButton/>
            <BreakfastComponent/>
        </div>
    );
}

export default BreakfastPage;
