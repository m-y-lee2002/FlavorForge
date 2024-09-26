import LandingPage from './components/landingPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './components/loginPage';
import './App.css';
import MainPage from './components/mainPage';
import RegisterPage from './components/registerPage';
import BreakfastPage from './components/breakfastPage';
import LunchPage from './components/lunchPage';
import DinnerPage from './components/dinnerPage';
import DessertPage from './components/dessertPage';
import DrinksPage from './components/drinksPage';
import CreateDishPage from './components/createDishPage';
import { useState } from 'react';
function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route path="/" element = {<LandingPage/>}/>
                <Route path="/loginpage" element = {<LoginPage/>}/>
                <Route path="/mainpage" element = {<MainPage/>}/>
                <Route path="/register" element = {<RegisterPage/>}/>
                <Route path="/breakfast" element = {<BreakfastPage/>}/>
                <Route path="/lunch" element = {<LunchPage/>}/>
                <Route path="/dinner" element = {<DinnerPage/>}/>
                <Route path="/dessert" element = {<DessertPage/>}/>
                <Route path="/drinks" element = {<DrinksPage/>}/>
                <Route path="/createdish" element = {<CreateDishPage/>}/>
            </Routes>
          </Router>
    </div>
  );
}

export default App;
