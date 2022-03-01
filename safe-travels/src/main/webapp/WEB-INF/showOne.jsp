<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<h1>Expense Details</h1>
	<ul>
		<li>Expense Name: ${expense.name }</li>
		<li>Expense Description: ${expense.description }</li>
		<li>Vendor: ${expense.vendor }</li>
		<li>Amount Spent: $${expense.amount }</li>
		
	</ul>
	<a href="/expenses">Main Page</a>
</body>
</html>