<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
 <link rel="stylesheet" href="css/Scheduler.css">
</head>
<body>
	

	
	
    <div class="container">
   
        
        	<div class="split left">
				<div >
				<a href="Home.jsp">Home</a></div>
				<div >
				<a href="#">About</a></div>
				<div >
				<a href="#">Contact</a></div>
				<div >
				<button id="logoutBtn" onclick="logout()">Logout</button></div>
				
	</div>
	     
	<div class="split right">
        <form class="form" action="DaywiseServlet" method="post">
        <h1>Training Scheduler</h1>
            <div class="form-group">
                <label for="course">Course:</label>
                <select name="course" id="course" onchange="updateDuration()" required >
                	<option value="selected">--select--</option>
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="Software Testing">Software Testing</option>
                    <!-- Add more course options here -->
                </select>
            </div>
            
            <div class="form-group">
                <label for="duration">Duration :</label>
                <input type="text" name="duration" id="duration">
            </div>
            
            <div class="form-group">
                <label>Batch Type:</label>
                <div class="radio-group">
                    <input type="radio" name="batchType" value="weekday" id="weekday">
                    <label for="weekday">Weekday</label>
                </div>
                    <div class="radio-group">
                    <input type="radio" name="batchType" value="weekend" id="weekend">
                    <label for="weekend">Weekend</label>
                </div>
            </div>
            
            <div class="form-group">
                <label for="hoursPerDay">Hours per Day:</label>
                <input type="text" name="hoursPerDay" id="hoursPerDay" required>
            </div>
            
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" name="startDate" id="startDate" required>
            </div>
            
            <div class="form-group">
                <input type="submit" value="Create Batch" class="btn1">
                <input type="reset" value="Reset" class="btn2">
            </div>
            
        </form>
       </div>
       
     </div>
        <!-- Your JSP page content -->




<!-- JavaScript code -->
<script>
  // Logout function
  function logout() {
    // Send a GET request to the logout servlet
    fetch('logout', {
      method: 'GET',
      credentials: 'same-origin' // Send cookies with the request
    })
    .then(function(response) {
      // Redirect to the login page
      window.location.href = 'Login.jsp';
    })
    .catch(function(error) {
      console.error('Logout error:', error);
    });
  }

  // Add click event listener to the logout button
  document.getElementById('logoutBtn').addEventListener('click', logout);
  
  //For automatically generating duration when course selected
  function updateDuration() {
	  var courseSelect = document.getElementById("course");
	  var durationField = document.getElementById("duration");

	  // Retrieve the selected value from the course dropdown
	  var selectedCourse = courseSelect.value;

	  // Update the duration field based on the selected course
	  if (selectedCourse === "Java") {
	    durationField.value = "120";
	  } else if (selectedCourse === "Python") {
	    durationField.value = "100";
	  } else {
	    durationField.value = ""; // Clear the duration field if no course is selected
	  }
	}
</script>

</body>
</html>