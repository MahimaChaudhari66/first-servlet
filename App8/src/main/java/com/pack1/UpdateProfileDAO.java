package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO 
{
	public int updateData(UserBean ub)
	{
		int rowCount=0;
		try
		{
			Connection con= DBConnect.connect();
			PreparedStatement pstmt = con.prepareStatement("update registration set firstname=?,lastname=?,mailid=?,phone=? where username=?");
			pstmt.setString(1, ub.getFirstName());
			pstmt.setString(2, ub.getLastName());
			pstmt.setString(3, ub.getMailId());
			pstmt.setString(4, ub.getPhoneNo());
			pstmt.setString(5, ub.getUserName());
			rowCount= pstmt.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

}
