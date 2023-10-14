package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddTopicServlet
 */
@WebServlet("/AddTopicServlet")
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String courseName = request.getParameter("course");
	        String topicName = request.getParameter("topic");
	        int duration = Integer.parseInt(request.getParameter("duration"));

	        // Insert the new topic into the database
	        insertTopicIntoDatabase(courseName, topicName, duration);

	        // Forward to the topicConfig.jsp page
	        RequestDispatcher dispatcher = request.getRequestDispatcher("topicConfig.jsp");
	        dispatcher.forward(request, response);
	       
	    }

	    private void insertTopicIntoDatabase(String courseName, String topicName, int duration) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        try {
	            // Establish the database connection
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tr_Sc", "root", "adarsh@1");

	            // Prepare the SQL statement for inserting the topic
	            String sql = "INSERT INTO coursetopics (course, topic, duration) VALUES (?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, courseName);
	            stmt.setString(2, topicName);
	            stmt.setInt(3, duration);

	            // Execute the SQL statement
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the database resources
	            try {
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
	    }
	    
	   
	    }

	  

