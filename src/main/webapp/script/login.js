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

function submitLogin(){
	var email = document.getElementById('email-input').value;
	var password = document.getElementById('pass-input').value;
		$.ajax({
	        url : '/elibrary/login',
	        type : "POST",
	        data : {
	                email : email,
	                password : password,  
	        },
	        success : function(xml) {
	        	document.body.innerHTML=xml;
	        }
		});
}

function search(){
	var bookSearch = document.getElementById('searchValue').value;
	var table = '<tr><td>Author</td>td>Title</td>td>edition</td>td>Publisher</td>td>Year</td>td>Extention</td></tr>';
		$.ajax({
	        url : '/elibrary/search',
	        type : "POST",
	        data :{

	        	str : bookSearch,
	        	
	        }, 
	        success : function(xml) {
	        	for(var i = 0; i < xml.length; i++){
	        		table += 
	        			'<tr>'+
		        			'<td>'+xml[i].author+'</td>'+
		        			'td>'+xml[i].title+'</td>'+
		        			'td>'+xml[i].edition+'</td>'+
		        			'td>'+xml[i].publisher+'</td>'+
		        			'td>'+xml[i].year+'</td>'+
		        			'td>'+xml[i].extention+'</td>'+
	        			'</tr>';
	        	}
	        	document.getElementById('search-table').innerHTML = table;
	        }
		});
}

function registration(){
	var fName = document.getElementById('firstName').value;
	var lName = document.getElementById('lastName').value;
	var email = document.getElementById('email-reg').value;
	var password = document.getElementById('pass').value;
	var date = document.getElementById('date').value;
	console.log(fName, lName, email, password, date);
		$.ajax({
	        url : '/elibrary/register',
	        type : "POST",
	        data : {
	        		fName : fName,
	        		lName : lName,
	                email : email,
	                password : password,  
	        },
	        success : function(xml) {
	        	document.body.innerHTML=xml;
	        }
		});
}

window.onload = function(){
	document.getElementById('sign').onclick = login;
	document.getElementById('registr').onclick = registr;
	document.getElementById('submitRegistr').onclick = registration;
	document.getElementById('login').onclick = submitLogin;
	document.getElementById('search-button').onclick = search;
}