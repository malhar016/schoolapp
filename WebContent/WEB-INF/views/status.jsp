<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Rest API</title>
</head>
<body>
<h1>
	REST API Demo
</h1>
<form:form method="POST" action="/tutorial/rest/addGroup">
<input type="submit" value="Add User">
<P>  Request Time ${serverTime}. </P>
</form:form>
</body>
</html>
