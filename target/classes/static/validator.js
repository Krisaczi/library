function validateLogin(){

var login = document.getElementById("login");
var password = document.getElementById("password");

var regex = /^[a-zA-Z0-9]{5,}$/;

if(!regex.test(login.value)) {
login.style.background ="#ff0000";
return false;
}

if(!regex.test(password.value)) {
return false;
}
return true;
}