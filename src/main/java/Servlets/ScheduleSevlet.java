package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleSevlet
 */
@WebServlet("/ScheduleSevlet")
public class ScheduleSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String course =request.getParameter("course");
		System.out.println(course);
		int duration = Integer.parseInt(request.getParameter("duration"));
		String batchType=request.getParameter("batchType");
		int hoursPerDay=Integer.parseInt(request.getParameter("hoursPerDay"));
		String startDateStr=request.getParameter("startDate");
		
		
		//calculate the end date and daywise schedule
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
	
		
				try {
					startDate = sdf.parse(startDateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		Calendar calender=Calendar.getInstance();
		calender.setTime(startDate);
		int remainingDuration =duration;
		int totalDays = 0;
		StringBuilder schedule = new StringBuilder();
		
		while(remainingDuration > 0) {
			if(batchType.equals("weekday") && isWeekday(calender.get(Calendar.DAY_OF_WEEK))){
				remainingDuration -=hoursPerDay;
				schedule.append(sdf.format(calender.getTime())).append("<br>");
				totalDays++;
			}if(batchType.equals("weekend") && isWeekend(calender.get(Calendar.DAY_OF_WEEK))) {
				remainingDuration -=hoursPerDay;
				schedule.append(sdf.format(calender.getTime())).append("<br>");
				totalDays++;
			}
			calender.add(Calendar.DAY_OF_MONTH, 1);
		}
		calender.add(Calendar.DAY_OF_MONTH, -1);
		Date endDate = calender.getTime();
		String endDateStr=sdf.format(endDate);
		
		  	request.setAttribute("course", course);
	        request.setAttribute("duration", duration);
	        request.setAttribute("batchType", batchType);
	        request.setAttribute("hoursPerDay", hoursPerDay);
	        request.setAttribute("startDateStr", startDateStr);
	        request.setAttribute("endDateStr", endDateStr);
	        request.setAttribute("totalDays", totalDays);
	        request.setAttribute("schedule", schedule.toString());
	        
	        request.getRequestDispatcher("schedule.jsp").forward(request, response);


	}
	

		 // Helper method to check if given day of the week is a weekday (Monday to Friday) --%>
        
      private  boolean isWeekday(int dayOfWeek) {
            return dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY;
        }
       
        
        // Helper method to check if given day of the week is a weekend (Saturday or Sunday) --%>
        
      private  boolean isWeekend(int dayOfWeek) {
            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
        }
      
	
}