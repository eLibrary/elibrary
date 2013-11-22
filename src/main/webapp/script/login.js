function login(){
	var txt = document.getElementById('login-form');
	console.log(txt.style.visibility);
	txt.style.visibility = "visible";
}

window.onload = function(){
	document.getElementById('sign').onclick = login;
}