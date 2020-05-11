<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.ArrayList" %>
    
   
<h1>Here is Your Order ${user.name} and Recepit</h1>
<hr>
<div class="flex-container">
<div class="flex-box">
<h2> Online Pizza Ordering Company</h2>
<h3> Call our customer service for any questions</h3>
<c:forEach var="pizza" items="${pizzas}">
							     
							    <table>
							    
								<tr><th>Size :</th> <td>${pizza.getSize()}</td></tr>
								<br>
								<tr><th>Price :</th><td>${pizza.getPrice()}</td></tr>
								<br>
								<tr><th>Topppings:</th><td>${pizza.getToppings()}</td></tr>
								<br>
								<tr><th>Date:</th><td>${pizza.getSqldate()}</td></tr>
								<tr><th>Pickup/Delivery Time :</th><td>${pizza.getSqltime()}</td></tr>
								
								</table>
							</c:forEach> 	
</div>
<hr>
<div class="flex-box">
<img src="piz.jpg" class="imagebox">
</div>
</div>
<form method="get" action='OrderPage'> 
<input type='submit' value='Add Another Pizza' class="button">

</form>
<br>






