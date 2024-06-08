<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant List</title>
</head>
<body>
    <h1>Restaurant List</h1>
    <table border="1">
        <tr>
            <th>Restaurant ID</th>
            <th>Name</th>
           <th>Address</th>
        </tr>
        <c:forEach items="${restaurants}" var="restaurant">
            <tr>
                <td>${restaurant.restaurantId}</td>
                <td>${restaurant.name}</td>
                <td>${restaurant.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
