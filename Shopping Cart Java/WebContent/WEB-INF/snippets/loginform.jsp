<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>
<form method=post>
<table class="center">
	<tr><td colspan=2><daksh:mytag>${param.msg }</daksh:mytag>
	<tr><td colspan=2><h2>Login Form</h2></td></tr>
	<tr>
		<td align=left>Name: </td>
		<td><input type=text name=lname></td>
	</tr>
	<tr>
		<td align=left>Password: </td>
		<td><input type=password name=lpass></td>
	</tr>
	<tr><td colspan=2><input type=submit value=Login></td></tr>
	<tr><td><a href=Addaccount>Add Account </a></td></tr>
</table>
</form>