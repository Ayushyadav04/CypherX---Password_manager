document.addEventListener('DOMContentLoaded', function() {
    const container = document.getElementById('container');
    const registerBtn = document.getElementById('register');
    const loginBtn = document.getElementById('login');

    registerBtn.addEventListener('click', () => {
        container.classList.add("active");
    });

    loginBtn.addEventListener('click', () => {
        container.classList.remove("active");
    });

    function storeCredentials(email, password) {
        localStorage.setItem('email', email);
        localStorage.setItem('password', password);
    }

    function storeUserData(data) {
        if (!data || !data.id || !data.username || !data.email) {
          console.error("Invalid login response. Missing required fields.");
          return;
        }
      
        localStorage.setItem("userId", data.id);
        localStorage.setItem("username", data.username);
        localStorage.setItem("email", data.email);
    }

    document.getElementById('sign-in-form').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission
        
        // Get email and password inputs
        const email = document.querySelector('#sign-in-form input[type="email"]').value;
        const password = document.querySelector('#sign-in-form input[type="password"]').value;

        // Data to be sent in the request body
        const data = {
            email: email,
            password: password
        };

        // URL of your login API endpoint
        const loginUrl = 'http://localhost:8080/cypher/v1/user_login';
        // Make a POST request to the login API endpoint
        fetch(loginUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                if (data.status === true) {
                    storeCredentials(email, password);
                    storeUserData(data);
                    // Login successful, redirect the user to the dashboard or perform any other action
                    window.location.href = '/main.html'; // Redirect to dashboard page
                } else {
                    // Login failed, display an error message to the user
                    alert('Login failed. Please check your credentials.');
                }
            })
            .catch(error => {
                console.error('There was a problem with the login request:', error);
            });
        
    });

    document.querySelector('#sign-up-form').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission

        // Get username, email, and password inputs
        const username = document.querySelector('#sign-up-form input[type="text"]').value;
        const email = document.querySelector('#sign-up-form input[type="email"]').value;
        const password = document.querySelector('#sign-up-form input[type="password"]').value;

        // Data to be sent in the request body
        const data = {
            username: username,
            email: email,
            password: password
        };
        // URL of your API endpoint to add user data to the database
        const addEmployeeUrl = 'http://localhost:8080/cypher/v1/new_user';
        // Send the data to the API endpoint
        fetch(addEmployeeUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (response.ok) {
                // Handle success response
                document.getElementById('added').textContent = "Account created successfully";
                console.log('Account created successfully.');
                // You can display a success message to the user or redirect
            } else {
                // Handle error response
                console.error('Failed to add user.');
                // You can display an error message to the user
            }
        })
        .catch(error => {
            console.error('There was a problem with the sign up request:', error);
        });
    });
});
