<!DOCTYPE html>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   
<html>
<head>
    <meta charset="UTF-8">
    <title>Topic Configuration</title>
    <!-- Add your CSS and JavaScript references here -->
</head>
<body>
    <h2>Topic Configuration</h2>
    <form action="AddTopicServlet" method="post">
        <!--input type="hidden" name="course" value="${course}"-->
        
        <div>
         <label for="courseSelect">Select a Course:</label>
        <select id="courseSelect" name="course">
            <option value="java">Java</option>
            <option value="python">Python</option>
            <option value="javascript">JavaScript</option>
        </select>
        </div>
         
        <div>
            <label for="topic">Topic:</label>
            <input type="text" id="topic" name="topic" required>
        </div>
        <div>
            <label for="duration">Duration (in hours):</label>
            <input type="number" id="duration" name="duration" min="1" required>
        </div>
        
        <div>
            <input type="submit" value="Add Topic">
        </div>
        
        
    </form>
    <br>
    
    <a href="ViewTopic.jsp">View The Existing Topics</a>
    <!-- Add your additional HTML content and scripts here -->
     
    
</body>
</html>
