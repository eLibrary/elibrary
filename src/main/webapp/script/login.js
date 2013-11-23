var logReg = false;

function login(){
	if(!logReg){
		document.getElementById('login-form').style.visibility = "visible";
		logReg = true;
	}else {
		logReg = false;
		document.getElementById('registration').style.visibility = 'hidden';
		document.getElementById('login-form').style.visibility = "hidden";
	}
}

function registr(){
	document.getElementById('registration').style.visibility = 'visible';
	document.getElementById('login-form').style.visibility = "hidden";
}

window.onload = function(){
	document.getElementById('sign').onclick = login;
	document.getElementById('registr').onclick = registr;
}