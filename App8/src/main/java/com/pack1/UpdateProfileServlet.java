package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Cookie[] arr = req.getCookies();
		String fname=null;
		if(arr==null)
		{
			req.setAttribute("msg", "Session Expired!!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext context = req.getServletContext();
			UserBean ub = (UserBean)context.getAttribute("UserBean");
			
			ub.setFirstName(req.getParameter("f_name"));
			ub.setLastName(req.getParameter("l_name"));
			ub.setMailId(req.getParameter("mail_id"));
			ub.setPhoneNo(req.getParameter("phn_no"));
			int rowCount=new UpdateProfileDAO().updateData(ub);
			
			if(rowCount>0)
			{
				req.setAttribute("msg", "Profile Updated");
				for(Cookie c:arr)
				{
					if("ck1".equals(c.getName()))
					{
						fname=c.getValue();
					}
				}
				req.setAttribute("fname", fname);
				req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			}
			else
			{
				throw new RuntimeException("Technical Error!!!"); 
			}
		}
	}

}
