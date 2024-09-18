import React, { useEffect, useState } from 'react';
import BackToMainButton from './backtomainbutton';
import BreakfastComponent from './breakfastComponent';
import { dishcontext } from './dishcontext';
const BreakfastPage = () => {
    
    return (
        <div>
            <h1>Breakfast</h1>
            <BackToMainButton/>
            <BreakfastComponent/>
        </div>
    );
}

export default BreakfastPage;
