package com.divyanshu.registration;
//user registration servlet
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divyanshu.DatabaseConnection.MyDatabase;
import com.divyanshu.dao.RegistrationDao;
import com.divyanshu.model.User;

@WebServlet("/RegisterPage")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		
		User user=new User();
		user.setUserName(uname);
		user.setPassword(upwd);
		user.setEmail(uemail);
		user.setContactNumber(umobile);
		
		
		MyDatabase mydata = (MyDatabase) getServletContext().getAttribute("DatabaseSSLFalse");  
        Connection con = mydata.getCon();  
        if (con != null) {  
            System.out.println("Database is connected");  
        } else {  
            System.out.println("Database is not connected");  
        }  
		
        RegistrationDao r=new RegistrationDao(con);
        
        
		int rowCount=0;
		
		try {
			rowCount = r.registerUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
		if(rowCount>0) {
			request.setAttribute("status", "success");
			
		}
		else
		{
			request.setAttribute("status", "failed");
		}
		rd.forward(request, response);
		
	}
  
}


