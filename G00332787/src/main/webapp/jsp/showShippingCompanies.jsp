<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Shipping Company</title>
</head>
<body>
	<h1>Shipping List</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
		</tr>
		<c:forEach items="${shippingCompanies}" var="shippingCompany">
			<tr> 
		    	<td>${shippingCompany.name}</td>
		    	<td>${shippingCompany.homePort}</td>
		    	<td>${shippingCompany.balance}</td>
		    	<td>${shippingCompany.ships}</td>
	   		</tr>
		</c:forEach>
	</table>
</body>
</html>