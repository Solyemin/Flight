package com.divyanshu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.divyanshu.model.Flight;

public class RetrieveFlightFromDatabaseDao
{ 
      
 
  public ArrayList<Flight> showFlightDestination(Flight f,Connection conn) throws SQLException
  { 
	    ArrayList<Flight> flightList=new ArrayList<>();
 
    
         //Final source and destination
         String sourceName=f.getSourceCity();
         System.out.println("The source city is : "+sourceName+"Just Checking");
         String sql2="SELECT * from FlightDetails2";

         PreparedStatement stmt = conn.prepareStatement(sql2); 
         ResultSet rs = stmt.executeQuery(); 
         // Extract data from result set 
        		 
         String flightId ,companyName ,sourceCity ,destinationCity ,arrivalTime  ,departureTime ;
         double fare; 
         Time t;
         while(rs.next()){ 
        	 //Retrieve by column name 
        	 System.out.print("-----Inside the result set----");
        	 flightId  = Integer.toString(rs.getInt("flightId")); 
        	 companyName = rs.getString("companyName"); 
        	 sourceCity=rs.getString("sourceCity");
        	 destinationCity = rs.getString("destinationCity"); 
        	 fare = rs.getDouble("fare"); 
        	 t=rs.getTime("arrivalTime");
        	 arrivalTime=t.toString();
        	 t=rs.getTime("departureTime");
        	 departureTime=t.toString();
        	 
        	 
        	 
        	 Flight flight=new Flight();
        	 flight.setFlightId(flightId);
        	 flight.setSourceCity(sourceCity);
        	 flight.setDestinationCity(destinationCity);
        	 flight.setCompanyName(companyName);
        	 flight.setArrivalTime(arrivalTime);
        	 flight.setDepartureTime(departureTime);
        	 flight.setCost(fare);
        	 
        	 flightList.add(flight);
        	 // Clean-up environment 
        	
        	 
         }
         rs.close(); 
    	 stmt.close(); 
         
         return flightList;
  } 
} 
         


         
         
         
         
        
        

         
         
         
         
         
        
         
         
         
         


        	 
        	 
         
         
 
 
 
