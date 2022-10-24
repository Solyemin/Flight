// admin login servlet
package com.divyanshu.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divyanshu.DatabaseConnection.MyDatabase;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
//		Connection conn=null;
   
		MyDatabase mydata = (MyDatabase) getServletContext().getAttribute("DatabaseSSLFalse");  
        Connection conn = mydata.getCon();  
        if (conn != null) {  
            System.out.println("Database is connected");  
        } else {  
            System.out.println("Database is not connected");  
        }  
		
//	    final String DB_URL="jdbc:mysql://localhost:3306/FlightSystem?useSSL=false";
//	    //  Database credentials 
//	    final String USER = "root"; 
//	    final String PASS = "9406";
	try{ 
	         // Register JDBC driver 
//	         Class.forName("com.mysql.jdbc.Driver"); 
	 
	         // Open a connection 
//	         conn = DriverManager.getConnection(DB_URL, USER, PASS); 
	         String sql="select * from admin where uname=? and upwd=?";
	         
	         PreparedStatement pst=conn.prepareStatement(sql);
	         
	         pst.setString(1, uname);
	         pst.setString(2, password);
             
	         ResultSet rs=pst.executeQuery();
	         if(rs.next())
	         {
	        	 //sets the adminusername for the particular session in our browser
	        	session.setAttribute("admin_name",rs.getString("uname"));
//	        	dispatcher =request.getRequestDispatcher("index.jsp");
	        	dispatcher =request.getRequestDispatcher("/WEB-INF/views/NewFiletest.jsp");
	         } 
	         else
	         {
	        	 request.setAttribute("status", "failed");
	        	 dispatcher =request.getRequestDispatcher("adminLogin.jsp");
	         }
	         dispatcher.forward(request,response);
	         
	         
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
	
	
	

