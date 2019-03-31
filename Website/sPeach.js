$(document).ready(function() {
    $("#member_form").submit(
			function(event) {
				var isValid = true;
				
				// validate the first name entry
				var firstName = $("#fname").val().trim();
				if (firstName == "") {
					document.getElementById("fname").previousElementSibling.innerHTML = "This field is required";				  
					isValid = false;
				} else {
					document.getElementById("fname").previousElementSibling.innerHTML = "";				  
				}
				$("#fname").val(firstName);
							
				// validate the last name entry
				var lastName = $("#lname").val().trim();
				if (lastName == "") {
					document.getElementById("lname").previousElementSibling.innerHTML = "This field is required";				  
					isValid = false;
				} else {
					document.getElementById("lname").previousElementSibling.innerHTML = "";				  
				}
				$("#lname").val(lastName);
				
				// validate the email entry with a regular expression
				var emailPattern = /\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}\b/;
				var email = $("#email").val().trim();
				if (email == "") { 
					document.getElementById("email").previousElementSibling.innerHTML = "This field is required.";				  
					isValid = false;
				} else if ( !emailPattern.test(email) ) {
					document.getElementById("email").previousElementSibling.innerHTML = "Must be a valid email entry.";				  
					isValid = false;
				} else {
					document.getElementById("email").previousElementSibling.innerHTML = "";				  
				}
				$("#email").val(email);
				
				var verify = $("#verify").val().trim(); 
				if (verify == "") {
					document.getElementById("verify").previousElementSibling.innerHTML = "This field is required."; 
					isValid = false; 
				} else if (email != verify) {
					document.getElementById("verify").previousElementSibling.innerHTML = "This entry must equal the last."; 
					isValid = false; 
				} else {
					document.getElementById("verify").previousElementSibling.innerHTML = ""; 
				}
				$("#verify").val(verify); 

				var subject = $("#subject").val().trim(); 
				if (subject == "") {
					document.getElementById("subject").previousElementSibling.innerHTML = "This field is required.";				  
					isValid = false; 
				} else {
					document.getElementById("subject").previousElementSibling.innerHTML = "";				  
				}
				$("#subject").val(subject); 

				var message = $("#message").val().trim(); 
				if (message == "") {
					document.getElementById("message").previousElementSibling.innerHTML = "This field is required.";				  
					isValid = false; 
				} else {
					document.getElementById("message").previousElementSibling.innerHTML = "";				  
				}
				$("#message").val(message); 

				// prevent the submission of the form if any entries are invalid 
			if (isValid == false) {
				event.preventDefault();				
			} 
		} // end function
	);
});