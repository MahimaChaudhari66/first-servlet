package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	Cookie[] arr = req.getCookies();
    	String fname= null;
    	
    	if(arr==null)
    	{
    		req.setAttribute("msg", "Session Expired");
    		req.getRequestDispatcher("Register.jsp").forward(req, resp);
    	}
    	else
    	{
    		for(Cookie c:arr)
    		{
    			if("ck1".equals(c.getName()))
    			{
    				fname=c.getValue();
    			}
    		}
    		req.setAttribute("fname",fname);
    		req.getRequestDispatcher("EditProfile.jsp").forward(req, resp);
    	}
    }
}
