import React from "react";
import LoginButton from "./loginbutton";
import SignupButton from "./signupbutton";
import Title from "./title";
import StartButton from "./startbutton";

const landingPage = () => {
    return (
    <div className="LandingPage">
        <SignupButton/>
        <LoginButton/>
        <Title/>
        <StartButton/>
    </div>

    );
}

export default landingPage;