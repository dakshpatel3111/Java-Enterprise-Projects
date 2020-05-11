<%@ page import="testpack.Item,java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>
     <%@taglib prefix="napster" uri="http://Daksh.com/java3/a4" %>
 <napster:Greetings>Hello ${name} , You are going to have nice day </napster:Greetings>
<table class="center" width="70%">
	<tr>
		<td align=left>Welcome: ${name}</td>
		
		<td align=right>
			<a href="ModifyAccount">Edit Account</a> 
			||<a href="Logout">LogOut</a>
			||<a href="Additem">Add Item</a>
			
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<h2>List of Items</h2>
			
			<table class="center">
				<tr><th>Actions</th><th>Item Name</th><th>Quantity</th></tr>
				
					<c:forEach var="item" items="${allItems}">
							<tr>
								<td>
									<a href="ViewItem?id=${item.getId()}">View</a> 
									<a href="EditItem?id=${item.getId()}">Edit</a> 
									<a href="DeleteItem?id=${item.getId()}">Delete</a>
								</td>
								<td>${item.name}</td>
								<td>${item.qty}</td>
							</tr>
							</c:forEach>	
					
			</table>
			
			
		</td>
	</tr>
</table>