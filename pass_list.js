document.addEventListener('DOMContentLoaded', function () {
  const logoutBtn = document.getElementById('logoutBtn');
  logoutBtn.addEventListener('click', function () {
    localStorage.removeItem('userToken');
    sessionStorage.clear();
    window.location.href = "login.html";
  });

  var viewAttendanceBtn = document.getElementById('viewPasswordBtn');
  viewAttendanceBtn.addEventListener('click', function () {
    console.log('ViewPasswordBtn clicked');
    fetchdata();
  });
});

function populatePasswordTable(passwords) {
  const tableBody = document.getElementById('password-data');
  tableBody.innerHTML = ''; // Clear existing content

  passwords.forEach(password => {
    const tableRow = document.createElement('tr');

    const websiteCell = document.createElement('td');
    websiteCell.textContent = password.website;
    tableRow.appendChild(websiteCell);

    const usernameCell = document.createElement('td');
    usernameCell.textContent = password.username;
    tableRow.appendChild(usernameCell);

    const passwordCell = document.createElement('td');
    passwordCell.textContent = password.password;
    tableRow.appendChild(passwordCell);

    const actionsCell = document.createElement('td');
    actionsCell.innerHTML = '<button>Delete</button>';
    actionsCell.addEventListener('click', () => handleDelete(password));
    tableRow.appendChild(actionsCell);
    tableBody.appendChild(tableRow);
  });
}

async function handleDelete(item) {
  try {
    await fetch('http://localhost:8085/cypher/v1/password-lists/by-name-website-password', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item)
    });
    alert('Item deleted successfully.');
    fetchdata();
  } catch (error) {
    console.error('Error deleting item:', error);
  }
}



function fetchdata() {
  fetch(`http://localhost:8085/cypher/v1/password-lists/` + localStorage.getItem('userId'))
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      populatePasswordTable(data);
    })
    .catch(error => {
      console.error('Error searching employee:', error);
    });
}


