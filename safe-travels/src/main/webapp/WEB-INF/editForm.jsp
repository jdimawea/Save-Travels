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
	<h1>Edit Expense</h1>
	<form:form action="/expenses/edit/${expense.id }" method="POST"
		modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:input path="vendor" />
			<form:errors path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount:</form:label>
			<form:input type="number" step="0.01" path="amount" />
			<form:errors path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:textarea path="description"></form:textarea>
		</p>
		<button>Submit</button>
		<a href="/expenses">Go back</a>
	</form:form>
</body>
</html>