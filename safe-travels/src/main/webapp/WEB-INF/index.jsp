<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash Board</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td colspan="2">Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses }">
				<tr>
					<td><a href="/expenses/${expense.id}">${expense.name }</a></td>
					<td>${expense.vendor }</td>
					<td>$${expense.amount }</td>
					<td><a href="/expenses/edit/${expense.id }">Edit</a></td>
					<td>
						<form action="/expenses/delete/${expense.id }" method="post">
							<input type="hidden" name="_method" value="delete">
							<button>Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h1>Add an expense:</h1>
	<form:form action="/expenses" method="POST" modelAttribute="expense">
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
			<form:label path="description">Description:</form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description" />
		</p>
		<button>Submit</button>
	</form:form>
</body>
</html>