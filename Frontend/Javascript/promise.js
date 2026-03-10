
const promise1 = Promise.resolve(10);
const promise2 = new Promise((resolve) => {
    setTimeout(() => resolve(20), 1000);
});


Promise.all([promise1, promise2])
    .then((results) => {
        console.log("Results from Promise.all:", results); 
    })
    .catch((err) => console.error(err));


fetch("https://jsonplaceholder.typicode.com/users")
    .then((response) => {
        
        return response.json(); 
    })
    .then((data) => {
        
        console.log("First user name:", data[0].name);
    })
    .catch((error) => {
        console.log("Fetch error:", error);
    });
