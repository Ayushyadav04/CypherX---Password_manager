const toggleBtn = document.getElementById('toggleBtn');
const sidebar = document.getElementById('sidebar');

toggleBtn.addEventListener('click', () => {
  sidebar.classList.toggle('hidden');  /* Toggle hidden class */

  
});

const addPasswordLink = document.querySelector('a[href="add_pass"]');
const homepage = document.querySelector('a[href="main"]');
const addPasswordFrame = document.getElementById('add-password-frame');

document.getElementById('userId').textContent = localStorage.getItem('username');



document.addEventListener('DOMContentLoaded', function () {
  const logoutBtn = document.getElementById('logoutBtn');
  logoutBtn.addEventListener('click', function () {
    localStorage.removeItem('userToken');
    sessionStorage.clear();
    window.location.href = "login.html";
  });
});