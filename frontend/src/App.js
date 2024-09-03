import LandingPage from './components/landingPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './components/loginPage';
import './App.css';
import MainPage from './components/mainPage';
import RegisterPage from './components/registerPage';
function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
            <Route path="/" element = {<LandingPage/>}/>
            <Route path="/loginpage" element = {<LoginPage/>}/>
            <Route path="/mainpage" element = {<MainPage/>}/>
            <Route path="/register" element = {<RegisterPage/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
