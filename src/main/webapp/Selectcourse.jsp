<!DOCTYPE html>
<html>
<head>
    <title>Select Course</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Select Course</h1>
    <form id="courseForm" action="TopicConfigServlet" method="post">
        <label for="courseSelect">Select a Course:</label>
        <select id="courseSelect" name="course">
            <option value="java">Java</option>
            <option value="python">Python</option>
            <option value="javascript">JavaScript</option>
        </select>
        <button type="submit">Submit</button>
    </form>
    
    
<!--  Commented this part
    <script>
        $(document).ready(function() {
            // Submit form on selection change
            $('#courseSelect').change(function() {
                $('#courseForm').submit();
            });
        });
    </script>
 -->
</body>
</html>
