package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO 
{
	public UserBean CheckLogin(String uname,String upwd)
	{
		UserBean ub=null;
		try
		{
			Connection con=DBConnect.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from registration where username=? and password=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
				ub=new UserBean();
				ub.setUserName(rs.getString(1));
				ub.setPassword(rs.getString(2));
				ub.setFirstName(rs.getString(3));
				ub.setLastName(rs.getString(4));
				ub.setMailId(rs.getString(5));
				ub.setPhoneNo(rs.getString(6));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}

}
