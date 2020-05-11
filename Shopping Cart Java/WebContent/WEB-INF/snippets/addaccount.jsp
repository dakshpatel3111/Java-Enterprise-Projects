<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>
    
<center>
<daksh:mytag>${param.msg}</daksh:mytag>
<h1 style='font-family:verdana;'>Create Your Account</h1>
<div style='color:blue;font-size:20px;font-family:verdana;'>
<form method=post style='font-family:verdana'>
Name : <input type=text name=Name><br>
Username: <input type=text name=cname><br>
Password : <input type=password name=cpass><br>
Confirm Password :<input type=password name=cpass2><br>
<br>
<input type=submit value=CreateAccount style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>
<hr>
<br><br><a href=Login style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>Back to Login Page</a>
</div>