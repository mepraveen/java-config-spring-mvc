function validate() {
	
	
	var password = document.f1.password.value.trim();
	var repassword = document.f1.repassword.value.trim();
	var username = document.f1.username.value.trim();
	
	var status = false;

	
	var x = document.f1.email.value.trim();
	var atposition = x.indexOf("@");
	var dotposition = x.lastIndexOf(".");

	if (atposition < 1 || dotposition < atposition + 2
			|| dotposition + 2 >= x.length) {
		document.getElementById("emailloc").innerHTML = "<img src='./resources/core/images/unchecked.gif'/> Invalid Email";
		status = false;

	} else {
		document.getElementById("emailloc").innerHTML = "<img src='./resources/core/images/checked.gif'/>";
		status = true;
		
		if((username.length < 6)){
			document.getElementById("usernameloc").innerHTML = "<img src='./resources/core/images/unchecked.gif'/>Enter Username";
			status = false;
			
		}else{
			
			document.getElementById("usernameloc").innerHTML = "<img src='./resources/core/images/checked.gif'/>";
			status = true;

		if ((password.length < 6)) {
			document.getElementById("passwordloc").innerHTML = "<img src='./resources/core/images/unchecked.gif'/> Password must be at least 6 char long";
			status = false;

		} else {
			document.getElementById("passwordloc").innerHTML = "<img src='./resources/core/images/checked.gif'/>";
			status = true;
			
			
				if(repassword == password){
				
				document.getElementById("repasswordloc").innerHTML = "<img src='./resources/core/images/checked.gif'/>";
				status = true;
			} else {
				document.getElementById("repasswordloc").innerHTML = "<img src='./resources/core/images/unchecked.gif'/>Password not matched";
				status = false;
				
			}

			}

		}

	}
	return status;
}

	
