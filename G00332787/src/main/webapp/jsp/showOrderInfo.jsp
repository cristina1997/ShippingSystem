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
<title>Show Order Info</title>
</head>
<body>
	<h1>Show Orders</h1>
	<table>
		<tr>
			<th>Order Number</th>
			<th>Shipping Company Name</th>
			<th>Ship Name</th>
			<th>Order Date</th>
		</tr>
		<c:forEach items="${orderInfos}" var="orderInfo">
			<tr> 
		    	<td>${orderInfo.oid}</td>
		    	<td>${orderInfo.shippingCompany.name}</td>
		    	<td>${orderInfo.ship.name}</td>
		    	<td>${orderInfo.date}</td>
	   		</tr>
		</c:forEach>
	</table>
</body>
</html>