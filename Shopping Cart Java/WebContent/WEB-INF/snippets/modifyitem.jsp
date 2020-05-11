<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>
     

<center>
<daksh:mytag>${param.msg}</daksh:mytag>
<h3 style='color:red;'>${msg}</h3>
<form method=post  style='font-family:verdana;'>
Item Name: <input type=text name=iname><br>
Item Quantity : <input type=text name=iqty><br>
<br>
<input type=submit value=Modify Account style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>
<hr>
<br><br><a href=Home style='background-color:#4CAF50; border: none; color: white;padding: 15px 32px;text-align: center;text-decoration: none;  display: inline-block;font-size: 16px;'>Back to Home Page</a>

</form>
</center>