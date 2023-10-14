<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Training Schedule</title>
    <link rel="stylesheet" type="text/css" href="css/Scheduler.css">
</head>
<body>
    <div class="container">
        <h1>Training Schedule</h1>
        <div class="schedule-results">
            <div>
                <p><strong>Course:</strong> ${course}</p>
                <p><strong>Duration:</strong> ${duration} hours</p>
                <p><strong>Batch Type:</strong> ${batchType}</p>
                <p><strong>Hours per Day:</strong> ${hoursPerDay}</p>
                <p><strong>Start Date:</strong> ${startDateStr}</p>
                <p><strong>End Date:</strong> ${endDateStr}</p>
                <p><strong>Total Days:</strong> ${totalDays}</p>
            	<p><strong>Day-wise Schedule:</strong><p>${schedule}</p>
                
            </div>
        </div>
        <form action="FetchDaywiseTopic" method="get">
        <div>
       <input type="hidden" id="course" name="course1" value="<%=request.getAttribute("course") %>">
       <input type="hidden" id="duration" name="duration1" value="<%=request.getAttribute("duration") %>">
       <input type="hidden" id="hoursPerDay" name="hoursPerDay1" value="<%=request.getAttribute("hoursPerDay") %>">
         <div>
            <input type="submit" value="View Day-wise Schedule">
        </div>
        
        </div>
        </form>
         
    
    </div>
</body>
</html>
