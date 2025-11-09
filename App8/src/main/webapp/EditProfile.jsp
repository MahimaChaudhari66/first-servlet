<%@page import="com.pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <center>
           <h1>
           <%
           UserBean ub = (UserBean)application.getAttribute("UserBean");
           String fn = (String)request.getAttribute("fname");
           out.println("This session belongs to "+fn+" <br><br>");
           
           %>
           
           <form action="update" method="post">
                FirstName <input type="text" name="f_name" value="<%= ub.getFirstName() %>"><br><br>
                LastName <input type="text" name="l_name" value="<%= ub.getLastName() %>"><br><br>
                MailId <input type="text" name="mail_id" value="<%= ub.getMailId() %>"><br><br>
                Phone <input type="text" name="phn_no" value="<%= ub.getPhoneNo() %>"><br><br>
                <input type="submit" value="Update"> 
           </form>
           
           </h1>
</body>
</html>