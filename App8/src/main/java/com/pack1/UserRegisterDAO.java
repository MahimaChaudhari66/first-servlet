package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO 
{
	public int insertData(UserBean ub)
	{
		int rowCount=0;
		try
		{
		Connection con=  DBConnect.connect();
		PreparedStatement pstmt=con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
		pstmt.setString(1, ub.getUserName());
		pstmt.setString(2, ub.getPassword());
		pstmt.setString(3, ub.getFirstName());
		pstmt.setString(4, ub.getLastName());
		pstmt.setString(5, ub.getMailId());
		pstmt.setString(6, ub.getPhoneNo());
		
		rowCount=pstmt.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

}
