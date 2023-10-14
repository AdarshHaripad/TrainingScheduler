package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.CourseTopic;
import Utility.DBUtil;



/**
 * Servlet implementation class FetchTopicServlet
 */
@WebServlet("/FetchTopicServlet")
public class FetchTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String courseName = request.getParameter("course");

	    List<Bean.CourseTopic> topics = retrieveTopicsFromDatabase(courseName);

	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Topic</th><th>Duration</th><th>Edit</th><th>Delete</th></tr>");
        for (Bean.CourseTopic e : topics) {
            out.print("<tr><td>" + e.getTopic() + "</td><td>" + e.getTimeTaken() + "</td><td><a href='EditServlet?id="
                    + e.getTopic() + "'>edit</a></td>  <td><a href='DeleteServlet?id=" + e.getTopic()
                    + "'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
	    
	    // Set the topics as a request attribute
	    request.setAttribute("topics", topics);

	    // Forward the request to the JSP page for displaying the data
//	    request.getRequestDispatcher("ViewTopic.jsp").forward(request, response);
	    request.getRequestDispatcher("ViewTopic.jsp").include(request, response);
	}
	private List<Bean.CourseTopic> retrieveTopicsFromDatabase(String courseName) {
 		  
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<CourseTopic> topics = new ArrayList<>();
	        
	        try {
	            conn=DBUtil.getconnection();
	            // Prepare the SQL statement for retrieving the topics
	            String sql = "SELECT topic, duration FROM coursetopics WHERE course = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, courseName);

	            // Execute the SQL statement
	            rs = stmt.executeQuery();

	            // Iterate over the result set and create Topic objects
	            while (rs.next()) {
	                String topicName = rs.getString("topic");
	                System.out.println(topicName);
	                int duration = rs.getInt("duration");
	                System.out.println(duration);
	                CourseTopic topic = new CourseTopic(topicName, duration);
	                topics.add(topic);
	                System.out.println(topics);
	             
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the database resources
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return topics;
	    }   	

}
