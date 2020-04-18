function showAlert() {
	alert("The button was clicked!");
}

function inoutCheck(form){
	var username = form.username.value;
	var passwd = form.passwd.value;
	
	if(username==""){
		alert("username null");
		return;
	}

	if(passwd==""){
		alert("passwd null");
		return;
	}
	
	form.submit();
}