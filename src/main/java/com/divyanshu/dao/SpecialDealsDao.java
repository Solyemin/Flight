package com.divyanshu.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;



public class SpecialDealsDao {
	
	Connection connection;
	public SpecialDealsDao(Connection conn)
	{
		this.connection=conn;
	}
	public ResultSet getOfferList()
	{
		
		ResultSet resultSet = null;
		try{ 
//			Connection connection = null;
//			Statement statement = null;
			
//			statement=connection.createStatement();
			//String sql ="SELECT * FROM offers2";

			
			//String sql2="select * from offers2 where expiryDate>=?";
			
		   String sql2="select * from flightdetails2 where discount is not NULL and ((offerEndDate>? and offerStartDate<?) or (offerStartDate=? and offerEndDate>=? and offerStartTime<=? and offerEndTime>?))";
           PreparedStatement stmt = connection.prepareStatement(sql2);
           //stmt.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           stmt.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           stmt.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           stmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           stmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           stmt.setString(5, new SimpleDateFormat("HH:mm:ss").format(new Date()));
           stmt.setString(6, new SimpleDateFormat("HH:mm:ss").format(new Date()));
           // Extract data from result set 
           
           System.out.println(stmt.toString());
           System.out.println("Before the stmt");
		   resultSet = stmt.executeQuery();
		   System.out.println(resultSet.toString());
		   System.out.println("After the stmt---");
		
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return resultSet;
             
     }
}
             
             
             
				
              
		
	
	


