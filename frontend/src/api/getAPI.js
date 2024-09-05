export const getAPI = (path, data) => {
    return fetch(`http://localhost:8080/api/get/${path}/${data}`, {
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
        return response;
    })
    .catch(error => {
        console.error('Error fetching data:', error);
        return;
    });
};