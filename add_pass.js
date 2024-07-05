const form = document.getElementById('sign-up-form');
const userNameInput = form.querySelector('input[placeholder="User Name"]');
const websiteInput = form.querySelector('input[placeholder="Website"]');
const passwordInput = form.querySelector('input[placeholder="Password"]');


function getStoredUserId() {
    const userId = localStorage.getItem("userId");
    if (userId) {
      return parseInt(userId); // Convert retrieved string to a number
    }
    return null;
}



form.addEventListener('submit', async (event) => {
  event.preventDefault(); // Prevent default form submission behavior
  const id = localStorage.getItem('userId');
  const userName = userNameInput.value;
  const website = websiteInput.value;
  const password = passwordInput.value;

  // Input validation (optional but recommended)
  if (!userName || !website || !password) {
    alert('Please fill in all required fields.');
    return;
  }

  const apiUrl = 'http://localhost:8086/api/add_paswords'; // Replace with your actual API endpoint

  const data = {
    username : userName,
    website : website,
    password : password,
    id : id,
  };

  fetch(apiUrl, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
})

  .then(response => {
    if (response.ok) {
      document.getElementById('added').textContent = "Password Added successfully";
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
document.addEventListener('DOMContentLoaded', function () {
  const logoutBtn = document.getElementById('logoutBtn');
  logoutBtn.addEventListener('click', function () {
    localStorage.removeItem('userToken');
    sessionStorage.clear();
    window.location.href = "login.html";
  });
});