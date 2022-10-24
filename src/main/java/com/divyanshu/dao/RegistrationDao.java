package com.divyanshu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.divyanshu.model.User;

public class RegistrationDao {
	
	private Connection conn;
	public RegistrationDao(Connection conn)
	{
		this.conn=conn;
	}

	public int registerUser(User user) throws SQLException
	{
		String userName=user.getUserName();
		String password=user.getPassword();
		String email=user.getEmail();
		String contactNumber=user.getContactNumber();
		int rowCount=0;
 
		String sql="Insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1, userName);
		pst.setString(2, password);
		pst.setString(3, email);
		pst.setString(4, contactNumber);
		
		rowCount=pst.executeUpdate();
	         
		return rowCount;
			
			
		
	}
		
	
}
