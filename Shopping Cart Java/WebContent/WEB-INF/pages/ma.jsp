<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="daksh" tagdir="/WEB-INF/tags/" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Account</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Modify Account</h2>

<div class="header"><jsp:include page="/WEB-INF/snippets/header.jsp"/></div>
<table class="center">
	<tr><td colspan=2><daksh:mytag>${param.msg }</daksh:mytag>
	<tr><td colspan=2><h2>Login Form</h2></td></tr>
	</table>
<div class="modifyaccount"><jsp:include page="/WEB-INF/snippets/modifyacc.jsp"/></div>
<div class="footer"><jsp:include page="/WEB-INF/snippets/footer.jsp"/></div>

</body>
</html>