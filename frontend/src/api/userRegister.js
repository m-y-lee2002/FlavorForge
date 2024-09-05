import { data } from "autoprefixer";

export const userRegister = (targetUser) => {
    return fetch(`http://localhost:8080/api/account/register`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(targetUser),
        credentials: 'include',

    })
    .then(async response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        let message = await response.text();
        console.log(message);
        return message;
    })
    .catch(error => {
        console.error('Error fetching data:', error);
        return;
    });
};