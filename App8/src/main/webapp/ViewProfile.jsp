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
           
           String pwd=ub.getPassword();
           String confpwd= pwd.substring(0, 1)+"*****"+pwd.substring(pwd.length()-1);
           
           out.println(ub.getUserName()+" "+confpwd+" "+ub.getFirstName()+" "+ub.getLastName()+" "+ub.getMailId()+" "+ub.getPhoneNo()+"<br><br>");
           %>
           <a href="edit">Edit Profile</a><br><br>
           <a href="logout">LogOut</a><br><br>
           </h1>
</body>
</html>