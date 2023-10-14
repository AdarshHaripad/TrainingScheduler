package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RetrieveTopic;
import Bean.ScheduledTopic;
import Utility.DBUtil;

/**
 * Servlet implementation class DaywiseServlet
 */
@WebServlet("/DaywiseServlet")
public class DaywiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String course =req.getParameter("course");
		System.out.println(course);
		int duration = Integer.parseInt(req.getParameter("duration"));
		String batchType=req.getParameter("batchType");
		int hoursPerDay=Integer.parseInt(req.getParameter("hoursPerDay"));
		String startDateStr=req.getParameter("startDate");
		
		
		
//Whole data from the database associated with the course given
		List<RetrieveTopic> objList= retrieveTopicsFromDatabase(course);
		
		
//Calculate the number of days
		int NumDays=duration/hoursPerDay;
		
//Get the start date from the frontend
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					 Date startDate;
try {
					startDate = dateFormat.parse(startDateStr);
	
			
//Iterate over the topics and assign them to specific days
		List<ScheduledTopic> scheduledTopics = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);

				for (RetrieveTopic topic : objList) {
					
		    // Calculate the end date for the current topic
				    calendar.add(Calendar.DAY_OF_MONTH, 1);
				    Date endDate = calendar.getTime();
		
		    // Store the scheduled topic with its start and end dates
				    ScheduledTopic scheduledTopic = new ScheduledTopic(topic.getTopicName(), startDate, endDate);
				    scheduledTopics.add(scheduledTopic);
		
		    // Update the start date for the next topic
				    startDate = endDate;
				}
				
				
				//Displaying the List in the front end as a table
			    resp.setContentType("text/html");
		        PrintWriter out = resp.getWriter();

		        out.print("<table border='1' width='100%'");
		        out.print("<tr><th>Topic</th><th>Start date</th></tr>");
		        
		//Iterating through the Final list(no need of edit and delete:should be removed after integrating with the dates)
		        for (int i = 0; i < scheduledTopics.size(); i++) {
					
		            out.print("<tr><td>" + scheduledTopics.get(i) + "</td><td> " + scheduledTopics.get(i+1) + "</td></tr>");
		        }
		        out.print("</table>");

		        out.close();
				
		
		        
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	 
	}
 
 
 
 //Fetching data from database
 	private List<RetrieveTopic> retrieveTopicsFromDatabase(String course) {
	  
     Connection conn = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     List<RetrieveTopic> RTopics = new ArrayList<>();
     
     try {
         conn=DBUtil.getconnection();
         // Prepare the SQL statement for retrieving the topics
         String sql = "SELECT topic, duration FROM coursetopics WHERE course = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, course);

         // Execute the SQL statement
         rs = stmt.executeQuery();

         // Iterate over the result set and create Topic objects
         while (rs.next()) {
             String topicName = rs.getString("topic");
             System.out.println(topicName);
             int duration = rs.getInt("duration");
             System.out.println(duration);
             //creating an object of the class for holding the values got from the database on each iterations
             RetrieveTopic topic = new RetrieveTopic(topicName, duration);
             //Adding these objects into the arraylist of type Retrieved class
             RTopics.add(topic);
             
          
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

     return RTopics;
 
}

}
