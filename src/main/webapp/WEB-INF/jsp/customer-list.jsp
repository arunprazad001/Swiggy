<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
</head>
<body>
    <h1>Customer List</h1>
    <table border="1">
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
