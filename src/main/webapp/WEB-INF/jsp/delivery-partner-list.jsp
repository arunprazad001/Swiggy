<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delivery Partner List</title>
</head>
<body>
    <h1>Delivery Partner List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone Number</th>
            <!-- Add more columns as needed -->
        </tr>
        <c:forEach items="${deliveryPartners}" var="deliveryPartner">
            <tr>
                <td>${deliveryPartner.deliveryPartnerId}</td>
                <td>${deliveryPartner.name}</td>
                <td>${deliveryPartner.phoneNumber}</td>
                <!-- Add more columns as needed -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
