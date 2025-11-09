package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserRegisterServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		UserBean bean= new UserBean();
		bean.setUserName(req.getParameter("uname"));
		bean.setPassword(req.getParameter("upwd"));
		bean.setFirstName(req.getParameter("ufname"));
		bean.setLastName(req.getParameter("ulname"));
		bean.setMailId(req.getParameter("umail"));
		bean.setPhoneNo(req.getParameter("uphone"));
		
		int rowCount= new UserRegisterDAO().insertData(bean);
		if(rowCount==0)
		{
			req.setAttribute("msg", "Data Not Inserted");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Record inserted in the database");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
	}

}
