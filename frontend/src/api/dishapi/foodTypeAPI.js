export const foodTypeAPI = (foodType, email) => {
    return fetch(`http://localhost:8080/api/dish/getFoodTypeDishes/${foodType}/${email}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Call the json() method
    })
    .catch(error => {
        console.error('Error fetching data:', error);
        throw error; // Re-throw the error to be caught in the calling function
    });
};