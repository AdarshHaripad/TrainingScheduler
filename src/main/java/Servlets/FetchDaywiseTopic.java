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

import Utility.DBUtil;

/**
 * Servlet implementation class FetchDaywiseTopic
 */
@WebServlet("/FetchDaywiseTopic")
public class FetchDaywiseTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//Retrieving the course name and hours per day from the front end(while clicking the "show day wise plan")
	    String courseName = request.getParameter("course1");
	    int hoursPerDay = Integer.parseInt(request.getParameter("hoursPerDay1"));
	    
 //Retrieving a list of data with the selected course(Calculated and inserted topics with respect to the hours per day) =>will call the method on L:76
	    List<String> Alltopics = retrieveTopicsFromDatabase(courseName,hoursPerDay);
	   

	    
//Displaying the List in the front end as a table
	    response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Topic</th><th>Edit</th><th>Delete</th></tr>");
        
//Iterating through the Final list(no need of edit and delete:should be removed after integrating with the dates)
        for (int i = 0; i < Alltopics.size(); i++) {
			
            out.print("<tr><td>" + Alltopics.get(i) + "</td><td><a href='EditServlet?id="
                    + Alltopics.get(i) + "'>edit</a></td>  <td><a href='DeleteServlet?id=" +Alltopics.get(i) 
                    + "'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
	    
    //------------------------------------------------------------------
	    
 
      
// Set the topics as a request attribute
	    request.setAttribute("topics", Alltopics);

// Forward the request to the JSP page for displaying the data
	    request.getRequestDispatcher("schedule.jsp").include(request, response);

	}
	
	
	//-----------------------------------------------------
	
	
	
	
	
	
	
//method for retrieving the course topic list from database using the bean class CourseTopic
	private List<String> retrieveTopicsFromDatabase(String courseName,int hoursPerDay) {
 		  
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        
 //creating a list for storing the topic and duration from database
	        List<String> topics = new ArrayList<>();
	      
	        int remainingHours=hoursPerDay;
	        StringBuilder obj=new StringBuilder();
	        int balance=0;
	              
	        try {
	            conn=DBUtil.getconnection();
 // Prepare the SQL statement for retrieving the topics
	            String sql = "SELECT topic, duration FROM coursetopics WHERE course = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, courseName);

	            // Execute the SQL statement
	            rs = stmt.executeQuery();
	            
	            
//Fetching the table and adding the topics to another list with respect to the duration and hoursperday(conditions applied)
//used the hoursperday from the front end and calculated the daywise plan with the help of a while loop and if loop
				while (rs.next()) {
					
			    String topic = rs.getString("topic");
			    int duration = rs.getInt("duration");
	
			    {
			    while (duration > remainingHours) {
			        topics.add(topic);
			        duration -= remainingHours;
//***			        remainingHours = hoursPerDay;
			    }
		
			    if (duration > 0) {
			        topics.add(topic);
			     //   remainingHours -= duration;
			    	}
			    }
			    
			    //This is a test for duration less than hpd********

//			    
//    			while(duration > 0) {
//    				remainingHours -=duration;
//    				if(remainingHours == 0) {
//    					topics.add(topic);
//    				}else {
//    					obj.append(topic);
//    				}
//    			}
    			
			    
    
    }
    }
	        
	        
				
	        catch (SQLException e) {
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

	       //After retrieving all the elements from the table the list will be returned to alltopics list.
	        return topics;
	    }   	
	
//	 First Attempt for references ------------------------------------------------     
//    try {
//        conn=DBUtil.getconnection();
//        // Prepare the SQL statement for retrieving the topics
//        String sql = "SELECT topic, duration FROM coursetopics WHERE course = ?";
//        stmt = conn.prepareStatement(sql);
//        stmt.setString(1, courseName);
//
//        // Execute the SQL statement
//        rs = stmt.executeQuery();
//
//        // Iterate over the result set and create Topic objects
//        while (rs.next()) {
//            String topicName = rs.getString("topic");
//         
//            int duration = rs.getInt("duration");
//          
//            //creating the object of a bean class
//            CourseTopic topic = new CourseTopic(topicName, duration);
//            //adding these object into the list
//            topics.add(topic);
//           
//        }
    
//------------------------------------------------  end


}
