<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Shipping List</title>
</head>
<body>
	<h1>Add Person</h1>
	
		<form:form modelAttribute="ship">
 		<table>
			<tr>
				<td>Ship Name </td>
				<td><form:input path="name"></form:input></td>
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td>Passengers </td>
				<td><form:input path="passengers"></form:input></td>
				<td><form:errors path="passengers"></form:errors></td>
			</tr>	
			<tr>
				<td>Cost </td>
				<td><form:input path="cost"></form:input></td>
				<td><form:errors path="cost"></form:errors></td>
			</tr>
			<tr>	
				<td>Meters </td>
				<td><form:input path="metres"></form:input></td>
				<td><form:errors path="metres"></form:errors></td>
			</tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
		</table> 
	</form:form>
    <a href="/">Home</a>
</body>
</html>