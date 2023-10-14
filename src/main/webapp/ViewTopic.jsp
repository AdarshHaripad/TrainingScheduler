<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FetchTopicServlet" method="get">
<div>
         <label for="courseSelect">Select a Course:</label>
        <select id="courseSelect" name="course">
            <option value="java">Java</option>
            <option value="python">Python</option>
            <option value="javascript">JavaScript</option>
        </select>
        </div>
        
           <div>
            <input type="submit" value="View Topics">
        </div>
        
        </form>
</body>
</html>