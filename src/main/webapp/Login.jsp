<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>User Login</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/Login.css">
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
   <a href="Registration.jsp"><button class="btnlogin_popup">Sign Up</button></a> 
</nav>
 </header>
	<div>

		<!-- Sing in  Form -->

					<div class="Wrapper">
						 <div class="form-box login">
       						 <h2>Sign In</h2>
						<form method="post" action="LoginServlet" class="register-form"
							id="login-form">
							<div class="input-box">
								
									<input type="text" name="username" id="username"
									placeholder="Your Name" />
									
							</div>
							<div class="input-box">
								 <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							<div class="login-Rem">
								<input type="checkbox" name="remember-me" id="remember-me"> Remember me </input>
							</div>
							<div>
								<button class="btn" type="submit" name="signin" id="signin"
								 value="Log in" >Login</button>
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
	if(st == "failed"){
		swal("Sorry","Username or Password is incorrect.","error");

	}
	
	</script>
</body>

</html>