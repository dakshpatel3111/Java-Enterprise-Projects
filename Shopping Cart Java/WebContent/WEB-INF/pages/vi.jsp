<%@ page import="testpack.Item,java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Items</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="header"><jsp:include page="/WEB-INF/snippets/header.jsp"/></div>

<div class="content"><jsp:include page="/WEB-INF/snippets/ViewItem.jsp"/></div>

<div class="footer"><jsp:include page="/WEB-INF/snippets/footer.jsp"/></div>

</body>
</html>