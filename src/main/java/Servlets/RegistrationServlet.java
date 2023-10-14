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

import Utility.DBUtil;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// TODO Auto-generated method stub
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upass=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		Connection con=null;
		try {
			
			//Connecting the database with external utility class
			   con = DBUtil.getconnection();
			    
				PreparedStatement ps=con.prepareStatement("insert into Registration(Uname,Uemail,Upass,Ucontact) values (?,?,?,?)");
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setString(4, umobile);
				
			int count=ps.executeUpdate();
			System.out.println(count);
			dispatcher=request.getRequestDispatcher("Registration.jsp");
			
			if(count>0) {
				request.setAttribute("Status","Success");
				dispatcher = request.getRequestDispatcher("SchedulerHome.jsp");
			}else {
				request.setAttribute("Status","Failed");
			}
			dispatcher.forward(request, response);
					
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//To print on the browser use printwriter
//		PrintWriter writer=response.getWriter();
//		writer.print(uname);
//		writer.print(uemail);
//		writer.print(upass);
//		writer.print(umobile);
	}

}
