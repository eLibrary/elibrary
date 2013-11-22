function login(){
	document.getElementById('login-form').style.visibility = "visible";
}

function registr(){
	document.getElementById('registration').style.visibility = 'visible';
	document.getElementById('login-form').style.visibility = "hidden";
}

window.onload = function(){
	document.getElementById('sign').onclick = login;
	document.getElementById('registr').onclick = registr;
}