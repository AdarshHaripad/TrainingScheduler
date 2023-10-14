package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utility.DBUtil;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String Uemail = request.getParameter("username");
	        String Upas = request.getParameter("password");
	        
	        HttpSession session = request.getSession();
	        RequestDispatcher dispatcher = null;

	        try {
	       
	        	//Connecting the database with external utility class
	            Connection con = DBUtil.getconnection();
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM Registration WHERE Uemail = ? AND Upass = ?");
	            ps.setString(1, Uemail);
	            ps.setString(2, Upas);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                String uname = rs.getString("Uname");
	                System.out.println("Login successful. Username: " + uname);
	                session.setAttribute("name", uname);
	                dispatcher = request.getRequestDispatcher("Home.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                System.out.println("Login failed. Invalid credentials.");
	                request.setAttribute("Status", "failed");
	                dispatcher = request.getRequestDispatcher("Login.jsp");
	                dispatcher.forward(request, response);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
