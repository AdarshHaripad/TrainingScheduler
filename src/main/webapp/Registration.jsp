<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>User Registration</title>

<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/Registration.css">
<link rel="stylesheet" href="alert/dist/sweetalert.css">
</head>
<body>

<input type="hidden" id="status" value="<%=request.getAttribute("Status") %>">
 <header>
    <img class="Logo-img" src="images/xpertlogo.jpeg-removebg.png" alt="Logo">
<!-- <h2 class="logo">Logo</h2> -->
<nav class="navigation">
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Contact</a>
   <a href="Login.jsp"><button class="btnlogin_popup">Login</button></a> 
</nav>
 </header>

	<div>

		<!-- Sign up form -->
	
				<div class="Wrapper">
					<div class="form-box login">
						<h2>Sign up</h2>
					
						<form method="post" action="RegistrationServlet" class="register-form" id="register-form" onsubmit= "validateForm()">
							<div class="input-box">
								<input type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							
							<div class="input-box">
							 <input type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							
							<div class="input-box">
							<input type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							
							<div class="input-box">
								
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="input-box">
								
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
							
							<div class="login-Rem">
								<input type="checkbox" name="agree-term" id="agree-term"
									/> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div>
								<button type="submit" name="signup" id="signup"
									class="btn" value="Register" >Sign Up</button>
							</div>
						</form>
					</div>
				
				</div>
			</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	
	<script type="text/javascript">
	var st= document.getElementById("status").value;
	if(st == "Success"){
		swal("Congrats","Account created successfully","Success");

	}
	</script>


</body>
</html>