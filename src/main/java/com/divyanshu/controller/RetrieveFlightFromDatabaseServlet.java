//servlet which performs the flight search functionality

package com.divyanshu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divyanshu.DatabaseConnection.MyDatabase;
import com.divyanshu.dao.FlightDao2Final;
import com.divyanshu.dao.RetrieveFlightFromDatabaseDao;
import com.divyanshu.model.Flight;
import com.divyanshu.model.PrepareResultDikhstras;


@WebServlet("/RetrieveFlightFromDatabase")
public class RetrieveFlightFromDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RetrieveFlightFromDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/NewFile1.jsp");
		rd.forward(request, response);//forward the request and response
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//we need to call the dao to fetch the flights from the server now .
		
		String sourceName=request.getParameter("sourceName");
		String destinationCity=request.getParameter("destinationCity");
		System.out.println(sourceName);
		System.out.print(destinationCity);
		
		//set the source and the destination names
		request.setAttribute("sourceName",sourceName);
		request.setAttribute("destinationCity", destinationCity);
		
		
		MyDatabase mydata = (MyDatabase) getServletContext().getAttribute("Database");  
        Connection con = mydata.getCon();  
        if (con != null) {  
            System.out.println("Database is connected");  
        } else {  
            System.out.println("Database is not connected");  
        }  
		
		
//		FlightDao2Final flightDao2=new FlightDao2Final();
        RetrieveFlightFromDatabaseDao flightDao2=new RetrieveFlightFromDatabaseDao();
		Flight f=new Flight();
		
		f.setSourceCity(sourceName);//setting the sourceCity name for a flight 
	    f.setDestinationCity(destinationCity);//setting the destination for the flight
	    
	   
		//call the DAO to get the destination details for the flight and the price 
	    System.out.println("Okay till here ---");
		ArrayList<Flight> flightList=null;
		try {
			flightList = flightDao2.showFlightDestination(f,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//the final list to be sent to dikshtra's
		PrepareResultDikhstras p=new PrepareResultDikhstras();
		ArrayList<Flight> resultList=p.solve(flightList,sourceName,destinationCity);
		//printing the resultlist
		
		System.out.println("Inside getfinalflights\n----------");
		if(resultList!=null)
		{
			for(Flight fl:resultList)
			{
			  System.out.println(fl.getFlightId());
			  System.out.println(fl.getSourceCity());
			  System.out.println(fl.getDestinationCity());
			  System.out.println(fl.getCost());
			  System.out.println(fl.getCompanyName());
			}	
		}
		else
		{
			System.out.println("No Paths is there !!");
		}
		
		request.setAttribute("FlightList", resultList);
//		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/showFlights.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("showFlights.jsp");
		rd.forward(request, response);
	}
		
}
		

