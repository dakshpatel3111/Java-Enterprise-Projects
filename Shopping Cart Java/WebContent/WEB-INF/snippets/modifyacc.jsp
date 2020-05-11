<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>

<daksh:mytag>${param.msg}</daksh:mytag>
<center>
<form method=post>
Name : <input type=text name=Name><br>
UserName should be same: <input type=text name=iname><br>
Password : <input type=password name=cpass><br>
Confirm Password :<input type=password name=cpass2><br>
<br>
<br>
<input type=submit value=Modify style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>
<br>
<br><br><a href=Home style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>Back to Home Page</a>
</form>
</center>