<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddContact</title>
</head>
<body>
<form:form action="savecontact" modelAttribute="contact">
Name: <form:input path="name"/>
MobileNumber: <form:input path="phonenum"/>
<input type="submit">

</form:form>

</body>
</html>