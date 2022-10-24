//servlet which performs the addition of flights action into our database

package com.divyanshu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divyanshu.DatabaseConnection.MyDatabase;
import com.divyanshu.dao.InsertFlightIntoDatabaseDao;
import com.divyanshu.model.DateTimeSeparator;
import com.divyanshu.model.Flight;
//adding flights final page design
@WebServlet("/InsertFlightIntoDatabase")
public class InsertFlightIntoDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertFlightIntoDatabaseServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/NewFiletest.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch all the parameter which are submitted by the user in the form 
		String resultDate = null,resultTime=null;
		
		String flightId=request.getParameter("flightId");
		System.out.println("Hello"+flightId);
		
		String companyName=request.getParameter("companyName");
		System.out.println("Hello"+companyName);
		
		String sourceCity=request.getParameter("sourceCity");
		System.out.println("Hello"+sourceCity);
		
		String destinationCity=request.getParameter("destinationCity");
		System.out.println("Hello"+destinationCity);
		
		
		String departureTime=request.getParameter("departureTime");
		System.out.println("Hello"+departureTime);
		
		
		String arrivalTime=request.getParameter("arrivalTime");
		System.out.println("Hello"+arrivalTime);
		
		String offerStart =request.getParameter("offerStart");
		System.out.println("Hello"+offerStart);
		
		String offerEnd=request.getParameter("offerEnd");
		System.out.println("Hello"+offerEnd);
		
		String fare=request.getParameter("fare");
		System.out.println("Hello"+fare);
		
		String discount=request.getParameter("discount");
		System.out.println("Hello"+discount);
		
		
		
		DateTimeSeparator d=new DateTimeSeparator();

		InsertFlightIntoDatabaseDao flightDao=new InsertFlightIntoDatabaseDao();
		Flight f=new Flight();
		MyDatabase mydata = (MyDatabase) getServletContext().getAttribute("Database");  
        Connection con = mydata.getCon();  
        if (con != null) {  
            System.out.println("Database is connected");  
        } else {  
            System.out.println("Database is not connected");  
        }  
        
		//set the mandatory properties for flight
		String result[]=null;
		f.setFlightId(flightId);
		f.setCompanyName(companyName);
		f.setSourceCity(sourceCity);
		f.setDestinationCity(destinationCity);
		f.setCost(Double.parseDouble(fare));
		
		//change the result array
		result=d.DateTimeMySqlFormat(departureTime, resultDate, resultTime);
		f.setDepartureTime(result[1]);
		f.setDepartureDate(result[0]);
		
		//set the arrivalTime and date of the flight 
		result=d.DateTimeMySqlFormat(arrivalTime, resultDate, resultTime);
		
		f.setArrivalTime(result[1]);
		f.setArrivalDate(result[0]);
		f.setOfferEntered(false);
		
		
		
		//optional in terms of our application 
		
		if(offerStart!="" && offerEnd!="" && discount!="")
		{
			f.setOfferEntered(true);//set the offer entered true so that it is valid
			result=d.DateTimeMySqlFormat(offerStart, resultDate, resultTime);
			f.setOfferStartDate(result[0]);
			f.setOfferStartTime(result[1]);
			result=d.DateTimeMySqlFormat(offerEnd, resultDate, resultTime);
			f.setOfferEndTime(result[1]);
			f.setOfferEndDate(result[0]);
			f.setDiscount(Double.parseDouble(discount));
		}
		//save the value into the database 
		try {
			flightDao.registerFlight(f,con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//printing on the server side in order to check the values 
		System.out.println(companyName);
		System.out.println(sourceCity);
		System.out.println(destinationCity);
		System.out.println(fare);
		System.out.println(discount);
		System.out.println("Departure Time:"+departureTime.substring(17));
		System.out.println("Arrival Time:"+arrivalTime);
		
//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/display.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/NewFiletest.jsp");
		
		rd.forward(request, response);
		
	}
	
}
		
		
		
		
		
		
			
			
	    
	    
	    
		
		
		
		
