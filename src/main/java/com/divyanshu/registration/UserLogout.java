package com.divyanshu.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I will log out-----------");
		HttpSession session=request.getSession();
		System.out.println("Current user name:");
		System.out.println(session.getAttribute("name"));
		
	    System.out.println("Current user name after invalidation:");
		System.out.println(session.getAttribute("name"));
		session.setAttribute("userLogout", "true");
//		RequestDispatcher rd=request.getRequestDispatcher("test.html");
		RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
